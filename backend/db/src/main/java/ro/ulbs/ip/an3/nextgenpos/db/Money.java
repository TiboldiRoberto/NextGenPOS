/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ulbs.ip.an3.nextgenpos.db;

/**
 *
 * @author user
 */
public class Money {
    private int value;

    public Money(int val) {
        this.value = val;
    }

    public Money() {
    }

    public int getAmount()
    {
        return value;
    }

    public Money times(int quantity) {
        return new Money(this.value * quantity);
    }
    // to DO

    public Money minus(Money total) {
        return new Money( this.getAmount() - total.getAmount());
    }

    public Money add(Money subtotal) {
        return new Money(this.getAmount() + subtotal.getAmount());
    }
}
