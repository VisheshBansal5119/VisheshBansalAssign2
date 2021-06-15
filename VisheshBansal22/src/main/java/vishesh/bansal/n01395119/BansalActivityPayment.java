// Vishesh Bansal N01395119 Section: RNA
package vishesh.bansal.n01395119;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class BansalActivityPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bansal_payment);
        Intent intent = getIntent();
        double total = intent.getDoubleExtra(BansalActivityOrder.TOTAL,0);
        double tax = Math.round((total*.13));
        String[] orderDetails = intent.getStringArrayExtra(BansalActivityOrder.SUMMARY);
        TextView orderSummary = findViewById(R.id.VisheshOrderSummary);
        orderSummary.setText("Style:  "+ orderDetails[0] +"\nSize:  "+ orderDetails[1]+ "\nToppings:"+ orderDetails[2] +"\nTax:"+ tax);
        TextView totalLabel = findViewById(R.id.Total_label);
        total += tax;
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
}