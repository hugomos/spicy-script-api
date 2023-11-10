package com.hugomos.spicyscriptapi.entity;

import com.hugomos.spicyscriptapi.dto.CreateRecipeDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "recipes")
@Table(name = "recipes")
@EqualsAndHashCode(of = "id")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    private String image;

    @Column(name = "created_in", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdIn;

    @PrePersist
    protected void onCreate(){
        this.createdIn = LocalDateTime.now();
    }

    public Recipe(CreateRecipeDto dto){
        this.title = dto.title();
        this.image = dto.image();
    }

}
