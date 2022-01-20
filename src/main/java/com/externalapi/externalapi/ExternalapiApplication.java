package com.externalapi.externalapi;

import com.externalapi.externalapi.Models.Trello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class ExternalapiApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ExternalapiApplication.class, args);	
		a();
	}

	public static void a(){
		RestTemplate template = new RestTemplate();
	
	
		UriComponents uri = UriComponentsBuilder.newInstance()
			.scheme("https")
			.host("api.trello.com/")  
			.path("1/members/me/boards")
			.queryParam("id", "6036d2062891930a423b81c8")
			.queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
			.queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
			.build();
	
		Trello[] entity =  template.getForObject(uri.toString(), Trello[].class);
		
		for (int i = 0; i < entity.length; i++) {
			System.out.println(entity[i]);
		}
	}

}
