
package Util;

import Componentes.ControlObjetos;
import Componentes.Info;
import Componentes.Objeto;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class SalidaEntrada {
    
    //GUARDAR
    @SuppressWarnings("UseSpecificCatch")
    public static boolean guardarSheet (ControlObjetos cl,int ancho,int alto,File fl){
        Info info=cl.getInfo();
        BufferedImage bf = new BufferedImage(ancho * info.getDimWidth(), alto * info.getDimHeight(), BufferedImage.TYPE_INT_ARGB);
        Color array[][];
        int objPos = 0;
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                if (cl.isValidPosicion(objPos)) {
                    array = cl.getObjeto(objPos).getColores();
                    cargarSubTilesEnSheet(array, x, y, info, bf);
                    objPos++;
                } else {
                    cargarNullEnSheet(x, y, info, bf);
                }
            }
        }
        try {
            ImageIO.write(bf, "png", fl);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    private static void cargarSubTilesEnSheet (Color[][] array,int x,int y,Info info,BufferedImage bf){
        int width=info.getDimWidth();
        int height=info.getDimHeight();
        x=width*x;
        y=height*y;
        int auxX=x;
        Color color;
        for (int i=0;i<height;i++){
            for (int j = 0; j < width; j++) {
                color = array[j][i];
                if (color == null) {
                    bf.setRGB(x, y, 0);
                } else bf.setRGB(x, y, color.getRGB());
                x++;
            }
            x=auxX;
            y++;
        }
    }
    private static void cargarNullEnSheet (int x,int y,Info info,BufferedImage bf){
        int width=info.getDimWidth();
        int height=info.getDimHeight();
        x*=width;
        y*=height;
        int auxX=x;
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                bf.setRGB(x, y, 0);
                x++;
            }
            y++;
            x=auxX;
        }
    }
    
    //GUARDAR TILE SOLO
    public static boolean guardarTileSolo(Color array[][], File fl) {
        BufferedImage bf = new BufferedImage(array.length, array[0].length, BufferedImage.TYPE_INT_ARGB);
        Color color;
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                color = array[j][i];
                if (color == null) {
                    bf.setRGB(j, i, 0);
                } else {
                    bf.setRGB(j, i, color.getRGB());
                }
            }
        }

        try {
            ImageIO.write(bf, "png", fl);
            return true;
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //CARGAR
    //CARGAR SOLO
    public static ControlObjetos cargarTileSolo (File fl){
        if (!fl.isFile()) return null;
        try {
            BufferedImage bi=ImageIO.read(fl);
            if (bi==null) return null;
            else if (bi.getWidth()<1 || bi.getWidth() >Util.MAX_DIMENSION || bi.getHeight() <1 || bi.getHeight() >Util.MAX_DIMENSION){
                JOptionPane.showMessageDialog(null, "La imagen es demasiado grande para cargarse en el programa\nMaximo: "+Util.MAX_DIMENSION+" x "+Util.MAX_DIMENSION);
                return null;
            } else{
                return crearControlObjetosSolo(bi,fl);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }
    private static ControlObjetos crearControlObjetosSolo (BufferedImage bi,File fl){
        Info info=new Info((byte) bi.getWidth(),(byte) bi.getHeight());
        ControlObjetos cl=new ControlObjetos(info);
        Objeto obj=new Objeto(info, crearArrayColorSolo(bi));
        obj.setFila(fl);
        cl.agregarNuevoObjeto(obj);
        return cl;
    }
    private static Color [][] crearArrayColorSolo (BufferedImage bi){
        Color color[][]=new Color[bi.getWidth()][bi.getHeight()];
        Color aux;
        for (int y=0;y<bi.getHeight();y++){
            for (int x=0;x<bi.getWidth();x++){
                aux=new Color(bi.getRGB(x, y), true);
                if (aux.getAlpha()==0){
                    color[x][y]=null;
                } else{
                    color[x][y]=aux;
                }
            }
        }
        return color;
    }
    
    //CARGAR SHEET
    
    
    //viejo
//    public static BufferedImage cargarImagenSheet (File fl){
//        if (!fl.isFile()) return null;
//            BufferedImage bi;
//        try{
//            bi = ImageIO.read(fl);
//        }catch (IOException e){
//            return null;
//        }
//        return bi;
//    }
//    
//    public static boolean isMedidasValidas (BufferedImage bi,Info info){
//        if (bi.getWidth()%(double)info.getDimWidth()==0 && bi.getHeight()%(double)info.getDimHeight()==0){
//            if (bi.getWidth()/info.getDimWidth()>=1 && bi.getHeight()/info.getDimHeight()>=1) return true;
//            return false;
//        } else return false;
//    }
//    
//    public static ControlObjetos getControlObjetos (BufferedImage bi,Info info){
//        if (isMedidasValidas(bi, info)) return null;
//        int widhtLimit=bi.getWidth()/info.getDimWidth();
//        int heightLimit=bi.getHeight()/info.getDimHeight();
//        ControlObjetos control=new ControlObjetos(info);
//        Color [][] array;
//        BufferedImage subImage;
//        
//        for (int i=0;i<heightLimit;i++){
//            for (int j=0;j<widhtLimit;j++){
//                subImage=bi.getSubimage(j*info.getDimWidth(), i*info.getDimHeight(), info.getDimWidth(), info.getDimHeight());
//                array=convertirAColorArray(subImage, info);
//                control.agregarNuevoObjeto(new Objeto(info, array));
//            }
//        }
//        return control;
//    }
//    
//    public static Color [][] convertirAColorArray (BufferedImage subImage,Info info){
//        Color colores[][]=new Color[info.getDimWidth()][info.getDimHeight()];
//        Color aux;
//        for (int i=0;i<info.getDimHeight();i++){
//            for (int j=0;j<info.getDimWidth();j++){
//                aux=new Color (subImage.getRGB(j, i));
//                if (aux.getAlpha()==255){
//                    colores[j][i]=null;
//                } else {
//                    colores[j][i]=aux;
//                }
//            }
//        }
//        return colores;
//    }
//    
//    public static boolean guardarTileSolo (File fl,Objeto obj){
//        Color array [][]=obj.getColores();
//        Color aux;
//        BufferedImage bi=new BufferedImage(array.length, array[0].length, BufferedImage.TYPE_INT_ARGB);
//        for (int i=0;i<array[0].length;i++){
//            for (int j=0;j<array.length;j++){
//                aux=array[j][i];
//                if (aux==null){
//                    aux=new Color(0, 0, 0, 255);
//                }
//                bi.setRGB(j, i, aux.getRGB());
//            }
//        }
//        try{
//            ImageIO.write(bi, "png", fl);
//            return true;
//        } catch (IOException e){
//            return false;
//        }
//    }
//    
//    public static boolean guardarSheet (File fl,ControlObjetos cl,Info info,int ancho,int alto){
//        if (isFormatValid(cl,ancho,alto)) return false;
//        Color array[][];
//        BufferedImage sheet=new BufferedImage(info.getDimWidth()*ancho, info.getDimHeight()*alto, BufferedImage.TYPE_INT_ARGB);
//        int xPixel=0,yPixel=0;
//        Color aux;
//        for (int i=0;i<cl.getArraySize();i++){
//            array=cl.getObjeto(i).getColores();
//            sheet=guardarFragmento(sheet, info, array, xPixel, yPixel);
//            xPixel+=info.getDimWidth();
//            if (xPixel==sheet.getWidth()){
//                yPixel+=info.getDimHeight();
//                xPixel=0;
//            }
//        }
//        return true;
//    }
//    private static BufferedImage guardarFragmento (BufferedImage guardar,Info info,Color [][] array,int xPixel,int yPixel){
//        Color aux;
//        for (int i=0;i<info.getDimHeight();i++){
//            for (int j=0;j<info.getDimHeight();j++){
//                aux=array[j][i];
//                if (aux==null){
//                    aux=new Color(0, 0, 0, 255);
//                }
//                guardar.setRGB(xPixel, yPixel, aux.getRGB());
//                xPixel++;
//            }
//            xPixel=0;
//            yPixel++;
//        }
//        return guardar;
//    }
//    
//    public static boolean isFormatValid (ControlObjetos cl,int ancho,int alto){
//        if (cl.getArraySize()==(ancho*alto)) return true;
//        else return false;
//    }
}
