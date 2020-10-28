
package main;

import com.bartosz.ado.service.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

/** Entry point to running the Spring Boot application. */
@SpringBootApplication
@ComponentScan(basePackages= {"com.bartosz.ado"})
public class Application implements CommandLineRunner {

  @Resource
  FilesStorageService storageService;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    storageService.deleteAll();
    storageService.init();
  }
}
