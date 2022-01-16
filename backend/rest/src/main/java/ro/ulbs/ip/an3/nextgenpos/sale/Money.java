/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.ulbs.ip.an3.nextgenpos.sale;

/**
 *
 * @author Roberto
 */
public class Money {
    private int val;

    public Money(int val) {
        this.val = val;
    }

    public Money() {
    }

    public int getAmount()
    {
        return val;
    }

    public int times(int val, int quantity) {
        return val * quantity;
    }
    // to DO

    public Money minus(Money total) {
        return new Money( this.getAmount() - total.getAmount());
    }

    public Money add(Money subtotal) {
        return new Money(this.getAmount() + subtotal.getAmount());
    }
}
