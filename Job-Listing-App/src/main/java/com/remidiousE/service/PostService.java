package com.remidiousE.service;

import com.remidiousE.controller.model.Post;
import com.remidiousE.dto.PostRequest;
import com.remidiousE.dto.PostResponse;
import com.remidiousE.exceptions.PostNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PostResponse createPost(PostRequest post);
    Optional<Post> findById(Long id) throws PostNotFoundException;
    List<Post> findAllPost();
    Optional<Post> findPostByTitle(String title) throws PostNotFoundException;
    Post updatePostById(Long id, Post post) throws PostNotFoundException;
    void deleteById(Long id);
}
