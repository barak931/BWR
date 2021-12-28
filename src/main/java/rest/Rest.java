package rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import robot.Robot;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.when;

public class Rest {

    Logger logger = LogManager.getLogger("Rest Assured");


    public Rest(){
        RestAssured.useRelaxedHTTPSValidation();
    }

    public RestResponse getRequestRobot(String getUrl, Robot robot){
        Response response = when().request("GET",robot.getRobotUrl()+"/"+getUrl).then().statusCode(200).extract().response();
        return new RestResponse(response.getStatusCode(),response.asPrettyString());
    }

    /**
     * This function is meant to send a post request only i dont really have an end point
     * commented lines inside the function will perform the post function and return the reuiqred obj
     * @param requestBody
     * @param robot
     * @param passResponse -- This is only for the simulation purpose and ofcourse will not exist in the infra
     * @return RestResponse Obj
     */
    public RestResponse postRequestRobot(String requestBody, Robot robot,boolean passResponse){
        //This is the actual line to run when using Rest Assured
        //For demo purposes i will comment it and will return a custom response.

        /**
        //Response response = with().body(requestBody).when().request("POST",robot.getRobotUrl()).then().statusCode(200).extract().response();
        //return new RestResponse(response.getStatusCode(),response.asPrettyString());
        **/
        try {
            if (passResponse)
                return new RestResponse(200, FileUtils.readFileToString(new File(Rest.class.getResource("/customResponse/goodResponse.json").getFile()), "UTF-8"));
            else
                return new RestResponse(500, FileUtils.readFileToString(new File(Rest.class.getResource("/customResponse/badResponse.json").getFile()), "UTF-8"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return new RestResponse(200,"");
    }

    //TODO -- Continue implementing for all required request types (i.e put, Patch etc..)

}
