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

    public Money(int newValue) {
        this.value = newValue;
    }

    public Money() {
    }

    public int getAmount()
    {
        return value;
    }

    public int times(int quantity) {
        return this.value * quantity;
    }

    public Money minus(Money total) {
        return new Money( this.getAmount() - total.getAmount());
    }

    public int add(int subtotal) {
        return this.getAmount() + subtotal;
    }
}
