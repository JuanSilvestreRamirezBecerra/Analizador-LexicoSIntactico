package Utilidades;


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
public class Estructuras {

    public  String[] producciones ={"iniciar","code","finalizar","forerunner","statement","variables","assignment","datatype","id",",",
                                    "other","int","string","do","sentences","while","condition","output","input","sentences","operation",
                                   "sentences","printf","(","chain",")",";","captura","id",";","id","=","+","id",";","cadena","concatenation",
                                    "cadena","+","id","+","cadena","+","id","+","cadena","+","id","id","==","char"};//Agregar producciones
    
    public String[] simbolNT ={"program","code","forerunner","assignment","other","datatype",
            "statement","sentences","output","input","operation","chain","concatenation","condition"};
    
    public String[] simbolT = {"iniciar","finalizar","variables","id",",","int","string","do","while",
            "printf","(",")",";","captura","cadena","+","==","char"};
    
    
    int contNT, contG, contT, contP;

    public Estructuras() {
        
        simbolT = new String[1];
        
        contNT = 0;
        contG = 0;
        contT = 0;
    }

}
