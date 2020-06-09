package Views;

import Models.Order;
import Models.Product;
import Models.Waiter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JFrameMain extends JFrame {

    public static ArrayList<Waiter> waiter = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<Order> orders = new ArrayList<>();
    public static Waiter currentWaiter;
    public static String currentTableId;
    public static Order currentOrder;

    public LoginPanel loginPanel;
    public MenuPanel menuPanel;
    public TablesPanel tablesPanel;
    public ItemsPanel itemsPanel;
    public BillPanel billPanel;

    public JFrameMain() {
        super("Bar System");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(1, 2, 3));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        this.setSize((int) width, (int) height);

        showLoginPanel();
    }

    public void showLoginPanel() {
        //Shows login panel for the bar system
        loginPanel = new LoginPanel(this);
        loginPanel.setSize(getWidth(), getHeight());
        add(loginPanel);
    }

    public void showMenuPanel() {
        //Shows Menu panel for the bar system
        loginPanel.setVisible(false);
        remove(loginPanel);

        menuPanel = new MenuPanel(this);
        menuPanel.setSize(getWidth(), getHeight());
        add(menuPanel);
    }

    public void showTablesPanel(int clickedButton) {
        //Shows Tables panel for the bar system
        menuPanel.setVisible(false);
        remove(menuPanel);

        tablesPanel = new TablesPanel(this);
        tablesPanel.clickedButton = clickedButton;
        tablesPanel.setSize(getWidth(), getHeight());
        add(tablesPanel);
    }


    public void showItemsPanel() {
        //Shows added Items panel for the bar system
        tablesPanel.setVisible(false);
        remove(tablesPanel);

        itemsPanel = new ItemsPanel(this);
        itemsPanel.setSize(getWidth(), getHeight());
        add(itemsPanel);
    }

    public void showBillPanel() {
        //Shows bill for the selected table
        tablesPanel.setVisible(false);
        remove(tablesPanel);

        billPanel = new BillPanel(this);
        billPanel.setSize(getWidth(), getHeight());
        add(billPanel);
    }
}
