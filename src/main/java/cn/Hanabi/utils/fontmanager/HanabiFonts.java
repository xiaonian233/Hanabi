package cn.Hanabi.utils.fontmanager;

import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class HanabiFonts
{
    public static String ICON_CLICKGUI_RENDER;
    public static String ICON_CLICKGUI_COMBAT;
    public static String ICON_CLICKGUI_WORLD;
    public static String ICON_CLICKGUI_MOVEMENT;
    public static String ICON_CLICKGUI_PLAYER;
    public static String ICON_CLICKGUI_GHOST;
    public static String ICON_CLICKGUI_ARROW_UP;
    public static String ICON_CLICKGUI_ARROW_DOWN;
    public static String ICON_HANABI_LOGO;
    public static String ICON_MAINMENU_SINGLE;
    public static String ICON_MAINMENU_MULTI;
    public static String ICON_MAINMENU_ALTMANAGER;
    public static String ICON_MAINMENU_SETTINGS;
    public static String ICON_MAINMENU_QUITGAME;
    public static String ICON_NOTIFY_INFO;
    public static String ICON_NOTIFY_SUCCESS;
    public static String ICON_NOTIFY_WARN;
    public static String ICON_NOTIFY_ERROR;
    private static String ICON_PLAYER_REPEAT;
    private static String ICON_PLAYER_NEXT;
    private static String ICON_PLAYER_PLAY;
    private static String ICON_PLAYER_PAUSE;
    private static final String[] llIIlllIlll;
    
    public HanabiFonts() {
        super();
    }
    
    static {
        lIIlIIIIIIlII();
        HanabiFonts.ICON_CLICKGUI_RENDER = HanabiFonts.llIIlllIlll[0];
        HanabiFonts.ICON_CLICKGUI_COMBAT = HanabiFonts.llIIlllIlll[1];
        HanabiFonts.ICON_CLICKGUI_WORLD = HanabiFonts.llIIlllIlll[2];
        HanabiFonts.ICON_CLICKGUI_MOVEMENT = HanabiFonts.llIIlllIlll[3];
        HanabiFonts.ICON_CLICKGUI_PLAYER = HanabiFonts.llIIlllIlll[4];
        HanabiFonts.ICON_CLICKGUI_GHOST = HanabiFonts.llIIlllIlll[5];
        HanabiFonts.ICON_CLICKGUI_ARROW_UP = HanabiFonts.llIIlllIlll[6];
        HanabiFonts.ICON_CLICKGUI_ARROW_DOWN = HanabiFonts.llIIlllIlll[7];
        HanabiFonts.ICON_HANABI_LOGO = HanabiFonts.llIIlllIlll[8];
        HanabiFonts.ICON_MAINMENU_SINGLE = HanabiFonts.llIIlllIlll[9];
        HanabiFonts.ICON_MAINMENU_MULTI = HanabiFonts.llIIlllIlll[10];
        HanabiFonts.ICON_MAINMENU_ALTMANAGER = HanabiFonts.llIIlllIlll[11];
        HanabiFonts.ICON_MAINMENU_SETTINGS = HanabiFonts.llIIlllIlll[12];
        HanabiFonts.ICON_MAINMENU_QUITGAME = HanabiFonts.llIIlllIlll[13];
        HanabiFonts.ICON_NOTIFY_INFO = HanabiFonts.llIIlllIlll[14];
        HanabiFonts.ICON_NOTIFY_SUCCESS = HanabiFonts.llIIlllIlll[15];
        HanabiFonts.ICON_NOTIFY_WARN = HanabiFonts.llIIlllIlll[16];
        HanabiFonts.ICON_NOTIFY_ERROR = HanabiFonts.llIIlllIlll[17];
    }
    
    private static void lIIlIIIIIIlII() {
        (llIIlllIlll = new String[22])[0] = "";
        HanabiFonts.llIIlllIlll[1] = "";
        HanabiFonts.llIIlllIlll[2] = "";
        HanabiFonts.llIIlllIlll[3] = "";
        HanabiFonts.llIIlllIlll[4] = "";
        HanabiFonts.llIIlllIlll[5] = "";
        HanabiFonts.llIIlllIlll[6] = "";
        HanabiFonts.llIIlllIlll[7] = "";
        HanabiFonts.llIIlllIlll[8] = "";
        HanabiFonts.llIIlllIlll[9] = "";
        HanabiFonts.llIIlllIlll[10] = "";
        HanabiFonts.llIIlllIlll[11] = "";
        HanabiFonts.llIIlllIlll[12] = "";
        HanabiFonts.llIIlllIlll[13] = "";
        HanabiFonts.llIIlllIlll[14] = "";
        HanabiFonts.llIIlllIlll[15] = "";
        HanabiFonts.llIIlllIlll[16] = "";
        HanabiFonts.llIIlllIlll[17] = "";
        HanabiFonts.llIIlllIlll[18] = "";
        HanabiFonts.llIIlllIlll[19] = "";
        HanabiFonts.llIIlllIlll[20] = "";
        HanabiFonts.llIIlllIlll[21] = "";
    }
    
    private static String lIIIlllllIlII(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("Blowfish")).init(2, new SecretKeySpec(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), "Blowfish"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String lIIIlllllIlll(String s, final String s2) {
        s = new String(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        final StringBuilder sb = new StringBuilder();
        final char[] charArray = s2.toCharArray();
        int n = 0;
        char[] charArray2;
        for (int length = (charArray2 = s.toCharArray()).length, i = 0; i < length; ++i) {
            sb.append((char)(charArray2[i] ^ charArray[n % charArray.length]));
            ++n;
        }
        return String.valueOf(sb);
    }
    
    private static String lIIIllllllIII(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("DES")).init(2, new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), 8), "DES"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
