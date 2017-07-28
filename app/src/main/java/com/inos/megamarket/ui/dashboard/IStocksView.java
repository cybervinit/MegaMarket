package com.inos.megamarket.ui.dashboard;

/**
 * Created by vinit on 2017-07-23.
 */

public interface IStocksView {
    void notifyDatasetUpdated();
    void setCardExpandedPosition(int newPos);
    void beginTransition(); // TODO: remove? Has weird animation
    void makeStockSellDialog(String[] stockContent);
}
