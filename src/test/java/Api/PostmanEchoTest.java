package Api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    @Test
    public void PostmanEchoGetTest(){
        RestAssured.baseURI = "https://postman-echo.com";
                 given()
                .param("sendrequest", "getresponse")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args.sendrequest", equalTo("getresponse"));
    }
    @Test
    public void PostmanEchoPostRawTextTest(){
        RestAssured.baseURI = "https://postman-echo.com";
        JSONObject person = new JSONObject()
                .put("name", "Miha")
                .put("age", "18")
                .put("hobby", "sport");

                 given()
                .body(person.toString())
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data.", containsString("Miha"))
                .body("data", containsString("18"))
                .body("data", containsString("sport"));
    }
    @Test
    public void PostmanEchoPostFormDataTest() {
        RestAssured.baseURI = "https://postman-echo.com";
        JSONObject person1 = new JSONObject()
                .put("name", "Miha")
                .put("age", "18")
                .put("hobby", "sport");


                 given().body(person1.toString())
                .body(person1.toString())
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", containsString("Miha"))
                .body("data", containsString("18"))
                .body("data", containsString("sport"));
    }
    @Test
    public void PostmanEchoPostPutTest() {
        RestAssured.baseURI = "https://postman-echo.com";

                 given()
                .param("sendrequest", "getresponse")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args.sendrequest", equalTo("getresponse"));
    }
    @Test
    public void PostmanEchoPostPatchTest() {
        RestAssured.baseURI = "https://postman-echo.com";
                 given()
                .param("sendrequest", "getresponse")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args.sendrequest", equalTo("getresponse"));
    }
    @Test
    public void PostmanEchoPostDeleteTest() {
        RestAssured.baseURI = "https://postman-echo.com";
                 given()
                .param("sendrequest", "getresponse")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args.sendrequest", equalTo("getresponse"));
    }
}
