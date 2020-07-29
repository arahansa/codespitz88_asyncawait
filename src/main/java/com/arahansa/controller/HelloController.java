package com.arahansa.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    static class Hello{
        private String name;
        private String message;

        public Hello(String name, String message) {
            this.name = name;
            this.message = message;
        }
        public String getName() {
            return name;
        }
        public String getMessage() {
            return message;
        }
    }

    @GetMapping("/page")
    public Page<Hello> hello(Pageable pageable){
        int page = pageable.getPageNumber();
        int size = pageable.getPageSize();
        List<Hello> helloList = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            int num = (size*page)+i;
            helloList.add(new Hello("네임"+num, "메시지 "+num));
        }
        return new PageImpl(helloList, pageable, 200);
    }

}
