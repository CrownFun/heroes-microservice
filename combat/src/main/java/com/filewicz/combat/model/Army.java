package com.filewicz.combat.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Army {

    private List<Creatures> creaturesList;

    public Army(List<Creatures> creaturesList) {
        this.creaturesList = creaturesList;
    }
}
