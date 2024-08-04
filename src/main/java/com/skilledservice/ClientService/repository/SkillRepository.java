package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Skill findSkillById(Long id);
    @Query("select skill Skill from Skill skill where skill.skilledWorker.id=:skilledWorkerId")
    List<Skill> findSkillBySkillWorkerId(Long skilledWorkerId);
}
