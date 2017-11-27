package controller;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Booking;
import entities.BookingCompositeKey;
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

	@PUT
	@Path("/inser/{checkIn}/{checkOut}/{numberOfPeople}/{numberOfRooms}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(@PathParam(value = "checkIn") Date checkIn, @PathParam(value = "checkOut") Date checkOut,
			@PathParam(value = "numberOfPeople") int numberOfPeople,
			@PathParam(value = "numberOfRooms") int numberOfRooms) {
	
		Booking booking = new Booking();
		BookingCompositeKey bck = new BookingCompositeKey();
		
		bck.setStartDate(checkIn);
		booking.setRoomIdStartDate(bck);
		booking.setEndDate(checkOut);
		
		try {
			List<Booking> bookingList = bookingService.save(booking, numberOfPeople, numberOfRooms, checkIn, checkOut);
			
			return Response.status(200).entity(bookingList).build();
		} catch(Exception e) {
			return Response.status(404).entity("Internal server error").build();
		}
	}
}
