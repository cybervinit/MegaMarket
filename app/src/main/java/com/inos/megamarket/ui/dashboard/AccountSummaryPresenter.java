package com.inos.megamarket.ui.dashboard;

/**
 * Created by vinit on 2017-07-23.
 */

public class AccountSummaryPresenter implements IAccountSummaryPresenter {

    // FIXME: add retreival of user summary data.

    private IAccountSummaryView mAccountSummaryView;

    public AccountSummaryPresenter(IAccountSummaryView accountSummaryView) {
        this.mAccountSummaryView = accountSummaryView;

        // init:
        // FIXME: bring this from the model
        this.mAccountSummaryView.setRank("Rank #4");
        this.mAccountSummaryView.setFinancialAmount("$ 41.3k");

    }


}
