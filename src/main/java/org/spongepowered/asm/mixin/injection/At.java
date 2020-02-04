package org.spongepowered.asm.mixin.injection;

import java.lang.annotation.*;
import java.util.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface At {
    String id() default "";
    
    String value();
    
    String slice() default "";
    
    Shift shift() default Shift.NONE;
    
    int by() default 0;
    
    String[] args() default {};
    
    String target() default "";
    
    int ordinal() default -1;
    
    int opcode() default -1;
    
    boolean remap() default true;
}
