package techproedbatch5;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.*;
public class GetRequest09 extends  TestBase{
    @Test
    public void get01(){
        Response response =given().
                spec(spec02).
                when().
                get();
        response.prettyPrint();
        //Json path objesi olusturunuz.
        JsonPath jsonPath=response.jsonPath();
        //Tum employee isimlerini consol a yazdiralim.
        System.out.println(jsonPath.getString("data.employee_name"));
        //   System.out.println(jsonPath.getList("data.employee_name"));
        // 2. iscinin isminin 'Garrett Winters' oldugunu 'verify' ediniz.
        assertEquals("isim istenildigi gibi degil","Garrett Winters",
                jsonPath.getString("data[1].employee_name")); //bu method hard assertion
        /*Soft assertion  icin 3 adimi takip etmek gerekir
            1)SoftAssert class indan bir obje (softAssert) uretilir
            2)Objeyi kullanarak assertion yapilir.
            3)SoftAssert.assertAll(); ile test bitirilir.
         */
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(jsonPath.getString("data[1].employee_name"),"Garrett Winters",
                "isim  istenildigi gibi degil");
        softAssert.assertAll();

        //Assertion hard test
        //verification 'verify' soft test

        //iscilerin arasinda 'Herrad Chandler' isminin var oldugunu 'verify' ediniz.


        softAssert.assertTrue(jsonPath.getString("data.employee_name")
                .contains ("Herrod Chandler"), "neredesin");

        //24 tane isci oldugunu 'verify' ediniz.

        softAssert.assertEquals(jsonPath.getList("data.id")
                .size (),24, "isci sayisi 24");


        softAssert.assertEquals(jsonPath.getString("data[6].employee_salary")
                ,"137500","maas verilen degere esit degil");






        softAssert.assertAll();


    }
}