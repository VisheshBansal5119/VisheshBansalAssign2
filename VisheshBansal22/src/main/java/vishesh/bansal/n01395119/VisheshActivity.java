package vishesh.bansal.n01395119;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class VisheshActivity extends AppCompatActivity {
    boolean storeSelect = false;
    public static final String EXTRA_MESSAGE = "vishesh.bansal.n01395119.MESSAGE";
    String store = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }


    public void storeClick(View view){
        RadioButton pizpiz = (RadioButton)findViewById(R.id.VisheshPizPiz);
        RadioButton domi = (RadioButton)findViewById(R.id.VisheshDomi);
        RadioButton nova = (RadioButton)findViewById(R.id.VisheshNova);

        if(pizpiz.isChecked()){
            displayToast("Pizza Pizza");
            storeSelect = true;
            store = "Pizza Pizza";
        }else if (domi.isChecked()){
            displayToast("Dominos");
            storeSelect = true;
            store = "Dominos";
        }else{
            storeSelect = true;
            displayToast("Pizza Nova");
            store = "Pizza Nova";
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
            intent.putExtra(EXTRA_MESSAGE,store);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        String helpSite = "https://www.apple.ca";
        switch (item.getItemId())
        {
            case R.id.VisheshHelp:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(helpSite));
                Context context = getApplicationContext();
                CharSequence text = getString(R.string.app_name) +" " + helpSite;
                startActivity(intent);
                break;

        }   return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
       onBack();
    }

}