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

package editor.gui;

import editor.Block;
import editor.Layer;
import editor.PlayerBlock;
import editor.gui.designGrid.DesignGridModel;
import editor.gui.designGrid.DesignGridTable;
import editor.gui.menu.MenuBar;
import io.SaveSystem;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Meldanor
 */
public class MainFrame extends JFrame {

    private DesignGridTable grid = null;
    private DesignGridModel gridModel = null;
    private static Block currentBlock = null;
    private SaveSystem saveSystem = new SaveSystem();

    public MainFrame () {
        initiate();
    }

    private void initiate () {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(new MenuBar(saveSystem));
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.LINE_AXIS));

//        addTopButtons();
//        addLeftButtons();
//        addButtomButtons();
//        addRightButtons();

        createTable(null);
        
        pack();
        this.setLocationRelativeTo(null);
    }

    private void addLeftButtons () {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        JButton button = new JButton("+");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                grid.addColumn(new TableColumn());
                grid.moveColumn(grid.getColumnCount() - 1, 0);
            }
        });
        buttonPanel.add(button);
        button = new JButton("-");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                grid.removeColumn(grid.getColumn(gridModel.getColumnName(0)));
            }
        });
        buttonPanel.add(button);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.WEST);
    }

    private void addButtomButtons () {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        JButton button = new JButton("+");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                gridModel.addRow(new Object[0]);
            }
        });
        buttonPanel.add(button);
        button = new JButton("-");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                gridModel.removeRow(gridModel.getRowCount() - 1);
            }
        });
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addRightButtons () {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        JButton button = new JButton("+");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                grid.addColumn(new TableColumn());
            }
        });
        buttonPanel.add(button);
        button = new JButton("-");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                grid.removeColumn(grid.getColumn(gridModel.getColumnName(gridModel.getColumnCount() - 1)));
            }
        });
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.EAST);
    }

    private void addTopButtons () {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        JButton button = new JButton("+");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                gridModel.insertRow(0, new Object[0]);
            }
        });
        buttonPanel.add(button);
        button = new JButton("-");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                gridModel.removeRow(0);
            }
        });
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.NORTH);
    }

    private void createTable (File loadedFile) {
        grid = new DesignGridTable();
        if (loadedFile == null)
            gridModel = saveSystem.createNewBlueprint();
        grid.setModel(gridModel);
        gridModel.initiate(grid);
        grid.setRowHeight(32);
        grid.addMouseListener(new ClickListener());
        JScrollPane scrollPane = new JScrollPane(grid);
        grid.setTableHeader(null);
        grid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        grid.setCellSelectionEnabled(true);
        add(scrollPane);
    }

    public static void setCurrentBlock (Block block) {
        currentBlock = block;
    }

    private class ClickListener implements MouseListener {

        @Override
        public void mouseClicked (MouseEvent e) {
            
        }

        @Override
        public void mousePressed (MouseEvent e) {
            if (currentBlock == null)
                return;
            int row = grid.rowAtPoint(e.getPoint());
            int col = grid.columnAtPoint(e.getPoint());
            if (currentBlock.isPlayerBlock()) {
                PlayerBlock playerBlock = saveSystem.getPlayerBLock();
                if (playerBlock == null)
                    saveSystem.initiatePlayerBlock(col, row, ((Layer) gridModel).getIndex());
                else {
                    grid.setValueAt(null, playerBlock.getY(), playerBlock.getX());
                    playerBlock.setNewPosition(col, row, ((Layer) gridModel).getIndex());
                }
            }


            grid.setValueAt(currentBlock, row, col);
        }

        @Override
        public void mouseReleased (MouseEvent e) {
        }

        @Override
        public void mouseEntered (MouseEvent e) {
        }

        @Override
        public void mouseExited (MouseEvent e) {
        }
    }

}
