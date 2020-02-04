package ClassSub;

import net.minecraft.client.*;
import net.minecraft.util.*;
import java.net.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;
import com.mojang.authlib.exceptions.*;
import cn.Hanabi.injection.interfaces.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class256 extends Thread
{
    private Class159 alt;
    String status;
    private Minecraft mc;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llIIllIllIl;
    
    public Class256(final Class159 alt) {
        super("Alt Login Thread");
        Minecraft.func_71410_x();
        this.alt = alt;
        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append("Waiting..."));
    }
    
    private static Session createSession(final String username, final String password) {
        final YggdrasilUserAuthentication yggdrasilUserAuthentication;
        (yggdrasilUserAuthentication = (YggdrasilUserAuthentication)new YggdrasilAuthenticationService(Proxy.NO_PROXY, Class256.llIIllIllIl[0]).createUserAuthentication(Agent.MINECRAFT)).setUsername(username);
        yggdrasilUserAuthentication.setPassword(password);
        final YggdrasilUserAuthentication yggdrasilUserAuthentication2 = yggdrasilUserAuthentication;
        try {
            yggdrasilUserAuthentication2.logIn();
            return new Session(yggdrasilUserAuthentication.getSelectedProfile().getName(), yggdrasilUserAuthentication.getSelectedProfile().getId().toString(), yggdrasilUserAuthentication.getAuthenticatedToken(), "mojang");
        }
        catch (AuthenticationException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private String getStatus() {
        return this.status;
    }
    
    @Override
    public final void run() {
        final int[] b = Class139.b();
        Object o = this;
        if (b == null) {
            if (this.alt.password.equals(Class256.llIIllIllIl[1])) {
                ((IMinecraft)Minecraft.func_71410_x()).setSession(new Session(this.alt.username, Class256.llIIllIllIl[2], Class256.llIIllIllIl[3], "mojang"));
                this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GREEN).append("Logged in. (").append(this.alt.username).append(" - offline name)"));
                return;
            }
            this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.AQUA).append("Logging in..."));
            o = null;
        }
        final Session session = createSession((String)o, this.alt.username);
        if (b != null) {
            return;
        }
        if (session == null) {
            this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Login failed!"));
            if (b == null) {
                return;
            }
        }
        Class312.lastAlt = new Class159(this.alt.username, this.alt.password);
        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GREEN).append("Logged in. (").append(session.func_111285_a()).append(Class256.llIIllIllIl[4]));
        this.alt.mask = session.func_111285_a();
        ((IMinecraft)Minecraft.func_71410_x()).setSession(session);
        final Class139 instance = Class139.INSTANCE;
        try {
            Class96.getFile(Class316.class).saveFile();
        }
        catch (Exception ex) {}
    }
    
    private void setStatus(final String status) {
        this.status = status;
    }
    
    static {
        lIIIlllIIlIII();
        Class169.a(7950721955040680565L, 2371382460110836110L, MethodHandles.lookup().lookupClass()).a(120141035919704L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class256.llIIllIllIl[5]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class256.llIIllIllIl[6]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(4476465111561L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[9];
        int n2 = 0;
        String s;
        int n3 = (s = Class256.llIIllIllIl[7]).length();
        int n4 = 32;
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class256.llIIllIllIl[9]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Class256.llIIllIllIl[8]).length();
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
        c = new String[9];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x41A8;
        if (Class256.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class256.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class256.llIIllIllIl[10]);
                    array[1] = SecretKeyFactory.getInstance(Class256.llIIllIllIl[11]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class256.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class256.llIIllIllIl[12], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class256.c[n3] = a(((Cipher)array[0]).doFinal(Class256.b[n3].getBytes(Class256.llIIllIllIl[13])));
        }
        return Class256.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class256.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIIlllIIlIII() {
        (llIIllIllIl = new String[17])[0] = "";
        Class256.llIIllIllIl[1] = "";
        Class256.llIIllIllIl[2] = "";
        Class256.llIIllIllIl[3] = "";
        Class256.llIIllIllIl[4] = ")";
        Class256.llIIllIllIl[5] = "DES/CBC/PKCS5Padding";
        Class256.llIIllIllIl[6] = "DES";
        Class256.llIIllIllIl[7] = "Õ\n³~l\u0006gçNþ_\u0082ÿä\u0096´êòÁ-/ô\u0098*{Y\u0017\u0097\u009a)\u009d¸(\u0084x\u0080\u0081,\u001fïãè½-Xàß\u0099ö¸Òª·\u001bGè§X\u0081}P\u0010k·\u001fò¾@!É´\u0006\u0089 ]\u0016\u009b^4\f=\u0095\u001b1ºWÐ×ôât{\u0013\u0092Ì«NÞ«\u001fC\u001cw\t;N\u0010£@Zæ²ê¢\u008a\u00ad\u0018Qö£\u0098#\u008a N¥bP\u0088M³¾7L\u008cR[yÎA÷CY«\u0081÷u¸^îj³\u008b÷\u0014¸ ñ_U\u0088¥RfA¸êo;¼\u008e\u000b¶\u0007Dño\u007fùé\u0084ÂÚ\u0087nd\r¡÷ Tµ¹g.y<¬¡Ð\u000bEe®\\\u0016Híµ@¥Ý\u001b!<\u0092Òx\u0003®\u0089\u001e";
        Class256.llIIllIllIl[8] = "Õ\u0001V\u0088\f\u0017W;%²iÇayk/\u0010\u0082\u0093¶P£(\u0092d°q/zi\rª|\u009a3\u00ad\u008c´\u0005\u0098\u0010t!R6\u00945\u008b\u001c\u001aæ\u008fë¶5-ø";
        Class256.llIIllIllIl[9] = "ISO-8859-1";
        Class256.llIIllIllIl[10] = "DES/CBC/PKCS5Padding";
        Class256.llIIllIllIl[11] = "DES";
        Class256.llIIllIllIl[12] = "是畏惧我了吗可是你一直被大家蒙在谷里不是吗你开始向我摇尾乞怜让我高抬贵手了废物二卡子你是不是无可奈何了啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2005\u2004\u2004\u200f";
        Class256.llIIllIllIl[13] = "ISO-8859-1";
        Class256.llIIllIllIl[14] = "是畏惧我了吗可是你一直被大家蒙在谷里不是吗你开始向我摇尾乞怜让我高抬贵手了废物二卡子你是不是无可奈何了啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2005\u2004\u2004\u200f";
        Class256.llIIllIllIl[15] = " : ";
        Class256.llIIllIllIl[16] = " : ";
    }
    
    private static String lIIIlllIIIlIl(final String s, final String s2) {
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
    
    private static String lIIIlllIIIlll(final String s, final String s2) {
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
    
    private static String lIIIlllIIIllI(String s, final String s2) {
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
