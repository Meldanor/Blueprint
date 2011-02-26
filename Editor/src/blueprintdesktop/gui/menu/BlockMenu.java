/*
 *  Copyright (C) 2011 by Kilian Gaertner
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

package blueprintdesktop.gui.menu;

import blueprintdesktop.gui.MainFrame;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author Meldanor
 */
public class BlockMenu extends JMenu {

    private MainFrame mainFrame = null;

    public BlockMenu(MainFrame parent) {
        super("Block");
        this.mainFrame = parent;
        add(new BlockPanel(this));
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

}
