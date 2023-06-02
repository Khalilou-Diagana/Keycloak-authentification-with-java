package com.khalilou.keyclock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    Logger log = LoggerFactory.getLogger(LoginController.class);
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(HttpServletRequest request, @RequestBody LoginRequest loginRequest) throws Exception{
        log.info("execution du login");
        ResponseEntity <LoginResponse> response =null;
        log.info(loginRequest.getUsername() + "-----" + loginRequest.getPassword());
        response = loginService.login(loginRequest);
        log.info(response.getBody().toString());
        return response;
    }


}
