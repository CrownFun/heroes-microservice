package com.filewicz.creature.controller;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreatureRestAsuuredTest {

    public static final String JSON = "application/json";

    @BeforeClass
    public void setupConfiguration(){
        RestAssured.baseURI ="http://localhost:8089/";
        RestAssured.basePath = "api/creature";
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(JSON).build();
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    void example2(){

        String baseURI = RestAssured.baseURI;
        String baseURI1 = RestAssured.basePath;
        System.out.println("namiar baseURI : " +baseURI);
        System.out.println("baza basePath" + baseURI1);

        given().log().all()
                .pathParam("title", "Matrix")
                .when().get("/{Dzida}").then()
                .log().all()
                .statusCode(200);
    }

}
