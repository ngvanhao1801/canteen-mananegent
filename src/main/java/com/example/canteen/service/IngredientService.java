package com.example.canteen.service;

import com.example.canteen.dto.ProductDto;
import com.example.canteen.entity.Ingredient;
import com.example.canteen.entity.Product;
import com.example.canteen.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

  private final IngredientRepository ingredientRepository;

  public IngredientService(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  public List<Ingredient> getListIngredient() {
    return ingredientRepository.findAll();
  }

  public Ingredient getIngredientById(int id) {
    return ingredientRepository.findById(id).get();
  }

  public void save(Ingredient ingredient) {
    ingredientRepository.save(ingredient);
  }

  public void deleteById(int id) {
    ingredientRepository.deleteById(id);
  }
}
