package cn.Hanabi.hmlProject;

import ClassSub.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class HMLUtils
{
    private static String CLIENT_NAME;
    private static String CLIENT_VERSION;
    private static String USERNAME;
    private static HML_ModManager MOD_MANAGER;
    private static HML_CommandManager COMMAND_MANAGER;
    private static final String[] lIIIIIIIll;
    
    public HMLUtils() {
        super();
    }
    
    public static void onModManagerLoad$2eb07009() {
        new HML_ModManager();
    }
    
    public static void onCommandManagerLoad(final Class336 class336) {
        new HML_CommandManager(class336);
    }
    
    static {
        lIlllIIIlII();
        final String[] array = new String[2];
        int n = 0;
        final String s;
        final int length = (s = HMLUtils.lIIIIIIIll[0]).length();
        int char1 = 6;
        int n2 = -1;
        Label_0029: {
            break Label_0029;
            do {
                char1 = s.charAt(n2);
                final int n3 = 114;
                ++n2;
                final String s2 = s;
                final int n4 = n2;
                final char[] charArray = s2.substring(n4, n4 + char1).toCharArray();
                final int length2 = charArray.length;
                int n5 = 0;
                while (true) {
                    Label_0187: {
                        if (!lIlllIlIIIl(length2, 1)) {
                            break Label_0187;
                        }
                        final int n6 = n5;
                        final char c = charArray[n6];
                        int n7 = 0;
                        switch (n5 % 7) {
                            case 0: {
                                n7 = 65;
                                break;
                            }
                            case 1: {
                                n7 = 79;
                                break;
                            }
                            case 2: {
                                n7 = 25;
                                break;
                            }
                            case 3: {
                                n7 = 33;
                                break;
                            }
                            case 4: {
                                n7 = 70;
                                break;
                            }
                            case 5: {
                                n7 = 73;
                                break;
                            }
                            default: {
                                n7 = 26;
                                break;
                            }
                        }
                        charArray[n6] = (char)(c ^ (n3 ^ n7));
                        ++n5;
                    }
                    if (!lIlllIlIIIl(length2, n5)) {
                        continue;
                    }
                    break;
                }
                array[n++] = new String(charArray).intern();
            } while ((n2 += char1) < length);
        }
        final String username = Class258.username;
    }
    
    private static void lIlllIIIlII() {
        (lIIIIIIIll = new String[] { null })[0] = "{\\\u00052VR\n\u0001\u0013Ys}i+uT\u0013";
    }
    
    private static String lIlllIIIIll(final String s, final String s2) {
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
    
    private static boolean lIlllIlIIIl(final int n, final int n2) {
        return n <= n2;
    }
}
