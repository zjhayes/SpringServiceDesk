package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Request;
import dmacc.beans.User;

@Configuration
public class BeanConfiguration
{
	@Bean
	public Request request() 
	{
		Request bean = new Request();
		return bean;
	}
	
	@Bean
	public User user()
	{
		User user = new User();
		return user;
	}
}
