package ClassSub;

import java.awt.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public class Class339
{
    public String parent;
    private float x;
    private float y;
    public boolean state;
    private double aniState;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map e;
    private static final String[] llIlIIllIl;
    
    public Class339(final String parent, final boolean state) {
        super();
        this.parent = parent;
        this.state = state;
        this.aniState = 8.0;
    }
    
    public final void draw(final float n, final float n2) {
        final int[] b = Class139.b();
        this.aniState = Class69.getAnimationState(this.aniState, 8.0, 100.0);
        final int[] array = b;
        final float n3 = n - 8.0f;
        final float n4 = n2 - 3.0f;
        final float n5 = n + 8.0f;
        final float n6 = n2 + 3.0f;
        final float n7 = 2.0f;
        final int currentMode = Class3.theme.isCurrentMode("Light") ? 1 : 0;
        if (array == null) {
            if (currentMode != 0) {
                new Color(Class22.GREY.c).brighter().getRGB();
            }
            else {
                new Color(40, 40, 40).getRGB();
            }
        }
        Class69.drawRoundedRect(n3, n4, n5, n6, n7, currentMode);
        final boolean currentMode2 = Class3.theme.isCurrentMode("Light");
        if (array == null) {
            if (currentMode2) {
                final float n8 = this.state ? ((float)(n - 4.0f + this.aniState)) : ((float)(n + 4.0f - this.aniState));
                final float n9 = 4.0f;
                final int state = this.state ? 1 : 0;
                if (array == null) {
                    if (state != 0) {
                        new Color(-14848033).brighter().getRGB();
                    }
                    else {
                        new Color(Class22.WHITE.c).darker().getRGB();
                    }
                }
                Class69.circle(n8, n2, n9, state);
                if (array == null) {
                    return;
                }
            }
            final boolean state2 = this.state;
        }
        final float n10 = currentMode2 ? ((float)(n - 4.0f + this.aniState)) : ((float)(n + 4.0f - this.aniState));
        final float n11 = 4.0f;
        final int state3 = this.state ? 1 : 0;
        if (array == null && state3 == 0) {}
        Class69.circle(n10, n2, n11, state3);
    }
    
    public final void toggle() {
        final int[] b = Class139.b();
        final boolean state = this.state;
        if (b == null && state) {}
        this.state = state;
        this.aniState = 0.0;
    }
    
    public final void isPressed$255f295() {
        Class139.b();
        this.onPress();
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
    
    public void onPress() {
        this.toggle();
    }
    
    static {
        lIIllIIlIIll();
        Class169.a(1091479462120940722L, 4767108384769883246L, MethodHandles.lookup().lookupClass()).a(134637163916733L);
        e = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class339.llIlIIllIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class339.llIlIIllIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(129813977328905L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class339.llIlIIllIl[2]).length();
        int char1 = 16;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            c2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class339.llIlIIllIl[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        c = c2;
        d = new String[2];
    }
    
    private static RuntimeException b(final RuntimeException ex) {
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x4B54;
        if (Class339.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class339.e.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class339.llIlIIllIl[4]);
                    array[1] = SecretKeyFactory.getInstance(Class339.llIlIIllIl[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class339.e.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class339.llIlIIllIl[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class339.d[n3] = a(((Cipher)array[0]).doFinal(Class339.c[n3].getBytes(Class339.llIlIIllIl[7])));
        }
        return Class339.d[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class339.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIllIIlIIll() {
        (llIlIIllIl = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class339.llIlIIllIl[1] = "DES";
        Class339.llIlIIllIl[2] = "\u0015·\u0089ñÌÁ°[.w\nA¥\u001bØó\u0010/¿ºBP|ï\u001fÆß0\u00adÑi¥W";
        Class339.llIlIIllIl[3] = "ISO-8859-1";
        Class339.llIlIIllIl[4] = "DES/CBC/PKCS5Padding";
        Class339.llIlIIllIl[5] = "DES";
        Class339.llIlIIllIl[6] = "现在你有没有恼羞成怒告诉我可以吗你这个废物那里的环境更适合你生存你回去再修炼几年再跟大哥来对抗吧你的无知只是我脚下的一对凌土你知道不垃圾狗篮子是不是啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u2003\u2008\u200b";
        Class339.llIlIIllIl[7] = "ISO-8859-1";
        Class339.llIlIIllIl[8] = "现在你有没有恼羞成怒告诉我可以吗你这个废物那里的环境更适合你生存你回去再修炼几年再跟大哥来对抗吧你的无知只是我脚下的一对凌土你知道不垃圾狗篮子是不是啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u2003\u2008\u200b";
        Class339.llIlIIllIl[9] = " : ";
        Class339.llIlIIllIl[10] = " : ";
    }
    
    private static String lIIllIIlIIlI(final String s, final String s2) {
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
    
    private static String lIIllIIlIIII(final String s, final String s2) {
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
    
    private static String lIIllIIlIIIl(String s, final String s2) {
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
    
    private static boolean lIIlllIlIIlI(final int n) {
        return n < 0;
    }
    
    private static boolean lIIlllIlIIII(final int n) {
        return n > 0;
    }
    
    private static int lIIlllIIlllI(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIIlllIIllll(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
