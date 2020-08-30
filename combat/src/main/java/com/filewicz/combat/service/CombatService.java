package com.filewicz.combat.service;

import com.filewicz.combat.model.Creatures;
import com.filewicz.combat.model.Heroes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CombatService {

    private AttackFactor calculateHeroesFactor(Heroes heroes) {


        int totalAttack = 0;
        int totalDefense = 0;
        int damage = 0;
        int weaponDamage = heroes.getWeapon().getDamage();
        int quantity = 0;

        int obrazenia = 0;
        int odporonosc = 0;

        List<Creatures> creaturesList = heroes.getArmy().getCreaturesList();

        Random random = new Random();
        for (Creatures creatures : creaturesList) {
            totalAttack = totalDefense + creatures.getAttack();
            quantity = quantity + creatures.getQuantity();
            totalDefense = totalDefense + creatures.getDefense();
            damage = damage + (random.nextInt(creatures.getMaxDamage()-creatures.getMinDamage()) + (creatures.getMinDamage()+1));  // random between max-min
        }
        System.out.println("staty dla heroes " + heroes.getName());
        System.out.println("total atak " + totalAttack);
        System.out.println("total Defense " + totalDefense);
        System.out.println("quantity " + quantity);
        System.out.println("damage " + damage);
        System.out.println("bron " + weaponDamage);

        obrazenia = totalAttack + damage + weaponDamage;
        odporonosc = totalDefense + quantity;

        System.out.println("Suma obrazen " + obrazenia);
        System.out.println("Suma ode=prosnosci " + odporonosc);
        System.out.println("--------------------------------------------");
        return new AttackFactor(obrazenia, odporonosc);
    }

    public String fight(Heroes heroes1, Heroes heroes2) {

        AttackFactor heroes1FactorAttack = calculateHeroesFactor(heroes1);
        AttackFactor heroes2FactorAttack = calculateHeroesFactor(heroes2);

        int resultOfAttack = heroes1FactorAttack.getAttack() - heroes2FactorAttack.getAttack();
        int resultOfdefence = heroes1FactorAttack.getDefense() - heroes2FactorAttack.getDefense();

        int totalResult = resultOfAttack + resultOfdefence;

        String text = "Pojdynek zakonczył się wynik to " + totalResult;

        if (totalResult > 0) {
            return text + " Wygrał heroes " + heroes1.getName();
        }
        return text + " Wygrał heroes " + heroes2.getName();
    }

}
