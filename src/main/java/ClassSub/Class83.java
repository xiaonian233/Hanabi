package ClassSub;

final class Class83 extends Thread
{
    private Class102 val$hud;
    private Class102 this$0;
    
    Class83(final Class102 val$hud) {
        this.val$hud = val$hud;
        super();
    }
    
    @Override
    public final void run() {
        this.val$hud.setState(false, true);
        final long n = 500L;
        try {
            Thread.sleep(n);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.val$hud.setState(true, true);
    }
}
