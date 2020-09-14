package com.filewicz.weapon.controller;

import com.filewicz.weapon.exception.WeaponNotFoundException;
import com.filewicz.weapon.model.Weapon;
import com.filewicz.weapon.service.WeaponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WeaponRestControllerImpl implements WeaponRestControler {


    private final WeaponService weaponService;

    @Override
    @GetMapping("/{weaponName}")
    public ResponseEntity<Weapon> getWeaponByName(@PathVariable("weaponName") String weaponName) {
        log.info("fetched weapon name " + weaponName);
        return Optional.ofNullable(weaponService.getWeaponByName(weaponName))
                .map(weapon -> new ResponseEntity<>(weapon, HttpStatus.OK))
                .orElseThrow(() -> new WeaponNotFoundException(weaponName));
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<Weapon>> getAllWeapons() {

        List<Weapon> allWeapons = weaponService.getAllWeapons();
        if (allWeapons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allWeapons, HttpStatus.OK);
    }
}
