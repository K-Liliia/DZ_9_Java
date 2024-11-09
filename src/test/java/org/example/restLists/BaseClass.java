package org.example.restLists;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public abstract class BaseClass {
    private String token = "pk_2144419997_FYG8LWOXN4N816EUCCV0E0YAGXF3LEUI";
    private String url = "https://api.clickup.com/api/v2";

    protected RequestSpecification requestSpecification;

    public void setUpRestAssured () {
        this.requestSpecification = SerenityRest.given()
                .baseUri(this.url)
                .header("Authorization", token)
                .contentType(ContentType.JSON);
    }
}
