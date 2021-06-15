package vishesh.bansal.n01395119;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class BansalActivityCheckout extends AppCompatActivity {
    double grossTotal =0;
    String[] orderDetails = new String[25];
    String[] payDetails = new String[25];
    boolean delivery =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bansal_checkout);
        Intent intent = getIntent();
        payDetails = intent.getStringArrayExtra(BansalActivityPayment.PAYMENT);
        delivery = intent.getBooleanExtra(BansalActivityPayment.DELIVERY,false);
        grossTotal = intent.getDoubleExtra(BansalActivityPayment.OTOTAL,0);
        orderDetails = intent.getStringArrayExtra(BansalActivityPayment.OSUMMARY);
        TextView finalcheck = findViewById(R.id.finalOrderSummary);
        TextView finalpay = findViewById(R.id.FinalPaymentInfo);
        finalcheck.setText("Style:  "+ orderDetails[0] +"\nSize:  "+ orderDetails[1]+ "\nToppings:"+ orderDetails[2] +"\nGross Total:"+ grossTotal);
        finalpay.setText("Name:" + payDetails[0] + "\nCard Number: " + payDetails[1]+ "\nAddress: " + payDetails[2]+ "\n(Make sure the details are correct)");

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