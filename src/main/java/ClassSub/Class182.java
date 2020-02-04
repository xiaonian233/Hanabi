package ClassSub;

import java.util.*;

public final class Class182 implements Runnable
{
    private /* synthetic */ Class132 this$0;
    
    public Class182(final Class132 this$0) {
        this.this$0 = this$0;
        super();
    }
    
    @Override
    public final void run() {
        this.this$0.irc.sendMsg("HB::true");
        if (new Random(new Random().nextInt(10)).nextInt(100) > 60) {
            this.this$0.irc.sendMsg("SERVERCHAT::[FakeIRCServer]成功发送心跳");
            this.this$0.irc.sendMsg("SERVERCHAT::[FakeIRCServer][Tip] 输入[.irc fuck李佳乐]来关闭这条提示");
        }
    }
}
