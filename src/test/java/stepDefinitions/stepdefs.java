package stepDefinitions;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import junit.framework.Assert;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class stepdefs {
	public static String URI;

	@Given("^I make a \"([^\"]*)\" call with URI \"([^\"]*)\" with endpoint \"([^\"]*)\" is provided$")
	public void i_make_a_call_with_URI_with_endpoint_is_provided(String arg1, String arg2, String arg3) throws Throwable {
		URI=arg2.concat(arg3);
	    System.out.println("URI you entered to test is :"+URI);
	}
	@Then("^api should return \"([^\"]*)\" status code$")
	public void api_should_return_status_code(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("URI with endpoint "+URI);
		int InputStatusCode=Integer.parseInt(arg1);
	    Response response=get(URI);
	   // System.out.println("Response is "+response.asString());
	    System.out.println("Status code is " +response.statusCode());
	    Assert.assertEquals(InputStatusCode, response.statusCode());
	}


}
