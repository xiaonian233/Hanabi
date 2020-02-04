package org.spongepowered.asm.mixin.injection.points;

import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.lib.tree.*;
import org.spongepowered.asm.util.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

@AtCode("FIELD")
public class BeforeFieldAccess extends BeforeInvoke
{
    private static final String ARRAY_GET;
    private static final String ARRAY_SET;
    private static final String ARRAY_LENGTH;
    private static int ARRAY_SEARCH_FUZZ_DEFAULT;
    private final int opcode;
    public final int arrOpcode;
    public final int fuzzFactor;
    private static final String[] lIIIIIIIlII;
    
    private BeforeFieldAccess(final InjectionPointData injectionPointData) {
        super(injectionPointData);
        this.opcode = injectionPointData.getOpcode$487101af(180, 181, 178, 179, -1);
        final String value = injectionPointData.get(BeforeFieldAccess.lIIIIIIIlII[0], BeforeFieldAccess.lIIIIIIIlII[1]);
        this.arrOpcode = (BeforeFieldAccess.lIIIIIIIlII[2].equalsIgnoreCase(value) ? 46 : (BeforeFieldAccess.lIIIIIIIlII[3].equalsIgnoreCase(value) ? 79 : (BeforeFieldAccess.lIIIIIIIlII[4].equalsIgnoreCase(value) ? 190 : 0)));
        this.fuzzFactor = Math.min(Math.max(InjectionPointData.parseInt$505cff29(injectionPointData.get(BeforeFieldAccess.lIIIIIIIlII[5], "8")), 1), 32);
    }
    
    private int getFuzzFactor() {
        return this.fuzzFactor;
    }
    
    private int getArrayOpcode() {
        return this.arrOpcode;
    }
    
    private int getArrayOpcode(final String s) {
        if (lIlllIlIIllI(this.arrOpcode, 190)) {
            return Type.getType(s).getElementType().getOpcode(this.arrOpcode);
        }
        return this.arrOpcode;
    }
    
    @Override
    protected final boolean matchesInsn(final AbstractInsnNode abstractInsnNode) {
        return abstractInsnNode instanceof FieldInsnNode && (!lIlllIlIIllI(((FieldInsnNode)abstractInsnNode).getOpcode(), this.opcode) || this.opcode == -1) && (this.arrOpcode == 0 || ((!lIlllIlIIllI(abstractInsnNode.getOpcode(), 178) || !lIlllIlIIllI(abstractInsnNode.getOpcode(), 180)) && Type.getType(((FieldInsnNode)abstractInsnNode).desc).sort == 9));
    }
    
    @Override
    protected final boolean addInsn(final InsnList list, final Collection<AbstractInsnNode> collection, final AbstractInsnNode abstractInsnNode) {
        if (this.arrOpcode > 0) {
            final FieldInsnNode fieldInsnNode = (FieldInsnNode)abstractInsnNode;
            final String desc = fieldInsnNode.desc;
            final int n = lIlllIlIIllI(this.arrOpcode, 190) ? Type.getType(desc).getElementType().getOpcode(this.arrOpcode) : this.arrOpcode;
            this.log(BeforeFieldAccess.lIIIIIIIlII[6], this.className, Bytecode.getOpcodeName(n), this.fuzzFactor);
            if (findArrayNode(list, fieldInsnNode, n, this.fuzzFactor) == null) {
                this.log(BeforeFieldAccess.lIIIIIIIlII[7], this.className);
                return false;
            }
        }
        this.log(BeforeFieldAccess.lIIIIIIIlII[8], this.className);
        return super.addInsn(list, collection, abstractInsnNode);
    }
    
    public static AbstractInsnNode findArrayNode(final InsnList list, final FieldInsnNode fieldInsnNode, final int n, final int n2) {
        int n3 = 0;
        final ListIterator<AbstractInsnNode> iterator = list.iterator(list.indexOf(fieldInsnNode) + 1);
        while (iterator.hasNext()) {
            final AbstractInsnNode abstractInsnNode;
            if ((abstractInsnNode = iterator.next()).getOpcode() == n) {
                return abstractInsnNode;
            }
            if (abstractInsnNode.getOpcode() == 190 && n3 == 0) {
                return null;
            }
            final FieldInsnNode fieldInsnNode2;
            if (abstractInsnNode instanceof FieldInsnNode && (fieldInsnNode2 = (FieldInsnNode)abstractInsnNode).desc.equals(fieldInsnNode.desc) && fieldInsnNode2.name.equals(fieldInsnNode.name) && fieldInsnNode2.owner.equals(fieldInsnNode.owner)) {
                return null;
            }
            if (n3++ > n2) {
                return null;
            }
        }
        return null;
    }
    
    static {
        lIlllIIlllll();
    }
    
    private static void lIlllIIlllll() {
        (lIIIIIIIlII = new String[12])[0] = "array";
        BeforeFieldAccess.lIIIIIIIlII[1] = "";
        BeforeFieldAccess.lIIIIIIIlII[2] = "get";
        BeforeFieldAccess.lIIIIIIIlII[3] = "set";
        BeforeFieldAccess.lIIIIIIIlII[4] = "length";
        BeforeFieldAccess.lIIIIIIIlII[5] = "fuzz";
        BeforeFieldAccess.lIIIIIIIlII[6] = "{} > > > > searching for array access opcode {} fuzz={}";
        BeforeFieldAccess.lIIIIIIIlII[7] = "{} > > > > > failed to locate matching insn";
        BeforeFieldAccess.lIIIIIIIlII[8] = "{} > > > > > adding matching insn";
        BeforeFieldAccess.lIIIIIIIlII[9] = "length";
        BeforeFieldAccess.lIIIIIIIlII[10] = "set";
        BeforeFieldAccess.lIIIIIIIlII[11] = "get";
    }
    
    private static String lIlllIIlllIl(String s, final String s2) {
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
    
    private static String lIlllIIllllI(final String s, final String s2) {
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
    
    private static String lIlllIIlllII(final String s, final String s2) {
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
    
    private static boolean lIlllIlIlIll(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIlllIlIlIIl(final int n) {
        return n > 0;
    }
    
    private static boolean lIlllIlIIllI(final int n, final int n2) {
        return n != n2;
    }
}
