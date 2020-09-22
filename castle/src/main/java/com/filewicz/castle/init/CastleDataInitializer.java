package com.filewicz.castle.init;

import com.filewicz.castle.model.Castle;
import com.filewicz.castle.model.Town;
import com.filewicz.castle.repository.CastleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CastleDataInitializer {

    private final CastleRepository castleRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initCastle() {

        List<Castle> castles = List.of(
                new Castle(Town.TWIERDZA, "Zamek Twierdza to miejsce, gdzie spotkamy największych specjalistów od walki. Największy nacisk kładą na siłę ataku."),
                new Castle(Town.INFERNO, "Zamek Inferno to miasto położone w czeluści piekieł. Jego mieszkańcy są z natury bardzo źli. Inferno jest przeciwieństwem zamku Castle."),
                new Castle(Town.BASTION, "Zamek Bastion jest jednym z najlepszych w grze. Zamieszkiwany jest on przez istoty dobre i leśne"),
                new Castle(Town.CYTADELA, "Zamek Cytadela jest królestwem bagien. Jego mieszkańcy są z natury źli, choć nie tak bardzo jak obywatele Nekropolii czy Inferno."),
                new Castle(Town.ZAMEK, "Zamek Castle to jedyny zamek, w którym zamieszkają zwykli ludzie. W każdym innym są to bliżej nieokreślone kreatury."),
                new Castle(Town.NEKROPOLIA, "Zamek Nekropolia to królestwo nieumarłych. Niby wszystkie 9 zamków różni się od siebie, ale to właśnie Nekropolia jest najdziwniejsza. "));
        castleRepository.saveAll(castles);
        log.info("dodano dane startowe Castle!");

    }
}
