package org.spongepowered.asm.mixin.injection.code;

import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.mixin.injection.throwables.*;
import org.spongepowered.asm.util.*;
import org.spongepowered.asm.lib.tree.*;
import java.util.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

public final class MethodSlices
{
    private final InjectionInfo info;
    public final Map<String, MethodSlice> slices;
    private static final String[] lllllIllll;
    
    private MethodSlices(final InjectionInfo info) {
        super();
        this.slices = new HashMap<String, MethodSlice>(4);
        this.info = info;
    }
    
    private void add(final MethodSlice methodSlice) {
        final String sliceId = this.info.getSliceId(methodSlice.id);
        if (this.slices.containsKey(sliceId)) {
            throw new InvalidSliceException((ISliceContext)this.info, String.valueOf(new StringBuilder().append(methodSlice).append(MethodSlices.lllllIllll[0]).append(sliceId).append(MethodSlices.lllllIllll[1])));
        }
        this.slices.put(sliceId, methodSlice);
    }
    
    private MethodSlice get(final String s) {
        return this.slices.get(s);
    }
    
    @Override
    public final String toString() {
        return String.format(MethodSlices.lllllIllll[2], this.slices.keySet());
    }
    
    public static MethodSlices parse(final InjectionInfo injectionInfo) {
        final MethodSlices methodSlices = new MethodSlices(injectionInfo);
        final AnnotationNode annotation;
        if ((annotation = injectionInfo.getAnnotation()) != null) {
            final Iterator<AnnotationNode> iterator = Annotations.getValue$3086008b(annotation, MethodSlices.lllllIllll[3]).iterator();
            while (iterator.hasNext()) {
                final MethodSlice parse = MethodSlice.parse(injectionInfo, iterator.next());
                final MethodSlices methodSlices2 = methodSlices;
                final MethodSlice methodSlice = parse;
                final MethodSlices methodSlices3 = methodSlices2;
                final String sliceId = methodSlices2.info.getSliceId(methodSlice.id);
                if (methodSlices3.slices.containsKey(sliceId)) {
                    throw new InvalidSliceException((ISliceContext)methodSlices3.info, String.valueOf(new StringBuilder().append(methodSlice).append(MethodSlices.lllllIllll[0]).append(sliceId).append(MethodSlices.lllllIllll[1])));
                }
                methodSlices3.slices.put(sliceId, methodSlice);
            }
        }
        return methodSlices;
    }
    
    static {
        lIllIllIIIIl();
    }
    
    private static void lIllIllIIIIl() {
        (lllllIllll = new String[4])[0] = " has a duplicate id, '";
        MethodSlices.lllllIllll[1] = "' was already defined";
        MethodSlices.lllllIllll[2] = "MethodSlices%s";
        MethodSlices.lllllIllll[3] = "slice";
    }
    
    private static String lIllIlIlIIII(String s, final String s2) {
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
    
    private static String lIllIlIIlllI(final String s, final String s2) {
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
