package com.filewicz.weapon.init;

import com.filewicz.weapon.model.Weapon;
import com.filewicz.weapon.repository.WeaponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class WeaponDataInitializer {

    private final WeaponRepository weaponRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        List<Weapon> weapons = List.of(
                new Weapon("Miecz", 77, 70),
                new Weapon("Łuk", 45, 97),
                new Weapon("Kij", 12, 74),
                new Weapon("Maczuga", 85, 34),
                new Weapon("Dzida", 65, 58),
                new Weapon("Sztylet", 45, 90)
        );
        weaponRepository.saveAll(weapons);
    log.info("weapon init data succesfully added to database!");
    }
}
