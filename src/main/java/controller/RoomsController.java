package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import service.RoomsService;

@Path("/rooms")
public class RoomsController {

	@GET
	@Path("/getVacantRooms")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVacantRooms() {
		RoomsService roomsService = new RoomsService();
		
		return null;
	}
}
