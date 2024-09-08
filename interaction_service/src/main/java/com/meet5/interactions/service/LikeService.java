package com.meet5.interactions.service;

import com.meet5.interactions.model.Like;
import com.meet5.interactions.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public Like recordLike(Like like) {
        return likeRepository.save(like);
    }

    public List<Like> getLikesByUserId(Long userId) {
        return likeRepository.findAllByLikerId(userId);
    }
}
