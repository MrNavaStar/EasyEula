package me.mrnavastar.easyeula;

import lombok.Getter;

public class EasyEula {

    @Getter
    private static boolean eulaAccepted = false;

    public void acceptEula() {
        eulaAccepted = true;
    }
}
