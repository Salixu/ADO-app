/*
 * Copyright 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bartosz.ado.controllers;

import com.bartosz.ado.exceptions.FileUploadExceptionAdvice;
import com.bartosz.ado.models.Image;
import com.bartosz.ado.services.ImageDbService;
import com.bartosz.ado.services.UserService;
import com.bartosz.ado.services.googleTranslate;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature.Type;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


import com.google.common.primitives.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/description")

public class VisionController {

  private final ImageDbService imageDbService;
  private final UserService userService;

  @Autowired
  private FileUploadExceptionAdvice exceptionAdvice;

  @Autowired
  private CloudVisionTemplate cloudVisionTemplate;
  private googleTranslate googleTranslate = new googleTranslate();


  public VisionController(
          ImageDbService imageDbService,
          UserService userService){
    this.imageDbService = imageDbService;
    this.userService = userService;
  }
  @PostMapping("/extractLabels")
  public Map<String, String> extractLabels(@RequestParam("File") MultipartFile descriptionRequest, @RequestParam("user_id") int user_id) {
    try {
      Map<String, String> responseLabels;

      AnnotateImageResponse response =
              this.cloudVisionTemplate.analyzeImage(
                      descriptionRequest.getResource(), Type.LABEL_DETECTION);

      Map<String, Float> imageLabels =
              response
                      .getLabelAnnotationsList()
                      .stream()
                      .collect(
                              Collectors.toMap(
                                      EntityAnnotation::getDescription,
                                      EntityAnnotation::getScore,
                                      (u, v) -> {
                                        throw new IllegalStateException(String.format("Duplicate key %s", u));
                                      },
                                      LinkedHashMap::new));

      responseLabels = googleTranslate.doTranslation(imageLabels);

      insertImageAndDescription(
              user_id,
              responseLabels,
              descriptionRequest.getBytes(),
              descriptionRequest.getResource().getFilename()
      );

      return responseLabels;
    } catch (MaxUploadSizeExceededException | IOException exc) {
      this.exceptionAdvice.handleMaxSizeException((MaxUploadSizeExceededException) exc);
    }
    Map<String, String> responseLabels = null;
    return responseLabels;
  }

  private void insertImageAndDescription(int id, Map<String, String> description, byte[] image, String fileName){
      this.imageDbService.insertImage(new Image(this.userService.findById(id), fileName, image,description.toString()));
  }

}

