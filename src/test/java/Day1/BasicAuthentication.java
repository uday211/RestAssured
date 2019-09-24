package Day1;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.ProxySpecification;


public class BasicAuthentication {
	
	@BeforeClass
	public void beforeClass()
	{
		//RestAssured.proxy=RestAssured.proxy(new ProxySpecification("192.168.100.1",8081));
		RestAssured.authentication=RestAssured.preemptive().basic("ToolsQA", "TestPassword");

	}
	
  @Test
  public void PreemptiveAuthentication ()
  {
	 /*  given()
	  		.proxy("192.168.100.1", 8081)
	  		.auth()
	  		.preemptive()
	  		.basic("ToolsQA", "TestPassword6")
	  .when()
	  		.get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
	  .then()
	  		.statusCode(200);
	 */
	  given()
		.proxy("192.168.100.1", 8081)
	  .when()
		.get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
	  .then()
		.statusCode(200);

  }
}
