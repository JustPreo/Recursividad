package recursividad;

public class PalindromoAir {

    private Ticket tickets[] = new Ticket[30];

    public boolean isPalindrome(String name) {

        if (name.length() <= 1) {
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
            return firstAvailable(index);
        }
        return firstAvailable(index + 1);
    }
    
    public int searchPassenger (String name, int index) {
        if (index >= 30) {
            return -1;
        }
        
        if (tickets[index] != null && tickets[index].getName().equalsIgnoreCase(name)) {
            return index;
        } else {
            return searchPassenger (name, index + 1);
        }
    }
    
    public void printPassengers(int index) {
        
    }
    
    public double income (int index, double suma) {
        if (index >= 30) {
            return suma;
        } 
        
        if (tickets[index] != null) {
            double finalAmount = tickets[index].getFinalAmount();
            suma += finalAmount;
        }
        return income (index + 1, suma);
    }
    
    public boolean reset(int index) {
        if (index >= 30) {
            return true;
        } else {
            tickets[index] = null;
            return reset(index + 1);
        }
    }
    
    public void sellTicket(String name) {
        
    }
    
    public boolean cancelTicket(String name) {
        int posAsiento = searchPassenger(name, 0);
        
        if (posAsiento != -1) {
            tickets[posAsiento] = null;
            return true;
        } else {
            String error = "Error: No se encontró dicho pasajero";
            return false;
        }
    }
    
    public void dispatch() {
        double totalGenerado = income(0,0);
        reset(0);
    }

}
