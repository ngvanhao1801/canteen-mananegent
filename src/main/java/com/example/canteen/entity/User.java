package com.example.canteen.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Table(name = "dbo_users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "full_name", nullable = false)
  private String fullName;

  @Column(name = "user_display_name", nullable = true)
  private String userDisplayName;

  @Column(name = "about_me", nullable = true)
  private String aboutMe;

  @Column(name = "views", nullable = true)
  private int views;

  @Column(name = "topic_counts", nullable = true)
  private int topicCounts;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "creation_date", nullable = false)
  private String creationDate;

  @Column(name = "role", nullable = false)
  private String role;

  public User(String email, String fullName, String userDisplayName, String aboutMe, int views, int topicCounts, String password, String creationDate, String role) {
    this.email = email;
    this.fullName = fullName;
    this.userDisplayName = userDisplayName;
    this.aboutMe = aboutMe;
    this.views = views;
    this.topicCounts = topicCounts;
    this.password = password;
    this.creationDate = creationDate;
    this.role = role;
  }

}
