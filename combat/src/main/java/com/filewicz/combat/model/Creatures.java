package com.filewicz.combat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Creatures {

    private String name;
    private Integer quantity;
    private Integer attack;
    private Integer defense;
    private Integer health;
    private Integer minDamage;
    private Integer maxDamage;
}
