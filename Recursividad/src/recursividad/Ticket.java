    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursividad;

/**
 *
 * @author user
 */
public class Ticket {
    
    private String name;
    private double finalCostoTicket;
    private double originalCostoTicket;
    private boolean palindromo;
    int descuento;
    PalindromoAir palindrom;
    
    /*
    Representa un boleto emitido para un pasajero.
    Esta clase debe conservar tanto los datos utilizados 
    al momento de la compra como los resultados calculados (por ejemplo, si recibió descuento).
    
    Nombre del pasajero.
    Monto final pagado por el ticket.
    Monto original del ticket (antes del descuento).
    Indicación si el nombre fue reconocido como palíndromo. //Da un descuento si es palindromo
    
    Inicializa todos los atributos en base al nombre ingresado y el cálculo del sistema.
    
    getName(): Devuelve el nombre del pasajero.
    getFinalAmount(): Devuelve el monto final pagado.
    getOriginalAmount(): Devuelve el monto original del ticket.
    isPalindrome(): Indica si el pasajero recibió descuento por nombre palíndromo.
    print(): Imprime o muestra en la interfaz los datos del ticket: nombre, monto original, monto pagado, y si aplicó descuento.
    
    */
    public Ticket (String name)
    {
        
        this.name = name;
        this.originalCostoTicket = 500;
        palindromo = isPalindrome();
        finalCostoTicket = getFinalAmount();
        
    }
    
    
    public String getName()
    {
    return name;
    }
    
    public double getFinalAmount()
    {
        if (palindromo)
        {
        finalCostoTicket = originalCostoTicket-(originalCostoTicket * 0.2); //El descuento lo puse en 20%
        }
        else
        {
        finalCostoTicket = originalCostoTicket;
        }
    return finalCostoTicket;
    }
    
    public double getOriginalAmount()
    {
    return originalCostoTicket;
    }
    
    public boolean isPalindrome()
    {
        palindrom = new PalindromoAir();
    return palindrom.isPalindrome(name);
    
    }
    
    public String print()
    {
        //Retornara nombre , monto original , monto pagado , aplica descuento?
    String returnn = "Nombre:"+name+
                     "\nMonto Original:"+originalCostoTicket+
                     "\nMonto Pagado:"+finalCostoTicket+
                     "\nAplica Descuento:"+palindromo;
    return returnn;
        
    }
    
    
    
    
    
}
