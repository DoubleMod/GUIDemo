package com.githup.swing.windowOne; /*
 * Created by JFormDesigner on Mon Jan 13 18:18:58 CST 2020
 */


import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.githup.swing.entity.DataModel;
import com.githup.swing.entity.DataTabelModel;
import com.githup.swing.utils.InfoUtil;
import com.githup.swing.utils.MsgUtil;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import net.coobird.thumbnailator.Thumbnails;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * @author unknown
 */
public class WindowOne extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    private JLabel pic_label;
    private JLabel title;
    private JLabel link_title;
    private JTextField link_field;
    private JLabel tao_title;
    private JTextField tao_field;
    private JLabel gold_title;
    private JLabel gold_label;
    private JLabel time_title;
    private JLabel time_label;
    private JPanel toolbarPanel;
    private JButton cancelButton;
    private JButton okButton;
    private JPopupMenu m_popupMenu;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private HashMap hashBacket;
    private List dataModels;
    private InfoUtil infoUtil;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public static void main(String[] args) {

//        FontUIResource fontRes = new FontUIResource(new Font("微软雅黑", Font.PLAIN, 12));
//        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
//            Object key = keys.nextElement();
//            Object value = UIManager.get(key);
//            if (value instanceof FontUIResource) {
//                UIManager.put(key, fontRes);
//            }
//        }
        try {
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);
            //BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("set skin fail!");
        }

        new WindowOne().setVisible(true);
    }

    public WindowOne() {

        initComponents();
        refreshTableData();
        List<DataModel> list = JSONObject.parseArray(JSONObject.toJSONString(dataModels), DataModel.class);
        list.forEach(dataModel -> hashBacket.put(dataModel.getId(), dataModel.getId()));
        new RefreshTableTimer();

        // 加载图片
//    ImageIcon icon = new ImageIcon("src/main/java/find.png");
        // 将图片放入label中
//    JLabel label = new JLabel(icon);
        // 设置label的大小
//    label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        // 获取窗口的第二层，将label放入
//    getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        // 获取frame的顶层容器,并设置为透明
//    contentPanel.setOpaque(false);
//    // 必须设置为透明的。否则看不到图片
//    contentPanel.setOpaque(false);
//    setSize(icon.getIconWidth(), icon.getIconHeight());
        setVisible(true);
        infoUtil.show("提示", "欢迎使用！");
    }

    private void refreshTableData() {

        String string = HttpUtil.get("https://api.2xb.cn/web_api/yuyuzhe/getdata.php?pageSize=10");
        dataModels = JSONObject.parseArray(JSONObject.parseObject(string).getString("data"));
        DataTabelModel dataTabelModel = new DataTabelModel();
        for (Object object : dataModels) {
            DataModel dataModel = JSONObject.parseObject(JSONObject.toJSONString(object), DataModel.class);
            dataTabelModel.addElement(dataModel);
        }
        // 创建指定列名和数据的表格
        TableColumnModel tableColumnModel = new DefaultTableColumnModel();
        TableColumn aColumn = new TableColumn(0, 300);
        aColumn.setHeaderValue("标题");
        tableColumnModel.addColumn(aColumn);
        TableColumn aColumn1 = new TableColumn(1, 15);
        aColumn1.setHeaderValue("状态");
        tableColumnModel.addColumn(aColumn1);
        TableColumn aColumn2 = new TableColumn(2, 30);
        aColumn2.setHeaderValue("金额");
        tableColumnModel.addColumn(aColumn2);
        TableColumn aColumn3 = new TableColumn(3, 40);
        aColumn3.setHeaderValue("更新时间");
        tableColumnModel.addColumn(aColumn3);

        table1.setRowHeight(25);
        table1.setModel(dataTabelModel);
        table1.setColumnModel(tableColumnModel);

        table1.validate();
        scrollPane1.validate();
        scrollPane1.setViewportView(table1);

    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void okButtonActionPerformed(ActionEvent e) {

        String string = HttpUtil.get("https://api.2xb.cn/web_api/yuyuzhe/getdata.php?pageSize=10");
        dataModels = JSONObject.parseArray(JSONObject.parseObject(string).getString("data"));
        DataTabelModel dataTabelModel = new DataTabelModel();
        for (Object object : dataModels) {
            DataModel dataModel = JSONObject.parseObject(JSONObject.toJSONString(object), DataModel.class);
            dataTabelModel.addElement(dataModel);
        }
        // 创建指定列名和数据的表格
        TableColumnModel tableColumnModel = new DefaultTableColumnModel();
        tableColumnModel.addColumn(new TableColumn(0, 240));
        tableColumnModel.addColumn(new TableColumn(1, 12));
        tableColumnModel.addColumn(new TableColumn(2, 30));
        tableColumnModel.addColumn(new TableColumn(3, 43));
        table1.setRowHeight(25);
        table1.setModel(dataTabelModel);
        table1.setColumnModel(tableColumnModel);

        table1.validate();
        scrollPane1.validate();
        scrollPane1.setViewportView(table1);

    }


    /**
     * 表格点击事件
     *
     * @param e 事件
     */
    private void table1MouseClicked(MouseEvent e) {
        // TODO add your code here
        try {
            int selectedRow = table1.getSelectedRow();
            if (selectedRow == -1) {
                return;
            }
            Object object = dataModels.get(selectedRow);
            DataModel dataModel = JSONObject.parseObject(JSONObject.toJSONString(object), DataModel.class);
            //判断是否为鼠标的BUTTON3按钮，BUTTON3为鼠标右键
            if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) {
                //通过点击位置找到点击为表格中的行
                int focusedRowIndex = table1.rowAtPoint(e.getPoint());
                if (focusedRowIndex == -1) {
                    return;
                }
                //将表格所选项设为当前右键点击的行
                table1.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
                //弹出菜单
                m_popupMenu.show(table1, e.getX(), e.getY());
            } else if (e.getClickCount() == 1) {
                String pic = dataModel.getPic();
                if (!pic.isEmpty()) {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    Thumbnails.of(new URL("http:" + pic)).forceSize(165, 165).toOutputStream(outputStream);
                    pic_label.setIcon(new ImageIcon(outputStream.toByteArray()));
                }
                title.setText(dataModel.getText().length() > 30 ? dataModel.getText().substring(0, 30) + "..." : dataModel.getText());
                link_field.setText(dataModel.getUrl());
                tao_field.setText(dataModel.getTkl());
                gold_label.setText("可领取");
                time_label.setText(DateUtil.format(new Date(dataModel.getUploadtime() * 1000), "yyyy-MM-dd HH:mm:ss"));

            } else if (e.getClickCount() == 2) {
                System.out.println(selectedRow);
                //获取当前系统桌面扩展
                java.awt.Desktop dp = java.awt.Desktop.getDesktop();
                //判断系统桌面是否支持要执行的功能
                if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {//获取系统默认浏览器打开链接
                    dp.browse(java.net.URI.create(dataModel.getUrl()));
                }
            }

//                if (e.getClickCount() == 3) {
//                    textArea1.setText(dataModel.getUrl());
//                    URL url=new URL(dataModel.getUrl());
//                    BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
//                    BufferedWriter writer=new BufferedWriter(new FileWriter("index.html"));
//                    String line;
//                    while((line=reader.readLine())!=null){
//                        System.out.println(line);
//                        writer.write(line);
//                        writer.newLine();
//                    }
//                    reader.close();
//                    writer.close();
//                    System.out.println(line);
//                }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 菜单项点击事件
     *
     * @param e 事件
     */
    private void menuItem1MousePressed(MouseEvent e) {
        // TODO add your code here
        MsgUtil.msg("已复制到剪切板", 2);
        if (table1.getSelectedRow() > 0) {
            Object object = dataModels.get(table1.getSelectedRow());
            DataModel dataModel = JSONObject.parseObject(JSONObject.toJSONString(object), DataModel.class);
            // 获取系统剪贴板
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            // 封装文本内容
            Transferable trans = new StringSelection(dataModel.getTkl());
            // 把文本内容设置到系统剪贴板
            clipboard.setContents(trans, null);
        }
    }


    private void menuItem2MousePressed(MouseEvent e) {
        // TODO add your code here
        MsgUtil.msg("已复制到剪切板", 2);
        if (table1.getSelectedRow() > 0) {
            Object object = dataModels.get(table1.getSelectedRow());
            DataModel dataModel = JSONObject.parseObject(JSONObject.toJSONString(object), DataModel.class);
            // 获取系统剪贴板
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            // 封装文本内容
            Transferable trans = new StringSelection(dataModel.getUrl());
            // 把文本内容设置到系统剪贴板
            clipboard.setContents(trans, null);
        }
    }

    private void pic_labelMousePressed(MouseEvent e) {
        // TODO add your code here
//        infoUtil.setVisible(true);
    }

    private void thisWindowClosed(WindowEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    /**
     * 窗口初始化
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel1 = new JPanel();
        pic_label = new JLabel();
        title = compFactory.createTitle("");
        link_title = compFactory.createTitle("text");
        link_field = new JTextField();
        tao_title = compFactory.createTitle("text");
        tao_field = new JTextField();
        gold_title = compFactory.createTitle("text");
        gold_label = new JLabel();
        time_title = compFactory.createTitle("text");
        time_label = new JLabel();
        toolbarPanel = new JPanel();
        cancelButton = new JButton();
        okButton = new JButton();
        m_popupMenu = new JPopupMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        hashBacket = new HashMap();
        infoUtil = new InfoUtil();

        //======== this ========
        setTitle("\u6dd8\u793c\u91d1");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {258, 45, 158, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0, 0.0};

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== panel1 ========
        {
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {172, 95, 54, 234, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {43, 33, 30, 30, 26, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- pic_label ----
            pic_label.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    pic_labelMousePressed(e);
                }
            });
            panel1.add(pic_label, new GridBagConstraints(0, 0, 1, 5, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- title ----
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setVerticalAlignment(SwingConstants.BOTTOM);
            title.setEnabled(false);
            panel1.add(title, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- link_title ----
            link_title.setText("\u94fe\u63a5");
            panel1.add(link_title, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(link_field, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- tao_title ----
            tao_title.setText("\u6dd8\u53e3\u4ee4");
            panel1.add(tao_title, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(tao_field, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- gold_title ----
            gold_title.setText("\u793c\u91d1\u72b6\u6001");
            panel1.add(gold_title, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(gold_label, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- time_title ----
            time_title.setText("\u66f4\u65b0\u65f6\u95f4");
            panel1.add(time_title, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
            panel1.add(time_label, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== toolbarPanel ========
        {
            toolbarPanel.setVisible(false);
            toolbarPanel.setLayout(new GridBagLayout());
            ((GridBagLayout)toolbarPanel.getLayout()).columnWidths = new int[] {149, 149, 242, 0};
            ((GridBagLayout)toolbarPanel.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)toolbarPanel.getLayout()).columnWeights = new double[] {1.0, 1.0, 0.0, 1.0E-4};
            ((GridBagLayout)toolbarPanel.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

            //---- cancelButton ----
            cancelButton.setText("Cancel");
            cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
            toolbarPanel.add(cancelButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- okButton ----
            okButton.setText("OK");
            okButton.addActionListener(e -> okButtonActionPerformed(e));
            toolbarPanel.add(okButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(toolbarPanel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        setSize(570, 530);
        setLocationRelativeTo(getOwner());

        //======== m_popupMenu ========
        {

            //---- menuItem1 ----
            menuItem1.setText("\u590d\u5236\u53e3\u4ee4");
            menuItem1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    menuItem1MousePressed(e);
                }
            });
            m_popupMenu.add(menuItem1);

            //---- menuItem2 ----
            menuItem2.setText("\u590d\u5236\u94fe\u63a5");
            menuItem2.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    menuItem2MousePressed(e);
                }
            });
            m_popupMenu.add(menuItem2);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    class RefreshTableTimer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            refreshTableData();
            List<DataModel> list = JSONObject.parseArray(JSONObject.toJSONString(dataModels), DataModel.class);
            for (DataModel dataModel : list) {
                String id = dataModel.getId();
                if (!hashBacket.containsKey(id)) {
                    infoUtil.setWord(dataModel.getText());
                    infoUtil.setVisible(true);
                    hashBacket.put(id, id);
                }
            }
        }

        public RefreshTableTimer() {
            //设置Timer定时器，并启动
            Timer timer = new Timer(10000, this);
            timer.start();
        }
    }

}
