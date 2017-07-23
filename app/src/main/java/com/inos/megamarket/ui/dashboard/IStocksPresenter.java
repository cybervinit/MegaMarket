package com.inos.megamarket.ui.dashboard;

import android.view.ViewGroup;

/**
 * Created by vinit on 2017-07-23.
 */

public interface IStocksPresenter {
    // TODO: add methods to be used by the VIEW
    void initData();
    StocksViewHolder createViewHolder(ViewGroup parent, int viewType);
    void bindViewHolder(StocksViewHolder holder, int position);
    int getStocksAmount();


    // TODO: add methods to be used by the MODEL
}
