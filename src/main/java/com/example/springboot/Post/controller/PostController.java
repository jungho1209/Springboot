package com.example.springboot.Post.controller;

import com.example.springboot.Post.dto.request.PostRequest;
import com.example.springboot.Post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sing/up")
public class PostController {
    private final PostService postService;

    @PostMapping
    public void postEntity(@RequestBody @Valid PostRequest postRequest) throws Exception{
        postService.postEntity(postRequest);
    }
}
