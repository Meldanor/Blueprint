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

import blueprintdesktop.BlueprintBlock;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author Meldanor
 */
public class BlockPanel extends JPanel{

    private ArrayList<BlueprintBlock> blockTypes = new ArrayList<BlueprintBlock>(16*16);
    private BlockMenu blockMenu = null;
    private ButtonGroup blockGroup = new ButtonGroup();

    public BlockPanel(BlockMenu blockMenu) {
        readBlocks();
        showBlocks();
        this.blockMenu = blockMenu;
    }
    private void readBlocks() {

        File template = new File("res/Block Location.txt");
        try {
            BufferedImage bImage = ImageIO.read(new File("res/terrain.png"));
            BufferedReader bReader = new BufferedReader(new FileReader(template));
            String line = "";
            while ((line = bReader.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;
                String[] split = line.split(",");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                String name = null;
                if (split.length == 3)
                    name = split[2];
                blockTypes.add(new BlueprintBlock(x,y,name,bImage));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showBlocks() {
        this.setLayout(new java.awt.GridLayout(16,16));
        ItemListener iL = new VoteItemListener();
        for(BlueprintBlock block : blockTypes) {
            BlockButton button = new BlockButton(block);
            button.addItemListener(iL);
            blockGroup.add(button);
            add(button);
        }
    }

    protected void close() {
        ((JPopupMenu)(this.getParent())).setVisible(false);
    }

    private class VoteItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent ex) {
            BlockButton button = (BlockButton)ex.getItemSelectable();
            ImageIcon icon = button.getImageIcon();
            blockMenu.setIcon(icon);
            close();
        }
    }
}
