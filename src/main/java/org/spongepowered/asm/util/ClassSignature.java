package org.spongepowered.asm.util;

import org.spongepowered.asm.lib.tree.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import org.spongepowered.asm.lib.signature.*;

public class ClassSignature
{
    private static String OBJECT;
    final Map<TypeVar, TokenHandle> types;
    Token superClass;
    private final List<Token> interfaces;
    public final Deque<String> rawInterfaces;
    private static final String[] lIlllllll;
    
    ClassSignature() {
        super();
        this.types = new LinkedHashMap<TypeVar, TokenHandle>();
        this.superClass = new Token(ClassSignature.lIlllllll[0]);
        this.interfaces = new ArrayList<Token>();
        this.rawInterfaces = new LinkedList<String>();
    }
    
    private ClassSignature read(final String s) {
        if (s != null) {
            try {
                new SignatureReader(s).accept(new SignatureParser());
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return this;
    }
    
    private TypeVar getTypeVar(final String s) {
        final Iterator<TypeVar> iterator = this.types.keySet().iterator();
        while (iterator.hasNext()) {
            final TypeVar typeVar;
            if ((typeVar = iterator.next()).matches(s)) {
                return typeVar;
            }
        }
        return null;
    }
    
    protected final TokenHandle getType(final String s) {
        final Iterator<TypeVar> iterator = this.types.keySet().iterator();
        while (iterator.hasNext()) {
            final TypeVar typeVar;
            if ((typeVar = iterator.next()).matches(s)) {
                return this.types.get(typeVar);
            }
        }
        final TokenHandle tokenHandle = new TokenHandle();
        this.types.put(new TypeVar(s), tokenHandle);
        return tokenHandle;
    }
    
    protected final String getTypeVar(final TokenHandle tokenHandle) {
        final Iterator<Map.Entry<TypeVar, TokenHandle>> iterator = this.types.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<TypeVar, TokenHandle> entry;
            final TypeVar typeVar = (entry = iterator.next()).getKey();
            final TokenHandle tokenHandle2 = entry.getValue();
            if (tokenHandle == tokenHandle2 || tokenHandle.token == tokenHandle2.token) {
                return String.valueOf(new StringBuilder().append(ClassSignature.lIlllllll[1]).append(typeVar).append(ClassSignature.lIlllllll[2]));
            }
        }
        return tokenHandle.token.asType();
    }
    
    private void addTypeVar(final TypeVar typeVar, final TokenHandle tokenHandle) throws IllegalArgumentException {
        if (this.types.containsKey(typeVar)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(ClassSignature.lIlllllll[3]).append(typeVar).append(ClassSignature.lIlllllll[4]).append(this)));
        }
        this.types.put(typeVar, tokenHandle);
    }
    
    private void setSuperClass(final Token superClass) {
        this.superClass = superClass;
    }
    
    private String getSuperClass() {
        return this.superClass.asType(true);
    }
    
    protected final void addInterface(final Token token) {
        if (!token.isRaw()) {
            final String type = token.asType(true);
            final ListIterator<Token> listIterator = this.interfaces.listIterator();
            while (listIterator.hasNext()) {
                final Token token2;
                if ((token2 = listIterator.next()).isRaw() && token2.asType(true).equals(type)) {
                    listIterator.set(token);
                    return;
                }
            }
        }
        this.interfaces.add(token);
    }
    
    private void addInterface(final String s) {
        this.rawInterfaces.add(s);
    }
    
    private void addRawInterface(final String s) {
        final Token token;
        final String type = (token = new Token(s)).asType(true);
        final Iterator<Token> iterator = this.interfaces.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().asType(true).equals(type)) {
                return;
            }
        }
        this.interfaces.add(token);
    }
    
    public final void merge(final ClassSignature classSignature) {
        try {
            final HashSet<String> set = new HashSet<String>();
            final Iterator<TypeVar> iterator = this.types.keySet().iterator();
            while (iterator.hasNext()) {
                set.add(iterator.next().toString());
            }
            classSignature.conform(set);
        }
        catch (IllegalStateException ex) {
            ex.printStackTrace();
            return;
        }
        for (final Map.Entry<TypeVar, TokenHandle> entry : classSignature.types.entrySet()) {
            final TypeVar typeVar = entry.getKey();
            final TokenHandle tokenHandle = entry.getValue();
            final TypeVar typeVar2 = typeVar;
            if (this.types.containsKey(typeVar2)) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(ClassSignature.lIlllllll[3]).append(typeVar2).append(ClassSignature.lIlllllll[4]).append(this)));
            }
            this.types.put(typeVar2, tokenHandle);
        }
        final Iterator<Token> iterator3 = classSignature.interfaces.iterator();
        while (iterator3.hasNext()) {
            this.addInterface(iterator3.next());
        }
    }
    
    private void conform(final Set<String> set) {
        final Iterator<TypeVar> iterator = this.types.keySet().iterator();
        while (iterator.hasNext()) {
            final TypeVar typeVar;
            final String originalName = (typeVar = iterator.next()).originalName;
            String currentName;
            if (!set.contains(originalName)) {
                currentName = originalName;
            }
            else {
                final String offsetName;
                if (originalName.length() == 1 && (offsetName = findOffsetName(originalName.charAt(0), set, ClassSignature.lIlllllll[11], ClassSignature.lIlllllll[12])) != null) {
                    currentName = offsetName;
                }
                else {
                    final String offsetName2;
                    if ((offsetName2 = findOffsetName('T', set, ClassSignature.lIlllllll[5], originalName)) != null) {
                        currentName = offsetName2;
                    }
                    else {
                        final String offsetName3;
                        if ((offsetName3 = findOffsetName('T', set, originalName, ClassSignature.lIlllllll[6])) != null) {
                            currentName = offsetName3;
                        }
                        else {
                            final String offsetName4;
                            if ((offsetName4 = findOffsetName('T', set, ClassSignature.lIlllllll[7], originalName)) != null) {
                                currentName = offsetName4;
                            }
                            else {
                                final String offsetName5;
                                if ((offsetName5 = findOffsetName('T', set, ClassSignature.lIlllllll[8], String.valueOf(new StringBuilder().append(originalName).append(ClassSignature.lIlllllll[9])))) == null) {
                                    throw new IllegalStateException(String.valueOf(new StringBuilder().append(ClassSignature.lIlllllll[10]).append(originalName)));
                                }
                                currentName = offsetName5;
                            }
                        }
                    }
                }
            }
            set.add(typeVar.currentName = currentName);
        }
    }
    
    private static String findUniqueName(final String s, final Set<String> set) {
        if (!set.contains(s)) {
            return s;
        }
        final String offsetName;
        if (s.length() == 1 && (offsetName = findOffsetName(s.charAt(0), set, ClassSignature.lIlllllll[11], ClassSignature.lIlllllll[12])) != null) {
            return offsetName;
        }
        final String offsetName2;
        if ((offsetName2 = findOffsetName('T', set, ClassSignature.lIlllllll[5], s)) != null) {
            return offsetName2;
        }
        final String offsetName3;
        if ((offsetName3 = findOffsetName('T', set, s, ClassSignature.lIlllllll[6])) != null) {
            return offsetName3;
        }
        final String offsetName4;
        if ((offsetName4 = findOffsetName('T', set, ClassSignature.lIlllllll[7], s)) != null) {
            return offsetName4;
        }
        final String offsetName5;
        if ((offsetName5 = findOffsetName('T', set, ClassSignature.lIlllllll[8], String.valueOf(new StringBuilder().append(s).append(ClassSignature.lIlllllll[9])))) != null) {
            return offsetName5;
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append(ClassSignature.lIlllllll[10]).append(s)));
    }
    
    private static String findOffsetName(final char c, final Set<String> set) {
        return findOffsetName(c, set, ClassSignature.lIlllllll[11], ClassSignature.lIlllllll[12]);
    }
    
    private static String findOffsetName(final char c, final Set<String> set, final String s, final String s2) {
        final String format = String.format(ClassSignature.lIlllllll[13], s, c, s2);
        if (!set.contains(format)) {
            return format;
        }
        if (lllllllIll$255f299(c) && c < '[') {
            for (int n = c - '@'; llllllllIl(n + 65, c); n = ++n % 26) {
                final String format2 = String.format(ClassSignature.lIlllllll[14], s, (char)(n + 65), s2);
                if (!set.contains(format2)) {
                    return format2;
                }
            }
        }
        return null;
    }
    
    public final SignatureVisitor getRemapper() {
        return new SignatureRemapper();
    }
    
    @Override
    public String toString() {
    Label_0106_Outer:
        while (this.rawInterfaces.size() > 0) {
            final Token token;
            final String type = (token = new Token(this.rawInterfaces.remove())).asType(true);
            final Iterator<Token> iterator = this.interfaces.iterator();
            while (true) {
                while (iterator.hasNext()) {
                    if (!iterator.next().asType(true).equals(type)) {
                        continue Label_0106_Outer;
                    }
                    continue Label_0106_Outer;
                }
                this.interfaces.add(token);
                continue;
            }
        }
        final StringBuilder sb = new StringBuilder();
        if (this.types.size() > 0) {
            boolean b = false;
            final StringBuilder sb2 = new StringBuilder();
            final Iterator<Map.Entry<TypeVar, TokenHandle>> iterator2 = this.types.entrySet().iterator();
            while (iterator2.hasNext()) {
                final Map.Entry<TypeVar, TokenHandle> entry;
                final String bound;
                if (!(bound = (entry = iterator2.next()).getValue().asBound()).isEmpty()) {
                    sb2.append(entry.getKey()).append(':').append(bound);
                    b = true;
                }
            }
            if (b) {
                sb.append('<').append((CharSequence)sb2).append('>');
            }
        }
        sb.append(this.superClass.asType());
        final Iterator<Token> iterator3 = this.interfaces.iterator();
        while (iterator3.hasNext()) {
            sb.append(iterator3.next().asType());
        }
        return String.valueOf(sb);
    }
    
    public ClassSignature wake() {
        return this;
    }
    
    public static ClassSignature of(final String s) {
        return new ClassSignature().read(s);
    }
    
    private static ClassSignature of(final ClassNode classNode) {
        if (classNode.signature != null) {
            return of(classNode.signature);
        }
        return generate(classNode);
    }
    
    public static ClassSignature ofLazy(final ClassNode classNode) {
        if (classNode.signature != null) {
            return new Lazy(classNode.signature);
        }
        return generate(classNode);
    }
    
    private static ClassSignature generate(final ClassNode classNode) {
        final ClassSignature classSignature;
        (classSignature = new ClassSignature()).superClass = new Token((classNode.superName != null) ? classNode.superName : ClassSignature.lIlllllll[15]);
        final Iterator<String> iterator = classNode.interfaces.iterator();
        while (iterator.hasNext()) {
            classSignature.addInterface(new Token(iterator.next()));
        }
        return classSignature;
    }
    
    static {
        llllllIlII();
    }
    
    private static void llllllIlII() {
        (lIlllllll = new String[17])[0] = "java/lang/Object";
        ClassSignature.lIlllllll[1] = "T";
        ClassSignature.lIlllllll[2] = ";";
        ClassSignature.lIlllllll[3] = "TypeVar ";
        ClassSignature.lIlllllll[4] = " is already present on ";
        ClassSignature.lIlllllll[5] = "";
        ClassSignature.lIlllllll[6] = "";
        ClassSignature.lIlllllll[7] = "T";
        ClassSignature.lIlllllll[8] = "";
        ClassSignature.lIlllllll[9] = "Type";
        ClassSignature.lIlllllll[10] = "Failed to conform type var: ";
        ClassSignature.lIlllllll[11] = "";
        ClassSignature.lIlllllll[12] = "";
        ClassSignature.lIlllllll[13] = "%s%s%s";
        ClassSignature.lIlllllll[14] = "%s%s%s";
        ClassSignature.lIlllllll[15] = "java/lang/Object";
        ClassSignature.lIlllllll[16] = "java/lang/Object";
    }
    
    private static String lllllIlllI(String s, final String s2) {
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
    
    private static String lllllIllll(final String s, final String s2) {
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
    
    private static String llllllIIIl(final String s, final String s2) {
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
    
    private static boolean lllllllIll$255f299(final int n) {
        return n > 64;
    }
    
    private static boolean llllllIlll(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lllllllIII(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lllllllllI(final int n) {
        return n > 0;
    }
    
    private static boolean llllllllIl(final int n, final int n2) {
        return n != n2;
    }
}
