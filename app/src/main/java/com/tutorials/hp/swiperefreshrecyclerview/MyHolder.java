package com.tutorials.hp.swiperefreshrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Oclemmy on 3/30/2016 for ProgrammingWizards Channel.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView img;
    TextView nameTxt;
    ItemClickListener itemClickListener;

    public MyHolder(View itemView) {
        super(itemView);

        img= (ImageView) itemView.findViewById(R.id.movieImage);
        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(getLayoutPosition());
    }
}
