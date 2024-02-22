package com.example.canteen.controller.user_login_logout_registration;

import com.example.canteen.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@AllArgsConstructor
@SessionAttributes("userDto")
public class LogoutController {

  @ModelAttribute("userDto")
  public UserDto userDto() {
    return new UserDto();
  }

  @GetMapping("/logout")
  public String Logout(@ModelAttribute("userDto") UserDto userDto, WebRequest request, SessionStatus status) {
//        Xóa session user ra khỏi vị trí
    status.setComplete();// đã hoàn thành
    request.removeAttribute("userDto", WebRequest.SCOPE_SESSION);
    return "redirect:/login";
  }
}
