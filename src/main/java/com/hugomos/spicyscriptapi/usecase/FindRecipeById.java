package com.hugomos.spicyscriptapi.usecase;

import com.hugomos.spicyscriptapi.dto.RecipeDto;
import com.hugomos.spicyscriptapi.entity.Recipe;
import com.hugomos.spicyscriptapi.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindRecipeById {

    @Autowired
    RecipesRepository recipesRepository;

    public RecipeDto run(String id){
        Recipe recipe = recipesRepository.findById(id).orElseThrow();
        return new RecipeDto(recipe);
    }
}
