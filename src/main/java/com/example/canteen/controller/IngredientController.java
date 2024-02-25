package com.example.canteen.controller;

import com.example.canteen.entity.Ingredient;
import com.example.canteen.repository.IngredientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IngredientController {

  private final IngredientRepository ingredientRepository;

  public IngredientController(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  private boolean isEdit = false;

  private String errorMessage = "";

  @GetMapping("/add_ingredient")
  public String addIngredient(Model model) {
    model.addAttribute("errorMessage", errorMessage);

    return "add_ingredient";
  }

  @GetMapping("/ingredients")
  public String getAllIngredients(Model model) {
    List<Ingredient> ingredients = ingredientRepository.findAll();
    model.addAttribute("ingredients", ingredients);
    return "ingredient_list";
  }

//  @GetMapping("/ingredientImage")
//  public ResponseEntity<?> getIngredientImage(@RequestParam("id") int id) {
//    Ingredient ingredient = ingredientRepository.findById(id);
//    byte[] imageData = ingredient.getImage();
//
//    return ResponseEntity.ok()
//        .contentType(MediaType.IMAGE_PNG)
//        .body(imageData);
//  }

  @PostMapping("/save_ingredient")
  public String saveIngredient(@ModelAttribute Ingredient ingredient, Model model) {
    errorMessage = "";
    if (!isEdit && ingredientRepository.existsById(ingredient.getId())) {
      isEdit = false;
      errorMessage = "Đã tồn tại id = " + ingredient.getId();
      model.addAttribute("ingredient", ingredient);
      return "redirect:/add_ingredient";
    }

    ingredientRepository.save(ingredient);
    return "redirect:/ingredients";
  }

  @RequestMapping("/editIngredient/{id}")
  public String editIngredient(@PathVariable("id") int id, Model model) {
    Ingredient ingredient = ingredientRepository.getIngredientById(id);
    model.addAttribute("ingredient", ingredient);

    isEdit = true;

    return "edit_ingredient";
  }

  @RequestMapping("/deleteIngredient/{id}")
  public String deleteIngredient(@PathVariable("id") int id) {
    ingredientRepository.deleteById(id);

    return "redirect:/ingredients";
  }

}
