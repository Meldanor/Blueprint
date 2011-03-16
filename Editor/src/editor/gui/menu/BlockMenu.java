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

import editor.Block;
import editor.gui.MainFrame;
import editor.gui.designGrid.DesignGridModel;
import editor.gui.designGrid.DesignGridTable;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Meldanor
 */
public class BlockMenu extends JMenu {

    private DesignGridTable blockTable;

    public BlockMenu () {
        super("Block auswählen");
        initiate();
    }

    private void initiate () {
        blockTable = new DesignGridTable();
        int width = 1 + (int) Math.sqrt(Block.availableBlocks.size());
        DesignGridModel newModel = new DesignGridModel(width, width);
        blockTable.setModel(newModel);
        newModel.initiate(blockTable);
        blockTable.setRowHeight(32);

        blockTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged (ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;
                Block block = (Block) blockTable.getValueAt(blockTable.getSelectedRow(), blockTable.getSelectedColumn());
                if (block == null)
                    return;
                setIcon(new ImageIcon(block.getImage()));
                setText(block.getName());
                MainFrame.setCurrentBlock(block);
            }
        });
        blockTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        blockTable.setCellSelectionEnabled(true);
        loadImages(width);
        this.add(blockTable);
    }

    private void loadImages (int width) {
        int index = 0;
        int maxSize = Block.availableBlocks.size();
        for (int i = 0 ; maxSize > index && i < width ; ++i) {
            for (int j = 0 ; maxSize > index && j < width ; ++j, ++index) {
                blockTable.setValueAt(Block.availableBlocks.get(index), i, j);
            }
        }
    }
}
