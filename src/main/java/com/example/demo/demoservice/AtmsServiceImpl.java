package com.example.demo.demoservice;
import java.util.List;
import com.example.demo.Exception.AtmHandlerException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.example.demo.dto.Atms;

@Service
public class AtmsServiceImpl implements AtmsService {
	private RestTemplate restTemplate;
	final String url="https://www.ing.nl/api/locator/atms/";
	@Autowired
	public AtmsServiceImpl(@Qualifier("restTemplate") RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Atms> getAtms() {
		List<Atms> atms=null;
		try {
			MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
			ResponseEntity<String> atmsStringResponse=restTemplate.exchange(url,HttpMethod.GET,requestEntity, String.class);
			String jsonReponse=atmsStringResponse.getBody();
			jsonReponse=jsonReponse.substring(jsonReponse.indexOf("["),jsonReponse.length());
			 atms = new ObjectMapper().readValue(jsonReponse, new TypeReference<List<Atms>>(){});
		} catch (Exception e) {
			throw  new AtmHandlerException("Atms not found");
		}
		return atms;
	}

}
