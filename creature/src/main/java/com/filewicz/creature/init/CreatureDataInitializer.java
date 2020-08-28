package com.filewicz.creature.init;

import com.filewicz.creature.model.Creature;
import com.filewicz.creature.repository.CreatureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreatureDataInitializer {

    private final CreatureRepository creatureRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        List<Creature> creatures = List.of(
                new Creature("Centaur",45,5,3,8,2,4),
                new Creature("Leśny Elf",29,9,5,15,3,5),
                new Creature("Zielony Smok",6,27,27,250,40,50),
                new Creature("Krzyżowiec",20,12,12,35,7,10),
                new Creature("Czempion",9,16,16,100,20,25),
                new Creature("Archanioł",6,30,30,250,50,50),
                new Creature("Cerber",23,10,8,25,2,7),
                new Creature("Ifryt",11,16,14,90,16,24),
                new Creature("Diabeł",7,26,28,200,30,40),
                new Creature("Wiwerna",11,14,14,70,18,22),
                new Creature("Hydra",7,18,20,250,25,45),
                new Creature("Bazyliszek",19,12,12,40,6,10),
                new Creature("Goblin",65,4,2,6,2,4),
                new Creature("Cyklop",17,17,13,70,16,20),
                new Creature("Behemot",7,19,19,300,30,50),
                new Creature("Gremlin",80,3,3,4,1,2),
                new Creature("Dżin",24,12,12,40,13,16),
                new Creature("Tytan",8,24,24,300,40,60),
                new Creature("Minotaur",13,15,15,50,12,20),
                new Creature("Chimera",17,16,14,80,14,20),
                new Creature("Czarny Smok",8,25,25,300,40,50),
                new Creature("Wampir",25,10,10,40,5,8),
                new Creature("Upiorny Rycerz",12,18,18,120,15,30),
                new Creature("Upiorny Smok",10,19,17,200,25,50)
        );
        creatureRepository.saveAll(creatures);
     log.info("init creatures data succesfully added!");
    }
}
