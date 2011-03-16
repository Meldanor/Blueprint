/*
 *  Copyright (C) 2011 Kilian Gaertner
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package editor.gui.designGrid;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Meldanor
 */
public class DesignGridModel extends DefaultTableModel {

    private JTable owner = null;

    public DesignGridModel () {
    }

    public DesignGridModel (int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }

    public void initiate (JTable table) {
        owner = table;
        editColumns();
    }

    private void editColumns () {

        for (int j = 0 ; j < getColumnCount() ; ++j) {
            TableColumn col = owner.getColumn(getColumnName(j));
            col.setWidth(32);
            col.setMaxWidth(32);
            col.setMinWidth(32);
            col.setResizable(false);
            col.setCellRenderer(new DesignGridRenderer());
        }
    }

    @Override
    public boolean isCellEditable (int row, int column) {
        return false;
    }

    @Override
    public void addColumn (Object columnName) {
        super.addColumn(columnName);
        this.editColumns();
    }
}
