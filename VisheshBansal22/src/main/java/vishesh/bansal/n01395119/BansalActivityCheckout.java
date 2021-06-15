package vishesh.bansal.n01395119;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class BansalActivityCheckout extends AppCompatActivity {
    double grossTotal =0;
    String[] orderDetails = new String[25];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bansal_checkout);
        Intent intent = getIntent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        grossTotal = intent.getDoubleExtra(BansalActivityPayment.TOTAL,0);
        orderDetails = intent.getStringArrayExtra(BansalActivityPayment.SUMMARY);
        TextView finalcheck = findViewById(R.id.textView);
        finalcheck.setText("$"+String.valueOf(grossTotal));

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