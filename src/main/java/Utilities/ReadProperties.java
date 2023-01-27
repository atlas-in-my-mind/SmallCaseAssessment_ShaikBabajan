package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    static Properties properties = new Properties();

    public ReadProperties() {
    }

    public static String getProperty(String key) throws IOException {
        InputStream input = new FileInputStream("src/config.properties");
        properties.load(input);
        return properties.getProperty(key);
    }

    public static String getAPIUrl() throws IOException {
        String BaseUrl = getProperty("APIURL");
        return BaseUrl;
    }

    public static String getGetBooksUrl() throws IOException {
        String GetBooksUrl = getProperty("GetBooksUrl");
        return GetBooksUrl;
    }

}
