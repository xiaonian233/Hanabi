package org.spongepowered.tools.obfuscation;

import org.spongepowered.tools.obfuscation.interfaces.*;
import org.spongepowered.asm.mixin.refmap.*;
import javax.lang.model.element.*;
import com.google.gson.*;
import java.io.*;
import javax.tools.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.obfuscation.mapping.*;
import org.spongepowered.asm.obfuscation.mapping.common.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class ReferenceManager implements IReferenceManager
{
    private final IMixinAnnotationProcessor ap;
    private final String outRefMapFileName;
    private final List<ObfuscationEnvironment> environments;
    private final ReferenceMapper refMapper;
    private boolean allowConflicts;
    private static final String[] lllIlIIIlI;
    
    public ReferenceManager(final IMixinAnnotationProcessor ap, final List<ObfuscationEnvironment> environments) {
        super();
        this.refMapper = new ReferenceMapper();
        this.ap = ap;
        this.environments = environments;
        this.outRefMapFileName = this.ap.getOption(ReferenceManager.lllIlIIIlI[0]);
    }
    
    @Override
    public final boolean getAllowConflicts() {
        return this.allowConflicts;
    }
    
    @Override
    public final void setAllowConflicts(final boolean allowConflicts) {
        this.allowConflicts = allowConflicts;
    }
    
    @Override
    public final void write() {
        if (this.outRefMapFileName == null) {
            return;
        }
        PrintWriter printWriter = null;
        try {
            final String outRefMapFileName = this.outRefMapFileName;
            final String s = ReferenceManager.lllIlIIIlI[1];
            try {
                final String s2 = s;
                final String s3 = outRefMapFileName;
                PrintWriter printWriter2;
                if (s3.matches(ReferenceManager.lllIlIIIlI[2])) {
                    final File file;
                    (file = new File(s3)).getParentFile().mkdirs();
                    this.ap.printMessage(Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append(ReferenceManager.lllIlIIIlI[3]).append(s2).append(ReferenceManager.lllIlIIIlI[4]).append(file.getAbsolutePath())));
                    printWriter2 = new PrintWriter(file);
                }
                else {
                    final FileObject resource = this.ap.getProcessingEnvironment().getFiler().createResource(StandardLocation.CLASS_OUTPUT, ReferenceManager.lllIlIIIlI[5], s3, new Element[0]);
                    this.ap.printMessage(Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append(ReferenceManager.lllIlIIIlI[6]).append(s2).append(ReferenceManager.lllIlIIIlI[7]).append(new File(resource.toUri()).getAbsolutePath())));
                    printWriter2 = new PrintWriter(resource.openWriter());
                }
                printWriter = printWriter2;
                new GsonBuilder().setPrettyPrinting().create().toJson((Object)this.refMapper, (Appendable)printWriter);
                final PrintWriter printWriter3 = printWriter;
                try {
                    printWriter3.close();
                }
                catch (Exception ex2) {}
            }
            catch (IOException ex) {
                ex.printStackTrace();
                if (printWriter == null) {
                    return;
                }
                final PrintWriter printWriter4 = printWriter;
                try {
                    printWriter4.close();
                }
                catch (Exception ex3) {}
            }
        }
        finally {
            if (printWriter != null) {
                final PrintWriter printWriter5 = printWriter;
                try {
                    printWriter5.close();
                }
                catch (Exception ex4) {}
            }
        }
    }
    
    private PrintWriter newWriter(final String s, final String s2) throws IOException {
        if (s.matches(ReferenceManager.lllIlIIIlI[2])) {
            final File file;
            (file = new File(s)).getParentFile().mkdirs();
            this.ap.printMessage(Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append(ReferenceManager.lllIlIIIlI[3]).append(s2).append(ReferenceManager.lllIlIIIlI[4]).append(file.getAbsolutePath())));
            return new PrintWriter(file);
        }
        final FileObject resource = this.ap.getProcessingEnvironment().getFiler().createResource(StandardLocation.CLASS_OUTPUT, ReferenceManager.lllIlIIIlI[5], s, new Element[0]);
        this.ap.printMessage(Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append(ReferenceManager.lllIlIIIlI[6]).append(s2).append(ReferenceManager.lllIlIIIlI[7]).append(new File(resource.toUri()).getAbsolutePath())));
        return new PrintWriter(resource.openWriter());
    }
    
    @Override
    public final ReferenceMapper getMapper() {
        return this.refMapper;
    }
    
    @Override
    public final void addMethodMapping(final String s, final String s2, final ObfuscationData<MappingMethod> obfuscationData) {
        for (final ObfuscationEnvironment obfuscationEnvironment : this.environments) {
            final MappingMethod mappingMethod;
            if ((mappingMethod = obfuscationData.get(obfuscationEnvironment.type)) != null) {
                this.addMapping(obfuscationEnvironment.type, s, s2, new MemberInfo(mappingMethod).toString());
            }
        }
    }
    
    @Override
    public final void addMethodMapping(final String s, final String s2, final MemberInfo memberInfo, final ObfuscationData<MappingMethod> obfuscationData) {
        for (final ObfuscationEnvironment obfuscationEnvironment : this.environments) {
            final MappingMethod mappingMethod;
            if ((mappingMethod = obfuscationData.get(obfuscationEnvironment.type)) != null) {
                this.addMapping(obfuscationEnvironment.type, s, s2, new MemberInfo(memberInfo, mappingMethod).toString());
            }
        }
    }
    
    @Override
    public final void addFieldMapping(final String s, final String s2, final MemberInfo memberInfo, final ObfuscationData<MappingField> obfuscationData) {
        for (final ObfuscationEnvironment obfuscationEnvironment : this.environments) {
            final MappingField mappingField;
            if ((mappingField = obfuscationData.get(obfuscationEnvironment.type)) != null) {
                this.addMapping(obfuscationEnvironment.type, s, s2, MemberInfo.fromMapping(mappingField.transform(obfuscationEnvironment.remapDescriptor(memberInfo.desc))).toString());
            }
        }
    }
    
    @Override
    public final void addClassMapping(final String s, final String s2, final ObfuscationData<String> obfuscationData) {
        for (final ObfuscationEnvironment obfuscationEnvironment : this.environments) {
            final String s3;
            if ((s3 = obfuscationData.get(obfuscationEnvironment.type)) != null) {
                this.addMapping(obfuscationEnvironment.type, s, s2, s3);
            }
        }
    }
    
    private void addMapping(final ObfuscationType obfuscationType, final String s, final String s2, final String s3) {
        final String addMapping = this.refMapper.addMapping(obfuscationType.key, s, s2, s3);
        if (obfuscationType.isDefault()) {
            this.refMapper.addMapping(null, s, s2, s3);
        }
        if (!this.allowConflicts && addMapping != null && !addMapping.equals(s3)) {
            throw new ReferenceConflictException(addMapping, s3);
        }
    }
    
    static {
        lIlIIllIIllI();
    }
    
    private static void lIlIIllIIllI() {
        (lllIlIIIlI = new String[8])[0] = "outRefMapFile";
        ReferenceManager.lllIlIIIlI[1] = "refmap";
        ReferenceManager.lllIlIIIlI[2] = "^.*[\\\\/:].*$";
        ReferenceManager.lllIlIIIlI[3] = "Writing ";
        ReferenceManager.lllIlIIIlI[4] = " to ";
        ReferenceManager.lllIlIIIlI[5] = "";
        ReferenceManager.lllIlIIIlI[6] = "Writing ";
        ReferenceManager.lllIlIIIlI[7] = " to ";
    }
    
    private static String lIlIIllIIIlI(final String s, final String s2) {
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
    
    private static String lIlIIllIIIIl(final String s, final String s2) {
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
    
    private static String lIlIIllIIIll(String s, final String s2) {
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
