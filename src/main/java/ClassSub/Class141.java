package ClassSub;

import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import java.awt.*;
import cn.Hanabi.utils.fontmanager.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public class Class141
{
    float x;
    float y;
    float radius;
    String logo;
    public String title;
    ScaledResolution sr;
    public Boolean active;
    private double state;
    private Class268 sb;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIIllIIIlI;
    
    public Class141(final float x, final float y, final float radius, final String title, final ScaledResolution sr, final Class268 sb) {
        super();
        this.active = Boolean.FALSE;
        this.state = 0.0;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.title = title;
        this.sr = sr;
        this.sb = sb;
        if (title.equals("Combat")) {
            this.logo = HanabiFonts.ICON_CLICKGUI_COMBAT;
            return;
        }
        if (title.equals("Movement")) {
            this.logo = HanabiFonts.ICON_CLICKGUI_MOVEMENT;
            return;
        }
        if (title.equals("Render")) {
            this.logo = HanabiFonts.ICON_CLICKGUI_RENDER;
            return;
        }
        if (title.equals("Player")) {
            this.logo = HanabiFonts.ICON_CLICKGUI_PLAYER;
            return;
        }
        if (title.equals("World")) {
            this.logo = HanabiFonts.ICON_CLICKGUI_WORLD;
            return;
        }
        this.logo = HanabiFonts.ICON_CLICKGUI_GHOST;
    }
    
    private void drawButton() {
        final int[] b = Class139.b();
        this.sr = new ScaledResolution(Minecraft.func_71410_x());
        final int[] array = b;
        int booleanValue;
        final int n = booleanValue = (((boolean)this.active) ? 1 : 0);
        if (array == null) {
            if (n == 0) {
                return;
            }
            double state = this.state;
            final int[] b2 = Class139.b();
            final float n2 = (float)(Class69.delta * 35.0);
            final int[] array2 = b2;
            final double n3 = dcmpg(state, 5.0);
            Label_0160: {
                final double n7;
                Label_0159: {
                    if (array2 == null) {
                        if (n3 < 0) {
                            double n5;
                            final double n4 = n5 = state + n2;
                            if (array2 == null) {
                                final double n6 = n4;
                                if (n4 < 5.0) {
                                    state = n6;
                                    if (array2 == null) {
                                        break Label_0160;
                                    }
                                }
                                n5 = 5.0;
                            }
                            state = n5;
                            if (array2 == null) {
                                break Label_0160;
                            }
                        }
                        n7 = state - n2;
                        if (array2 != null) {
                            break Label_0159;
                        }
                        final double n8 = dcmpl(n7, 5.0);
                    }
                    if (n3 > 0) {
                        state -= n2;
                        if (array2 == null) {
                            break Label_0160;
                        }
                    }
                }
                state = n7;
            }
            this.state = state;
            booleanValue = (int)this.x - 45;
        }
        final float n9 = booleanValue;
        final float n10 = (int)this.y - 16;
        final float n11 = (int)this.x + 45;
        final float n12 = (int)this.y + 17;
        final float n13 = 15.0f;
        final int currentMode = Class3.theme.isCurrentMode("Light") ? 1 : 0;
        if (array == null) {
            if (currentMode != 0) {
                new Color(-14848033).brighter().getRGB();
            }
            else {
                new Color(47, 116, 253).getRGB();
            }
        }
        Class69.drawRoundedRect(n9, n10, n11, n12, n13, currentMode);
    }
    
    private void drawOther() {
        final int[] b = Class139.b();
        final float n = this.sr.func_78328_b() / 60.0f * 4.0f;
        final int[] array = b;
        final UnicodeFontRenderer fontWithCustomGlyph$24c8c416 = Class139.INSTANCE.fontManager.getFontWithCustomGlyph$24c8c416("icon", n);
        final UnicodeFontRenderer font = Class139.INSTANCE.fontManager.getFont("raleway", n / 2.0f);
        if (Class3.theme.isCurrentMode("Light")) {
            final UnicodeFontRenderer unicodeFontRenderer = fontWithCustomGlyph$24c8c416;
            final String logo = this.logo;
            final float n2 = this.x - this.radius / 2.0f;
            final float n3 = this.y - fontWithCustomGlyph$24c8c416.getStringHeight(this.logo) / 2.0f;
            final int booleanValue = ((boolean)this.active) ? 1 : 0;
            if (array == null) {
                if (booleanValue != 0) {
                    new Color(255, 255, 255).getRGB();
                }
                else {
                    new Color(-14848033).brighter().getRGB();
                }
            }
            unicodeFontRenderer.drawString(logo, n2, n3, booleanValue);
            final UnicodeFontRenderer unicodeFontRenderer2 = font;
            final String title = this.title;
            final float n4 = this.x - fontWithCustomGlyph$24c8c416.func_78256_a(this.logo) / 2;
            final float n5 = this.y - font.getStringHeight(this.title) / 2.0f;
            final int booleanValue2 = ((boolean)this.active) ? 1 : 0;
            if (array == null) {
                if (booleanValue2 != 0) {
                    new Color(255, 255, 255).getRGB();
                }
                else {
                    new Color(-14848033).brighter().getRGB();
                }
            }
            unicodeFontRenderer2.drawString(title, n4, n5, booleanValue2);
            if (array == null) {
                return;
            }
        }
        final UnicodeFontRenderer unicodeFontRenderer3 = fontWithCustomGlyph$24c8c416;
        final String logo2 = this.logo;
        final float n6 = this.x - this.radius / 2.0f;
        final float n7 = this.y - fontWithCustomGlyph$24c8c416.getStringHeight(this.logo) / 2.0f;
        final int booleanValue3 = ((boolean)this.active) ? 1 : 0;
        if (array == null) {
            if (booleanValue3 != 0) {
                new Color(255, 255, 255).getRGB();
            }
            else {
                new Color(47, 116, 253).getRGB();
            }
        }
        unicodeFontRenderer3.drawString(logo2, n6, n7, booleanValue3);
        final UnicodeFontRenderer unicodeFontRenderer4 = font;
        final String title2 = this.title;
        final float n8 = this.x - fontWithCustomGlyph$24c8c416.func_78256_a(this.logo) / 2;
        final float n9 = this.y - font.getStringHeight(this.title) / 2.0f;
        final int booleanValue4 = ((boolean)this.active) ? 1 : 0;
        if (array == null) {
            if (booleanValue4 != 0) {
                new Color(255, 255, 255).getRGB();
            }
            else {
                new Color(47, 116, 253).getRGB();
            }
        }
        unicodeFontRenderer4.drawString(title2, n8, n9, booleanValue4);
    }
    
    public void onPress() {
        final int[] b = Class139.b();
        final Iterator<Class141> iterator = this.sb.button.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            iterator.next().active = Boolean.FALSE;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        this.active = Boolean.TRUE;
        this.state = 0.0;
    }
    
    private boolean isPressed(int n, int n2) {
        final int[] b = Class139.b();
        final int n3 = n;
        final int n4 = n2;
        final double n5 = this.x - this.radius / 1.5;
        final double n6 = this.y - this.radius / 3.5;
        final double n7 = this.x + this.radius / 1.5;
        final double n8 = this.y + this.radius / 3.5;
        final double n9 = n7;
        final double n10 = n6;
        final double n11 = n5;
        n2 = n4;
        n = n3;
        final int[] b2 = Class139.b();
        final double n12 = n;
        final double n13 = n11;
        final double n14 = n12;
        boolean b3;
        boolean booleanValue;
        int n18;
        int n17;
        int n16;
        final int n15 = n16 = (n17 = (n18 = ((booleanValue = (b3 = dcmpl(n12, n13))) ? 1 : 0)));
        Label_0177: {
            Label_0176: {
                if (b2 == null) {
                    if (n15 <= 0) {
                        break Label_0176;
                    }
                    final int n19;
                    n16 = (n19 = (n17 = (n18 = ((booleanValue = (b3 = dcmpg(n14, n9))) ? 1 : 0))));
                }
                if (b2 == null) {
                    if (n15 >= 0) {
                        break Label_0176;
                    }
                    n17 = (n16 = (n18 = ((booleanValue = (b3 = dcmpl((double)n2, n10))) ? 1 : 0)));
                }
                if (b2 == null) {
                    if (n16 <= 0) {
                        break Label_0176;
                    }
                    n18 = (n17 = ((booleanValue = (b3 = dcmpg((double)n2, n8))) ? 1 : 0));
                }
                if (b2 == null) {
                    if (n17 >= 0) {
                        break Label_0176;
                    }
                    booleanValue = ((n18 = ((b3 = true) ? 1 : 0)) != 0);
                }
                break Label_0177;
            }
            booleanValue = ((n18 = ((b3 = false) ? 1 : 0)) != 0);
        }
        if (b == null) {
            if (n18 == 0) {
                return false;
            }
            b3 = (booleanValue = this.active);
        }
        if (b == null) {
            if (booleanValue) {
                return false;
            }
            b3 = true;
        }
        return b3;
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
    
    private static double getAnimationState$482004d7(double n) {
        final int[] b = Class139.b();
        final float n2 = (float)(Class69.delta * 35.0);
        final int[] array = b;
        final double n3 = dcmpg(n, 5.0);
        final double n7;
        if (array == null) {
            if (n3 < 0) {
                double n5;
                final double n4 = n5 = n + n2;
                if (array == null) {
                    final double n6 = n4;
                    if (n4 < 5.0) {
                        n = n6;
                        if (array == null) {
                            return n;
                        }
                    }
                    n5 = 5.0;
                }
                n = n5;
                if (array == null) {
                    return n;
                }
            }
            n7 = n - n2;
            if (array != null) {
                return n7;
            }
            final double n8 = dcmpl(n7, 5.0);
        }
        if (n3 > 0) {
            n -= n2;
            if (array == null) {
                return n;
            }
        }
        n = n7;
        return n;
    }
    
    static {
        lllIIIlIIIl();
        Class169.a(6049679130403233259L, 994616258463624042L, MethodHandles.lookup().lookupClass()).a(202430526572371L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class141.lIIllIIIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class141.lIIllIIIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(74541743421954L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[9];
        int n2 = 0;
        String s;
        int n3 = (s = Class141.lIIllIIIlI[2]).length();
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class141.lIIllIIIlI[4]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class141.lIIllIIIlI[3]).length();
                            n4 = 16;
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
        c = new String[9];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x1FDF;
        if (Class141.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class141.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class141.lIIllIIIlI[5]);
                    array[1] = SecretKeyFactory.getInstance(Class141.lIIllIIIlI[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class141.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class141.lIIllIIIlI[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class141.c[n3] = a(((Cipher)array[0]).doFinal(Class141.b[n3].getBytes(Class141.lIIllIIIlI[8])));
        }
        return Class141.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class141.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lllIIIlIIIl() {
        (lIIllIIIlI = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class141.lIIllIIIlI[1] = "DES";
        Class141.lIIllIIIlI[2] = "\u008e\fÌÑØ×=\u001d\u0018¦\u0083.\u001eY4\u0083\u0010ã¿~\u0092ôA\u00912\u0099e\u0004öuT°¼ [ ¡húÅµZ\r ©Ð\u008a\u0019Û\u0088)Ír\u0088t\u000f½2pA\u0011Z,]\u001cê\u0010!¤ûö/Õ÷\u008f\n0,¾3Aä=\u0010©\u001b\u00020-\u008d3\u0003ÚXO\u0004\u0004\n\u009f\u007f\u0010V\u0011ý©ü¹_@&ï\u0012\u0095Z\u0096¸¼\u0010\u0000H\u0097ö\u000bJ\u0096\\Aá\u009cæô@\u001b%";
        Class141.lIIllIIIlI[3] = "A\u0094¾XÙùt\u0006\u0004ôÅgÄ+\u0097À\u00108µ\u0002^ºxDý\u0081VZ~j\n°\u0098";
        Class141.lIIllIIIlI[4] = "ISO-8859-1";
        Class141.lIIllIIIlI[5] = "DES/CBC/PKCS5Padding";
        Class141.lIIllIIIlI[6] = "DES";
        Class141.lIIllIIIlI[7] = "你不要妄想什么到最后出什么状况你是不是一窍不通啊你这连ABC都不知道怎么念的东西你看看你现在的样子面目狰狞想忤逆你亲爹是吗你记住以后不要再用你那粗俗的语言就像让我来定格你的人品NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u2008\u2006\u2009";
        Class141.lIIllIIIlI[8] = "ISO-8859-1";
        Class141.lIIllIIIlI[9] = "你不要妄想什么到最后出什么状况你是不是一窍不通啊你这连ABC都不知道怎么念的东西你看看你现在的样子面目狰狞想忤逆你亲爹是吗你记住以后不要再用你那粗俗的语言就像让我来定格你的人品NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u2008\u2006\u2009";
        Class141.lIIllIIIlI[10] = " : ";
        Class141.lIIllIIIlI[11] = " : ";
    }
    
    private static String lllIIIIIlIl(final String s, final String s2) {
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
    
    private static String lllIIIIIIlI(String s, final String s2) {
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
    
    private static String lllIIIIIIll(final String s, final String s2) {
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
    
    private static boolean lllIIIllllI(final int n) {
        return n < 0;
    }
    
    private static boolean lllIIIlllIl(final int n) {
        return n > 0;
    }
    
    private static int lllIIIllIll(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lllIIIlllII(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lllIIlIIIII(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lllIIIlllll(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
