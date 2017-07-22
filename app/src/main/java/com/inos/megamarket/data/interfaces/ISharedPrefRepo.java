package com.inos.megamarket.data.interfaces;

/**
 * Created by vinit on 2017-07-22.
 */

public interface ISharedPrefRepo {

    boolean getBool(String key);

    void writeBool(String key, boolean val);

}
