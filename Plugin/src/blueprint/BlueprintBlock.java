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

import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 *
 * @author Kilian Gaertner
 */
public class BlueprintBlock {

    private Block block;
    private int originalID;
    private int blueprintID;

    public BlueprintBlock(Block block, int typeID) {
        this.block = block;
        originalID = block.getTypeId();
        this.blueprintID = typeID;
    }

    public int getTypeID() {
        return blueprintID;
    }

    public void convertToGlass() {
        block.setType(Material.GLASS);
    }

    public void convertToRealBlock() {
        block.setType(Material.getMaterial(blueprintID));
    }

    public void convertToOriginalBlock() {
        block.setType(Material.getMaterial(originalID));
    }
}
