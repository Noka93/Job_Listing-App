package com.remidiousE.controller;

import com.remidiousE.controller.model.Post;
import com.remidiousE.dto.PostRequest;
import com.remidiousE.dto.PostResponse;
import com.remidiousE.exceptions.PostNotFoundException;
import com.remidiousE.repository.PostRepository;
import com.remidiousE.service.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PostController {
    @Autowired
    private PostServices postService;

    @PostMapping("/post")
    public PostResponse createPost(@RequestBody PostRequest post){
        PostResponse response = postService.createPost(post);
        return response;
    }

    @GetMapping("/find-post/{id}")
    public Optional<Post> findPostById(@PathVariable("id") Long id) throws PostNotFoundException {
        return postService.findById(id);
    }

    @GetMapping("/get-posts")
    public List<Post> findAllPost(){
        return postService.findAllPost();
    }

    @GetMapping("/post/{title}")
    public Optional<Post>findPostByTitle(@PathVariable("title") String title) throws PostNotFoundException {
        return postService.findPostByTitle(title);
    }

    @PutMapping("/update-post/{id}")
    public Post updatePost(@PathVariable("id") Long id, @RequestBody Post post) throws PostNotFoundException {
        return postService.updatePostById(id, post);
    }

    @DeleteMapping("delete/{id}")
    public String deletePost(@PathVariable("id") Long id){
        postService.deleteById(id);
        return "Post has been deleted successfully";
    }

}
