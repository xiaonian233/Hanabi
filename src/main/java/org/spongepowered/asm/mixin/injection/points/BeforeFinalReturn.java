package org.spongepowered.asm.mixin.injection.points;

import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.refmap.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.lib.tree.*;
import org.spongepowered.asm.mixin.injection.throwables.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

@AtCode("TAIL")
public class BeforeFinalReturn extends InjectionPoint
{
    private final IMixinContext context;
    private static final String[] lllIIllI;
    
    private BeforeFinalReturn(final InjectionPointData injectionPointData) {
        super(injectionPointData);
        this.context = injectionPointData.context;
    }
    
    @Override
    public final boolean checkPriority(final int n, final int n2) {
        return true;
    }
    
    @Override
    public final boolean find(final String s, final InsnList list, final Collection<AbstractInsnNode> collection) {
        AbstractInsnNode abstractInsnNode = null;
        final int opcode = Type.getReturnType(s).getOpcode(172);
        final ListIterator<AbstractInsnNode> iterator = list.iterator();
        while (iterator.hasNext()) {
            final AbstractInsnNode abstractInsnNode2;
            if ((abstractInsnNode2 = iterator.next()) instanceof InsnNode && abstractInsnNode2.getOpcode() == opcode) {
                abstractInsnNode = abstractInsnNode2;
            }
        }
        if (abstractInsnNode == null) {
            throw new InvalidInjectionException(this.context, BeforeFinalReturn.lllIIllI[0]);
        }
        collection.add(abstractInsnNode);
        return true;
    }
    
    static {
        lIlIIIlIll();
    }
    
    private static void lIlIIIlIll() {
        (lllIIllI = new String[] { null })[0] = "TAIL could not locate a valid RETURN in the target method!";
    }
    
    private static String lIlIIIlIlI(final String s, final String s2) {
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
