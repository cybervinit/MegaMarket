package com.inos.megamarket.ui.dashboard;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
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

    // Sell stock dialog:


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        // Init account summary feature:
        this.mRankTv = (TextView) findViewById(R.id.tempTvRank);
        this.mFinancialAmountTv = (TextView) findViewById(R.id.tempTvFinancialAmount);
        this.mAccountSummaryPresenter = new AccountSummaryPresenter(this);


        // Init stock list feature:

        this.mStocksRecView = (RecyclerView) findViewById(R.id.stocksRecView);
        this.mStocksRecViewAdapter = new StocksAdapter();
        mStocksRecView.setHasFixedSize(true);
        mStocksRecView.setLayoutManager(new LinearLayoutManager(this));
        mStocksRecView.setAdapter(this.mStocksRecViewAdapter);
        this.mStocksPresenter = new StocksPresenter(this);

        // TODO: Expand feature



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

    @Override
    public void setCardExpandedPosition(int newPos) {
        this.mStocksRecViewAdapter.setExpandedPos(newPos);
    }

    @Override
    public void beginTransition() {
        TransitionManager.beginDelayedTransition(this.mStocksRecView);
        this.mStocksRecViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void makeStockSellDialog(String[] stockContent) {
        new MaterialDialog.Builder(this)
                .title(R.string.sell)
                .content(stockContent[0])
                .positiveText(R.string.sell)
                .negativeText("cancel")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(getBaseContext(), which.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .build()
                .show();
    }


    private class StocksAdapter extends RecyclerView.Adapter<StocksViewHolder> {

        private int mExpandedPos;

        public StocksAdapter() {
            this.mExpandedPos= -1;
        }

        @Override
        public StocksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return mStocksPresenter.createViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(StocksViewHolder holder, int position) {
            mStocksPresenter.bindViewHolder(holder, position, this.mExpandedPos);
        }

        @Override
        public int getItemCount() {
            return mStocksPresenter.getStocksAmount();
        }

        public void setExpandedPos(int newPos) {
            this.mExpandedPos = newPos;
        }

    }
}
