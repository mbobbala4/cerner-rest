package com.cerner;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("webapi")
public class CernerApplication extends Application {
	
	
	/*public CernerApplication() {
		packages("cerner.application");
		register(RolesAllowedDynamicFeature.class);
		
	} */

}
