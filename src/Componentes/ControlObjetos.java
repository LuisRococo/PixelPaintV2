
package Componentes;

import java.util.ArrayList;

public class ControlObjetos {
    
    private final ArrayList <Objeto> objetos;
    private final Info info;
    
    public ControlObjetos(Info info) {
        this.info=info;
        this.objetos = new ArrayList<>();
    }
    
    public boolean isValidPosicion (int pos){
        if (pos>=0 && pos < objetos.size()) return true;
        else return false;
    }
    
    public void agregarNuevoObjeto (Objeto agregar){
        this.objetos.add(agregar);
    }
    
    public void crearNuevoObjeto (){
        this.objetos.add(new Objeto (this.info));
    }
    public void eliminarObjeto (int pos){
        if (isValidPosicion(pos)) this.objetos.remove(pos);
    }
    public int getArraySize (){
        return this.objetos.size();
    }
    public Objeto getObjeto (int pos){
        if (isValidPosicion(pos)) return this.objetos.get(pos);
        else return null;
    }
    public void reiniciarObjeto (int pos){
        if (isValidPosicion(pos)) objetos.get(pos).reiniciarColores();
    }
    public void copiarObjeto (int pos){
        if (isValidPosicion(pos)){
            this.objetos.add(this.objetos.get(pos).copiarObjet());
        }
    }
    
    public Info getInfo (){
        return this.info;
    }
    public ArrayList<Objeto> getArrayObjetos (){
        return this.objetos;
    }
}
