package kr.hs.dgsw.allnewdokdo.recyclerview;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.hs.dgsw.allnewdokdo.R;
import kr.hs.dgsw.allnewdokdo.db.DokdoBean;



public class NatureAdapter extends RecyclerView.Adapter<NatureViewHolder> {

    private ArrayList<DokdoBean> imgData;
    private NatureItemClickListener listener;

    public NatureAdapter(ArrayList<DokdoBean> data, NatureItemClickListener listener){
        this.imgData = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NatureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(viewGroup.getContext())
                                        .inflate(R.layout.recycler_image, viewGroup, false);
        return new NatureViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull NatureViewHolder natureViewHolder, int i) {
        DokdoBean dokdoBean = imgData.get(i);
        //Drawable drawable = Resources.getSystem().getDrawable(dokdoBean.getImgNo(), null);
        natureViewHolder.imageView.setImageResource(dokdoBean.getImgNo());
        int tag = dokdoBean.getImgNo();
        natureViewHolder.imageView.setTag(tag);
        final int index = i;
        natureViewHolder.itemView.setOnClickListener(v->{
            listener.onImgClick(v, index);
        });

    }

    @Override
    public int getItemCount() {
        if(imgData == null)
            return 0;
        else
            return imgData.size();
    }
}
