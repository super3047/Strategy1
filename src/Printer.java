// 打印机类
public class Printer {
    private String model;
    private double price;
    private DiscountStrategy discountStrategy;

    public Printer(String model, double price) {
        this.model = model;
        this.price = price;
        this.discountStrategy = new NoDiscount(); // 默认无折扣
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double getFinalPrice() {
        return discountStrategy.calculateDiscount(price);
    }

    public String getModel() {
        return model;
    }

    public double getOriginalPrice() {
        return price;
    }
}

