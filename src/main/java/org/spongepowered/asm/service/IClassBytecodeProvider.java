package org.spongepowered.asm.service;

import java.io.*;
import org.spongepowered.asm.lib.tree.*;

public interface IClassBytecodeProvider
{
    byte[] getClassBytes(final String p0, final String p1) throws IOException;
    
    byte[] getClassBytes$44c4d6c8(final String p0) throws ClassNotFoundException, IOException;
    
    ClassNode getClassNode(final String p0) throws ClassNotFoundException, IOException;
}
