package com.remidiousE.service;

import com.remidiousE.Mapper.PostMapper;
import com.remidiousE.controller.model.Post;
import com.remidiousE.dto.PostRequest;
import com.remidiousE.dto.PostResponse;
import com.remidiousE.exceptions.PostNotFoundException;
import com.remidiousE.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServices implements PostService{

    @Autowired
    private PostRepository postRepository;
    @Override
    public PostResponse createPost(PostRequest post) {
        Post newPost = PostMapper.map(post);
        Post savedPost = postRepository.save(newPost);

        return PostMapper.map(savedPost);
    }
    @Override
    public Optional<Post> findById(Long id) throws PostNotFoundException {
        Optional<Post> foundPost = postRepository.findById(id);
        if (foundPost.isPresent()) return foundPost;
        else throw new PostNotFoundException("Post with ID " + id + "not found");
    }
    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findPostByTitle(String title) throws PostNotFoundException {
        Optional<Post> postTitle = postRepository.findByTitle(title);
        if (postTitle.isPresent()) return postTitle;
        else throw new PostNotFoundException("Post with title not found");
    }
    @Override
    public Post updatePostById(Long id, Post post) throws PostNotFoundException {
        Optional<Post>existingPost = postRepository.findById(id);
        if (existingPost.isEmpty()) throw new PostNotFoundException("Post not found");
        Post foundPost = existingPost.get();
        if (post.getTitle() == null || !post.getTitle().isEmpty())
            foundPost.setTitle(post.getTitle());
        if (post.getDescription() == null || !post.getDescription().isEmpty())
            foundPost.setDescription(post.getDescription());

        return postRepository.save(foundPost);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
