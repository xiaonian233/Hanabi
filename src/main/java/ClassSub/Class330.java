package ClassSub;

import net.minecraft.client.*;
import org.jetbrains.annotations.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class330
{
    private static final String VERTEX_SHADER;
    private Minecraft mc;
    private int program;
    private long startTime;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIIlIIIl;
    
    private Class330(@NotNull final String s) {
        super();
        this.mc = Minecraft.func_71410_x();
        this.program = GL20.glCreateProgram();
        this.startTime = System.currentTimeMillis();
        final int glCreateShader = GL20.glCreateShader(35633);
        final int glCreateShader2 = GL20.glCreateShader(35632);
        GL20.glShaderSource(glCreateShader, (CharSequence)"#version 130\n\nvoid main() {\n    gl_TexCoord[0] = gl_MultiTexCoord0;\n    gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n}");
        GL20.glShaderSource(glCreateShader2, (CharSequence)s);
        GL20.glValidateProgram(this.program);
        GL20.glCompileShader(glCreateShader);
        GL20.glCompileShader(glCreateShader2);
        GL20.glAttachShader(this.program, glCreateShader);
        GL20.glAttachShader(this.program, glCreateShader2);
        GL20.glLinkProgram(this.program);
    }
    
    private void initShader(@NotNull final String s) {
        final int glCreateShader = GL20.glCreateShader(35633);
        final int glCreateShader2 = GL20.glCreateShader(35632);
        GL20.glShaderSource(glCreateShader, (CharSequence)"#version 130\n\nvoid main() {\n    gl_TexCoord[0] = gl_MultiTexCoord0;\n    gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n}");
        GL20.glShaderSource(glCreateShader2, (CharSequence)s);
        GL20.glValidateProgram(this.program);
        GL20.glCompileShader(glCreateShader);
        GL20.glCompileShader(glCreateShader2);
        GL20.glAttachShader(this.program, glCreateShader);
        GL20.glAttachShader(this.program, glCreateShader2);
        GL20.glLinkProgram(this.program);
    }
    
    private void renderFirst() {
        GL11.glClear(16640);
        GL20.glUseProgram(this.program);
    }
    
    private void renderSecond() {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        final ScaledResolution scaledResolution = new ScaledResolution(this.mc);
        GL11.glBegin(7);
        GL11.glTexCoord2d(0.0, 1.0);
        GL11.glVertex2d(0.0, 0.0);
        GL11.glTexCoord2d(0.0, 0.0);
        GL11.glVertex2d(0.0, (double)scaledResolution.func_78328_b());
        GL11.glTexCoord2d(1.0, 0.0);
        GL11.glVertex2d((double)scaledResolution.func_78326_a(), (double)scaledResolution.func_78328_b());
        GL11.glTexCoord2d(1.0, 1.0);
        GL11.glVertex2d((double)scaledResolution.func_78326_a(), 0.0);
        GL11.glEnd();
        GL20.glUseProgram(0);
    }
    
    private void bind() {
        GL20.glUseProgram(this.program);
    }
    
    private int getProgram() {
        return this.program;
    }
    
    @NotNull
    private Class330 uniform1i(@NotNull final String s, final int n) {
        GL20.glUniform1i(GL20.glGetUniformLocation(this.program, (CharSequence)s), n);
        return this;
    }
    
    @NotNull
    private Class330 uniform2i(@NotNull final String s, final int n, final int n2) {
        GL20.glUniform2i(GL20.glGetUniformLocation(this.program, (CharSequence)s), n, n2);
        return this;
    }
    
    @NotNull
    private Class330 uniform3i(@NotNull final String s, final int n, final int n2, final int n3) {
        GL20.glUniform3i(GL20.glGetUniformLocation(this.program, (CharSequence)s), n, n2, n3);
        return this;
    }
    
    @NotNull
    private Class330 uniform4i(@NotNull final String s, final int n, final int n2, final int n3, final int n4) {
        GL20.glUniform4i(GL20.glGetUniformLocation(this.program, (CharSequence)s), n, n2, n3, n4);
        return this;
    }
    
    @NotNull
    private Class330 uniform1f(@NotNull final String s, final float n) {
        GL20.glUniform1f(GL20.glGetUniformLocation(this.program, (CharSequence)s), n);
        return this;
    }
    
    @NotNull
    private Class330 uniform2f(@NotNull final String s, final float n, final float n2) {
        GL20.glUniform2f(GL20.glGetUniformLocation(this.program, (CharSequence)s), n, n2);
        return this;
    }
    
    @NotNull
    private Class330 uniform3f(@NotNull final String s, final float n, final float n2, final float n3) {
        GL20.glUniform3f(GL20.glGetUniformLocation(this.program, (CharSequence)s), n, n2, n3);
        return this;
    }
    
    @NotNull
    private Class330 uniform4f(@NotNull final String s, final float n, final float n2, final float n3, final float n4) {
        GL20.glUniform4f(GL20.glGetUniformLocation(this.program, (CharSequence)s), n, n2, n3, n4);
        return this;
    }
    
    @NotNull
    private Class330 uniform1b(@NotNull final String s, final boolean b) {
        final int[] b2 = Class139.b();
        final int glGetUniformLocation = GL20.glGetUniformLocation(this.program, (CharSequence)s);
        int n = b ? 1 : 0;
        if (b2 == null) {
            if (b) {
                n = 1;
            }
            else {
                n = 0;
            }
        }
        GL20.glUniform1i(glGetUniformLocation, n);
        return this;
    }
    
    private void addDefaultUniforms() {
        GL20.glUniform2f(GL20.glGetUniformLocation(this.program, (CharSequence)"resolution"), (float)this.mc.field_71443_c, (float)this.mc.field_71440_d);
        GL20.glUniform1f(GL20.glGetUniformLocation(this.program, (CharSequence)"time"), (System.currentTimeMillis() - this.startTime) / 1000.0f);
    }
    
    static {
        lIlllIIll();
        Class169.a(5902820314958712991L, 6444300791926974657L, MethodHandles.lookup().lookupClass()).a(102132972800534L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class330.lIIlIIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class330.lIIlIIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(114708513735123L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[4];
        int n2 = 0;
        String s;
        int n3 = (s = Class330.lIIlIIIl[2]).length();
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class330.lIIlIIIl[4]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class330.lIIlIIIl[3]).length();
                            n4 = 208;
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x365D;
        if (Class330.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class330.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class330.lIIlIIIl[5]);
                    array[1] = SecretKeyFactory.getInstance(Class330.lIIlIIIl[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class330.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class330.lIIlIIIl[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class330.c[n3] = a(((Cipher)array[0]).doFinal(Class330.b[n3].getBytes(Class330.lIIlIIIl[8])));
        }
        return Class330.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class330.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIlllIIll() {
        (lIIlIIIl = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class330.lIIlIIIl[1] = "DES";
        Class330.lIIlIIIl[2] = "R½>\u0082X\u0089Sé8 \u0087deçª\u00ad +¾\u0017u`äÄõÚ\u009cØ\u0006×\u0092;\u0014+ÈÖ\rã(q\u0016º}c\u0086?\u009b+ç";
        Class330.lIIlIIIl[3] = "e\u0083¿\u009a\u0089\u008f$é(\u0006\u001c$:6\u009a¢m\u009døC`©G\u008fÞðêê%ââXV´ì¥Móç\u0087=/òâM+\u0011×\u0007GkØ\u008cÝæª\u0087ÃÕÚlÌ:FÔO±Tn\u008fV\u009f¡ÃË?o\u0003`DJP\u0093\u000bM\u0081\u0094\u001cS«\u0016RÁ¬\u0083$\u0000ì\u001d[\u001a\u0005\u00adHÔî/ÅôÜ%\u0099»äQüx+¡]\u0080\u009dµi\u0007*ÒÁÃró\u0015¹Z/\r\u0090\u0091&¦R¦\u001eE»ïôüëíN\u008f\u0097nsÌ\u0094\u007fY>áF\u0090\u0082\u0087çÂÁL«\u0082ÎMðMÜ&V7d F\u008d¿å³%z«ü\u0001º\u0016@Öô\u0086\u0088\u0097f§àh`hNpßÐuÁ+~OÞßµÐ>&²¿2£¾®xw:\u0004Î(\\`ÒF'HNlÒiB[\u008b3ÙÿÑÜõÎþ\u0004ç\u0004ø\u0010\u001c\u0092 ¸\u001còÐLn¼®ÛÏ¤è\u009câ\u0006\u0011\rBZ\u0015\u000feG#\u009b£N²a_ÊÖ©l+ªÔ\u009b\u001bÁfÄkÃµ\u008fÊ\u00057\u008aÈÍx]³_\u001bR_\u000eE|m\u008bo±p\u001d¹Iå\u0010ü68QMå}\u0012\u0001\u0080\nðOó¤\u0010³2³\t\u0017'mÃ_t¡«¨}j¦ÂóQ#õvÞ\u009f¤ÿ¹ÍÕ\u0017³:f'\u000e<Ô##Ü¹É\u0080\u0095YkE\u007f\u0099ûD`\u0002\u008a¥Ü\u0011\u0091¯è\u000fc\u0082¢É\u000eÿï";
        Class330.lIIlIIIl[4] = "ISO-8859-1";
        Class330.lIIlIIIl[5] = "DES/CBC/PKCS5Padding";
        Class330.lIIlIIIl[6] = "DES";
        Class330.lIIlIIIl[7] = "别在那里恬不知耻了好吗那里是你的天堂你不是自以为是大手可以登峰造极唯我独尊的吗你以为你那些措辞可以让你爹爹我有所感触是吗你现在内心哭泣了是吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2005\u2004\u200e\u2002";
        Class330.lIIlIIIl[8] = "ISO-8859-1";
        Class330.lIIlIIIl[9] = "别在那里恬不知耻了好吗那里是你的天堂你不是自以为是大手可以登峰造极唯我独尊的吗你以为你那些措辞可以让你爹爹我有所感触是吗你现在内心哭泣了是吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2005\u2004\u200e\u2002";
        Class330.lIIlIIIl[10] = " : ";
        Class330.lIIlIIIl[11] = " : ";
    }
    
    private static String lIllIlIll(final String s, final String s2) {
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
    
    private static String lIllIllll(final String s, final String s2) {
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
    
    private static String lIllIlIlI(String s, final String s2) {
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
