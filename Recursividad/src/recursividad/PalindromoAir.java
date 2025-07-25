package recursividad;

public class PalindromoAir {
    private Ticket tickets[] = new Ticket[30];
    
    public boolean isPalindrome(String name) {
        
        if (name.length() == 1){
            return false;
        }
        
        if (name.charAt(0) == name.charAt(name.length() - 1)) {
            return isPalindrome (name.substring(1, name.length() - 1));
        } else {
            return false;
        }
        
    }
    
}