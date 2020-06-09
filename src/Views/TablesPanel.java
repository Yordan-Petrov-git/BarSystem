package Views;

import Helpers.InitializeObjects;
import Models.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablesPanel extends JPanel {

    private JButton jButtonBack;
    private JButton jButtonTable;
    public JFrameMain jFrame;
    public static int clickedButton;

    public TablesPanel(JFrameMain jFrame) {
        this.jFrame = jFrame;


        jButtonBack = new JButton("Back");
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.tablesPanel.setVisible(false);
                remove(jFrame.tablesPanel);
                jFrame.showLoginPanel();
            }
        });


        int tableCount = 5;
        //Variable for the table count
        //How much tables do we want
        for (int i = 0; i <= tableCount; i++) {
            //Creates the buttons for the tables
            add(button("Table " + i));
        }

    }

    private JButton button(String buttonName) {
        //Creates new button for the items
        jButtonTable = new JButton(buttonName);
        jButtonTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Button for the selected table ID
                String tableId = ((JButton) e.getSource()).getText();
                //Gets current table id
                JFrameMain.currentTableId = tableId;
                //Gets the clicked button text
                boolean isOrderFound = false;
                //boolean for search state
                //Searching for the order in the arrayList
                for (Order order : JFrameMain.orders) {
                    //Iterates through the arrayList containing orders
                    if (order.getTableID().equals(tableId)) {
                        //If the order is for the current table
                        JFrameMain.currentOrder = order;
                        //Saves the selected order for later use
                        isOrderFound = true;
                        //If order is found
                        orderFound();
                        break;
                    }
                }
                if (!isOrderFound) {
                    //if the order is not found
                    orderNotFound(tableId);
                }

            }
        });
        return jButtonTable;
    }

    public void orderFound() {
        //Method for when the order is found in the arrayList Orders

        switch (clickedButton) {
            //Switching between the 3 buttons from the Menu
            //1 -> new order
            //2 -> add to existing order
            //3 -> show bill
            case 1:
                //1 -> New order option : 1 order found : popup the order already exists
                JOptionPane.showMessageDialog(null
                        , "Order for the selected table already exists"
                        , "Order exists"
                        , JOptionPane.INFORMATION_MESSAGE);

                break;

            case 2:
                //2 -> Existing order option : order found : go to the panel with the items
                //:TODO ADD resetExistingOrderProductArrayList();
                jFrame.showItemsPanel();

                break;

            case 3:
                //3 -> Get Bill option : order found : go to get bill panel
                jFrame.showBillPanel();

                break;

            default:
                //When no valid button is pressed
                System.out.println("No valid menu option selected");

                break;

        }
    }

    public void orderNotFound(String tableId) {
        //Method that activates if no order is found in the arrayList Orders

        switch (clickedButton) {
            //Switching between the 3 buttons from the Menu
            //1 -> new order
            //2 -> add to existing order
            //3 -> show bill
            case 1:
                //1 -> New order option  :  order not found : sazdavame nova pora4ka i q dobavqme v masiva s pora4ki
                InitializeObjects.initializeNewWOrder(tableId, JFrameMain.currentWaiter);
                //go to the next panel
                jFrame.showItemsPanel();
                break;
            case 2:
                //2 -> Existing order option :  order not found : popup to ask if do we want to make new order
                int result =
                        JOptionPane.showConfirmDialog(
                                null
                                , "No order for the current table."
                                        + "Do you want to add new order ?"
                                , "No existing orders"
                                , JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    //Add new order on yes option only !
                    InitializeObjects.initializeNewWOrder(tableId, JFrameMain.currentWaiter);
                    jFrame.showItemsPanel();
                }

                break;
            case 3:
                //3 -> Get Bill option :  order not found : no orders present for this table and the bill cannot be shown
                JOptionPane.showMessageDialog(
                        null
                        , "No existing order for the selected table"
                        , "Order not found"
                        , JOptionPane.INFORMATION_MESSAGE);

                add(jButtonBack);

                break;

            default:
                //When no valid button is pressed
                System.out.println("No valid menu option selected");

                break;
        }
    }
}
