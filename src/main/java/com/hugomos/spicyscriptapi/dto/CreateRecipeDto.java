package com.hugomos.spicyscriptapi.dto;


import jakarta.validation.constraints.NotBlank;

public record CreateRecipeDto(@NotBlank String title, String image) {
}
