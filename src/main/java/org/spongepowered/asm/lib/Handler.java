package org.spongepowered.asm.lib;

final class Handler
{
    Label start;
    Label end;
    Label handler;
    String desc;
    int type;
    Handler next;
    
    Handler() {
        super();
    }
    
    static Handler remove(Handler next, final Label label, final Label label2) {
        if (next == null) {
            return null;
        }
        final Handler handler = next;
        handler.next = remove(handler.next, label, label2);
        final int position = next.start.position;
        final int position2 = next.end.position;
        final int position3 = label.position;
        final int n = (label2 == null) ? Integer.MAX_VALUE : label2.position;
        if (position3 < position2 && n > position) {
            if (position3 <= position) {
                if (lIIlllllIlll(n, position2)) {
                    next = next.next;
                }
                else {
                    next.start = label2;
                }
            }
            else if (lIIlllllIlll(n, position2)) {
                next.end = label;
            }
            else {
                final Handler next2;
                (next2 = new Handler()).start = label2;
                next2.end = next.end;
                next2.handler = next.handler;
                next2.desc = next.desc;
                next2.type = next.type;
                next2.next = next.next;
                next.end = label;
                next.next = next2;
            }
        }
        return next;
    }
    
    private static boolean lIIlllllIlll(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIlllllIllI(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean lIIlllllIlIl(final int n, final int n2) {
        return n > n2;
    }
}
