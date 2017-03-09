package com.btpn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Manaraceko_M on 9/3/2017.
 * Test Cases for DiscountService
 */
public class DiscountServiceTest {

    DiscountService discountService = new DiscountService();

    /*
    Test case #1
    1. User is employee of the store
    2. User is buying groceries
     */
    @Test
    public void testCalculateNetAmount() throws Exception {
        double expectedAmmount =  950;
        double netAmount = discountService.calculateNetAmount(1000, true, false, 1, true);
        Assert.assertEquals(expectedAmmount, netAmount, 0);
    }

    /*
    Test case #2
    1. User is an employee of the store
    2. User is not buying groceries
     */
    @Test
    public void testCalculateNetAmount2() throws Exception {
        double expectedAmmount =  665;
        double netAmount = discountService.calculateNetAmount(1000, true, false, 1, false);
        Assert.assertEquals(expectedAmmount, netAmount, 0);
    }

    /*
    Test case #3
    1. User is an affiliate of the store
    2. User is buying groceries
    3.
     */
    @Test
    public void testCalculateNetAmount3() throws Exception {
        double expectedAmmount =  950;
        double netAmount = discountService.calculateNetAmount(1000, false, true, 1, true);
        Assert.assertEquals(expectedAmmount, netAmount, 0);
    }

    /*
    Test case #4
    1. User is an affiliate of the store
    2. User is not buying groceries
    3.
     */
    @Test
    public void testCalculateNetAmount4() throws Exception {
        double expectedAmmount =  855;
        double netAmount = discountService.calculateNetAmount(1000, false, true, 1, false);
        Assert.assertEquals(expectedAmmount, netAmount, 0);
    }

    /*
    Test case #5
    1. User has been a customer for over 2 years
    2. User is buying groceries
     */
    @Test
    public void testCalculateNetAmount5() throws Exception {
        double expectedAmmount =  950;
        double netAmount = discountService.calculateNetAmount(1000, false, false, 3, true);
        Assert.assertEquals(expectedAmmount, netAmount, 0);
    }

    /*
    Test case #6
    1. User has been a customer for over 2 years
    2. User is not buying groceries
     */
    @Test
    public void testCalculateNetAmount6() throws Exception {
        double expectedAmmount =  902.5;
        double netAmount = discountService.calculateNetAmount(1000, false, false, 3, false);
        Assert.assertEquals(expectedAmmount, netAmount, 0);
    }

    /*
    Test case #7
    1. User who is not an employee, affiliate, nor customer for over 2 years
    2. User is not buying groceries
     */
    @Test
    public void testCalculateNetAmount7() throws Exception {
        double expectedAmmount =  950;
        double netAmount = discountService.calculateNetAmount(1000, false, false, 1, false);
        Assert.assertEquals(expectedAmmount, netAmount, 0);
    }

    /*
    Test case #8
    1. User who is not an employee, affiliate, nor customer for over 2 years
    2. User is buying groceries
     */
    @Test
    public void testCalculateNetAmount8() throws Exception {
        double expectedAmmount =  950;
        double netAmount = discountService.calculateNetAmount(1000, false, false, 1, true);
        Assert.assertEquals(expectedAmmount, netAmount, 0);
    }
}