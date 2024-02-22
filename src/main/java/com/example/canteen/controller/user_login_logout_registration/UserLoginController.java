package com.example.canteen.controller.user_login_logout_registration;

import com.example.canteen.dto.UserDto;
import com.example.canteen.entity.User;
import com.example.canteen.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("userDto")
public class UserLoginController {
  private final UserService userService;

  public UserLoginController(UserService userService) {
    this.userService = userService;
  }

  @ModelAttribute("userDto")
  public UserDto userDto() {
    return new UserDto();
  }

  @GetMapping("/login")
  public String showLoginForm() {
    return "/login";
  }

  @PostMapping("/login")
  public String Login(@ModelAttribute("userDto") UserDto userDto, Model model) {
    if (!userService.checkUserByEmail(userDto.getEmail())) {
      return "redirect:/login?emailwrong";
    }
    User user = userService.getUserByEmail(userDto.getEmail());
    if (user.getRole().equals("ADMIN")) {
      return "redirect:/admin_home";
    }
    if (userService.checkPasswordUser(userDto.getEmail(), userDto.getPassword())) {
      return "redirect:/home?success";
    }

    return "redirect:/login?passwordwrong";
  }

//  @PostMapping("/login")
//  public String login(@ModelAttribute("userDto") UserDto userDto, Model model,
//                      HttpServletResponse response, @RequestParam(value = "remember-me", required = false) String rememberMe) {
//    if (!userService.checkUserByEmail(userDto.getEmail())) {
//      return "redirect:/login?emailwrong";
//    }
//    User user = userService.getUserByEmail(userDto.getEmail());
//    if (user.getRole().equals("ADMIN")) {
//      return "redirect:/admin_home";
//    }
//    if (userService.checkPasswordUser(userDto.getEmail(), userDto.getPassword())) {
//      // Nếu người dùng chọn "Remember me"
//      if (rememberMe != null) {
//        Cookie cookie = new Cookie("rememberMe", "true");
//        cookie.setMaxAge(7 * 24 * 60 * 60); // Thời gian sống của cookie (đơn vị: giây), ví dụ 7 ngày
//        response.addCookie(cookie);
//      }
//      return "redirect:/home?success";
//    }
//    return "redirect:/login?passwordwrong";
//  }

}
