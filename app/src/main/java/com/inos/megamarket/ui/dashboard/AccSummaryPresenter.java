package com.inos.megamarket.ui.dashboard;

import com.inos.megamarket.data.classes.AccSummaryModel.AccSummaryModel;
import com.inos.megamarket.data.classes.AccSummaryModel.IAccSummaryModel;

/**
 * Created by vinit on 2017-07-23.
 */

public class AccSummaryPresenter implements IAccSummaryPresenter {

    // FIXME: add retreival of user summary data.

    private IAccSummaryView mAccountSummaryView;

    // FIXME: TEMP
    private IAccSummaryModel mAccountSummaryModel;

    public AccSummaryPresenter(IAccSummaryView accountSummaryView) {
        this.mAccountSummaryView = accountSummaryView;

        // init:
        // FIXME: bring this from the model
        this.mAccountSummaryView.setRank("Rank #4");
        this.mAccountSummaryView.setFinancialAmount("$ 41.3k");


        // FIXME: TEMP
        this.mAccountSummaryModel = new AccSummaryModel(this);
    }
}
