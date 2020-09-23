package com.filewicz.combat.controller.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CombatRestControllerImplTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void fightTest() throws Exception {

        /** W związku  z tym że, Obiekty Heroes nie są zapisywane w bazie tylko na liście a MockMvc
            nie umozliwia strzeleania na zewnętrzne API wiec nie możliwe jest przetestowanie API Combat w prosty sposób.
            Nalezy powrócić do problemu po konwersji zapisu herosa do bazy danych.

            Narazie nie wiadomo kiedy to nastąpi bo jestem bardzo zajęty

         Musze napisać TESTY REST Assured i podpiąć Dokera i na koniec jeszcze Swaggera dodac wtedy jako tako będzie skończone.

         Dziś juz nie mam czasu bo msuze sie spakować i isć do sklepu bo jutro jade w Bieszczady

         Pogoda pewnie sie spierdoli na weekend

          nawet jeszce trasy nie zaplanowałem a już 20:41

         I jeszcze musze zatankowac jutro..


         **/
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("http://localhost:8087/create")
//                .param("heroesName", "Terykee")
//                .param("castleName", "Twierdza")
//                .param("weaponName", "Dzida")
//                .param("creature1", "Cyklop")
//                .param("creature2", "Behemot")
//                .param("creature3", "Goblin"))
//                .andExpect(status().isCreated());
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("http://localhost:8089/api/heroes/create")
//                .param("heroesName", "Bally")
//                .param("castleName", "Bastion")
//                .param("weaponName", "Dzida")
//                .param("creature1", "Cyklop")
//                .param("creature2", "Behemot")
//                .param("creature3", "Goblin"))
//                .andExpect(status().isCreated());

//        this.mockMvc.perform(get("/fight")
//                .param("heroes1", "Terykee")
//                .param("heroes2","Bally"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Pojdynek zakonczył się wynik to ")));


    }
}

