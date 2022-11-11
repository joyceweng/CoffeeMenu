package group3;

import javax.swing.JFrame;

/**
 * main class for the project
 * @author Phuoc Nguyen
 * @author Joyce Weng
 * @author Tammy H Le
 * @version 12/06/2020
 */
public class CS141FinalProject {

    /**
     * main method for the project
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CoffeeOrderView view = new CoffeeOrderView("SHOP NAME");
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.pack();
        view.setVisible(true);
    }
    
}
