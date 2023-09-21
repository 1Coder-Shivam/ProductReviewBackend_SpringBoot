package com.nagarro.controller;

import com.nagarro.entity.Stats;
import com.nagarro.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StatsController {

    @Autowired
    StatsService service;

    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {
            Stats  stats = service.getStats();
            return ResponseEntity.ok(stats);
    }
}
