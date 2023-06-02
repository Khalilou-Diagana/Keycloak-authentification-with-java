package com.khalilou.keycloak.Services;

import com.khalilou.keycloak.Entities.LoginRequest;
import com.khalilou.keycloak.Entities.LoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {
    @Value("${app.keycloak.login.url}")
    private  String loginUrl;
    @Value("${app.keycloak.client-secret}")
    private  String clientSecret;
   @Value("${app.keycloak.grant-type}")
    private  String grantType;
   @Value("${app.keycloak.client-id}")
    private String clientId = "myapp";


    RestTemplate restTemplate;

    public LoginService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<LoginResponse> login (LoginRequest request){
        HttpHeaders headers=new  HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map=new LinkedMultiValueMap<>();
        map.add("username", request.getUsername());
        map.add("password", request.getPassword());
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("grant_type", grantType);

        HttpEntity<MultiValueMap<String,String>> httpEntity=new HttpEntity<>(map,headers);
        System.out.println(httpEntity.getBody());
        ResponseEntity<LoginResponse> loginResponse =restTemplate.postForEntity(loginUrl, httpEntity,LoginResponse.class);
        System.err.println(loginResponse.getBody());
        return ResponseEntity.status(200).body(loginResponse.getBody());

    }

}
