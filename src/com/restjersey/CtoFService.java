package com.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/*
 * CtoFService: This below service will provide the client
 * the results of Celsius to Fahrenheit temperature
 * conversions
 */
@Path("/ctofservice")
public class CtoFService {
	@GET
	@Produces("application/xml")
	public String convertCtoF(){
		Double fahrenheit;
		Double celsius = 36.8;
		fahrenheit = ((celsius*9)/5)+32;
		String result = "@Produces(\"application/xml\")Output:\n\n C to F converter output:\n\n" +fahrenheit;
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}
	
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String convertCtoFfromInputService(@PathParam("c") Double c){
		Double fahrenheit;
		Double celsius = c;
		fahrenheit = ((celsius*9)/5)+32;
		String result = "@Produces(\"application/xml\")Output:\n\n C to F converter output:\n\n" +fahrenheit;
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
		
	}
}
