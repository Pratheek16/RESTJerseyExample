package com.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/*
 * RESTJerseyClient: This class will access the resources i.e.
 * Receives the results of temperature conversions.
 */

public class RESTJerseyClient {
	
	public static void main(String[] args){
		RESTJerseyClient restJerseyClient = new RESTJerseyClient();
		restJerseyClient.getCtoFResponse();
		restJerseyClient.getFtoCResponse();
	}
	
	private void getCtoFResponse(){
		try{
			Client client = Client.create();
			WebResource resource = client.resource("http://localhost:8080/RESTJerseyExample/temperatureconversion/ctofservice/40");
			ClientResponse response = resource.accept("application/xml").get(ClientResponse.class);
			if(response.getStatus()!=200){
				throw new RuntimeException("Failed HTTP error code:" + response.getStatus());
			}
			String output = response.getEntity(String.class);
			System.out.println(output);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void getFtoCResponse(){
		try{
			Client client = Client.create();
			WebResource resource2 = client.resource("http://localhost:8080/RESTJerseyExample/temperatureconversion/ftocservice/40");
			ClientResponse response2 = resource2.accept("application/json").get(ClientResponse.class);
			if(response2.getStatus()!=200){
				throw new RuntimeException("Failed HTTP error code:" + response2.getStatus());
			}
			String output2 = response2.getEntity(String.class);
			System.out.println(output2);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
