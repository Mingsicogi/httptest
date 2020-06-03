package mins.study;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpCommon {

    private static final HttpClient httpClient1 = HttpClient.newBuilder().build();

    private static final String testUrl = "http://localhost:8080/welcome";

    public void test1() throws URISyntaxException, IOException, InterruptedException {
        HttpResponse<String> response = httpClient1.send(HttpRequest.newBuilder().GET().uri(URI.create(testUrl)).build(), HttpResponse.BodyHandlers.ofString());
        System.out.println(">>>> response : " + response.body());
    }
}
