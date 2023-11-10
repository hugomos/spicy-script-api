package com.hugomos.spicyscriptapi.usecase;

import com.hugomos.spicyscriptapi.dto.RecipeDto;
import com.hugomos.spicyscriptapi.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllRecipes {

    @Autowired
    private RecipesRepository recipesRepository;

    public List<RecipeDto> run(){
        return recipesRepository.findAll().stream().map(RecipeDto::new).toList();
    }
}
