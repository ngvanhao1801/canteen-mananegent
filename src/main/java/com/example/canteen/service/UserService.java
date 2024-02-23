package com.example.canteen.service;

import com.example.canteen.dto.UserDto;
import com.example.canteen.entity.Profile;
import com.example.canteen.entity.User;
import com.example.canteen.repository.ProfileReponsitory;
import com.example.canteen.repository.UserReponsitory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserService {

	private final UserReponsitory userReponsitory;

	private final ProfileReponsitory profileReponsitory;

	public UserService(UserReponsitory userReponsitory, ProfileReponsitory profileReponsitory) {
		this.userReponsitory = userReponsitory;
		this.profileReponsitory = profileReponsitory;
	}

	public void save(UserDto userDto) {
		LocalDateTime Date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String creationDate = Date.format(formatter);
		User user = new User(userDto.getEmail(),
				userDto.getUserDisplayName(),
				".",
				0,
				0,
				userDto.getPassword(),
				creationDate,
				"ROLE_USER"
		);
		Profile profile = new Profile(
				"First Name",
				"Last Name",
				creationDate,
				"null",
				"Gender",
				"Address",
				user
		);
		userReponsitory.save(user);
		profileReponsitory.save(profile);
	}

	public Boolean checkPasswordUser(String email, String password) {
		User user = userReponsitory.findUserByEmail(email);
		return user.getPassword().equals(password);
	}

	public Boolean checkUserByEmail(String email) {
		User user = userReponsitory.findUserByEmail(email);
		return user != null;
	}

	public User getUserByEmail(String email) {
		return userReponsitory.getUserByEmail(email);
	}
}
