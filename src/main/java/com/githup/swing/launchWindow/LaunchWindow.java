package com.githup.swing.launchWindow;
/*
 * Created by JFormDesigner on Fri Jan 10 18:25:38 CST 2020
 */

import cn.hutool.core.io.FileUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.setting.dialect.Props;
import com.githup.swing.entity.User;
import com.githup.swing.utils.MsgUtil;
import com.githup.swing.windowOne.WindowOne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;

/** @author unknown */
public class LaunchWindow extends JFrame {

  // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
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
    contentPane.setLayout(new GridBagLayout());
    ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0};
    ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0};
    ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
    ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

    //======== dialogPane ========
    {
        dialogPane.setLayout(new GridBagLayout());
        ((GridBagLayout)dialogPane.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)dialogPane.getLayout()).rowHeights = new int[] {0, 0};
        ((GridBagLayout)dialogPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)dialogPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
    }
    contentPane.add(dialogPane, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

    //======== contentPanel ========
    {
        contentPanel.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {60, 180, 0};
        ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- usernameLable ----
        usernameLable.setText("\u7528\u6237\u540d\uff1a");
        contentPanel.add(usernameLable, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 7, 7), 0, 0));
        contentPanel.add(usernameTextField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 7, 0), 0, 0));

        //---- passwordLabel ----
        passwordLabel.setText("\u5bc6\u7801\uff1a");
        contentPanel.add(passwordLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 7, 7), 0, 0));
        contentPanel.add(passwordField, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 7, 0), 0, 0));

        //---- checkBoxOne ----
        checkBoxOne.setText("\u8bb0\u4f4f\u8d26\u53f7");
        contentPanel.add(checkBoxOne, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 7, 0), 0, 0));
        contentPanel.add(hSpacer1, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- loginButton ----
        loginButton.setText("login");
        loginButton.addActionListener(e -> loginButtonActionPerformed(e));
        contentPanel.add(loginButton, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- cancelButton ----
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
        contentPanel.add(cancelButton, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));
    }
    contentPane.add(contentPanel, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));
    setSize(310, 190);
    setLocationRelativeTo(getOwner());
    // JFormDesigner - End of component initialization  //GEN-END:initComponents
  }
}
