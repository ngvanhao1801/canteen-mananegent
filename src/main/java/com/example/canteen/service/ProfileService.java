package com.example.canteen.service;

import com.example.canteen.entity.Profile;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {
  void update(Profile profile);
}
