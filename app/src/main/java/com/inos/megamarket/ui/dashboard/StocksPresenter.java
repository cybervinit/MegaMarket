package com.inos.megamarket.ui.dashboard;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inos.megamarket.R;

import java.util.ArrayList;

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
            this.mStockArray.add("Stock #"+i);
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
    public void bindViewHolder(StocksViewHolder holder, int position) {
        holder.mStockNameTv.setText("Stock Name"+position);
        holder.mStockPriceTv.setText("$ 100");
    }

    @Override
    public int getStocksAmount() {
        return mStockArray.size();
    }
}
