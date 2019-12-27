package stepDefinitions;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.common.net.HttpHeaders;

import io.restassured.response.Response;
import junit.framework.Assert;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class stepdefs {
	public static String URI;
	public static String jsonBody;

	@Given("^I make a GET call with URI \"([^\"]*)\" with endpoint \"([^\"]*)\" is provided$")
	public void i_make_a_call_with_URI_with_endpoint_is_provided( String arg1, String arg2) throws Throwable {
		URI=arg1.concat(arg2);
	    System.out.println("URI you entered to test is :"+URI);
	}
	@Then("^get  api should return \"([^\"]*)\" status code$")
	public void api_should_return_status_code(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("URI with endpoint "+URI);
		int InputStatusCode=Integer.parseInt(arg1);
	    Response response=get(URI);
	   // System.out.println("Response is "+response.asString());
	    System.out.println("Status code is " +response.statusCode());
	    Assert.assertEquals(InputStatusCode, response.statusCode());
	}

	@Given("^I make a POST call with URI \"([^\"]*)\" with endpoint \"([^\"]*)\"$")
	public void i_make_a_POST_call_with_URI_with_endpoint(String arg1, String arg2) throws Throwable {
		URI=arg1.concat(arg2);
	    System.out.println("URI you entered to test is :"+URI);
	}

	@Then("^provided following details Name : \"([^\"]*)\" Salary : \"([^\"]*)\" Age : \"([^\"]*)\" with OTP : \"([^\"]*)\"$")
	public void provided_following_details_Name_Phoneno_EmailID_with_OTP(String arg1, String arg2, String arg3, String arg4) throws Throwable {
	  jsonBody="{\"name\":\""+arg1+"\",\"salary\":\""+arg2+"\",\"age\":\""+arg3+"\"}";
	  System.out.println("\n\n" + jsonBody);
	}
	@Then("^post API should return \"([^\"]*)\" status code$")
	public void post_API_should_return_status_code(String arg1) throws Throwable {
		 HttpPost request = new HttpPost(URI);
		  StringEntity entity = new StringEntity(jsonBody);
		  request.addHeader("content-type", "application/json");
		  request.setEntity(entity);
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		  RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT).build();
		  RequestConfig localConfig = RequestConfig.copy(globalConfig).setCookieSpec(CookieSpecs.STANDARD).build();
		  request.setConfig(localConfig);
		  HttpResponse response = httpClient.execute(request);
		  System.out.println("Status code is " +response.getStatusLine().getStatusCode());
		  assertEquals(200, response.getStatusLine().getStatusCode());
	}

	
}
