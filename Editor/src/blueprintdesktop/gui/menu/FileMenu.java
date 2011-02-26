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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Meldanor
 */
public class FileMenu  extends JMenu {

    private JMenuItem newMenuItem;
    private JMenuItem openMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem saveAsMenuItem;
    private JMenuItem exitMenuItem;

    public FileMenu() {
        super("Datei");
        initiate();
    }

    private void initiate() {
        newMenuItem = new JMenuItem("Neue Konstruktion");
        newMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });
        add(newMenuItem);

        openMenuItem = new JMenuItem("Öffnen");
        openMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });
        add(openMenuItem);

        saveMenuItem = new JMenuItem("Speichern");
        saveMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
                
            }

        });
        add(saveMenuItem);

        saveAsMenuItem = new JMenuItem("Speichern unter");
        saveAsMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });
        add(saveAsMenuItem);

        exitMenuItem = new JMenuItem("Beenden");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitMenuItem);
    }
}
