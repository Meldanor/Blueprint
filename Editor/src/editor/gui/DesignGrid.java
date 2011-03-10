/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.gui;

import editor.gui.designGrid.DesignGridRenderer;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Meldanor
 */
public class DesignGrid extends JTable {

    public DesignGrid() {
        try {
            this.setModel(new DefaultTableModel(10,10));
            this.setRowHeight(30);
            this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for(int j = 0 ; j < getColumnCount() ; ++j) {
                TableColumn col = this.getColumn(this.getModel().getColumnName(j));
                col.setWidth(30);
                col.setCellRenderer(new DesignGridRenderer());
                col.setResizable(false);
            }
        }
        catch (Exception ex) {

        }
        
    }
}
