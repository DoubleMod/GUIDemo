package com.githup.swing.entity;

import cn.hutool.core.date.DateUtil;

import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.LinkedList;

/**
 * TableModel 模型类
 *
 * @author lxw
 */
public class DataTabelModel extends AbstractTableModel {


    private static final String[] columnNames = {"column 1", "column 2"};
    private final LinkedList<DataModel> list;

    public DataTabelModel() {
        list = new LinkedList<DataModel>();
    }

    public void addElement(DataModel e) {
        // Adds the element in the last position in the list
        list.add(e);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getText();
            case 1:
                return "可领取";
            case 2:
                return list.get(rowIndex).getText().substring(list.get(rowIndex).getText().lastIndexOf("，") + 1);
            case 3:
                return DateUtil.format(new Date(list.get(rowIndex).getUploadtime() * 1000), "MM-dd HH:mm");
        }
        return null;
    }
}
