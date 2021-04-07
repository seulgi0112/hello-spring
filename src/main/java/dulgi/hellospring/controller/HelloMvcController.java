package dulgi.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloMvcController {

	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model ) {
		model.addAttribute("name",name);
		return "hello-template";
	}
}
