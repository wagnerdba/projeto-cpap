package com.wrtecnologia.cpap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.util.TimeZone;

@SpringBootApplication
@Slf4j
public class CpapApplication {
	public static void main(String[] args) {
		SpringApplication.run(CpapApplication.class, args);
	}

	@PostConstruct
	public void init() {

		// Setting Spring Boot SetTimeZone
		log.info(String.valueOf(ZoneId.systemDefault()));
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
		log.info(String.valueOf(ZoneId.systemDefault()));
	}
}
