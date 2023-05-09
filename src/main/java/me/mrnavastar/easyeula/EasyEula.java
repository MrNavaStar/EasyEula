package me.mrnavastar.easyeula;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class EasyEula {
    public static final String MOD_ID = "EasyEula";

    public static void log(Level level, String message) {
        LogManager.getLogger().log(level, "[" + MOD_ID + "] " + message);
    }
}