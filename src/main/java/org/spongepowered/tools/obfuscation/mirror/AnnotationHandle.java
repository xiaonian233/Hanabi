package org.spongepowered.tools.obfuscation.mirror;

import com.google.common.collect.*;
import java.lang.annotation.*;
import javax.lang.model.element.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class AnnotationHandle
{
    public static final AnnotationHandle MISSING;
    public final AnnotationMirror annotation;
    public static final String[] lIIIlllIIl;
    
    private AnnotationHandle(final AnnotationMirror annotation) {
        super();
        this.annotation = annotation;
    }
    
    private AnnotationMirror asMirror() {
        return this.annotation;
    }
    
    public final boolean exists() {
        return this.annotation != null;
    }
    
    @Override
    public final String toString() {
        if (this.annotation == null) {
            return AnnotationHandle.lIIIlllIIl[0];
        }
        return String.valueOf(new StringBuilder().append(AnnotationHandle.lIIIlllIIl[1]).append((Object)this.annotation.getAnnotationType().asElement().getSimpleName()));
    }
    
    public final <T> T getValue(final String s, final T t) {
        if (this.annotation == null) {
            return t;
        }
        final Iterator<? extends ExecutableElement> iterator = this.annotation.getElementValues().keySet().iterator();
        while (true) {
            while (iterator.hasNext()) {
                final ExecutableElement executableElement;
                if ((executableElement = (ExecutableElement)iterator.next()).getSimpleName().contentEquals(s)) {
                    final AnnotationValue annotationValue = (AnnotationValue)this.annotation.getElementValues().get(executableElement);
                    final AnnotationValue annotationValue2 = annotationValue;
                    if (t instanceof Enum && annotationValue2 != null) {
                        final VariableElement variableElement;
                        if ((variableElement = (VariableElement)annotationValue2.getValue()) == null) {
                            return t;
                        }
                        return Enum.valueOf(t.getClass(), variableElement.getSimpleName().toString());
                    }
                    else {
                        if (annotationValue2 != null) {
                            return (T)annotationValue2.getValue();
                        }
                        return t;
                    }
                }
            }
            final AnnotationValue annotationValue = null;
            continue;
        }
    }
    
    public final <T> T getValue() {
        return this.getValue(AnnotationHandle.lIIIlllIIl[2], (T)null);
    }
    
    private <T> T getValue(final String s) {
        return this.getValue(s, (T)null);
    }
    
    public final boolean getBoolean(final String s, final boolean b) {
        return this.getValue(s, b);
    }
    
    public final AnnotationHandle getAnnotation(final String s) {
        final AnnotationMirror value;
        if ((value = this.getValue(s, (AnnotationMirror)null)) instanceof AnnotationMirror) {
            return of(value);
        }
        final Object value2;
        if (value instanceof AnnotationValue && (value2 = ((AnnotationValue)value).getValue()) instanceof AnnotationMirror) {
            return of((AnnotationMirror)value2);
        }
        return null;
    }
    
    private <T> List<T> getList() {
        return this.getList(AnnotationHandle.lIIIlllIIl[3]);
    }
    
    public final <T> List<T> getList(final String s) {
        return unwrapAnnotationValueList(this.getValue(s, Collections.emptyList()));
    }
    
    public final List<AnnotationHandle> getAnnotationList(final String s) {
        final AnnotationMirror value;
        if ((value = this.getValue(s, (AnnotationMirror)null)) == null) {
            return Collections.emptyList();
        }
        if (value instanceof AnnotationMirror) {
            return (List<AnnotationHandle>)ImmutableList.of((Object)of(value));
        }
        final List<AnnotationValue> list = (List<AnnotationValue>)value;
        final ArrayList list2 = new ArrayList<AnnotationHandle>(list.size());
        final Iterator<AnnotationValue> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(new AnnotationHandle((AnnotationMirror)iterator.next().getValue()));
        }
        return Collections.unmodifiableList((List<? extends AnnotationHandle>)list2);
    }
    
    private AnnotationValue getAnnotationValue(final String s) {
        final Iterator<? extends ExecutableElement> iterator = this.annotation.getElementValues().keySet().iterator();
        while (iterator.hasNext()) {
            final ExecutableElement executableElement;
            if ((executableElement = (ExecutableElement)iterator.next()).getSimpleName().contentEquals(s)) {
                return (AnnotationValue)this.annotation.getElementValues().get(executableElement);
            }
        }
        return null;
    }
    
    private static <T> List<T> unwrapAnnotationValueList(final List<AnnotationValue> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        final ArrayList<T> list2 = new ArrayList<T>(list.size());
        final Iterator<AnnotationValue> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add((T)iterator.next().getValue());
        }
        return list2;
    }
    
    private static AnnotationMirror getAnnotation(final Element element, final Class<? extends Annotation> clazz) {
        if (element == null) {
            return null;
        }
        final List<? extends AnnotationMirror> annotationMirrors;
        if ((annotationMirrors = element.getAnnotationMirrors()) == null) {
            return null;
        }
        final Iterator<? extends AnnotationMirror> iterator = annotationMirrors.iterator();
        while (iterator.hasNext()) {
            final AnnotationMirror annotationMirror;
            final Element element2;
            if ((element2 = (annotationMirror = (AnnotationMirror)iterator.next()).getAnnotationType().asElement()) instanceof TypeElement) {
                if (((TypeElement)element2).getQualifiedName().contentEquals(clazz.getName())) {
                    return annotationMirror;
                }
                continue;
            }
        }
        return null;
    }
    
    private static AnnotationHandle of(final AnnotationMirror annotationMirror) {
        return new AnnotationHandle(annotationMirror);
    }
    
    public static AnnotationHandle of(final Element element, final Class<? extends Annotation> clazz) {
        return new AnnotationHandle(getAnnotation(element, clazz));
    }
    
    static {
        llIlIIIIlIl();
        MISSING = new AnnotationHandle(null);
    }
    
    private static void llIlIIIIlIl() {
        (lIIIlllIIl = new String[4])[0] = "@{UnknownAnnotation}";
        AnnotationHandle.lIIIlllIIl[1] = "@";
        AnnotationHandle.lIIIlllIIl[2] = "value";
        AnnotationHandle.lIIIlllIIl[3] = "value";
    }
    
    private static String llIIllllIlI(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("Blowfish")).init(2, new SecretKeySpec(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), "Blowfish"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String llIlIIIIIll(String s, final String s2) {
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
}
