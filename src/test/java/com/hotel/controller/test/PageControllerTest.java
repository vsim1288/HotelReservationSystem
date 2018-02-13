package com.hotel.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hotel.controller.PageController;
import com.hotel.entity.Users;
import com.hotel.service.UsersService;

@RunWith(SpringRunner.class)
@WebMvcTest(PageController.class)
public class PageControllerTest {
	@Autowired
	private PageController pageController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UsersService usersService;
	
	@Mock
	private Users user;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(pageController).isNotNull();
	}
	
	@Test
	public void methodShouldReturnNullFromService() throws Exception {
		String username = "user1@uer.com";
		
		assertThat(usersService.findByUsername(username)).isNull();
	}
}
