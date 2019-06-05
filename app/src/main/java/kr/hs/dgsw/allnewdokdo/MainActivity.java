package kr.hs.dgsw.allnewdokdo;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        Intent intent = null;
        switch(v.getId()){
            case R.id.inforBtn:
                intent = new Intent(this, InforActivity.class);
                startActivity(intent);
                break;
            case R.id.natureBtn:
                intent = new Intent(this, NatureActivity.class);
                startActivity(intent);
                break;
            case R.id.historyBtn:
                intent = new Intent(this, HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.exitBtn:
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }
    }

}
