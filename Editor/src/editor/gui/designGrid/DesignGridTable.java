/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.gui.designGrid;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Meldanor
 */
public class DesignGridTable extends JTable {

    public DesignGridTable(DesignGridModel model) {
        
    }

    public DesignGridTable() {
        try {
            this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    


}
