
package com.bartosz.ado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


/** Entry point to running the Spring Boot application. */

@SpringBootApplication
@EntityScan(basePackages = {"com.bartosz.ado"})
public class Application  {


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
