package com.example.accuweather.service;

import com.example.accuweather.exception.IntegrationException;
import com.example.accuweather.exception.InternalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.zip.GZIPInputStream;

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
