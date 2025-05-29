import org.junit.Test;
import static org.junit.Assert.*;

public class PrinterTest {
    private static final double DELTA = 0.001;

    @Test
    public void testNoDiscount() {
        Printer printer = new Printer("Test Model", 1000.00);
        printer.setDiscountStrategy(new NoDiscount());
        assertEquals(1000.00, printer.getFinalPrice(), DELTA);
    }

    @Test
    public void testFixedDiscount() {
        Printer printer = new Printer("Test Model", 1000.00);
        printer.setDiscountStrategy(new FixedDiscount(200.00));
        assertEquals(800.00, printer.getFinalPrice(), DELTA);

        // 测试折扣金额大于原价的情况
        printer.setDiscountStrategy(new FixedDiscount(1200.00));
        assertEquals(0.00, printer.getFinalPrice(), DELTA);
    }

    @Test
    public void testPercentageDiscount() {
        Printer printer = new Printer("Test Model", 1000.00);
        printer.setDiscountStrategy(new PercentageDiscount(0.05));
        assertEquals(950.00, printer.getFinalPrice(), DELTA);

        printer.setDiscountStrategy(new PercentageDiscount(0.20));
        assertEquals(800.00, printer.getFinalPrice(), DELTA);
    }

    @Test
    public void testStrategyChange() {
        Printer printer = new Printer("Test Model", 1000.00);

        // 初始无折扣
        assertEquals(1000.00, printer.getFinalPrice(), DELTA);

        // 更改为固定折扣
        printer.setDiscountStrategy(new FixedDiscount(150.00));
        assertEquals(850.00, printer.getFinalPrice(), DELTA);

        // 更改为百分比折扣
        printer.setDiscountStrategy(new PercentageDiscount(0.10));
        assertEquals(900.00, printer.getFinalPrice(), DELTA);
    }
}