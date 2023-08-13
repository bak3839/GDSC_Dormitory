package com.example.GDSC_Dormitory.api;

import com.example.GDSC_Dormitory.Controller.CheckForm;
import com.example.GDSC_Dormitory.Controller.EmailForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/email")
public class EmailAuth {

    @PostMapping("/sendcode")
    public ResponseEntity<String> sendCode (@RequestBody EmailForm form) {
        System.out.println(form.getEmail());
        // API 엔드포인트 URL
        String apiUrl = "https://univcert.com/api/v1/certify";

        // 요청에 필요한 데이터
        String key = "67551582-995f-4a87-8287-8263b1fb22a0"; // 실제 키로 대체
        String email = form.getEmail(); // 이메일 주소로 대체
        String univName = "상명대학교"; // 대학 이름으로 대체
        boolean univCheck = true; // 대학 재학 확인 여부 (true: 재학 확인, false: 대학 이메일 유무만 확인)

        // 요청 데이터를 JSON 형식으로 생성
        String requestBody = "{\"key\": \"" + key + "\","
                + "\"email\": \"" + email + "\","
                + "\"univName\": \"" + univName + "\","
                + "\"univ_check\": " + univCheck + "}";

        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 요청 생성
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // RestTemplate 생성
        RestTemplate restTemplate = new RestTemplate();

        // POST 요청 보내고 응답 받기
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

        // 응답 처리
        HttpStatus statusCode = responseEntity.getStatusCode();
        String responseBody = responseEntity.getBody();

        System.out.println("Response Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);

        return responseEntity;
    }

    @PostMapping("/checkcode")
    public String checkCode (@RequestBody CheckForm form) {
        System.out.println(form.getEmail() + " " + form.getNum());
        // API 엔드포인트 URL
        String apiUrl = "https://univcert.com/api/v1/certifycode";

        // 요청에 필요한 데이터
        String key = "67551582-995f-4a87-8287-8263b1fb22a0"; // 실제 키로 대체
        String email = form.getEmail(); // 이메일 주소로 대체
        String univName = "상명대학교"; // 대학 이름으로 대체
        int code = form.getNum(); // 인증번호

        // 요청 데이터를 JSON 형식으로 생성
        String requestBody = "{\"key\": \"" + key + "\","
                + "\"email\": \"" + email + "\","
                + "\"univName\": \"" + univName + "\","
                + "\"code\":" + code + "}";

        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

        // 응답 처리
        // HttpStatus statusCode = responseEntity.getStatusCode();
        String responseBody = responseEntity.getBody();
        System.out.println(responseBody);
        return responseBody;
    }
}
