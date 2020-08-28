package pl.filewicz.heroes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttackFactor {

    private int attack;
    private int defense;
}
