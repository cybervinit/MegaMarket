package com.inos.megamarket.ui.dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.inos.megamarket.R;

/**
 * Created by vinit on 2017-07-23.
 */

public class StocksViewHolder extends RecyclerView.ViewHolder {

    TextView mStockNameTv;
    TextView mStockPriceTv;


    public StocksViewHolder(View itemView) {
        super(itemView);

        initViews(itemView);
    }

    private void initViews(View itemView) {
        this.mStockNameTv = (TextView) itemView.findViewById(R.id.stockNameTv);
        this.mStockPriceTv = (TextView) itemView.findViewById(R.id.stockPriceTv);
    }

}
