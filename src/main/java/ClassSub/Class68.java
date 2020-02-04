package ClassSub;

import cn.Hanabi.modules.*;
import java.awt.*;
import cn.Hanabi.utils.fontmanager.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class68
{
    public static Mod selectedMod;
    Mod mod;
    boolean selected;
    private float x;
    private float y;
    Class339 button;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lllllllIll;
    
    public Class68(final Mod mod) {
        super();
        this.selected = false;
        this.mod = mod;
    }
    
    private void draw(final int n, final int n2) {
        final int[] b = Class139.b();
        int selected;
        final boolean b2 = (selected = (this.selected ? 1 : 0)) != 0;
        Label_0063: {
            if (b == null) {
                if (!b2) {
                    break Label_0063;
                }
                Class68.selectedMod = this.mod;
                selected = n;
            }
            final float n3 = selected;
            final float n4 = n2;
            final float n5 = n + 100;
            final float n6 = n2 + 25;
            final float n7 = 6.0f;
            final int currentMode = Class3.theme.isCurrentMode("Light") ? 1 : 0;
            if (b == null && currentMode == 0) {}
            Class69.drawRoundedRect(n3, n4, n5, n6, n7, currentMode);
        }
        final UnicodeFontRenderer usans16 = Class139.INSTANCE.fontManager.usans16;
        final String name = this.mod.getName();
        final float n8 = n + 5;
        final float n9 = n2 + 12.5f - usans16.field_78288_b / 2;
        final int currentMode2 = Class3.theme.isCurrentMode("Light") ? 1 : 0;
        if (b == null) {
            if (currentMode2 != 0) {
                final int c = Class22.BLACK.c;
            }
            else {
                new Color(167, 167, 167).getRGB();
            }
        }
        usans16.drawString(name, n8, n9, currentMode2);
        final Class339 button = this.button;
        if (b == null) {
            if (button == null) {
                this.button = new Class93(this, this.mod.getName(), this.mod.state);
            }
            this.button.draw(n + 85, n2 + 12.5f);
            final Class339 button2 = this.button;
        }
        button.state = this.mod.state;
    }
    
    public static boolean isPressed$255f299() {
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
    
    private static boolean isHovering(final int n, final int n2, final double n3, final double n4, final double n5, final double n6) {
        final int[] b = Class139.b();
        final double n11;
        double n10;
        int n9;
        double n8;
        final int n7 = (int)(n8 = (n9 = (int)(n10 = dcmpl(n11 = n, n3))));
        if (b == null) {
            if (n7 <= 0) {
                return false;
            }
            final double n12;
            n8 = (n12 = (n9 = (int)(n10 = dcmpg(n11, n5))));
        }
        if (b == null) {
            if (n7 >= 0) {
                return false;
            }
            n9 = (int)(n8 = (n10 = dcmpl((double)n2, n4)));
        }
        if (b == null) {
            if (n8 <= 0) {
                return false;
            }
            n10 = (n9 = dcmpg((double)n2, n6));
        }
        if (b == null) {
            if (n9 >= 0) {
                return false;
            }
            n10 = 1;
        }
        return n10 != 0.0;
    }
    
    static {
        lIllIllllllI();
        Class169.a(1438266855732129963L, 3675505031954571517L, MethodHandles.lookup().lookupClass()).a(263565385702442L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class68.lllllllIll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class68.lllllllIll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(117160810489401L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class68.lllllllIll[2]).length();
        int char1 = 16;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class68.lllllllIll[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[2];
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static String a(final byte[] array) {
        int n = 0;
        final int length;
        final char[] array2 = new char[length = array.length];
        for (int i = 0; i < length; ++i) {
            final int n2;
            if ((n2 = (0xFF & array[i])) < 192) {
                array2[n++] = (char)n2;
            }
            else if (n2 < 224) {
                array2[n++] = (char)((char)((char)(n2 & 0x1F) << 6) | (char)(array[++i] & 0x3F));
            }
            else if (i < length - 2) {
                array2[n++] = (char)((char)((char)((char)(n2 & 0xF) << 12) | (char)(array[++i] & 0x3F) << 6) | (char)(array[++i] & 0x3F));
            }
        }
        return new String(array2, 0, n);
    }
    
    private static String a(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x6BD5;
        if (Class68.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class68.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class68.lllllllIll[4]);
                    array[1] = SecretKeyFactory.getInstance(Class68.lllllllIll[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class68.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class68.lllllllIll[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class68.c[n3] = a(((Cipher)array[0]).doFinal(Class68.b[n3].getBytes(Class68.lllllllIll[7])));
        }
        return Class68.c[n3];
    }
    
    private static Object a$dd29b59(final MutableCallSite mutableCallSite, final Object[] array) {
        final String a = a((int)array[0], (long)array[1]);
        mutableCallSite.setTarget(MethodHandles.dropArguments(MethodHandles.constant(String.class, a), 0, Integer.TYPE, Long.TYPE));
        return a;
    }
    
    private static CallSite a(final MethodHandles.Lookup p0, final String p1, final MethodType p2) {
        // 
        // This method could not be decompiled.
        // 
        // Could not show original bytecode, likely due to the same error.
        // 
        // The error that occurred was:
        // 
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class68.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
        //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:65)
        //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:729)
        //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveForgeJarDecompiled(FileSaver.java:228)
        //     at us.deathmarine.luyten.FileSaver.lambda$saveAllForgeDir$0(FileSaver.java:142)
        //     at java.lang.Thread.run(Unknown Source)
        // Caused by: java.lang.ClassCastException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void lIllIllllllI() {
        (lllllllIll = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class68.lllllllIll[1] = "DES";
        Class68.lllllllIll[2] = "é\b\u0091\u00152CP·Ô\u001cÅ#\nI7U\u0010ÜÁ¦É«\"\u001b6ö\u0096\u008bXÇÐÒS";
        Class68.lllllllIll[3] = "ISO-8859-1";
        Class68.lllllllIll[4] = "DES/CBC/PKCS5Padding";
        Class68.lllllllIll[5] = "DES";
        Class68.lllllllIll[6] = "你空白的大脑偶尔也思考这复杂的局势你在说下看看看你有气无力的挣扎我突然起来怜悯之心请停止你舞动在键盘上的手好吗那里是你的天堂NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200d\u200f\u2009\u2003";
        Class68.lllllllIll[7] = "ISO-8859-1";
        Class68.lllllllIll[8] = "你空白的大脑偶尔也思考这复杂的局势你在说下看看看你有气无力的挣扎我突然起来怜悯之心请停止你舞动在键盘上的手好吗那里是你的天堂NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200d\u200f\u2009\u2003";
        Class68.lllllllIll[9] = " : ";
        Class68.lllllllIll[10] = " : ";
    }
    
    private static String lIllIlllllIl(final String s, final String s2) {
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
    
    private static String lIllIllllIll(String s, final String s2) {
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
    
    private static String lIllIlllllII(final String s, final String s2) {
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
    
    private static boolean lIlllIIlIlIl(final int n) {
        return n < 0;
    }
    
    private static boolean lIlllIIlIlII(final int n) {
        return n > 0;
    }
    
    private static int lIlllIIlIIlI(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIlllIIlIIll(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
