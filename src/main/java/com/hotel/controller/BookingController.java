package com.hotel.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.entity.Booking;
import com.hotel.form.BookingForm;
import com.hotel.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@GetMapping("/booking/getAll")
	public ResponseEntity<List<Booking>> getAll() {
		List<Booking> bookingList = bookingService.findAll();
		return ResponseEntity.ok().body(bookingList);
	}
	
	@GetMapping("/booking")
	public ModelAndView getBooking() {
		ModelAndView model = new ModelAndView();
		BookingForm bookingForm = new BookingForm();
		model.addObject("bookingForm", bookingForm);
		model.setViewName("booking");

		return model;
	}

	@PostMapping("/booking")
	public ModelAndView booking(@Valid BookingForm bookingForm, BindingResult bindingResult, Principal principal) {
		final Logger log = LoggerFactory.getLogger(BookingController.class);
		ModelAndView model = new ModelAndView();
		DateTime checkIn, checkOut;
		DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");

		log.info("Got from booking form: ");
		log.info(bookingForm.getCheckIn());
		log.info(bookingForm.getCheckOut());
		log.info(bookingForm.getPeople());
		log.info(principal.getName());
		
		checkIn = dtf.parseDateTime(bookingForm.getCheckIn());
		checkOut = dtf.parseDateTime(bookingForm.getCheckOut());
		
		if(checkIn.isBeforeNow()) {
			log.info("Check-in date is before today!");
			bindingResult.rejectValue("checkIn", "error.checkIn", "Check-in day must be set for today or a future date!");
		}
		
		if(checkOut.isBefore(checkIn) || checkOut.isEqual(checkIn)) {
			log.info("Check-in date is after or equal to check-out date!");
			bindingResult.rejectValue("checkIn", "error.checkIn", "Check-in date is after or equal to check-out date!");
		}

		if (bindingResult.hasErrors()) {
			log.error("Form has errors, sending back for correction!");
			model.setViewName("booking");
		} else {
			log.info("Everything is ok");
			
			bookingService.saveBooking(bookingForm.getCheckIn(), bookingForm.getCheckOut(), bookingForm.getPeople(), principal.getName());

			model.setViewName("booking");
		}

		return model;
	}
}
