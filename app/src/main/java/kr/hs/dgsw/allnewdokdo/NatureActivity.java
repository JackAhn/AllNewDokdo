package kr.hs.dgsw.allnewdokdo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import kr.hs.dgsw.allnewdokdo.db.DokdoBean;
import kr.hs.dgsw.allnewdokdo.recyclerview.NatureAdapter;
import kr.hs.dgsw.allnewdokdo.recyclerview.NatureItemClickListener;

public class NatureActivity extends AppCompatActivity implements NatureItemClickListener {

    private Toolbar toolbar;
    private RecyclerView imgList;
    private NatureAdapter adapter;
    private ArrayList<DokdoBean> data;
    private ImageView mainimg;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        content = findViewById(R.id.natureContent);
        mainimg = findViewById(R.id.natureBigimg);
        data = MainActivity.helper.getData("자연관");
        adapter = new NatureAdapter(data, this);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.HORIZONTAL);
        imgList = findViewById(R.id.natureRecycle);
        imgList.setLayoutManager(layout);
        imgList.setAdapter(adapter);
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
    public void onImgClick(View v, int position) {
        int childcount = imgList.getChildCount();
        for(int i = 0; i < childcount; i++){
            RecyclerView.ViewHolder holder = imgList.getChildViewHolder(imgList.getChildAt(i));
            holder.itemView.setBackgroundResource(0);
        }
        ImageView im = v.findViewById(R.id.natureImg);
        int tag = (int) im.getTag();
        String text = MainActivity.helper.natureContent(tag);
        Bitmap bitmap = ((BitmapDrawable)im.getDrawable()).getBitmap();
        mainimg.setImageBitmap(bitmap);
        mainimg.setBackgroundResource(R.drawable.default_img_border);
        v.setBackgroundResource(R.drawable.nature_img_border);
        content.setText(text);
    }

    public void onClickBefore(View v){
        int childcount = imgList.getChildCount();
        for(int i = 0; i < childcount; i++){
            RecyclerView.ViewHolder holder = imgList.getChildViewHolder(imgList.getChildAt(i));
            holder.itemView.setBackgroundResource(0);
        }
        RecyclerView.ViewHolder holder = imgList.getChildViewHolder(imgList.getChildAt(0));
        ImageView im = holder.itemView.findViewById(R.id.natureImg);
        int tag = (int) im.getTag();
        String text = MainActivity.helper.natureContent(tag);
        Bitmap bitmap = ((BitmapDrawable)im.getDrawable()).getBitmap();
        mainimg.setImageBitmap(bitmap);
        holder.itemView.setBackgroundResource(R.drawable.nature_img_border);
        content.setText(text);
    }
    public void onClickLast(View v){
        int childcount = imgList.getChildCount();
        for(int i = 0; i < childcount; i++){
            RecyclerView.ViewHolder holder = imgList.getChildViewHolder(imgList.getChildAt(i));
            holder.itemView.setBackgroundResource(0);
        }

        RecyclerView.ViewHolder holder = imgList.getChildViewHolder(imgList.getChildAt(childcount - 1));
        ImageView im = holder.itemView.findViewById(R.id.natureImg);
        int tag = (int) im.getTag();
        String text = MainActivity.helper.natureContent(tag);
        Bitmap bitmap = ((BitmapDrawable)im.getDrawable()).getBitmap();
        mainimg.setImageBitmap(bitmap);
        holder.itemView.setBackgroundResource(R.drawable.nature_img_border);
        content.setText(text);
    }
}
