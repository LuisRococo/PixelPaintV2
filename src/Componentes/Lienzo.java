
package Componentes;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Lienzo extends JPanel{

    private Objeto objetoActual;
    private final Control cl;
    private final Info info;
    private Color pintura;
    private byte modoDibujo;
    private boolean mostrarCuadricula;
    public Lienzo(Control cl) {
        this.cl=cl;
        this.mostrarCuadricula=true;
        this.info=cl.info;
        this.objetoActual=null;
        this.modoDibujo=0;
        this.pintura=Util.Util.COLOR_PINTURA_DEFAULT;
    }
    
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Color [][] colores;
        
        if (this.objetoActual!=null){
            //DIBUJAR ARRAY COLOR
            colores=objetoActual.getColores();
            for (int i=0;i<info.getDimHeight();i++){
                for (int j=0;j<info.getDimWidth();j++){
                    if (colores[j][i]==null) g.setColor(Util.Util.COLOR_FONDO); 
                    else g.setColor(colores[j][i]);
                    g.fillRect(j*info.getPixeles(), i*info.getPixeles(), info.getPixeles(), info.getPixeles());
                }
            }
            //DIBUJAR CUADRICULA
            if (mostrarCuadricula) {
                g.setColor(Color.BLACK);
                for (int i = 0; i <= info.getDimHeight(); i++) { //HORIZONTALES
                    g.drawLine(0, i * info.getPixeles(), info.getPixeles() * info.getDimWidth(), i * info.getPixeles());
                }
                for (int i = 0; i <= info.getDimWidth(); i++) { //VERTICALES
                    g.drawLine(i * info.getPixeles(), 0, i * info.getPixeles(), info.getPixeles() * info.getDimHeight());
                }
            }
            //DIBUJAR Bordes
            g.setColor(Color.BLACK);
            g.drawLine(0, 0, this.getWidth()-1, 0);
            g.drawLine(0, this.getHeight()-1, this.getWidth()-1, this.getHeight()-1);
            g.drawLine(0, 0, 0, this.getHeight());
            g.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight()-1);
        }
    }
    
    public void AccionEnPos(byte x, byte y) {
        Color[][] colores;
        if (objetoActual != null) {
            colores=objetoActual.getColores();
            switch (this.modoDibujo) {
                case 0: //DIBUJO
                    colores[x][y]=this.pintura;
                    this.repaint();
                    break;
                case 1: //BORRAR
                    colores[x][y]=null;
                    this.repaint();
                    break;
                case 2: //CAMBIAR ALL COLORS
                    setAllColors(colores, x, y);
                    cl.setModoACero();
                    this.repaint();
                    break;
                case 3: //GET COLOR
                    cl.modoGetColor(getColorEnPos(colores, x, y));
                    break;
            }
        }
    }
    private Color getColorEnPos (Color colores[][],byte x, byte y){
        if (this.objetoActual!=null){
            colores=objetoActual.getColores();
            return colores[x][y];
        } else {
            return null;
        }
    }
    private void setAllColors (Color colores[][],byte x,byte y){
        Color click=getColorEnPos(colores, x, y);
        if (click==null){
            for (int i=0;i<info.getDimHeight();i++){ //CAMBIAR NULOS
                for (int j=0;j<info.getDimWidth();j++){
                    if (colores[j][i]==null) colores[j][i]=pintura;
                }
            }
        } else { //CAMBIAR UN COLOR EXISTENTE
            for (int i = 0; i < info.getDimHeight(); i++) {
                for (int j = 0; j < info.getDimWidth(); j++) {
                    if (colores[j][i]!=null){
                        if (colores[j][i].equals(click)){
                            colores[j][i]=pintura;
                        }
                    }
                }
            }
        }
    }
    
    //GETTERS SETTERS
    public void setObjetoActual (Objeto nuevo){
        this.objetoActual=nuevo;
    }
    public Objeto getObjetoActual (){
        return this.objetoActual;
    }
    
    public void setColorPintura (Color nuevo){
        this.pintura=nuevo;
    }
    
    public void setModoDibujo (byte modo){
        this.modoDibujo=modo;
    }
    
    public void setMostrarCuadricula (boolean mostrar){
        this.mostrarCuadricula=mostrar;
    }
}
