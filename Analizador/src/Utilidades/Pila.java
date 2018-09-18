
package Utilidades;


/**
 *
 * @author 
 *  Argel Ortiz Arenas
 *  Jose Martin Ruiz Coss
 *  Angel Cristian Alvrez Trujillo
 *
 *  Paerte del software que analiza si un programa escrito
 *  en un lenguaje espesifico es sintactica y lexicamente correcto o no
 *
 * 
 *  
 */
public class Pila<Tipo> {
    private Nodo <Tipo> tope;
    private int  cantidad;
    
    private class Nodo <Tipo>{
    Tipo informacion;
    Nodo next;
    
         public Nodo(Tipo i){
             informacion = i;
             next = null;
        }
    }
    public Pila(){
        tope     = null;
        cantidad = 0;
    }
    
    
    public boolean isEmpty(){
        return tope == null;
    }
    
    
    public int size(){
        return cantidad;
    }
    
 
    public Tipo pop(){
        if(isEmpty()){
            return null;
        }else{
            Nodo <Tipo> temp = tope;
            tope = tope.next;
            temp.next = null;
            return temp.informacion;
        }
    }
    
    public void push(Tipo i) throws IllegalStateException{
        Nodo<Tipo> nuevo = new Nodo(i);
        
        if(nuevo != null){
            if(tope == null){
                tope = nuevo;
            }else{
                nuevo.next = tope;
                tope = nuevo;
            }
            cantidad++;
        }else{
            throw new IllegalStateException("Pila llena");
        }
    }
    
   
    public Tipo peak(){
        
        return tope.informacion;
    }
}


