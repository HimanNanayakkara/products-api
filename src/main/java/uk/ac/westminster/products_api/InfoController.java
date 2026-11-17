package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class InfoController {
    @GetMapping("/info")
    public String getInfo() {return "This is an springboot app with 4 classes for now";}
}
