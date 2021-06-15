// Vishesh Bansal N01395119 Section: RNA
package vishesh.bansal.n01395119;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BansalActivityPayment extends AppCompatActivity {
    public static final String TOTAL = "vishesh.bansal.n01395119.Order.TOTAL";
    public static final String SUMMARY = "vishesh.bansal.n01395119.Order.SUMMARY";
    double grossTotal =0;
    String[] orderDetails = new String[25];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bansal_payment);
        Intent intent = getIntent();
        double total = intent.getDoubleExtra(BansalActivityOrder.TOTAL,0);
        double tax = Math.round((total*.13));
         orderDetails = intent.getStringArrayExtra(BansalActivityOrder.SUMMARY);
        TextView orderSummary = findViewById(R.id.VisheshOrderSummary);
        orderSummary.setText("Style:  "+ orderDetails[0] +"\nSize:  "+ orderDetails[1]+ "\nToppings:"+ orderDetails[2] +"\nTax:"+ tax);
        TextView totalLabel = findViewById(R.id.Total_label);
        total += tax;
        grossTotal = total;
        totalLabel.setText("$"+String.valueOf(total));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void onPlaceOrder(View view){
        Button placeOrder = findViewById(R.id.PlaceOrder);
        Intent intent = new Intent(this,BansalActivityCheckout.class);
        intent.putExtra(TOTAL,grossTotal);
        intent.putExtra(SUMMARY,orderDetails);
        startActivity(intent);
    }


}