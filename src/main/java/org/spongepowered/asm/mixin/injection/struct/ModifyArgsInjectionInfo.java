package org.spongepowered.asm.mixin.injection.struct;

import org.spongepowered.asm.mixin.transformer.*;
import org.spongepowered.asm.lib.tree.*;
import org.spongepowered.asm.mixin.injection.code.*;
import org.spongepowered.asm.mixin.injection.invoke.*;
import java.util.*;
import java.nio.charset.*;

public final class ModifyArgsInjectionInfo extends InjectionInfo
{
    private static final String[] lIIllllIll;
    
    public ModifyArgsInjectionInfo(final MixinTargetContext mixinTargetContext, final MethodNode methodNode, final AnnotationNode annotationNode) {
        super(mixinTargetContext, methodNode, annotationNode);
    }
    
    @Override
    protected final Injector parseInjector(final AnnotationNode annotationNode) {
        return new ModifyArgsInjector(this);
    }
    
    @Override
    protected final String getDescription() {
        return ModifyArgsInjectionInfo.lIIllllIll[0];
    }
    
    static {
        lllIlIIlIIl();
    }
    
    private static void lllIlIIlIIl() {
        (lIIllllIll = new String[] { null })[0] = "Multi-argument modifier method";
    }
    
    private static String lllIlIIlIII(String s, final String s2) {
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
