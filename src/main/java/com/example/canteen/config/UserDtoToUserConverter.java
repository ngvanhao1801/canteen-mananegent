package com.example.canteen.config;

import com.example.canteen.dto.UserDto;
import com.example.canteen.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {

  @Override
  public User convert(UserDto userDto) {
    if (userDto == null) {
      return null;
    }

    User user = new User();
    user.setFullName(userDto.getFullName());
    user.setUserDisplayName(userDto.getUserDisplayName());

    return user;
  }
}