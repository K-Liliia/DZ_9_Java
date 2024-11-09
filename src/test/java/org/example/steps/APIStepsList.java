package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;
import utils.RandomData;
import utils.ResourceUtils;

import java.io.IOException;

public class APIStepsList extends BaseSteps {
    private static String listId = "";

    @Given("Sent request to get lists")
    public void getAllLists(){
        Response response = listClass.getAllLists();
        sharedTestData.setResponse(response);
    }

    @When("User create a new list from file {}")
    public void createNewListFromBody(String filePath) throws IOException {

        RandomData randomData = new RandomData();
        String listName = "My new list is " + randomData.generateRandomString(15);
        String listContent = "My new list content is: " + randomData.generateRandomString(20);
        String source = "data/lists/" + filePath;
        JSONObject body = ResourceUtils.readJson(source);
        body.put("name", listName);
        body.put("content", listContent);
        Response response =  listClass.createNewListFromFile(body.toString());
        sharedTestData.setResponse(response);
        System.out.println(response.getBody().asString());
        JSONObject responseBody = new JSONObject(response.getBody().asString());
        listId = responseBody.getString("id");
        System.out.println("Created List ID: " + listId);
    }

    @And("User send a request to get all lists without folders")
    public void getAllListsWithoutFolders(){
        Response response = listClass.getAllListsWithoutFolders();
        sharedTestData.setResponse(response);
    }

    @When("User send a request to create a new list without folders from file {}")
    public void createNewListWithoutFolderFromBody(String filePath) throws IOException {
        RandomData randomData = new RandomData();
        String listName = "My new list is " + randomData.generateRandomString(15);
        String listContent = "My new list content is: " + randomData.generateRandomString(20);
        String source = "data/lists/" + filePath;
        JSONObject body = ResourceUtils.readJson(source);
        body.put("name", listName);
        body.put("content", listContent);
        Response response =  listClass.createListWithoutFolders(body.toString());
        sharedTestData.setResponse(response);
    }

    @And("User send a request to get a list by it's Id")
    public void getListById(){
        System.out.println("List id is --------> " + listId);
        Response response = listClass.getListById(listId);
        sharedTestData.setResponse(response);
    }

    @When("User send a request to update a list from file {}")
    public void updateListFromBody(String filePath) throws IOException {
        RandomData randomData = new RandomData();
        String updatedlistName = "My new list is " + randomData.generateRandomString(15);
        String updatedlistContent = "My new list content is: " + randomData.generateRandomString(20);
        String source = "data/lists/" + filePath;
        JSONObject body = ResourceUtils.readJson(source);
        body.put("name", updatedlistName);
        body.put("content", updatedlistContent);
        Response response =  listClass.updateListById(body.toString(), listId);
        sharedTestData.setResponse(response);
    }

    @And("Sent request to delete a list")
    public void deleteList(){
        Response response = listClass.deleteList(listId);
        sharedTestData.setResponse(response);
    }
}
