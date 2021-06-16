package vishesh.bansal.n01395119;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

        grossTotal = intent.getDoubleExtra(BansalActivityPayment.TOTAL,0);
        orderDetails = intent.getStringArrayExtra(BansalActivityPayment.SUMMARY);
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
   // Button checkout = (Button)findViewById(R.id.FinalCheckoutButton);
    public String alertMsg(){
        int rand = (int) Math.round((Math.random()*100));
        String msg= null;
        if(delivery) {
            msg = "Order No: " + String.valueOf(rand) + " Delivery at 9:45PM";
        }else {
            msg = "Order No: " + String.valueOf(rand) + " Pickup at 9:45PM";
        }
        return msg;
    }
    public void callMainActivity(){
        Intent intent = new Intent(this,VisheshActivity.class);
        startActivity(intent);
    }
    public void onCheckout(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(BansalActivityCheckout.this);
        builder.setTitle("Order Confirmed");
        builder.setMessage(alertMsg())
                .setCancelable(false)
                .setPositiveButton("Dismiss",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    callMainActivity();
                    }})
                .setIcon(R.drawable.applogo);

        builder.show();
    }
}