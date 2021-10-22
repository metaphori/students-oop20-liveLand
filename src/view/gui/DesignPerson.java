package view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JApplet;
import javax.swing.JPanel;

public class DesignPerson extends JPanel {
	
	/**
     * 
     */
        private static final long serialVersionUID = 1L;

        public static CircleImpl createAdult(int x, int y, int radius) {
            CircleImpl adult = new CircleImpl();
            adult.setColor(new Color(15,226,0));
            adult.setRadius(radius);
            adult.setX(x);
            adult.setY(y);
            return adult;
        }

        public static CircleImpl createBaby(int x, int y, int radius) {
            CircleImpl baby = new CircleImpl();
            baby.setColor(new Color(192,0,250));
            baby.setRadius(radius);
            baby.setX(x);
            baby.setY(y);
            return baby;
        }
        
        public static CircleImpl createPass(int x, int y, int radius) {
            CircleImpl pass = new CircleImpl();
            pass.setColor(new Color(0,155,232));
            pass.setRadius(radius);
            pass.setX(x);
            pass.setY(y);
            return pass;
        }

        
     
        /*
         * public class Movimento1 extends JApplet {
         * 
         * private JButton sposta; private Rectangle rettangolo; private PannelloDisegno
         * disegno; private int a, b;
         * 
         * public void init() { rettangolo = new Rectangle(0, 80, 40, 30);
         * 
         * // decido di quanto traslare il rettangolo: a = 5; b = 0;
         * 
         * // installo il ricevitore di eventi che viene // installato nel bottone. La
         * classe Ricevitore1 // e' una classe interna definita in questo file.
         * Ricevitore1 ricevitore1 = new Ricevitore1();
         * 
         * sposta = new JButton("sposta"); sposta.addActionListener(ricevitore1);
         * 
         * // costruisco un oggetto della classe interna PannelloDisegno // che contiene
         * il disegno del rettangolo rosso. // In un JApplet non si puo' disegnare
         * direttamente usando // il metodo paint() come negli Applet, ma il disegno va
         * // fatto in un oggetto a parte (di una classe che estende // JPanel). disegno
         * = new PannelloDisegno();
         * 
         * // imposto il layout: Container pannelloApplet = getContentPane();
         * pannelloApplet.setLayout(new BorderLayout()); pannelloApplet.add(sposta,
         * BorderLayout.SOUTH); pannelloApplet.add(disegno, BorderLayout.CENTER);
         * 
         * }
         * 
         * // classe interna che permette di definire il pannello // con il disegno del
         * rettangolo. La classe e' definita come // una sottoclasse di JPanel. Per
         * eseguire un disegno si // usa il metodo paintComponent(). La prima istruzione
         * del // metodo paintComponent DEVE essere super.paintComponent(..), // cioe'
         * di deve chiamare innanzitutto il metodo paintComponent() // della
         * superclasse. class PannelloDisegno extends JPanel { public void
         * paintComponent(Graphics g) { super.paintComponent(g); Graphics2D g2 =
         * (Graphics2D)g; rettangolo.translate(a, b); // traslo il quadrato di a, b
         * g2.setColor(Color.red); g2.fill(rettangolo); }
         * 
         * } // fine classe interna PannelloDisegno
         * 
         * // classe per il ricevitore di eventi del mouse. class Ricevitore1 implements
         * ActionListener { public void actionPerformed(ActionEvent e) { int x =
         * (int)rettangolo.getX(); // se il rettangolo e' scappato troppo a destra, //
         * lo riporto alla posizione iniziale: if (x > 200) rettangolo.translate(-x, 0);
         * disegno.repaint(); }
         * 
         * } // fine classe interna Ricevitor
         * 
         */

}
