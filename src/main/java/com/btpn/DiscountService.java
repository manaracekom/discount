package com.btpn;

/**
 * Created by Manaraceko_M on 9/3/2017.
 * Assumptions:
 * 1. Higher discounts wins
 * 2. Direct discount applied first before percentage based discount
 * 3. A user can get only one of the percentage based discounts on a bill.
 * 4. The percentage based discounts do not apply on groceries.
 */
public class DiscountService {

    public double calculateNetAmount(int bill, boolean isEmployee, boolean isAffiliate, int yearsRegistered, boolean isGroceries) {
        double netAmount;
        double percentageDiscount = 0;
        int directDiscount;
        double totalDiscount;
        double totalPercentageDiscount;

        // Calculate direct discount
        directDiscount = (bill / 100) * 5;

        // Determine percentage discount
        if (!isGroceries) {
            // Percentage base discount only applies other than groceries
            if (isEmployee) {
                percentageDiscount = 30;
            } else if (isAffiliate) {
                percentageDiscount = 10;
            } else if (yearsRegistered >= 2) {
                percentageDiscount = 5;
            }
        }

        if (percentageDiscount > 0) {
            totalDiscount = directDiscount + (bill - directDiscount) * (percentageDiscount / 100);
        } else {
            totalDiscount = directDiscount;
        }

        netAmount = bill - totalDiscount;

        return netAmount;
    }
}
