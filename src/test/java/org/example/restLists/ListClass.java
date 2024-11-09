package org.example.restLists;

import io.restassured.response.Response;

public class ListClass extends BaseClass{

    String getAllListsUrl = "/folder/90122619397/list";
    String getListsWithoutFolders = "/space/90121459531/list";
    String getListById = "/list/";

    public ListClass () {
        this.setUpRestAssured();
    }

    public Response getAllLists(){
        return this.requestSpecification.get(getAllListsUrl+"?archived=false");
    }

    public Response createNewListFromFile(String requestBody){
        return this.requestSpecification.body(requestBody).post(getAllListsUrl);
    }

    public Response getAllListsWithoutFolders(){
        return this.requestSpecification.get(getListsWithoutFolders);
    }

    public Response createListWithoutFolders(String requestBody){
        return this.requestSpecification.body(requestBody).post(getListsWithoutFolders);
    }

    public Response getListById(String listId){
        return this.requestSpecification.get(getListById + listId);
    }

    public Response updateListById(String requestBody, String listId){
        return this.requestSpecification.body(requestBody).put(getListById + listId);
    }

    public Response deleteList(String listId){
        return this.requestSpecification.delete(getListById + listId);
    }

}
