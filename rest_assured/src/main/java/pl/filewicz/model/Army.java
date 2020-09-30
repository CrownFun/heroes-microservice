package pl.filewicz.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Army {

    private List<Creature> creaturesList;

    public Army(List<Creature> creaturesList) {
        this.creaturesList = creaturesList;
    }
}
