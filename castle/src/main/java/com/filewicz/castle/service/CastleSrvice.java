package com.filewicz.castle.service;

import com.filewicz.castle.model.Castle;

import java.util.List;

public interface CastleSrvice {

    Castle getCastleByName(String name);
    List<Castle> getAllCastles();
}
