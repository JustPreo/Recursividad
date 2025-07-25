package recursividad;

import javax.swing.JOptionPane;

public class PalindromoAir {

    public static Ticket tickets[] = new Ticket[30];

    public boolean isPalindrome(String name) {

        if (name.length() <= 1) {
            return true;
        }

        if (name.charAt(0) == name.charAt(name.length() - 1)) {
            return isPalindrome(name.substring(1, name.length() - 1));
        } else {
            return false;
        }

    }

    public int firstAvailable(int index) {

        if (index >= tickets.length) {
            return -1;
        }
        
        if (tickets[index] == null) {
            return index;
        }
        return firstAvailable(index + 1);
    }
    
    public int searchPassenger (String name, int index) {
        if (index >= tickets.length) {
            return -1;
        }
        
        if (tickets[index] != null && tickets[index].getName().equalsIgnoreCase(name)) {
            return index;
        } else {
            return searchPassenger (name, index + 1);
        }
    }
    
    public String[] printPassengers(int index, String datos[]) {
        if (index >= tickets.length) {
            return datos;
        } 
        if (tickets[index] != null) {
        datos[index] = "Nombre: " + tickets[index].getName() + " Monto original: " + tickets[index].getOriginalAmount()
                + " Monto final: " + tickets[index].getFinalAmount();
        } else {
            datos[index] = "Asiento vacío";
        }
        return printPassengers(index + 1, datos);
    }
    
    public double income (int index, double suma) {
        if (index >= tickets.length) {
            return suma;
        } 
        
        if (tickets[index] != null) {
            double finalAmount = tickets[index].getFinalAmount();
            suma += finalAmount;
        }
        return income (index + 1, suma);
    }
    
    public boolean reset(int index) {
        if (index >= tickets.length) {
            return true;
        } else {
            tickets[index] = null;
            return reset(index + 1);
        }
    }
    
    public void sellTicket(String name) {
        int asiento = firstAvailable(0);
        if (firstAvailable(0) == -1){
            String error = "Error: no hay asientos disponibles";
            JOptionPane.showMessageDialog(null, error);
        } else {
            tickets[asiento] = new Ticket(name);
            
        }
    }
    
    public boolean cancelTicket(String name) {
        int posAsiento = searchPassenger(name, 0);
        
        if (posAsiento != -1) {
            tickets[posAsiento] = null;
            return true;
        } else {
            //falta mensaje de error
            return false;
        }
    }
    
    public void dispatch() {
        double totalGenerado = income(0,0);
        reset(0);
    }

}
