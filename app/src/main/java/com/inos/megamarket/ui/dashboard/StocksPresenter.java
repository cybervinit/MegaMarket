package com.inos.megamarket.ui.dashboard;

import android.text.Layout;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inos.megamarket.R;

import java.util.ArrayList;
import java.util.jar.Pack200;

/**
 * Created by vinit on 2017-07-23.
 */

public class StocksPresenter implements IStocksPresenter {


    IStocksView mStocksView;

    // FIXME: change to an actual Stock (possibly an object?) array
    ArrayList<String> mStockArray;


    public StocksPresenter(IStocksView stocksView) {
        this.mStocksView = stocksView;
        this.mStockArray = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            this.mStockArray.add("STOCK --> "+i);
        }
        this.initData();
    }

    @Override
    public void initData() {
        syncData();
    }

    public void syncData() {
        mStocksView.notifyDatasetUpdated();
    }

    @Override
    public StocksViewHolder createViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View stockCard = inflater.inflate(R.layout.stock_card_dashboard, parent, false);
        return new StocksViewHolder(stockCard);
    }

    @Override
    public void bindViewHolder(StocksViewHolder holder, final int position, int expanded) {
        holder.mStockNameTv.setText(mStockArray.get(position));
        holder.mStockPriceTv.setText("$ 100");
        holder.mSellStockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] stockContent = {mStockArray.get(position)};
                mStocksView.makeStockSellDialog(stockContent);
            }
        });

        // TODO: implement card expansion feature
        final boolean isExpanded = position == expanded;
        holder.mCompressedView.setVisibility(isExpanded? View.INVISIBLE : View.VISIBLE);
        holder.mExpandedView.setVisibility(isExpanded? View.VISIBLE : View.INVISIBLE);
        if (isExpanded) { // FIXME: set the expanded "more info" for the stock
            holder.mCompressedView.getLayoutParams().height = 0;
            holder.mExpandedView.getLayoutParams().height  = 300;
        } else { // FIXME: set the compressed info for the stock
            holder.mCompressedView.getLayoutParams().height = 100;
            holder.mExpandedView.getLayoutParams().height  = 0;
        }

        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStocksView.setCardExpandedPosition(isExpanded ? -1 : position);
                //mStocksView.beginTransition();
                mStocksView.notifyDatasetUpdated();
            }
        });
    }

    @Override
    public int getStocksAmount() {
        return mStockArray.size();
    }
}
