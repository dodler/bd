/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint_jg;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import ui.MarkupLoader;
import ui.markupexception.MissingMouseListenerException;

/**
 *
 * @author Артем
 */
public class Paint_jg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, MissingMouseListenerException, Exception {
        MarkupLoader ml = MarkupLoader.getMarkupLoaderInstance();
        ml.loadMarkup("markup.xml");
    }
}
