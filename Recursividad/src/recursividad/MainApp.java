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
    private JLabel JLabel1;
    private JTextField nombreP, precioP;
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
        
        precioP = new JTextField();
        precioP.setBounds(300, 700, 150, 50);
        add(precioP);

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
                if (!(precioP.getText().equals("") && nombreP.getText().equals(""))) {
                    try {
                        double precio = Double.parseDouble(precioP.getText());
                        Ticket ticket = new Ticket(nombreP.getText(), precio);
                        palindrome.firstAvailable(asientosOcupados);
                        botones[asientosOcupados].setBackground(Color.red);
                        asientosOcupados++;
                    } catch (InputMismatchException a) {
                        JOptionPane.showMessageDialog(null, "Ocupa ingresar un numero valido");
                    }
repaint();
                }
                
                else
                {
                JOptionPane.showMessageDialog(null, "No puedes dejar los requisitos vacios \n"+ "Nombre Y Precio");
                
                }

            }
        });

        Cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        Dispatch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        Print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        View.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        Search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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
                JButton asiento = new JButton();
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

}
