package ClassSub;

import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import java.io.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class75 extends GuiScreen
{
    private final Class323 manager;
    private GuiTextField nameField;
    private Class325 pwField;
    private String status;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lllIlllIlI;
    
    public Class75(final Class323 manager) {
        super();
        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append("Waiting..."));
        this.manager = manager;
    }
    
    public final void func_146284_a(final GuiButton guiButton) {
        Label_0055: {
            final int[] b;
            if ((b = Class139.b()) == null) {
                switch (guiButton.field_146127_k) {
                    case 1: {
                        this.field_146297_k.func_147108_a((GuiScreen)this.manager);
                        break;
                    }
                    case 0: {
                        break Label_0055;
                    }
                }
            }
            if (b == null) {
                return;
            }
        }
        this.manager.selectedAlt.mask = this.nameField.func_146179_b();
        this.manager.selectedAlt.password = this.pwField.getText();
        this.status = "Edited!";
    }
    
    public final void func_73863_a(final int n, final int n2, final float n3) {
        this.func_146276_q_();
        final int[] b = Class139.b();
        final ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k);
        final int[] array = b;
        Class69.drawRect(0.0f, 0.0f, scaledResolution.func_78326_a(), scaledResolution.func_78328_b(), 0);
        this.func_73732_a(this.field_146289_q, "Edit Alt", this.field_146294_l / 2, 10, -1);
        this.func_73732_a(this.field_146289_q, this.status, this.field_146294_l / 2, 20, -1);
        this.nameField.func_146194_f();
        this.pwField.drawTextBox();
        final boolean empty = this.nameField.func_146179_b().isEmpty();
        Class75 class75 = null;
        Label_0187: {
            if (array == null) {
                if (empty) {
                    this.func_73731_b(this.field_146297_k.field_71466_p, "New name", this.field_146294_l / 2 - 96, 66, -7829368);
                }
                class75 = this;
                if (array != null) {
                    break Label_0187;
                }
                this.pwField.getText().isEmpty();
            }
            if (empty) {
                this.func_73731_b(this.field_146297_k.field_71466_p, "New password", this.field_146294_l / 2 - 96, 106, -7829368);
            }
            class75 = this;
        }
        class75.func_73863_a(n, n2, n3);
    }
    
    public final void func_73866_w_() {
        this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 92 + 12, "Edit"));
        this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 116 + 12, "Cancel"));
        this.nameField = new GuiTextField(99997, this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100, 60, 200, 20);
        this.pwField = new Class325(this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100);
    }
    
    protected final void func_73869_a(final char c, final int n) {
        final int[] b = Class139.b();
        this.nameField.func_146201_a(c, n);
        this.pwField.textboxKeyTyped(c, n);
        final int[] array = b;
        char isFocused = c;
        final char c2 = '\t';
        if (array == null) {
            Label_0115: {
                Label_0114: {
                    if (c == c2) {
                        final GuiTextField nameField = this.nameField;
                        if (array == null) {
                            if (!nameField.func_146206_l()) {
                                final boolean b2 = (isFocused = (char)(this.pwField.isFocused ? 1 : 0)) != '\0';
                                if (array != null) {
                                    break Label_0115;
                                }
                                if (!b2) {
                                    break Label_0114;
                                }
                            }
                            final GuiTextField nameField2 = this.nameField;
                        }
                        final boolean func_146206_l = this.nameField.func_146206_l();
                        if (array == null && func_146206_l) {}
                        nameField.func_146195_b(func_146206_l);
                        final Class325 pwField = this.pwField;
                        final boolean isFocused2 = this.pwField.isFocused;
                        if (array == null && isFocused2) {}
                        pwField.setFocused(isFocused2);
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
        this.nameField.func_146192_a(n, n2, n3);
        this.pwField.mouseClicked(n, n2, n3);
    }
    
    static {
        lIlIlIlIIlIl();
        Class169.a(8477914097040263816L, 8011667151354666302L, MethodHandles.lookup().lookupClass()).a(202210427526698L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class75.lllIlllIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class75.lllIlllIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(117786988977679L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[7];
        int n2 = 0;
        String s;
        int n3 = (s = Class75.lllIlllIlI[2]).length();
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class75.lllIlllIlI[4]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class75.lllIlllIlI[3]).length();
                            n4 = 32;
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
        c = new String[7];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x411F;
        if (Class75.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class75.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class75.lllIlllIlI[5]);
                    array[1] = SecretKeyFactory.getInstance(Class75.lllIlllIlI[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class75.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class75.lllIlllIlI[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class75.c[n3] = a(((Cipher)array[0]).doFinal(Class75.b[n3].getBytes(Class75.lllIlllIlI[8])));
        }
        return Class75.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class75.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIlIlIlIIlIl() {
        (lllIlllIlI = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class75.lllIlllIlI[1] = "DES";
        Class75.lllIlllIlI[2] = "Æ»å \u001b¢\u008ej¥h¥\u001fàS\u0007Ô I\u0087ü¬0}¶Q\u0093ÌçB~â\u0011v\u0098ê\u0011Ç[8#\u001brÍ.35â\u0015  ò*´G¯LG\u008c7öø0^ÆÜ·Ý^l\u0015dHÏ±\u0080\u0094Bý¼\u0000\u0016\u0080\u0010\u0017&ï\u0002_sÆ\u0007°\u000e·®\u0084!x\u0011\u0010aá³\u0013\u00948\u0099\u0002=\u008cfô\u0014\u0096)\u008a";
        Class75.lllIlllIlI[3] = "o÷Û<©ÚÊ\u0006N5_¥@$æ-ºÄ\u0019NóOµ\u0017\u0014©h\u0082\u008f\u0007-\u0099 ¢üÂ\u009eÌTI\u0086â\u0010.çÊý^ñÀùüÂ\\\u008e+\u0015¯Vú»\u0013ç'ò";
        Class75.lllIlllIlI[4] = "ISO-8859-1";
        Class75.lllIlllIlI[5] = "DES/CBC/PKCS5Padding";
        Class75.lllIlllIlI[6] = "DES";
        Class75.lllIlllIlI[7] = "我给你证据你要吗因为我最后一点瞧的起你的地方也荡然失存了可是你的尊严也所剩无几了是吗你认为你的语言华丽为什么没能激怒叫你他麻痹的去老老实实的当窝囊废啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u200c\u2002\u2004";
        Class75.lllIlllIlI[8] = "ISO-8859-1";
        Class75.lllIlllIlI[9] = "我给你证据你要吗因为我最后一点瞧的起你的地方也荡然失存了可是你的尊严也所剩无几了是吗你认为你的语言华丽为什么没能激怒叫你他麻痹的去老老实实的当窝囊废啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u200c\u2002\u2004";
        Class75.lllIlllIlI[10] = " : ";
        Class75.lllIlllIlI[11] = " : ";
    }
    
    private static String lIlIlIlIIIlI(final String s, final String s2) {
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
    
    private static String lIlIlIIllllI(String s, final String s2) {
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
    
    private static String lIlIlIIlllll(final String s, final String s2) {
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
}
