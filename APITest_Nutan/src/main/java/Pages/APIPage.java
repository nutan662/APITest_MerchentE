package Pages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class APIPage {
    Payload payload = new Payload();

    public void verifyGetAPI() {
        RestAssured.baseURI = "https://reqres.in/";

        String response = given().log().all().when().get("/api/users?page=2").then().extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response); //for parsing Json
        String firstName = js.getString("data[0].first_name");
        Assert.assertEquals(firstName, "Michael");
    }

    public void verifyPostAPI() {
        RestAssured.baseURI = "https://reqres.in/";

        String response = given().log().all().header("Content-Type", "application/json")
                .body(payload.createUser()).when().post("/api/users")
                .then().extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response); //for parsing Json
        String job = js.getString("job");
        Assert.assertEquals(job, "leader");
    }

    public void verifyPutAPI() {
        RestAssured.baseURI = "https://reqres.in/";

        String response = given().log().all().header("Content-Type", "application/json")
                .body(payload.updateUser()).when().put("/api/users/2")
                .then().extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response); //for parsing Json
        String job = js.getString("job");
        Assert.assertEquals(job, "zion resident");
    }

    public void verifyDeleteAPI() {
        RestAssured.baseURI = "https://reqres.in/";

        Response response = given().log().all().when().delete("/api/users/2").then().extract().response();

        System.out.println(response);
        Assert.assertEquals(response.getStatusCode(), 204);
    }

}
