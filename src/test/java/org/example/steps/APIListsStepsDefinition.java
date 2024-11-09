package org.example.steps;

import com.google.gson.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class APIListsStepsDefinition {
    String token = "pk_2144419997_FYG8LWOXN4N816EUCCV0E0YAGXF3LEUI";
    String url = "https://api.clickup.com/api/v2";
    String listId = "";

    @When("User sent a request to get all lists")
    public void getAllLists() {
        SerenityRest.given().baseUri(url)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .when()
                .get("/folder/90122619397/list?archived=false")
                .then().assertThat().statusCode(200);
    }

    //--------------------------------------------------------------------------
//    @When("User sent a request to get a list and list id")
//    public void getListsAndId() {
//        SerenityRest.given().baseUri(url)
//                .header("Authorization", token)
//                .header("Content-Type", "application/json")
//                .when()
//                .get("/folder/90122619397/list")
//                .then().assertThat().statusCode(200);
//    }

    //---------------------------------------------------------------------------

    //Add body to the script
//    @And("User sent a request to create a new list")
//    public void createNewList() {
//        SerenityRest.given().baseUri(url)
//                .header("Authorization", token)
//                .header("Content-Type", "application/json")
//                .when()
//                .post("/folder/90122754485/liste")
//                .then().assertThat().statusCode(200);
//    }

    @Then("User can sent a request to get all folderless lists")
    public void getAllFolderlessLists() {
        SerenityRest.given().baseUri(url)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .get("/space/90121459531/list").getBody().print();
    }

//    @And("User can sent a request to create a new folderless list")
//    public void createNewFolderlessList() {
//
//    }

    @When("User can extract all lists ids")
    public void getAllListsId() {
        String requestResponse = SerenityRest.given().baseUri(url)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .get("/folder/90122619397/list?archived=false")
                .then()
                .extract()
                .body()
                .asString();
        System.out.println(requestResponse);

        JSONObject response = new JSONObject(requestResponse);
        JSONArray listsArray = response.getJSONArray("lists");
        List<String> listIds = new ArrayList<>();

        // to get all lists id from response
        for (int i = 0; i < listsArray.length(); i++) {
            JSONObject list = listsArray.getJSONObject(i);
            listIds.add(list.getString("id"));
        }
        System.out.println(listIds);

        // to get only first list id from response
        JSONObject list = listsArray.getJSONObject(0);
        listId = list.getString("id");
        System.out.println("First list id in response -> "+ listId);
    }

    @When("User sent a request to get a list by it's id")
    public void getListById() {
        SerenityRest.given().baseUri(url)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .when()
                .get("/list/"+ listId)
                .then().assertThat().statusCode(200);
    }

    @Then("User can sent a request to update list by it's id")
    public void updateListById() {

    }

    @And("User can sent a request to delete list by it's id")
    public void deleteListById() {

    }

}
