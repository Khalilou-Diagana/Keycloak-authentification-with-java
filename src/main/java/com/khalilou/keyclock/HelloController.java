package com.khalilou.keyclock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/user")
    public String getUser(@RequestHeader String authorization){
        return "hello user";
    }

    @GetMapping("/admin")
    public String getAdmin(@RequestHeader String authorization){
        return "hello admin";
    }

    @GetMapping("/random")
    public String getRandomUser() {
        return "Hello random user";
    }


}
