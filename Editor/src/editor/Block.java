/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor;

import java.awt.Image;
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
    private Image image;
    private String name;
    
    public static ArrayList<Block> availableBlocks = new ArrayList<Block>();

    public Block(int id, Image image, String name) {
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

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public static void loadBlocks() {
        try {
            BufferedReader bReader = new BufferedReader(new FileReader("res/block.txt"));
            String line = "";
            while ((line = bReader.readLine()) != null) {
                if (line.isEmpty())
                    continue;
                String[] split = line.split(",");
                BufferedImage bImage = ImageIO.read(new File("res/icons/".concat(split[0])));
                int id = Integer.parseInt(split[1]);
                String name = split[2];
                Block block = new Block(id,bImage.getScaledInstance(30, 30, Image.SCALE_FAST),name);
                availableBlocks.add(block);
            }
            Block playerBlock = new Block(-1,ImageIO.read(new File("res/icons/Player.png")).getScaledInstance(30, 30, Image.SCALE_FAST),"Player");
            availableBlocks.add(playerBlock);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
