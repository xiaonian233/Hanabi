package ClassSub;

import cn.Hanabi.command.*;
import cn.Hanabi.modules.Player.*;
import java.io.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import net.minecraft.client.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class133 extends Command
{
    private static String fileDir;
    private static final long c;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] llIlllllII;
    
    public Class133() {
        super(invokedynamic(y:(IJ)Ljava/lang/String;, 28681, 0x57753C572BDD06DEL ^ (Class133.c ^ 0x214313146787L)), new String[0]);
    }
    
    private static void saveText() {
        final long n = Class133.c ^ 0x20D792D53C28L;
        final int[] array = invokedynamic(U:(JJ)[I, -2382329840650659122L, n);
        final File file = new File(String.valueOf(new StringBuilder().append(Class133.fileDir).append(invokedynamic(y:(IJ)Ljava/lang/String;, 27893, 0x35B2119C296CC18EL ^ n))));
        final int[] array2 = array;
        final File file2 = file;
        try {
            Label_0081: {
                boolean exists;
                try {
                    exists = file2.exists();
                    if (array2 != null) {
                        break Label_0081;
                    }
                    if (!exists) {
                        break Label_0081;
                    }
                    break Label_0081;
                }
                catch (Exception ex) {
                    throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex, -2382383732012593430L, n);
                }
                try {
                    if (!exists) {
                        file.createNewFile();
                    }
                }
                catch (Exception ex2) {
                    throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex2, -2382383732012593430L, n);
                }
            }
            final PrintWriter printWriter;
            (printWriter = new PrintWriter(file)).print(Spammer.text);
            printWriter.close();
        }
        catch (Exception ex3) {
            ex3.printStackTrace();
        }
    }
    
    public static void loadText() throws IOException {
        final long n = Class133.c ^ 0xEB385180A74L;
        final int[] array = invokedynamic(U:(JJ)[I, -1680847864383050606L, n);
        final File file = new File(String.valueOf(new StringBuilder().append(Class133.fileDir).append(invokedynamic(y:(IJ)Ljava/lang/String;, 2301, 0x6D28E4ACE5B793DFL ^ n))));
        final int[] array2 = array;
        final File file2 = file;
        Label_0103: {
            Label_0081: {
                boolean exists;
                try {
                    exists = file2.exists();
                    if (array2 != null) {
                        break Label_0081;
                    }
                    if (!exists) {
                        break Label_0081;
                    }
                    break Label_0103;
                }
                catch (Exception ex) {
                    throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex, -1680901515780982602L, n);
                }
                try {
                    if (exists) {
                        break Label_0103;
                    }
                    file.createNewFile();
                }
                catch (Exception ex2) {
                    throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex2, -1680901515780982602L, n);
                }
            }
            if (array2 == null) {
                return;
            }
        }
        String line;
        while ((line = new BufferedReader(new FileReader(file)).readLine()) != null) {
            final String s = line;
            try {
                Spammer.text = String.valueOf(s);
                continue;
            }
            catch (Exception ex3) {
                if (array2 == null) {
                    continue;
                }
            }
            break;
        }
    }
    
    @Override
    public final void run(final String s, final String[] array) {
        final long n = Class133.c ^ 0x1FCCAC4C2161L;
        final int[] array3;
        final int[] array2 = array3 = invokedynamic(U:(JJ)[I, -4343303223278483577L, n);
        Label_0075: {
            Label_0040: {
                try {
                    if (array2 != null) {
                        break Label_0040;
                    }
                    final int n2 = array.length;
                    if (n2 == 0) {
                        break Label_0040;
                    }
                    break Label_0075;
                }
                catch (RuntimeException ex) {
                    throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex, -4343390316366048349L, n);
                }
                try {
                    final int n2 = array.length;
                    if (n2 != 0) {
                        break Label_0075;
                    }
                    Class23.sendClientMessage(invokedynamic(y:(IJ)Ljava/lang/String;, 20068, 0x33795F691DA7FE57L ^ n), Class153.WARNING);
                }
                catch (RuntimeException ex2) {
                    throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex2, -4343390316366048349L, n);
                }
            }
            if (array3 == null) {
                return;
            }
        }
        String value = Class133.llIlllllII[0];
        int i = 0;
        while (true) {
            while (i < array.length) {
                value = String.valueOf(new StringBuilder().append(value).append(array[i]).append(Class133.llIlllllII[1]));
                ++i;
                if (array3 != null) {
                    Class23.sendClientMessage(String.valueOf(new StringBuilder().append(invokedynamic(y:(IJ)Ljava/lang/String;, 3202, 0x2BDC2FCD893BCB4L ^ n)).append(value)), Class153.SUCCESS);
                    return;
                }
                if (array3 != null) {
                    break;
                }
            }
            Spammer.text = value;
            final long n3 = Class133.c ^ 0x20D792D53C28L;
            final int[] array4 = invokedynamic(U:(JJ)[I, -2382329840650659122L, n3);
            final File file = new File(String.valueOf(new StringBuilder().append(Class133.fileDir).append(invokedynamic(y:(IJ)Ljava/lang/String;, 27893, 0x35B2119C296CC18EL ^ n3))));
            final int[] array5 = array4;
            final File file2 = file;
            try {
                Label_0225: {
                    boolean exists;
                    try {
                        exists = file2.exists();
                        if (array5 != null) {
                            break Label_0225;
                        }
                        if (!exists) {
                            break Label_0225;
                        }
                        break Label_0225;
                    }
                    catch (Exception ex3) {
                        throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex3, -2382383732012593430L, n3);
                    }
                    try {
                        if (!exists) {
                            file.createNewFile();
                        }
                    }
                    catch (Exception ex4) {
                        throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex4, -2382383732012593430L, n3);
                    }
                }
                final PrintWriter printWriter;
                (printWriter = new PrintWriter(file)).print(Spammer.text);
                printWriter.close();
            }
            catch (Exception ex5) {
                ex5.printStackTrace();
            }
            continue;
        }
    }
    
    @Override
    public final List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
    
    static {
        lIlIIIIIIIlI();
        final long n = (c = Class169.a(-8480920789588864292L, 2546272647865178283L, MethodHandles.lookup().lookupClass()).a(267430504031663L)) ^ 0x4B66363C4871L;
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class133.llIlllllII[2]);
        final int n2 = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class133.llIlllllII[3]);
        final byte[] array = new byte[8];
        array[0] = (byte)(n >>> 56);
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(n << i * 8 >>> 56);
        }
        instance.init(n2, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[6];
        int n3 = 0;
        String s;
        int n4 = (s = Class133.llIlllllII[4]).length();
        int n5 = 16;
        int n6 = -1;
    Label_0166:
        while (true) {
            while (true) {
                ++n6;
                final String s2 = s;
                final int n7 = n6;
                String s3 = s2.substring(n7, n7 + n5);
                int n8 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class133.llIlllllII[6]))).intern();
                    switch (n8) {
                        default: {
                            d2[n3++] = intern;
                            if ((n6 += n5) < n4) {
                                n5 = s.charAt(n6);
                                continue Label_0166;
                            }
                            n4 = (s = Class133.llIlllllII[5]).length();
                            n5 = 32;
                            n6 = -1;
                            break;
                        }
                        case 0: {
                            d2[n3++] = intern;
                            if ((n6 += n5) < n4) {
                                n5 = s.charAt(n6);
                                break;
                            }
                            break Label_0166;
                        }
                    }
                    ++n6;
                    final String s4 = s;
                    final int n9 = n6;
                    s3 = s4.substring(n9, n9 + n5);
                    n8 = 0;
                }
            }
            break;
        }
        d = d2;
        e = new String[6];
        Class133.fileDir = String.valueOf(new StringBuilder().append(Minecraft.func_71410_x().field_71412_D.getAbsolutePath()).append(invokedynamic(y:(IJ)Ljava/lang/String;, 21383, 0x74C85037D5E50AA7L ^ n)));
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x73E2;
        if (Class133.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class133.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class133.llIlllllII[7]);
                    array[1] = SecretKeyFactory.getInstance(Class133.llIlllllII[8]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class133.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class133.llIlllllII[9], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class133.e[n3] = a(((Cipher)array[0]).doFinal(Class133.d[n3].getBytes(Class133.llIlllllII[10])));
        }
        return Class133.e[n3];
    }
    
    private static void lIlIIIIIIIlI() {
        (llIlllllII = new String[14])[0] = "";
        Class133.llIlllllII[1] = " ";
        Class133.llIlllllII[2] = "DES/CBC/PKCS5Padding";
        Class133.llIlllllII[3] = "DES";
        Class133.llIlllllII[4] = "*m\u007f{f)ÓÝSð¥Ò{¬É\u0091 \u0004\u009eÂ\u009bð\n*Y¡\u0082¡\f\\K\u0019ýëëTP\u0087CtÐoQ\u0098ÐÛ\u0094A¢\u0010\u0090$I½k_÷7\u000bi\u0005è°Ñ¬\u0091\u0010\f\"À\u0014\u0094\u0080J«\u009fc=\u0087\u0012át«";
        Class133.llIlllllII[5] = "\b\u009d°\u009e\u0089\u0010\r4;»û4¹Æ$«ý\u0094\u0019³7ÔÄ¼b\u0019ñÍ\b$³å ù·¡û\f<Þ\u001e\\¶úäBò\u0002~\u0014\u001f \u0081\u0016NcÛ\u0098,¦UÙ?'\u00ad";
        Class133.llIlllllII[6] = "ISO-8859-1";
        Class133.llIlllllII[7] = "DES/CBC/PKCS5Padding";
        Class133.llIlllllII[8] = "DES";
        Class133.llIlllllII[9] = "孩子你给你爹爹记住了输了敢于承认不要再装逼因为我目前只是给你教训你是不是无与伦比的窝囊废啊小伙子你八仙过海的赶来狐假虎威的狗你爹爹我呢你这个天生的废材爹爹我可以把你打到七窍流血NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u200f\u2004\u2001";
        Class133.llIlllllII[10] = "ISO-8859-1";
        Class133.llIlllllII[11] = "孩子你给你爹爹记住了输了敢于承认不要再装逼因为我目前只是给你教训你是不是无与伦比的窝囊废啊小伙子你八仙过海的赶来狐假虎威的狗你爹爹我呢你这个天生的废材爹爹我可以把你打到七窍流血NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u200f\u2004\u2001";
        Class133.llIlllllII[12] = " : ";
        Class133.llIlllllII[13] = " : ";
    }
    
    private static String lIIlllllllIl(final String s, final String s2) {
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
    
    private static String lIIlllllllII(final String s, final String s2) {
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
    
    private static String lIIllllllllI(String s, final String s2) {
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
