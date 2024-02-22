package com.example.canteen.controller.home;

import com.example.canteen.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

  @GetMapping("/home")
  public String showHomeForm() {
    return "home";
  }
}
