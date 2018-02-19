package com.hotel.controller.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.hotel.controller.BookingController;
import com.hotel.service.BookingService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookingService bookingServiceMock;
	
	@Test
	public void save_ShouldSaveNewBookingToDatabase() throws Exception {
		
	}

	@Test
	//test as if we're logged in
	@WithMockUser
	public void findAll_ShouldReturnAllBookingsFromDatabaseAsJSON() throws Exception {					
		mockMvc.perform(get("/booking/getAll"))
				.andExpect(status().isOk());
	}
}
