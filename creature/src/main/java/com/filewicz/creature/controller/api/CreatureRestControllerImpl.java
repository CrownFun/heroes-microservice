package com.filewicz.creature.controller.api;

import com.filewicz.creature.exceptions.CreatureNotFoundException;
import com.filewicz.creature.model.Creature;
import com.filewicz.creature.service.CreatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CreatureRestControllerImpl implements CreatureRestController {

    private final CreatureService creatureService;
    @Value("${info.property}")
    private String property;
    @Override
    @GetMapping("/{name}")
    public ResponseEntity<Creature> getCreatureByName(@PathVariable("name") String name) {
        return Optional.ofNullable(creatureService.getCreatureByName(name))
                .map(creature -> new ResponseEntity<>(creature, HttpStatus.OK))
                .orElseThrow(() -> new CreatureNotFoundException(name));
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<Creature>> getAllCreatures() {
        List<Creature> allCreatures = creatureService.getAllCreatures();
        if (allCreatures.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allCreatures, HttpStatus.OK);
    }
    @GetMapping("/message")
    String property() {
        return property;
    }
}
