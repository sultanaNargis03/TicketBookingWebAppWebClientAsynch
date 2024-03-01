package com.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import com.telusko.response.Ticket;

@SpringBootApplication
public class TicketBookingWebAppApplication
{
	private static final String GET_URL = "http://localhost:8088/TicketBookingApp/api/ticket-booking/getTicket/{ticketNumber}";
	

	public static void main(String[] args) 
	{
		SpringApplication.run(TicketBookingWebAppApplication.class, args);
		//Get the WebClient object
		System.out.println("Request to API started....");
				WebClient webClient = WebClient.create();
			//	Ticket ticket=webClient
								webClient
								.get()
								.uri(GET_URL,2)
								.retrieve()
								.bodyToMono(Ticket.class)
								.subscribe(TicketBookingWebAppApplication::handleResponse);//asynch
								//.block();//synch
				//System.out.println(ticket);	
				System.out.println("Request to API ended....");	
			
	}
	public static void handleResponse(Ticket ticket)
	{
		System.out.println(ticket);
	}
	

}
