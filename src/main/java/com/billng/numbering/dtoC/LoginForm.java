package com.billng.numbering.dtoC;

import lombok.Data;

@Data
public class LoginForm {
    private String username;
    private String password;
    private String ip;
    private String clientKey;
    private String token;
}
