package com.filewicz.castle.service;

import com.filewicz.castle.model.Castle;
import com.filewicz.castle.model.Town;
import com.filewicz.castle.repository.CastleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CastleServiceImpl implements CastleSrvice {
    private final CastleRepository castleRepository;

    @Override
    public Castle getCastleByName(String name) {
        return castleRepository.findByName(name.toUpperCase());
    }

    @Override
    public List<Castle> getAllCastles() {
        return castleRepository.findAll();
    }
}
