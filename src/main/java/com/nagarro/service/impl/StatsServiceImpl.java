package com.nagarro.service.impl;

import com.nagarro.entity.Stats;
import com.nagarro.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatsServiceImpl implements StatsService {
    @Autowired
    private ReviewServiceImpl reviewServiceImpl;
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private UserServiceImpl registrationService;

    @Override
    public Stats getStats() {
        Stats stats = new Stats();
        stats.setCountUsers(registrationService.countAllRegistrated());
        stats.setCountReviews(reviewServiceImpl.countAllReview());
        stats.setCountPosts(productServiceImpl.countAllProduct());
        return stats;
    }
}
