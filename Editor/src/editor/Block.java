/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Meldanor
 */
public class Block {

    private int id;
    private BufferedImage image;
    private String name;
    
    public static ArrayList<Block> availableBlocks = new ArrayList<Block>();

    public Block(int id, BufferedImage image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    public static ArrayList<Block> getAvailableBlocks() {
        return availableBlocks;
    }

    public int getId() {
        return id;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public static void loadBlocks() {
        try {
            BufferedImage bImage = ImageIO.read(new File("res/terrain.png"));
            int resolution = bImage.getHeight() / 16;
            BufferedReader bReader = new BufferedReader(new FileReader("res/block.txt"));
            String line = "";
            while ((line = bReader.readLine()) != null) {
                if (line.isEmpty())
                    continue;
                String[] split = line.split(",");
                int id = Integer.parseInt(split[3]);
                int y = Integer.parseInt(split[0]);
                int x = Integer.parseInt(split[1]);
                String name = split[2];
                Block block = new Block(id,bImage.getSubimage(x * resolution, y * resolution, resolution, resolution),name);
                availableBlocks.add(block);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
