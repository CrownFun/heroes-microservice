package pl.filewicz.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
public class Creature {

    private long id;
    private String name;
    private Integer quantity;
    private Integer attack;
    private Integer defense;
    private Integer health;
    private Integer minDamage;
    private Integer maxDamage;

    public Creature(String name, Integer quantity, Integer attack, Integer defense, Integer health, Integer minDamage, Integer maxDamage) {
        this.name = name;
        this.quantity = quantity;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
}
