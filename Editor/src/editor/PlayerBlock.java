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

package editor;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Kilian Gaertner
 */
public class PlayerBlock extends Block {

    /** Represents the x,y and z-Coordinates of the Block. The z-Coordinate
    represents the index of the layers. */
    private int x;
    private int y;
    private int z;
    private static Image image = null;


    public PlayerBlock (int x, int y, int z) {
        super(-1, image, "Player");
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void loadImage () throws Exception {
        if (image == null)
            image = ImageIO.read(new File("res/icons/Player.png")).getScaledInstance(30, 30, Image.SCALE_FAST);
        else
            throw new Exception("The Image of the PlayerBlock was already loaded!");

    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }

    public int getZ () {
        return z;
    }


    public void setNewPosition (int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int[] differPosition (int x, int y, int z) {
        return new int[]{
                    this.x - x,
                    this.y - y,
                    this.z - z};
    }

    public String getPositionAsString() {
        return x + "," + y + "," + z;
    }
}
