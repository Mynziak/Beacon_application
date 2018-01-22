package beacon_application;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Dima on 21.01.2018.
 */
public class BeaconApp {

    private static BeaconCore beaconCore = new BeaconCore();

    public static void main(String[] args) throws IOException, URISyntaxException, ParserConfigurationException, SAXException {
        beaconCore.runApplication();
    }
}



