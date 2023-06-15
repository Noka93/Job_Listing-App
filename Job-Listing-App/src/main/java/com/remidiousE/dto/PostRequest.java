package com.remidiousE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String title;
    private String description;
    private String company;
    private String location;
    private String employmentType;
    private String industry;
    private String skillsRequired;
    private int experience;
    private String educationLevel;
}
