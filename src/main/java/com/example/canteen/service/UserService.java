package com.example.canteen.service;

import com.example.canteen.dto.UserDto;
import com.example.canteen.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  void save(UserDto userDto);

  Boolean checkPasswordUser(String email, String password);

  Boolean checkUserByEmail(String email);

  User getUserByEmail(String email);
}
