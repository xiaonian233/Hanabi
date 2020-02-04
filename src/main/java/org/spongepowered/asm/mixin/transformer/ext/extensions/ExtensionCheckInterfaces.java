package org.spongepowered.asm.mixin.transformer.ext.extensions;

import com.google.common.collect.*;
import com.google.common.base.*;
import com.google.common.io.*;
import java.text.*;
import org.spongepowered.asm.mixin.transformer.ext.*;
import org.apache.commons.io.*;
import java.io.*;
import org.apache.logging.log4j.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.util.*;
import java.lang.annotation.*;
import org.spongepowered.asm.mixin.gen.*;
import org.spongepowered.asm.mixin.transformer.*;
import org.spongepowered.asm.lib.tree.*;
import java.util.*;

public final class ExtensionCheckInterfaces implements IExtension
{
    private static final String AUDIT_DIR;
    private static final String IMPL_REPORT_FILENAME;
    private static final String IMPL_REPORT_CSV_FILENAME;
    private static final String IMPL_REPORT_TXT_FILENAME;
    private static final Logger logger;
    private final File csv;
    private final File report;
    private final Multimap<ClassInfo, ClassInfo.Method> interfaceMethods;
    private boolean strict;
    private static final String[] lIlIlIIIIlI;
    
    public ExtensionCheckInterfaces() {
        super();
        this.interfaceMethods = (Multimap<ClassInfo, ClassInfo.Method>)HashMultimap.create();
        final File file;
        (file = new File(Constants.DEBUG_OUTPUT_DIR, ExtensionCheckInterfaces.lIlIlIIIIlI[0])).mkdirs();
        this.csv = new File(file, ExtensionCheckInterfaces.lIlIlIIIIlI[1]);
        this.report = new File(file, ExtensionCheckInterfaces.lIlIlIIIIlI[2]);
        final String s = ExtensionCheckInterfaces.lIlIlIIIIlI[3];
        final File csv = this.csv;
        final Charset iso_8859_1 = Charsets.ISO_8859_1;
        try {
            Files.write((CharSequence)s, csv, iso_8859_1);
        }
        catch (IOException ex) {}
        final String s2 = ExtensionCheckInterfaces.lIlIlIIIIlI[4];
        try {
            Files.write((CharSequence)String.valueOf(new StringBuilder().append(ExtensionCheckInterfaces.lIlIlIIIIlI[5]).append(new SimpleDateFormat(s2).format(new Date())).append(ExtensionCheckInterfaces.lIlIlIIIIlI[6])), this.report, Charsets.ISO_8859_1);
        }
        catch (IOException ex2) {}
    }
    
    @Override
    public final boolean checkActive(final MixinEnvironment mixinEnvironment) {
        this.strict = mixinEnvironment.getOption(MixinEnvironment.Option.CHECK_IMPLEMENTS_STRICT);
        return mixinEnvironment.getOption(MixinEnvironment.Option.CHECK_IMPLEMENTS);
    }
    
    @Override
    public final void preApply(final ITargetClassContext targetClassContext) {
        final ClassInfo classInfo;
        final Iterator<ClassInfo.Method> iterator = (classInfo = targetClassContext.getClassInfo()).getInterfaceMethods(false).iterator();
        while (iterator.hasNext()) {
            this.interfaceMethods.put((Object)classInfo, (Object)iterator.next());
        }
    }
    
    @Override
    public final void postApply(ITargetClassContext replace) {
        final ClassInfo classInfo;
        if (((classInfo = replace.getClassInfo()).access & 0x400) != 0x0 && !this.strict) {
            ExtensionCheckInterfaces.logger.info(ExtensionCheckInterfaces.lIlIlIIIIlI[7], new Object[] { this.getClass().getSimpleName(), replace });
            return;
        }
        replace = (ITargetClassContext)classInfo.name.replace('/', '.');
        int n = 0;
        final PrettyPrinter prettyPrinter;
        (prettyPrinter = new PrettyPrinter()).add(ExtensionCheckInterfaces.lIlIlIIIIlI[8], replace).hr('*');
        prettyPrinter.add(ExtensionCheckInterfaces.lIlIlIIIIlI[9], ExtensionCheckInterfaces.lIlIlIIIIlI[10], ExtensionCheckInterfaces.lIlIlIIIIlI[11], ExtensionCheckInterfaces.lIlIlIIIIlI[12]).hr('*');
        final Set<ClassInfo.Method> interfaceMethods = classInfo.getInterfaceMethods(true);
        final HashSet set;
        (set = new HashSet(classInfo.getSuperClass().getInterfaceMethods(true))).addAll(this.interfaceMethods.removeAll((Object)classInfo));
        for (final ClassInfo.Method method : interfaceMethods) {
            final ClassInfo.Method methodInHierarchy;
            if (((methodInHierarchy = classInfo.findMethodInHierarchy(method.getName(), method.getDesc(), ClassInfo.SearchType.ALL_CLASSES, ClassInfo.Traversal.ALL)) == null || methodInHierarchy.isAbstract()) && !set.contains(method)) {
                if (n > 0) {
                    prettyPrinter.add();
                }
                final SignaturePrinter setModifiers = new SignaturePrinter(method.getName(), method.getDesc()).setModifiers(ExtensionCheckInterfaces.lIlIlIIIIlI[13]);
                final String replace2 = method.getOwner().name.replace('/', '.');
                ++n;
                prettyPrinter.add(ExtensionCheckInterfaces.lIlIlIIIIlI[14], setModifiers.getReturnType(), setModifiers);
                prettyPrinter.add(ExtensionCheckInterfaces.lIlIlIIIIlI[15], ExtensionCheckInterfaces.lIlIlIIIIlI[16], replace2);
                final ITargetClassContext targetClassContext = replace;
                final ClassInfo.Method method2 = method;
                final String s = replace2;
                final ClassInfo.Method method3 = method2;
                final ITargetClassContext targetClassContext2 = targetClassContext;
                final String s2 = ExtensionCheckInterfaces.lIlIlIIIIlI[20];
                final Object[] array = new Object[4];
                array[0] = targetClassContext2;
                final int n2 = 1;
                final ClassInfo.Method method4 = method3;
                try {
                    array[n2] = method4.getName();
                    array[2] = method3.getDesc();
                    array[3] = s;
                    Files.append((CharSequence)String.format(s2, array), this.csv, Charsets.ISO_8859_1);
                }
                catch (IOException ex) {}
            }
        }
        if (n > 0) {
            prettyPrinter.hr('*').add(ExtensionCheckInterfaces.lIlIlIIIIlI[17], ExtensionCheckInterfaces.lIlIlIIIIlI[18], ExtensionCheckInterfaces.lIlIlIIIIlI[19], n);
            prettyPrinter.print(System.err);
            final PrettyPrinter prettyPrinter2 = prettyPrinter;
            OutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(this.report, true);
                final PrintStream printStream;
                (printStream = new PrintStream(outputStream)).print(ExtensionCheckInterfaces.lIlIlIIIIlI[21]);
                prettyPrinter2.print(printStream);
            }
            catch (Exception ex2) {}
            finally {
                IOUtils.closeQuietly(outputStream);
            }
        }
    }
    
    @Override
    public final void export(final MixinEnvironment mixinEnvironment, final String s, final boolean b, final byte[] array) {
    }
    
    private void appendToCSVReport(final String s, final ClassInfo.Method method, final String s2) {
        final String s3 = ExtensionCheckInterfaces.lIlIlIIIIlI[20];
        final Object[] array = new Object[4];
        array[0] = s;
        final int n = 1;
        try {
            array[n] = method.getName();
            array[2] = method.getDesc();
            array[3] = s2;
            Files.append((CharSequence)String.format(s3, array), this.csv, Charsets.ISO_8859_1);
        }
        catch (IOException ex) {}
    }
    
    private void appendToTextReport(final PrettyPrinter prettyPrinter) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(this.report, true);
            final PrintStream printStream;
            (printStream = new PrintStream(outputStream)).print(ExtensionCheckInterfaces.lIlIlIIIIlI[21]);
            prettyPrinter.print(printStream);
        }
        catch (Exception ex) {}
        finally {
            IOUtils.closeQuietly(outputStream);
        }
    }
    
    static {
        lllIlIllIIII();
        logger = LogManager.getLogger(ExtensionCheckInterfaces.lIlIlIIIIlI[26]);
    }
    
    private static void lllIlIllIIII() {
        (lIlIlIIIIlI = new String[27])[0] = "audit";
        ExtensionCheckInterfaces.lIlIlIIIIlI[1] = "mixin_implementation_report.csv";
        ExtensionCheckInterfaces.lIlIlIIIIlI[2] = "mixin_implementation_report.txt";
        ExtensionCheckInterfaces.lIlIlIIIIlI[3] = "Class,Method,Signature,Interface\n";
        ExtensionCheckInterfaces.lIlIlIIIIlI[4] = "yyyy-MM-dd HH:mm:ss";
        ExtensionCheckInterfaces.lIlIlIIIIlI[5] = "Mixin Implementation Report generated on ";
        ExtensionCheckInterfaces.lIlIlIIIIlI[6] = "\n";
        ExtensionCheckInterfaces.lIlIlIIIIlI[7] = "{} is skipping abstract target {}";
        ExtensionCheckInterfaces.lIlIlIIIIlI[8] = "Class: %s";
        ExtensionCheckInterfaces.lIlIlIIIIlI[9] = "%-32s %-47s  %s";
        ExtensionCheckInterfaces.lIlIlIIIIlI[10] = "Return Type";
        ExtensionCheckInterfaces.lIlIlIIIIlI[11] = "Missing Method";
        ExtensionCheckInterfaces.lIlIlIIIIlI[12] = "From Interface";
        ExtensionCheckInterfaces.lIlIlIIIIlI[13] = "";
        ExtensionCheckInterfaces.lIlIlIIIIlI[14] = "%-32s%s";
        ExtensionCheckInterfaces.lIlIlIIIIlI[15] = "%-80s  %s";
        ExtensionCheckInterfaces.lIlIlIIIIlI[16] = "";
        ExtensionCheckInterfaces.lIlIlIIIIlI[17] = "%82s%s: %d";
        ExtensionCheckInterfaces.lIlIlIIIIlI[18] = "";
        ExtensionCheckInterfaces.lIlIlIIIIlI[19] = "Total unimplemented";
        ExtensionCheckInterfaces.lIlIlIIIIlI[20] = "%s,%s,%s,%s\n";
        ExtensionCheckInterfaces.lIlIlIIIIlI[21] = "\n";
        ExtensionCheckInterfaces.lIlIlIIIIlI[22] = "audit";
        ExtensionCheckInterfaces.lIlIlIIIIlI[23] = "mixin_implementation_report.txt";
        ExtensionCheckInterfaces.lIlIlIIIIlI[24] = "mixin_implementation_report";
        ExtensionCheckInterfaces.lIlIlIIIIlI[25] = "mixin_implementation_report.csv";
        ExtensionCheckInterfaces.lIlIlIIIIlI[26] = "mixin";
    }
    
    private static String lllIlIlIllIl(final String s, final String s2) {
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
    
    private static String lllIlIlIlllI(String s, final String s2) {
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
    
    private static String lllIlIlIllll(final String s, final String s2) {
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
    
    private static boolean lllIlIllIlII(final int n) {
        return n > 0;
    }
}
