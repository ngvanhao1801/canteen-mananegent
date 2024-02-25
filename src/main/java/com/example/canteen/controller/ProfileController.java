package com.example.canteen.controller;

import com.example.canteen.dto.ProfileDto;
import com.example.canteen.dto.UserDto;
import com.example.canteen.entity.Profile;
import com.example.canteen.entity.User;
import com.example.canteen.repository.ProfileRepository;
import com.example.canteen.service.ProfileService;
import com.example.canteen.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("userDto")
public class ProfileController {
  private final UserService userService;

  private final ProfileService profileService;

  private final ProfileRepository profileRepository;

  public ProfileController(UserService userService, ProfileService profileService, ProfileRepository profileRepository) {
    this.userService = userService;
    this.profileService = profileService;
    this.profileRepository = profileRepository;
  }

  @ModelAttribute("userDto")
  public UserDto userDto() {
    return new UserDto();
  }

  @ModelAttribute("profileUser")
  public ProfileDto profileDto() {
    return new ProfileDto();
  }

  @GetMapping("/profile")
  public String showProfile(@ModelAttribute("userDto") User user,
                            Model model) {
//    if (userService.getUserByEmail(user.getEmail()) == null) {
//      return "redirect:/login";
//    }
    model.addAttribute("user", user);
    Profile profile = profileRepository.findProfileByUser(user);
    model.addAttribute("profile", profile);
    return "profile";
  }

  @PostMapping("/profile/{id}")
  public String getProfile(@SessionAttribute("userDto") UserDto userDto,
                           @PathVariable String id,
                           Model model,
                           @ModelAttribute("profile") ProfileDto profileDto) {
    Profile profileUpdate = profileRepository.findProfileById(Integer.parseInt(id));
    profileUpdate.setAdress(profileDto.getAdress());
    profileUpdate.setDateofBirth(profileDto.getDateofBirth());
    profileUpdate.setGender(profileDto.getGender());
    profileUpdate.setFirstName(profileDto.getFirstName());
    profileUpdate.setLastName(profileDto.getLastName());
    profileService.update(profileUpdate);
    return "redirect:/profile";
  }
}