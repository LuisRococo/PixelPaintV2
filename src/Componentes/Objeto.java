
package Componentes;

import java.awt.Color;
import java.io.File;

public class Objeto {

    private final Info info;
    private final Color colores[][];
    private File fila;
    public Objeto(Info info) { //CONSTRUCTOR DESDE CLASE CONTROL OBJETOS
        this.fila=null;
        this.info=info;
        this.colores=new Color[info.getDimWidth()][info.getDimHeight()];
    }
    public Objeto(Info info,Color colores[][]){ //CONSTRUCTOR DESDE IO O COPIAR
        this.fila=null;
        this.info=info;
        this.colores=colores;
    }
    
    public Objeto copiarObjet (){
        return new Objeto(info, copiarColores());
    }
    private Color[][] copiarColores(){
        Color copia[][]=new Color[info.getDimWidth()][info.getDimHeight()];
        for (int i=0;i<info.getDimHeight();i++){
            for (int j=0;j<info.getDimWidth();j++){
                copia[j][i]=colores[j][i];
            }
        }
        return copia;
    }
    
    public void reiniciarColores (){
        for (int i=0;i<info.getDimHeight();i++){
            for (int j=0;j<info.getDimWidth();j++){
                colores[j][i]=null;
            }
        }
    }
    
    public Color[][] getColores (){
        return this.colores;
    }

    public File getFila() {
        return fila;
    }

    public void setFila(File fila) {
        this.fila = fila;
    }
    
    
    
}
