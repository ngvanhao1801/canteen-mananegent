package com.example.canteen.service;

import com.example.canteen.dto.UserDto;
import com.example.canteen.entity.Profile;
import com.example.canteen.entity.User;
import com.example.canteen.repository.ProfileRepository;
import com.example.canteen.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserService {

	private final UserRepository userRepository;

	private final ProfileRepository profileRepository;

	public UserService(UserRepository userRepository, ProfileRepository profileRepository) {
		this.userRepository = userRepository;
		this.profileRepository = profileRepository;
	}

	public void save(UserDto userDto) {
		LocalDateTime Date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String creationDate = Date.format(formatter);
		User user = new User(userDto.getEmail(),
				userDto.getFullName(),
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
		userRepository.save(user);
		profileRepository.save(profile);
	}

	public Boolean checkPasswordUser(String email, String password) {
		User user = userRepository.findUserByEmail(email);
		return user.getPassword().equals(password);
	}

	public Boolean checkUserByEmail(String email) {
		User user = userRepository.findUserByEmail(email);
		return user != null;
	}

	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}
}
