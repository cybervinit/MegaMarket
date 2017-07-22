package com.inos.megamarket.data.interfaces;

/**
 * Created by vinit on 2017-07-22.
 */

public interface ISharedPrefRepo {
    boolean get(String key);

    void write(String key, String defaultVal);

}
