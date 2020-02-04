package com.darkmagician6.eventapi.types;

import org.jetbrains.annotations.*;

public final class Priority
{
    private static byte HIGHEST;
    private static byte HIGH;
    private static byte MEDIUM;
    private static byte LOW;
    private static byte LOWEST;
    @NotNull
    public static final byte[] VALUE_ARRAY;
    
    public Priority() {
        super();
    }
    
    static {
        VALUE_ARRAY = new byte[] { 0, 1, 2, 3, 4 };
    }
}
