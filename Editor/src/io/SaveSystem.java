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

import editor.Layer;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Kilian Gaertner
 */
public class SaveSystem {

    private ArrayList<Layer> layers = new ArrayList<Layer>();
    private int currentIndex;
    private File currentSaveFile;

    public SaveSystem () {
    }

    public Layer createNewBlueprint () {
        Layer firstLayer = new Layer();
        layers.add(firstLayer);
        currentIndex = 0;
        return firstLayer;
    }

    public void save () {
        saveBlueprint();
    }

    public void saveAs (File targetFile) {
        currentSaveFile = targetFile;
        saveBlueprint();
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

    private void saveBlueprint () {
    }
}
