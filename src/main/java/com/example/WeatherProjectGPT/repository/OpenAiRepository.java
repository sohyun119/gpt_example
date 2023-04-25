package com.example.WeatherProjectGPT.repository;

import com.example.WeatherProjectGPT.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenAiRepository extends JpaRepository<Diary,Integer> {
}
