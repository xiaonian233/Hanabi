package ClassSub;

import java.io.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final strictfp class Class176 implements Serializable
{
    private static final long serialVersionUID = 1339934L;
    public float x;
    public float y;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIlIIlIlIl;
    
    public Class176() {
        super();
    }
    
    private Class176(final float[] array) {
        super();
        this.x = array[0];
        this.y = array[1];
    }
    
    private Class176(final double theta) {
        super();
        this.x = 1.0f;
        this.y = 0.0f;
        this.setTheta(theta);
    }
    
    private strictfp void setTheta(double n) {
        final int[] b = Class139.b();
        final double n2 = n;
        double n3 = -360.0;
        Label_0082: {
            final double n4;
            Label_0061: {
                Label_0054: {
                    if (b == null) {
                        if (n2 >= -360.0) {
                            n4 = dcmpl(n, 360.0);
                            if (b != null) {
                                break Label_0061;
                            }
                            if (n4 <= 0) {
                                break Label_0054;
                            }
                        }
                        n3 = 360.0;
                    }
                    n = n2 % n3;
                }
                final double n5 = n;
                if (b != null) {
                    break Label_0082;
                }
                final double n6 = dcmpg(n5, 0.0);
            }
            if (n4 < 0) {
                n += 360.0;
            }
            this.getTheta();
        }
        final float length = this.length();
        this.x = length * (float)Class243.cos(StrictMath.toRadians(n));
        this.y = length * (float)Class243.sin(StrictMath.toRadians(n));
    }
    
    private strictfp Class176 add(final double n) {
        this.setTheta(this.getTheta() + n);
        return this;
    }
    
    private strictfp Class176 sub(final double n) {
        this.setTheta(this.getTheta() - n);
        return this;
    }
    
    private strictfp double getTheta() {
        final int[] b = Class139.b();
        double degrees = StrictMath.toDegrees(StrictMath.atan2(this.y, this.x));
        final int[] array = b;
        final double n = degrees;
        double n2 = -360.0;
        final double n3;
        final double n4;
        Label_0078: {
            Label_0071: {
                if (array == null) {
                    if (n >= -360.0) {
                        n3 = dcmpl(degrees, 360.0);
                        if (array != null) {
                            break Label_0078;
                        }
                        if (n3 <= 0) {
                            break Label_0071;
                        }
                    }
                    n2 = 360.0;
                }
                degrees = n % n2;
            }
            n4 = degrees;
            if (array != null) {
                return n4;
            }
            final double n5 = dcmpg(n4, 0.0);
        }
        if (n3 < 0) {
            degrees += 360.0;
        }
        return n4;
    }
    
    private strictfp float getX() {
        return this.x;
    }
    
    private strictfp float getY() {
        return this.y;
    }
    
    public Class176(final Class176 class176) {
        this(class176.x, class176.y);
    }
    
    public Class176(final float x, final float y) {
        super();
        this.x = x;
        this.y = y;
    }
    
    public final strictfp void set(final Class176 class176) {
        this.set(class176.x, class176.y);
    }
    
    public final strictfp float dot(final Class176 class176) {
        return this.x * class176.x + this.y * class176.y;
    }
    
    public final strictfp Class176 set(final float x, final float y) {
        this.x = x;
        this.y = y;
        return this;
    }
    
    private strictfp Class176 getPerpendicular() {
        return new Class176(-this.y, this.x);
    }
    
    private strictfp Class176 set(final float[] array) {
        return this.set(array[0], array[1]);
    }
    
    private strictfp Class176 negate() {
        return new Class176(-this.x, -this.y);
    }
    
    private strictfp Class176 negateLocal() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }
    
    private strictfp Class176 add(final Class176 class176) {
        this.x += class176.x;
        this.y += class176.y;
        return this;
    }
    
    public final strictfp Class176 sub(final Class176 class176) {
        this.x -= class176.x;
        this.y -= class176.y;
        return this;
    }
    
    private strictfp Class176 scale(final float n) {
        this.x *= n;
        this.y *= n;
        return this;
    }
    
    private strictfp Class176 normalise() {
        final int[] b = Class139.b();
        final float length = this.length();
        if (b == null) {
            if (length == 0.0f) {
                return this;
            }
            this.x /= length;
            this.y /= length;
        }
        return this;
    }
    
    private strictfp Class176 getNormal() {
        final Class176 copy;
        final Class176 class176 = copy = this.copy();
        final int[] b = Class139.b();
        final float length = copy.length();
        if (b == null && length != 0.0f) {
            final Class176 class177 = copy;
            class177.x /= length;
            final Class176 class178 = copy;
            class178.y /= length;
        }
        return class176;
    }
    
    public final strictfp float lengthSquared() {
        return this.x * this.x + this.y * this.y;
    }
    
    public final strictfp float length() {
        return (float)Math.sqrt(this.lengthSquared());
    }
    
    private strictfp void projectOntoUnit(final Class176 class176, final Class176 class177) {
        final float dot = class176.dot(this);
        class177.x = dot * class176.x;
        class177.y = dot * class176.y;
    }
    
    public final strictfp Class176 copy() {
        return new Class176(this.x, this.y);
    }
    
    @Override
    public final strictfp String toString() {
        return String.valueOf(new StringBuilder("[Vector2f ").append(this.x).append(Class176.lIlIIlIlIl[0]).append(this.y).append(" (").append(this.length()).append(")]"));
    }
    
    private strictfp float distance(Class176 class176) {
        final Class176 class177 = class176;
        class176 = this;
        final float n = class177.x - class176.x;
        final float n2 = class177.y - class176.y;
        final float n3 = n;
        final float n4 = n3 * n3;
        final float n5 = n2;
        return (float)Math.sqrt(n4 + n5 * n5);
    }
    
    private strictfp float distanceSquared(final Class176 class176) {
        final float n = class176.x - this.x;
        final float n2 = class176.y - this.y;
        final float n3 = n;
        final float n4 = n3 * n3;
        final float n5 = n2;
        return n4 + n5 * n5;
    }
    
    @Override
    public final strictfp int hashCode() {
        return 997 * (int)this.x ^ 991 * (int)this.y;
    }
    
    @Override
    public final strictfp boolean equals(final Object o) {
        final int[] b = Class139.b();
        final boolean b2 = o instanceof Class176;
        if (b == null && b2) {
            final Class176 class176;
            float n2;
            final float n = n2 = fcmpl((class176 = (Class176)o).x, this.x);
            if (b == null) {
                if (n != 0) {
                    return false;
                }
                final int n3;
                n2 = (n3 = fcmpl(class176.y, this.y));
            }
            if (b == null) {
                if (n != 0) {
                    return false;
                }
                n2 = 1;
            }
            return n2 != 0.0f;
        }
        return b2;
    }
    
    static {
        llllIlIIlIl();
        Class169.a(435714855365925750L, 1263794759938111264L, MethodHandles.lookup().lookupClass()).a(5919949815073L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class176.lIlIIlIlIl[1]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class176.lIlIIlIlIl[2]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(33439954663993L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[3];
        int n2 = 0;
        final String s;
        final int length = (s = Class176.lIlIIlIlIl[3]).length();
        int char1 = 16;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class176.lIlIIlIlIl[4]))).intern();
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x1DD;
        if (Class176.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class176.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class176.lIlIIlIlIl[5]);
                    array[1] = SecretKeyFactory.getInstance(Class176.lIlIIlIlIl[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class176.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class176.lIlIIlIlIl[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class176.c[n3] = a(((Cipher)array[0]).doFinal(Class176.b[n3].getBytes(Class176.lIlIIlIlIl[8])));
        }
        return Class176.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class176.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void llllIlIIlIl() {
        (lIlIIlIlIl = new String[12])[0] = ",";
        Class176.lIlIIlIlIl[1] = "DES/CBC/PKCS5Padding";
        Class176.lIlIIlIlIl[2] = "DES";
        Class176.lIlIIlIlIl[3] = "MÜ\u0000 Õ%Æ%kW!øâ\\\u001ew\u0010QÉ\u0019\u008f\tl6R\u001d$ºÿ}SÌv MvE)±&Ìº\u009eJ\u0011?\u0095¦\u0086-Ü{\u001c\u001a\u009fZ®\u0019O\u0083>\u009eî-õÓ";
        Class176.lIlIIlIlIl[4] = "ISO-8859-1";
        Class176.lIlIIlIlIl[5] = "DES/CBC/PKCS5Padding";
        Class176.lIlIIlIlIl[6] = "DES";
        Class176.lIlIIlIlIl[7] = "你自己用那些狗刨式的词汇来挑战我的忍耐力你干什么啊是不是气势凶凶了啊你以为你的速度登峰造极了开始对我肆无忌惮的人格抹杀自取其辱了你说给我展现自我的机会你和我反驳啥了啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u200e\u200b\u200c";
        Class176.lIlIIlIlIl[8] = "ISO-8859-1";
        Class176.lIlIIlIlIl[9] = "你自己用那些狗刨式的词汇来挑战我的忍耐力你干什么啊是不是气势凶凶了啊你以为你的速度登峰造极了开始对我肆无忌惮的人格抹杀自取其辱了你说给我展现自我的机会你和我反驳啥了啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u200e\u200b\u200c";
        Class176.lIlIIlIlIl[10] = " : ";
        Class176.lIlIIlIlIl[11] = " : ";
    }
    
    private static String llllIlIIlII(final String s, final String s2) {
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
    
    private static String llllIlIIIlI(String s, final String s2) {
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
    
    private static String llllIlIIIll(final String s, final String s2) {
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
    
    private static boolean llllIlIlIlI(final int n) {
        return n >= 0;
    }
    
    private static boolean llllIlIllII(final int n) {
        return n < 0;
    }
    
    private static boolean llllIlIlIll(final int n) {
        return n > 0;
    }
    
    private static int llllIlIlIII$25399e8(final double n) {
        return dcmpl(n, 360.0);
    }
    
    private static int llllIlIIllI(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int llllIlIlllI$25399e8(final double n) {
        return dcmpl(n, 360.0);
    }
    
    private static int llllIlIllIl(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int llllIllIIII$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int llllIllIIlI(final float n, final float n2) {
        return fcmpl(n, n2);
    }
}
