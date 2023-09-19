package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class SoapXMLRequest {
@Test
	public void validateSoapXML() throws IOException {
	
	File f = new File("C:\\QA\\Selenium_Workspace\\RestAssuredAPITesting\\SoapRequest\\Add.xml");
	if(f.exists())
		System.out.println("  >> File Exists");
	FileInputStream fp = new FileInputStream(f);
	String reqBody = IOUtils.toString(fp,"UTF-8");
	baseURI= "http://www.dneonline.com";
	given().contentType("text/xml")
	.accept(ContentType.XML)
	.body(reqBody)
	.when()
	.post("/calculator.asmx")
	.then()
	.statusCode(200).log().all()
	.and()
	.body("//*:AddResult.text()", equalTo("11"));
	}

}
