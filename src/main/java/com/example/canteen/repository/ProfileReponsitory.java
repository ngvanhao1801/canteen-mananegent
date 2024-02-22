package com.example.canteen.repository;

import com.example.canteen.entity.Profile;
import com.example.canteen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProfileReponsitory extends JpaRepository<Profile, Integer> {
  Profile findProfileByUser(User user);

  Profile findProfileById(int id);
}
