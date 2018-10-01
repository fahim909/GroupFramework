package OpenWeatherMap;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequestTest {

    public static String url = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

    @Test
    public void testResponseCode(){
        int status = get(url).getStatusCode();
        Assert.assertEquals(status,200);
    }

    @Test
    public void testResponseTime(){
        long time = get(url).getTime();
        Assert.assertTrue(time > 0.0);
    }

//    @Test
//    public void testResponseSize(){
//
//    }
}
