package com.filewicz.weapon.repository;

import com.filewicz.weapon.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon,Long> {

    Weapon findByName(String name);

}
