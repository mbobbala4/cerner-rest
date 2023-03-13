package com.cerner.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.cerner.model.User;
import com.cerner.service.UserService;



@Path("/user")
//@Api("/userInfo")
//@SwaggerDefinition(tags={@Tag(name="userInfo",description="REST EndPoint for userInfo")})
public class UserResource {
	UserService userService = new UserService();
	final static Logger logger = Logger.getLogger(UserResource.class);
	// CRUD -- CREATE operation
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User user) {
		
		User userResponse = userService.createUser(user);
		
		return userResponse;
	}

	// CRUD -- READ operation
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		List<User> userList = userService.getAllUsers();
		return userList;
	}

	// CRUD -- READ operation
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserForId(@PathParam("id") int id) {
		User user = userService.getUserForId(id);
		return user;
	}

	// CRUD -- UPDATE operation
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateUser(User user) {
		User userResponse = userService.updateUser(user);
		return userResponse;
	}

	// CRUD -- DELETE operation
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User deleteUser(@PathParam("id") int id) {
		User userResponse = userService.deleteUser(id);
		return userResponse;
	}
}
