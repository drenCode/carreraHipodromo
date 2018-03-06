package carreraHipodromo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Scanner;

public class Carrera extends JFrame {
	
	JPanel[] paneles;
	JLabel[] labels;
	String[] nombres = {"Imperioso","Pegaso","Perdigon","Babieca"};
	JButton boton;
	int ancho = 400;
	
	public Carrera() {
		setLayout(new GridLayout(0,1));
		paneles = new JPanel[4];
		labels = new JLabel[4];
			
			for(int i = 0; i<4;i++) {
				paneles[i] = new JPanel();
				add(paneles[i]);
				labels[i] = new JLabel(nombres[i]);
				labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i]+".gif")));
				paneles[i].add(labels[i]);
			}
			boton = new JButton("Comenzar");
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			add(boton);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocation(200,250);
			setSize(ancho,200);
			setVisible(true);
	}

    private static Scanner teclado;

	public static void main(String[] args) {
       Carrera carrera = new Carrera();
        teclado = new Scanner(System.in);
        
        Hilo Imperioso;
        Hilo Pegaso;
        Hilo Perdigon;
        Hilo Babieca;

        int saldo = 1000;
        int apuesta = 0;
        
        Imperioso = new Hilo("Imperioso");
        Pegaso = new Hilo("Pegaso");
        Perdigon = new Hilo("Perdigon");
        Babieca = new Hilo("Babieca");
        
        System.out.println("-- ¡La carrera va a empezar! --");
        
        System.out.println("Por quien quieres apostar?-");
        System.out.println("Imperioso -> 2 a 1");
        System.out.println("Pegaso -> 3 a 1");
        System.out.println("Perdigon -> 5 a 1");
        System.out.println("Babieca -> 7 a 1");
        System.out.println("-- ¡Hagan sus apuestas! --");
        String jugadorApostado = teclado.next();
        
        System.out.println("Cuanto quieres apostar? Tienes: " + saldo + " €");
        apuesta = teclado.nextInt();
        

        while(apuesta > saldo){
            System.out.println("Lo siento vuelve a probar:");
            apuesta = teclado.nextInt();
        }
        
        Imperioso.start();
        Pegaso.start();
        Perdigon.start();
        Babieca.start();

     
        while(!Hilo.interrupted()){
            if(Imperioso.getTiempoDormido()>=20){

            	Pegaso.interrupt();
            	Perdigon.interrupt();
            	Babieca.interrupt();
            	 System.exit(0);
                if(jugadorApostado.equalsIgnoreCase("Imperioso")){
                    int nuevoSaldo = saldo + apuesta*2;
                    System.out.println("¡Has ganado " + apuesta*2 + " €! Tu nuevo saldo es " + nuevoSaldo + " €");
                }else{
                    int nuevoSaldo = saldo - apuesta;
                    System.out.println("Has perdido la apuesta ): te quedan: " + nuevoSaldo + " €");
                }
   
                System.exit(0);
            }

            else if (Pegaso.getTiempoDormido()>=20){
         
            	Imperioso.interrupt();
            	Perdigon.interrupt();
            	Babieca.interrupt();
            	
                if(jugadorApostado.equalsIgnoreCase("Pegaso")){
                    int nuevoSaldo = saldo + apuesta*3;
                    System.out.println("¡Has ganado " + apuesta*2 + " €! Tu nuevo saldo es " + nuevoSaldo + " €");
                   
                }else{
                    int nuevoSaldo = saldo - apuesta;
                    System.out.println("Has perdido la apuesta ): te quedan: " + nuevoSaldo + " €");
                }
              
                System.exit(0);
            } else if (Perdigon.getTiempoDormido()>=20){

            	Imperioso.interrupt();
            	Pegaso.interrupt();
            	Babieca.interrupt();
            
                if(jugadorApostado.equalsIgnoreCase("Perdigon")){
                    int nuevoSaldo = saldo + apuesta*5;
                    System.out.println("¡Has ganado " + apuesta*2 + " €! Tu nuevo saldo es " + nuevoSaldo + " €");
                   
                }else{
                    int nuevoSaldo = saldo - apuesta;
                    System.out.println("Has perdido la apuesta ): te quedan: " + nuevoSaldo + " €");
                }

                System.exit(0);
            }else if (Babieca.getTiempoDormido()>=20){

            	Imperioso.interrupt();
            	Pegaso.interrupt();
            	Perdigon.interrupt();
            	
                if(jugadorApostado.equalsIgnoreCase("Babieca")){
                    int nuevoSaldo = saldo + apuesta*7;
                    System.out.println("¡Has ganado " + apuesta*2 + " €! Tu nuevo saldo es " + nuevoSaldo + " €");
                }else{
                    int nuevoSaldo = saldo - apuesta;
                    System.out.println("Has perdido la apuesta ): te quedan: " + nuevoSaldo + " €");
                    System.exit(0);
                }
                System.exit(0); 
            }
        }
    }
   }
	