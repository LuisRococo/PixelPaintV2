
package Componentes;

import java.awt.Color;
import java.awt.Dimension;
import pixelpaint.Frame_Principal;

public class Control {
    
    public final Info info;
    private final Frame_Principal frame;
    private Lienzo lienzo;
    private final ControlObjetos controlObj;
    private int lastPixelX=-1;
    private int lastPixelY=-1;
    
    public Control(Frame_Principal frame) {
        this.info = frame.info;
        this.frame = frame;
        this.controlObj=new ControlObjetos(this.info);
        initLienzo();
    }

    public Control(Frame_Principal frame, ControlObjetos controlObj) {
        this.info = frame.info;
        this.frame = frame;
        this.controlObj = controlObj;
        initLienzo();
    }
    
    private void initLienzo (){
        MiMouseListener listener=new MiMouseListener(this);
        Dimension dim=new Dimension(info.getTamPanel(),info.getTamPanel());
        
        lienzo=new Lienzo(this);
        lienzo.setFocusable(true);
        lienzo.addMouseListener(listener);
        lienzo.addMouseMotionListener(listener);
        lienzo.setSize(dim);
        lienzo.setPreferredSize(dim);
        frame.addLienzo(lienzo);
    }
    
    public void mostrarCuadricula (boolean mostrar){
        lienzo.setMostrarCuadricula(mostrar);
        lienzo.repaint();
    }
    
    public void setModoDibujo (byte modo){
        lienzo.setModoDibujo(modo);
    }
    
    public void reiniciarObjeto (int pos){
        controlObj.reiniciarObjeto(pos);
        lienzo.repaint();
    }
    
    public void copiarObjeto (int pos){
        controlObj.copiarObjeto(pos);
    }
    
    public void eliminarTile (int pos){
        controlObj.eliminarObjeto(pos);
    }
    
    public void crearObjeto (){
        this.controlObj.crearNuevoObjeto();
    }
    
    public void setColorPintura(Color nuevo){
        lienzo.setColorPintura(nuevo);
    }
    
    public void modoGetColor (Color nuevo){ //LLAMADO DESDE LIENZO
        if (nuevo==null){
            nuevo=Util.Util.COLOR_FONDO;
        }
        frame.setColorPintura(nuevo);
        frame.setModoPaint((byte)0);
    }
    public void setModoACero (){ //LLAMADO DESDE LIENZO
        frame.setModoPaint((byte)0);
    }
    
    public void setObjetoEnLienzo (int pos){
        this.lienzo.setObjetoActual(controlObj.getObjeto(pos));
        lienzo.repaint();
    }
    public void setUltimoObjeto (){
        frame.setValueSpinner(controlObj.getArraySize()-1);
    }

    public void AccionEnCoor(int xCoor, int yCoor, boolean dragged) {
        xCoor = xCoor / info.getPixeles();
        yCoor = yCoor / info.getPixeles();
        if (dragged) {
            if (xCoor==lastPixelX && yCoor==lastPixelY) {
                return;
            }
            lastPixelX = xCoor;
            lastPixelY = yCoor;
        }
        if (xCoor<info.getDimWidth() && xCoor>=0 && yCoor<info.getDimHeight() &&yCoor>=0){
            this.lienzo.AccionEnPos((byte)xCoor, (byte)yCoor);
        }
    }
    
    public ControlObjetos getControlObjetos (){
        return this.controlObj;
    }
}
