package pl.filewicz.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class Weapon {

    private long id;
    private String name;
    private int damage;
    private int fast;

    public Weapon(String name, int damage, int fast) {
        this.name = name;
        this.damage = damage;
        this.fast = fast;
    }
}
