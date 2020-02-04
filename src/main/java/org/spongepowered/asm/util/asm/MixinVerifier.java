package org.spongepowered.asm.util.asm;

import org.spongepowered.asm.lib.tree.analysis.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.mixin.transformer.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class MixinVerifier extends SimpleVerifier
{
    private Type currentClass;
    private Type currentSuperClass;
    private List<Type> currentClassInterfaces;
    private boolean isInterface;
    private static final String[] lIlIIlIIlI;
    
    public MixinVerifier(final Type currentClass, final Type currentSuperClass, final List<Type> currentClassInterfaces) {
        super(currentClass, currentSuperClass, currentClassInterfaces, false);
        this.currentClass = currentClass;
        this.currentSuperClass = currentSuperClass;
        this.currentClassInterfaces = currentClassInterfaces;
    }
    
    public final boolean isInterface(final Type type) {
        return (this.currentClass == null || !type.equals(this.currentClass)) && ClassInfo.forType(type).isInterface;
    }
    
    public final Type getSuperClass(final Type type) {
        if (this.currentClass != null && type.equals(this.currentClass)) {
            return this.currentSuperClass;
        }
        final ClassInfo superClass;
        if ((superClass = ClassInfo.forType(type).getSuperClass()) == null) {
            return null;
        }
        return Type.getType(String.valueOf(new StringBuilder().append(MixinVerifier.lIlIIlIIlI[0]).append(superClass.name).append(MixinVerifier.lIlIIlIIlI[1])));
    }
    
    public final boolean isAssignableFrom(Type type, Type superClass) {
        while (!type.equals(superClass)) {
            if (this.currentClass != null && type.equals(this.currentClass)) {
                if (this.getSuperClass(superClass) == null) {
                    return false;
                }
                final MixinVerifier mixinVerifier = this;
                final Type type2 = type;
                superClass = this.getSuperClass(superClass);
                type = type2;
                this = mixinVerifier;
            }
            else if (this.currentClass != null && superClass.equals(this.currentClass)) {
                if (this.isAssignableFrom(type, this.currentSuperClass)) {
                    return true;
                }
                if (this.currentClassInterfaces != null) {
                    for (int i = 0; i < this.currentClassInterfaces.size(); ++i) {
                        superClass = this.currentClassInterfaces.get(i);
                        if (this.isAssignableFrom(type, superClass)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            else {
                ClassInfo classInfo;
                if ((classInfo = ClassInfo.forType(type)) == null) {
                    return false;
                }
                if (classInfo.isInterface) {
                    classInfo = ClassInfo.forName(MixinVerifier.lIlIIlIIlI[2]);
                }
                return ClassInfo.forType(superClass).hasSuperClass(classInfo);
            }
        }
        return true;
    }
    
    static {
        llllIIIllII();
    }
    
    private static void llllIIIllII() {
        (lIlIIlIIlI = new String[3])[0] = "L";
        MixinVerifier.lIlIIlIIlI[1] = ";";
        MixinVerifier.lIlIIlIIlI[2] = "java/lang/Object";
    }
    
    private static String llllIIIlIlI(final String s, final String s2) {
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
    
    private static String llllIIIlIll(String s, final String s2) {
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
    
    private static boolean llllIIlllIl$255f299(final int n) {
        return n != 10;
    }
}
