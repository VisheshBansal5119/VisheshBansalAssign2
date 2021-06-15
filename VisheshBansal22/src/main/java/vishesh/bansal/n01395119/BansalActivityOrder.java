// Vishesh Bansal N01395119 Section: RNA

package vishesh.bansal.n01395119;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class BansalActivityOrder extends AppCompatActivity {
    boolean selectType = false;
    boolean selectSize = false;
    boolean selectTop = false;
    public static final String TOTAL = "vishesh.bansal.n01395119.TOTAL";
    public static final String SUMMARY = "vishesh.bansal.n01395119.SUMMARY";
    String[] orderDetail = new String[25];
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

    public double onSelectType(){
        RadioButton Boston = (RadioButton)findViewById(R.id.VisheshBoston);
        RadioButton Cheese = (RadioButton)findViewById(R.id.VisheshCheese);
        RadioButton Chicago = (RadioButton)findViewById(R.id.VisheshChicago);
        if(Boston.isChecked()){
            selectType = true;
            orderDetail[0]="Boston $9.99";
            return 9.99;
        }else if (Cheese.isChecked()){
            orderDetail[0]="Cheese 5.99";
            selectType = true;
            return 5.99;
        }else if(Chicago.isChecked()){
            orderDetail[0]="Chicago 12.99";
            selectType = true;
            return 12.99;
        }
    return 0;
    }
    public double onSelectSize(){
        RadioButton Small = (RadioButton)findViewById(R.id.VisheshSmall);
        RadioButton Medium = (RadioButton)findViewById(R.id.VisheshMedium);
        RadioButton Large = (RadioButton)findViewById(R.id.VisheshLarge);

        if(Small.isChecked()){
            selectSize = true;
            orderDetail[1]="Small $4.5";
            return 4.5;
        }else if (Medium.isChecked()){
            selectSize = true;
            orderDetail[1]="Medium $6.5";
            return 6.5;
        }else if(Large.isChecked()){
            selectSize = true;
            orderDetail[1]="Large $8.5";
            return 8.5;
        }
        return 0;
    }

    public double onExtraTop(){
        CheckBox mush = findViewById(R.id.VisheshMush);
        CheckBox rpep = findViewById(R.id.VisheshRedPepper);
        CheckBox pine = findViewById(R.id.VisheshPineapple);
        CheckBox extcheese = findViewById(R.id.VisheshExtraCheese);
        CheckBox oni = findViewById(R.id.VisheshOnions);
        int count =0;
        String toppings = new String();
        if(mush.isChecked()){
            toppings = " Mushroom +$0.50";
            count ++;
        }
        if(rpep.isChecked()) {
            toppings += " Red Pepper +$0.50";
            count++;
        }
        if(pine.isChecked()) {
            toppings += " Pineapple +$0.50";
            count++;
        }
        if(extcheese.isChecked()) {
            toppings += " Extra Cheese +$0.50";
            count++;
        }
        if(oni.isChecked()) {
            toppings += " Onions +$0.50";
            count++;
        }
        if(count>0){
            selectTop = true;
        }
        orderDetail[2] = toppings;
        return (count*.5);
    }
    public void onCheckout(View view){
        double total= 0;
        total = onSelectSize();
        total+= onSelectType();
        total+= onExtraTop();
        total = Math.round(total);

        if(selectType&&selectSize&&selectTop) {
            Intent intent = null;
            intent = new Intent(this, BansalActivityPayment.class);
            intent.putExtra(TOTAL,total);
            intent.putExtra(SUMMARY,orderDetail);
            startActivity(intent);

        }else{
            Toast.makeText(getBaseContext(),"Incomplete Selection",Toast.LENGTH_SHORT).show();
        }
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