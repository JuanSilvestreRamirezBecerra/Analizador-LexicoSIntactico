/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Entidades.Token;
import Extras.Clasificaciones;
import Procesos.Lectura;

/**
 *
 * @author 
 *  Argel Ortiz Arenas
 *  Jose Martin Ruiz Coss
 *
 *  Paerte del software que analiza si un programa escrito
 *  en un lenguaje espesifico es sintactica y lexicamente correcto o no
 *
 *  Con colaboracion en conjunto de:
 *  
 *  Eder Luis Beade Gomez
 *  Angel Cristian Alvrez Trujillo
 */
public class Controlador {
    
    Token t;
    Lectura l;
    AnalizadorLexico al;
    Clasificaciones c;
    public Controlador(Token t){
        
        this.t = t;
        l = new Lectura();
        al = new AnalizadorLexico();
        c = new Clasificaciones();
        
        
    }
    
    public void controlador(){
        
        al.q0(l.metodoParche(), t);
        
    }
    
}
