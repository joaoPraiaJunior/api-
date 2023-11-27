package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")

public class HelloWorldController {
    @GetMapping
    public String hello() {
        return "<h1>Hello World!</h1><br><h2>MedVoll API</h2>";
    }
}
