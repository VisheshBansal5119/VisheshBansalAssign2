package vishesh.bansal.n01395119;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BansalActivityOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bansal);

        Intent intent = getIntent();
        String storeName = intent.getStringExtra(VisheshActivity.EXTRA_MESSAGE);
        TextView storeTitle = findViewById(R.id.VisheshStoreName);
        storeTitle.setText(storeName);
    }
    public void onCheckout(View view){
        Intent intent = null;
        intent = new Intent(this,BansalActivityPayment.class);
        startActivity(intent);
    }
}