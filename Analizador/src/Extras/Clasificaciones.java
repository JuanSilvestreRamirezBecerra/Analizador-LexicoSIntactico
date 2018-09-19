
package Extras;

/**
 *
 * @author 
 *  Ortiz Arenas Argel
 *  12/09/2018
 * 
 * Clasificaciones de los recursos gramaticales
 * necesarios para la identificacion lexica
 */
public class Clasificaciones {
    
    private final String letterMin = "abcdefghijklmnñopqrstuvwxyz";
    private final String letterMay = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private final String acentMin = "áéíóú";
    private final String acentMay = "ÁÉÍÓÚ";
    private final String[] reservadas = {"Iniciar","Finalizar","Variables","int","String","do","while","printf","$"};
    private final String comillaDoble = "\"";
    
    public Clasificaciones(){
        
        
    }
    
    public Boolean isComillaDoble(char simbolo){
        return simbolo == comillaDoble.charAt(0);
    }
    
    public Boolean isLetterMin(char simbolo) {

        for (int i = 0; i < letterMin.length(); i++) {
            if (simbolo == letterMin.charAt(i)) {
                return  true;
                
            } 
        }
        return false;
    }
    
    public Boolean isLetterMay(char simbolo) {

        for (int i = 0; i < letterMay.length(); i++) {
            if (simbolo == letterMay.charAt(i)) {
                return  true;
                
            } 
        }
        return false;
    }
    
    public Boolean isAcentMin(char simbolo) {

        for (int i = 0; i < acentMin.length(); i++) {
            if (simbolo == acentMin.charAt(i)) {
                return  true;
                
            } 
        }
        return false;
    }
    
    public Boolean isAcentMay(char simbolo) {

        for (int i = 0; i < acentMay.length(); i++) {
            if (simbolo == acentMay.charAt(i)) {
                return  true;
                
            } 
        }
        return false;
    }
    
    public Boolean isWhite(char simbolo) {
        if (simbolo == ' ' || simbolo == '\n' || simbolo == '\t' || simbolo == '\r') {

            return true;
        } 
        
        return false;
    }
    
    public boolean isReservada(String token){
        
        for (int i = 0; i < reservadas.length; i++) {
            
            if (token.equals(reservadas[i])) {
                
                return true;
            }
            
        }
        
        return false;
    }
    
}
