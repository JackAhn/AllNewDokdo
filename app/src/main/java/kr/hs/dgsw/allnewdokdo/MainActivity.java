package kr.hs.dgsw.allnewdokdo;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import kr.hs.dgsw.allnewdokdo.db.DokdoBean;
import kr.hs.dgsw.allnewdokdo.db.DokdoDBHelper;

public class MainActivity extends AppCompatActivity {

    public static DokdoDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DokdoDBHelper(this, "dokdodb", null, 1);
        addData();
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

    private void addData(){

        helper.insert(new DokdoBean("자연관", R.drawable.nature1,"괭이갈매기는 이름 그대로 고양이 울음소리 같은 소리를 냅니다.\n그리고 독도에 많이 서식하는 동물 중 하나입니다."));
        helper.insert(new DokdoBean("자연관", R.drawable.nature2,"용치놀래기는 식탐이 강하기로 유명합니다.\n그래서 먹이인 성게나 멍게 주변에서 흔히 볼 수 있습니다."));
    }

}
