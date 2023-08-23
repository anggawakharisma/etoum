package com.tabeldata.etoum.controller;

import com.tabeldata.etoum.dto.Example;
import com.tabeldata.etoum.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/example")
public class ExampleController {

    private final ExampleService service;

    @GetMapping
    public ResponseEntity<String> hello(Principal principal){

//        JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
//        String userName = (String) token.getTokenAttributes().get("preferred_username");
//        String userEmail = (String) token.getTokenAttributes().get("email");
//
//        System.out.println("username : " + userName);

        return ResponseEntity.ok("welcome home!");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Example>> list(){
        List<Example> list = this.service.findAll();
        return ResponseEntity.ok(list);
    }

}
