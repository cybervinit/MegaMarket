package com.inos.megamarket.ui.dashboard;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

        // TODO: Swipe feature
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                // TODO: here is where you change the colour and stuff. BEAUTIFY
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };

        ItemTouchHelper itHelper = new ItemTouchHelper(simpleCallback);
        itHelper.attachToRecyclerView(this.mStocksRecView);



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
