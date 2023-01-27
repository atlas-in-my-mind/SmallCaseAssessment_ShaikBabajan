package Services;
import Pojos.Responses.Book;
import Utilities.ScenarioContext;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetBooksService extends BaseService {
    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private String method;
    private String url;

    public static ScenarioContext context = new ScenarioContext();

    public GetBooksService(String url, String method) throws IOException {
        super(url, method);
        this.url = url;
        this.method = method;
    }

    public Response callGetBooksAPI() {
        Response getBooksAPIResponse = (Response) ExecuteAPI();
        List<Book> books = getBooksAPIResponse.getBody().jsonPath().getList("books", Book.class);

        //Putting the Response details in Context Class to use it for any further steps
        context.put("GetBooksResponse", getBooksAPIResponse);
        context.put("BooksListFromPrevResp", books);

        //Printing out the Response
        System.out.println("********RESPONSE********");
        System.out.println("Body :");
        System.out.println(getBooksAPIResponse.getBody().asString());
        return getBooksAPIResponse;
    }

    public static List<Map> getBooksAsMapList(List<Book> ActualBooksList ) {
        List<Map> ActualDetails = new ArrayList<>();
        for (Book book : ActualBooksList) {
            Map<String, Object> map = new HashMap<>();
            map.put("isbn", book.getIsbn());
            map.put("title", book.getTitle());
            map.put("subTitle", book.getSubTitle());
            map.put("author", book.getAuthor());
            map.put("publish_date", book.getPublish_date());
            map.put("publisher", book.getPublisher());
            map.put("pages", book.getPages());
            map.put("description", book.getDescription());
            map.put("website", book.getDescription());
            ActualDetails.add(map);
        }
        return ActualDetails;
    }
}
