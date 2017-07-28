package com.inos.megamarket.ui.dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.inos.megamarket.R;

/**
 * Created by vinit on 2017-07-23.
 */

public class StocksViewHolder extends RecyclerView.ViewHolder {



    // Compressed View
    RelativeLayout mCompressedView;
    TextView mStockNameTv;
    TextView mStockPriceTv;

    // Expanded View
    LinearLayout mExpandedView;
    Button mSellStockBtn;




    public StocksViewHolder(View itemView) {
        super(itemView);

        initViews(itemView);
    }

    private void initViews(View itemView) {
        this.mCompressedView = (RelativeLayout) itemView.findViewById(R.id.unexpanded_layout);
        this.mStockNameTv = (TextView) itemView.findViewById(R.id.stockNameTv);
        this.mStockPriceTv = (TextView) itemView.findViewById(R.id.stockPriceTv);

        this.mExpandedView = (LinearLayout) itemView.findViewById(R.id.expanded_layout);
        this.mSellStockBtn = (Button) itemView.findViewById(R.id.sell_stock_button);

    }

}
