/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursividad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javax.swing.*;

/*
    Botones funcionales:
    "Sell Ticket"
    "Cancel Ticket"
    "Dispatch"
    "Print Passengers"
    "View Income"
    "Search Passenger"
    Área de mensajes o consola visual: Muestra confirmaciones, errores, resultados de operaciones y mensajes de sistema.
    Colores recomendados:
    Verde para asientos disponibles.
    Rojo para asientos ocupados.
    Azul o dorado para asientos ocupados por pasajeros con nombre palíndromo.
 */
public class MainApp extends JFrame {

    private JButton Sell, Cancel, Dispatch, Print, View, Search;
    private JLabel nombrePasajero;
    private JTextField nombreP;
    Ticket ticket;
    PalindromoAir palindrome;
    JButton[] botones;
    int contador;
    int asientosOcupados;

    public MainApp(PalindromoAir palindrome) {
        contador = 0;
        asientosOcupados = 0;
        botones = new JButton[30];
        this.ticket = ticket;
        this.palindrome = palindrome;
        setTitle("Spirit Airlines");
        setSize(900, 800);
        System.out.println(this.getHeight());
        System.out.println(this.getWidth());

        //Nombre pasajero supongo y precio
        nombreP = new JTextField();
        nombreP.setBounds(0, 700, 150, 50);
        add(nombreP);
        
        nombrePasajero = new JLabel("Nombre del pasajero");
        nombrePasajero.setBounds(20,650,150,50);
        add(nombrePasajero);
        

        //Creacion de botones
        Sell = new JButton();
        Sell = new JButton("Sell Ticket");
        Sell.setBounds(0, 600, 150, 50); //X , Y , WIDTH , HEIGHT
        add(Sell);

        Cancel = new JButton();
        Cancel = new JButton("Cancel Ticket");
        Cancel.setBounds(150, 600, 150, 50); //X , Y , WIDTH , HEIGHT
        add(Cancel);

        Dispatch = new JButton();
        Dispatch = new JButton("Dispatch");
        Dispatch.setBounds(300, 600, 150, 50); //X , Y , WIDTH , HEIGHT
        add(Dispatch);

        Print = new JButton();
        Print = new JButton("Print Passengers");
        Print.setBounds(450, 600, 150, 50); //X , Y , WIDTH , HEIGHT
        add(Print);

        View = new JButton();
        View = new JButton("View Income");
        View.setBounds(600, 600, 150, 50); //X , Y , WIDTH , HEIGHT
        add(View);

        Search = new JButton();
        Search = new JButton("Search Passenger");
        Search.setBounds(750, 600, 150, 50); //X , Y , WIDTH , HEIGHT
        add(Search);

        //Action Listeners
        Sell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!(nombreP.getText().equals("")) && asientosOcupados != 30) {
                    try {

                        int numero = palindrome.sellTicket(nombreP.getText());

                        if (PalindromoAir.tickets[numero]!= null && PalindromoAir.tickets[numero].isPalindrome()) {
                            botones[numero].setBackground(new Color(239, 184, 16));
                        } else {
                            botones[numero].setBackground(Color.red);
                        }
                        nombreP.setText("");
                        asientosOcupados++;
                    } catch (InputMismatchException a) {
                        JOptionPane.showMessageDialog(null, "Ocupa ingresar un numero valido");
                    }
                    repaint();
                } else if (nombreP.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "No puedes dejar los requisitos vacios \n" + "                   Nombre ");
                } else {
                    nombreP.setText("");
                    JOptionPane.showMessageDialog(null, "ERROR:No hay asientos disponibles");
                }

            }
        });

        Cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!(nombreP.getText().equals(""))) {
                    int index = palindrome.searchPassenger(nombreP.getText(), 0);
                    System.out.println(index);
                    palindrome.cancelTicket(nombreP.getText());
                     if (index != -1)
                     {
                     botones[index].setBackground(Color.green);
                     }
                     repaint();
                     asientosOcupados--;
                }
                else
                {
                JOptionPane.showMessageDialog(null, "ERROR:Pasajero no encontrado");
                }

            }
        });

        Dispatch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                palindrome.dispatch();
                for (JButton variable : botones) {
                    variable.setBackground(Color.green);
                }
                asientosOcupados = 0;
            }
        });

        Print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPasajerosSimples();

            }
        });

        View.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double dinerodineros = palindrome.income(0, 0);
                JOptionPane.showMessageDialog(null, "Tu ingreso actual es de : " + dinerodineros);

            }
        });

        Search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (!(nombreP.getText().equals(""))) {
                    int index = palindrome.searchPassenger(nombreP.getText(), 0);

                    if (index != -1) {
                        JOptionPane.showMessageDialog(null, "El pasajero esta en el asiento " + (index + 1));
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR:Pasajero no encontrado");

                    }
                    
                    
                }
                
                else
                {
                JOptionPane.showMessageDialog(null, "ERROR:No puedes dejar el campo vacio");
                }

            }
        });

        //Propiedades de ventana
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        spawnear();
        setVisible(true);

    }

    public void spawnear() {

        for (int r = 1; r <= 6; r++) {
            for (int c = 1; c <= 5; c++) {
                JButton asiento = new JButton(""+(contador+1));
                asiento.setBounds((r * 100) + 50, c * 100, 100, 100);
                add(asiento);

                /*
                Verde para asientos disponibles.
                Rojo para asientos ocupados.
                Azul o dorado para asientos ocupados por pasajeros con nombre palíndromo.
                 */
                botones[contador] = asiento;
                asiento.setBackground(Color.GREEN);
                System.out.println(contador);
                contador++;

            }

        }

    }

    public void mostrarPasajerosSimples() {
        String[] resultado = palindrome.printPassengers(0, new String[30]);
        StringBuilder elStringComoTal = new StringBuilder();

        for (int i = 0; i < resultado.length; i++) {
            elStringComoTal.append("Asiento " + (i + 1) + ":" + resultado[i] + "\n");
        }

        JTextArea muchoTexto = new JTextArea(elStringComoTal.toString());
        muchoTexto.setRows(35);
        muchoTexto.setColumns(50);

        muchoTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(muchoTexto);

        JOptionPane.showMessageDialog(null, scroll, "Lista de Pasajeros", JOptionPane.INFORMATION_MESSAGE);
    }

}
