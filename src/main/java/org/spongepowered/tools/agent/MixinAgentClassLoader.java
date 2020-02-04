package org.spongepowered.tools.agent;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.lib.*;
import org.apache.logging.log4j.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

final class MixinAgentClassLoader extends ClassLoader
{
    private static final Logger logger;
    Map<Class<?>, byte[]> mixins;
    Map<String, byte[]> targets;
    private static final String[] lIIIIIIIllI;
    
    MixinAgentClassLoader() {
        super();
        this.mixins = new HashMap<Class<?>, byte[]>();
        this.targets = new HashMap<String, byte[]>();
    }
    
    final void addMixinClass(final String s) {
        MixinAgentClassLoader.logger.debug(MixinAgentClassLoader.lIIIIIIIllI[0], new Object[] { s });
        try {
            final ClassWriter classWriter;
            (classWriter = new ClassWriter(3)).visit(MixinEnvironment.getCompatibilityLevel().classVersion, 1, s.replace('.', '/'), null, Type.getInternalName(Object.class), null);
            final MethodVisitor visitMethod;
            (visitMethod = classWriter.visitMethod(1, MixinAgentClassLoader.lIIIIIIIllI[1], MixinAgentClassLoader.lIIIIIIIllI[2], null, null)).visitCode();
            visitMethod.visitVarInsn(25, 0);
            visitMethod.visitMethodInsn(183, Type.getInternalName(Object.class), MixinAgentClassLoader.lIIIIIIIllI[3], MixinAgentClassLoader.lIIIIIIIllI[4], false);
            visitMethod.visitInsn(177);
            visitMethod.visitMaxs(1, 1);
            visitMethod.visitEnd();
            classWriter.visitEnd();
            final byte[] byteArray = classWriter.toByteArray();
            final Class<?> defineClass;
            (defineClass = this.defineClass(s, byteArray, 0, byteArray.length)).newInstance();
            this.mixins.put(defineClass, byteArray);
        }
        catch (Throwable t) {
            MixinAgentClassLoader.logger.catching(t);
        }
    }
    
    private void addTargetClass(final String s, final byte[] array) {
        this.targets.put(s, array);
    }
    
    private byte[] getFakeMixinBytecode(final Class<?> clazz) {
        return this.mixins.get(clazz);
    }
    
    private byte[] getOriginalTargetBytecode(final String s) {
        return this.targets.get(s);
    }
    
    private static byte[] materialise(final String s) {
        final ClassWriter classWriter;
        (classWriter = new ClassWriter(3)).visit(MixinEnvironment.getCompatibilityLevel().classVersion, 1, s.replace('.', '/'), null, Type.getInternalName(Object.class), null);
        final MethodVisitor visitMethod;
        (visitMethod = classWriter.visitMethod(1, MixinAgentClassLoader.lIIIIIIIllI[1], MixinAgentClassLoader.lIIIIIIIllI[2], null, null)).visitCode();
        visitMethod.visitVarInsn(25, 0);
        visitMethod.visitMethodInsn(183, Type.getInternalName(Object.class), MixinAgentClassLoader.lIIIIIIIllI[3], MixinAgentClassLoader.lIIIIIIIllI[4], false);
        visitMethod.visitInsn(177);
        visitMethod.visitMaxs(1, 1);
        visitMethod.visitEnd();
        classWriter.visitEnd();
        return classWriter.toByteArray();
    }
    
    static {
        lIlllIlIIlII();
        logger = LogManager.getLogger(MixinAgentClassLoader.lIIIIIIIllI[5]);
    }
    
    private static void lIlllIlIIlII() {
        (lIIIIIIIllI = new String[6])[0] = "Mixin class {} added to class loader";
        MixinAgentClassLoader.lIIIIIIIllI[1] = "<init>";
        MixinAgentClassLoader.lIIIIIIIllI[2] = "()V";
        MixinAgentClassLoader.lIIIIIIIllI[3] = "<init>";
        MixinAgentClassLoader.lIIIIIIIllI[4] = "()V";
        MixinAgentClassLoader.lIIIIIIIllI[5] = "mixin.agent";
    }
    
    private static String lIlllIlIIIlI(final String s, final String s2) {
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
    
    private static String lIlllIlIIIll(String s, final String s2) {
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
    
    private static String lIlllIlIIIIl(final String s, final String s2) {
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
