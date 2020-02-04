package org.spongepowered.asm.mixin.injection.callback;

import org.spongepowered.asm.lib.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public class CallbackInfoReturnable<R> extends CallbackInfo
{
    private R returnValue;
    private static final String[] lIIIIIIlll;
    
    private CallbackInfoReturnable(final String s, final boolean b) {
        super(s, b);
        this.returnValue = null;
    }
    
    private CallbackInfoReturnable(final String s, final boolean b, final R returnValue) {
        super(s, b);
        this.returnValue = returnValue;
    }
    
    private CallbackInfoReturnable(final String s, final boolean b, final byte b2) {
        super(s, b);
        this.returnValue = (R)b2;
    }
    
    private CallbackInfoReturnable(final String s, final boolean b, final char c) {
        super(s, b);
        this.returnValue = (R)c;
    }
    
    private CallbackInfoReturnable(final String s, final boolean b, final double n) {
        super(s, b);
        this.returnValue = (R)n;
    }
    
    private CallbackInfoReturnable(final String s, final boolean b, final float n) {
        super(s, b);
        this.returnValue = (R)n;
    }
    
    private CallbackInfoReturnable(final String s, final boolean b, final int n) {
        super(s, b);
        this.returnValue = (R)n;
    }
    
    private CallbackInfoReturnable(final String s, final boolean b, final long n) {
        super(s, b);
        this.returnValue = (R)n;
    }
    
    private CallbackInfoReturnable(final String s, final boolean b, final short n) {
        super(s, b);
        this.returnValue = (R)n;
    }
    
    private CallbackInfoReturnable(final String s, final boolean b, final boolean b2) {
        super(s, b);
        this.returnValue = (R)b2;
    }
    
    private void setReturnValue(final R returnValue) throws CancellationException {
        super.cancel();
        this.returnValue = returnValue;
    }
    
    private R getReturnValue() {
        return this.returnValue;
    }
    
    private byte getReturnValueB() {
        if (this.returnValue == null) {
            return 0;
        }
        return (byte)this.returnValue;
    }
    
    private char getReturnValueC() {
        if (this.returnValue == null) {
            return '\0';
        }
        return (char)this.returnValue;
    }
    
    private double getReturnValueD() {
        if (this.returnValue == null) {
            return 0.0;
        }
        return (double)this.returnValue;
    }
    
    private float getReturnValueF() {
        if (this.returnValue == null) {
            return 0.0f;
        }
        return (float)this.returnValue;
    }
    
    private int getReturnValueI() {
        if (this.returnValue == null) {
            return 0;
        }
        return (int)this.returnValue;
    }
    
    private long getReturnValueJ() {
        if (this.returnValue == null) {
            return 0L;
        }
        return (long)this.returnValue;
    }
    
    private short getReturnValueS() {
        if (this.returnValue == null) {
            return 0;
        }
        return (short)this.returnValue;
    }
    
    private boolean getReturnValueZ() {
        return this.returnValue != null && (boolean)this.returnValue;
    }
    
    static String getReturnAccessor(final Type type) {
        if (!lIllllIllII$255f299(type.sort) || type.sort == 9) {
            return CallbackInfoReturnable.lIIIIIIlll[0];
        }
        return String.format(CallbackInfoReturnable.lIIIIIIlll[1], type.getDescriptor());
    }
    
    static String getReturnDescriptor(final Type type) {
        if (!lIllllIllII$255f299(type.sort) || type.sort == 9) {
            return String.format(CallbackInfoReturnable.lIIIIIIlll[2], CallbackInfoReturnable.lIIIIIIlll[3]);
        }
        return String.format(CallbackInfoReturnable.lIIIIIIlll[4], type.getDescriptor());
    }
    
    static {
        lIlllIllIlI();
    }
    
    private static void lIlllIllIlI() {
        (lIIIIIIlll = new String[5])[0] = "getReturnValue";
        CallbackInfoReturnable.lIIIIIIlll[1] = "getReturnValue%s";
        CallbackInfoReturnable.lIIIIIIlll[2] = "()%s";
        CallbackInfoReturnable.lIIIIIIlll[3] = "Ljava/lang/Object;";
        CallbackInfoReturnable.lIIIIIIlll[4] = "()%s";
    }
    
    private static String lIlllIlIIll(final String s, final String s2) {
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
    
    private static String lIlllIlIllI(final String s, final String s2) {
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
    
    private static String lIlllIlIIlI(String s, final String s2) {
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
    
    private static boolean lIllllIllII$255f299(final int n) {
        return n != 10;
    }
}
