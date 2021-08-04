package com.example.demo.contoller;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.demoservice.AtmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Atms;


@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AtmController {
	@Autowired
	AtmsService atmsService;
	
	@GetMapping(path = "/getAtms")
	public ResponseEntity<List<Atms>> getAtms() {
		List<Atms> atms=atmsService.getAtms();;
		return ResponseEntity.ok(atms);
	}
	@GetMapping(path = "/getAtmByCity/{city}")
	public ResponseEntity<List<Atms>> getAtmsByCity(@PathVariable String city) {
		List<Atms> atms=atmsService.getAtms();;
		List<Atms> atmsByCity=atms.stream().filter(atm->atm.getAddress().getCity().equals(city)).collect(Collectors.toList());
		return ResponseEntity.ok(atmsByCity);
	}

}
