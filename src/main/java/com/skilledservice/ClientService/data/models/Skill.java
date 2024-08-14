package com.skilledservice.ClientService.data.models;

import com.skilledservice.ClientService.data.constants.Category;
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
    @ManyToOne
    private SkilledWorker skilledWorker;
//    private BigDecimal rate;
    @Enumerated(EnumType.STRING)
    private Category skillCategory;
}
