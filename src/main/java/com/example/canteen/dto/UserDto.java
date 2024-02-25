package com.example.canteen.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
  private String fullName;
  private String Email;
  private String UserDisplayName;
  private String Password;
  private String CheckPass;

  public UserDto(String email, String userDisplayName, String password) {
    Email = email;
    UserDisplayName = userDisplayName;
    Password = password;
  }
}
