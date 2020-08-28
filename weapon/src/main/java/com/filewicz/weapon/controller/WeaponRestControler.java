package com.filewicz.weapon.controller;

import com.filewicz.weapon.model.Weapon;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WeaponRestControler {

    ResponseEntity<Weapon> getWeaponByName(String weaponName);

    ResponseEntity<List<Weapon>> getAllWeapons();

}
