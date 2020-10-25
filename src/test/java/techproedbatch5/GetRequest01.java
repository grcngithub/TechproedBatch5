package techproedbatch5;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
public class GetRequest01 {
    //Rest-Assured kulanarak API testing yapacagiz
    @Test
    public void getMethod01(){
        given().//rest assured den gelen method
                when().//when den sonra--get,post,put,patch, delete methodlari calistirilir
                //get("https://restful-booker.herokuapp.com/").// get in icine sadece end point yazilir
                        get("https://restful-booker.herokuapp.com/booking").
                then().//dogrulama demek
                assertThat().
                statusCode(200);
    }
    /// get ile aldigimiz data yi console da gormek istiyoruz
// gelen data yi bir konteyner icerisine alip yazdirmak gerekiyor , bunn icinde response kullanarak
// postman deki ciktinin aynisini elde edecegiz. Response body kismina yazilir
    @Test
    public  void getMethod02(){
        Response response=given().when().get("https://restful-booker.herokuapp.com/booking");
        //responde body console yazdirmk icin
        //response.prettyPrint();
        //
        System.out.println("status code: "+response.getStatusCode());
        System.out.println("Status Line: "+response.getStatusLine());
        //Headers kisminda content type yazdirilir. 1. yol
        System.out.println("Content type: "+response.getContentType());
        //2. yol
        System.out.println("Content Type2: "+response.header("Content-Type"));
        System.out.println(response.getHeaders());
        System.out.println(response.header("Date"));
        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8").statusLine("HTTP/1.1 200 OK");
    }
}