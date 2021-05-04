package com.example.SpringsterTwo.service;

import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Access;
import java.util.Base64;

@Component
@AllArgsConstructor
public class ImgBBConverter {
// api key  = 196b11b2e811ec52ce7384eba01415ed

    public String writeToStore(byte[] fileBytes) throws Exception {
        String url = "https://api.imgbb.com/1/upload?key=196b11b2e811ec52ce7384eba01415ed";
        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("image", Base64.getEncoder().encode(fileBytes));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ImgBBRes> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ImgBBRes.class);

        return response.getBody().getData().getDisplay_url();
    }
}
