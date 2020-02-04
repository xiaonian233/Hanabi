package org.spongepowered.asm.util;

import java.lang.annotation.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.lib.tree.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import java.nio.charset.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.*;
import java.security.*;

public final class Annotations
{
    private static final String[] lIlIlIllIll;
    
    private Annotations() {
        super();
    }
    
    private static void setVisible(final FieldNode fieldNode, final Class<? extends Annotation> clazz, final Object... array) {
        fieldNode.visibleAnnotations = add(fieldNode.visibleAnnotations, createNode(Type.getDescriptor(clazz), array));
    }
    
    private static void setInvisible(final FieldNode fieldNode, final Class<? extends Annotation> clazz, final Object... array) {
        fieldNode.invisibleAnnotations = add(fieldNode.invisibleAnnotations, createNode(Type.getDescriptor(clazz), array));
    }
    
    public static void setVisible(final MethodNode methodNode, final Class<? extends Annotation> clazz, final Object... array) {
        methodNode.visibleAnnotations = add(methodNode.visibleAnnotations, createNode(Type.getDescriptor(clazz), array));
    }
    
    private static void setInvisible(final MethodNode methodNode, final Class<? extends Annotation> clazz, final Object... array) {
        methodNode.invisibleAnnotations = add(methodNode.invisibleAnnotations, createNode(Type.getDescriptor(clazz), array));
    }
    
    private static AnnotationNode createNode(final String s, final Object... array) {
        final AnnotationNode annotationNode = new AnnotationNode(s);
        for (int i = 0; i < array.length - 1; i += 2) {
            if (!(array[i] instanceof String)) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(Annotations.lIlIlIllIll[0]).append(array[i].getClass().getSimpleName()).append(Annotations.lIlIlIllIll[1]).append(array[i].toString()).append(Annotations.lIlIlIllIll[2]).append(i).append(Annotations.lIlIlIllIll[3]).append(s)));
            }
            annotationNode.visit((String)array[i], array[i + 1]);
        }
        return annotationNode;
    }
    
    private static List<AnnotationNode> add(List<AnnotationNode> list, final AnnotationNode annotationNode) {
        if (list == null) {
            list = new ArrayList<AnnotationNode>(1);
        }
        else {
            final ArrayList<AnnotationNode> list2 = list;
            list2.remove(get(list2, annotationNode.desc));
        }
        list.add(annotationNode);
        return list;
    }
    
    public static AnnotationNode getVisible(final FieldNode fieldNode, final Class<? extends Annotation> clazz) {
        return get(fieldNode.visibleAnnotations, Type.getDescriptor(clazz));
    }
    
    public static AnnotationNode getInvisible(final FieldNode fieldNode, final Class<? extends Annotation> clazz) {
        return get(fieldNode.invisibleAnnotations, Type.getDescriptor(clazz));
    }
    
    public static AnnotationNode getVisible(final MethodNode methodNode, final Class<? extends Annotation> clazz) {
        return get(methodNode.visibleAnnotations, Type.getDescriptor(clazz));
    }
    
    public static AnnotationNode getInvisible(final MethodNode methodNode, final Class<? extends Annotation> clazz) {
        return get(methodNode.invisibleAnnotations, Type.getDescriptor(clazz));
    }
    
    public static AnnotationNode getSingleVisible(final MethodNode methodNode, final Class<? extends Annotation>... array) {
        return getSingle(methodNode.visibleAnnotations, array);
    }
    
    private static AnnotationNode getSingleInvisible(final MethodNode methodNode, final Class<? extends Annotation>... array) {
        return getSingle(methodNode.invisibleAnnotations, array);
    }
    
    public static AnnotationNode getVisible(final ClassNode classNode, final Class<? extends Annotation> clazz) {
        return get(classNode.visibleAnnotations, Type.getDescriptor(clazz));
    }
    
    public static AnnotationNode getInvisible(final ClassNode classNode, final Class<? extends Annotation> clazz) {
        return get(classNode.invisibleAnnotations, Type.getDescriptor(clazz));
    }
    
    private static AnnotationNode getVisibleParameter(final MethodNode methodNode, final Class<? extends Annotation> clazz, final int n) {
        return getParameter(methodNode.visibleParameterAnnotations, Type.getDescriptor(clazz), n);
    }
    
    public static AnnotationNode getInvisibleParameter(final MethodNode methodNode, final Class<? extends Annotation> clazz, final int n) {
        return getParameter(methodNode.invisibleParameterAnnotations, Type.getDescriptor(clazz), n);
    }
    
    private static AnnotationNode getParameter(final List<AnnotationNode>[] array, final String s, final int n) {
        if (array == null || n < 0 || n >= array.length) {
            return null;
        }
        return get(array[n], s);
    }
    
    private static AnnotationNode get(final List<AnnotationNode> list, final String s) {
        if (list == null) {
            return null;
        }
        for (final AnnotationNode annotationNode : list) {
            if (s.equals(annotationNode.desc)) {
                return annotationNode;
            }
        }
        return null;
    }
    
    private static AnnotationNode getSingle(final List<AnnotationNode> list, final Class<? extends Annotation>[] array) {
        final ArrayList<AnnotationNode> list2 = new ArrayList<AnnotationNode>();
        for (int length = array.length, i = 0; i < length; ++i) {
            final AnnotationNode value;
            if ((value = get(list, Type.getDescriptor(array[i]))) != null) {
                list2.add(value);
            }
        }
        final int size;
        if (llllIlIIllIl$255f299(size = list2.size())) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(Annotations.lIlIlIllIll[4]).append(Lists.transform((List)list2, (Function)new Function<AnnotationNode, String>() {
                Annotations$1() {
                    super();
                }
                
                private static String apply(final AnnotationNode annotationNode) {
                    return annotationNode.desc;
                }
                
                public final /* bridge */ Object apply(final Object o) {
                    return ((AnnotationNode)o).desc;
                }
            }))));
        }
        if (size == 0) {
            return null;
        }
        return (AnnotationNode)list2.get(0);
    }
    
    public static <T> T getValue(final AnnotationNode annotationNode) {
        return getValue(annotationNode, Annotations.lIlIlIllIll[5]);
    }
    
    public static <T> T getValue(final AnnotationNode annotationNode, final String s, final T t) {
        final T value;
        if ((value = getValue(annotationNode, s)) != null) {
            return value;
        }
        return t;
    }
    
    public static <T> T getValue(AnnotationNode annotationNode, final String s, final Class<?> clazz) {
        Preconditions.checkNotNull((Object)clazz, (Object)Annotations.lIlIlIllIll[6]);
        if ((annotationNode = getValue(annotationNode, s)) == null) {
            final Class[] array = new Class[0];
            try {
                annotationNode = (AnnotationNode)clazz.getDeclaredMethod(s, (Class[])array).getDefaultValue();
            }
            catch (NoSuchMethodException ex) {}
        }
        return (T)annotationNode;
    }
    
    public static <T> T getValue(final AnnotationNode annotationNode, final String s) {
        int n = 0;
        if (annotationNode == null || annotationNode.values == null) {
            return null;
        }
        for (final T next : annotationNode.values) {
            if (n != 0) {
                return next;
            }
            if (!next.equals(s)) {
                continue;
            }
            n = 1;
        }
        return null;
    }
    
    public static <T extends Enum<T>> T getValue(final AnnotationNode annotationNode, final String s, final Class<T> clazz, final T t) {
        final String[] array;
        if ((array = getValue(annotationNode, s)) == null) {
            return t;
        }
        return toEnumValue(clazz, array);
    }
    
    public static <T> List<T> getValue$3086008b(final AnnotationNode annotationNode, final String s) {
        final T value;
        if ((value = getValue(annotationNode, s)) instanceof List) {
            return (List<T>)value;
        }
        if (value != null) {
            final ArrayList<T> list;
            (list = new ArrayList<T>()).add(value);
            return list;
        }
        return Collections.emptyList();
    }
    
    public static <T extends Enum<T>> List<T> getValue$25538dfc(final AnnotationNode annotationNode, final String s, final Class<T> clazz) {
        final String[] value;
        if ((value = getValue(annotationNode, s)) instanceof List) {
            final ListIterator<String[]> listIterator = ((List<String[]>)(Object)value).listIterator();
            while (listIterator.hasNext()) {
                listIterator.set((String[])(Object)toEnumValue(clazz, listIterator.next()));
            }
            return (List<T>)(Object)value;
        }
        if (value instanceof String[]) {
            final ArrayList<T> list;
            (list = new ArrayList<T>()).add(toEnumValue(clazz, value));
            return list;
        }
        return Collections.emptyList();
    }
    
    private static <T extends Enum<T>> T toEnumValue(final Class<T> clazz, final String[] array) {
        if (!clazz.getName().equals(Type.getType(array[0]).getClassName())) {
            throw new IllegalArgumentException(Annotations.lIlIlIllIll[7]);
        }
        return Enum.valueOf(clazz, array[1]);
    }
    
    static {
        llllIIIIllll();
    }
    
    private static void llllIIIIllll() {
        (lIlIlIllIll = new String[8])[0] = "Annotation keys must be strings, found ";
        Annotations.lIlIlIllIll[1] = " with ";
        Annotations.lIlIlIllIll[2] = " at index ";
        Annotations.lIlIlIllIll[3] = " creating ";
        Annotations.lIlIlIllIll[4] = "Conflicting annotations found: ";
        Annotations.lIlIlIllIll[5] = "value";
        Annotations.lIlIlIllIll[6] = "annotationClass cannot be null";
        Annotations.lIlIlIllIll[7] = "The supplied enum class does not match the stored enum value";
    }
    
    private static String llllIIIIllIl(String s, final String s2) {
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
    
    private static String llllIIIIlllI(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("DES")).init(2, new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), 8), "DES"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static boolean llllIlIIlIll(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean llllIlIIllIl$255f299(final int n) {
        return n > 1;
    }
    
    private static boolean llllIlIIlIlI(final int n) {
        return n >= 0;
    }
}
