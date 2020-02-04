package ClassSub;

import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

final class Class88
{
    public short id;
    public short x;
    public short y;
    public short width;
    public short height;
    public short xoffset;
    public short yoffset;
    public short xadvance;
    public Class85 image;
    private short dlIndex;
    public short[] kerning;
    final Class181 this$0;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIlIlIII;
    
    private Class88(final Class181 this$0) {
        this.this$0 = this$0;
        super();
    }
    
    private void init() {
        this.image = Class181.access$400(this.this$0).getSubImage(this.x, this.y, this.width, this.height);
    }
    
    @Override
    public final String toString() {
        return String.valueOf(new StringBuilder("[CharDef id=").append(this.id).append(" x=").append(this.x).append(" y=").append(this.y).append(Class88.lIlIlIII[0]));
    }
    
    public final void draw(final float n, final float n2) {
        this.image.drawEmbedded(n + this.xoffset, n2 + this.yoffset, this.width, this.height);
    }
    
    public final int getKerning(final int n) {
        final int[] b = Class139.b();
        if (this.kerning == null) {
            return 0;
        }
        int i = 0;
        int n2 = this.kerning.length - 1;
        while (i <= n2) {
            final int n3 = i + n2 >>> 1;
            final short n8;
            final int n7;
            int n6;
            int n5;
            final int n4 = n5 = (n6 = (n7 = ((n8 = this.kerning[n3]) & 0xFF)));
            if (b != null) {
                return n7;
            }
            int n9 = n;
            Label_0119: {
                if (b == null) {
                    if (n4 < n) {
                        i = n3 + 1;
                        if (b == null) {
                            break Label_0119;
                        }
                    }
                    n6 = (n5 = n4);
                    n9 = n;
                }
                if (b == null) {
                    if (n5 > n) {
                        n2 = n3 - 1;
                        if (b == null) {
                            break Label_0119;
                        }
                    }
                    n6 = n8;
                    n9 = 8;
                }
                return n6 >> n9;
            }
            if (b != null) {
                break;
            }
        }
        return 0;
    }
    
    Class88(final Class181 class181, final byte b) {
        this(class181);
    }
    
    static {
        lllIIIIII();
        Class169.a(6984243607858948535L, 1079909972611809278L, MethodHandles.lookup().lookupClass()).a(195709268492075L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class88.lIlIlIII[1]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class88.lIlIlIII[2]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(132306670548458L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[3];
        int n2 = 0;
        final String s;
        final int length = (s = Class88.lIlIlIII[3]).length();
        int char1 = 16;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class88.lIlIlIII[4]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[3];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x5B93;
        if (Class88.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class88.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class88.lIlIlIII[5]);
                    array[1] = SecretKeyFactory.getInstance(Class88.lIlIlIII[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class88.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class88.lIlIlIII[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class88.c[n3] = a(((Cipher)array[0]).doFinal(Class88.b[n3].getBytes(Class88.lIlIlIII[8])));
        }
        return Class88.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class88.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lllIIIIII() {
        (lIlIlIII = new String[12])[0] = "]";
        Class88.lIlIlIII[1] = "DES/CBC/PKCS5Padding";
        Class88.lIlIlIII[2] = "DES";
        Class88.lIlIlIII[3] = "\u0005\u0083î1=\u0006S\u0088\u008c±-}`\u0098\u000bÛ\u00103\u0093cQÔ\u008e\u0019\u0088£\u0006»TPE\u001bz\u0018ó\u0014W÷r\u000fK¯«Èì]LÉ¡N®·ð\u0014\u0006K(z";
        Class88.lIlIlIII[4] = "ISO-8859-1";
        Class88.lIlIlIII[5] = "DES/CBC/PKCS5Padding";
        Class88.lIlIlIII[6] = "DES";
        Class88.lIlIlIII[7] = "小伙子你是不是啊我看你都没速度和我唠嗑你晓得啥你别虎了吗你现在所有的话都是胡言乱语躲躲闪闪气急败坏不服输只会狗急跳墙死皮赖脸的用复制和你妖域的爷爷奶奶们抗衡你是不是内心充满着恐惧NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a\u200f\u200c\u2003";
        Class88.lIlIlIII[8] = "ISO-8859-1";
        Class88.lIlIlIII[9] = "小伙子你是不是啊我看你都没速度和我唠嗑你晓得啥你别虎了吗你现在所有的话都是胡言乱语躲躲闪闪气急败坏不服输只会狗急跳墙死皮赖脸的用复制和你妖域的爷爷奶奶们抗衡你是不是内心充满着恐惧NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a\u200f\u200c\u2003";
        Class88.lIlIlIII[10] = " : ";
        Class88.lIlIlIII[11] = " : ";
    }
    
    private static String llIllllIl(final String s, final String s2) {
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
    
    private static String llIlllllI(String s, final String s2) {
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
    
    private static String llIllllll(final String s, final String s2) {
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
    
    private static boolean lllIIIIlI(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean lllIIIlIl(final int n, final int n2) {
        return n > n2;
    }
}
