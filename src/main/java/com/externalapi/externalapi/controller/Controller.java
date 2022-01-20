package com.externalapi.externalapi.controller;

import com.externalapi.externalapi.Models.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/externalapi")
public class Controller {

    @GetMapping
    public List<Todo> todo() {

        List<String> list = Arrays.asList("61d49225f0a00d1c380d9bdc","61d4947638055f100cdefb7e");

        // return list.stream().map(t -> {
        //     return restTemplate.getForObject("http://localhost:8080/v1/todo/" + t , Todo.class);
        // }).collect(Collectors.toList());
            
        return metodoRestTemplate(list);
        
        // return Stream.of(Arrays.asList("61d49225f0a00d1c380d9bdc","61d4947638055f100cdefb7e"))
        //     .map(t -> restTemplate.getForObject("http://localhost:8080/v1/todo/" + t , Todo.class))
        //     .collect(Collectors.toList());
    }

    public List<Todo> metodoRestTemplate(List<String> s){
        List<Todo> a = new ArrayList<>();
        for (String aux : s) {
          a.add((new RestTemplate().getForObject("http://localhost:8080/v1/todo/" + aux , Todo.class))); 
        }
       return a;
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
       return new RestTemplate().postForObject("http://localhost:8080/v1/todo/", todo, Todo.class);
    }

}