package kr.hs.dgsw.allnewdokdo;

import android.graphics.PorterDuff;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.hs.dgsw.allnewdokdo.db.DokdoBean;

public class HistoryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Toolbar toolbar;
    private String[] item;
    private Spinner spinner;

    private ConstraintLayout layout;
    private ImageView im;
    private TextView maintext;
    private TextView pagetext;

    private String selected; //선택한 항목 이름
    private int page; //현재 페이지
    private ArrayList<DokdoBean> data; //데이터 가져올 배열

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        toolbar = findViewById(R.id.toolbar);
        spinner = findViewById(R.id.historySpinner);
        layout = findViewById(R.id.historyPanel);
        im = findViewById(R.id.historyMainimg);
        im.setBackgroundResource(R.drawable.default_img_border);
        maintext = findViewById(R.id.historyMaintext);
        pagetext = findViewById(R.id.historyPage);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        item = getResources().getStringArray(R.array.historycombo);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, item);
        spinner.getBackground().setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(0);
        getData("", 0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getItemAtPosition(position).toString().equals("항목을 선택해주세요.")){
            getData("", 0);
        }
        else{
            getData(parent.getItemAtPosition(position).toString(),1);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void getData(String kind, int page){
        if(kind.equals("")){
            selected = "";
            layout.setVisibility(View.INVISIBLE);
        }
        else {
            if(!kind.equals(selected)){
                selected = kind;
                this.page = page;
            }
            layout.setVisibility(View.VISIBLE);
            data = MainActivity.helper.getData(kind);
            im.setImageResource(data.get(page - 1).getImgNo());
            maintext.setText(data.get(page - 1).getContent());
            pagetext.setText(page + "/" + data.size() + "페이지");
        }
    }

    public void historyclickBeforeBtn(View v){
        if(page == 1){
            Toast.makeText(getApplicationContext(), "첫 번째 페이지입니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        page--;
        getData(selected, page);
    }

    public void historyclickAfterBtn(View v){
        if(page == data.size()){
            Toast.makeText(getApplicationContext(), "마지막 페이지입니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        page++;
        getData(selected, page);
    }
}
