package Utilities;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    public static Map<String, Object> context;

    public ScenarioContext() {
        context = new HashMap<>();
    }

    public void put(String key, Object value) {
        context.put(key, value);
    }

    public Object get(String key) {
        return context.get(key);
    }

    public Response getResponse() {
        return (Response) context.get("response");
    }

    public void setResponse(Response response) {
        context.put("response", response);
    }
}
