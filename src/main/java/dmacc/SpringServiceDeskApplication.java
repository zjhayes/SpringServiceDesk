package dmacc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dmacc.beans.Request;
import dmacc.beans.User;
import dmacc.repository.RequestRepository;
import dmacc.repository.UserRepository;


@SpringBootApplication
public class SpringServiceDeskApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringServiceDeskApplication.class, args);
	}
	/*
	@Bean
	public CommandLineRunner mappingDemo(RequestRepository requestRepo, UserRepository userRepo)
	{
		return args -> {
			User user = new User("zhayes@example.com", "Zachary Hayes", "aakjgo");
			
			userRepo.save(user);
			
			requestRepo.save(new Request("subject!", "description!", "Bug", user));
			
		};
	}*/
}
