package com.billng.numbering.service;

import com.billng.numbering.dtoC.LoginForm;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;



@Slf4j
@Service
@Transactional
public class LoginService {
    @Autowired
    private RestTemplate restTemplate;
    public String login(LoginForm form){
        // URL of the external API
        String apiUrl = "https://intra.tot.co.th/api/SignIn.ashx?action=Authen";

        // Create the form parameters
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("username", form.getUsername());
        formData.add("password", form.getPassword());
        formData.add("ip", form.getIp());
        formData.add("client_key", form.getClientKey());

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Create the request entity with the form data and headers
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);

        // Make a POST request to the external API with the form data
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

        // Get the response body
        String responseBody = responseEntity.getBody();

        System.out.println(responseBody);
        // Process the response as needed
        return responseBody;
    }

    public String signOut(LoginForm form){
        // URL of the external API
        String apiUrl = "https://intra.tot.co.th/api/SignIn.ashx?action=SignOut";

        // Create the form parameters
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("username", form.getUsername());
        formData.add("client_key", form.getClientKey());
        formData.add("token", form.getToken());

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Create the request entity with the form data and headers
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);

        // Make a POST request to the external API with the form data
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

        // Get the response body
        String responseBody = responseEntity.getBody();

        //System.out.println(responseBody);
        // Process the response as needed
        return responseBody;
    }

    public String sessionInfo(LoginForm form){
        // URL of the external API
        String apiUrl = "https://intra.tot.co.th/api/SignIn.ashx?action=SessionInfo";

        // Create the form parameters
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_key", form.getClientKey());
        formData.add("token",form.getToken());

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Create the request entity with the form data and headers
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);

        // Make a POST request to the external API with the form data
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

        // Get the response body
        String responseBody = responseEntity.getBody();

        //System.out.println(responseBody);
        // Process the response as needed
        return responseBody;
    }

    public String extendSession(LoginForm form){
        // URL of the external API
        String apiUrl = "https://intra.tot.co.th/api/SignIn.ashx?action=ExtendSession";

        // Create the form parameters
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_key", form.getClientKey());
        formData.add("token",form.getToken());
        formData.add("ip",form.getIp());

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Create the request entity with the form data and headers
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);

        // Make a POST request to the external API with the form data
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

        // Get the response body
        String responseBody = responseEntity.getBody();

        //System.out.println(responseBody);
        // Process the response as needed
        return responseBody;
    }
}
