package recursividad;

public class PalindromoAir {
    private Ticket tickets[] = new Ticket[30];
    
    public boolean isPalindrome(String name) {
        int i = 0;
        
        String nombreEvaluar = tickets[i].getName();
        int tamanioNombre = nombreEvaluar.length();
        
        if (nombreEvaluar.charAt(i) != nombreEvaluar.charAt(tamanioNombre - i)){
            return false;
        }
        
        return true;
    }
    
}
