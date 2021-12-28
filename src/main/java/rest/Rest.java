package rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import robot.Robot;

import static io.restassured.RestAssured.when;

public class Rest {

    Logger logger = LogManager.getLogger("Rest Assured");


    public Rest(){
        RestAssured.useRelaxedHTTPSValidation();
    }

    public RestResponse getRequestRobot(String requestBody, Robot robot){
        Response response = when().request("GET",robot.getRobotUrl()).then().statusCode(200).extract().response();
        return new RestResponse(response.getStatusCode(),response.asPrettyString());
    }

    public RestResponse postRequestRobot(String requestBody, Robot robot){
        Response response = when().request("POST",robot.getRobotUrl()).then().statusCode(200).extract().response();
        return new RestResponse(response.getStatusCode(),response.asPrettyString());
    }

    //TODO -- Continue implementing for all required request types (i.e put, Patch etc..)

}
