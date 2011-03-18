/*
 *  Copyright (C) 2011 Kilian Gaertner
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

package editor.gui.menu;

import io.SaveSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Meldanor
 */
public class FileMenu extends JMenu {

    private SaveSystem saveSystem;

    public FileMenu (SaveSystem saveSystem) {
        super("File");
        this.saveSystem = saveSystem;
        initiate();
    }

    private void initiate () {
        JMenuItem newFileItem = new JMenuItem("New Blueprint");
        newFileItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                createNewFile();
            }
        });
        add(newFileItem);

        JMenuItem openFileItem = new JMenuItem("Load Blueprint");
        openFileItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                openBlueprintFile();
            }
        });
        add(openFileItem);

        JMenuItem saveFileItem = new JMenuItem("Save Blueprint");
        saveFileItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                saveBlueprintFile();
            }
        });
        add(saveFileItem);

        JMenuItem saveAsFileItem = new JMenuItem("Save Blueprint as...");
        saveAsFileItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                saveAsBlueprintFile();
            }
        });
        add(saveAsFileItem);

        JMenuItem quitItem = new JMenuItem("Exit");
        quitItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                if (true)
                    System.exit(0);
            }
        });
        add(quitItem);
    }

    private void openBlueprintFile () {
    }

    private void createNewFile () {
    }

    private void saveBlueprintFile () {
        if (saveSystem.getPlayerBLock() == null) {
            JOptionPane.showMessageDialog(this, "Please place at first the player Block.");
            return;
        }
        if (saveSystem.getCurrentSaveFile() == null)
            saveAsBlueprintFile();
        else
            saveSystem.save();
    }

    private void saveAsBlueprintFile () {
        if (saveSystem.getPlayerBLock() == null) {
            JOptionPane.showMessageDialog(this, "Please place at first the player Block.");
            return;
        }
        JFileChooser saveFileChooser = new JFileChooser(saveSystem.getCurrentSaveFile());
        saveFileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        saveFileChooser.showOpenDialog(this);
        File saveFile = saveFileChooser.getSelectedFile();
        if (saveFile != null)
             if (!saveSystem.saveAs(saveFile))
                 JOptionPane.showMessageDialog(this, "The save was not sucessfull!");
             

    }
}
