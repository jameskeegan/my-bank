package com.abc;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test //Test customer statement generation
    public void testApp(){

        Customer henry = new Customer("Henry");
        Account checkingAccount = henry.openCheckingAccount();
        Account savingsAccount = henry.openSavingsAccount();

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);

        Transfer.newTransfer(50.00, checkingAccount, savingsAccount);

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "  transfer-out $50.00\n" +
                "Total $50.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "  transfer-in $50.00\n" +
                "Total $3,850.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", henry.getStatement());
    }

    @Test
    public void testOneAccount(){
        Customer oscar = new Customer("Oscar");

        oscar.openCheckingAccount();

        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccount(){
        Customer oscar = new Customer("Oscar");

        oscar.openSavingsAccount();
        oscar.openCheckingAccount();

        assertEquals(2, oscar.getNumberOfAccounts());
    }
}
