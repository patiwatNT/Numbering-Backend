package com.billng.numbering.service;

import com.billng.numbering.dto.NumberingPrivilegesDto;
import com.billng.numbering.dto.NumberingRolePrivilegesDto;
import com.billng.numbering.dto.NumberingUsersDto;
import com.billng.numbering.dtoC.LoginForm;
import com.billng.numbering.entities.NumberingPrivileges;
import com.billng.numbering.entities.NumberingRolePrivilegesPK;
import com.billng.numbering.entities.NumberingRoles;
import com.billng.numbering.mapper.NumberingRolePrivilegesMapper;
import com.billng.numbering.mapper.NumberingUsersMapper;
import com.billng.numbering.repository.NumberingPrivilegesRepository;
import com.billng.numbering.repository.NumberingRolePrivilegesRepository;
import com.billng.numbering.repository.NumberingUsersRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;


@Slf4j
@Service
@Transactional
public class LoginService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private NumberingUsersRepository numberingUsersRepository;
    @Autowired
    private NumberingRolePrivilegesRepository numberingRolePrivilegesRepository;
    @Autowired
    private NumberingPrivilegesRepository numberingPrivilegesRepository;
    @Autowired
    private NumberingUsersMapper numberingUsersMapper;
    @Autowired
    private NumberingRolePrivilegesMapper numberingRolePrivilegesMapper;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String login(LoginForm form) {
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
        String result = extractResult(responseBody, "result");
        System.out.println(result);
//        if (result != null && result.equals("success")) {
//            String username = form.getUsername();
//            NumberingUsersDto numberingUsersDto = numberingUsersRepository.findByUsername(username);
//            if(numberingUsersDto==null){
//                // Insert User
//                NumberingUsersDto temp = new NumberingUsersDto();
//                temp.setUserId(BigDecimal.valueOf(Math.random()));
//                temp.setUsername(username);
//                NumberingRoles numberingRoles = new NumberingRoles();
//                numberingRoles.setRoleId(BigDecimal.valueOf(2));
//                temp.setRoleId(numberingRoles);
//                numberingUsersRepository.save(numberingUsersMapper.toEntity(temp));
//
//                // Insert Role and Privilege
//                List<NumberingPrivileges> numberingPrivilegesList = numberingPrivilegesRepository.findAll();
//                for(NumberingPrivileges tempId:numberingPrivilegesList){
//                    NumberingRolePrivilegesDto numberingRolePrivilegesDto = new NumberingRolePrivilegesDto();
//                    NumberingRolePrivilegesPK pk = new NumberingRolePrivilegesPK();
//                    pk.setRoleId(BigInteger.valueOf(2));
//                    pk.setPrivilegeId(tempId.getPrivilegeId());
//                    numberingRolePrivilegesDto.setNumberingRolePrivilegesPK(pk);
//                    numberingRolePrivilegesDto.setAccessRights("ST001");
//                    numberingRolePrivilegesRepository.save(numberingRolePrivilegesMapper.toEntity(numberingRolePrivilegesDto));
//                }
//                System.out.println("Insert User Success");
//            }
//        }
        //System.out.println(responseBody);
        // Process the response as needed
        return responseBody;
    }

    public String signOut(LoginForm form) {
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

    public String sessionInfo(LoginForm form) {
        // URL of the external API
        String apiUrl = "https://intra.tot.co.th/api/SignIn.ashx?action=SessionInfo";

        // Create the form parameters
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
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

    public String extendSession(LoginForm form) {
        // URL of the external API
        String apiUrl = "https://intra.tot.co.th/api/SignIn.ashx?action=ExtendSession";

        // Create the form parameters
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_key", form.getClientKey());
        formData.add("token", form.getToken());
        formData.add("ip", form.getIp());

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

    public static String extractResult(String jsonResponse, String selectedNode) {
        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode node = rootNode.get(selectedNode);
            if (node != null) {
                return node.asText();
            }
        } catch (Exception e) {
            // Handle parsing exceptions
            e.printStackTrace();
        }
        return null;
    }
}
