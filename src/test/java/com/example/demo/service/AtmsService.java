package com.example.demo.service;
import com.example.demo.demoservice.AtmsServiceImpl;
import com.example.demo.dto.Atms;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AtmsService {
    @InjectMocks
    AtmsServiceImpl atmsService;
    @Mock
    @Qualifier("restTemplate")
    RestTemplate restClient;

    final String path="testData/Atms.json";
    @Test
    public void getAllAtms() throws IOException {

        String atmsResponse = getAtms(path);
        ResponseEntity<String> response = new ResponseEntity<>(atmsResponse, HttpStatus.OK);
        when(restClient.exchange(anyString(), eq(HttpMethod.GET), any(), eq(String.class))).thenReturn(response);
        List<Atms> atms=atmsService.getAtms();
        assertFalse(atms.isEmpty());
    }
    private String getAtms(String path) throws IOException {
        if (Objects.isNull(path)) {
            path = "testData/Atms.json";
        }
        String extraData=")]}',";
        JsonNode jsonNode = new ObjectMapper().readValue(
                new ClassPathResource(path).getFile(),
                JsonNode.class);
        String jsonReponse =  new ObjectMapper().convertValue(jsonNode, JsonNode.class).toString();
        return  jsonReponse=extraData+jsonReponse;
    }
}
