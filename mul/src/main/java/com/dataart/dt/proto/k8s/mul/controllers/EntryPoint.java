package com.dataart.dt.proto.k8s.mul.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EntryPoint {


    @GetMapping("/mul")
    @ResponseBody
    public int add(@RequestParam int a,
                   @RequestParam int b) {
        return a * b;
    }

}
