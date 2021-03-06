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
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

public class BansalActivityPayment extends AppCompatActivity {
    public static final String TOTAL = "vishesh.bansal.n01395119.Order.TOTAL";
    public static final String SUMMARY = "vishesh.bansal.n01395119.Order.SUMMARY";
    public static final String PAYMENT = "vishesh.bansal.n01395119.Order.PAYMENT";
    public static final String DELIVERY = "vishesh.bansal.n01395119.Order.Deli";
    TextView totalLabel;
    EditText name,card,address;
    String[] orderDetails = new String[25];
    String[] payInfo = new String[25];
    String CCname,CCnum,CCaddress;
    boolean delivery = false;
    double grossTotal =0;
    double delCharge = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bansal_payment);
         name= findViewById(R.id.VisheshCCName);
         card = findViewById(R.id.VisheshCCNumber);
        address = findViewById(R.id.VisheshAddress);

        Intent intent = getIntent();
        double total = intent.getDoubleExtra(BansalActivityOrder.TOTAL,0);
        double tax = Math.round((total*.13));
         orderDetails = intent.getStringArrayExtra(BansalActivityOrder.SUMMARY);
        TextView orderSummary = findViewById(R.id.VisheshOrderSummary);
        orderSummary.setText("Style:  "+ orderDetails[0] +"\nSize:  "+ orderDetails[1]+ "\nToppings:"+ orderDetails[2] +"\nTax:"+ tax);
        totalLabel = findViewById(R.id.Total_label);
        total += tax;
        grossTotal = total;
        DecimalFormat df = new DecimalFormat("####0.00");
        totalLabel.setText("$"+df.format(total));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void addDelivery(boolean delivery){
        TextView deliveryCharge =  findViewById(R.id.DeliveryCharge);
        if(delivery){
            delCharge = 3;
            deliveryCharge.setText("Delivery Charge: $"+String.valueOf(delCharge) + " (FREE!)");
        }else{
            deliveryCharge.setText("");

        }
    }
    public void getPayInfo(){
        payInfo[0] = CCname;
        payInfo[1] =CCnum;
        payInfo[2] = CCaddress;
    }
    public boolean validateName(){
        CCname = name.getText().toString().trim();
        CCnum = card.getText().toString();
        CCaddress = address.getText().toString();
                boolean validate = true;
               if(CCname.length()<3){
                name.setError(getString(R.string.CCname_3_error));
                validate = false;
                }else if (CCnum.length()<8){
                    validate = false;
                    card.setError(getString(R.string.CCnum_error));
                }else if (CCnum.isEmpty()){
                    validate = false;
                    card.setError(getString(R.string.empty_field_error));
                }else if(CCaddress.isEmpty()){
                    validate = false;
                    address.setError(getString(R.string.address_empty_error));
                }
        return validate;
    }
    public void callSwitch(View view){
       Switch switchLabel = findViewById(R.id.VisheshDeliveryOption);

        if(switchLabel.isChecked()){
            delivery =true;
           }else{
            delivery =false;
           }
        addDelivery(delivery);
    }
    public void onPlaceOrder(View view){
        if(validateName()) {

        getPayInfo();

            Intent intent = new Intent(this, BansalActivityCheckout.class);
            intent.putExtra(TOTAL, grossTotal);
            intent.putExtra(SUMMARY, orderDetails);
            intent.putExtra(DELIVERY,delivery);
            intent.putExtra(PAYMENT,payInfo);
            startActivity(intent);
        }
    }


}