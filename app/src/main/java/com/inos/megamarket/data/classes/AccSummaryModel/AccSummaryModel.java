package com.inos.megamarket.data.classes.AccSummaryModel;

import com.inos.megamarket.data.interfaces.RUsersService;
import com.inos.megamarket.ui.dashboard.IAccSummaryPresenter;

/**
 * Created by vinit on 2017-07-28.
 */

public class AccSummaryModel implements IAccSummaryModel {

    public static final String TAG = "VINIT";

    private RUsersService rUsersService;
    private IAccSummaryPresenter mPresenter;

    public AccSummaryModel(IAccSummaryPresenter presenter) {
        rUsersService = RUsersService.retrofit.create(RUsersService.class);
        this.mPresenter = presenter;
    }
}
