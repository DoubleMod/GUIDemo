package windowOne; /*
                    * Created by JFormDesigner on Mon Jan 13 18:18:58 CST 2020
                    */

import net.miginfocom.swing.MigLayout;
import utils.MsgUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/** @author unknown */
public class WindowOne extends JFrame {

  // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
  // Generated using JFormDesigner Evaluation license - unknown
  private JPanel dialogPane;
  private JPanel contentPanel;
  private JPanel buttonBar;
  private JButton cancelButton;
  private JButton okButton;
  // JFormDesigner - End of variables declaration  //GEN-END:variables

  public static void main(String[] args) {
    new WindowOne().setVisible(true);
  }

  public WindowOne() {
    initComponents();

    // 加载图片
    ImageIcon icon = new ImageIcon("src/main/java/find.png");
    // 将图片放入label中
    JLabel label = new JLabel(icon);
    // 设置label的大小
    label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
    // 获取窗口的第二层，将label放入
    getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
    // 获取frame的顶层容器,并设置为透明
    contentPanel.setOpaque(false);
    // 必须设置为透明的。否则看不到图片
    contentPanel.setOpaque(false);
    setSize(icon.getIconWidth(), icon.getIconHeight());
    setVisible(true);
  }

  private void cancelButtonActionPerformed(ActionEvent e) {
    System.exit(0);
  }

  private void okButtonActionPerformed(ActionEvent e) {
    // user.dir指定了当前的路径
    System.out.println(this.getClass().getClassLoader().getResource(""));
    System.out.println(this.getClass().getClassLoader().getResource("/"));
    System.out.println(this.getClass().getClassLoader().getResource("/icon16.png"));
    System.out.println(this.getClass().getClassLoader().getResource("icon16.png"));
    MsgUtil.msg(System.getProperty("user.dir"), 2);
  }

  private void initComponents() {
    // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - unknown
    dialogPane = new JPanel();
    contentPanel = new JPanel();
    buttonBar = new JPanel();
    cancelButton = new JButton();
    okButton = new JButton();

    //======== this ========
    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());

    //======== dialogPane ========
    {
        dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
        .swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing
        .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
        Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
        ),dialogPane. getBorder()));dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
        public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName(
        )))throw new RuntimeException();}});
        dialogPane.setLayout(new BorderLayout());

        //======== contentPanel ========
        {
            contentPanel.setLayout(new MigLayout(
                "insets dialog,hidemode 3",
                // columns
                "[]",
                // rows
                "[]"));
        }
        dialogPane.add(contentPanel, BorderLayout.WEST);

        //======== buttonBar ========
        {
            buttonBar.setLayout(new MigLayout(
                "insets dialog,alignx right",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[button,fill]" +
                "[button,fill]",
                // rows
                null));

            //---- cancelButton ----
            cancelButton.setText("Cancel");
            cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
            buttonBar.add(cancelButton, "cell 3 0");

            //---- okButton ----
            okButton.setText("OK");
            okButton.addActionListener(e -> okButtonActionPerformed(e));
            buttonBar.add(okButton, "cell 13 0");
        }
        dialogPane.add(buttonBar, BorderLayout.SOUTH);
    }
    contentPane.add(dialogPane, BorderLayout.CENTER);
    pack();
    setLocationRelativeTo(getOwner());
    // JFormDesigner - End of component initialization  //GEN-END:initComponents
  }
}
