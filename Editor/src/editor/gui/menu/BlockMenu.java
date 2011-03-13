/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.gui.menu;

import editor.Block;
import editor.gui.designGrid.DesignGridModel;
import editor.gui.designGrid.DesignGridRenderer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Meldanor
 */
public class BlockMenu extends JMenu {

    public BlockMenu(String name) {
        super(name);
        initiate();
    }

    private void initiate() {
        this.add(new BlockTable());
    }


    private class BlockTable extends JTable {

        public BlockTable() {
            initiate();
        }

        private void initiate() {
            int width = 1 + (int) Math.sqrt(Block.availableBlocks.size());
            
            this.setModel(new DesignGridModel(width,width));

            setRowHeight(32);
            for (int j = 0; j < getColumnCount(); ++j) {
                TableColumn col = this.getColumn(this.getModel().getColumnName(j));
                col.setWidth(32);
                col.setMaxWidth(32);
                col.setMinWidth(32);
                col.setResizable(false);
                col.setCellRenderer(new DesignGridRenderer());
            }

            loadImages(width);

            this.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {

                }
                @Override
                public void mousePressed(MouseEvent e) {
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                }
                @Override
                public void mouseExited(MouseEvent e) {
                }
                
            });
        }

        private void loadImages(int width) {
            int index = 0;
            int maxSize = Block.availableBlocks.size();
            for (int i = 0 ; maxSize > index && i < width ; ++i ) {
                for (int j = 0 ; maxSize > index && j < width ; ++j, ++index) {
                    try {
                        this.setValueAt(Block.availableBlocks.get(index).getImage(), i, j);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("i = "+i);
                        System.out.println("j = "+j);
                        System.out.println("index = "+index);
                        System.out.println("width = "+width);
                    }
                    
                }
            }
        }
    }
}
