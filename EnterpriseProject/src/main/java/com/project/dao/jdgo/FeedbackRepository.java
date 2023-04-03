package com.project.dao.jdgo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.jdgo.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}