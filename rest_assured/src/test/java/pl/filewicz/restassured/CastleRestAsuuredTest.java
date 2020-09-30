package pl.filewicz.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.filewicz.model.Castle;
import pl.filewicz.model.Weapon;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CastleRestAsuuredTest {

    public static final String JSON = "application/json";

    @BeforeClass
    public void setupConfiguration() {
        RestAssured.baseURI = "http://localhost:8089/";
        RestAssured.basePath = "api/castle";
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(JSON).build();
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    void getOneCastleByNameTest() {
        String baseURI = RestAssured.baseURI;
        String baseURI1 = RestAssured.basePath;
        System.out.println("namiar baseUri: " + baseURI);
        System.out.println("baza basepath" + baseURI1);

        Castle weapon = given().log().all()
                .pathParam("castleName", "Twierdza")
                .when().get("/{castleName}")
                .then()
                .statusCode(200)
                .extract().as(Castle.class);

        assertEquals(weapon.getName(), "TWIERDZA");
    }

    @Test
    void getAllCastlesTest() {
        String baseURI = RestAssured.baseURI;
        String baseURI1 = RestAssured.basePath;
        System.out.println("namiar baseUri: " + baseURI);
        System.out.println("baza basepath" + baseURI1);

        Castle[] castles = given().log().all()
                .when().get("/all")
                .then()
                .statusCode(200)
                .extract().as(Castle[].class);

        assertEquals(castles.length, 6);
    }
}
