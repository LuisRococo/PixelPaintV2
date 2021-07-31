
package Componentes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MiMouseListener implements MouseListener, MouseMotionListener{

    private final Control cl;
    public MiMouseListener(Control cl) {
        this.cl=cl;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        cl.AccionEnCoor(e.getX(), e.getY(),false);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        cl.AccionEnCoor(e.getX(), e.getY(),true);
    }

    //NO USADOS
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
    
}
