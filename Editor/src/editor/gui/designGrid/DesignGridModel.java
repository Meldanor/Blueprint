/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.gui.designGrid;

import editor.Block;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Meldanor
 */
public class DesignGridModel extends DefaultTableModel{

    private JTable owner = null;

    public DesignGridModel() {

    }

    public DesignGridModel(int rowCount, int columnCount) {
        super(rowCount,columnCount);
    }

    public void initiate(JTable table) {
        owner = table;
        editColumns();
    }

    private void editColumns() {

         for (int j = 0; j < getColumnCount(); ++j) {
            TableColumn col = owner.getColumn(getColumnName(j));
            col.setWidth(32);
            col.setMaxWidth(32);
            col.setMinWidth(32);
            col.setResizable(false);
            col.setCellRenderer(new DesignGridRenderer());
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public void addColumn(Object columnName) {
        super.addColumn(columnName);
        this.editColumns();
    }


}
