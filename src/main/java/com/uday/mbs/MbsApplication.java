package com.uday.mbs;

import com.uday.mbs.entities.Booking;
import com.uday.mbs.services.InitService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MbsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MbsApplication.class, args);
		Booking booking  = new Booking();

	}
	/**
	 * This is way to execute something in the very beggining when application
	 * is starting up
	 * @param initService
	 * @return
	 */
	@Bean
	CommandLineRunner init(InitService initService){
		return args -> {
			System.out.println("This will be executed as soon as the application is started");
			initService.init();
		};
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
