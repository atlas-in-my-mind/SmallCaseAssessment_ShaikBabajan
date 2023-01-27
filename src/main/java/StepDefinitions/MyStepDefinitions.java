package StepDefinitions;

import Pojos.Responses.Book;
import Services.GetBooksService;
import Utilities.ApiMethods;
import Utilities.ReadProperties;
import Utilities.ScenarioContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Services.GetBooksService.getBooksAsMapList;

public class MyStepDefinitions {

    @Given("I Get Books From ToolsQa BookStore")
        public void getBooks() throws IOException {
        String url = ReadProperties.getGetBooksUrl();
        GetBooksService getBooks = new GetBooksService(url, ApiMethods.GET);
        System.out.println("Getting All Books From API...");
        getBooks.callGetBooksAPI();
    }

    @Then("I Verify The DataTypes Of Each Field In Response As Below")
    public void iVerifyTheDataTypesOfEachFieldInResponseAsBelow(DataTable table) {
        System.out.println("********Asserting All DataTypes Of Book Details In Response********");
        List<Map<String, String>> ExpectedDetailsMaps = table.asMaps(String.class, String.class);
        Map<String, String> ExpectedDetails = ExpectedDetailsMaps.get(0);

        List<Book> ActualBooksList = (List<Book>) GetBooksService.context.get("BooksListFromPrevResp");

        //convert List of Books into a List of Maps containing all books details
        List<Map> ActualDetails = getBooksAsMapList(ActualBooksList);

        for(Map book: ActualDetails ){
            for (Map.Entry<String, String> entry : ExpectedDetails.entrySet()){
                Assert.assertEquals(entry.getValue(), book.get(entry.getKey()).getClass().getSimpleName());
            }
        }
        System.out.println("********All Assertions Got Passed********");
    }
}
