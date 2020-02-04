package ClassSub;

import java.net.*;
import java.io.*;

public final class Class82 implements Class247
{
    public Class82() {
        super();
    }
    
    @Override
    public final URL getResource(String replace) {
        replace = replace.replace('\\', '/');
        return Class5.class.getClassLoader().getResource(replace);
    }
    
    @Override
    public final InputStream getResourceAsStream(String replace) {
        replace = replace.replace('\\', '/');
        return Class5.class.getClassLoader().getResourceAsStream(replace);
    }
}
