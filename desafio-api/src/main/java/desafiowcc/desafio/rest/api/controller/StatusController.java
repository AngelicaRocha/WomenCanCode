package desafiowcc.desafio.rest.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value = "/api/status")
public class StatusController {

    @GetMapping
    public String check () {
        return "Online";
    }
}
