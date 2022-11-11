package group3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for serialization
 * @author Joyce Weng
 * @author Tammy H Le
 * @version 12/06/2020
 */
public class CoffeeOrderCollection {

    //private field
    private ArrayList<CoffeeOrder> orderList;

    /**
     * Default constructor.
     */
    public CoffeeOrderCollection() {
        orderList = new ArrayList<>();
        readCollection();
    }

    /**
     * Adds a order to the collection. This method prevents the addition of
     * orders that already exist in the collection.
     *
     * @param order the order object to add
     * @return true if the order was added, false if not
     */
    public boolean addOrder(CoffeeOrder order) {
        System.out.println(order.getName().toString());
        boolean inDbAlready = false;
        for (int i = 0; i <= orderList.size() - 1; i++) {
            System.out.println("name of new order: " + order.getName().toString() + " Name of db order: " + orderList.get(i).getName().toString());
            String name1 = order.getName().toString();
            String name2 = orderList.get(i).getName();
            System.out.println(name1.equals(name2));
            if (name1.equals(name2)) {
                inDbAlready = true;
            }
        }

        System.out.println("Does DB contain new order: " + inDbAlready);
        if (!inDbAlready) {
            orderList.add(order);
            writeCollection();
            return true;
        }
        return false;
    }

    /**
     * Deletes a order from the collection.
     *
     * @param order the order object to delete.
     */
    public void deleteOrder(CoffeeOrder order) {
        for (int i = 0; i <= orderList.size() - 1; i++) {
            System.out.println("name of new order: " + order.getName().toString() + " Name of db order: " + orderList.get(i).getName().toString());
            String name1 = order.getName().toString();
            String name2 = orderList.get(i).getName();
            System.out.println(name1.equals(name2));
            if (name1.equals(name2)) {
                orderList.remove(i);
                writeCollection();
            }
        }

    }

    /**
     * Provides access to the collection of orders as a sorted array.
     *
     * @return the sorted array
     */
    public CoffeeOrder[] getSortedArray() {
        Collections.sort(orderList);
        //make sure to implement the comparable for this to work
        CoffeeOrder[] listToReturn = orderList.toArray(new CoffeeOrder[orderList.size()]);
        System.out.println("Returning CoffeeOrder Array, size: " + listToReturn.length);

        return listToReturn;
    }

    /**
     * Private method to write collection to a file.
     *
     * @return true if saved, false if not
     */
    private boolean writeCollection() {
        boolean success = true;
        try (FileOutputStream fos = new FileOutputStream("orders.ser");
                ObjectOutputStream output = new ObjectOutputStream(fos)) {
            output.writeObject(orderList);
        } catch (Exception ex) {
            System.out.println("Cannot write to file:\n" + ex.getMessage());
            success = false;
        }
        return success;
    }

    /**
     * Private method to read collection from a file.
     *
     * @return true if read, false if not
     */
    private boolean readCollection() {
        boolean success = true;
        File ser = new File("orders.ser");
        if (ser.exists()) {
            try (FileInputStream fis = new FileInputStream("orders.ser");
                    ObjectInputStream input = new ObjectInputStream(fis)) {
                orderList = (ArrayList<CoffeeOrder>) input.readObject();
            } catch (Exception ex) {
                System.out.println("Cannot read from file:\n" + ex.getMessage());
                success = false;
            }
        }
        return success;
    }
}
