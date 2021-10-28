package com.example.azuredemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.azuredemo.dto.GenericPayload;

@RestController
@RequestMapping("/generic")
public class AzureController {

	/*@Value("${applicationname}")
	private String applicationname;*/
	
	@GetMapping(path="/{name}", produces = "application/json")
    public @ResponseBody String getName(@PathVariable String name) {
        return "Welcome ID "+ name;
    }
	
	@RequestMapping(value = "/payload",  method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<GenericPayload> getPayload(HttpServletRequest request){
		
		GenericPayload genericPayload = new GenericPayload();
		genericPayload.setId("HAHAHAH1x3546");
		genericPayload.setName("Vikram");
		genericPayload.setSource("Azure");
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(genericPayload);
	}

	
	@RequestMapping(value = "/multipayload",  method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<List<GenericPayload>> getPayloads(HttpServletRequest request){
		
		GenericPayload genericPayload = new GenericPayload();
		genericPayload.setId("HAHAHAH1x3546");
		genericPayload.setName("Vikram");
		genericPayload.setSource("Azure");
		GenericPayload genericPayload1 = new GenericPayload();
		genericPayload1.setId("xzxsdsw3434");
		genericPayload1.setName("Sample");
		genericPayload1.setSource("Azure-1");
		
		List<GenericPayload> list = new ArrayList<>();
		list.add(genericPayload);
		list.add(genericPayload1);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(list);
	}
}
