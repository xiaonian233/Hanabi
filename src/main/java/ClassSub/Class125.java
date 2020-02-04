package ClassSub;

import java.net.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.World.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class125 extends JFrame
{
    private static final long serialVersionUID = 1L;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llllIlIIlI;
    
    public Class125() {
        super();
    }
    
    public final void init() {
        final int[] b = Class139.b();
        try {
            final Socket socket;
            final OutputStream outputStream = (socket = new Socket("127.0.0.1", 34234)).getOutputStream();
            socket.getOutputStream().write("GET".getBytes("UTF-8"));
            socket.shutdownOutput();
            final InputStream inputStream = socket.getInputStream();
            final byte[] array = new byte[1024];
            final StringBuilder sb = new StringBuilder();
            int read;
            while ((read = inputStream.read(array)) != -1) {
                sb.append(new String(array, 0, read, "UTF-8"));
                if (b != null) {
                    return;
                }
                if (b != null) {
                    break;
                }
            }
            Class258.username = (Mod.username = String.valueOf(sb).split("\\|")[0]);
            Class258.password = (Mod.password = String.valueOf(sb).split("\\|")[1].substring(0, 32));
            IRC.client = new Class206();
            Class206.start(Class258.username, Class258.password);
            new Class139();
            this.setVisible(false);
            inputStream.close();
            outputStream.close();
            socket.close();
        }
        catch (Exception ex) {
            this.setDefaultCloseOperation(2);
            this.setAlwaysOnTop(true);
            this.setTitle("Hanabi 2.2 IRCFix");
            this.setBounds(0, 0, 275, 175);
            this.setLocationRelativeTo(null);
            final Container contentPane;
            (contentPane = this.getContentPane()).setLayout(null);
            final JLabel label;
            (label = new JLabel("用户名：")).setBounds(30, 10, 200, 35);
            final JTextField textField;
            (textField = new JTextField()).setBounds(100, 10, 150, 35);
            final JLabel label2;
            (label2 = new JLabel("密码：")).setBounds(30, 50, 200, 35);
            final JPasswordField passwordField;
            (passwordField = new JPasswordField()).setBounds(100, 50, 150, 35);
            contentPane.add(label);
            contentPane.add(textField);
            contentPane.add(label2);
            contentPane.add(passwordField);
            final JButton button;
            (button = new JButton("确定")).addActionListener(new Class334(this, textField, passwordField));
            button.setBounds(10, 100, 250, 30);
            contentPane.add(button);
            this.setResizable(false);
            this.setVisible(true);
            this.addWindowListener(new Class342());
        }
    }
    
    static {
        lIlIlllIlIIl();
        Class169.a(3181635511226670315L, 3472994514897515791L, MethodHandles.lookup().lookupClass()).a(76829501517076L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class125.llllIlIIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class125.llllIlIIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(12363306924259L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[10];
        int n2 = 0;
        String s;
        int n3 = (s = Class125.llllIlIIlI[2]).length();
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class125.llllIlIIlI[4]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class125.llllIlIIlI[3]).length();
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
        c = new String[10];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x3775;
        if (Class125.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class125.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class125.llllIlIIlI[5]);
                    array[1] = SecretKeyFactory.getInstance(Class125.llllIlIIlI[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class125.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class125.llllIlIIlI[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class125.c[n3] = a(((Cipher)array[0]).doFinal(Class125.b[n3].getBytes(Class125.llllIlIIlI[8])));
        }
        return Class125.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class125.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIlIlllIlIIl() {
        (llllIlIIlI = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class125.llllIlIIlI[1] = "DES";
        Class125.llllIlIIlI[2] = "n\u001a\u0095ñ\u009aËÔ{c\u0013þ\" §½\u0012\u0010Ä\u0091zy×·x.\u0087²hTHa%x(®\u0089©\u00ad\u009c½ûÒú\u000b!þScá\u009d÷[\u008a×å3à\u0012od`Ñþ\u0080¹r:\u0019Ø¦\u0094ÉÉ:\u0010ÃT\u008f\u0095vÒ¨\u008b\u0007øÝ^\u0096Û¤×\u0018¿Yx\u0016Ý\u0099º\u009b¾ª¶±£\u001bVøê\u0011\u001e®^v5S\u0010í\u0082ý\u0015Ø|â-ÛüS,o\u0001\u008d\u0089\u0018\u00075Lå¸´ýF@ñîJ\u0007ô(Âú\u0094e*\u009eÐc®\u0010\u001b=\u009dî\u0013¤¬\u000b¨å9«¡\nù¤";
        Class125.llllIlIIlI[3] = "\u001d\u001dýR½Ô\u0099hL\u009da\u00ad\u009eÐß\u000eÙ\u0098ÛMÊTØø;\".Òôê4ï\u0010\u009cåõÜÌÛ±¤×´^ªcñ©ð";
        Class125.llllIlIIlI[4] = "ISO-8859-1";
        Class125.llllIlIIlI[5] = "DES/CBC/PKCS5Padding";
        Class125.llllIlIIlI[6] = "DES";
        Class125.llllIlIIlI[7] = "呵呵我不想说什么对于你这样的亡命匪徒我不想再和你继续磨磨唧唧我真的不知道要能拿什么词语来跟你说本人不是大手没有词汇好么你是不是以为你有千千万万的言语就可以击败你登峰造极的爹我啊怎么出现在还和丧家之犬一样的对我穷追猛打企图超越你爹爹的存在NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2004\u2003\u200d ";
        Class125.llllIlIIlI[8] = "ISO-8859-1";
        Class125.llllIlIIlI[9] = "呵呵我不想说什么对于你这样的亡命匪徒我不想再和你继续磨磨唧唧我真的不知道要能拿什么词语来跟你说本人不是大手没有词汇好么你是不是以为你有千千万万的言语就可以击败你登峰造极的爹我啊怎么出现在还和丧家之犬一样的对我穷追猛打企图超越你爹爹的存在NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2004\u2003\u200d ";
        Class125.llllIlIIlI[10] = " : ";
        Class125.llllIlIIlI[11] = " : ";
    }
    
    private static String lIlIlllIIlII(final String s, final String s2) {
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
    
    private static String lIlIlllIIlIl(String s, final String s2) {
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
    
    private static String lIlIlllIIIll(final String s, final String s2) {
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
    
    private static boolean lIllllllllII$255f299(final int n) {
        return n != -1;
    }
}
