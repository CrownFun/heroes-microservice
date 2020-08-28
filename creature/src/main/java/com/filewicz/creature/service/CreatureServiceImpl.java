package com.filewicz.creature.service;

import com.filewicz.creature.model.Creature;
import com.filewicz.creature.repository.CreatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreatureServiceImpl implements CreatureService {

    private final CreatureRepository creatureRepository;

    @Override
    public Creature getCreatureByName(String name) {
        return creatureRepository.findByName(name);
    }

    @Override
    public List<Creature> getAllCreatures() {
        return creatureRepository.findAll();
    }
}
