package Models;

public class Product {

    private String productName;
    private String productQuantity;
    private double productPrice;

    public Product(String productName, String productQuantity, double productPrice) {
        setProductName(productName);
        setProductQuantity(productQuantity);
        setProductPrice(productPrice);

    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return productName + " " +
                "Quantity " + productQuantity + " " +
                "Price " + productPrice;
    }

}
