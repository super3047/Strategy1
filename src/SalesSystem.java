// 销售系统
public class SalesSystem {
    public static void main(String[] args) {
        // 创建打印机
        Printer printer = new Printer("HP LaserJet Pro", 1200.00);

        // 无折扣
        System.out.println("No discount: " + printer.getFinalPrice());

        // 设置固定折扣策略
        printer.setDiscountStrategy(new FixedDiscount(200.00));
        System.out.println("Fixed discount: " + printer.getFinalPrice());

        // 设置百分比折扣策略
        printer.setDiscountStrategy(new PercentageDiscount(0.05));
        System.out.println("5% discount: " + printer.getFinalPrice());
    }
}
