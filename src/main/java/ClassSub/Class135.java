package ClassSub;

import java.nio.*;
import java.io.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class135 implements Class296
{
    private ArrayList sources;
    private Class296 picked;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIlIIllIIl;
    
    public Class135() {
        super();
        this.sources = new ArrayList();
    }
    
    public final void add(final Class296 class296) {
        this.sources.add(class296);
    }
    
    @Override
    public final ByteBuffer loadImage(final InputStream inputStream) throws IOException {
        return this.loadImage(inputStream, false, null);
    }
    
    @Override
    public final ByteBuffer loadImage(final InputStream inputStream, final boolean b, final int[] array) throws IOException {
        return this.loadImage(inputStream, b, false, array);
    }
    
    @Override
    public final ByteBuffer loadImage(InputStream inputStream2, final boolean b, final boolean b2, final int[] array) throws IOException {
        final Class161 class161 = new Class161();
        final int[] b3 = Class139.b();
        ByteBuffer loadImage = null;
        final int[] array2 = b3;
        final BufferedInputStream bufferedInputStream;
        (bufferedInputStream = new BufferedInputStream(inputStream, inputStream.available())).mark(inputStream.available());
        inputStream2 = (InputStream)0;
        while (inputStream2 < this.sources.size()) {
            bufferedInputStream.reset();
            try {
                final Class296 picked;
                loadImage = (picked = this.sources.get((int)inputStream2)).loadImage(bufferedInputStream, b, b2, array);
                this.picked = picked;
            }
            catch (Exception ex) {
                Class355.warn(String.valueOf(new StringBuilder().append(this.sources.get((int)inputStream2).getClass()).append(" failed to read the data")), ex);
                class161.exceptions.add(ex);
                ++inputStream2;
                if (array2 == null) {
                    continue;
                }
            }
            break;
        }
        if (this.picked == null) {
            throw class161;
        }
        return loadImage;
    }
    
    private void checkPicked() {
        if (this.picked == null) {
            throw new RuntimeException("Attempt to make use of uninitialised or invalid composite image data");
        }
    }
    
    @Override
    public final int getDepth() {
        this.checkPicked();
        return this.picked.getDepth();
    }
    
    @Override
    public final int getHeight() {
        this.checkPicked();
        return this.picked.getHeight();
    }
    
    @Override
    public final ByteBuffer getImageBufferData() {
        this.checkPicked();
        return this.picked.getImageBufferData();
    }
    
    @Override
    public final int getTexHeight() {
        this.checkPicked();
        return this.picked.getTexHeight();
    }
    
    @Override
    public final int getTexWidth() {
        this.checkPicked();
        return this.picked.getTexWidth();
    }
    
    @Override
    public final int getWidth() {
        this.checkPicked();
        return this.picked.getWidth();
    }
    
    @Override
    public final void configureEdging(final boolean b) {
        final int[] b2 = Class139.b();
        int i = 0;
        final int[] array = b2;
        while (i < this.sources.size()) {
            ((Class296)this.sources.get(i)).configureEdging(b);
            ++i;
            if (array != null) {
                break;
            }
        }
    }
    
    static {
        llllIllIllI();
        Class169.a(5033953630262749862L, 227700964295176323L, MethodHandles.lookup().lookupClass()).a(33948913169494L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class135.lIlIIllIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class135.lIlIIllIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(64088293274669L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class135.lIlIIllIIl[2]).length();
        int char1 = 56;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class135.lIlIIllIIl[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[2];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x5805;
        if (Class135.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class135.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class135.lIlIIllIIl[4]);
                    array[1] = SecretKeyFactory.getInstance(Class135.lIlIIllIIl[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class135.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class135.lIlIIllIIl[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class135.c[n3] = a(((Cipher)array[0]).doFinal(Class135.b[n3].getBytes(Class135.lIlIIllIIl[7])));
        }
        return Class135.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class135.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void llllIllIllI() {
        (lIlIIllIIl = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class135.lIlIIllIIl[1] = "DES";
        Class135.lIlIIllIIl[2] = "\u000ez¢M\u00037°Ré\u001bµ°\u0099\fé%\u0080:\u0013\u009eø\u0091<:I\u0019îm¡ç¿â6\u0005\u0013¡në\u0086\n\u0097÷H\u0001\u0015*ëý\u001cÌm³\u0005\u000b\u0011Rh#.ð\u0013ôóÊð\b\u0003\u0012h8²ì\u0001A=\u0010Î}Á\u0080\r\u008eìÝLø³¾M\u0091y\u0005\u0013Ó%ÿ³M\u000bGßZÏ\u008fî$\f6M|ÖM\u001cvSgqÆ\u000e_X\u0097eónò®\u0088Ö\u0014.g6oæ4ú¿oR]àJo}\u0003!Ó\u0013\u001a\u0092Õ3?\u0002øhßÑòI";
        Class135.lIlIIllIIl[3] = "ISO-8859-1";
        Class135.lIlIIllIIl[4] = "DES/CBC/PKCS5Padding";
        Class135.lIlIIllIIl[5] = "DES";
        Class135.lIlIIllIIl[6] = "你就这样拿出了你所谓的词汇自我安慰是吗孩子你噶哈不敢给我说话了呢看你有气无力的挣扎为什么草你妈是不是蜗牛草你妈有本事拿出你的词汇让我心服口服不要自欺欺人NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2005\u2005\u2004\u200c";
        Class135.lIlIIllIIl[7] = "ISO-8859-1";
        Class135.lIlIIllIIl[8] = "你就这样拿出了你所谓的词汇自我安慰是吗孩子你噶哈不敢给我说话了呢看你有气无力的挣扎为什么草你妈是不是蜗牛草你妈有本事拿出你的词汇让我心服口服不要自欺欺人NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2005\u2005\u2004\u200c";
        Class135.lIlIIllIIl[9] = " : ";
        Class135.lIlIIllIIl[10] = " : ";
    }
    
    private static String llllIllIlIl(String s, final String s2) {
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
    
    private static String llllIlIllll(final String s, final String s2) {
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
    
    private static String llllIlIIlll(final String s, final String s2) {
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
