package pl.filewicz.heroes.controller.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HeroesRestControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    //http://localhost:8087/api/heroes/create?heroesName=Kosiarz&castleName=LOCHY&weaponName=Miecz&creature1=Cyklop&creature2=Behemot&creature3=Goblin
    public void createHeroesTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/create")
                .param("heroesName", "Kosiarz")
                .param("castleName", "Twierdza")
                .param("weaponName", "Dzida")
                .param("creature1", "Cyklop")
                .param("creature2", "Behemot")
                .param("creature3", "Goblin"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void createHeroesAndgetByNametest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/create")
                .param("heroesName", "Benq")
                .param("castleName", "Twierdza")
                .param("weaponName", "Dzida")
                .param("creature1", "Cyklop")
                .param("creature2", "Behemot")
                .param("creature3", "Goblin"))
                .andDo(print())
                .andExpect(status().isCreated());

        this.mockMvc.perform(get("/Benq"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Benq")));

    }


    @Test
    public void createHeroesAndGetAllTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/create")
                .param("heroesName", "Benq1")
                .param("castleName", "Twierdza")
                .param("weaponName", "Dzida")
                .param("creature1", "Cyklop")
                .param("creature2", "Behemot")
                .param("creature3", "Goblin"))
                .andExpect(status().isCreated());

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/create")
                .param("heroesName", "Benq2")
                .param("castleName", "Bastion")
                .param("weaponName", "Dzida")
                .param("creature1", "Cyklop")
                .param("creature2", "Behemot")
                .param("creature3", "Goblin"))
                .andExpect(status().isCreated());

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/create")
                .param("heroesName", "Benq3")
                .param("castleName", "Zamek")
                .param("weaponName", "Dzida")
                .param("creature1", "Cyklop")
                .param("creature2", "Behemot")
                .param("creature3", "Goblin"))
                .andExpect(status().isCreated());

        this.mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(5)));

    }


}