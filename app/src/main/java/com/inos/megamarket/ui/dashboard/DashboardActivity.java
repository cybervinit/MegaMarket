package com.inos.megamarket.ui.dashboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.inos.megamarket.R;

public class DashboardActivity extends AppCompatActivity implements IAccountSummaryView {


    // User Summary Feature:
    IAccountSummaryPresenter mAccountSummaryPresenter;
    TextView mRankTv;
    TextView mFinancialAmountTv;


    RecyclerView mStocksRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        // Init feature 1:
        this.mRankTv = (TextView) findViewById(R.id.tempTvRank);
        this.mFinancialAmountTv = (TextView) findViewById(R.id.tempTvFinancialAmount);
        this.mAccountSummaryPresenter = new AccountSummaryPresenter(this);


        // Init feature 2:
        //TODO





    }

    @Override
    public void setRank(String rankStr) {
        this.mRankTv.setText(rankStr);
    }

    @Override
    public void setFinancialAmount(String financialAmount) {
        this.mFinancialAmountTv.setText(financialAmount);
    }
}
