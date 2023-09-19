package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TestsExample {

	@Test
	public void test_1() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		int response_code = response.getStatusCode();
		Assert.assertEquals(response_code, 200);
	}

	@Test
	public void test_2() {
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then()
		.statusCode(200).body("data[1].id",equalTo(8))
		.log().all();

	}
}
