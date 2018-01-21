package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


     /*************************************************************************
     *                        GLOBAL VARIABLES                                *
     **************************************************************************
     * quantity : the number of coffees                                       *
     * price : the price for each coffee                                      *
     *************************************************************************/
    int quantity = 0;
    int price = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     /*************************************************************************
     * submitOrder                                                            *
     **************************************************************************
     * This method will be used later to process the order and charge the     *
     *      customer for the order. Initially, it updated the UI to show the  *
     *      total, but that seems unintuitive for an "order" button. For now, *
     *      this is a dummy method that's wired up to the onClick of the      *
     *      ORDER button.                                                     *
     *************************************************************************/
    public void submitOrder(View view) {
        // do nothing -- this is for later when charging the order
    }

     /*************************************************************************
     * increment                                                              *
     **************************************************************************
     * This method increments the number of coffees in the current order      *
     * @param view : the "+" button, id: increment_button                     *
     *************************************************************************/
    public void increment(View view) {
        ++quantity;
        updateUI();
    }

     /*************************************************************************
     * decrement                                                              *
     **************************************************************************
     * This method decrements the number of coffees in the current order      *
     * @param view : the "-" button, id: decrement_button                     *
     *************************************************************************/
    public void decrement (View view) {
        --quantity;
        updateUI();
    }

     /*************************************************************************
     * updateUI                                                               *
     **************************************************************************
     * This method updates the display to show the quantity, the current      *
     *      total (quantity * price), and the enabled state of the decrement  *
     *      button for cases where there is no quantity to decrement          *
     *************************************************************************/
    private void updateUI () {
        display(quantity);
        displayPrice(price * quantity);
        updateButtonState();
    }

     /*************************************************************************
     * updateButtonState                                                      *
     **************************************************************************
     * This method flips the enabled state of the decrement button depending  *
     *      on the value of the quantity global variable                      *
     *************************************************************************/
    private void updateButtonState () {
        Button decButton = (Button) findViewById(R.id.decrement_button);
        decButton.setEnabled(quantity > 0);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
