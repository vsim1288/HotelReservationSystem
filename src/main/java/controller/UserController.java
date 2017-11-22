package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Role;
import entities.User;
import service.UserService;

@Path("/user")
public class UserController {
	private UserService userService = new UserService();

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
}
