package linkedinlearning.cucumber;

public class BillCalculationHelper {
    public static double calculateBillForCustomer(double billAmount, double taxRate) {
        return billAmount + (billAmount * (taxRate / 100));
    }
}
