/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg_l2;

import haulmaunt.lyan.ui.markupexception.MissingMouseListenerException;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import ui.MarkupLoader;

/**
 *
 * @author Артем
 */
public class KG_l2 {

    private static MarkupLoader ml;
    private static MyPainter mp1;
    private static final MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            String x1, x2, x3, x4, y1, y2, y3, y4;
            x1 = ((JTextField) ml.components.get("x1")).getText();
            x2 = ((JTextField) ml.components.get("x2")).getText();
            x3 = ((JTextField) ml.components.get("x3")).getText();
            x4 = ((JTextField) ml.components.get("x4")).getText();

            y1 = ((JTextField) ml.components.get("y1")).getText();
            y2 = ((JTextField) ml.components.get("y2")).getText();
            y3 = ((JTextField) ml.components.get("y3")).getText();
            y4 = ((JTextField) ml.components.get("y4")).getText();

            Point p1 = new Point(), p2 = new Point(), p3 = new Point(), p4 = new Point();

            if (!x1.equals("")) {
                p1.x = Integer.parseInt(x1);
            }
            if (!x2.equals("")) {
                p2.x = Integer.parseInt(x2);
            }
            if (!x3.equals("")) {
                p3.x = Integer.parseInt(x3);
            }
            if (!x4.equals("")) {
                p4.x = Integer.parseInt(x4);
            }

            if (!y1.equals("")) {
                p1.y = Integer.parseInt(y1);
            }
            if (!y2.equals("")) {
                p2.y = Integer.parseInt(y2);
            }
            if (!y3.equals("")) {
                p3.y = Integer.parseInt(y3);
            }
            if (!y4.equals("")) {
                p4.y = Integer.parseInt(y4);
            }


            mp1.setCubicCurvePoint(p1, p2, p3, p4);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, MissingMouseListenerException, Exception {

        ml = MarkupLoader.getMarkupLoaderInstance();
        
        mp1 = new MyPainter(
                new Point(10, 200),
                new Point(15, 15),
                new Point(200, 15),
                new Point(350, 200));
        
        mp1.setBounds(0, 0, 400, 300);
        ml.mouseListeners.put("mouseListener", mouseListener);
        ml.loadMarkup("markup.xml");
        
        JFrame mp = (JFrame)ml.components.get("main");
        
        mp.add(mp1);
        
        mp.setLayout(new BorderLayout());
        
        mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
