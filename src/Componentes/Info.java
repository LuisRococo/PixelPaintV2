
package Componentes;


public class Info {

    private final int TAM_PANEL=640;
    private final int pixeles;
    private final byte dimWidth; 
    private final byte dimHeight; 
    
    public Info(byte dimWidth,byte dimHeight) {
        this.dimWidth=dimWidth;
        this.dimHeight=dimHeight;
        
        this.pixeles= Math.min(TAM_PANEL/dimWidth, TAM_PANEL/dimHeight);
    }

    public int getTamPanel() {
        return TAM_PANEL;
    }
    
    public int getPixeles() {
        return pixeles;
    }
    
    public byte getDimWidth() {
        return dimWidth;
    }

    public byte getDimHeight() {
        return dimHeight;
    }
    
}
