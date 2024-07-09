package me.mrnavastar.easyeula;

import lombok.Getter;

public class EasyEula {

    @Getter
    private static boolean eulaAccepted = false;

    public static void acceptEula() {
        eulaAccepted = true;
    }
}
