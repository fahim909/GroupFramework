package JSONServer;

import com.mongodb.util.JSON;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class PostsResource {
/*
    note: in order to have a api that excepts put/post/delete operations a local JSON server
    has to be installed and running in order for these tests to work. please refer to the following
    site for installation instructions.
 */
    @Test
    public void postTest() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", 91);
        jsonObject.put("title", "juned");
        jsonObject.put("author", "QA");

        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/posts");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    @Test
    public void deletePost() {
        RequestSpecification request = RestAssured.given();

        Response response = request.delete("http://localhost:3000/posts/82");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    public void putPost() {
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 75);
        jsonObject.put("title", "Huckleberry Fin");
        jsonObject.put("author", "Homer Simpson");

        request.body(jsonObject.toJSONString());


        Response response = request.put("http://localhost:3000/posts/75");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    public void putNullPost() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();


        jsonObject.put("id", 999);
        jsonObject.put("title", "Huckleberry Fin");
        jsonObject.put("author", "Homer Simpson");

        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/posts/999");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);
    }
}
