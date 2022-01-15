package com.example.accuweather.service;

import com.example.accuweather.exception.IntegrationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class AccuweatherServiceImpl implements AccuweatherService {

    private final RestTemplate restTemplate;

    @Override
    public byte[] getDecodedByteResponseFromGivenUrl(String apiName, String destinationUrl) throws IntegrationException {
        URI url = URI.create(destinationUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept-Encoding", "gzip");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, byte[].class);
        if (response.getStatusCodeValue() == HttpStatus.OK.value()) {
            return response.getBody();
        } else {
            throw new IntegrationException(response.getStatusCodeValue(), apiName);
        }
    }
}
