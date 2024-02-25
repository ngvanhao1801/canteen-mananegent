package com.example.canteen.controller;

import com.example.canteen.entity.Ingredient;
import com.example.canteen.entity.User;
import com.example.canteen.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  private boolean isEdit = false;

  private String errorMessage = "";

  @GetMapping("/add_user")
  public String addUser(Model model) {
    model.addAttribute("errorMessage", errorMessage);

    return "add_user";
  }

  @GetMapping("/users")
  public String getAllUser(Model model) {
    List<User> users = userRepository.findAll();
    model.addAttribute("users", users);
    return "user_list";
  }

  @PostMapping("/save_user")
  public String saveUser(@ModelAttribute User user, Model model) {
    errorMessage = "";
    if (userRepository.existsByEmail(user.getEmail())) {
      errorMessage = "Đã tồn tại email = " + user.getEmail();
      model.addAttribute("user", user);
      return "redirect:/add_user";
    }
    if (!isEdit && userRepository.existsById(user.getId())) {
      isEdit = false;
      errorMessage = "Đã tồn tại id = " + user.getId();
      model.addAttribute("user", user);
      return "redirect:/add_user";
    }

    if (!isEdit && userRepository.existsByEmail(user.getEmail())) {
      isEdit = false;
      errorMessage = "Đã tồn tại email = " + user.getEmail();
      model.addAttribute("user", user);
      return "redirect:/add_user";
    }

    userRepository.save(user);
    return "redirect:/users";
  }

  @RequestMapping("/editUser/{id}")
  public String editUser(@PathVariable("id") int id, Model model) {
    User user = userRepository.getUserById(id);
    model.addAttribute("user", user);

    isEdit = true;

    return "edit_user";
  }

  @RequestMapping("/deleteUser/{id}")
  public String deleteUser(@PathVariable("id") int id) {
    userRepository.deleteById(id);

    return "redirect:/users";
  }

  //  @GetMapping("/userImage")
//  public ResponseEntity<?> getUserImage(@RequestParam("id") int id) {
//    User user = userRepository.findById(id);
//    byte[] imageData = user.getImage();
//
//    return ResponseEntity.ok()
//        .contentType(MediaType.IMAGE_PNG)
//        .body(imageData);
//  }

}
