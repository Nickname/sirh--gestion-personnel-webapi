package dev.sgpwepapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.sgpwepapi.config.AppConfig;

@SpringBootApplication
public class SgpWepapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}
}
