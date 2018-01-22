package tests;

import beacon_application.BeaconCore;
import beacon_application.BeaconRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Dima on 21.01.2018.
 */
public class BaconTests {

    private BeaconRequest beaconRequest = new BeaconRequest();
    private BeaconCore beaconCore = new BeaconCore();
    private String charsString = "ABBAA111166FF";
    private String uniqueCharsString = "AB16F";

    @Test
    public void beaconResponseTest() throws IOException, URISyntaxException {

        // Check that response from echo machine is string and is not empty:
        String responseXml = beaconRequest.getBeaconValue();
        Assert.assertNotEquals(responseXml, null, "Response frorm echo is null!");
        Assert.assertNotEquals(responseXml.length(), 0, "Response from echo is empty!");
        Assert.assertTrue(responseXml.contains("outputValue"), "Response doesn't contains outputValue");
    }

    @Test
    public void outputValueTest() throws IOException, URISyntaxException, ParserConfigurationException, SAXException {

        //Check that outputValue is 128 bit string:
        String outputValue = beaconCore.getOutputValue(beaconRequest.getBeaconValue());
        Assert.assertNotEquals(outputValue, null, "outputValue is null!");
        Assert.assertEquals(outputValue.length(), 128, "outputValue is not 128 hexidecimal characters,!");
    }

    @Test
    public void uniqueCharsTest() {

        //check that method getUniqueChars returns string with unique chars:
        Assert.assertEquals(beaconCore.getUniqueChars(uniqueCharsString), uniqueCharsString, "Method getUniqueChars works incorrect!");
    }

    @Test
    public void countOccurrencesTest() {

        //Check that method getOccurrences counts occurrences:
        Assert.assertEquals(beaconCore.getOccurrences(charsString, "A"), 3, "Method getOccurrences counts incorrect!");
    }

    @Test
    public void integrationTest() throws IOException, URISyntaxException, ParserConfigurationException, SAXException {

        //Check that all modules works correct together:
        String responseXml =  beaconRequest.getBeaconValue();
        Assert.assertNotEquals(responseXml, null, "Response frorm echo is null!");
        Assert.assertNotEquals(responseXml.length(), 0, "Response from echo is empty!");
        Assert.assertTrue(responseXml.contains("outputValue"), "Response doesn't contains outputValue");
        String outputValue = beaconCore.getOutputValue(responseXml);
        Assert.assertNotEquals(outputValue, null, "outputValue is null!");
        Assert.assertEquals(outputValue.length(), 128, "outputValue is not 128 hexidecimal characters,!");
        String uniqueChars = beaconCore.getUniqueChars(outputValue);
    }
}
