package org.Gluecode;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.BaseClass.APIEndpoints;
import org.CallRestAPI.CallRestAPI;
import org.Pages.Petbody;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class Restgluecode extends APIEndpoints {

    public static Response response;

    @Given ("All the parameters to hit rest API")
    public void AlltheparameterstohitrestAPI() {

        System.out.println(" Start Rest API");
    }

    @When("the Get API is called")
    public void theGetAPIiscalled() {

        response = CallRestAPI.CallGetAPI(APIEndpoints.getReqresURl());

        System.out.println("The Status Code From REST API is===> "+ response.getStatusCode());
        System.out.println("The Response Body From REST API is===> "+ response.body().asPrettyString());
    }

    @Then("Get valid response code from API")
    public void GetvalidresponsecodefromAPI(){

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Then("Validate All the Fields in The Response")
    public void ValidateAlltheFieldsinTheResponse() {

        int id = response.body().path("data[0].id");
        String email = response.body().path("data[0].email");
        String FirstName = response.body().path("data[0].first_name");
        String LastName = response.body().path("data[0].last_name");

        Assert.assertEquals(7, id);
        Assert.assertEquals("michael.lawson@reqres.in", email);
        Assert.assertEquals("Michael",FirstName );
        Assert.assertEquals("Lawson", LastName);

    }

    @Given("Prepare the parameters to hit API")
    public void PreparetheparameterstohitAPI () {

            System.out.println("======> Starting REST SERVICE API........!!!!!");

        }

        @When("the Post API is called")
    public void thePostAPIiscalled(){

        JSONObject obj = Petbody.Petbodydetails(343, "GERMAN SHEPARD", "available", "DOG", "https://petstore.swagger.io/PhotoURLs", "PET");

        response = CallRestAPI.CallPostAPI(APIEndpoints.getAddPettStoreUrl(), obj);
        System.out.println(response.asPrettyString());

        }

        @Then("Valid Response code from POST API")
    public void ValidResponsecodefromPOSTAPI(){
        Assert.assertEquals(200, response.getStatusCode());
        System.out.println("LOOK here-->" + response.getStatusCode());

    }

    @Then ("i validate all the reponse body")
    public void ivalidateallthereponsebody(){

        //Assert.assertEquals("343", Integer.valueOf(response.body().path("id")));
        Assert.assertEquals("DOG", response.body().path("category.name"));
        Assert.assertEquals("GERMAN SHEPARD", response.body().path("name"));
        Assert.assertEquals("https://petstore.swagger.io/PhotoURLs", response.body().path("photoUrls[0]"));
        Assert.assertEquals("PET", response.body().path("tags[0].name"));
        Assert.assertEquals("available", response.body().path("status"));
         }

}
