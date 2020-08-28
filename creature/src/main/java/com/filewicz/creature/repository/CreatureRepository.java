package com.filewicz.creature.repository;

import com.filewicz.creature.model.Creature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureRepository extends JpaRepository<Creature,Long> {

    Creature findByName(String name);

}
