package org.spongepowered.asm.launch;

import org.spongepowered.asm.service.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class GlobalProperties
{
    private static IGlobalPropertyService service;
    
    private GlobalProperties() {
        super();
    }
    
    private static IGlobalPropertyService getService() {
        if (GlobalProperties.service == null) {
            GlobalProperties.service = ServiceLoader.load(IGlobalPropertyService.class, GlobalProperties.class.getClassLoader()).iterator().next();
        }
        return GlobalProperties.service;
    }
    
    public static <T> T get(final String s) {
        return getService().getProperty(s);
    }
    
    public static void put(final String s, final Object o) {
        getService().setProperty(s, o);
    }
    
    private static <T> T get(final String s, final T t) {
        return getService().getProperty(s, t);
    }
    
    public static String getString(final String s, final String s2) {
        return getService().getPropertyString(s, s2);
    }
}
