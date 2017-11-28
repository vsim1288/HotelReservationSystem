package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Booking;
import managedBeans.LoginBean;
import service.BookingService;

@Path("/booking")
public class BookingController {
	private BookingService bookingService = new BookingService();

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		try {
			List<Booking> bookingList = bookingService.getAll();

			return Response.status(200).entity(bookingList).build();
		} catch (Exception e) {
			return Response.status(500).entity("Internal server error!").build();
		}
	}

	@GET
	@Path("/insert/{checkIn}/{checkOut}/{numberOfPeople}/{numberOfRooms}/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(@PathParam(value = "checkIn") String checkIn, @PathParam(value = "checkOut") String checkOut,
			@PathParam(value = "numberOfPeople") int numberOfPeople,
			@PathParam(value = "numberOfRooms") int numberOfRooms, @PathParam(value = "username") String username) throws ParseException {
		System.out.println("Booking");
		boolean status = false;

		System.out.println("got username: " + username);

		System.out.println("booking set");
		
		DateFormat checkInFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date checkInDate = checkInFormat.parse(checkIn);
		System.out.println(checkInDate);
		
		DateFormat checkOutFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date checkOutDate = checkOutFormat.parse(checkOut);
		System.out.println(checkOutDate);
		
		try {
			status = bookingService.save(numberOfPeople, numberOfRooms, checkInDate, checkOutDate, username);
			System.out.println("check status: " + status);
			if (status) {
				return Response.status(200).entity("{'status': + " + status + "}").build();
			}
			return Response.status(404).entity("{'status': " + status +"}").build();
		} catch (Exception e) {
			return Response.status(500).entity("{'status': " + status +"}").build();
		}
	}
}
