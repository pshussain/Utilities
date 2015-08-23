package com.fabdy.auth;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hussain on 24/7/15.
 */
public class UserAuth {

    private static Map<Long, HashMap<String, String>> marketPlaceAuth = new HashMap<Long, HashMap<String, String>>() { {
        put(1l, new HashMap<String, String>() {{put("user", "aseemabdul@hotmail.com"); put("pass", "Veiji8101");}});
        put(2l, new HashMap<String, String>() {{put("user", "fabdyfashion@gmail.com"); put("pass", "Veiji8101");}});
    }};

    public static Map<String, String> login(long seller) {
        return marketPlaceAuth.get(seller);
    }
}
