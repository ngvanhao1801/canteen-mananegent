package com.example.canteen.repository;

import com.example.canteen.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

  Ingredient getIngredientById(int id);

}
