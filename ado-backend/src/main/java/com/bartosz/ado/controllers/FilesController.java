//package com.bartosz.ado.controllers;
//
//import com.bartosz.ado.models.Product;
//import com.bartosz.ado.payloads.Responses.MessageResponse;
//import com.bartosz.ado.models.FileInfo;
//import com.bartosz.ado.repositories.FilesStorageService;
//import com.bartosz.ado.services.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Controller
//@CrossOrigin(origins =  "http://localhost:4200")
//@RequestMapping("/upload")
//public class FilesController {
//    @Autowired
//    FilesStorageService filesStorageService;
//
//    @Autowired
//    ProductService productService;
//
//    @PostMapping("/upload")
//    public ResponseEntity<MessageResponse> uploadFile(@RequestParam("File")MultipartFile file){
//        String message = "";
//        try{
//            filesStorageService.save(file);
//            message = "Plik przesłano z sukcesem: " + file.getOriginalFilename();
//            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
//        } catch (Exception e){
//            message = "Nie można przesłać pliku: " + file.getOriginalFilename();
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
//        }
//    }
//
//
//    @PostMapping("/upload-product")
//    public ResponseEntity<MessageResponse> uploadProduct(@RequestParam("File")MultipartFile file,
//                                                         @RequestParam("Name")String name,
//                                                         @RequestParam("Price")String price) throws IOException {
//        Product product = new Product();
//        product.setPrice(price);
//        product.setName(name);
//        product.setImage(file.getBytes());
//        this.productService.InsertProduct(product);
//        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Plik przesłano z sukcesem: "));
//
//    }
//
//    @GetMapping("/get-products")
//    public ResponseEntity<MessageResponse> getProducts() {
//        List<Product> products = new ArrayList<>();
//        products = this.productService.SelectAllImages();
//        Map<String, Object> response = new HashMap<>();
//        response.put("products", products);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//    @GetMapping("/files")
//    public ResponseEntity<List<FileInfo>> getListFiles(){
//        List<FileInfo> fileInfos = filesStorageService.loadAll().map(path -> {
//            String filename = path.getFileName().toString();
//            String url = MvcUriComponentsBuilder
//                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
//            return new FileInfo(filename, url);
//        }).collect(Collectors.toList());
//        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
//    }
//
//    @GetMapping("/files/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> getFile(@PathVariable String filename){
//        Resource file = filesStorageService.load(filename);
//        return ResponseEntity
//                .ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//    }
//}
//
