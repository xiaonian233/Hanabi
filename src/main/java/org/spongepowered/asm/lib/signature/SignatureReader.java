package org.spongepowered.asm.lib.signature;

public final class SignatureReader
{
    private final String signature;
    
    public SignatureReader(final String signature) {
        super();
        this.signature = signature;
    }
    
    public final void accept(final SignatureVisitor signatureVisitor) {
        final String signature;
        final int length = (signature = this.signature).length();
        int n;
        if (signature.charAt(0) == '<') {
            n = 2;
            char char1;
            do {
                final int index = signature.indexOf(58, n);
                signatureVisitor.visitFormalTypeParameter(signature.substring(n - 1, index));
                n = index + 1;
                final char char2;
                if (!lIIlIIIIlIIlI(char2 = signature.charAt(n), 76) || !lIIlIIIIlIIlI(char2, 91) || char2 == 'T') {
                    n = parseType(signature, n, signatureVisitor.visitClassBound());
                }
                while ((char1 = signature.charAt(n++)) == ':') {
                    n = parseType(signature, n, signatureVisitor.visitInterfaceBound());
                }
            } while (char1 != '>');
        }
        else {
            n = 0;
        }
        if (signature.charAt(n) == '(') {
            ++n;
            while (lIIlIIIIlIIlI(signature.charAt(n), 41)) {
                n = parseType(signature, n, signatureVisitor.visitParameterType());
            }
            for (int i = parseType(signature, n + 1, signatureVisitor.visitReturnType()); i < length; i = parseType(signature, i + 1, signatureVisitor.visitExceptionType())) {}
        }
        else {
            for (int j = parseType(signature, n, signatureVisitor.visitSuperclass()); j < length; j = parseType(signature, j, signatureVisitor.visitInterface())) {}
        }
    }
    
    public final void acceptType(final SignatureVisitor signatureVisitor) {
        parseType(this.signature, 0, signatureVisitor);
    }
    
    private static int parseType(String s, int n, SignatureVisitor visitArrayType) {
        while (true) {
            final char char1;
            switch (char1 = s.charAt(n++)) {
                case 'B':
                case 'C':
                case 'D':
                case 'F':
                case 'I':
                case 'J':
                case 'S':
                case 'V':
                case 'Z': {
                    visitArrayType.visitBaseType(char1);
                    return n;
                }
                case '[': {
                    final String s2 = s;
                    final int n2 = n;
                    visitArrayType = visitArrayType.visitArrayType();
                    n = n2;
                    s = s2;
                    continue;
                }
                case 'T': {
                    final int index = s.indexOf(59, n);
                    visitArrayType.visitTypeVariable(s.substring(n, index));
                    return index + 1;
                }
                default: {
                    int n3 = n;
                    int n4 = 0;
                    int n5 = 0;
                Block_2:
                    while (true) {
                        final char char2;
                        switch (char2 = s.charAt(n++)) {
                            case '.':
                            case ';': {
                                if (n4 == 0) {
                                    final String substring = s.substring(n3, n - 1);
                                    if (n5 != 0) {
                                        visitArrayType.visitInnerClassType(substring);
                                    }
                                    else {
                                        visitArrayType.visitClassType(substring);
                                    }
                                }
                                if (char2 == ';') {
                                    break Block_2;
                                }
                                n3 = n;
                                n4 = 0;
                                n5 = 1;
                                continue;
                            }
                            case '<': {
                                final String substring2 = s.substring(n3, n - 1);
                                if (n5 != 0) {
                                    visitArrayType.visitInnerClassType(substring2);
                                }
                                else {
                                    visitArrayType.visitClassType(substring2);
                                }
                                n4 = 1;
                            Label_0368:
                                while (true) {
                                    final char char3;
                                    switch (char3 = s.charAt(n)) {
                                        case '>': {
                                            break Label_0368;
                                        }
                                        case '*': {
                                            ++n;
                                            visitArrayType.visitTypeArgument();
                                            continue;
                                        }
                                        case '+':
                                        case '-': {
                                            n = parseType(s, n + 1, visitArrayType.visitTypeArgument(char3));
                                            continue;
                                        }
                                        default: {
                                            n = parseType(s, n, visitArrayType.visitTypeArgument('='));
                                            continue;
                                        }
                                    }
                                }
                                continue;
                            }
                            default: {
                                continue;
                            }
                        }
                    }
                    visitArrayType.visitEnd();
                    return n;
                }
            }
        }
    }
    
    private static boolean lIIlIIIIlIIlI(final int n, final int n2) {
        return n != n2;
    }
}
