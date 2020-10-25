package techproedbatch5;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.*;
public class GetRequest06 extends TestBase{
    /*
    * When I send a GET request to REST API URL
       https://restful-booker.herokuapp.com/booking/5
       Then HTTP Status Code should be 200
       And response content type is “application/JSON”
       And response body should be like;
       {
           “firstname”: “Sally”,
           “lastname”: “Ericsson”,
           “totalprice”: 111,
           “depositpaid”: false,
           “bookingdates”: {
               “checkin”: “2017-05-23",
               “checkout”: “2019-07-02"
            }
    */
    @Test
    public void get01(){
        Response response = given().
                spec(spec01).
                when().
                get("/booking/5");
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firsname", Matchers.equalTo("Susan"),
                        "lastname",Matchers.equalTo("Brown"),
                        "totalprice",Matchers.equalTo(496));
    }
}
