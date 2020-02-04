package ClassSub;

import javax.swing.border.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

final class Class227 extends JDialog
{
    public boolean okPressed;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llIIllIlIl;
    
    public Class227(final JComponent component, final String s, final String s2) {
        super();
        this.okPressed = false;
        final int[] b = Class139.b();
        this.setDefaultCloseOperation(2);
        this.setLayout(new GridBagLayout());
        final int[] array = b;
        this.setModal(true);
        JComponent editor = component;
        Label_0066: {
            if (array == null) {
                if (!(component instanceof JSpinner)) {
                    break Label_0066;
                }
                editor = ((JSpinner)component).getEditor();
            }
            ((JSpinner.DefaultEditor)editor).getTextField().setColumns(4);
        }
        final JPanel panel;
        (panel = new JPanel()).setLayout(new GridBagLayout());
        this.getContentPane().add(panel, new GridBagConstraints(0, 0, 2, 1, 1.0, 0.0, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        final JTextArea textArea = new JTextArea(s2);
        panel.add(textArea, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, 10, 1, new Insets(5, 5, 5, 5), 0, 0));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        textArea.setEditable(false);
        final JPanel panel2 = new JPanel();
        this.getContentPane().add(panel2, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, 10, 0, new Insets(5, 5, 0, 5), 0, 0));
        panel2.add(new JLabel(String.valueOf(new StringBuilder().append(s).append(Class227.llIIllIlIl[0]))));
        panel2.add(component);
        final JPanel panel3 = new JPanel();
        this.getContentPane().add(panel3, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, 13, 0, new Insets(0, 0, 0, 0), 0, 0));
        final JButton button = new JButton("OK");
        panel3.add(button);
        button.addActionListener(new Class163(this));
        final JButton button2 = new JButton("Cancel");
        panel3.add(button2);
        button2.addActionListener(new Class186(this));
        this.setSize(new Dimension(320, 175));
    }
    
    static {
        lIIlIlIIlIIl();
        Class169.a(1667021271855535820L, 8398389661346539567L, MethodHandles.lookup().lookupClass()).a(65341502586853L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class227.llIIllIlIl[1]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class227.llIIllIlIl[2]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(140073795874302L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class227.llIIllIlIl[3]).length();
        int char1 = 16;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class227.llIIllIlIl[4]))).intern();
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x104C;
        if (Class227.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class227.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class227.llIIllIlIl[5]);
                    array[1] = SecretKeyFactory.getInstance(Class227.llIIllIlIl[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class227.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class227.llIIllIlIl[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class227.c[n3] = a(((Cipher)array[0]).doFinal(Class227.b[n3].getBytes(Class227.llIIllIlIl[8])));
        }
        return Class227.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class227.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIlIlIIlIIl() {
        (llIIllIlIl = new String[12])[0] = ":";
        Class227.llIIllIlIl[1] = "DES/CBC/PKCS5Padding";
        Class227.llIIllIlIl[2] = "DES";
        Class227.llIIllIlIl[3] = "eË\u00adl$ÏG\u0085å\u0097\u0002Yi(\u001eb\u0010<ïD$\u0003\fÔ\u001f¢R\u0007ñì|¸0";
        Class227.llIIllIlIl[4] = "ISO-8859-1";
        Class227.llIIllIlIl[5] = "DES/CBC/PKCS5Padding";
        Class227.llIIllIlIl[6] = "DES";
        Class227.llIIllIlIl[7] = "怎么怎么怎么你这么自以为是你还能怎么样你不是不是窝囊废啊我看你都没速度和我唠嗑你晓得啥你别虎了吗你为什么还要垂死挣扎呢NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL \u2002\u2005\u200d";
        Class227.llIIllIlIl[8] = "ISO-8859-1";
        Class227.llIIllIlIl[9] = "怎么怎么怎么你这么自以为是你还能怎么样你不是不是窝囊废啊我看你都没速度和我唠嗑你晓得啥你别虎了吗你为什么还要垂死挣扎呢NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL \u2002\u2005\u200d";
        Class227.llIIllIlIl[10] = " : ";
        Class227.llIIllIlIl[11] = " : ";
    }
    
    private static String lIIlIIllllII(String s, final String s2) {
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
    
    private static String lIIlIIlllIll(final String s, final String s2) {
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
    
    private static String lIIlIIlllIII(final String s, final String s2) {
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
