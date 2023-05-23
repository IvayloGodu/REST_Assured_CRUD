package tests;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.JSONAssertion;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndPost {
    @Test
    public void testGet()
    {
        baseURI="https://reqres.in/api";
            given().
                get("/users?page=2").
            then().
                statusCode(200).
                body("data[0].last_name", equalTo("Lawson")).
                body("data.last_name", hasItems("Funke","Ferguson"));
    }
    @Test
    public void testPost()
    {
        Map<String, Object> map=new HashMap<String, Object>();
//       map.put("name","Ivaylo");
//       map.put("job","QA Tester");
//
//        System.out.println(map);

        JSONObject request = new JSONObject();
        request.put("name","Ivaylo");
        request.put("job","QA Tester");
        System.out.println(request.toJSONString());

        baseURI="https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
          when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }
}
