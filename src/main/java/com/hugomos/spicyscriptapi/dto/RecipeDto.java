package com.hugomos.spicyscriptapi.dto;

import com.hugomos.spicyscriptapi.entity.Recipe;

import java.time.LocalDateTime;

public record RecipeDto(String id, String title, String image, LocalDateTime createdIn) {
    public RecipeDto(Recipe recipe) {
        this(recipe.getId(), recipe.getTitle(), recipe.getImage(), recipe.getCreatedIn());
    }
}
