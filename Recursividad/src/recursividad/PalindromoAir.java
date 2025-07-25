package recursividad;

public class PalindromoAir {

    private Ticket tickets[] = new Ticket[30];

    public boolean isPalindrome(String name) {

        if (name.length() == 1) {
            return false;
        }

        if (name.charAt(0) == name.charAt(name.length() - 1)) {
            return isPalindrome(name.substring(1, name.length() - 1));
        } else {
            return false;
        }

    }

    public int firstAvailable(int index) {

        if (index >= 30) {
            return -1;
        }
        
        if (tickets[index] == null) {
            return firstAvailable(index + 1);
        } else {
            return index;
        }
    }
    
    public int searchPassenger (String name, int index) {
        if (index >= 30) {
            return -1;
        }
        
        if (tickets[index].getName().equalsIgnoreCase(name)) {
            return index;
        } else {
            return searchPassenger (name, index + 1);
        }
    }
    
    public void printPassengers(int index) {
        
    }
    
    public void income (int index) {
        
    }

}
