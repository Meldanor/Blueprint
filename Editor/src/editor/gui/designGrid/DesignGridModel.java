/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.gui.designGrid;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Meldanor
 */
public class DesignGridModel extends DefaultTableModel{

    public DesignGridModel(int rowCount, int columnCount) {
        super(rowCount,columnCount);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }




}
