/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.gui;

import javax.swing.JFrame;

/**
 *
 * @author Meldanor
 */
public class MainFrame extends JFrame{

    DesignGrid grid = null;

    public MainFrame() {
        initiate();
    }

    private void initiate() {
        grid = new DesignGrid();
        add(grid);
    }

}
