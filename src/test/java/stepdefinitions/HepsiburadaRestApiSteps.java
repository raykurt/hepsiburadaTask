package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class HepsiburadaRestApiSteps {

    RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://ec0b5215-8f25-4fd2-8deb-f10e6eee04da.mock.pstmn.io").build();
    Response response;
    Map<String,Object> actualData;

    @Given("user sends the GET request for grocery")
    public void user_sends_the_get_request_for_grocery() {
        spec.pathParam("first", "allGrocery");
        response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
    }

    @Then("validates get request for grocery")
    public void validates_get_request_for_grocery() {
        response.then().statusCode(200);
        actualData = response.as(HashMap.class);
        assertTrue(actualData.get("data").toString().contains("apple"));
        assertTrue(actualData.get("data").toString().contains("grapes"));
    }

    @Given("user sends the GET request for {string} grocery")
    public void user_sends_the_get_request_for_grocery(String fruit) {
        spec.pathParam("first","allGrocery").queryParam("name", fruit);
        response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
    }
    @Then("validates get request for {string} grocery")
    public void validates_get_request_for_grocery(String fruit) {
        response.then().statusCode(200);
        actualData = response.as(HashMap.class);
        assertTrue(actualData.get("data").toString().contains(fruit));
    }

    @Then("validates negative get request for banana grocery")
    public void validates_negative_get_request_for_banana_grocery() {
        response.
                then().
                assertThat().
                statusCode(404).
                body("message",equalTo("Not Found"));
    }

    @Given("user sends the POST request for {string}, {string}, {string}, {string}")
    public void user_sends_the_post_request_for(String id, String name, String price, String stock) {
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("id",id);
        expectedData.put("name",name);
        expectedData.put("price",price);
        expectedData.put("stock",stock);

        spec.pathParam("first", "add");
        response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();
    }

    @Then("validates post request for grocery")
    public void validates_post_request_for_grocery() {
        response.then().statusCode(201);
        actualData = response.as(HashMap.class);
        assertTrue(actualData.get("data").toString().contains("string"));
    }

    @Given("user sends the negative POST request for {string}, {string}, {string}, {string}")
    public void user_sends_the_negative_post_request_for(String id, String name, String price, String stock) {
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("id",id);
        expectedData.put("name",name);
        expectedData.put("price",price);
        expectedData.put("stock",stock);

        spec.pathParams("first", "add","second","negative");
        response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}/{second}");
        response.prettyPrint();
    }

    @Then("validates post request for negative grocery")
    public void validates_post_request_for_negative_grocery() {
        response.
                then().
                assertThat().
                statusCode(400).
                body("message",equalTo("Bad Request"));

    }
}
