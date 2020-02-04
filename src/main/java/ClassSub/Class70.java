package ClassSub;

import cn.Hanabi.value.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class70
{
    private Value<String> value;
    private int x;
    private int y;
    private boolean readySelect;
    private boolean isSelectingMode;
    private double ani;
    public static Value<String> renderingValue;
    private static final long a;
    private static final String b;
    private static final String[] lIIllIlIlIl;
    
    public Class70(final Value value) {
        super();
        this.value = (Value<String>)value;
    }
    
    public final void draw$3b4dfe4b(final int n, final int n2) {
        final int[] b = Class139.b();
        final int currentMode = this.value.isCurrentMode("Light") ? 1 : 0;
        final float n4;
        final float n3 = (n4 = n2 - 5) + 7.0f;
        this.ani = Class69.getAnimationState(this.ani, 0.0, 400.0);
        Class69.drawRoundedRect(n - 80, n4, n - 20, (float)(n4 + this.ani), 2.0f, currentMode);
        Class69.drawRoundedRect(n - 80, n4, n - 20, n4 + 20.0f, 2.0f, currentMode);
        Class139.INSTANCE.fontManager.usans15.drawString(this.value.mode.get(this.value.getCurrentMode()), n - 75, n3, -1);
        final Iterator<String> iterator = this.value.mode.iterator();
        while (iterator.hasNext()) {
            final String s;
            final boolean equals = (s = iterator.next()).equals(this.value.mode.get(this.value.getCurrentMode()));
            Label_0295: {
                if (b == null) {
                    if (equals) {
                        new Class6().start();
                        this.value.setCurrentMode(this.value.mode.indexOf(s));
                        if (b != null) {
                            final Iterator<Class70> iterator2 = Class338.modeValueMap.values().iterator();
                            while (iterator2.hasNext()) {
                                iterator2.next();
                                new Class329().start();
                                if (b != null) {
                                    break Label_0295;
                                }
                                if (b != null) {
                                    break;
                                }
                            }
                        }
                    }
                    Class139.INSTANCE.fontManager.usans15.drawString(s, n - 75, n3, -1);
                }
            }
            if (b != null) {
                break;
            }
        }
    }
    
    private static boolean isHovering$5775bf99(final int p0, final double p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore_3       
        //     4: iload_0        
        //     5: i2d            
        //     6: dload_1        
        //     7: dcmpl          
        //     8: aload_3        
        //     9: ifnonnull       23
        //    12: ifle            19
        //    15: iconst_1       
        //    16: goto            20
        //    19: iconst_0       
        //    20: ifeq            40
        //    23: aload_3        
        //    24: ifnonnull       39
        //    27: ifge            34
        //    30: iconst_1       
        //    31: goto            35
        //    34: iconst_0       
        //    35: ifeq            40
        //    38: iconst_1       
        //    39: ireturn        
        //    40: iconst_0       
        //    41: ireturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #0023 (coming from #0020).
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2181)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
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
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static boolean access$002$48e05c1e$587cea02() {
        return false;
    }
    
    static boolean access$102$48e05c1e$587cea02() {
        return false;
    }
    
    static {
        llIllIllIIII();
        Class169.a(3588343598030117701L, 9018506988671530380L, MethodHandles.lookup().lookupClass()).a(258370106765711L);
        final Cipher instance = Cipher.getInstance(Class70.lIIllIlIlIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class70.lIIllIlIlIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(42884157109451L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class70.lIIllIlIlIl[2].getBytes(Class70.lIIllIlIlIl[3]))).intern();
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
    
    private static void llIllIllIIII() {
        (lIIllIlIlIl = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class70.lIIllIlIlIl[1] = "DES";
        Class70.lIIllIlIlIl[2] = "p@\u0081\u009aBm\u00812";
        Class70.lIIllIlIlIl[3] = "ISO-8859-1";
    }
    
    private static String llIllIlIlllI(final String s, final String s2) {
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
    
    private static String llIllIlIllll(final String s, final String s2) {
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
    
    private static String llIllIlIllIl(String s, final String s2) {
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
    
    private static boolean lllIlIIlIlll(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lllIlIlIIIII(final int n) {
        return n < 0;
    }
    
    private static boolean lllIlIIllIIl(final int n) {
        return n > 0;
    }
    
    private static int lllIlIIlIIll(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lllIlIIllIlI(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lllIlIIllIll(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
