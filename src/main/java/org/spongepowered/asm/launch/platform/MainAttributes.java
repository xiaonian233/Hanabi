package org.spongepowered.asm.launch.platform;

import java.net.*;
import java.io.*;
import java.util.zip.*;
import java.util.jar.*;
import java.util.*;

final class MainAttributes
{
    private static final Map<URI, MainAttributes> instances;
    private Attributes attributes;
    
    private MainAttributes() {
        super();
        this.attributes = new Attributes();
    }
    
    private MainAttributes(final File file) {
        super();
        this.attributes = getAttributes(file);
    }
    
    public final String get(final String s) {
        if (this.attributes != null) {
            return this.attributes.getValue(s);
        }
        return null;
    }
    
    private static Attributes getAttributes(File mainAttributes) {
        if (mainAttributes == null) {
            return null;
        }
        ZipFile zipFile = null;
        try {
            final File file = mainAttributes;
            try {
                final Manifest manifest;
                if ((manifest = ((JarFile)(zipFile = new JarFile(file))).getManifest()) != null) {
                    mainAttributes = (File)manifest.getMainAttributes();
                    try {
                        zipFile.close();
                    }
                    catch (IOException ex) {}
                    return (Attributes)mainAttributes;
                }
                try {
                    zipFile.close();
                }
                catch (IOException ex2) {}
                return new Attributes();
            }
            catch (IOException ex3) {}
        }
        finally {
            final ZipFile zipFile2 = zipFile;
            try {
                if (zipFile2 != null) {
                    zipFile.close();
                }
            }
            catch (IOException ex4) {}
        }
        return new Attributes();
    }
    
    private static MainAttributes of(final File file) {
        return of(file.toURI());
    }
    
    public static MainAttributes of(final URI uri) {
        MainAttributes mainAttributes;
        if ((mainAttributes = MainAttributes.instances.get(uri)) == null) {
            mainAttributes = new MainAttributes(new File(uri));
            MainAttributes.instances.put(uri, mainAttributes);
        }
        return mainAttributes;
    }
    
    static {
        instances = new HashMap<URI, MainAttributes>();
    }
}
