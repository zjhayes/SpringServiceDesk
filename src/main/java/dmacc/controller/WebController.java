package dmacc.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Request;
import dmacc.beans.User;
import dmacc.repository.RequestRepository;
import dmacc.repository.UserRepository;

@Controller
public class WebController
{
	@Autowired
	RequestRepository repo;
	@Autowired
	UserRepository userRepo;

	@GetMapping("/viewAll") // Link from index.html
	public String viewAllRequests(Model model)
	{
		if(repo.findAll().isEmpty())
		{
			return addNewRequest(model);
		}
		
		model.addAttribute("requests", repo.findAll());
		return "requests"; // Returns name of page to forward to.
	}
	
	@GetMapping("/inputRequest") // Action called from portal.html, link from index.html
	public String addNewRequest(Model model)
	{
		Request r = new Request();
		model.addAttribute("newRequest", r); // passing object to portal called newRequest
		return "portal"; // Pass empty Request to portal form.
	}
	
	@PostMapping("/inputRequest")
	public String addNewRequest(@ModelAttribute Request r, Model model)
	{
		r.setCreatedDate(LocalDate.now());
		repo.save(r);
		return "success";
	}
	
	@GetMapping("/edit/{id}") // id set in requests.html
	public String showUpdateRequest(@PathVariable("id") long id, Model model)
	{
		Request r = repo.findById(id).orElse(null);
		model.addAttribute("requestToUpdate", r);
		return "edit-request";
	}
	
	@PostMapping("/update/{id}") // Set in edit-request.html
	public String editRequest(Request r, Model model)
	{
		repo.save(r);
		return viewAllRequests(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRequest(@PathVariable("id") long id, Model model)
	{
		Request r = repo.findById(id).orElse(null);
		repo.delete(r);
		return viewAllRequests(model);
	}
	
	@GetMapping("/viewAllUsers")
	public String viewAllUsers(Model model)
	{	
		if(userRepo.findAll().isEmpty())
		{
			return viewAllRequests(model);
		}
		
		model.addAttribute("users", userRepo.findAll());
		return "users";
	}
	
	@GetMapping("/inputUser") // Action called from portal.html, link from index.html
	public String addNewUser(Model model)
	{
		User u = new User();
		model.addAttribute("newUser", u); // passing object to portal called newRequest
		return "register-user"; // Pass empty Request to portal form.
	}
	
	@PostMapping("/inputUser")
	public String addNewUser(@ModelAttribute User u, Model model)
	{
		userRepo.save(u);
		return viewAllUsers(model);
	}
	
	@GetMapping("/edit-user/{id}") // id set in requests.html
	public String showUpdateUser(@PathVariable("id") long id, Model model)
	{
		User u = userRepo.findById(id).orElse(null);
		model.addAttribute("userToUpdate", u);
		return "edit-user";
	}
	
	@PostMapping("/update-user/{id}") // Set in edit-request.html
	public String editUsert(User u, Model model)
	{
		userRepo.save(u);
		return viewAllUsers(model);
	}
	
	@GetMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model)
	{
		User u = userRepo.findById(id).orElse(null);
		userRepo.delete(u);
		return viewAllUsers(model);
	}
	
	@GetMapping("/edit-password/{id}")
	public String showUpdatePassword(@PathVariable("id") long id, Model model)
	{
		User u = userRepo.findById(id).orElse(null);
		model.addAttribute("userToUpdate", u);
		return "update-password";
	}
}
