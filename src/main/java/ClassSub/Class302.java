package ClassSub;

import java.awt.*;
import net.minecraft.client.*;
import cn.Hanabi.utils.fontmanager.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public final class Class302
{
    public String message;
    public Class220 timer;
    double lastY;
    double posY;
    double width;
    double height;
    double animationX;
    int color;
    private int imageWidth;
    Class153 t;
    private long stayTime;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    static final String[] lllIlllII;
    
    public Class302(final String message, final Class153 t) {
        super();
        this.message = message;
        final int[] b = Class139.b();
        this.timer = new Class220();
        this.timer.lastMs = System.currentTimeMillis();
        this.width = Class139.INSTANCE.fontManager.comfortaa16.func_78256_a(message) + 35;
        this.height = 20.0;
        this.animationX = this.width;
        final int[] array = b;
        this.stayTime = 1500L;
        this.posY = -1.0;
        this.t = t;
        boolean b3;
        boolean equals;
        final boolean b2 = equals = (b3 = t.equals(Class153.INFO));
        if (array == null) {
            if (b2) {
                this.color = Class22.DARKGREY.c;
                if (array == null) {
                    return;
                }
            }
            final boolean b4;
            equals = (b4 = (b3 = t.equals(Class153.ERROR)));
        }
        if (array == null) {
            if (b2) {
                this.color = new Color(36, 36, 36).getRGB();
                if (array == null) {
                    return;
                }
            }
            b3 = (equals = t.equals(Class153.SUCCESS));
        }
        if (array == null) {
            if (equals) {
                this.color = new Color(36, 36, 36).getRGB();
                if (array == null) {
                    return;
                }
            }
            b3 = t.equals(Class153.WARNING);
        }
        if (b3) {
            this.color = Class22.DARKGREY.c;
        }
    }
    
    private void draw(final double posY, final double lastY) {
        this.width = Class139.INSTANCE.fontManager.comfortaa15.func_78256_a(this.message) + 45;
        this.height = 22.0;
        final int[] b = Class139.b();
        this.lastY = lastY;
        final double animationX = this.animationX;
        Class302 class302 = this;
        double width = 0.0;
        Label_0066: {
            if (b == null) {
                if (!this.isFinished()) {
                    width = 0.0;
                    break Label_0066;
                }
                class302 = this;
            }
            width = class302.width;
        }
        final double n = this.isFinished() ? 200.0 : 30.0;
        final double animationX2 = this.animationX;
        Class302 class303 = this;
        double width2 = 0.0;
        Label_0106: {
            if (b == null) {
                if (!this.isFinished()) {
                    width2 = 0.0;
                    break Label_0106;
                }
                class303 = this;
            }
            width2 = class303.width;
        }
        this.animationX = getAnimationState(animationX, width, Math.max(n, Math.abs(animationX2 - width2) * 20.0) * 0.3);
        Class302 class304 = this;
        Label_0168: {
            if (b == null) {
                if (this.posY == -1.0) {
                    this.posY = posY;
                    if (b == null) {
                        break Label_0168;
                    }
                }
                class304 = this;
            }
            class304.posY = getAnimationState(this.posY, posY, 200.0);
        }
        final ScaledResolution scaledResolution;
        final int n2 = (int)((scaledResolution = new ScaledResolution(Minecraft.func_71410_x())).func_78326_a() - this.width + this.animationX);
        int n3 = 0;
        Class69.drawRect(n2, n3, (int)(scaledResolution.func_78326_a() + this.animationX), (int)((n3 = (int)this.posY - 22) + this.height), Class23.reAlpha(this.color, 0.85f));
        boolean contains;
        final int n4 = (contains = (Class208.$SwitchMap$cn$Hanabi$gui$notifications$Notification$Type[this.t.ordinal()] != 0)) ? 1 : 0;
        if (b == null) {
            Label_0401: {
                switch (n4) {
                    case 1: {
                        Class139.INSTANCE.fontManager.icon25.func_78276_b(HanabiFonts.ICON_NOTIFY_ERROR, n2 + 3, n3 + 4, Class22.WHITE.c);
                        if (b != null) {
                            break Label_0401;
                        }
                        break;
                    }
                    case 2: {
                        Class139.INSTANCE.fontManager.icon25.func_78276_b(HanabiFonts.ICON_NOTIFY_INFO, n2 + 3, n3 + 4, Class22.WHITE.c);
                        if (b != null) {
                            break Label_0401;
                        }
                        break;
                    }
                    case 3: {
                        Class139.INSTANCE.fontManager.icon25.func_78276_b(HanabiFonts.ICON_NOTIFY_SUCCESS, n2 + 3, n3 + 4, Class22.WHITE.c);
                        if (b != null) {
                            break Label_0401;
                        }
                        break;
                    }
                    case 4: {
                        Class139.INSTANCE.fontManager.icon25.func_78276_b(HanabiFonts.ICON_NOTIFY_WARN, n2 + 3, n3 + 4, Class22.WHITE.c);
                        break;
                    }
                }
            }
            ++n3;
            final boolean contains2;
            contains = (contains2 = this.message.contains(" Enabled"));
        }
        if (b == null) {
            if (n4 != 0) {
                Class139.INSTANCE.fontManager.comfortaa15.drawString(this.message.replace(" Enabled", Class302.lllIlllII[0]), n2 + 19, (float)(n3 + this.height / 4.0), -1);
                Class139.INSTANCE.fontManager.comfortaa15.drawString(" Enabled", n2 + 20 + Class139.INSTANCE.fontManager.comfortaa15.func_78256_a(this.message.replace(" Enabled", Class302.lllIlllII[1])), (float)(n3 + this.height / 4.0), Class22.GREY.c);
                if (b == null) {
                    return;
                }
            }
            contains = this.message.contains(" Disabled");
        }
        if (b == null) {
            if (contains) {
                Class139.INSTANCE.fontManager.comfortaa15.drawString(this.message.replace(" Disabled", Class302.lllIlllII[2]), n2 + 19, (float)(n3 + this.height / 4.0), -1);
                Class139.INSTANCE.fontManager.comfortaa15.drawString(" Disabled", n2 + 20 + Class139.INSTANCE.fontManager.comfortaa15.func_78256_a(this.message.replace(" Disabled", Class302.lllIlllII[3])), (float)(n3 + this.height / 4.0), Class22.GREY.c);
                if (b == null) {
                    return;
                }
            }
            Class139.INSTANCE.fontManager.comfortaa15.drawString(this.message, n2 + 20, (float)(n3 + this.height / 4.0), -1);
        }
    }
    
    private boolean shouldDelete() {
        final int[] b = Class139.b();
        double finished;
        int n2;
        final int n = n2 = (int)(finished = (this.isFinished() ? 1 : 0));
        if (b == null) {
            if (n == 0) {
                return false;
            }
            finished = (n2 = dcmpl(this.animationX, this.width));
        }
        if (b == null) {
            if (n2 < 0) {
                return false;
            }
            finished = (true ? 1 : 0);
        }
        return finished != 0.0;
    }
    
    final boolean isFinished() {
        final int[] b = Class139.b();
        double delayComplete;
        boolean b3;
        final boolean b2 = b3 = ((delayComplete = (this.timer.isDelayComplete(this.stayTime) ? 1 : 0)) != 0.0);
        if (b == null) {
            if (!b2) {
                return false;
            }
            delayComplete = ((b3 = dcmpl(this.posY, this.lastY)) ? 1 : 0);
        }
        if (b == null) {
            if (b3) {
                return false;
            }
            delayComplete = (true ? 1 : 0);
        }
        return delayComplete != 0.0;
    }
    
    private double getHeight() {
        return this.height;
    }
    
    public static double getAnimationState(double n, final double n2, final double n3) {
        final int[] b = Class139.b();
        final float n4 = (float)(Class69.delta * n3);
        final int[] array = b;
        final double n5 = dcmpg(n, n2);
        final double n9;
        if (array == null) {
            if (n5 < 0) {
                double n7;
                final double n6 = n7 = n + n4;
                if (array == null) {
                    final double n8 = n6;
                    if (n6 < n2) {
                        n = n8;
                        if (array == null) {
                            return n;
                        }
                    }
                    n7 = n2;
                }
                n = n7;
                if (array == null) {
                    return n;
                }
            }
            n9 = n - n4;
            if (array != null) {
                return n9;
            }
            final double n10 = dcmpl(n9, n2);
        }
        if (n5 > 0) {
            n -= n4;
            if (array == null) {
                return n;
            }
        }
        n = n9;
        return n;
    }
    
    private static void drawImage(final ResourceLocation resourceLocation, final int n, final int n2, final int n3, final int n4) {
        new ScaledResolution(Minecraft.func_71410_x());
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDepthMask(false);
        OpenGlHelper.func_148821_a(770, 771, 1, 0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.func_71410_x().func_110434_K().func_110577_a(resourceLocation);
        Gui.func_146110_a(n, n2, 0.0f, 0.0f, n3, n4, (float)n3, (float)n4);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
    }
    
    static {
        lIlIlIlIIll();
        Class169.a(4208385685957005307L, 6154745797311274526L, MethodHandles.lookup().lookupClass()).a(168691924846130L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class302.lllIlllII[4]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class302.lllIlllII[5]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(21538944878928L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[4];
        int n2 = 0;
        String s;
        int n3 = (s = Class302.lllIlllII[6]).length();
        int n4 = 24;
        int n5 = -1;
    Label_0152:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class302.lllIlllII[8]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Class302.lllIlllII[7]).length();
                            n4 = 24;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                break;
                            }
                            break Label_0152;
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
        c = new String[4];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0xA2;
        if (Class302.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class302.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class302.lllIlllII[9]);
                    array[1] = SecretKeyFactory.getInstance(Class302.lllIlllII[10]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class302.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class302.lllIlllII[11], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class302.c[n3] = a(((Cipher)array[0]).doFinal(Class302.b[n3].getBytes(Class302.lllIlllII[12])));
        }
        return Class302.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class302.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIlIlIlIIll() {
        (lllIlllII = new String[16])[0] = "";
        Class302.lllIlllII[1] = "";
        Class302.lllIlllII[2] = "";
        Class302.lllIlllII[3] = "";
        Class302.lllIlllII[4] = "DES/CBC/PKCS5Padding";
        Class302.lllIlllII[5] = "DES";
        Class302.lllIlllII[6] = "\u009b£miMrfe_\\j-9\u009bh Ò*3yÉà\u009bö\u0018\u0014\u001b±AÄ\u0090TDg¹Iµ#×Ã7i6\u0097 ¨Ð'P";
        Class302.lllIlllII[7] = "{\u0014_\u009b¦2>î\u0002\u0087¶\u0000%@B]\u0086Dªü]\u0003ÊB LG~Y0(\u001fËG@ä¡¦\u009f\u0098&D»Õuo{ÍZ êÓ[n·Ì(";
        Class302.lllIlllII[8] = "ISO-8859-1";
        Class302.lllIlllII[9] = "DES/CBC/PKCS5Padding";
        Class302.lllIlllII[10] = "DES";
        Class302.lllIlllII[11] = "其实你根本不敢回击我的是吗人身攻击难道你没发现我一直在低头注视着你吗你是不是窝囊废啊觉得你要输给你登峰造极的爸爸我啊可以滚蛋了么NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2006\u2001\u200b\u200b";
        Class302.lllIlllII[12] = "ISO-8859-1";
        Class302.lllIlllII[13] = "其实你根本不敢回击我的是吗人身攻击难道你没发现我一直在低头注视着你吗你是不是窝囊废啊觉得你要输给你登峰造极的爸爸我啊可以滚蛋了么NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2006\u2001\u200b\u200b";
        Class302.lllIlllII[14] = " : ";
        Class302.lllIlllII[15] = " : ";
    }
    
    private static String lIlIlIlIIII(String s, final String s2) {
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
    
    private static String lIlIlIlIIIl(final String s, final String s2) {
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
    
    private static String lIlIlIlIIlI(final String s, final String s2) {
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
    
    private static boolean lIlIlIllllI(final int n) {
        return n >= 0;
    }
    
    private static boolean lIlIllIIIll(final int n) {
        return n < 0;
    }
    
    private static boolean lIlIllIIlII(final int n) {
        return n > 0;
    }
    
    private static int lIlIlIllIII$25399e8(final double n) {
        return dcmpl(n, -1.0);
    }
    
    private static int lIlIlIlllII(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIlIlIlllll(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIlIllIIIlI(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIlIllIIIIl(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
