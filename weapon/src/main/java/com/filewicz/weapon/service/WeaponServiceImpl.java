package com.filewicz.weapon.service;

import com.filewicz.weapon.model.Weapon;
import com.filewicz.weapon.repository.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeaponServiceImpl implements WeaponService {

    private final WeaponRepository weaponRepository;

    @Override
    public Weapon getWeaponByName(String weaponName) {
        return weaponRepository.findByName(weaponName);
    }

    @Override
    public List<Weapon> getAllWeapons() {
        return weaponRepository.findAll();
    }
}
