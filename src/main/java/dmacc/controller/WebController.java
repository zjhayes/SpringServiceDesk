package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Request;
import dmacc.repository.RequestRepository;

@Controller
public class WebController
{
	@Autowired
	RequestRepository repo;

	@GetMapping("/viewAll")
	public String viewAllRequests(Model model)
	{
		model.addAttribute("requests", repo.findAll());
		return "requests"; // Returns name of page to forward to.
	}
	
	@GetMapping("/inputRequest")
	public String addNewRequest(Model model)
	{
		Request r = new Request();
		model.addAttribute("newRequest", r);
		return "portal"; // Pass empty Request to portal form.
	}
	
	@PostMapping("/input")
	public String addNewRequest(@ModelAttribute Request r, Model model)
	{
		repo.save(r);
		return "success";
	}
}
