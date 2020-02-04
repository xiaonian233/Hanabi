package ClassSub;

import com.google.gson.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class100
{
    private static String PRIMARY_COLOR;
    private static String SECONDARY_COLOR;
    private static final String PREFIX;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIlIIlIIIlI;
    
    public Class100() {
        super();
    }
    
    public static void send(final String s) {
        final JsonObject jsonObject;
        (jsonObject = new JsonObject()).addProperty("text", s);
        Minecraft.func_71410_x().field_71439_g.func_145747_a(IChatComponent$Serializer.func_150699_a(jsonObject.toString()));
    }
    
    public static void success(final String s) {
        info(s);
    }
    
    public static void info(final String s) {
        send(String.valueOf(new StringBuilder("§7[§1Hanabi§7] ").append(s)));
    }
    
    public static void showMessageBox(final String s) {
        showMessageBox(s, false);
    }
    
    public static void showMessageBox(final String s, final boolean b) {
        new Class272(s, b);
    }
    
    static {
        lllIIlIllIIl();
        Class169.a(8856338789543361760L, 7784342221016341242L, MethodHandles.lookup().lookupClass()).a(241349138582892L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class100.lIlIIlIIIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class100.lIlIIlIIIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(19786727226005L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Class100.lIlIIlIIIlI[2]).length();
        int n4 = 16;
        int n5 = -1;
    Label_0150:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class100.lIlIIlIIIlI[4]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class100.lIlIIlIIIlI[3]).length();
                            n4 = 40;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                break;
                            }
                            break Label_0150;
                        }
                    }
                    ++n5;
                    final String s4 = s;
                    final int n8 = n5;
                    s3 = s4.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        b = b2;
        c = new String[5];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x7E53;
        if (Class100.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class100.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class100.lIlIIlIIIlI[5]);
                    array[1] = SecretKeyFactory.getInstance(Class100.lIlIIlIIIlI[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class100.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class100.lIlIIlIIIlI[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class100.c[n3] = a(((Cipher)array[0]).doFinal(Class100.b[n3].getBytes(Class100.lIlIIlIIIlI[8])));
        }
        return Class100.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class100.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lllIIlIllIIl() {
        (lIlIIlIIIlI = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class100.lIlIIlIIIlI[1] = "DES";
        Class100.lIlIIlIIIlI[2] = "aL\u0018ÿ¤\u001a\u0014ü<¨lõöú\u0082\u001b\u0010¥²¢cû_\u007f¹V \u008aÞÜ \u0083\u0097(ýP\u0089q§²vd \u0019M\u000fçy&Óþ6È\u0090m3\u0001\u0013]\u0091Zµýø\u0091\u0095|\u001e\u0099é»\u008d\u000bl";
        Class100.lIlIIlIIIlI[3] = "ÈpÖT\u0018È°aO.8ã\u0089\u0083\u008e|?Ç\u0015\u0090Ìà´m\u0006&´\t}ÎîÂ\u001a\u0099\u0004ç÷õÞí\u0010s<N`SÙGO¬\u001b\u001dÆà,UC";
        Class100.lIlIIlIIIlI[4] = "ISO-8859-1";
        Class100.lIlIIlIIIlI[5] = "DES/CBC/PKCS5Padding";
        Class100.lIlIIlIIIlI[6] = "DES";
        Class100.lIlIIlIIIlI[7] = "草你妈的行不行啊孩子你不要灰心回你娘胎里再深造两年再出来和我抗衡爹爹我会等你你现在唯一的赌注是不是你的尊严别在那里恬不知耻了好吗我指着你脑袋瓜子羞辱你了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u2006\u2004\u200c";
        Class100.lIlIIlIIIlI[8] = "ISO-8859-1";
        Class100.lIlIIlIIIlI[9] = "草你妈的行不行啊孩子你不要灰心回你娘胎里再深造两年再出来和我抗衡爹爹我会等你你现在唯一的赌注是不是你的尊严别在那里恬不知耻了好吗我指着你脑袋瓜子羞辱你了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u2006\u2004\u200c";
        Class100.lIlIIlIIIlI[10] = " : ";
        Class100.lIlIIlIIIlI[11] = " : ";
    }
    
    private static String lllIIlIlIlll(final String s, final String s2) {
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
    
    private static String lllIIlIllIII(final String s, final String s2) {
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
    
    private static String lllIIlIlIllI(String s, final String s2) {
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
