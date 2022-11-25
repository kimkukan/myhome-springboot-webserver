package com.kimkukan.springboot.web;

import com.kimkukan.springboot.service.post.PostService;
import com.kimkukan.springboot.web.dto.PostResponseDto;
import com.kimkukan.springboot.web.dto.PostSaveRequestDto;
import com.kimkukan.springboot.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/post/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }
}
