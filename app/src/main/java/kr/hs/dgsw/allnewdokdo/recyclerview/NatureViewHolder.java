package kr.hs.dgsw.allnewdokdo.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import kr.hs.dgsw.allnewdokdo.R;

public class NatureViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    public NatureViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.natureImg);
    }
}
