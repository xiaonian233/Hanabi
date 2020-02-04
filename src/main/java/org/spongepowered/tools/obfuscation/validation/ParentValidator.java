package org.spongepowered.tools.obfuscation.validation;

import org.spongepowered.tools.obfuscation.*;
import org.spongepowered.tools.obfuscation.interfaces.*;
import org.spongepowered.tools.obfuscation.mirror.*;
import javax.lang.model.element.*;
import java.util.*;
import java.nio.charset.*;

public final class ParentValidator extends MixinValidator
{
    private static final String[] lIlIllIIIII;
    
    public ParentValidator(final IMixinAnnotationProcessor mixinAnnotationProcessor) {
        super(mixinAnnotationProcessor, IMixinValidator.ValidationPass.EARLY);
    }
    
    public final boolean validate$47e13afc(final TypeElement typeElement, final Collection<TypeHandle> collection) {
        if (typeElement.getEnclosingElement().getKind() != ElementKind.PACKAGE && !typeElement.getModifiers().contains(Modifier.STATIC)) {
            this.error(ParentValidator.lIlIllIIIII[0], typeElement);
        }
        return true;
    }
    
    static {
        llllIIIllIll();
    }
    
    private static void llllIIIllIll() {
        (lIlIllIIIII = new String[] { null })[0] = "Inner class mixin must be declared static";
    }
    
    private static String llllIIIllIlI(String s, final String s2) {
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
    
    private static boolean llllIlIIIIll(final Object o, final Object o2) {
        return o != o2;
    }
}
