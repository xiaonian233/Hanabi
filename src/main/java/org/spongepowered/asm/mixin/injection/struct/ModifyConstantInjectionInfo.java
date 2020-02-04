package org.spongepowered.asm.mixin.injection.struct;

import org.spongepowered.asm.mixin.transformer.*;
import org.spongepowered.asm.lib.tree.*;
import com.google.common.collect.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.mixin.injection.points.*;
import org.spongepowered.asm.mixin.injection.code.*;
import org.spongepowered.asm.mixin.injection.invoke.*;
import com.google.common.base.*;
import org.spongepowered.asm.mixin.injection.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class ModifyConstantInjectionInfo extends InjectionInfo
{
    private static final String CONSTANT_ANNOTATION_CLASS;
    private static final String[] llIIIIlll;
    
    public ModifyConstantInjectionInfo(final MixinTargetContext mixinTargetContext, final MethodNode methodNode, final AnnotationNode annotationNode) {
        super(mixinTargetContext, methodNode, annotationNode, ModifyConstantInjectionInfo.llIIIIlll[0]);
    }
    
    @Override
    protected final List<AnnotationNode> readInjectionPoints(final String s) {
        Object o;
        if (((List)(o = super.readInjectionPoints(s))).isEmpty()) {
            final AnnotationNode annotationNode;
            (annotationNode = new AnnotationNode(ModifyConstantInjectionInfo.CONSTANT_ANNOTATION_CLASS)).visit(ModifyConstantInjectionInfo.llIIIIlll[1], Boolean.TRUE);
            o = ImmutableList.of((Object)annotationNode);
        }
        return (List<AnnotationNode>)o;
    }
    
    @Override
    protected final void parseInjectionPoints(final List<AnnotationNode> list) {
        final Type returnType = Type.getReturnType(this.method.desc);
        final Iterator<AnnotationNode> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.injectionPoints.add(new BeforeConstant(this.getContext(), iterator.next(), returnType.getDescriptor()));
        }
    }
    
    @Override
    protected final Injector parseInjector(final AnnotationNode annotationNode) {
        return new ModifyConstantInjector(this);
    }
    
    @Override
    protected final String getDescription() {
        return ModifyConstantInjectionInfo.llIIIIlll[2];
    }
    
    @Override
    public final String getSliceId(final String s) {
        return Strings.nullToEmpty(s);
    }
    
    static {
        lIIIIIlIllI();
        CONSTANT_ANNOTATION_CLASS = Constant.class.getName().replace('.', '/');
    }
    
    private static void lIIIIIlIllI() {
        (llIIIIlll = new String[3])[0] = "constant";
        ModifyConstantInjectionInfo.llIIIIlll[1] = "log";
        ModifyConstantInjectionInfo.llIIIIlll[2] = "Constant modifier method";
    }
    
    private static String lIIIIIlIlII(String s, final String s2) {
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
    
    private static String lIIIIIlIIll(final String s, final String s2) {
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
    
    private static String lIIIIIlIlIl(final String s, final String s2) {
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
