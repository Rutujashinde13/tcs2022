package com.cts.authorization.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.authorization.config.JwtTokenUtil;
import com.cts.authorization.model.JwtRequest;
import com.cts.authorization.model.User;
import com.cts.authorization.service.JwtUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class JwtAuthenticationControllerEndPointsTest {

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Autowired
	private MockMvc mockmvc;

	@MockBean
	private JwtUserDetailsService userdetailsservice;

	@MockBean
	private JwtTokenUtil jwtokenUtil;

	@MockBean
	private AuthenticationManager authenticationmanager;

	@Test
	void testBadRequestGenerateToken() throws Exception {
		this.mockmvc.perform(post("/api/v1/authenticate")).andExpect(status().isBadRequest());
	}

	@Test
	void testAuthorizedGenerateToken() throws Exception {

		User user = new User(1, "admin", "admin");
		UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), new ArrayList<>());
		when(jwtokenUtil.generateToken(details)).thenReturn("Bearer @token@token");
		when(userdetailsservice.loadUserByUsername("admin")).thenReturn(details);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(new JwtRequest("admin", "admin"));
		this.mockmvc.perform(post("/api/v1/authenticate").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isUnauthorized());
	}

	@Test
	void testBadRequest() throws Exception {
		this.mockmvc.perform(post("/api/v1/authenticate")).andExpect(status().isBadRequest());
	}

	@Test
	void testRandomUrl() throws Exception {
		this.mockmvc.perform(get("/api/v1/other/url")).andExpect(status().isNotFound());
	}

	@Test
	void textExistingUserAuthenticate() throws Exception {
		User user = new User(1, "admin", "pass");
		UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), new ArrayList<>());
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				"admin", "admin");
		when(authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken("admin", "admin")))
				.thenReturn(usernamePasswordAuthenticationToken);
		when(userdetailsservice.loadUserByUsername("admin")).thenReturn(details);
		when(jwtokenUtil.getUsernameFromToken("token")).thenReturn("admin");
		when(jwtokenUtil.generateToken(details)).thenReturn("token");
		ObjectMapper mapper = new ObjectMapper();
		mockmvc.perform(MockMvcRequestBuilders.post("/api/v1/authenticate").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(new JwtRequest("admin", "pass")))).andExpect(status().isUnauthorized());

	}

	@Test
	void textExistingUserAuthorize() throws Exception {
		User user = new User(1, "admin", "pass");
		UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), new ArrayList<>());
		when(userdetailsservice.loadUserByUsername("admin")).thenReturn(details);
		when(jwtokenUtil.getUsernameFromToken("token")).thenReturn("admin");
		mockmvc.perform(MockMvcRequestBuilders.post("/api/v1/authorize").header("Authorization", "Bearer token"))
				.andExpect(status().isOk());

	}

	@Test
	void textNullTokenAuthorize() throws Exception {
		User user = new User(1, "admin", "pass");
		UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), new ArrayList<>());
		when(userdetailsservice.loadUserByUsername("admin")).thenReturn(details);
		when(jwtokenUtil.getUsernameFromToken("token")).thenReturn("admin");
		mockmvc.perform(MockMvcRequestBuilders.post("/api/v1/authorize").header("Authorization", "")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	@Test
    void heatlthCheck() throws Exception {
        this.mockmvc.perform(get("/api/v1/health-check")).andExpect(status().isOk());
    }

}
