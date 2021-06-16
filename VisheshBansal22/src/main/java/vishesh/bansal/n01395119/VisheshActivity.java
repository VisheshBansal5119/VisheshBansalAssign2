// Vishesh Bansal N01395119 Section: RNA
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
        Intent intent =getIntent();
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

        if(pizpiz.isChecked()){
            storeSelect = true;
            store = getString(R.string.store_name_piz);
        }else if (domi.isChecked()){
            storeSelect = true;
            store = getString(R.string.store_name_domi);
        }else{
            storeSelect = true;
            store = getString(R.string.store_name_nova);
        }
    }
    public void displayToast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_SHORT).show();
    }

    public void onNext(View view){
        Intent intent = null;
        intent = new Intent(this, BansalActivityOrder.class);

        if(storeSelect) {
            intent.putExtra(EXTRA_MESSAGE,store);
            startActivity(intent);
        }else{
            displayToast(getString(R.string.select_store_msg));
        }
    }

    public void onBack(){
        AlertDialog.Builder builder = new AlertDialog.Builder(VisheshActivity.this);
        builder.setTitle("Exit!!");
        builder.setMessage("Are you to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       finish();
                    }})
                .setIcon(R.drawable.alert)
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }});
        builder.show();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        String helpSite = getString(R.string.help_redirect);
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