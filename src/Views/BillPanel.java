package Views;

import Models.Order;
import Models.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BillPanel extends JPanel {

    private JLabel jLabelShowBill;
    public JFrameMain jFrame;
    private JButton jButtonBack;

    public BillPanel(JFrameMain jFrame) {
        this.jFrame = jFrame;
        double bill = getBill();
        ArrayList<Product> arrayListOfCurrentTableProducts = getAllItems();
        String products =
                arrayListOfCurrentTableProducts.toString()
                        .replace("[", "")
                        .replace("]", "");
        String message = products + " " + "Your  waiter was: " + JFrameMain.currentWaiter.getUserFullName()
                + " The bill for " + JFrameMain.currentTableId
                + " is total :" + bill + "BGN";
        jLabelShowBill = new JLabel(message);
        add(jLabelShowBill);

        jButtonBack = new JButton("Back");
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.billPanel.setVisible(false);
                remove(jFrame.billPanel);
                jFrame.showLoginPanel();
            }
        });

        add(jButtonBack);
    }

    public Double getBill() {
        //Sums the total bill of all the items of one order
        double totalSum = 0.0;
        //Holds the sum
        for (Order order : JFrameMain.orders) {
            if (order.getTableID().equals(JFrameMain.currentTableId)) {
                for (Product product : order.getProductArrayList()) {
                    totalSum += product.getProductPrice();
                }
                break;
            }
        }
        return totalSum;
    }


    public ArrayList<Product> getAllItems() {
        //Gets and returns the array of items for the Current table ID order
        ArrayList<Product> productArrayList = new ArrayList<>();
        for (Order order : JFrameMain.orders) {
            if (order.getTableID().equals(JFrameMain.currentTableId)) {

                productArrayList = order.getProductArrayList();

                break;
            }
        }
        return productArrayList;
    }


}
