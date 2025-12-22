package br.com.alura.dojoplaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class DojoPlacesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DojoPlacesApplication.class, args);
    }
}
