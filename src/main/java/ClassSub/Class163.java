package ClassSub;

import java.awt.event.*;

final class Class163 implements ActionListener
{
    private Class227 this$0;
    
    Class163(final Class227 this$0) {
        this.this$0 = this$0;
        super();
    }
    
    @Override
    public final void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.okPressed = true;
        this.this$0.setVisible(false);
    }
}
