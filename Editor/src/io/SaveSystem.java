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

package io;

import editor.Block;
import editor.Layer;
import editor.PlayerBlock;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Kilian Gaertner
 */
public class SaveSystem {

    private ArrayList<Layer> layers = new ArrayList<Layer>();
    private int currentIndex;
    private File currentSaveFile;
    private PlayerBlock playerBlock ;

    public SaveSystem () {
    }

    public Layer createNewBlueprint () {
        Layer firstLayer = new Layer();
        layers.add(firstLayer);
        currentIndex = 0;
        return firstLayer;
    }

    public boolean save () {
        return saveBlueprint();
    }

    public boolean saveAs (File targetFile) {
        currentSaveFile = targetFile;
        return saveBlueprint();
    }

    public Layer getLayer (int index) {
        currentIndex = index;
        return layers.get(index);

    }

    public Layer getUpperLayer () {
        if (currentIndex + 1 < layers.size())
            return layers.get(++currentIndex);
        else
            return null;
    }

    public Layer getButtomLayer () {
        if (currentIndex - 1 >= 0)
            return layers.get(--currentIndex);
        else
            return null;
    }

    public int getCurrentLayerIndex () {
        return currentIndex;
    }

    public File getCurrentSaveFile () {
        return currentSaveFile;
    }

    private boolean saveBlueprint () {
        BufferedWriter bWriter = null;
        try {
            bWriter = new BufferedWriter(new FileWriter(currentSaveFile));
            // Store the PlayerBlock at first

            bWriter.write(playerBlock.getPositionAsString());
            bWriter.newLine();

            for(Layer layer : layers) {
                for(int row = 0 ; row < layer.getRowCount() ; ++row) {
                    for (int col = 0 ; col < layer.getColumnCount() ; ++col) {
                        Object o = layer.getValueAt(row, col);
                        if (o != null) {
                            Block block = (Block)o;
                            if (!(block instanceof PlayerBlock)) {
                                int[] diffPos = playerBlock.differPosition(col, row, layer.getIndex());
                                bWriter.write(layer.getIndex()+",");
                                bWriter.write(diffPos[0]+",");
                                bWriter.write(diffPos[1]+",");
                                bWriter.write(diffPos[2]+",");
                                bWriter.write(block.getId()+",");
                                bWriter.newLine();
                            }
                        }
                    }
                }
                bWriter.flush();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }
        finally {
            try {
                if (bWriter != null)
                    bWriter.close();
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public PlayerBlock getPlayerBLock() {
        return playerBlock;
    }

    public void initiatePlayerBlock(int x, int y, int z) {
        if (playerBlock == null)
            playerBlock = new PlayerBlock(x,y,z);
        else
            throw new RuntimeException();
    }
}
