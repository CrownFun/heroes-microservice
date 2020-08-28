package com.filewicz.combat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weapon {

    private String name;
    private int damage;
    private int fast;
}
