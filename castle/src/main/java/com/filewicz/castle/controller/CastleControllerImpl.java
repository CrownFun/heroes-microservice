package com.filewicz.castle.controller;

import com.filewicz.castle.exceptions.CastleNotFoundException;
import com.filewicz.castle.model.Castle;
import com.filewicz.castle.service.CastleServiceImpl;
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
@RequestMapping("/api/castle")
@RequiredArgsConstructor
@Slf4j
//localhost:8040/api/castle
public class CastleControllerImpl implements CastleController {

    private final CastleServiceImpl castleService;

    @Override
    @GetMapping("/{name}")
    public ResponseEntity<Castle> getCastleByName(@PathVariable("name") String name) {
        log.info("Fetched castle name " + name);
        Castle castleByName = castleService.getCastleByName(name);
        return Optional.ofNullable(castleService.getCastleByName(name))
                .map(castle -> new ResponseEntity<>(castle, HttpStatus.OK))
                .orElseThrow(() -> new CastleNotFoundException(name));
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<Castle>> getAllCastles() {
        List<Castle> allCastles = castleService.getAllCastles();
        if (allCastles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allCastles, HttpStatus.OK);
    }

}
