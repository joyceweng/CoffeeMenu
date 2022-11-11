package group3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * The GUI class
 *
 * @author Phuoc Nguyen
 * @author Tammy H Le
 * @author Joyce Weng
 * @version 12/06/2020
 */
public class CoffeeOrderView extends JFrame {

    ArrayList<ArrayList> orderList;
    CoffeeOrderCollection collection;
    JTextField txtName;
    JTextArea txtReceipt;
    JButton btnEdit;
    JButton btnDelete;
    JButton btnDone;
    JComboBox cmboName;
    JComboBox cmboCoffee;
    JComboBox cmboFlavor;
    JComboBox cmboSize;
    CoffeeOrder order;
    JButton btnViewOrder;

    /**
     * Constructor
     *
     * @param title the frame title
     */
    public CoffeeOrderView(String title) {
        super(title);
        collection = new CoffeeOrderCollection();
        orderList = new ArrayList<>();
        cmboName = new JComboBox();
        CoffeeOrder[] savedOrderList = collection.getSortedArray();
        for (CoffeeOrder savedOrderList1 : savedOrderList) {
            cmboName.addItem(savedOrderList1.getName());
            cmboName.setSelectedIndex(0);
            ArrayList orderAsList = new ArrayList();
            orderAsList.add(savedOrderList1.getName());
            orderAsList.add(savedOrderList1.getCoffeeTemp());
            orderAsList.add(savedOrderList1.getCoffeeFlavor());
            orderAsList.add(savedOrderList1.getCoffeeSize());
            orderList.add(orderAsList);
        }
        addComponents();
        addEventHandlers();
    }

    /**
     * Private method used to add components to the frame.
     */
    private void addComponents() {
        //panel north contains Shop's name
        JPanel pnlNorth = new JPanel();
        JLabel lblName = new JLabel("New Order Name: ");
        txtName = new JTextField(20);
        pnlNorth.add(lblName);
        pnlNorth.add(txtName);
        this.add(pnlNorth, BorderLayout.NORTH);
        //panel south contains all the note that user need to read
        JPanel pnlSouth = new JPanel();
        JLabel lblNote1 = new JLabel("*Click on Done to order the coffee");
        JLabel lblNote2 = new JLabel("*Click on Delete to delete the selected order");
        JLabel lblNote3 = new JLabel("*Click on View Order to view your order");
        pnlSouth.setLayout(new BoxLayout(pnlSouth, BoxLayout.Y_AXIS));
        pnlSouth.add(lblNote1);
        pnlSouth.add(lblNote2);
        pnlSouth.add(lblNote3);
        this.add(pnlSouth, BorderLayout.SOUTH);
        //create panel contains buttons and Jtextfield that will print the receipt
        JPanel pnlButton = new JPanel();
        txtReceipt = new JTextArea();
        txtReceipt.setLineWrap(true);
        txtReceipt.setEditable(false);
        txtReceipt.setPreferredSize(new Dimension(300, 200));
        JPanel pnlFunction = new JPanel();
        btnEdit = new JButton("Edit");
        btnDelete = new JButton("Delete");
        btnDone = new JButton("Done");
        pnlFunction.setLayout(new BoxLayout(pnlFunction, BoxLayout.Y_AXIS));
        pnlButton.setLayout(new BoxLayout(pnlButton, BoxLayout.X_AXIS));
        pnlButton.add(btnEdit);
        pnlButton.add(btnDelete);
        pnlButton.add(btnDone);
        pnlFunction.add(txtReceipt);
        pnlFunction.add(pnlButton);
        //create panel contain JComboBoxes
        JPanel pnlCmbo = new JPanel();
        JLabel lblOrder = new JLabel("Order:  ");
        btnViewOrder = new JButton("View Order");
        pnlCmbo.add(lblOrder);
        pnlCmbo.add(cmboName);
        pnlCmbo.add(btnViewOrder);
        //create panel for coffee        
        JPanel pnlCof = new JPanel();
        JLabel lblCof = new JLabel("COFFEE:  ");
        cmboCoffee = new JComboBox();
        pnlCof.setLayout(new FlowLayout());
        pnlCof.add(lblCof);
        pnlCof.add(cmboCoffee);
        cmboCoffee.addItem("Hot");
        cmboCoffee.addItem("Cold");
        //create a panel for Coffee Flavor
        JPanel pnlFla = new JPanel();
        JLabel lblFla = new JLabel("COFFEE FLAVOR:  ");
        cmboFlavor = new JComboBox();
        pnlFla.setLayout(new FlowLayout());
        pnlFla.add(lblFla);
        pnlFla.add(cmboFlavor);
        cmboFlavor.addItem("Vanilla");
        cmboFlavor.addItem("French Vanilla");
        cmboFlavor.addItem("Caramel");
        cmboFlavor.addItem("Mocha");
        cmboFlavor.addItem("Hazelnut");
        JLabel lblVanilla = new JLabel("Vanilla   (S: $3.99     L: $4.99)");
        JLabel lblFrenchVanilla = new JLabel("French Vanilla   (S: $4.49     L: $5.49)");
        JLabel lblCaramel = new JLabel("Caramel   (S: $3.99     L: $4.99)");
        JLabel lblMocha = new JLabel("Mocha   (S: $4.99     L: $5.99)");
        JLabel lblHazelnut = new JLabel("Hazelnut   (S: $4.49     L: $5.49)");
        GridBagConstraints gbc = new GridBagConstraints();
        pnlFla.setLayout(new GridBagLayout());
        gbc.gridwidth = 2;
        gbc.gridx = 4;
        gbc.gridy = 1;
        pnlFla.add(lblFla, gbc);
        gbc.gridx = 4;
        gbc.gridy = 2;
        pnlFla.add(cmboFlavor, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        pnlFla.add(lblVanilla, gbc);
        gbc.gridx = 6;
        gbc.gridy = 3;
        pnlFla.add(lblFrenchVanilla, gbc);
        gbc.gridx = 2;
        gbc.gridy = 5;
        pnlFla.add(lblCaramel, gbc);
        gbc.gridx = 6;
        gbc.gridy = 5;
        pnlFla.add(lblMocha, gbc);
        gbc.gridx = 2;
        gbc.gridy = 7;
        pnlFla.add(lblHazelnut, gbc);
        //create a panel for Coffee Size
        JPanel pnlSize = new JPanel();
        JLabel lblSize = new JLabel("SIZE:  ");
        cmboSize = new JComboBox();
        pnlSize.setLayout(new FlowLayout());
        pnlSize.add(lblSize);
        pnlSize.add(cmboSize);
        cmboSize.addItem("Small");
        cmboSize.addItem("Large");
        //adding to panel Menu
        JPanel pnlMenu = new JPanel();
        pnlMenu.setLayout(new BoxLayout(pnlMenu, BoxLayout.Y_AXIS));
        pnlMenu.add(pnlCmbo);
        pnlMenu.add(pnlCof);
        pnlMenu.add(pnlFla);
        pnlMenu.add(pnlSize);
        //Panel Center
        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.X_AXIS));
        pnlCenter.add(pnlMenu);
        pnlCenter.add(pnlFunction);
        this.add(pnlCenter, BorderLayout.CENTER);
        //set border for the panels
        pnlMenu.setBorder(new LineBorder(Color.BLACK, 1));
        pnlFla.setBorder(new LineBorder(Color.BLACK, 1));
        pnlCof.setBorder(new LineBorder(Color.BLACK, 1));
        pnlSize.setBorder(new LineBorder(Color.BLACK, 1));
        pnlCmbo.setBorder(new LineBorder(Color.BLACK, 1));
    }

    /**
     * private method to save into database when the Done button is clicked
     *
     * @return order
     */
    private boolean saveDoneToDB() {
        //saving orders to database
        System.out.println("btnDone.addAction functions is started");
        order = new CoffeeOrder();
        order.setName(txtName.getText());
        order.setCoffeeFlavor(cmboFlavor.getSelectedItem().toString().toLowerCase());
        order.setCoffeeIsCold(cmboCoffee.getSelectedItem().toString().equals("Cold"));
        order.setCoffeeIsLarge(cmboSize.getSelectedItem().toString().equals("Large"));
        order.setPrice(order.calculate());
        return collection.addOrder(order);
    }

    /**
     * private method to save into database when the delete button is clicked
     */
    private void saveDeleteToDB() {
        //saving orders to database
        System.out.println("btnDelete.addAction functions is started");
        order = new CoffeeOrder();
        order.setName(cmboName.getSelectedItem().toString());
        order.setCoffeeFlavor(cmboFlavor.getSelectedItem().toString());
        order.setCoffeeIsCold(cmboCoffee.getSelectedItem().toString().equals("Cold"));
        order.setCoffeeIsLarge(cmboSize.getSelectedItem().toString().equals("Large"));
        collection.deleteOrder(order);
    }

    /**
     * private method to delete order from combo box
     */
    private void deleteFromOrderList() {
        for (int i = 1; i < orderList.size(); i++) {
            if (cmboName.getSelectedItem().toString().equals(orderList.get(i).get(0))) {
                System.out.println(orderList.get(i));
                System.out.println("index: " + i);
                orderList.remove(i);
            }
        }
    }

    /**
     * private method to display the all information of an order on text area
     */
    private void displayReceipt() {
        txtReceipt.setText("");
        txtReceipt.append("=============================\n");
        txtReceipt.append("Name: " + txtName.getText());
        txtReceipt.append("\n");
        txtReceipt.append("Coffee: " + order.getCoffeeTemp());
        txtReceipt.append("\n");
        txtReceipt.append("Flavor: " + order.getCoffeeFlavor());
        txtReceipt.append("\n");
        txtReceipt.append("Size: " + order.getCoffeeSize());
        txtReceipt.append("\n");
        txtReceipt.append("Total: $" + order.getPrice() + "\n");
        txtReceipt.append("=============================\n");
    }

    /**
     * private method used to set up event handlers for all button and combo box
     */
    private void addEventHandlers() {
        //update btnDone 
        btnDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtName.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter your name");
                } else {
                    boolean responseFromDB = saveDoneToDB();
                    System.out.println("Response from DB for save: " + responseFromDB);
                    if (responseFromDB) {
                        cmboName.getSelectedItem();
                        cmboCoffee.getSelectedItem();
                        cmboFlavor.getSelectedItem();
                        cmboSize.getSelectedItem();
                        txtName.getText();
                        ArrayList orderAsList = new ArrayList();
                        orderAsList.add(txtName.getText());
                        orderAsList.add(cmboCoffee.getSelectedItem().toString());
                        orderAsList.add(cmboFlavor.getSelectedItem().toString());
                        orderAsList.add(cmboSize.getSelectedItem().toString());
                        orderList.add(orderAsList);
                        cmboName.addItem(order.getName());
                        cmboName.setSelectedIndex(cmboName.getItemCount() - 1);
                        displayReceipt();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Duplicate name - cannot add.");
                    }
                }
            }
        }
        );
        //update delete button
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDeleteToDB();
                deleteFromOrderList();
                cmboName.removeItem(cmboName.getSelectedItem());
            }

        });
        //update/edit button
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete then add
                //delete
                saveDeleteToDB();
                deleteFromOrderList();
                cmboName.removeItem(cmboName.getSelectedItem());
                boolean responseFromDB = saveDoneToDB();
                if (responseFromDB) {
                    cmboName.getSelectedItem();
                    cmboCoffee.getSelectedItem();
                    cmboFlavor.getSelectedItem();
                    cmboSize.getSelectedItem();
                    txtName.getText();
                    ArrayList orderAsList = new ArrayList();
                    orderAsList.add(txtName.getText());
                    orderAsList.add(cmboCoffee.getSelectedItem().toString());
                    orderAsList.add(cmboFlavor.getSelectedItem().toString());
                    orderAsList.add(cmboSize.getSelectedItem().toString());
                    orderList.add(orderAsList);
                    cmboName.addItem(order.getName());
                    cmboName.updateUI();
                    cmboName.setSelectedItem(cmboName.getItemCount() - 1);
                    displayReceipt();
                }
            }
        }
        );
        //update btnViewOrder
        btnViewOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean found = false;
                for (int i = 0; i < orderList.size() && !found; i++) {
                    if (cmboName.getSelectedItem().toString().equals(orderList.get(i).get(0))) {
                        found = true;
                        System.out.println(orderList.get(i));
                        txtName.setText(cmboName.getSelectedItem().toString());
                        txtReceipt.setText("");
                        txtReceipt.append("======SELECTED ORDER=======\n");
                        txtReceipt.append("Name: " + orderList.get(i).get(0));
                        txtReceipt.append("\n");
                        txtReceipt.append("Coffee: " + orderList.get(i).get(1));
                        txtReceipt.append("\n");
                        txtReceipt.append("Flavor: " + orderList.get(i).get(2));
                        txtReceipt.append("\n");
                        txtReceipt.append("Size: " + orderList.get(i).get(3));
                        txtReceipt.append("\n");
                        txtReceipt.append("=============================\n");
                    }
                }
            }
        });
    }
}
