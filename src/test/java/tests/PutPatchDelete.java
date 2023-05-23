package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class PutPatchDelete {

    @Test
    public void testPut()
    {
        JSONObject request = new JSONObject();
        request.put("name","Ivaylo");
        request.put("job","QA Tester");
        System.out.println(request.toJSONString());

        baseURI="https://reqres.in";
                given().
                  header("Content-Type","application/json").
                  contentType(ContentType.JSON).
                  accept(ContentType.JSON).
                  body(request.toJSONString()).
                when().
                  put("/api/users/2").
                then().
                  statusCode(200).
                  log().all();
    }
    @Test
    public void testPach()
    {
        JSONObject request = new JSONObject();
        request.put("name","Ivaylo");
        request.put("job","QA Tester");
        System.out.println(request.toJSONString());

        baseURI="https://reqres.in";
                given().
                  header("Content-Type","application/json").
                  contentType(ContentType.JSON).
                  accept(ContentType.JSON).
                  body(request.toJSONString()).
                when().
                  patch("/api/users/2").
                then().
                  statusCode(200).
                  log().all();
    }
    @Test
    public void testDelete()
    {
        baseURI="https://reqres.in";

                when().
                  delete("/api/users/2").
                then().
                  statusCode(204).
                log().all();
    }
}
