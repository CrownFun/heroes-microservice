package com.filewicz.creature.service;

import com.filewicz.creature.model.Creature;

import java.util.List;

public interface CreatureService {

    Creature getCreatureByName(String name);

    List<Creature> getAllCreatures();

}
