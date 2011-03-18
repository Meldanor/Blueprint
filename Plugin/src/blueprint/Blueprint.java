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

package blueprint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/**
 *
 * @author Kilian Gaertner
 */
public class Blueprint {

    private Player owner = null;
    private ArrayList<BlueprintBlock> blocks = null;

    private static LinkedList<Blueprint> blueprints = new LinkedList<Blueprint>();

    public Blueprint(Player owner, File file) {
        this.owner = owner;
        try {
            loadBlocks(file);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
        blueprints.add(this);
    }

    private void loadBlocks(File file) throws Exception {
        BufferedReader bReader = new BufferedReader(new FileReader(file));
        int lineCount = 0;
        while(bReader.readLine() != null)
            ++lineCount;
        bReader.close();
        blocks = new ArrayList<BlueprintBlock>(lineCount - 1);
        bReader = new BufferedReader(new FileReader(file));
        // skip the player block line, it's just necessary for the editor
        String line = bReader.readLine();
        
        String[] split = null;
        int x = 0;
        int y = 0;
        int z = 0;
        int typeID = 0;
        Block playerBlock = owner.getLocation().getBlock();
        
        while ((line = bReader.readLine()) != null) {
            split = line.split(",");
            x = Integer.parseInt(split[0]);
            y = Integer.parseInt(split[1]);
            z = Integer.parseInt(split[2]);
            typeID = Integer.parseInt(split[3]);
            Block block = playerBlock.getRelative(x, z, y);
            blocks.add(new BlueprintBlock(block,typeID));
        }

        for (BlueprintBlock block : blocks)
            block.convertToGlass();
    }

    public void buildBlueprint() {
        for (BlueprintBlock block : blocks)
            block.convertToRealBlock();
    }

    public ArrayList<Block> getBlocks() {
        return null;
    }
    
    public Player getOwner() {
        return owner;
    }

    private void cancelBlueprint() {
        for (BlueprintBlock block : blocks)
            block.convertToOriginalBlock();
    }

    public static Blueprint getBlueprint(Player owner) {
        for (Blueprint blueprint : blueprints)
            if (owner.getEntityId() == blueprint.getOwner().getEntityId())
                return blueprint;
        return null;
    }

    public static LinkedList<Blueprint> getBlueprints() {
        return blueprints;
    }

    public static void cancelBlueprint(Player owner) {
        for (Blueprint blueprint : blueprints) {
            if (owner.getEntityId() == blueprint.getOwner().getEntityId()){
                blueprint.cancelBlueprint();
            }
        }
    }
}
