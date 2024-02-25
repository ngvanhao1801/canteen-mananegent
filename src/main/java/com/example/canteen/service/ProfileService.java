package com.example.canteen.service;

import com.example.canteen.entity.Profile;
import com.example.canteen.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

  private final ProfileRepository profileRepository;

  public ProfileService(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }

  public void update(Profile profile) {
    profileRepository.save(profile);
  }

}
