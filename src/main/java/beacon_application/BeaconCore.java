package beacon_application;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;

/**
 * Created by Dima on 21.01.2018.
 */
public class BeaconCore {

    public void runApplication() throws IOException, URISyntaxException, ParserConfigurationException, SAXException {
        BeaconRequest beaconRequest = new BeaconRequest(); //----1. Create object of BeaconRequest.Class
        String responseXml = beaconRequest.getBeaconValue(); //--2. Get response from api -request: //https://beacon.nist.gov/rest/record/last
        String outputValue = getOutputValue(responseXml); //-----3. Get outputValue from xml string (parsing xml)
        String uniqueChars = getUniqueChars(outputValue); //-----4. Get all unique chars in outputValue
        printResult(uniqueChars, outputValue);// ----------------5. Print results of counting occurrences
    }


    public String getOutputValue(String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(xml));

        Document doc = builder.parse(src);
        return doc.getElementsByTagName("outputValue").item(0).getTextContent();
    }

    public String getUniqueChars(String str) {
        String temp = "";

        for (int i = 0; i < str.length(); i++) {
            if (temp.indexOf(str.charAt(i)) == -1) {
                temp = temp + str.charAt(i);
            }
        }

        System.out.println("Unique characters are: " + temp);
        return temp;
    }

    public int getOccurrences(String string, String character) {
        int count = string.length() - string.replace(character, "").length();
        System.out.println(character + "," + count);
        return count;
    }

    private void printResult(String uniqueChars, String outputValue) {
        for (int i = 0; i < uniqueChars.length(); i++) {
            char currentCh = uniqueChars.charAt(i);
            getOccurrences(outputValue, String.valueOf(currentCh));
        }
    }
}