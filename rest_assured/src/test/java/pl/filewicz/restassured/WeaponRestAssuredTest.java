package pl.filewicz.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.filewicz.model.Weapon;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class WeaponRestAssuredTest {

    public static final String JSON = "application/json";

    @BeforeClass
    public void setupConfiguration() {
        RestAssured.baseURI = "http://localhost:8089/";
        RestAssured.basePath = "api/weapon";
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(JSON).build();
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    void getOneWeaponByNameTest() {
        String baseURI = RestAssured.baseURI;
        String baseURI1 = RestAssured.basePath;
        System.out.println("namiar baseUri: " + baseURI);
        System.out.println("baza basepath" + baseURI1);

        Weapon weapon = given().log().all()
                .pathParam("weaponName", "Miecz")
                .when().get("/{weaponName}")
                .then()
                .statusCode(200)
                .extract().as(Weapon.class);

        assertEquals(weapon.getName(), "Miecz");
        assertEquals(weapon.getDamage(), 77);
    }

    @Test
    void getAllWeapons() {
        String baseURI = RestAssured.baseURI;
        String baseURI1 = RestAssured.basePath;
        System.out.println("namiar baseUri: " + baseURI);
        System.out.println("baza basepath" + baseURI1);

        Weapon[] weapons = given().log().all()
                .when().get("/all")
                .then()
                .statusCode(200)
                .extract().as(Weapon[].class);

//        assertEquals(weapon.getName(), "Miecz");
        assertEquals(weapons.length, 6);
    }


}
