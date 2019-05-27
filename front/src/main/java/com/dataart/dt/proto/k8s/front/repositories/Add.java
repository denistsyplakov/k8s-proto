package com.dataart.dt.proto.k8s.front.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "add", url = "http://${service.add.host}:${service.add.port}")
public interface Add {

    @RequestMapping(method = RequestMethod.GET, value = "/add?a={a}&b={b}")
    public int add(@PathVariable("a") int a, @PathVariable("b") int b);

}
