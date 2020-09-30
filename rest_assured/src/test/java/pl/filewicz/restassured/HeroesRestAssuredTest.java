package pl.filewicz.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.filewicz.model.Castle;
import pl.filewicz.model.Heroes;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class HeroesRestAssuredTest {

    public static final String JSON = "application/json";
    public String heroesName = UUID.randomUUID().toString().substring(1,5);

    @BeforeClass
    public void setupConfiguration() {
        RestAssured.baseURI = "http://localhost:8089/";
        RestAssured.basePath = "api/heroes";
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(JSON).build();
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    void createHeroesTest() {
        given()
                .queryParam("heroesName", heroesName)
                .queryParam("castleName", "Twierdza")
                .queryParam("weaponName", "Dzida")
                .queryParam("creature1", "Wiwerna")
                .queryParam("creature2", "Chimera")
                .queryParam("creature3", "Centaur")
                .when()
                .post("/create")
                .then()
                .statusCode(201);
    }

    @Test
    void getOneCastleByNameTest() {
        Heroes weapon = given().log().all()
                .pathParam("heroesName", heroesName)
                .when().get("/{heroesName}")
                .then()
                .statusCode(200)
                .extract().as(Heroes.class);

        assertEquals(weapon.getName(), heroesName);
        assertEquals(weapon.getCastle().getName(), "TWIERDZA");
        assertEquals(weapon.getWeapon().getName(), "Dzida");
    }

}
