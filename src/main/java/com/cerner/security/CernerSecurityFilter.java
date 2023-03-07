package com.cerner.security;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

import com.cerner.service.UserService;

import java.util.List;

@Provider
public class CernerSecurityFilter implements ContainerRequestFilter {
	
	UserService us = new UserService();
	
	private static final String AUTHORIZATION_HEADER_KEY ="Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		if(authHeader!=null && authHeader.size() > 0){
			String authToken = authHeader.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX,"");
			String decodedString = Base64.decodeAsString(authToken);
			StringTokenizer tokenizer = new StringTokenizer(decodedString,":");
			String userName = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			
			boolean isValid = us.getUserByUserNameandPassword( userName , password);
			
			if(isValid) {
				return;
			}
			
		}
		Response unauthorizedStatus = Response
				                       .status(Response.Status.UNAUTHORIZED)
			                           .entity("user cannot access the resource.")
			                           .build();
		
		requestContext.abortWith(unauthorizedStatus);
			
		}
		
	}


