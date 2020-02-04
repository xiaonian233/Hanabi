package org.spongepowered.asm.mixin.injection.invoke.util;

import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.lib.tree.*;
import org.apache.logging.log4j.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import org.spongepowered.asm.lib.tree.analysis.*;

public final class InsnFinder
{
    private static final Logger logger;
    private static final String[] lIlIlll;
    
    public InsnFinder() {
        super();
    }
    
    public static AbstractInsnNode findPopInsn(final Target target, final AbstractInsnNode abstractInsnNode) {
        try {
            new PopAnalyzer(abstractInsnNode).analyze(target.classNode.name, target.method);
        }
        catch (AnalyzerException ex2) {
            final AnalyzerException ex = ex2;
            if (ex2.getCause() instanceof AnalysisResultException) {
                return ((AnalysisResultException)ex.getCause()).result;
            }
            InsnFinder.logger.catching((Throwable)ex);
        }
        return null;
    }
    
    static {
        llllIlIl();
        logger = LogManager.getLogger(InsnFinder.lIlIlll[0]);
    }
    
    private static void llllIlIl() {
        (lIlIlll = new String[] { null })[0] = "mixin";
    }
    
    private static String llllIIll(final String s, final String s2) {
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
