/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.gui;

import editor.gui.menu.MenuBar;
import javax.swing.BoxLayout;
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
        this.setJMenuBar(new MenuBar());
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS));
        grid = new DesignGrid();
        add(grid);
        pack();
    }

}
