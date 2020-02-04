package org.spongepowered.asm.service;

import java.net.*;

public interface IClassProvider
{
    URL[] getClassPath();
    
    Class<?> findClass(final String p0) throws ClassNotFoundException;
    
    Class<?> findClass$3555389e(final String p0) throws ClassNotFoundException;
    
    Class<?> findAgentClass$3555389e(final String p0) throws ClassNotFoundException;
}
