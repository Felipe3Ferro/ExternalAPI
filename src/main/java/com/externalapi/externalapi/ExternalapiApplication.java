package com.externalapi.externalapi;

import java.util.Arrays;

import com.externalapi.externalapi.Models.Boards;
import com.externalapi.externalapi.Models.Cards;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class ExternalapiApplication {


	public static RestTemplate template = new RestTemplate();

	public static void main(String[] args) {
		// SpringApplication.run(ExternalapiApplication.class, args);
		// seila("61eb148bf61d443d512751de");	
		getAllOfBoards();
	}

	public static Boards[] getAllOfBoards(){
	
	
		UriComponents uri = UriComponentsBuilder.newInstance()
			.scheme("https")
			.host("api.trello.com/")
			.path("1/members/me/boards")
			.queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
			.queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
			.build();
	
		Boards[] entity =  template.getForObject(uri.toString(), Boards[].class);

		for (int i = 0; i < entity.length; i++) {
			System.out.println(entity[i]);
		}
		
		return entity;
	}
	
	public static Cards[] getListCardsOfBoards(String id){

		//https://api.trello.com/1/boards/61eb148bf61d443d512751de/cards
		
		UriComponents uri = UriComponentsBuilder.newInstance()
			.scheme("https")
			.host("api.trello.com/")
			.path("1/boards/")
			.path(id + "/cards")
			.queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
			.queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
			.build();
	
		Cards[] entity =  template.getForObject(uri.toString(), Cards[].class);

		return entity;
	}

	public static void seila(String id){
	
		Arrays.stream(getListCardsOfBoards(id)).map(cards -> cards.getName()).forEach(System.out::println);

	}


	//== == == == == == == == == == == == == == == == == == == == == == == == == ==

	public static void postABoard(){

		UriComponents uri = UriComponentsBuilder.newInstance()
			.scheme("https")
			.host("api.trello.com/")
			.path("1/members/me/boards")
			.queryParam("name", "Create board test")
			.queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
			.queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
			.build();
			
	}

}
