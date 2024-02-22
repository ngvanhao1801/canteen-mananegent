package com.example.canteen.controller.user_login_logout_registration;

import com.example.canteen.dto.UserDto;
import com.example.canteen.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegistrationController {
  private final UserService userService;

  public UserRegistrationController(UserService userService) {
    this.userService = userService;
  }

  @ModelAttribute("userdto")
  public UserDto userResgistrationDto() {
    return new UserDto();
  }

  @GetMapping("/registration")
  public String showRegistrationForm() {
    return "/registration";
  }

  @PostMapping("/registration")
  public String registerUserAccount(@ModelAttribute("userdto") UserDto userDto) {
    if (userService.checkUserByEmail(userDto.getEmail())) {
      return "redirect:/registration?emailexist";
    }
    if (!userDto.getPassword().equals(userDto.getCheckPass())) {
      return "redirect:/registration?checkpass";
    }
    userService.save(userDto);
    return "redirect:/registration?success";
  }
}
