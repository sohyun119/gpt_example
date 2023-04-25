package com.example.WeatherProjectGPT.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Diary {

    @Id
    private int id;
    private LocalDate date;
    private String weather;
    private String text;
    private double temperature;


}
