package com.dataart.dt.proto.k8s.front.controllers;

import com.dataart.dt.proto.k8s.front.services.ExpressionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EntryPoint {

    final ExpressionHandler expressionHandler;

    @Autowired
    public EntryPoint(ExpressionHandler expressionHandler) {
        this.expressionHandler = expressionHandler;
    }

    @GetMapping("/calc")
    @ResponseBody
    public String calc(@RequestParam String expression) {
        if (expressionHandler.evaluateExpression(expression)) {
            return "OK";
        } else {
            return "Not correct expression";
        }

    }

}
