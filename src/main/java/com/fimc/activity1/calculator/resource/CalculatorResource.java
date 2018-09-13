package com.fimc.activity1.calculator.resource;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("/calculator")
public class CalculatorResource implements Serializable {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(CalculatorRequest request) {
		CalculatorResponse calculatorResponse = new CalculatorResponse();
		
		if(StringUtils.isEmpty(request.getOperator())||StringUtils.isEmpty(request.getNumber1())||StringUtils.isEmpty(request.getNumber2())) {
			return Response.status(Response.Status.BAD_REQUEST)
		              .entity("All fields are required").type( MediaType.TEXT_PLAIN).build();
		}else if (!request.getNumber1().matches("[0-9]+") || !request.getNumber2().matches("[0-9]+")) {
			return Response.status(Response.Status.BAD_REQUEST)
		              .entity("Invalid number").type( MediaType.TEXT_PLAIN).build();
		}else {
				String action = ""; String result = "";
				if(request.getOperator().equals("+")) {
					action = "addition";
					result = String.valueOf(Integer.parseInt(request.getNumber1())+Integer.parseInt(request.getNumber2()));
				}else if(request.getOperator().equals("-")) {
					action = "subtraction";
					result = String.valueOf(Integer.parseInt(request.getNumber1())-Integer.parseInt(request.getNumber2()));
				}else if(request.getOperator().equals("*")) {
					action = "multiplication";
					result = String.valueOf(Integer.parseInt(request.getNumber1())*Integer.parseInt(request.getNumber2()));
				}else if(request.getOperator().equals("/")) {
					action = "division";
					if(Integer.parseInt(request.getNumber2())==0) {
						return Response.status(Response.Status.BAD_REQUEST).entity("Cant divide by zero").type( MediaType.TEXT_PLAIN).build();
					}else {
						result = String.valueOf(Double.parseDouble(String.format("%.5f", Double.valueOf(request.getNumber1()) / Double.valueOf(request.getNumber2()))));
					}
				}else {
					return Response.status(Response.Status.BAD_REQUEST).entity("Invalid operator").type( MediaType.TEXT_PLAIN).build();
				}
					calculatorResponse.setAction(String.format("%s",action));
					calculatorResponse.setResult(Double.parseDouble(result));
					return Response.ok().entity(calculatorResponse).build();
			}
			
		}
}
