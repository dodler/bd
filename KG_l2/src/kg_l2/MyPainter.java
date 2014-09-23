/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg_l2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Артем
 */
public class MyPainter extends JPanel {

    public void setCubicCurvePoint(Point p, int n) throws WrongIndexException{
        switch(n){
            case 0: p0 = p; break;
            case 1: p1 = p; break;
            case 2: p2 = p; break;
            case 3: p3 = p; break;
            default: throw new WrongIndexException();
        }
        paintComponent(getGraphics());
    }
    
    /**
     * общий метод для обновления всех координат опорных точек кривой безье
     * @param p0 - первая опорная точка
     * @param p1 - вторая опорная точка
     * @param p2 - третья опорная точка
     * @param p3 - четвертая опорная точка
     */
    public void setCubicCurvePoint(Point p0, Point p1, Point p2, Point p3) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        paintComponent(getGraphics());
    }
    private CubicCurve2D.Double curve;
    
    private Point p0, p1, p2, p3;
    private Rectangle2D.Double b0, b1, b2, b3;
    
    private static final int WIDTH_ = 5;// длина для прямоугольников, которые обозначают точки для кривой безье
    private static final int HEIGHT_ = 5;

    public MyPainter(Point p0, Point p1, Point p2, Point p3) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        b0 = new Rectangle2D.Double(p0.getX(), p0.getY(), WIDTH_, HEIGHT_);
        b1 = new Rectangle2D.Double(p1.getX(), p1.getY(), WIDTH_, HEIGHT_);
        b2 = new Rectangle2D.Double(p2.getX(), p2.getY(), WIDTH_, HEIGHT_);
        b3 = new Rectangle2D.Double(p3.getX(), p3.getY(), WIDTH_, HEIGHT_);

        curve = new CubicCurve2D.Double(p0.getX(),
                p0.getY(),
                p1.getX(),
                p1.getY(),
                p2.getX(),
                p2.getY(),
                p3.getX(),
                p3.getY());
    }

    private void doDrawing(Graphics g){
        g.clearRect(0, 0, getWidth(), getHeight());
        curve.setCurve(p0.getX(), p0.getY(), p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
        b0.setRect(p0.getX(), p0.getY(), WIDTH_, HEIGHT_);
        b1.setRect(p1.getX(), p1.getY(), WIDTH_, HEIGHT_);
        b2.setRect(p2.getX(), p2.getY(), WIDTH_, HEIGHT_);
        b3.setRect(p3.getX(), p3.getY(), WIDTH_, HEIGHT_);
        ((Graphics2D) g).draw(curve);
        ((Graphics2D) g).draw(b0);
        ((Graphics2D) g).draw(b1);
        ((Graphics2D) g).draw(b2);
        ((Graphics2D) g).draw(b3);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
