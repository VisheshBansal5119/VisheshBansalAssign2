package vishesh.bansal.n01395119;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
}