package com.scalar.productservicejune24.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//This class will be hosting set of HTTP API's

@RestController
@RequestMapping("/say")

public class SampleController
{
    @GetMapping("/hello/{name}/{times}")
    public String sayHello(@PathVariable("name") String xyz, @PathVariable("times") int times )//ideally name of both these parameters should be same
    {
        String output=" ";
        for(int i=0;i<times;i++)
        {
            output= output + " Hello " + xyz;
        }
          return output;
    }

    @GetMapping("/hi")
    public String sayHi()
    {
        return "Hi Everyone!";
    }
}
