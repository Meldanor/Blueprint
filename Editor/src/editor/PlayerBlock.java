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
    private int[] position = new int[3];
    private static Image image = null;

    public PlayerBlock (int[] position) {
        super(-1, image, "Player");
        this.position = position;
    }

    public PlayerBlock (int x, int y, int z) {
        this(new int[]{
                    x, y, z
                });
    }

    public static void loadImage () throws Exception {
        if (image == null)
            image = ImageIO.read(new File("res/icons/Player.png")).getScaledInstance(30, 30, Image.SCALE_FAST);
        else
            throw new Exception("The Image of the PlayerBlock was already loaded!");

    }

    public int[] getPosition () {
        return position;
    }

    public int getX () {
        return position[0];
    }

    public int getY () {
        return position[1];
    }

    public int getZ () {
        return position[2];
    }

    public void setNewPosition (int[] newPosition) {
        position = newPosition;
    }

    public void setNewPosition (int x, int y, int z) {
        setNewPosition(new int[]{
                    x, y, z
                });
    }

    public int[] differPosition (int[] otherPosition) {
        return new int[]{
                    position[0] - otherPosition[0],
                    position[1] - otherPosition[1],
                    position[2] - otherPosition[2],};
    }
}
