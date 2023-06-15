package com.remidiousE.Mapper;

import com.remidiousE.controller.model.Post;
import com.remidiousE.dto.PostRequest;
import com.remidiousE.dto.PostResponse;

public class PostMapper {

    public static Post map(PostRequest postRequest){
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        post.setCompany(postRequest.getCompany());
        post.setLocation(postRequest.getLocation());
        post.setEmploymentType(postRequest.getEmploymentType());
        post.setIndustry(postRequest.getIndustry());
        post.setSkillsRequired(postRequest.getSkillsRequired());
        post.setExperience(postRequest.getExperience());
        post.setEducationLevel(postRequest.getEducationLevel());

        return post;
    }

    public static PostResponse map (Post post){
    PostResponse response = new PostResponse();
    response.setTitle(post.getTitle());
    response.setDescription(post.getDescription());
    response.setCompany(post.getCompany());
    response.setLocation(post.getLocation());
    response.setEmploymentType(post.getEmploymentType());
    response.setIndustry(post.getIndustry());
    response.setSkillsRequired(post.getSkillsRequired());
    response.setExperience(post.getExperience());
    response.setEducationLevel(post.getEducationLevel());

    return response;
    }
}
