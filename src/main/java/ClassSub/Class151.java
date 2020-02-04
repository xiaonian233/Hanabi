package ClassSub;

import net.minecraft.client.gui.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.*;
import java.security.*;

public final class Class151
{
    private GuiScreen screen;
    private String text;
    public int animatedY;
    private boolean init;
    public String icon;
    private Class46 handler;
    private static final long a;
    static final String[] lIlIllIIIl;
    
    public Class151(final String icon) {
        super();
        this.animatedY = 0;
        new Class46();
        this.icon = icon;
    }
    
    private void draw$3b4dfe4b(final int n, final int n2) {
        final int[] b = Class139.b();
        this.animatedY = (int)Class69.getAnimationState(this.animatedY, n2, 200.0);
        Class69.circle(n, this.animatedY, 30.0f, Class22.WHITE.c);
        final String icon = this.icon;
        final int hashCode = icon.hashCode();
        if (b == null) {
            Label_0208: {
                switch (hashCode) {
                    case 59658: {
                        final boolean b3;
                        final boolean b2 = b3 = icon.equals(Class151.lIlIllIIIl[0]);
                        if (b != null) {
                            break;
                        }
                        if (b2 && b != null) {
                            break Label_0208;
                        }
                        break;
                    }
                    case 59660: {
                        final boolean b3;
                        final boolean b4 = b3 = icon.equals(Class151.lIlIllIIIl[1]);
                        if (b != null) {
                            break;
                        }
                        if (b4 && b != null) {
                            break Label_0208;
                        }
                        break;
                    }
                    case 59666: {
                        final boolean b3;
                        final boolean b5 = b3 = icon.equals(Class151.lIlIllIIIl[2]);
                        if (b != null) {
                            break;
                        }
                        if (b5 && b != null) {
                            break Label_0208;
                        }
                        break;
                    }
                    case 59661: {
                        final boolean b3;
                        final boolean b6 = b3 = icon.equals(Class151.lIlIllIIIl[3]);
                        if (b != null) {
                            break;
                        }
                        if (b6 && b != null) {
                            break Label_0208;
                        }
                        break;
                    }
                    case 59664: {
                        final boolean b3;
                        final boolean b7 = b3 = icon.equals(Class151.lIlIllIIIl[4]);
                        if (b != null) {
                            break;
                        }
                        if (b7) {
                            break;
                        }
                        break;
                    }
                }
            }
        }
        Label_0432: {
            Label_0391: {
                Label_0350: {
                    Label_0309: {
                        if (b == null) {
                            switch (hashCode) {
                                case 0: {
                                    Class139.INSTANCE.fontManager.icon70.drawString(this.icon, n - 17.0f, this.animatedY - 19, Class22.GREY.c);
                                    break;
                                }
                                case 1: {
                                    break Label_0309;
                                }
                                case 2: {
                                    break Label_0350;
                                }
                                case 3: {
                                    break Label_0391;
                                }
                                case 4: {
                                    break Label_0432;
                                }
                            }
                        }
                        if (b == null) {
                            return;
                        }
                    }
                    Class139.INSTANCE.fontManager.icon100.drawString(this.icon, n - 24.0f, this.animatedY - 28, Class22.GREY.c);
                    if (b == null) {
                        return;
                    }
                }
                Class139.INSTANCE.fontManager.icon70.drawString(this.icon, n - 17.0f, this.animatedY - 20, Class22.GREY.c);
                if (b == null) {
                    return;
                }
            }
            Class139.INSTANCE.fontManager.icon70.drawString(this.icon, n - 17.0f, this.animatedY - 19, Class22.GREY.c);
            if (b == null) {
                return;
            }
        }
        Class139.INSTANCE.fontManager.icon70.drawString(this.icon, n - 17.0f, this.animatedY - 19, Class22.GREY.c);
    }
    
    public static void onClick$3b4dfe4b() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: pop            
        //     4: invokestatic    ClassSub/Class139.b:()[I
        //     7: pop            
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static boolean isHovering$5afc9019() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: pop            
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        lllllIllllI();
        Class169.a(1867988912885748850L, 5244694701907152908L, MethodHandles.lookup().lookupClass()).a(117339357861802L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static void lllllIllllI() {
        (lIlIllIIIl = new String[5])[0] = "";
        Class151.lIlIllIIIl[1] = "";
        Class151.lIlIllIIIl[2] = "";
        Class151.lIlIllIIIl[3] = "";
        Class151.lIlIllIIIl[4] = "";
    }
    
    private static String lllllIllIlI(String s, final String s2) {
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
    
    private static String lllllIllIll(final String s, final String s2) {
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
    
    private static String lllllIlllII(final String s, final String s2) {
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
    
    private static boolean llllllIlIll(final int n) {
        return n < 0;
    }
    
    private static boolean llllllIlIII(final int n) {
        return n > 0;
    }
    
    private static int llllllIIllI(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int llllllIIlll(final float n, final float n2) {
        return fcmpg(n, n2);
    }
}
