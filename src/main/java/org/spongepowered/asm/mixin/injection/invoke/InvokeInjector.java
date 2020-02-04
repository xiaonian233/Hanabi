package org.spongepowered.asm.mixin.injection.invoke;

import org.spongepowered.asm.mixin.injection.code.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.throwables.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.mixin.transformer.*;
import org.spongepowered.asm.util.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.lib.tree.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public abstract class InvokeInjector extends Injector
{
    protected final String annotationType;
    private static final String[] lIllIIIlIII;
    
    public InvokeInjector(final InjectionInfo injectionInfo, final String annotationType) {
        super(injectionInfo);
        this.annotationType = annotationType;
    }
    
    @Override
    public void sanityCheck(final Target target, final List<InjectionPoint> list) {
        super.sanityCheck(target, list);
        this.checkTarget(target);
    }
    
    protected void checkTarget(final Target target) {
        this.checkTargetModifiers(target, true);
    }
    
    protected final void checkTargetModifiers(final Target target, final boolean b) {
        if (b && target.isStatic != this.isStatic) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(InvokeInjector.lIllIIIlIII[0]).append(this)));
        }
        if (!b && !this.isStatic && target.isStatic) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(InvokeInjector.lIllIIIlIII[1]).append(this).append(InvokeInjector.lIllIIIlIII[2])));
        }
    }
    
    protected final void checkTargetForNode(final Target target, final InjectionNodes.InjectionNode injectionNode) {
        if (!target.isCtor || target.indexOf(injectionNode.currentTarget) > target.indexOf(target.isCtor ? Bytecode.findSuperInit(target.method, ClassInfo.forName(target.classNode.name).superName) : null)) {
            this.checkTargetModifiers(target, true);
            return;
        }
        if (!this.isStatic) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(InvokeInjector.lIllIIIlIII[3]).append(this.annotationType).append(InvokeInjector.lIllIIIlIII[4]).append(this)));
        }
    }
    
    public void inject(final Target target, final InjectionNodes.InjectionNode injectionNode) {
        if (!(injectionNode.currentTarget instanceof MethodInsnNode)) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(this.annotationType).append(InvokeInjector.lIllIIIlIII[5]).append(target).append(InvokeInjector.lIllIIIlIII[6]).append(this)));
        }
        this.injectAtInvoke(target, injectionNode);
    }
    
    protected abstract void injectAtInvoke(final Target p0, final InjectionNodes.InjectionNode p1);
    
    protected final AbstractInsnNode invokeHandlerWithArgs(final Type[] array, final InsnList list, final int[] array2) {
        return this.invokeHandlerWithArgs(array, list, array2, 0, array.length);
    }
    
    protected final AbstractInsnNode invokeHandlerWithArgs(final Type[] array, final InsnList list, final int[] array2, final int n, final int n2) {
        if (!this.isStatic) {
            list.add(new VarInsnNode(25, 0));
        }
        pushArgs(array, list, array2, n, n2);
        return this.invokeHandler(list);
    }
    
    protected static int[] storeArgs(Target target, final Type[] array, final InsnList list, final int n) {
        final Target target2 = target;
        int i = n;
        target = target2;
        if (target2.argMapVars == null) {
            target.argMapVars = new ArrayList<Integer>();
        }
        final int[] array2 = new int[array.length];
        int n2 = 0;
        while (i < array.length) {
            final int size = array[i].getSize();
            array2[i] = target.allocateArgMapLocal(n2, size);
            n2 += size;
            ++i;
        }
        final int[] array3 = array2;
        storeArgs(array, list, array3, n, array.length);
        return array3;
    }
    
    private static void storeArgs(final Type[] array, final InsnList list, final int[] array2, final int n, int i) {
        --i;
        while (i >= n) {
            list.add(new VarInsnNode(array[i].getOpcode(54), array2[i]));
            --i;
        }
    }
    
    protected static void pushArgs(final Type[] array, final InsnList list, final int[] array2, int i, final int n) {
        while (i < n) {
            list.add(new VarInsnNode(array[i].getOpcode(21), array2[i]));
            ++i;
        }
    }
    
    static {
        llllIllIIIll();
    }
    
    private static void llllIllIIIll() {
        (lIllIIIlIII = new String[7])[0] = "'static' modifier of handler method does not match target in ";
        InvokeInjector.lIllIIIlIII[1] = "non-static callback method ";
        InvokeInjector.lIllIIIlIII[2] = " targets a static method which is not supported";
        InvokeInjector.lIllIIIlIII[3] = "Pre-super ";
        InvokeInjector.lIllIIIlIII[4] = " invocation must be static in ";
        InvokeInjector.lIllIIIlIII[5] = " annotation on is targetting a non-method insn in ";
        InvokeInjector.lIllIIIlIII[6] = " in ";
    }
    
    private static String llllIllIIIII(final String s, final String s2) {
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
    
    private static String llllIllIIIlI(String s, final String s2) {
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
    
    private static boolean llllIlllIllI(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean llllIlllIlIl(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean llllIlllIIll(final int n, final int n2) {
        return n != n2;
    }
}
