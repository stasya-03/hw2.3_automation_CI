package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostmanEchoTest {

    @Test
    void shouldReturnSentData() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Hi") // что мы отправляем
                .when().log().all()
                .post("/post")
                .then().log().all()
                .statusCode(200)
                .body("data", org.hamcrest.Matchers.equalTo("Hi")); // проверка JSONPath
    }
}
