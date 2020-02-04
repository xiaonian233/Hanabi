package cn.Hanabi.modules;

import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public enum Category
{
    COMBAT(array3[4]), 
    MOVEMENT(array3[1]), 
    PLAYER(array3[2]), 
    RENDER(array3[9]), 
    WORLD(array3[6]), 
    GHOST(array3[8]);
    
    private String name;
    private static final /* synthetic */ Category[] $VALUES;
    private static int a;
    private static final String[] lIIlIIlll;
    
    public static Category[] values() {
        return Category.$VALUES.clone();
    }
    
    public static Category valueOf(final String s) {
        return Enum.valueOf(Category.class, s);
    }
    
    private Category(final String name) {
        this.name = name;
    }
    
    @Override
    public final String toString() {
        return this.name;
    }
    
    static {
        llIIllIlIl();
        final long n = Class169.a(7937470203635765844L, 6577716373797521840L, MethodHandles.lookup().lookupClass()).a(245732729543537L) ^ 0x3DAD3574C284L;
        if (invokedynamic(U:(JJ)I, 5154151158017386548L, n) != 0) {
        }
        // invokedynamic(U:(IJJ)V, 119, 5152863722044762146L, n)
        final Cipher instance = Cipher.getInstance(Category.lIIlIIlll[0]);
        final int n2 = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Category.lIIlIIlll[1]);
        final byte[] array = new byte[8];
        array[0] = (byte)(n >>> 56);
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(n << i * 8 >>> 56);
        }
        instance.init(n2, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] array2 = new String[12];
        int n3 = 0;
        String s;
        int n4 = (s = Category.lIIlIIlll[2]).length();
        int n5 = 8;
        int n6 = -1;
    Label_0173:
        while (true) {
            while (true) {
                ++n6;
                final String s2 = s;
                final int n7 = n6;
                String s3 = s2.substring(n7, n7 + n5);
                int n8 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Category.lIIlIIlll[4]))).intern();
                    switch (n8) {
                        default: {
                            array2[n3++] = intern;
                            if ((n6 += n5) < n4) {
                                n5 = s.charAt(n6);
                                continue Label_0173;
                            }
                            n4 = (s = Category.lIIlIIlll[3]).length();
                            n5 = 8;
                            n6 = -1;
                            break;
                        }
                        case 0: {
                            array2[n3++] = intern;
                            if ((n6 += n5) < n4) {
                                n5 = s.charAt(n6);
                                break;
                            }
                            break Label_0173;
                        }
                    }
                    ++n6;
                    final String s4 = s;
                    final int n9 = n6;
                    s3 = s4.substring(n9, n9 + n5);
                    n8 = 0;
                }
            }
            break;
        }
        final String[] array3 = array2;
        $VALUES = new Category[] { Category.COMBAT, Category.MOVEMENT, Category.PLAYER, Category.RENDER, Category.WORLD, Category.GHOST };
    }
    
    public static void b(final int a) {
        Category.a = a;
    }
    
    public static int b() {
        return Category.a;
    }
    
    public static int a() {
        if (Category.a == 0) {
            return 34;
        }
        return 0;
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
    
    private static void llIIllIlIl() {
        (lIIlIIlll = new String[5])[0] = "DES/CBC/PKCS5Padding";
        Category.lIIlIIlll[1] = "DES";
        Category.lIIlIIlll[2] = "¸D\u0086\u0084F=\u0005>\u0010H\u0010¶Þ-\u0002%Ï@ðð{CIXÊ\bL«\u0092\u0088ãÆÐ¼\u0010Ç\u001f\u001eÔu³ý\u009eöÁéÄX«ê\u0082\b\u0000g`û¦°\u009cc\b\u0010,¢»\u0001\u0097ÉW\b\u0093ÿìÙ\u0016P\u009a:\b;(\u0097h©¥\b\n\bF·âz\u0007\u000bTg\b\u001aë¾\u009cGâ¿:";
        Category.lIIlIIlll[3] = "\u00821\u0006\u0099r®\\|\b!'ÝÑã\tÙ\u0003";
        Category.lIIlIIlll[4] = "ISO-8859-1";
    }
    
    private static String llIIllIIIl(final String s, final String s2) {
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
    
    private static String llIIllIIII(String s, final String s2) {
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
}
