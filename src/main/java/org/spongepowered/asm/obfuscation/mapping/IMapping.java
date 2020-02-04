package org.spongepowered.asm.obfuscation.mapping;

import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public interface IMapping<TMapping>
{
    Type getType();
    
    TMapping move$9543ced();
    
    TMapping remap(final String p0);
    
    TMapping transform$9543ced();
    
    TMapping copy();
    
    String getName();
    
    String getSimpleName();
    
    String getOwner();
    
    String getDesc();
    
    TMapping getSuper();
    
    String serialise();
}
