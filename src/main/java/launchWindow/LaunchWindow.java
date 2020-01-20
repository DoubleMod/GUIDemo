package launchWindow;
/*
 * Created by JFormDesigner on Fri Jan 10 18:25:38 CST 2020
 */

import cn.hutool.core.io.FileUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.setting.dialect.Props;
import entity.User;
import net.miginfocom.swing.MigLayout;
import utils.MsgUtil;
import windowOne.WindowOne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

/** @author unknown */
public class LaunchWindow extends JFrame {

  // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
  // Generated using JFormDesigner Evaluation license - unknown
  private JPanel dialogPane;
  private JPanel contentPanel;
  private JLabel usernameLable;
  private JTextField usernameTextField;
  private JLabel passwordLabel;
  private JPasswordField passwordField;
  private JCheckBox checkBoxOne;
  private JPanel hSpacer1;
  private JButton loginButton;
  private JButton cancelButton;
  // JFormDesigner - End of variables declaration  //GEN-END:variables
  private String path = "E:\\repository\\GUIDemo\\src\\main\\java\\test.properties";

  public LaunchWindow() {
    initComponents();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 回显储存的账户信息
    if (FileUtil.exist(path)) {
      Props props = new Props(path);
      usernameTextField.setText(props.getStr("username"));
      passwordField.setText(props.getStr("password"));
      checkBoxOne.setSelected(true);
    }
  }

  public static void main(String[] args) {
    new LaunchWindow().setVisible(true);
  }

  private void loginButtonActionPerformed(ActionEvent e) {

    List<User> users;
    System.out.println("hit");
    String username = usernameTextField.getText();
    String password = passwordField.getText();

    if (checkBoxOne.isSelected()) {
      FileUtil.del(path);
      System.out.println(true);
      Props props = new Props();
      props.setProperty("username", username);
      props.setProperty("password", password);
      props.store(path);
    } else {
      System.out.println(false);
      FileUtil.del(path);
    }

    try {
      users =
          Db.use()
              .find(
                  Entity.create("user").set("name", username).set("password", password),
                  User.class);
    } catch (SQLException ex) {
      MsgUtil.msg("网络繁忙，请稍后再试！", JOptionPane.ERROR_MESSAGE);
      ex.printStackTrace();
      return;
    }

    if (null == users || users.size() == 0) {
      MsgUtil.msg("账号或密码错误", JOptionPane.ERROR_MESSAGE);
      return;
    }

    if (users.get(0).getName().equals(username) && users.get(0).getPassword().equals(password)) {
      JOptionPane.showMessageDialog(
          contentPanel, "登录成功", "information", JOptionPane.INFORMATION_MESSAGE);
      this.setVisible(false);
      WindowOne windowOne = new WindowOne();
      windowOne.setDefaultCloseOperation(EXIT_ON_CLOSE);
      windowOne.setVisible(true);
    } else {
      MsgUtil.msg("登录失败，请检查帐号密码", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void cancelButtonActionPerformed(ActionEvent e) {
    System.exit(0);
  }

  private void thisKeyPressed(KeyEvent e) {
    System.out.println("thisKeyPressed");
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_ENTER) {
      e.getComponent().transferFocus();
    }
  }

  private void thisKeyReleased(KeyEvent e) {
    System.out.println("thisKeyReleased");
    // TODO add your code here
  }

  private void initComponents() {
    // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - unknown
    dialogPane = new JPanel();
    contentPanel = new JPanel();
    usernameLable = new JLabel();
    usernameTextField = new JTextField();
    passwordLabel = new JLabel();
    passwordField = new JPasswordField();
    checkBoxOne = new JCheckBox();
    hSpacer1 = new JPanel(null);
    loginButton = new JButton();
    cancelButton = new JButton();

    //======== this ========
    setIconImage(new ImageIcon(getClass().getResource("/icon16.png")).getImage());
    addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            thisKeyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e) {
            thisKeyReleased(e);
        }
    });
    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());

    //======== dialogPane ========
    {
        dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );
        dialogPane.setLayout(new BorderLayout());
    }
    contentPane.add(dialogPane, BorderLayout.WEST);

    //======== contentPanel ========
    {
        contentPanel.setLayout(new MigLayout(
            "insets dialog,hidemode 3",
            // columns
            "[53,fill]" +
            "[180,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- usernameLable ----
        usernameLable.setText("\u7528\u6237\u540d\uff1a");
        contentPanel.add(usernameLable, "cell 0 0");
        contentPanel.add(usernameTextField, "cell 1 0");

        //---- passwordLabel ----
        passwordLabel.setText("\u5bc6\u7801\uff1a");
        contentPanel.add(passwordLabel, "cell 0 2");
        contentPanel.add(passwordField, "cell 1 2");

        //---- checkBoxOne ----
        checkBoxOne.setText("\u8bb0\u4f4f\u8d26\u53f7");
        contentPanel.add(checkBoxOne, "cell 1 3");
        contentPanel.add(hSpacer1, "cell 0 4 2 1");

        //---- loginButton ----
        loginButton.setText("login");
        loginButton.addActionListener(e -> loginButtonActionPerformed(e));
        contentPanel.add(loginButton, "cell 0 4 2 1");

        //---- cancelButton ----
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
        contentPanel.add(cancelButton, "cell 0 4 2 1");
    }
    contentPane.add(contentPanel, BorderLayout.NORTH);
    pack();
    setLocationRelativeTo(getOwner());
    // JFormDesigner - End of component initialization  //GEN-END:initComponents
  }
}
