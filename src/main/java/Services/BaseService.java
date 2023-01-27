package Services;

import Pojos.Responses.Book;
import Utilities.ApiMethods;
import Utilities.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.List;

public class BaseService {

    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private String method;
    private String url;

    Response response;


    public BaseService(String url, String method) throws IOException {
        this.url = ReadProperties.getAPIUrl()+url;
        this.method = method;
    }

    public ResponseOptions<Response> ExecuteAPI() {
        RequestSpecification requestSpec = builder.build();
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.spec(requestSpec);
        System.out.println("********REQUEST********");
        System.out.println(method);
        System.out.println("URL: "+url);
        if (this.method.equalsIgnoreCase(ApiMethods.POST)) {
            response = request.post(this.url);
        } else if (this.method.equalsIgnoreCase(ApiMethods.DELETE)) {
            response = request.delete(this.url);
        } else if (this.method.equalsIgnoreCase(ApiMethods.GET)) {
            response = request.get(this.url);
        }
        return response;
    }
}
