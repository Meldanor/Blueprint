/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.gui.menu;

import javax.swing.JMenuBar;

/**
 *
 * @author Meldanor
 */
public class MenuBar extends JMenuBar {

    public MenuBar() {
        initiate();
    }

    private void initiate() {
        add(new BlockMenu("Block"));
    }
}
