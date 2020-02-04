package ClassSub;

import javax.swing.*;
import java.awt.event.*;
import cn.Hanabi.modules.*;
import org.apache.commons.codec.digest.*;
import cn.Hanabi.modules.World.*;

final class Class334 implements ActionListener
{
    private JTextField val$name;
    private JPasswordField val$password;
    private Class125 this$0;
    
    Class334(final Class125 this$0, final JTextField val$name, final JPasswordField val$password) {
        this.this$0 = this$0;
        this.val$name = val$name;
        this.val$password = val$password;
        super();
    }
    
    @Override
    public final void actionPerformed(final ActionEvent actionEvent) {
        Class258.username = (Mod.username = this.val$name.getText());
        Class258.password = (Mod.password = DigestUtils.md5Hex(new String(this.val$password.getPassword())));
        IRC.client = new Class206();
        Class206.start(Class258.username, Class258.password);
        new Class139();
        this.this$0.setVisible(false);
    }
}
