package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    private JLabel jLabelTop;
    private JButton jButtonAddNewOrder;
    private JButton jButtonAddExistingOrder;
    private JButton jButtonShowBill;
    public JFrameMain jFrame;

    public MenuPanel(JFrameMain jFrame) {
        this.jFrame = jFrame;

        jLabelTop = new JLabel("Menu");
        add(jLabelTop);

        jButtonAddNewOrder = new JButton("Add new order");
        jButtonAddNewOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add new order button
                addNewOrder();
            }
        });
        add(jButtonAddNewOrder);

        jButtonAddExistingOrder = new JButton("Add to existing order");
        jButtonAddExistingOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add new  existing order button
                addToExistingOrder();
            }
        });
        add(jButtonAddExistingOrder);

        jButtonShowBill = new JButton("Show bill");
        jButtonShowBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Show bill button
                showBill();
            }
        });
        add(jButtonShowBill);

    }

    public void addNewOrder() {
        //Option 1
        jFrame.showTablesPanel(1);
    }

    public void addToExistingOrder() {
        //Option 2
        jFrame.showTablesPanel(2);
    }

    public void showBill() {
        //Option 3
        jFrame.showTablesPanel(3);
    }
}
