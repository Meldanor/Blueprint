/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.gui.designGrid;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Meldanor
 */
public class DesignGridRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
      if (value instanceof Image) {
          JLabel label = (JLabel) super.getTableCellRendererComponent(
                         table, value, isSelected, hasFocus,
                         row, column);
          // Lediglich Text und Grafik anpassen
          if (value != null) {
            label.setText("");
            label.setIcon(new ImageIcon((Image)value));
          }
          return label;
        }

      return null;
    }

}