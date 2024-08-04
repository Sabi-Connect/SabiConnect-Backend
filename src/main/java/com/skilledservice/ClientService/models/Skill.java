package com.skilledservice.ClientService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skillName;
    private String skillDescription;
    @ManyToOne
    private User skilledWorker;
    private String experience;
    private BigDecimal rate;
}
