package com.inos.megamarket.data.classes;

import com.inos.megamarket.data.interfaces.ISharedPrefRepo;

/**
 * Created by vinit on 2017-07-22.
 */

public class SharedPrefRepo implements ISharedPrefRepo {
    private static SharedPrefRepo thisRepo;

    private SharedPrefRepo() {/* CONSTRUCTOR */ }

    public SharedPrefRepo getInstance() {
        if (thisRepo == null) {
            thisRepo = new SharedPrefRepo();
        }
        return thisRepo;
    }
    @Override
    public boolean get(String key) {
        return false;
    }

    @Override
    public void write(String key, String defaultVal) {

    }
}
