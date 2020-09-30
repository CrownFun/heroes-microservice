package pl.filewicz.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@NoArgsConstructor
@Getter
public class Castle {

    private long id;
    private String name;
    private String description;

    public Castle(Town name, String description) {
        this.name = name.toString();
        this.description = description;
    }
}
