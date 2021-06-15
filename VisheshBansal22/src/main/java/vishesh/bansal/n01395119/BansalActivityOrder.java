// Vishesh Bansal N01395119 Section: RNA

package vishesh.bansal.n01395119;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void onCheckout(View view){
        Intent intent = null;
        intent = new Intent(this,BansalActivityPayment.class);
        startActivity(intent);
    }
    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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