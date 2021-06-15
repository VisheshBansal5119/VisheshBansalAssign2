package vishesh.bansal.n01395119;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class VisheshActivity extends AppCompatActivity {
    boolean storeSelect = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void storeClick(View view){
        RadioButton pizpiz = (RadioButton)findViewById(R.id.VisheshPizPiz);
        RadioButton domi = (RadioButton)findViewById(R.id.VisheshDomi);
        RadioButton nova = (RadioButton)findViewById(R.id.VisheshNova);

        if(pizpiz.isChecked()){
            displayToast("Pizza Pizza");
            storeSelect = true;
        }else if (domi.isChecked()){
            displayToast("Dominos");
            storeSelect = true;
        }else{
            storeSelect = true;
            displayToast("Pizza Nova");
        }
    }
    public void displayToast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_SHORT).show();
    }

    public void onNext(View view){
        Intent intent = null;
        intent = new Intent(this, BansalActivityOrder.class);
        if(storeSelect) {
            displayToast("on next");
            startActivity(intent);
        }else{
            displayToast("Please select a store");
        }
    }

    public void onBack(){
        AlertDialog.Builder builder = new AlertDialog.Builder(VisheshActivity.this);
        builder.setTitle("Exit!!");
        builder.setMessage("Are you to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    displayToast("yes clicked");
                       finish();
                    }})
                .setIcon(R.drawable.alert)
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        displayToast("no clicked");

                    }});
        builder.show();

    }
    @Override
    public void onBackPressed(){

       onBack();
    }


}