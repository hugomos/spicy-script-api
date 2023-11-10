package com.hugomos.spicyscriptapi.usecase;

import com.hugomos.spicyscriptapi.dto.CreateRecipeDto;
import com.hugomos.spicyscriptapi.entity.Recipe;
import com.hugomos.spicyscriptapi.repository.RecipesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRecipe {

    @Autowired
    RecipesRepository recipesRepository;

    public String run(CreateRecipeDto dto){
        Recipe recipe = new Recipe(dto);
        recipesRepository.save(recipe);

        return recipe.getId();
    }
}
