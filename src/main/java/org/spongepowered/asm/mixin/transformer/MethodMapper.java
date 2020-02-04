package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.mixin.injection.struct.*;
import com.google.common.base.*;
import org.apache.logging.log4j.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.util.*;
import java.lang.annotation.*;
import org.spongepowered.asm.mixin.gen.*;
import org.spongepowered.asm.lib.tree.*;
import java.util.*;

public final class MethodMapper
{
    private static final Logger logger;
    private static final List<String> classes;
    private static final Map<String, Counter> methods;
    private final ClassInfo info;
    private static final String[] lIIllIIII;
    
    public MethodMapper(final ClassInfo info) {
        super();
        this.info = info;
    }
    
    private ClassInfo getClassInfo() {
        return this.info;
    }
    
    public static void remapHandlerMethod(final MixinInfo mixinInfo, final MethodNode methodNode, final ClassInfo.Method method) {
        if (!(methodNode instanceof MixinInfo.MixinMethodNode) || !((MixinInfo.MixinMethodNode)methodNode).isInjector()) {
            return;
        }
        if (method.isUnique()) {
            MethodMapper.logger.warn(MethodMapper.lIIllIIII[0], new Object[] { method, mixinInfo });
        }
        if (method.isRenamed()) {
            methodNode.name = method.getName();
            return;
        }
        final MixinInfo.MixinMethodNode mixinMethodNode;
        final String injectorPrefix = InjectionInfo.getInjectorPrefix((mixinMethodNode = (MixinInfo.MixinMethodNode)methodNode).getInjectorAnnotation());
        final String classRef = mixinMethodNode.this$0.getClassRef();
        int n;
        if ((n = MethodMapper.classes.indexOf(classRef)) < 0) {
            n = MethodMapper.classes.size();
            MethodMapper.classes.add(classRef);
        }
        final String hexString = Integer.toHexString(n);
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hexString.length(); ++i) {
            final char char1 = hexString.charAt(i);
            final StringBuilder sb2 = sb;
            final char c = char1;
            sb2.append((char)(c + ((c < ':') ? 49 : 10)));
        }
        final String padStart = Strings.padStart(String.valueOf(sb), 3, 'z');
        final String name = mixinMethodNode.name;
        final String desc = mixinMethodNode.desc;
        final boolean b = !mixinMethodNode.isSurrogate();
        final String format = String.format(MethodMapper.lIIllIIII[2], name, desc);
        Counter counter;
        if ((counter = MethodMapper.methods.get(format)) == null) {
            counter = new Counter();
            MethodMapper.methods.put(format, counter);
        }
        else if (b) {
            final Counter counter2 = counter;
            ++counter2.value;
        }
        methodNode.name = method.renameTo(String.format(MethodMapper.lIIllIIII[1], injectorPrefix, mixinMethodNode.name, padStart, String.format(MethodMapper.lIIllIIII[3], counter.value)));
    }
    
    private static String getHandlerName(final MixinInfo.MixinMethodNode mixinMethodNode) {
        final String injectorPrefix = InjectionInfo.getInjectorPrefix(mixinMethodNode.getInjectorAnnotation());
        final String classRef = mixinMethodNode.this$0.getClassRef();
        int n;
        if ((n = MethodMapper.classes.indexOf(classRef)) < 0) {
            n = MethodMapper.classes.size();
            MethodMapper.classes.add(classRef);
        }
        final String hexString = Integer.toHexString(n);
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hexString.length(); ++i) {
            final char char1 = hexString.charAt(i);
            final StringBuilder sb2 = sb;
            final char c = char1;
            sb2.append((char)(c + ((c < ':') ? 49 : 10)));
        }
        final String padStart = Strings.padStart(String.valueOf(sb), 3, 'z');
        final String name = mixinMethodNode.name;
        final String desc = mixinMethodNode.desc;
        final boolean b = !mixinMethodNode.isSurrogate();
        final String format = String.format(MethodMapper.lIIllIIII[2], name, desc);
        Counter counter;
        if ((counter = MethodMapper.methods.get(format)) == null) {
            counter = new Counter();
            MethodMapper.methods.put(format, counter);
        }
        else if (b) {
            final Counter counter2 = counter;
            ++counter2.value;
        }
        return String.format(MethodMapper.lIIllIIII[1], injectorPrefix, mixinMethodNode.name, padStart, String.format(MethodMapper.lIIllIIII[3], counter.value));
    }
    
    private static String getClassUID(final String s) {
        int n;
        if ((n = MethodMapper.classes.indexOf(s)) < 0) {
            n = MethodMapper.classes.size();
            MethodMapper.classes.add(s);
        }
        final String hexString = Integer.toHexString(n);
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hexString.length(); ++i) {
            final char char1 = hexString.charAt(i);
            final StringBuilder sb2 = sb;
            final char c = char1;
            sb2.append((char)(c + ((c < ':') ? 49 : 10)));
        }
        return Strings.padStart(String.valueOf(sb), 3, 'z');
    }
    
    private static String getMethodUID(String format, final String s, final boolean b) {
        format = String.format(MethodMapper.lIIllIIII[2], format, s);
        Counter counter;
        if ((counter = MethodMapper.methods.get(format)) == null) {
            counter = new Counter();
            MethodMapper.methods.put(format, counter);
        }
        else if (b) {
            final Counter counter2 = counter;
            ++counter2.value;
        }
        return String.format(MethodMapper.lIIllIIII[3], counter.value);
    }
    
    private static String finagle(final int n) {
        final String hexString = Integer.toHexString(n);
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hexString.length(); ++i) {
            final char char1 = hexString.charAt(i);
            final StringBuilder sb2 = sb;
            final char c = char1;
            sb2.append((char)(c + ((c < ':') ? 49 : 10)));
        }
        return Strings.padStart(String.valueOf(sb), 3, 'z');
    }
    
    static {
        lllIllIlII();
        logger = LogManager.getLogger(MethodMapper.lIIllIIII[4]);
        classes = new ArrayList<String>();
        methods = new HashMap<String, Counter>();
    }
    
    private static void lllIllIlII() {
        (lIIllIIII = new String[5])[0] = "Redundant @Unique on injector method {} in {}. Injectors are implicitly unique";
        MethodMapper.lIIllIIII[1] = "%s$%s$%s%s";
        MethodMapper.lIIllIIII[2] = "%s%s";
        MethodMapper.lIIllIIII[3] = "%03x";
        MethodMapper.lIIllIIII[4] = "mixin";
    }
    
    private static String llIlIIllII(final String s, final String s2) {
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
    
    private static String llIlIIlIll(String s, final String s2) {
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
    
    private static String lllIllIIIl(final String s, final String s2) {
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
    
    private static boolean llllIlIIll(final int n) {
        return n < 0;
    }
}
