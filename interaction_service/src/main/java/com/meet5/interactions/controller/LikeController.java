package com.meet5.interactions.controller;

import com.meet5.interactions.model.Like;
import com.meet5.interactions.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping
    public Like recordLike(@RequestBody Like like) {
        return likeService.recordLike(like);
    }

    @GetMapping("/{likerId}")
    public List<Like> getLikesByUser(@PathVariable Long likerId) {
        return likeService.getLikesByUserId(likerId);
    }
}
