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
import javax.swing.JMenuBar;

/**
 *
 * @author Meldanor
 */
public class MenuBar extends JMenuBar {

    public MenuBar(MainFrame parent) {
        super();
        add(new FileMenu());
        add(new BlockMenu(parent));
    }

}
