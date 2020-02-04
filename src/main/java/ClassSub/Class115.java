package ClassSub;

import net.minecraft.util.*;
import java.awt.*;
import java.awt.datatransfer.*;
import net.minecraft.client.gui.*;
import org.lwjgl.input.*;
import java.io.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class115 extends GuiScreen
{
    private final Class323 manager;
    private Class325 password;
    private String status;
    private GuiTextField username;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llIIIllIlI;
    
    public Class115(final Class323 manager) {
        super();
        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append("Idle..."));
        this.manager = manager;
    }
    
    protected final void func_146284_a(GuiButton guiButton) {
        final int[] b = Class139.b();
        Label_0080: {
            switch (guiButton.field_146127_k) {
                case 0: {
                    new Class291(this, this.username.func_146179_b(), this.password.getText()).start();
                    if (b != null) {
                        break Label_0080;
                    }
                    break;
                }
                case 1: {
                    this.field_146297_k.func_147108_a((GuiScreen)this.manager);
                    if (b != null) {
                        break Label_0080;
                    }
                    break;
                }
                case 2: {
                    guiButton = null;
                    try {
                        guiButton = (GuiButton)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                    }
                    catch (Exception ex) {
                        if (b == null) {
                            break;
                        }
                    }
                    final GuiButton guiButton2 = guiButton;
                    final String s = Class115.llIIIllIlI[0];
                    if (b == null) {
                        if (!((String)guiButton2).contains(s)) {
                            break;
                        }
                        final String s2 = Class115.llIIIllIlI[1];
                    }
                    final String[] split = ((String)guiButton2).split(s);
                    this.username.func_146180_a(split[0]);
                    this.password.setText(split[1]);
                    break;
                }
            }
        }
    }
    
    public final void func_73863_a(final int n, final int n2, final float n3) {
        this.func_146276_q_();
        final ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k);
        Class69.drawRect(0.0f, 0.0f, scaledResolution.func_78326_a(), scaledResolution.func_78328_b(), 0);
        this.username.func_146194_f();
        final int[] b = Class139.b();
        this.password.drawTextBox();
        this.func_73732_a(this.field_146289_q, "Add Alt", this.field_146294_l / 2, 20, -1);
        final int[] array = b;
        final boolean empty = this.username.func_146179_b().isEmpty();
        Class115 class115 = null;
        Label_0187: {
            if (array == null) {
                if (empty) {
                    this.func_73731_b(this.field_146297_k.field_71466_p, "Username / E-Mail", this.field_146294_l / 2 - 96, 66, -7829368);
                }
                class115 = this;
                if (array != null) {
                    break Label_0187;
                }
                this.password.getText().isEmpty();
            }
            if (empty) {
                this.func_73731_b(this.field_146297_k.field_71466_p, "Password", this.field_146294_l / 2 - 96, 106, -7829368);
            }
            this.func_73732_a(this.field_146289_q, this.status, this.field_146294_l / 2, 30, -1);
            class115 = this;
        }
        class115.func_73863_a(n, n2, n3);
    }
    
    public final void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_146292_n.clear();
        this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 92 + 12, "Login"));
        this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 116 + 12, "Back"));
        this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 116 + 36, "Import user:pass"));
        this.username = new GuiTextField(99999, this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100, 60, 200, 20);
        this.password = new Class325(this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100);
    }
    
    protected final void func_73869_a(final char c, final int n) {
        final int[] b = Class139.b();
        this.username.func_146201_a(c, n);
        this.password.textboxKeyTyped(c, n);
        final int[] array = b;
        char isFocused = c;
        final char c2 = '\t';
        if (array == null) {
            Label_0115: {
                Label_0114: {
                    if (c == c2) {
                        final GuiTextField username = this.username;
                        if (array == null) {
                            if (!username.func_146206_l()) {
                                final boolean b2 = (isFocused = (char)(this.password.isFocused ? 1 : 0)) != '\0';
                                if (array != null) {
                                    break Label_0115;
                                }
                                if (!b2) {
                                    break Label_0114;
                                }
                            }
                            final GuiTextField username2 = this.username;
                        }
                        final boolean func_146206_l = this.username.func_146206_l();
                        if (array == null && func_146206_l) {}
                        username.func_146195_b(func_146206_l);
                        final Class325 password = this.password;
                        final boolean isFocused2 = this.password.isFocused;
                        if (array == null && isFocused2) {}
                        password.setFocused(isFocused2);
                    }
                }
                isFocused = c;
            }
        }
        if (isFocused == c2) {
            this.func_146284_a(this.field_146292_n.get(0));
        }
    }
    
    protected final void func_73864_a(final int n, final int n2, final int n3) {
        try {
            super.func_73864_a(n, n2, n3);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        this.username.func_146192_a(n, n2, n3);
        this.password.mouseClicked(n, n2, n3);
    }
    
    static void access$0(final Class115 class115, final String status) {
        class115.status = status;
    }
    
    static {
        lIIIllllllII();
        Class169.a(7878548027422167222L, 3919844682096641740L, MethodHandles.lookup().lookupClass()).a(188956376480076L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class115.llIIIllIlI[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class115.llIIIllIlI[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(30705407450605L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[7];
        int n2 = 0;
        String s;
        int n3 = (s = Class115.llIIIllIlI[4]).length();
        int n4 = 16;
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class115.llIIIllIlI[6]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Class115.llIIIllIlI[5]).length();
                            n4 = 48;
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
        c = new String[7];
    }
    
    private static Exception a(final Exception ex) {
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x738E;
        if (Class115.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class115.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class115.llIIIllIlI[7]);
                    array[1] = SecretKeyFactory.getInstance(Class115.llIIIllIlI[8]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class115.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class115.llIIIllIlI[9], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class115.c[n3] = a(((Cipher)array[0]).doFinal(Class115.b[n3].getBytes(Class115.llIIIllIlI[10])));
        }
        return Class115.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class115.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIIllllllII() {
        (llIIIllIlI = new String[14])[0] = ":";
        Class115.llIIIllIlI[1] = ":";
        Class115.llIIIllIlI[2] = "DES/CBC/PKCS5Padding";
        Class115.llIIIllIlI[3] = "DES";
        Class115.llIIIllIlI[4] = "ò7\u008b î+\u0086± \u00adN\u0091\u0089×'ó\u0010\u0019gsÒÔD\u0014¥ÿãv\u00839&ÿ9\u0010\rÙÛ8\u009a6¶lüP%h\u001b×ã\u0097\u0018Á\u0090²Öó;!\u008b`¯ÝÊ\u0085[o Ä&\u0098\u0012\u009crqæ(*\u0081\u0083.\u000b\u001ds'Z1*b\u008eÓ¹¼\u008f5ÂÝ\u0013Ïðî\u009b4\u009f\u001dÆ\u0098h\u0017\u0095¢ËÃÎ$A\u0017";
        Class115.llIIIllIlI[5] = "W&\"ú\u0003ÔÚcýÇÇ\u0089\u001dcú\u001f>\u008e\u008fÓùxiéaZìòÈÌ\u0013ÀÉ5\u0016>\u009b\u0095\u0011ªÓã;gÊò/Á\u0010 æ\u0014´u©®S\u009cÈûÉ(\u0010[Q";
        Class115.llIIIllIlI[6] = "ISO-8859-1";
        Class115.llIIIllIlI[7] = "DES/CBC/PKCS5Padding";
        Class115.llIIIllIlI[8] = "DES";
        Class115.llIIIllIlI[9] = "你怎么还纹丝不动啊大哥我随意践踏你的自尊和人格你还能用语言反击我么你根本没有任何的语言和任何的实力跟我抗衡呵呵我不想说什么对于你这样的亡命匪徒我不想再和你继续磨磨唧唧盖好你的棺材门NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u200b\u200f ";
        Class115.llIIIllIlI[10] = "ISO-8859-1";
        Class115.llIIIllIlI[11] = "你怎么还纹丝不动啊大哥我随意践踏你的自尊和人格你还能用语言反击我么你根本没有任何的语言和任何的实力跟我抗衡呵呵我不想说什么对于你这样的亡命匪徒我不想再和你继续磨磨唧唧盖好你的棺材门NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u200b\u200f ";
        Class115.llIIIllIlI[12] = " : ";
        Class115.llIIIllIlI[13] = " : ";
    }
    
    private static String lIIIlllllIIl(String s, final String s2) {
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
    
    private static String lIIIlllllIll(final String s, final String s2) {
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
    
    private static String lIIIlllllIlI(final String s, final String s2) {
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
}
