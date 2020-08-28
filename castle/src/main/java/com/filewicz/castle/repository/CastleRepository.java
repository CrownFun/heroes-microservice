package com.filewicz.castle.repository;

import com.filewicz.castle.model.Castle;
import com.filewicz.castle.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastleRepository extends JpaRepository<Castle,Long> {

    Castle findByName(String name);
}
