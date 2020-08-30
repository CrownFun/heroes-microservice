package com.filewicz.creature.controller.api;

import com.filewicz.creature.model.Creature;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CreatureRestController {

    ResponseEntity<Creature> getCreatureByName(String name);

    ResponseEntity<List<Creature>> getAllCreatures();

}
