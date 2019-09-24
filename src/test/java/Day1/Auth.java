package Day1;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Auth {
	@Test(enabled=false)
	public void f() {
		given()
			.proxy("192.168.100.1", 8081)
			.auth()
			.oauth2("566548ff0281bbd59b15110307ca79ece59613f5")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/417/chickens-feed")
		.then()
			.statusCode(200);
	
	}
	
	
	@Test(enabled=true)
	public void f2() {

		/* Generating  Access Token with Server*/
		Response R=given()
						.proxy("192.168.100.1", 8081)
						.formParam("client_id", "DemoAPP")
						.formParam("client_secret", "47ee64e1c7c9dfff25a221e7fb72eac2")
						.formParam("grant_type", "client_credentials")
					.when()
						.post("http://coop.apps.symfonycasts.com/token");
		
		System.out.println(R.jsonPath().prettify());
		String token=R.jsonPath().get("access_token");
		System.out.println("Token is "+token);
		
		/*Using Generated Token */		
		given()
			.proxy("192.168.100.1", 8081)
			.auth()
			.oauth2(token)
		.when()
			.post("http://coop.apps.symfonycasts.com/api/417/chickens-feed")
		.then()
			.statusCode(200);
	}
}
