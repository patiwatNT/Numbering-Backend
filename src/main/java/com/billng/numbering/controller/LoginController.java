package com.billng.numbering.controller;

import com.billng.numbering.dtoC.LoginForm;
import com.billng.numbering.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
@Slf4j
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/auth")
    public String login(@RequestBody LoginForm form){
        System.out.println("Username: " + form.getUsername());
        System.out.println("Password: " + form.getPassword());
        System.out.println("IP: " + form.getIp());
        System.out.println("Client Key: " + form.getClientKey());
        return loginService.login(form);
    }

    @PostMapping("/signOut")
    public String signOut(@RequestBody LoginForm form){
        System.out.println("Token: " + form.getToken());
        System.out.println("Client Key: " + form.getClientKey());
        return loginService.signOut(form);
    }

    @PostMapping("/sessionInfo")
    public String sessionInfo(@RequestBody LoginForm form){
        System.out.println("Token: " + form.getToken());
        System.out.println("Client Key: " + form.getClientKey());
        return loginService.sessionInfo(form);
    }

    @PostMapping("/extendSession")
    public String extendSession(@RequestBody LoginForm form){
        System.out.println("Token: " + form.getToken());
        System.out.println("Client Key: " + form.getClientKey());
        System.out.println("IP: " + form.getIp());
        return loginService.extendSession(form);
    }
}
