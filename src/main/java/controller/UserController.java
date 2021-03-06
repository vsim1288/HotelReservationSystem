package controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.User;
import service.UserService;

@Path("/user")
public class UserController {
	private UserService userService = new UserService();

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<User> userList = userService.list();
		
		return Response.status(200).entity(userList).build();
	}
	
	@GET
	@Path("/get/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsernameAndPassword(@PathParam(value = "username") String username,
			@PathParam(value = "password") String password) {
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);

		System.out.println("usercontroller");

		try {
			User userFound;
			
			userFound = userService.get(user);
				
			return Response.ok().entity(userFound).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return Response.status(404).entity("fail").build();
	}
	
	@GET
	@Path("/getByUsername/{username}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByUsername(@PathParam(value="username") String username) {
		try {
			User user = userService.getByUsername(username);
			System.out.println("user: " + user.getPassword());
			
			return Response.status(200).entity(user).build();
		} catch(Exception e) {
			
			return null;
		}
	}
}
