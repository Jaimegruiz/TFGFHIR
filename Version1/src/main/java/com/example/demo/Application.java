package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * En esta clase se encuentra el main, SpringApplication se encarga automaticamente de todos los preparativos
 * necesarios para ejecutar una aplicación Spring. He seguido este tutorial de <a href="https://spring.io/guides/gs/rest-service/">la página oficial</a>
 * @author jaimegonzalezruiz
 *
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
