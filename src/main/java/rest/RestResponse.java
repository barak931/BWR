package rest;

public class RestResponse {

    private int statusCode;
    private String jsonResponse;

    public RestResponse(int statusCode, String jsonResponse) {
        this.statusCode = statusCode;
        this.jsonResponse = jsonResponse;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getJsonResponse() {
        return jsonResponse;
    }
}
