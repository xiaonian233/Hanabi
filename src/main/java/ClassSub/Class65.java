package ClassSub;

import java.awt.*;
import java.awt.datatransfer.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import org.lwjgl.input.*;
import java.io.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class65 extends GuiScreen
{
    private Class325 password;
    private final GuiScreen previousScreen;
    private Class256 thread;
    private GuiTextField username;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIIIIIIllIl;
    
    public Class65(final GuiScreen previousScreen) {
        super();
        this.previousScreen = previousScreen;
    }
    
    protected final void func_146284_a(final GuiButton guiButton) {
        final int[] b;
        final int[] array = b = Class139.b();
        try {
            Label_0095: {
                Label_0055: {
                    if (array == null) {
                        switch (guiButton.field_146127_k) {
                            case 1: {
                                this.field_146297_k.func_147108_a(this.previousScreen);
                                break;
                            }
                            case 0: {
                                break Label_0055;
                            }
                            case 2: {
                                break Label_0095;
                            }
                        }
                    }
                    if (b == null) {
                        return;
                    }
                }
                (this.thread = new Class256(new Class159(this.username.func_146179_b(), this.password.getText()))).start();
                if (b == null) {
                    return;
                }
            }
            String s2;
            final String s = s2 = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            final String s3 = Class65.lIIIIIIllIl[0];
            if (b == null) {
                if (!s.contains(s3)) {
                    return;
                }
                s2 = s;
                final String s4 = Class65.lIIIIIIllIl[1];
            }
            final String[] split = s2.split(s3);
            this.username.func_146180_a(split[0]);
            this.password.setText(split[1]);
        }
        catch (Throwable t) {}
    }
    
    public final void func_73863_a(final int n, final int n2, final float n3) {
        final int[] b = Class139.b();
        this.func_146276_q_();
        final int[] array = b;
        final ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k);
        Class69.drawRect(0.0f, 0.0f, scaledResolution.func_78326_a(), scaledResolution.func_78328_b(), 0);
        this.username.func_146194_f();
        this.password.drawTextBox();
        this.func_73732_a(this.field_146297_k.field_71466_p, "Alt Login", this.field_146294_l / 2, 20, -1);
        final FontRenderer field_71466_p = this.field_146297_k.field_71466_p;
        final Class256 thread = this.thread;
        String s = null;
        Label_0128: {
            if (array == null) {
                if (thread == null) {
                    s = String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append("Idle..."));
                    break Label_0128;
                }
                final Class256 thread2 = this.thread;
            }
            s = thread.status;
        }
        this.func_73732_a(field_71466_p, s, this.field_146294_l / 2, 29, -1);
        final boolean empty = this.username.func_146179_b().isEmpty();
        Class65 class65 = null;
        Label_0232: {
            if (array == null) {
                if (empty) {
                    this.func_73731_b(this.field_146297_k.field_71466_p, "Username / E-Mail", this.field_146294_l / 2 - 96, 66, -7829368);
                }
                class65 = this;
                if (array != null) {
                    break Label_0232;
                }
                this.password.getText().isEmpty();
            }
            if (empty) {
                this.func_73731_b(this.field_146297_k.field_71466_p, "Password", this.field_146294_l / 2 - 96, 106, -7829368);
            }
            class65 = this;
        }
        class65.func_73863_a(n, n2, n3);
    }
    
    public final void func_73866_w_() {
        final int n = this.field_146295_m / 4 + 24;
        this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, n + 72 + 12, "Login"));
        this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, n + 72 + 12 + 24, "Back"));
        this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 - 100, n + 72 + 12 + 48, "Import user:pass"));
        this.username = new GuiTextField(n, this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100, 60, 200, 20);
        this.password = new Class325(this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100);
        this.username.func_146195_b(true);
        Keyboard.enableRepeatEvents(true);
    }
    
    protected final void func_73869_a(final char c, final int n) {
        final int[] b = Class139.b();
        try {
            super.func_73869_a(c, n);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        char c2 = c;
        final char c3 = '\t';
        if (b == null) {
            Label_0106: {
                if (c == c3) {
                    final GuiTextField username = this.username;
                    final Class325 password;
                    Label_0084: {
                        if (b == null) {
                            if (!username.func_146206_l()) {
                                password = this.password;
                                if (b != null) {
                                    break Label_0084;
                                }
                                if (!password.isFocused) {
                                    this.username.func_146195_b(true);
                                    if (b == null) {
                                        break Label_0106;
                                    }
                                }
                            }
                            final GuiTextField username2 = this.username;
                        }
                        username.func_146195_b(this.password.isFocused);
                        final Class325 password2 = this.password;
                    }
                    final boolean func_146206_l = this.username.func_146206_l();
                    if (b == null && func_146206_l) {}
                    password.setFocused(func_146206_l);
                }
            }
            c2 = c;
            if (b != null) {
                return;
            }
        }
        if (c2 == c3) {
            this.func_146284_a(this.field_146292_n.get(0));
        }
        this.username.func_146201_a(c, n);
        this.password.textboxKeyTyped(c, n);
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
    
    public final void func_146281_b() {
        Keyboard.enableRepeatEvents(false);
    }
    
    public final void func_73876_c() {
        this.username.func_146178_a();
        final Class325 password = this.password;
        ++password.cursorCounter;
    }
    
    static {
        lIllllIIIlIl();
        Class169.a(2540851985348987931L, 925480910547673444L, MethodHandles.lookup().lookupClass()).a(58355770014330L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class65.lIIIIIIllIl[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class65.lIIIIIIllIl[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(60563751531969L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[7];
        int n2 = 0;
        String s;
        int n3 = (s = Class65.lIIIIIIllIl[4]).length();
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class65.lIIIIIIllIl[6]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Class65.lIIIIIIllIl[5]).length();
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
    
    private static Throwable a(final Throwable t) {
        return t;
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x1290;
        if (Class65.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class65.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class65.lIIIIIIllIl[7]);
                    array[1] = SecretKeyFactory.getInstance(Class65.lIIIIIIllIl[8]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class65.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class65.lIIIIIIllIl[9], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class65.c[n3] = a(((Cipher)array[0]).doFinal(Class65.b[n3].getBytes(Class65.lIIIIIIllIl[10])));
        }
        return Class65.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class65.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIllllIIIlIl() {
        (lIIIIIIllIl = new String[14])[0] = ":";
        Class65.lIIIIIIllIl[1] = ":";
        Class65.lIIIIIIllIl[2] = "DES/CBC/PKCS5Padding";
        Class65.lIIIIIIllIl[3] = "DES";
        Class65.lIIIIIIllIl[4] = "5í'UôTR\u009aý¯\u0088\b¨ùBsN¹ýS\u0091Y;è\u0018\u0083cZ5\u008a\u0001ÜÁ\u0015MÐuï\u008f\u0080[£»Gö`\u0090\u0001\"\u0010ó};Æù=ø\u0095ä¯D\f3pg\u0015\u0010ùÝ\u008d¨Î\u0085\u008aí\u0098H\u007fCä\u0087ä;\u0010\u0014\u001f\u0012ÙçÍ\u0015\u0096î\u008añL\u008e\u001a\u000b\u0082";
        Class65.lIIIIIIllIl[5] = "@uG\u0087g_\u0098ñ$º²±ùÄ! ·¨)X9±5·b%T£*ûÈ\u009f\u0018LÎ\u009d®ôE|(8Ï\u0087\u009f\u0084ý\u0099«àÉÔå\u0013¨ø\u0098k\u009a-ôß55d\u0094:=e-ÒêãÛ\u000b;\u0081=)9N";
        Class65.lIIIIIIllIl[6] = "ISO-8859-1";
        Class65.lIIIIIIllIl[7] = "DES/CBC/PKCS5Padding";
        Class65.lIIIIIIllIl[8] = "DES";
        Class65.lIIIIIIllIl[9] = "速度点你还要继续发扬你那厚颜无耻的精神吗你到底是怎样长大的你在说下我一巴掌呼你脸上你信吗怎么怎么怎么你这么自以为是你怎么三番五次的狗你爹爹我啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2005 \u2002\u2002";
        Class65.lIIIIIIllIl[10] = "ISO-8859-1";
        Class65.lIIIIIIllIl[11] = "速度点你还要继续发扬你那厚颜无耻的精神吗你到底是怎样长大的你在说下我一巴掌呼你脸上你信吗怎么怎么怎么你这么自以为是你怎么三番五次的狗你爹爹我啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2005 \u2002\u2002";
        Class65.lIIIIIIllIl[12] = " : ";
        Class65.lIIIIIIllIl[13] = " : ";
    }
    
    private static String lIllllIIIIlI(final String s, final String s2) {
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
    
    private static String lIllllIIIIll(final String s, final String s2) {
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
    
    private static String lIllllIIIlII(String s, final String s2) {
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
