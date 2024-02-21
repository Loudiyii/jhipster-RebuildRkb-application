package com.rbuilde.myapp.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbuilde.myapp.model.GeneratorJhipster;
import com.rbuilde.myapp.model.GeneratorJhipsterInitializer;
import com.rbuilde.myapp.model.GeneratorJhipsterUpdater;
import com.rbuilde.myapp.service.MyService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final MyService myService;
    private final GeneratorJhipsterInitializer generatorJhipsterInitializer;

    @Autowired
    public MyController(MyService myService, GeneratorJhipsterInitializer generatorJhipsterInitializer) {
        this.myService = myService;
        this.generatorJhipsterInitializer = generatorJhipsterInitializer;
    }

    @PostMapping("/call-download")
    public ResponseEntity<byte[]> callExternalAPI(
        @RequestHeader("Authorization") String authToken,
        @RequestBody(required = false) Map<String, Object> payload
    ) {
        try {
            // Initialize GeneratorJhipster
            GeneratorJhipster generatorJhipster = generatorJhipsterInitializer.initializeGeneratorJhipster();

            // If payload is provided, update the GeneratorJhipster object
            if (payload != null) {
                GeneratorJhipsterUpdater.updateGeneratorJhipster(generatorJhipster, payload);
            }

            // Create a map to hold the GeneratorJhipster properties under "generator-jhipster" key
            Map<String, GeneratorJhipster> jsonMap = new HashMap<>();
            jsonMap.put("generator-jhipster", generatorJhipster);

            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert map to JSON string
            String jsonBody = objectMapper.writeValueAsString(jsonMap);

            byte[] responseData = myService.callExternalPostAPI(authToken, jsonBody);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "application.zip");
            return new ResponseEntity<>(responseData, headers, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid request parameters".getBytes());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to call external API".getBytes());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
