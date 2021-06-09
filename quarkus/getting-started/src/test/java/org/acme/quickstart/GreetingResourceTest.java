package org.acme.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import java.util.UUID;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

  @Test
  public void testHelloEndpoint() {
    given()
        .when().get("/hello")
        .then()
        .statusCode(200)
        .body(is("hello\n"));
  }

  @Test
  public void testAsyncHelloEndpoint() {
    given()
        .when().get("/hello/async")
        .then()
        .statusCode(200)
        .body(is("hello\n"));
  }

  @Test
  public void testGreetingEndpoint() {
    String uuid = UUID.randomUUID().toString();
    given()
        .pathParam("name", uuid)
        .when().get("/hello/greeting/{name}")
        .then()
        .statusCode(200)
        .body(is("hello " + uuid + "\n"));
  }


}