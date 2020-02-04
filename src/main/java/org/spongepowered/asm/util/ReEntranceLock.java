package org.spongepowered.asm.util;

import java.util.*;
import java.nio.charset.*;

public final class ReEntranceLock
{
    private final int maxDepth;
    public int depth;
    public boolean semaphore;
    private static final String[] llllIIll;
    
    public ReEntranceLock() {
        super();
        this.depth = 0;
        this.semaphore = false;
    }
    
    private static int getMaxDepth() {
        return 1;
    }
    
    private int getDepth() {
        return this.depth;
    }
    
    private ReEntranceLock push() {
        ++this.depth;
        this.semaphore |= this.check();
        return this;
    }
    
    public final ReEntranceLock pop() {
        if (this.depth == 0) {
            throw new IllegalStateException(ReEntranceLock.llllIIll[0]);
        }
        --this.depth;
        return this;
    }
    
    public final boolean check() {
        return this.depth > 1;
    }
    
    private boolean checkAndSet() {
        return this.semaphore |= this.check();
    }
    
    private ReEntranceLock set() {
        this.semaphore = true;
        return this;
    }
    
    private boolean isSet() {
        return this.semaphore;
    }
    
    private ReEntranceLock clear() {
        this.semaphore = false;
        return this;
    }
    
    static {
        lIlIlIlllI();
    }
    
    private static void lIlIlIlllI() {
        (llllIIll = new String[] { null })[0] = "ReEntranceLock pop() with zero depth";
    }
    
    private static String lIlIlIllIl(String s, final String s2) {
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
    
    private static boolean lIllIIIllI(final int n, final int n2) {
        return n > n2;
    }
}
