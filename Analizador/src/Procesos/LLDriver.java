
package Procesos;

import Entidades.Token;
import Utilidades.Controlador;
import Utilidades.Estructuras;
import Utilidades.Pila;

/**
 *
 * @author 
 * 
 *  Ortiz Arenas Argel
 *  8/09/2018
 * 
 *  Clase LLDriver, clase encargada de
 *  hacer el analisis sintactico.
 *  Paerte del software que analiza si un programa escrito
 *  en un lenguaje espesifico es sintactica y lexicamente correcto o no
 */
public class LLDriver {
    
    Pila p;
    Token a;
    Controlador c;
    String x;
    Estructuras e;
    
    int matriz[][] = {{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                      {0,0,2,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
                      {0,0,3,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0},
                      {0,0,0,0,0,5,5,6,0,0,0,0,0,0,0,0,0,0},
                      {0,0,0,0,7,8,8,8,0,0,0,0,0,0,0,0,0,0},
                      {0,0,0,0,0,9,0,10,0,0,0,0,0,0,0,0,0,0},
                      {0,0,0,0,0,0,0,11,0,0,0,0,0,0,0,0,0,0},
                      {0,0,0,13,0,0,0,0,14,12,0,0,0,0,0,0,0,0},
                      {0,0,0,0,0,0,0,0,0,15,0,0,0,0,0,0,0,0},
                      {0,0,0,17,0,0,0,0,17,17,0,0,0,16,0,0,0,0},
                      {0,0,0,18,0,19,0,0,19,19,0,0,0,0,0,0,0,0},
                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,21,0,0,0},
                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,22,0,0,0},
                      {0,0,0,0,0,23,0,0,0,0,0,0,0,0,0,0,0,0}};
    
    
    
    public LLDriver(Estructuras e){
        
        this.e = e;
        p = new Pila();
        a = new Token();
        c = new Controlador(a);
        x = "";
        
        
    
    }
    
    //modificar metodos de comprobacion (Ubicados hasta abajo)
    public void analizar() {

        p.push("systemgoal");

        x = (String) p.peak();// asignar "x"

        c.controlador(); // asignando el token a "a"

        try {
            while (!p.isEmpty()) {

                if (isNoTerminal()) {

                    int px = posicionX();

                    int pa = posicionA();

                    if (matriz[px][pa] != 0) {

                        p.pop();

                        String[] aux = e.producciones[matriz[px][pa] - 1].split(" ");

                        for (int i = aux.length - 1; i >= 0; i--) {

                            if (!aux[i].equals("") && !aux[i].equals(" ")) {

                                p.push(aux[i]);

                            }

                        }

                        x = (String) p.peak();

                    } else {

                        System.out.println("Error Lexico/Sintactico --2--");
                        System.exit(0);
                    }
                } else {
                    //si x es un terminal

                    if (a.getClasificacion().equals("Reservada")) {

                        if (x.equals(a.getToken())) {

                            p.pop();
                            c.controlador(); // asignando el siguiente token a "a"
                            if (!a.getToken().equals(" ")) {
                                x = (String) p.peak(); //asignar el nuevo "x"
                            }

                        } else {

                            System.out.println("Error Lexico/Sintactico --3--");
                            System.exit(0);

                        }

                    } else if (a.getClasificacion().equals("id")) {

                        if (x.equals(a.getClasificacion())) {

                            p.pop();
                            c.controlador(); // asignando el siguiente token a "a"

                            if (!a.getToken().equals(" ")) {
                                x = (String) p.peak(); //asignar el nuevo "x"
                            }

                        } else {

                            System.out.println("Error Lexico/Sintactico --3--");
                            System.exit(0);

                        }

                    } else if (a.getClasificacion().equals("Caracter Simple")) {

                        if (x.equals(a.getToken())) {

                            p.pop();
                            c.controlador(); // asignando el siguiente token a "a"
                            if (!a.getToken().equals(" ")) {
                                x = (String) p.peak(); //asignar el nuevo "x"
                            }

                        } else {

                            System.out.println("Error Lexico/Sintactico --3--");
                            System.exit(0);

                        }

                    } else if (a.getClasificacion().equals("intLiteral")) {

                        if (x.equals(a.getClasificacion())) {

                            p.pop();
                            c.controlador(); // asignando el siguiente token a "a"
                            if (!a.getToken().equals(" ")) {
                                x = (String) p.peak(); //asignar el nuevo "x"
                            }

                        } else {

                            System.out.println("Error Lexico/Sintactico --3--");
                            System.exit(0);

                        }

                    } else if (a.getClasificacion().equals("Operadores")) {

                        if (x.equals(a.getToken())) {

                            p.pop();
                            c.controlador(); // asignando el siguiente token a "a"
                            if (!a.getToken().equals(" ")) {
                                x = (String) p.peak(); //asignar el nuevo "x"
                            }
                            if (!a.getToken().equals(" ")) {
                                x = (String) p.peak(); //asignar el nuevo "x"
                            }

                        }

                    } else {
                        System.out.println("6");
                        System.out.println(x + " / " + a.getToken());

                        System.out.println("Error Lexico/Sintactico --3--");
                        System.exit(0);

                    }

                }

            }
        } catch (Exception e) {

            System.out.println("Error Lexico/Sintactico --1--");
            System.out.println(e);
            System.exit(0);

        }

        System.out.println(
                "El programa es sintacticamente aceptado :D");

    }
    
    private int posicionA() {

       
        if (a.getClasificacion().equals("Reservada")) {
//            System.out.println("1");

            for (int i = 0; i < e.simbolT.length; i++) {

                if (a.getToken().equals(e.simbolT[i])) {
                    
                    return i;
                }

            }

        } else if (a.getClasificacion().equals("id")) {
//            System.out.println("2");
            for (int i = 0; i < e.simbolT.length; i++) {

                if (a.getClasificacion().equals(e.simbolT[i])) {
                    return i;
                }

            }

        } else if (a.getClasificacion().equals("Caracter Simple")) {
//            System.out.println("3");
            for (int i = 0; i < e.simbolT.length; i++) {

                if (a.getToken().equals(e.simbolT[i])) {
                    return i;
                }

            }

        } else if (a.getClasificacion().equals("intLiteral")) {
//            System.out.println("4");
            for (int i = 0; i < e.simbolT.length; i++) {

                if (a.getClasificacion().equals(e.simbolT[i])) {
                    return i;
                }

            }

        } else if (a.getClasificacion().equals("Operadores")) {
//            System.out.println("5");
            for (int i = 0; i < e.simbolT.length; i++) {

                if (a.getToken().equals(e.simbolT[i])) {
                    return i;
                }

            }

        } else {

            return e.simbolT.length;

        }

        return e.simbolT.length;
    }

    private int posicionX() {

        for (int i = 0; i < e.simbolNT.length; i++) {

            if (x.equals(e.simbolNT[i])) {

                return i;

            }

        }

        return e.simbolNT.length;
    }

    private boolean isNoTerminal() {

        for (int i = 0; i < e.simbolNT.length; i++) {

            if (x.equals(e.simbolNT[i])) {

                return true;
            }

        }

        return false;
    }

}

