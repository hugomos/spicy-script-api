package com.hugomos.spicyscriptapi.controller;

import com.hugomos.spicyscriptapi.dto.CreateRecipeDto;
import com.hugomos.spicyscriptapi.dto.RecipeDto;
import com.hugomos.spicyscriptapi.usecase.CreateRecipe;
import com.hugomos.spicyscriptapi.usecase.FindRecipeById;
import com.hugomos.spicyscriptapi.usecase.ListAllRecipes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipesController {

    @Autowired
    ListAllRecipes listAllRecipesUseCase;

    @Autowired
    CreateRecipe createRecipeUseCase;

    @Autowired
    FindRecipeById findRecipeByIdUseCase;

    @GetMapping("")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<RecipeDto>> listAll(){
        try {
            var recipeDtos = listAllRecipesUseCase.run();
            return ResponseEntity.ok().body(recipeDtos);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<RecipeDto> findById(@PathVariable String id){
        try {
            RecipeDto recipeDto = findRecipeByIdUseCase.run(id);
            return ResponseEntity.ok().body(recipeDto);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> create(@RequestBody @Valid CreateRecipeDto dto){
        try {
            String recipeId = createRecipeUseCase.run(dto);
            return ResponseEntity.ok().body(recipeId);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
