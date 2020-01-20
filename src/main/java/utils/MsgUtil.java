package utils;

import javax.swing.*;

public   class MsgUtil {


    public static void msg(String msg, int messageType) {
        JOptionPane.showMessageDialog(null, msg, "alert", messageType);
    }

}
