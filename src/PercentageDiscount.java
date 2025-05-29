// 百分比折扣策略
public class PercentageDiscount implements DiscountStrategy {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double calculateDiscount(double originalPrice) {
        return originalPrice * (1 - percentage);
    }
}
