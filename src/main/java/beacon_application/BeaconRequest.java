package beacon_application;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Dima on 21.01.2018.
 */
public class BeaconRequest {

    // Send get request to: https://beacon.nist.gov/rest/record/last

    public static String host = "beacon.nist.gov";
    public static String scheme = "https";
    public static String path = "/rest/record/last";

    private URIBuilder getUriBuilder() {
        return new URIBuilder().setScheme(scheme).setHost(host);
    }

    private String getResponseBody(HttpResponse resp) throws ParseException, IOException {
        String respBody = EntityUtils.toString(resp.getEntity());
        int statusCode = resp.getStatusLine().getStatusCode();
        System.out.println("RESPONSE: " + respBody);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK, "Status code: " + statusCode);
        return respBody;
    }

    public String getBeaconValue() throws IOException, URISyntaxException {
        URI uri = getUriBuilder().setPath(path).build();
        System.out.println("Request uri is: " + uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        return getResponseBody(resp);
    }
}
