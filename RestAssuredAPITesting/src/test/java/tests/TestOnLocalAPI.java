package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestOnLocalAPI {
	@Test
	public void get() {
		baseURI = "http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();

	}

	@Test
	public void post() {
		JSONObject request = new JSONObject();
		request.put("first_name", "Rita");
		request.put("last_name", "Patel");
		request.put("subjectId", 1);

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.post("/users").then().statusCode(201).log().all();
	}

	@Test
	public void put() {
		JSONObject request = new JSONObject();
		request.put("first_name", "Shailesh");
		request.put("last_name", "Patel");
		request.put("subjectId", 2);

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.put("/users/4").then().statusCode(200).log().all();
	}

	@Test
	public void patch() {
		JSONObject request = new JSONObject();

		request.put("last_name", "Papa");

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.patch("/users/4").then().statusCode(200).log().all();
	}

	@Test
	public void delete() {
		baseURI = "http://localhost:3000";
		given().when().delete("/users/4").then().statusCode(200);
	}
}
