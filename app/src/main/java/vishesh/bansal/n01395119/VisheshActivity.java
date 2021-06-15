package vishesh.bansal.n01395119;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class VisheshActivity extends AppCompatActivity {

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
        }else if (domi.isChecked()){
            displayToast("Dominos");
        }else displayToast("Pizza Nova");
    }
    public void displayToast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_SHORT).show();
    }

    public void onNext(View view){

    }


}