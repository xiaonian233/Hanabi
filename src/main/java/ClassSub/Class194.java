package ClassSub;

import cn.Hanabi.value.*;
import java.awt.*;
import cn.Hanabi.utils.fontmanager.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import org.lwjgl.input.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class194
{
    Value<Double> value;
    public float x;
    private float y;
    boolean isDraging;
    boolean clickNotDraging;
    private int tX;
    private int tY;
    private int dragX;
    private int dragY;
    double ani;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    static final String[] llIllIllIll;
    
    public Class194(final Value value) {
        super();
        this.value = (Value<Double>)value;
    }
    
    private void draw(final float x, final float n) {
        final int[] b = Class139.b();
        this.x = x;
        final int[] array = b;
        final UnicodeFontRenderer comfortaa16 = Class139.INSTANCE.fontManager.comfortaa16;
        final double n2 = (this.value.value - this.value.getValueMin()) / (this.value.getValueMax() - this.value.getValueMin());
        final UnicodeFontRenderer unicodeFontRenderer = comfortaa16;
        final String s = this.value.name.split(Class194.llIllIllIll[0])[1];
        final float n3 = x + 120.0f;
        float n4 = n;
        final Color color = new Color(212, 212, 212);
        int n6 = 0;
        Label_0232: {
            if (array == null) {
                unicodeFontRenderer.drawString(s, n3, n, color.getRGB());
                String.valueOf(new StringBuilder().append(this.value.value).append(Class194.llIllIllIll[1]));
                final float n5 = x - 165.0f - comfortaa16.func_78256_a(String.valueOf(new StringBuilder().append(this.value.value).append(Class194.llIllIllIll[2])));
                n4 = n;
                if (Class3.theme.isCurrentMode("Light")) {
                    n6 = Class22.GREY.c;
                    break Label_0232;
                }
                final Color color2 = new Color(212, 212, 212);
            }
            n6 = color.getRGB();
        }
        unicodeFontRenderer.drawString(s, n3, n4, n6);
        Class194 class194 = this;
        Label_0277: {
            if (array == null) {
                if (this.ani != 0.0 && !Class338.isDraging) {
                    break Label_0277;
                }
                class194 = this;
            }
            class194.ani = (float)(x - 15.0f - (140.0 - n2 * 140.0));
        }
        this.ani = Class69.getAnimationState(this.ani, (float)(x - 15.0f - (140.0 - n2 * 140.0)), 600.0);
        final float n7 = x - 155.0f;
        final float n8 = n + 3.0f;
        final float n9 = x - 15.0f;
        final float n10 = n + 6.0f;
        final float n11 = 1.0f;
        final int currentMode = Class3.theme.isCurrentMode("Light") ? 1 : 0;
        if (array == null) {
            if (currentMode != 0) {
                final int c = Class22.GREY.c;
            }
            else {
                new Color(27, 27, 27).getRGB();
            }
        }
        Class69.drawRoundedRect(n7, n8, n9, n10, n11, currentMode);
        final float n12 = x - 155.0f;
        final float n13 = n + 3.0f;
        final float n14 = (float)this.ani;
        final float n15 = n + 6.0f;
        final float n16 = 1.0f;
        final int currentMode2 = Class3.theme.isCurrentMode("Light") ? 1 : 0;
        if (array == null) {
            if (currentMode2 != 0) {
                new Color(-14848033).brighter().getRGB();
            }
            else {
                new Color(16, 72, 182).getRGB();
            }
        }
        Class69.drawRoundedRect(n12, n13, n14, n15, n16, currentMode2);
        final float n17 = (float)this.ani;
        final float n18 = n + 4.5f;
        final float n19 = 3.0f;
        final int currentMode3 = Class3.theme.isCurrentMode("Light") ? 1 : 0;
        if (array == null) {
            if (currentMode3 != 0) {
                new Color(-14848033).brighter().getRGB();
            }
            else {
                new Color(29, 111, 223).getRGB();
            }
        }
        Class69.circle(n17, n18, n19, currentMode3);
    }
    
    private void onPress$255f295(final int isDraging) {
        final int[] b = Class139.b();
        new ScaledResolution(Minecraft.func_71410_x());
        final int[] array = b;
        if (b == null) {
            if (Mouse.isButtonDown(0)) {
                this.isDraging = (isDraging != 0);
                if (array != null) {
                    this.clickNotDraging = true;
                }
                if (array != null) {
                    return;
                }
                if (!this.isDraging) {
                    return;
                }
                if (array != null) {
                    return;
                }
                if (this.clickNotDraging) {
                    return;
                }
                double n2;
                final double n = dcmpg(n2 = (isDraging - this.x + 155.0f) / 140.0f, 0.0);
                final double n3;
                double doubleValue = 0.0;
                Label_0159: {
                    if (array == null) {
                        if (n < 0) {
                            n2 = 0.0;
                        }
                        n3 = n2;
                        doubleValue = 1.0;
                        if (array != null) {
                            break Label_0159;
                        }
                        final double n4 = dcmpl(n3, 1.0);
                    }
                    if (n > 0) {
                        n2 = 1.0;
                    }
                    final double n5 = (this.value.getValueMax() - this.value.getValueMin()) * n2;
                    doubleValue = this.value.getValueMin();
                }
                this.value.value = Math.round((n3 + doubleValue) * (1.0 / this.value.step)) / (1.0 / this.value.step);
                if (array == null) {
                    return;
                }
            }
            this.isDraging = false;
        }
        this.clickNotDraging = false;
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
        lIIllIIIIIlIl();
        Class169.a(2742781473045761835L, 4149109380329973982L, MethodHandles.lookup().lookupClass()).a(762117221453L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class194.llIllIllIll[3]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class194.llIllIllIll[4]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(18410381638255L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class194.llIllIllIll[5]).length();
        int char1 = 16;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class194.llIllIllIll[6]))).intern();
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x1ADB;
        if (Class194.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class194.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class194.llIllIllIll[7]);
                    array[1] = SecretKeyFactory.getInstance(Class194.llIllIllIll[8]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class194.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class194.llIllIllIll[9], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class194.c[n3] = a(((Cipher)array[0]).doFinal(Class194.b[n3].getBytes(Class194.llIllIllIll[10])));
        }
        return Class194.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class194.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIllIIIIIlIl() {
        (llIllIllIll = new String[14])[0] = "_";
        Class194.llIllIllIll[1] = "";
        Class194.llIllIllIll[2] = "";
        Class194.llIllIllIll[3] = "DES/CBC/PKCS5Padding";
        Class194.llIllIllIll[4] = "DES";
        Class194.llIllIllIll[5] = "ÚÀvu\u0098ï¹\u0080{:ýÎ ÁÏô\u0010\u0093\u0093\r\b¡Ç²\u0014\\Å\u000f\u001b\u0089ìAî";
        Class194.llIllIllIll[6] = "ISO-8859-1";
        Class194.llIllIllIll[7] = "DES/CBC/PKCS5Padding";
        Class194.llIllIllIll[8] = "DES";
        Class194.llIllIllIll[9] = "我很欣赏你的个性你是害怕了对吧是不是你就是你爹娘的失败之作你才这样没用的我给你证据你要吗你告诉我啊你用你稀稀拉拉的言语攻击我啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200f\u2005\u200c\u200f";
        Class194.llIllIllIll[10] = "ISO-8859-1";
        Class194.llIllIllIll[11] = "我很欣赏你的个性你是害怕了对吧是不是你就是你爹娘的失败之作你才这样没用的我给你证据你要吗你告诉我啊你用你稀稀拉拉的言语攻击我啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200f\u2005\u200c\u200f";
        Class194.llIllIllIll[12] = " : ";
        Class194.llIllIllIll[13] = " : ";
    }
    
    private static String lIIlIlllllIIl(final String s, final String s2) {
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
    
    private static String lIIlIlllllIII(String s, final String s2) {
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
    
    private static String lIIlIlllllIll(final String s, final String s2) {
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
    
    private static boolean lIIllIIIlIIIl(final int n) {
        return n < 0;
    }
    
    private static boolean lIIllIIIlIIlI(final int n) {
        return n > 0;
    }
    
    private static int lIIllIIIIlIlI$25399e8(final double n) {
        return dcmpl(n, 0.0);
    }
    
    private static int lIIllIIIIlllI$25399e8(final double n) {
        return dcmpl(n, 1.0);
    }
    
    private static int lIIllIIIIllIl$25399e8(final double n) {
        return dcmpg(n, 0.0);
    }
    
    private static int lIIllIIIlIIll(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIIllIIIlIlII(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
