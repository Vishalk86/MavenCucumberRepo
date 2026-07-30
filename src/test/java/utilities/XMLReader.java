package utilities;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLReader 
{
	public String getLocator(String moduleName, String objectKey) 
	{
        String locator = "";

        try 
        {
            File file = new File("src/test/resources/objectrepository/" + moduleName + ".xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Element");

            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                String key = doc.getElementsByTagName("Objectkey").item(i).getTextContent();

                if (key.equalsIgnoreCase(objectKey)) 
                {
                    locator = doc.getElementsByTagName("Objectvalue").item(i).getTextContent();
                    break;
                }
            }
        } 
        catch (Exception e) {e.printStackTrace();}

        return locator;
    }
}
