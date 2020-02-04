package org.spongepowered.tools.obfuscation.mirror;

import org.spongepowered.asm.util.*;
import javax.annotation.processing.*;
import javax.lang.model.element.*;
import java.nio.charset.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.*;
import java.security.*;
import javax.lang.model.type.*;

public abstract class TypeUtils
{
    private static final int MAX_GENERIC_RECURSION_DEPTH;
    private static final String OBJECT_SIG;
    private static final String OBJECT_REF;
    private static final String[] llIllllIl;
    
    private TypeUtils() {
        super();
    }
    
    public static PackageElement getPackage(final TypeMirror typeMirror) {
        if (!(typeMirror instanceof DeclaredType)) {
            return null;
        }
        return getPackage((TypeElement)((DeclaredType)typeMirror).asElement());
    }
    
    public static PackageElement getPackage(final TypeElement typeElement) {
        Element element;
        for (element = typeElement.getEnclosingElement(); element != null && !(element instanceof PackageElement); element = element.getEnclosingElement()) {}
        return (PackageElement)element;
    }
    
    public static String getElementType(final Element element) {
        if (element instanceof TypeElement) {
            return TypeUtils.llIllllIl[0];
        }
        if (element instanceof ExecutableElement) {
            return TypeUtils.llIllllIl[1];
        }
        if (element instanceof VariableElement) {
            return TypeUtils.llIllllIl[2];
        }
        if (element instanceof PackageElement) {
            return TypeUtils.llIllllIl[3];
        }
        if (element instanceof TypeParameterElement) {
            return TypeUtils.llIllllIl[4];
        }
        return element.getClass().getSimpleName();
    }
    
    public static String stripGenerics(final String s) {
        final StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = 0;
        while (i < s.length()) {
            final char char1;
            if ((char1 = s.charAt(i)) == '<') {
                ++n;
            }
            if (n == 0) {
                sb.append(char1);
            }
            else if (char1 == '>') {
                --n;
            }
            ++i;
        }
        return String.valueOf(sb);
    }
    
    public static String getName(final VariableElement variableElement) {
        if (variableElement != null) {
            return variableElement.getSimpleName().toString();
        }
        return null;
    }
    
    public static String getName(final ExecutableElement executableElement) {
        if (executableElement != null) {
            return executableElement.getSimpleName().toString();
        }
        return null;
    }
    
    public static String getJavaSignature(final Element element) {
        if (element instanceof ExecutableElement) {
            final ExecutableElement executableElement = (ExecutableElement)element;
            final StringBuilder append = new StringBuilder().append(TypeUtils.llIllllIl[5]);
            int n = 0;
            for (final VariableElement variableElement : executableElement.getParameters()) {
                if (n != 0) {
                    append.append(',');
                }
                append.append(getTypeName(variableElement.asType()));
                n = 1;
            }
            append.append(')').append(getTypeName(executableElement.getReturnType()));
            return String.valueOf(append);
        }
        return getTypeName(element.asType());
    }
    
    public static String getJavaSignature(final String s) {
        final SignaturePrinter signaturePrinter;
        (signaturePrinter = new SignaturePrinter(TypeUtils.llIllllIl[6], s)).fullyQualified = true;
        return signaturePrinter.toDescriptor();
    }
    
    public static String getTypeName(final TypeMirror typeMirror) {
        switch (TypeUtils$1.$SwitchMap$javax$lang$model$type$TypeKind[typeMirror.getKind().ordinal()]) {
            case 1: {
                return String.valueOf(new StringBuilder().append(getTypeName(((ArrayType)typeMirror).getComponentType())).append(TypeUtils.llIllllIl[7]));
            }
            case 2: {
                return getTypeName((DeclaredType)typeMirror);
            }
            case 3: {
                return getTypeName(getUpperBound(typeMirror));
            }
            case 4: {
                return TypeUtils.llIllllIl[8];
            }
            default: {
                return typeMirror.toString();
            }
        }
    }
    
    private static String getTypeName(final DeclaredType declaredType) {
        if (declaredType == null) {
            return TypeUtils.llIllllIl[9];
        }
        return getInternalName((TypeElement)declaredType.asElement()).replace('/', '.');
    }
    
    public static String getDescriptor(final Element element) {
        if (element instanceof ExecutableElement) {
            return getDescriptor((ExecutableElement)element);
        }
        if (element instanceof VariableElement) {
            return getInternalName((VariableElement)element);
        }
        return getInternalName(element.asType());
    }
    
    public static String getDescriptor(final ExecutableElement executableElement) {
        if (executableElement == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        final Iterator<? extends VariableElement> iterator = executableElement.getParameters().iterator();
        while (iterator.hasNext()) {
            sb.append(getInternalName((VariableElement)iterator.next()));
        }
        return String.format(TypeUtils.llIllllIl[10], sb, getInternalName(executableElement.getReturnType()));
    }
    
    public static String getInternalName(final VariableElement variableElement) {
        if (variableElement == null) {
            return null;
        }
        return getInternalName(variableElement.asType());
    }
    
    public static String getInternalName(final TypeMirror typeMirror) {
        switch (TypeUtils$1.$SwitchMap$javax$lang$model$type$TypeKind[typeMirror.getKind().ordinal()]) {
            case 1: {
                return String.valueOf(new StringBuilder().append(TypeUtils.llIllllIl[11]).append(getInternalName(((ArrayType)typeMirror).getComponentType())));
            }
            case 2: {
                return String.valueOf(new StringBuilder().append(TypeUtils.llIllllIl[12]).append(getInternalName((DeclaredType)typeMirror)).append(TypeUtils.llIllllIl[13]));
            }
            case 3: {
                return String.valueOf(new StringBuilder().append(TypeUtils.llIllllIl[14]).append(getInternalName(getUpperBound(typeMirror))).append(TypeUtils.llIllllIl[15]));
            }
            case 5: {
                return TypeUtils.llIllllIl[16];
            }
            case 6: {
                return TypeUtils.llIllllIl[17];
            }
            case 7: {
                return TypeUtils.llIllllIl[18];
            }
            case 8: {
                return TypeUtils.llIllllIl[19];
            }
            case 9: {
                return TypeUtils.llIllllIl[20];
            }
            case 10: {
                return TypeUtils.llIllllIl[21];
            }
            case 11: {
                return TypeUtils.llIllllIl[22];
            }
            case 12: {
                return TypeUtils.llIllllIl[23];
            }
            case 13: {
                return TypeUtils.llIllllIl[24];
            }
            case 4: {
                return TypeUtils.llIllllIl[25];
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(TypeUtils.llIllllIl[26]).append(typeMirror).append(TypeUtils.llIllllIl[27]).append(typeMirror.getKind()).append(TypeUtils.llIllllIl[28])));
            }
        }
    }
    
    private static String getInternalName(final DeclaredType declaredType) {
        if (declaredType == null) {
            return TypeUtils.llIllllIl[29];
        }
        return getInternalName((TypeElement)declaredType.asElement());
    }
    
    public static String getInternalName(final TypeElement typeElement) {
        if (typeElement == null) {
            return null;
        }
        final StringBuilder sb;
        (sb = new StringBuilder()).append(typeElement.getSimpleName());
        for (Element element = typeElement.getEnclosingElement(); element != null; element = element.getEnclosingElement()) {
            if (element instanceof TypeElement) {
                sb.insert(0, TypeUtils.llIllllIl[30]).insert(0, element.getSimpleName());
            }
            else if (element instanceof PackageElement) {
                sb.insert(0, TypeUtils.llIllllIl[31]).insert(0, ((PackageElement)element).getQualifiedName().toString().replace('.', '/'));
            }
        }
        return String.valueOf(sb);
    }
    
    private static DeclaredType getUpperBound(final TypeMirror typeMirror) {
        final int n = 5;
        try {
            return getUpperBound0(typeMirror, n);
        }
        catch (IllegalStateException ex) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(TypeUtils.llIllllIl[32]).append(typeMirror).append(TypeUtils.llIllllIl[33])), ex);
        }
        catch (IllegalArgumentException ex2) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(TypeUtils.llIllllIl[34]).append(typeMirror)), ex2);
        }
    }
    
    private static DeclaredType getUpperBound0(final TypeMirror typeMirror, int n) {
        if (n == 0) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append(TypeUtils.llIllllIl[35]).append(typeMirror).append(TypeUtils.llIllllIl[36]).append(5).append(TypeUtils.llIllllIl[37])));
        }
        if (typeMirror instanceof DeclaredType) {
            return (DeclaredType)typeMirror;
        }
        if (typeMirror instanceof TypeVariable) {
            try {
                final TypeVariable typeVariable = (TypeVariable)typeMirror;
                try {
                    return getUpperBound0(typeVariable.getUpperBound(), --n);
                }
                catch (IllegalStateException ex) {
                    throw ex;
                }
                catch (IllegalArgumentException ex2) {
                    throw ex2;
                }
            }
            catch (Exception ex3) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(TypeUtils.llIllllIl[38]).append(typeMirror)));
            }
        }
        return null;
    }
    
    public static boolean isAssignable(final ProcessingEnvironment processingEnvironment, TypeMirror rawType, TypeMirror rawType2) {
        final boolean assignable;
        if (!(assignable = processingEnvironment.getTypeUtils().isAssignable(rawType, rawType2)) && rawType instanceof DeclaredType && rawType2 instanceof DeclaredType) {
            rawType = toRawType(processingEnvironment, (DeclaredType)rawType);
            rawType2 = toRawType(processingEnvironment, (DeclaredType)rawType2);
            return processingEnvironment.getTypeUtils().isAssignable(rawType, rawType2);
        }
        return assignable;
    }
    
    private static TypeMirror toRawType(final ProcessingEnvironment processingEnvironment, final DeclaredType declaredType) {
        return processingEnvironment.getElementUtils().getTypeElement(((TypeElement)declaredType.asElement()).getQualifiedName()).asType();
    }
    
    public static Visibility getVisibility(final Element element) {
        if (element == null) {
            return null;
        }
        final Iterator<Modifier> iterator = element.getModifiers().iterator();
        while (iterator.hasNext()) {
            switch (TypeUtils$1.$SwitchMap$javax$lang$model$element$Modifier[iterator.next().ordinal()]) {
                case 1: {
                    return Visibility.PUBLIC;
                }
                case 2: {
                    return Visibility.PROTECTED;
                }
                case 3: {
                    return Visibility.PRIVATE;
                }
                default: {
                    continue;
                }
            }
        }
        return Visibility.PACKAGE;
    }
    
    static {
        lIlIIIIIlll();
    }
    
    private static void lIlIIIIIlll() {
        (llIllllIl = new String[41])[0] = "TypeElement";
        TypeUtils.llIllllIl[1] = "ExecutableElement";
        TypeUtils.llIllllIl[2] = "VariableElement";
        TypeUtils.llIllllIl[3] = "PackageElement";
        TypeUtils.llIllllIl[4] = "TypeParameterElement";
        TypeUtils.llIllllIl[5] = "(";
        TypeUtils.llIllllIl[6] = "";
        TypeUtils.llIllllIl[7] = "[]";
        TypeUtils.llIllllIl[8] = "java.lang.Object";
        TypeUtils.llIllllIl[9] = "java.lang.Object";
        TypeUtils.llIllllIl[10] = "(%s)%s";
        TypeUtils.llIllllIl[11] = "[";
        TypeUtils.llIllllIl[12] = "L";
        TypeUtils.llIllllIl[13] = ";";
        TypeUtils.llIllllIl[14] = "L";
        TypeUtils.llIllllIl[15] = ";";
        TypeUtils.llIllllIl[16] = "Z";
        TypeUtils.llIllllIl[17] = "B";
        TypeUtils.llIllllIl[18] = "C";
        TypeUtils.llIllllIl[19] = "D";
        TypeUtils.llIllllIl[20] = "F";
        TypeUtils.llIllllIl[21] = "I";
        TypeUtils.llIllllIl[22] = "J";
        TypeUtils.llIllllIl[23] = "S";
        TypeUtils.llIllllIl[24] = "V";
        TypeUtils.llIllllIl[25] = "Ljava/lang/Object;";
        TypeUtils.llIllllIl[26] = "Unable to parse type symbol ";
        TypeUtils.llIllllIl[27] = " with ";
        TypeUtils.llIllllIl[28] = " to equivalent bytecode type";
        TypeUtils.llIllllIl[29] = "java/lang/Object";
        TypeUtils.llIllllIl[30] = "$";
        TypeUtils.llIllllIl[31] = "/";
        TypeUtils.llIllllIl[32] = "Type symbol \"";
        TypeUtils.llIllllIl[33] = "\" is too complex";
        TypeUtils.llIllllIl[34] = "Unable to compute upper bound of type symbol ";
        TypeUtils.llIllllIl[35] = "Generic symbol \"";
        TypeUtils.llIllllIl[36] = "\" is too complex, exceeded ";
        TypeUtils.llIllllIl[37] = " iterations attempting to determine upper bound";
        TypeUtils.llIllllIl[38] = "Unable to compute upper bound of type symbol ";
        TypeUtils.llIllllIl[39] = "java.lang.Object";
        TypeUtils.llIllllIl[40] = "java/lang/Object";
    }
    
    private static String lIIllllIIll(String s, final String s2) {
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
    
    private static String lIIllllIIlI(final String s, final String s2) {
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
    
    private static String lIIllllIlII(final String s, final String s2) {
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
}
