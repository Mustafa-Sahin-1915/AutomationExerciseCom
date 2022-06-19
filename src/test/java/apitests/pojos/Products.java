package apitests.pojos;

import java.util.List;

public class Products {
    private int responseCode;
    private List<Product> products;

    public Products() {
    }

    public Products(int responseCode, List<Product> products) {
        this.responseCode = responseCode;
        this.products = products;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Products{" +
                "responseCode=" + responseCode +
                ", products=" + products +
                '}';
    }
}
