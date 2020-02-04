package org.spongepowered.asm.lib;

import java.lang.reflect.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class Type
{
    private static int VOID;
    private static int BOOLEAN;
    private static int CHAR;
    private static int BYTE;
    private static int SHORT;
    private static int INT;
    private static int FLOAT;
    private static int LONG;
    private static int DOUBLE;
    private static int ARRAY;
    private static int OBJECT;
    private static int METHOD;
    public static final Type VOID_TYPE;
    private static Type BOOLEAN_TYPE;
    private static Type CHAR_TYPE;
    private static Type BYTE_TYPE;
    private static Type SHORT_TYPE;
    public static final Type INT_TYPE;
    public static final Type FLOAT_TYPE;
    public static final Type LONG_TYPE;
    public static final Type DOUBLE_TYPE;
    public final int sort;
    private final char[] buf;
    private final int off;
    private final int len;
    private static final String[] lIIIlIIIlI;
    
    private Type(final int sort, final char[] buf, final int off, final int len) {
        super();
        this.sort = sort;
        this.buf = buf;
        this.off = off;
        this.len = len;
    }
    
    public static Type getType(final String s) {
        return getType(s.toCharArray(), 0);
    }
    
    public static Type getObjectType(final String s) {
        final char[] charArray = s.toCharArray();
        return new Type((charArray[0] == '[') ? 9 : 10, charArray, 0, charArray.length);
    }
    
    public static Type getMethodType(final String s) {
        return getType(s.toCharArray(), 0);
    }
    
    private static Type getMethodType(final Type type, final Type... array) {
        final StringBuilder sb;
        (sb = new StringBuilder()).append('(');
        for (int i = 0; i < array.length; ++i) {
            array[i].getDescriptor(sb);
        }
        sb.append(')');
        type.getDescriptor(sb);
        return getType(String.valueOf(sb));
    }
    
    public static Type getType(final Class<?> clazz) {
        if (!clazz.isPrimitive()) {
            return getType(getDescriptor(clazz));
        }
        if (llIIlIlIllI(clazz, Integer.TYPE)) {
            return Type.INT_TYPE;
        }
        if (llIIlIlIllI(clazz, Void.TYPE)) {
            return Type.VOID_TYPE;
        }
        if (llIIlIlIllI(clazz, Boolean.TYPE)) {
            return Type.BOOLEAN_TYPE;
        }
        if (llIIlIlIllI(clazz, Byte.TYPE)) {
            return Type.BYTE_TYPE;
        }
        if (llIIlIlIllI(clazz, Character.TYPE)) {
            return Type.CHAR_TYPE;
        }
        if (llIIlIlIllI(clazz, Short.TYPE)) {
            return Type.SHORT_TYPE;
        }
        if (llIIlIlIllI(clazz, Double.TYPE)) {
            return Type.DOUBLE_TYPE;
        }
        if (llIIlIlIllI(clazz, Float.TYPE)) {
            return Type.FLOAT_TYPE;
        }
        return Type.LONG_TYPE;
    }
    
    private static Type getType(final Constructor<?> constructor) {
        final Class<?>[] parameterTypes = (Class<?>[])constructor.getParameterTypes();
        final StringBuilder sb;
        (sb = new StringBuilder()).append('(');
        for (int i = 0; i < parameterTypes.length; ++i) {
            getDescriptor(sb, parameterTypes[i]);
        }
        return getType(String.valueOf(sb.append(Type.lIIIlIIIlI[10])));
    }
    
    private static Type getType(final Method method) {
        final Class<?>[] parameterTypes = method.getParameterTypes();
        final StringBuilder sb;
        (sb = new StringBuilder()).append('(');
        for (int i = 0; i < parameterTypes.length; ++i) {
            getDescriptor(sb, parameterTypes[i]);
        }
        sb.append(')');
        getDescriptor(sb, method.getReturnType());
        return getType(String.valueOf(sb));
    }
    
    public static Type[] getArgumentTypes(final String s) {
        final char[] charArray = s.toCharArray();
        int n = 1;
        int n2 = 0;
        char c;
        while ((c = charArray[n++]) != ')') {
            if (c == 'L') {
                while (llIIlIlIlll(charArray[n++], 59)) {}
                ++n2;
            }
            else {
                if (!llIIlIlIlll(c, 91)) {
                    continue;
                }
                ++n2;
            }
        }
        final Type[] array = new Type[n2];
        for (int n3 = 1, n4 = 0; llIIlIlIlll(charArray[n3], 41); n3 += array[n4].len + ((array[n4].sort == 10) ? 2 : 0), ++n4) {
            array[n4] = getType(charArray, n3);
        }
        return array;
    }
    
    private static Type[] getArgumentTypes(final Method method) {
        final Class<?>[] parameterTypes;
        final Type[] array = new Type[(parameterTypes = method.getParameterTypes()).length];
        for (int i = parameterTypes.length - 1; i >= 0; --i) {
            array[i] = getType(parameterTypes[i]);
        }
        return array;
    }
    
    public static Type getReturnType(final String s) {
        final char[] charArray = s.toCharArray();
        int n = 1;
        char c;
        while ((c = charArray[n++]) != ')') {
            if (c == 'L') {
                while (llIIlIlIlll(charArray[n++], 59)) {}
            }
        }
        return getType(charArray, n);
    }
    
    private static Type getReturnType(final Method method) {
        return getType(method.getReturnType());
    }
    
    public static int getArgumentsAndReturnSizes(final String s) {
        int n = 1;
        int n2 = 1;
        char char1;
        while ((char1 = s.charAt(n2++)) != ')') {
            if (char1 == 'L') {
                while (llIIlIlIlll(s.charAt(n2++), 59)) {}
                ++n;
            }
            else if (char1 == '[') {
                char char2;
                while ((char2 = s.charAt(n2)) == '[') {
                    ++n2;
                }
                if (llIIlIlIlll(char2, 68) && char2 != 'J') {
                    continue;
                }
                --n;
            }
            else if (!llIIlIlIlll(char1, 68) || char1 == 'J') {
                n += 2;
            }
            else {
                ++n;
            }
        }
        final char char3 = s.charAt(n2);
        return n << 2 | ((char3 == 'V') ? 0 : ((!llIIlIlIlll(char3, 68) || char3 == 'J') ? 2 : 1));
    }
    
    private static Type getType(final char[] array, final int n) {
        switch (array[n]) {
            case 'V': {
                return Type.VOID_TYPE;
            }
            case 'Z': {
                return Type.BOOLEAN_TYPE;
            }
            case 'C': {
                return Type.CHAR_TYPE;
            }
            case 'B': {
                return Type.BYTE_TYPE;
            }
            case 'S': {
                return Type.SHORT_TYPE;
            }
            case 'I': {
                return Type.INT_TYPE;
            }
            case 'F': {
                return Type.FLOAT_TYPE;
            }
            case 'J': {
                return Type.LONG_TYPE;
            }
            case 'D': {
                return Type.DOUBLE_TYPE;
            }
            case '[': {
                int n2;
                for (n2 = 1; array[n + n2] == '['; ++n2) {}
                if (array[n + n2] == 'L') {
                    ++n2;
                    while (llIIlIlIlll(array[n + n2], 59)) {
                        ++n2;
                    }
                }
                return new Type(9, array, n, n2 + 1);
            }
            case 'L': {
                int n3;
                for (n3 = 1; llIIlIlIlll(array[n + n3], 59); ++n3) {}
                return new Type(10, array, n + 1, n3 - 1);
            }
            default: {
                return new Type(11, array, n, array.length - n);
            }
        }
    }
    
    private int getSort() {
        return this.sort;
    }
    
    public final int getDimensions() {
        int n;
        for (n = 1; this.buf[this.off + n] == '['; ++n) {}
        return n;
    }
    
    public final Type getElementType() {
        return getType(this.buf, this.off + this.getDimensions());
    }
    
    public final String getClassName() {
        switch (this.sort) {
            case 0: {
                return Type.lIIIlIIIlI[0];
            }
            case 1: {
                return Type.lIIIlIIIlI[1];
            }
            case 2: {
                return Type.lIIIlIIIlI[2];
            }
            case 3: {
                return Type.lIIIlIIIlI[3];
            }
            case 4: {
                return Type.lIIIlIIIlI[4];
            }
            case 5: {
                return Type.lIIIlIIIlI[5];
            }
            case 6: {
                return Type.lIIIlIIIlI[6];
            }
            case 7: {
                return Type.lIIIlIIIlI[7];
            }
            case 8: {
                return Type.lIIIlIIIlI[8];
            }
            case 9: {
                final StringBuilder sb = new StringBuilder(this.getElementType().getClassName());
                for (int i = this.getDimensions(); i > 0; --i) {
                    sb.append(Type.lIIIlIIIlI[9]);
                }
                return String.valueOf(sb);
            }
            case 10: {
                return new String(this.buf, this.off, this.len).replace('/', '.');
            }
            default: {
                return null;
            }
        }
    }
    
    public final String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }
    
    private Type[] getArgumentTypes() {
        return getArgumentTypes(this.getDescriptor());
    }
    
    private Type getReturnType() {
        return getReturnType(this.getDescriptor());
    }
    
    private int getArgumentsAndReturnSizes() {
        return getArgumentsAndReturnSizes(this.getDescriptor());
    }
    
    public final String getDescriptor() {
        final StringBuilder sb = new StringBuilder();
        this.getDescriptor(sb);
        return String.valueOf(sb);
    }
    
    private static String getMethodDescriptor(final Type type, final Type... array) {
        final StringBuilder sb;
        (sb = new StringBuilder()).append('(');
        for (int i = 0; i < array.length; ++i) {
            array[i].getDescriptor(sb);
        }
        sb.append(')');
        type.getDescriptor(sb);
        return String.valueOf(sb);
    }
    
    private void getDescriptor(final StringBuilder sb) {
        if (this.buf == null) {
            sb.append((char)((this.off & 0xFF000000) >>> 24));
            return;
        }
        if (this.sort == 10) {
            sb.append('L');
            sb.append(this.buf, this.off, this.len);
            sb.append(';');
            return;
        }
        sb.append(this.buf, this.off, this.len);
    }
    
    public static String getInternalName(final Class<?> clazz) {
        return clazz.getName().replace('.', '/');
    }
    
    public static String getDescriptor(final Class<?> clazz) {
        final StringBuilder sb;
        getDescriptor(sb = new StringBuilder(), clazz);
        return String.valueOf(sb);
    }
    
    private static String getConstructorDescriptor(final Constructor<?> constructor) {
        final Class<?>[] parameterTypes = (Class<?>[])constructor.getParameterTypes();
        final StringBuilder sb;
        (sb = new StringBuilder()).append('(');
        for (int i = 0; i < parameterTypes.length; ++i) {
            getDescriptor(sb, parameterTypes[i]);
        }
        return String.valueOf(sb.append(Type.lIIIlIIIlI[10]));
    }
    
    private static String getMethodDescriptor(final Method method) {
        final Class<?>[] parameterTypes = method.getParameterTypes();
        final StringBuilder sb;
        (sb = new StringBuilder()).append('(');
        for (int i = 0; i < parameterTypes.length; ++i) {
            getDescriptor(sb, parameterTypes[i]);
        }
        sb.append(')');
        getDescriptor(sb, method.getReturnType());
        return String.valueOf(sb);
    }
    
    private static void getDescriptor(final StringBuilder sb, Class<?> componentType) {
        while (!componentType.isPrimitive()) {
            if (!componentType.isArray()) {
                sb.append('L');
                String name;
                for (int length = (name = componentType.getName()).length(), i = 0; i < length; ++i) {
                    final char char1 = name.charAt(i);
                    sb.append((char1 == '.') ? '/' : char1);
                }
                sb.append(';');
                return;
            }
            sb.append('[');
            componentType = componentType.getComponentType();
        }
        char c;
        if (llIIlIlIllI(componentType, Integer.TYPE)) {
            c = 'I';
        }
        else if (llIIlIlIllI(componentType, Void.TYPE)) {
            c = 'V';
        }
        else if (llIIlIlIllI(componentType, Boolean.TYPE)) {
            c = 'Z';
        }
        else if (llIIlIlIllI(componentType, Byte.TYPE)) {
            c = 'B';
        }
        else if (llIIlIlIllI(componentType, Character.TYPE)) {
            c = 'C';
        }
        else if (llIIlIlIllI(componentType, Short.TYPE)) {
            c = 'S';
        }
        else if (llIIlIlIllI(componentType, Double.TYPE)) {
            c = 'D';
        }
        else if (llIIlIlIllI(componentType, Float.TYPE)) {
            c = 'F';
        }
        else {
            c = 'J';
        }
        sb.append(c);
    }
    
    public final int getSize() {
        if (this.buf == null) {
            return this.off & 0xFF;
        }
        return 1;
    }
    
    public final int getOpcode(final int n) {
        if (!llIIlIlIlll(n, 46) || n == 79) {
            return n + ((this.buf == null) ? ((this.off & 0xFF00) >> 8) : 4);
        }
        return n + ((this.buf == null) ? ((this.off & 0xFF0000) >> 16) : 4);
    }
    
    public final boolean equals(final Object o) {
        if (llIIlIlIllI(this, o)) {
            return true;
        }
        if (!(o instanceof Type)) {
            return false;
        }
        final Type type = (Type)o;
        if (llIIlIlIlll(this.sort, type.sort)) {
            return false;
        }
        if (llIIllIIIII$255f299(this.sort)) {
            if (llIIlIlIlll(this.len, type.len)) {
                return false;
            }
            for (int i = this.off, off = type.off; i < i + this.len; ++i, ++off) {
                if (llIIlIlIlll(this.buf[i], type.buf[off])) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public final int hashCode() {
        int n = 13 * this.sort;
        if (llIIllIIIII$255f299(this.sort)) {
            int i = 0;
            while (i < (i = this.off) + this.len) {
                n = '\u0011' * (n + this.buf[i]);
                ++i;
            }
        }
        return n;
    }
    
    public final String toString() {
        return this.getDescriptor();
    }
    
    static {
        llIIlIIIIII();
        VOID_TYPE = new Type(0, null, 1443168256, 1);
        Type.BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
        Type.CHAR_TYPE = new Type(2, null, 1124075009, 1);
        Type.BYTE_TYPE = new Type(3, null, 1107297537, 1);
        Type.SHORT_TYPE = new Type(4, null, 1392510721, 1);
        INT_TYPE = new Type(5, null, 1224736769, 1);
        FLOAT_TYPE = new Type(6, null, 1174536705, 1);
        LONG_TYPE = new Type(7, null, 1241579778, 1);
        DOUBLE_TYPE = new Type(8, null, 1141048066, 1);
    }
    
    private static void llIIlIIIIII() {
        (lIIIlIIIlI = new String[11])[0] = "void";
        Type.lIIIlIIIlI[1] = "boolean";
        Type.lIIIlIIIlI[2] = "char";
        Type.lIIIlIIIlI[3] = "byte";
        Type.lIIIlIIIlI[4] = "short";
        Type.lIIIlIIIlI[5] = "int";
        Type.lIIIlIIIlI[6] = "float";
        Type.lIIIlIIIlI[7] = "long";
        Type.lIIIlIIIlI[8] = "double";
        Type.lIIIlIIIlI[9] = "[]";
        Type.lIIIlIIIlI[10] = ")V";
    }
    
    private static String llIIIllIlIl(final String s, final String s2) {
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
    
    private static String llIIIlllllI(final String s, final String s2) {
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
    
    private static String llIIIllllll(String s, final String s2) {
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
    
    private static boolean llIIllIIIII$255f299(final int n) {
        return n >= 9;
    }
    
    private static boolean llIIlIlIllI(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean llIIlIllIII(final int n) {
        return n >= 0;
    }
    
    private static boolean llIIlIllIlI(final int n) {
        return n > 0;
    }
    
    private static boolean llIIlIlIlll(final int n, final int n2) {
        return n != n2;
    }
}
