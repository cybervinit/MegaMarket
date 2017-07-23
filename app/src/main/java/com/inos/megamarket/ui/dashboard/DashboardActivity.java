package com.inos.megamarket.ui.dashboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inos.megamarket.R;

public class DashboardActivity extends AppCompatActivity implements IAccountSummaryView, IStocksView {


    // User Summary Feature:
    IAccountSummaryPresenter mAccountSummaryPresenter;
    TextView mRankTv;
    TextView mFinancialAmountTv;


    // User Stocks
    IStocksPresenter mStocksPresenter;
    RecyclerView mStocksRecView;
    StocksAdapter mStocksRecViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        // Init feature 1:
        this.mRankTv = (TextView) findViewById(R.id.tempTvRank);
        this.mFinancialAmountTv = (TextView) findViewById(R.id.tempTvFinancialAmount);
        this.mAccountSummaryPresenter = new AccountSummaryPresenter(this);


        // Init feature 2:

        this.mStocksRecView = (RecyclerView) findViewById(R.id.stocksRecView);
        this.mStocksRecViewAdapter = new StocksAdapter();
        mStocksRecView.setHasFixedSize(true);
        mStocksRecView.setLayoutManager(new LinearLayoutManager(this));
        mStocksRecView.setAdapter(this.mStocksRecViewAdapter);
        this.mStocksPresenter = new StocksPresenter(this);




    }

    @Override
    public void setRank(String rankStr) {
        this.mRankTv.setText(rankStr);
    }

    @Override
    public void setFinancialAmount(String financialAmount) {
        this.mFinancialAmountTv.setText(financialAmount);
    }

    @Override
    public void notifyDatasetUpdated() {
        mStocksRecViewAdapter.notifyDataSetChanged();
    }


    private class StocksAdapter extends RecyclerView.Adapter<StocksViewHolder> {


        @Override
        public StocksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return mStocksPresenter.createViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(StocksViewHolder holder, int position) {
            mStocksPresenter.bindViewHolder(holder, position);
        }

        @Override
        public int getItemCount() {
            return mStocksPresenter.getStocksAmount();
        }

    }
}
