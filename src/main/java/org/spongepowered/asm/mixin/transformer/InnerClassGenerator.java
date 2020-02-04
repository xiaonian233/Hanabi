package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.mixin.transformer.ext.*;
import org.spongepowered.asm.service.*;
import org.spongepowered.asm.transformers.*;
import org.spongepowered.asm.mixin.transformer.throwables.*;
import org.apache.logging.log4j.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import org.spongepowered.asm.lib.commons.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.mixin.extensibility.*;
import java.io.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.util.*;
import java.lang.annotation.*;
import org.spongepowered.asm.mixin.gen.*;
import org.spongepowered.asm.lib.tree.*;
import java.util.*;

final class InnerClassGenerator implements IClassGenerator
{
    static final Logger logger;
    final Map<String, String> innerClassNames;
    final Map<String, InnerClassInfo> innerClasses;
    static final String[] llIIIllll;
    
    InnerClassGenerator() {
        super();
        this.innerClassNames = new HashMap<String, String>();
        this.innerClasses = new HashMap<String, InnerClassInfo>();
    }
    
    private String registerInnerClass(final MixinInfo mixinInfo, final String s, final MixinTargetContext mixinTargetContext) {
        final String format = String.format(InnerClassGenerator.llIIIllll[0], s, mixinTargetContext);
        String format2;
        if ((format2 = this.innerClassNames.get(format)) == null) {
            String substring;
            if ((substring = s.substring(s.lastIndexOf(36) + 1)).matches(InnerClassGenerator.llIIIllll[3])) {
                substring = InnerClassGenerator.llIIIllll[4];
            }
            format2 = String.format(InnerClassGenerator.llIIIllll[5], mixinTargetContext.targetClass.getClassRef(), substring, UUID.randomUUID().toString().replace(InnerClassGenerator.llIIIllll[6], InnerClassGenerator.llIIIllll[7]));
            this.innerClassNames.put(format, format2);
            this.innerClasses.put(format2, new InnerClassInfo(format2, s, mixinInfo, mixinTargetContext));
            InnerClassGenerator.logger.debug(InnerClassGenerator.llIIIllll[1], new Object[] { s, mixinInfo.info.name, mixinTargetContext.targetClass.getClassRef(), format2 });
        }
        return format2;
    }
    
    @Override
    public final byte[] generate(String replace) {
        replace = replace.replace('.', '/');
        final InnerClassInfo innerClassInfo;
        if ((innerClassInfo = this.innerClasses.get(replace)) != null) {
            return generate(innerClassInfo);
        }
        return null;
    }
    
    private static byte[] generate(final InnerClassInfo innerClassInfo) {
        final Logger logger = InnerClassGenerator.logger;
        final String[] llIIIllll = InnerClassGenerator.llIIIllll;
        final int n = 2;
        try {
            final String s = llIIIllll[n];
            final Object[] array = new Object[2];
            final int n2 = 0;
            try {
                array[n2] = innerClassInfo.name;
                array[1] = innerClassInfo.originalName;
                logger.debug(s, array);
                final ClassReader classReader = new ClassReader(MixinService.getService().getBytecodeProvider().getClassBytes$44c4d6c8(innerClassInfo.originalName));
                final MixinClassWriter mixinClassWriter = new MixinClassWriter(classReader, 0);
                classReader.accept(new InnerClassAdapter(mixinClassWriter, innerClassInfo), 8);
                return mixinClassWriter.toByteArray();
            }
            catch (InvalidMixinException ex) {
                throw ex;
            }
        }
        catch (Exception ex2) {
            InnerClassGenerator.logger.catching((Throwable)ex2);
            return null;
        }
    }
    
    private static String getUniqueReference(String substring, final MixinTargetContext mixinTargetContext) {
        final String s = substring;
        if ((substring = s.substring(s.lastIndexOf(36) + 1)).matches(InnerClassGenerator.llIIIllll[3])) {
            substring = InnerClassGenerator.llIIIllll[4];
        }
        return String.format(InnerClassGenerator.llIIIllll[5], mixinTargetContext.targetClass.getClassRef(), substring, UUID.randomUUID().toString().replace(InnerClassGenerator.llIIIllll[6], InnerClassGenerator.llIIIllll[7]));
    }
    
    static {
        lIIIlIIllII();
        logger = LogManager.getLogger(InnerClassGenerator.llIIIllll[8]);
    }
    
    private static void lIIIlIIllII() {
        (llIIIllll = new String[9])[0] = "%s%s";
        InnerClassGenerator.llIIIllll[1] = "Inner class {} in {} on {} gets unique name {}";
        InnerClassGenerator.llIIIllll[2] = "Generating mapped inner class {} (originally {})";
        InnerClassGenerator.llIIIllll[3] = "^[0-9]+$";
        InnerClassGenerator.llIIIllll[4] = "Anonymous";
        InnerClassGenerator.llIIIllll[5] = "%s$%s$%s";
        InnerClassGenerator.llIIIllll[6] = "-";
        InnerClassGenerator.llIIIllll[7] = "";
        InnerClassGenerator.llIIIllll[8] = "mixin";
    }
    
    private static String lIIIlIIIIll(final String s, final String s2) {
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
    
    private static String lIIIlIIIIlI(String s, final String s2) {
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
    
    private static String lIIIlIIIIIl(final String s, final String s2) {
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
