package com.cerner;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.cerner.resource.VitalsResource;
@ApplicationPath("webapi")
public class CernerApplication extends Application {
	
	
	private Set<Object> singletons = new HashSet<Object>();

    public CernerApplication() {
        singletons.add(new VitalsResource());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
    
	/*public CernerApplication() {
		packages("cerner.application");
		register(RolesAllowedDynamicFeature.class);
		
	} */

}
