package recursividad;

public class PalindromoAir {
    private Ticket tickets[] = new Ticket[30];
    
    public boolean isPalindrome(String name, int index) {
        
        if (name.charAt(index) != name.charAt(name.length() - index)){
            return false;
        }
        
        return true;
    }
    
}