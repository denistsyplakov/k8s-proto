package com.dataart.dt.proto.k8s.front.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "mul", url = "http://localhost:8081")
public interface Mul {

    @RequestMapping(method = RequestMethod.GET, value = "/mul?a={a}&b={b}")
    public int mul(@PathVariable("a")int a, @PathVariable("b") int b);

}
