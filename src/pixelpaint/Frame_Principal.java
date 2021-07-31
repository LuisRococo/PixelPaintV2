
package pixelpaint;

import Componentes.Control;
import Componentes.ControlObjetos;
import Componentes.Info;
import Componentes.Lienzo;
import Componentes.Objeto;
import Util.SalidaEntrada;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;


public class Frame_Principal extends javax.swing.JFrame implements ActionListener{

    private final Control cl;
    public final Info info;
    public Frame_Principal(byte dimWidth, byte dimHeight) {
        initComponents();
        this.info=new Info(dimWidth, dimHeight);
        this.cl=new Control(this);
        initBotones();
        
        cl.crearObjeto();
        cl.setObjetoEnLienzo(0);
    }
    
    public Frame_Principal(Info info,ControlObjetos controlObj){
        initComponents();
        this.info=info;
        this.cl=new Control(this, controlObj);
        initBotones();
        
        cl.setObjetoEnLienzo(0);
    }
    
    private void initBotones (){
        toggleBorrar.addActionListener(this);
        toggleGetColor.addActionListener(this);
        toggloSetAllColor.addActionListener(this);
        
        jBoton_Color.addActionListener(this);
        jBoton_GuardarSolo.addActionListener(this);
        jBoton_GuardarSheet.addActionListener(this);
        jBoton_MENU.addActionListener(this);
        jBoton_SALIR.addActionListener(this);
        jBoton_REINICIAR_LIENZO.addActionListener(this);
        jBoton_GuardarCambiosSolo.addActionListener(this);
        
        JBoton_NUEVA_TILE.addActionListener(this);
        jBoton_ELIMINAR_TILE.addActionListener(this);
        jBoton_COPIAR_TILE.addActionListener(this);
    }
    
    public void addLienzo (Lienzo agregar){
        this.Panel_Referencia.add(agregar);
    }
    public void setValueSpinner (int value){
        this.jSpinner1.setValue(value);
    }
    
    public void setColorPintura (Color nuevo){
        this.jTextField1.setBackground(nuevo);
        cl.setColorPintura(nuevo);
    }
    
    public void setModoPaint (byte modo){
        switch (modo){
            case 0: //REINICIAR //DIBUJO
                toggleBorrar.setSelected(false);
                toggleGetColor.setSelected(false);
                toggloSetAllColor.setSelected(false);
                cl.setModoDibujo((byte) 0);
                break;
            case 1: //BORRAR
                setModoPaint((byte)0);
                toggleBorrar.setSelected(true);
                cl.setModoDibujo((byte) 1);
                break;
            case 2: //SET ALL COLOR
                setModoPaint((byte)0);
                toggloSetAllColor.setSelected(true);
                cl.setModoDibujo((byte) 2);
                break;
            case 3: //GET COLOR
                setModoPaint((byte)0);
                toggleGetColor.setSelected(true);
                cl.setModoDibujo((byte) 3);
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Panel_Referencia = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        JBoton_NUEVA_TILE = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jBoton_ELIMINAR_TILE = new javax.swing.JButton();
        jBoton_COPIAR_TILE = new javax.swing.JButton();
        jBoton_GuardarSheet = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jBoton_Color = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        toggleBorrar = new javax.swing.JToggleButton();
        toggloSetAllColor = new javax.swing.JToggleButton();
        toggleGetColor = new javax.swing.JToggleButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jBoton_REINICIAR_LIENZO = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jBoton_GuardarSolo = new javax.swing.JButton();
        jBoton_GuardarCambiosSolo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jBoton_SALIR = new javax.swing.JButton();
        jBoton_MENU = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pixel Paint");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Panel_Referencia.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout Panel_ReferenciaLayout = new javax.swing.GroupLayout(Panel_Referencia);
        Panel_Referencia.setLayout(Panel_ReferenciaLayout);
        Panel_ReferenciaLayout.setHorizontalGroup(
            Panel_ReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        Panel_ReferenciaLayout.setVerticalGroup(
            Panel_ReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        JBoton_NUEVA_TILE.setText("NUEVA TILE");

        jLabel1.setText("Sprite Sheet: ");

        jLabel2.setText("Moverse: ");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner1.setToolTipText("");
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jBoton_ELIMINAR_TILE.setText("ELIMINAR TILE");

        jBoton_COPIAR_TILE.setText("COPIAR TILE");

        jBoton_GuardarSheet.setText("GUARDAR HOJA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBoton_NUEVA_TILE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner1))
                    .addComponent(jBoton_ELIMINAR_TILE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBoton_COPIAR_TILE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jBoton_GuardarSheet, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBoton_NUEVA_TILE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBoton_ELIMINAR_TILE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBoton_COPIAR_TILE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBoton_GuardarSheet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Herramientas: ");

        jBoton_Color.setText("COLOR");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));

        toggleBorrar.setText("BORRAR");

        toggloSetAllColor.setText("SET ALL COLOR");

        toggleGetColor.setText("AGARRAR COLOR");

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Mostrar Cuadricula");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jBoton_REINICIAR_LIENZO.setText("REINICIAR LIENZO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBoton_Color, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(toggleBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toggloSetAllColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toggleGetColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBoton_REINICIAR_LIENZO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBoton_Color)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toggleBorrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toggloSetAllColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toggleGetColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBoton_REINICIAR_LIENZO)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBoton_GuardarSolo.setText("GUARDAR");

        jBoton_GuardarCambiosSolo.setText("GUARDAR CAMBIOS");

        jLabel4.setText("Tile: ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBoton_GuardarSolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBoton_GuardarCambiosSolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBoton_GuardarSolo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBoton_GuardarCambiosSolo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBoton_SALIR.setText("SALIR");

        jBoton_MENU.setText("MENU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBoton_SALIR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBoton_MENU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBoton_SALIR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBoton_MENU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) cl.mostrarCuadricula(true);
        else cl.mostrarCuadricula(false);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        this.cl.setObjetoEnLienzo(Integer.valueOf(jSpinner1.getValue().toString()));
    }//GEN-LAST:event_jSpinner1StateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBoton_NUEVA_TILE;
    private javax.swing.JPanel Panel_Referencia;
    private javax.swing.JButton jBoton_COPIAR_TILE;
    private javax.swing.JButton jBoton_Color;
    private javax.swing.JButton jBoton_ELIMINAR_TILE;
    private javax.swing.JButton jBoton_GuardarCambiosSolo;
    private javax.swing.JButton jBoton_GuardarSheet;
    private javax.swing.JButton jBoton_GuardarSolo;
    private javax.swing.JButton jBoton_MENU;
    private javax.swing.JButton jBoton_REINICIAR_LIENZO;
    private javax.swing.JButton jBoton_SALIR;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton toggleBorrar;
    private javax.swing.JToggleButton toggleGetColor;
    private javax.swing.JToggleButton toggloSetAllColor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        Color aux;
        Objeto obj;
        //BOTONES NORMALES
        if (e.getSource().equals(jBoton_Color)){
            aux=JColorChooser.showDialog(this, "COLOR PINTURA", Util.Util.COLOR_PINTURA_DEFAULT);
            if (aux!= null) this.setColorPintura(aux);
        } else if (e.getSource().equals(jBoton_MENU)){
            Frame_Menu frame=new Frame_Menu();
            frame.setLocationRelativeTo(this);
            frame.setVisible(true);
            this.setVisible(false);
            this.dispose();
        } else if (e.getSource().equals(jBoton_SALIR)){
            System.exit(0);
        } else if (e.getSource().equals(jBoton_GuardarSolo)){
            if (cl.getControlObjetos().isValidPosicion(Integer.valueOf(jSpinner1.getValue().toString()))){
                Dialog_GuardarSolo dl=new Dialog_GuardarSolo(this, cl.getControlObjetos().getObjeto(Integer.valueOf(jSpinner1.getValue().toString())));
                dl.setLocationRelativeTo(this);
                dl.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "ERROR: El tile que quiere guardar se encuentra vacio");
            }
        } else if (e.getSource().equals(jBoton_GuardarCambiosSolo)){
            obj=cl.getControlObjetos().getObjeto(Integer.valueOf(jSpinner1.getValue().toString()));
            if (obj==null) JOptionPane.showMessageDialog(this, "Error: Esta en un Tile que esta vacio");
            else{
                File fl=obj.getFila();
                if (fl==null) JOptionPane.showMessageDialog(this, "ERROR: No hay archivo que sobre-escribir, primero guarde el archivo");
                else {
                    if (SalidaEntrada.guardarTileSolo(obj.getColores(), fl)){
                        JOptionPane.showMessageDialog(this, "AVISO: Exito al Guardar");
                    } else JOptionPane.showMessageDialog(this, "ERROR: Error al guardar");
                }
            }
        } else if (e.getSource().equals(JBoton_NUEVA_TILE)){
            cl.crearObjeto();
            cl.setObjetoEnLienzo(Integer.valueOf(jSpinner1.getValue().toString()));
        } else if (e.getSource().equals(jBoton_ELIMINAR_TILE)){
            cl.eliminarTile(Integer.valueOf(jSpinner1.getValue().toString()));
            cl.setObjetoEnLienzo(Integer.valueOf(jSpinner1.getValue().toString()));
        } else if (e.getSource().equals(jBoton_COPIAR_TILE)){
            this.cl.copiarObjeto(Integer.valueOf(jSpinner1.getValue().toString()));
            this.cl.setUltimoObjeto();
        } else if (e.getSource().equals(jBoton_REINICIAR_LIENZO)) {
            this.cl.reiniciarObjeto(Integer.valueOf(jSpinner1.getValue().toString()));
        } else if (e.getSource().equals(jBoton_GuardarSheet)) {
            Dialog_GuardarHoja dl = new Dialog_GuardarHoja(this, cl.getControlObjetos());
            dl.setLocationRelativeTo(null);
            dl.setVisible(true);
        } 
        //TOGGLE BUTTOMS
        if (e.getSource().equals(toggleBorrar)){
            if (toggleBorrar.isSelected()) setModoPaint((byte)1);
            else setModoPaint((byte)0);
        } else if (e.getSource().equals(toggloSetAllColor)){
            if (toggloSetAllColor.isSelected()) setModoPaint((byte)2);
            else setModoPaint((byte)0);
        } else if (e.getSource().equals(toggleGetColor)){
            if (toggleGetColor.isSelected()) setModoPaint((byte)3);
            else setModoPaint((byte)0);
        }
    }
}
