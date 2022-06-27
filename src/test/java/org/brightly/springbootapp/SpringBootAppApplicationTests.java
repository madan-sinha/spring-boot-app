package org.brightly.springbootapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(classes = SpringBootAppApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootAppApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void testHealthEndpoint() {

		ResponseEntity<String> response = restTemplate.getForEntity("/health", String.class);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("{\"status\":\"UP\",\"groups\":[\"liveness\",\"readiness\"]}");
	}

	@Test
	public void testHelloEndpoint() {

		ResponseEntity<String> response = restTemplate.getForEntity("/greeting", String.class);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("Hello Spring-Boot !!");
	}

	@Test
	public void testHelloNameEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity("/greeting/Madan", String.class);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("Hello Nishant, Welcome to Spring-Boot World !!");
	}
}
