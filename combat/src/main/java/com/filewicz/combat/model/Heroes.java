package com.filewicz.combat.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Heroes {

    private String name;
    private Weapon weapon;
    private Army army;
    private Castle castle;

    public Heroes(String name, Weapon weapon, Army army, Castle castle) {
        this.name = name;
        this.weapon = weapon;
        this.army = army;
        this.castle = castle;
    }
}
