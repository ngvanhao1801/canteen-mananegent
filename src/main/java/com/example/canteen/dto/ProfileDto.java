package com.example.canteen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfileDto implements Serializable {
  private String FirstName;
  private String LastName;
  private String DateofBirth;
  private String ImgUrl;
  private String Gender;
  private String Adress;
}