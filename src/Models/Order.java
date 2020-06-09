package Models;

import Views.JFrameMain;

import java.util.ArrayList;

public class Order {

    private ArrayList<Product> productArrayList = new ArrayList<>();
    private String tableID;
    private Waiter WaiterCurrent;

    public Order(ArrayList<Product> productArrayList, String tableID, Waiter waiterCurrent) {
        setProductArrayList(productArrayList);
        setTableID(tableID);
        setWaiter(waiterCurrent);
    }

    public Order(String tableID, Waiter waiterCurrent) {
        setTableID(tableID);
        setWaiter(waiterCurrent);
    }

    public Order(ArrayList<Product> productArrayList) {
        setProductArrayList(productArrayList);
    }

    public ArrayList<Product> getProductArrayList() {
        return this.productArrayList;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    public String getTableID() {
        return this.tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public Waiter getWaiter() {
        return this.WaiterCurrent;
    }

    public void setWaiter(Waiter waiterCurrent) {
        WaiterCurrent = waiterCurrent;
    }




}
