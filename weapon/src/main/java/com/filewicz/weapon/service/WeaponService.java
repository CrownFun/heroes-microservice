package com.filewicz.weapon.service;

import com.filewicz.weapon.model.Weapon;

import java.util.List;

public interface WeaponService {

    Weapon getWeaponByName(String weaponName);
    List<Weapon> getAllWeapons();

}
