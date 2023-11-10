package com.hugomos.spicyscriptapi.repository;

import com.hugomos.spicyscriptapi.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecipesRepository extends JpaRepository<Recipe, String> {
}
