package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.util.*;
import org.spongepowered.asm.mixin.transformer.throwables.*;
import org.spongepowered.asm.mixin.extensibility.*;
import org.spongepowered.asm.lib.tree.*;
import java.nio.charset.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.*;
import java.security.*;

class MixinPreProcessorInterface extends MixinPreProcessorStandard
{
    private static final String[] lllIlIIllI;
    
    MixinPreProcessorInterface(final MixinInfo mixinInfo, final MixinInfo.MixinClassNode mixinClassNode) {
        super(mixinInfo, mixinClassNode);
    }
    
    @Override
    protected final void prepareMethod(final MixinInfo.MixinMethodNode mixinMethodNode, final ClassInfo.Method method) {
        if (!Bytecode.hasFlag(mixinMethodNode, 1) && !Bytecode.hasFlag(mixinMethodNode, 4096)) {
            throw new InvalidInterfaceMixinException(this.mixin, String.valueOf(new StringBuilder().append(MixinPreProcessorInterface.lllIlIIllI[0]).append(method).append(MixinPreProcessorInterface.lllIlIIllI[1]).append(this.mixin)));
        }
        super.prepareMethod(mixinMethodNode, method);
    }
    
    @Override
    protected final boolean validateField(final MixinTargetContext mixinTargetContext, final FieldNode fieldNode, final AnnotationNode annotationNode) {
        if (!Bytecode.hasFlag(fieldNode, 8)) {
            throw new InvalidInterfaceMixinException(this.mixin, String.valueOf(new StringBuilder().append(MixinPreProcessorInterface.lllIlIIllI[2]).append(fieldNode.name).append(MixinPreProcessorInterface.lllIlIIllI[3]).append(this.mixin)));
        }
        return super.validateField(mixinTargetContext, fieldNode, annotationNode);
    }
    
    static {
        lIlIIllIllII();
    }
    
    private static void lIlIIllIllII() {
        (lllIlIIllI = new String[4])[0] = "Interface mixin contains a non-public method! Found ";
        MixinPreProcessorInterface.lllIlIIllI[1] = " in ";
        MixinPreProcessorInterface.lllIlIIllI[2] = "Interface mixin contains an instance field! Found ";
        MixinPreProcessorInterface.lllIlIIllI[3] = " in ";
    }
    
    private static String lIlIIllIlIlI(String s, final String s2) {
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
    
    private static String lIlIIllIlIll(final String s, final String s2) {
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
