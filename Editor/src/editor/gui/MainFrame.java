/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.gui;

import editor.Block;
import editor.gui.designGrid.DesignGridModel;
import editor.gui.designGrid.DesignGridTable;
import editor.gui.menu.MenuBar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableColumn;

/**
 *
 * @author Meldanor
 */
public class MainFrame extends JFrame{

    private DesignGridTable grid = null;
    private DesignGridModel gridModel = null;
    private static Block currentBlock = null;

    public MainFrame() {
        initiate();
    }

    private void initiate() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(new MenuBar());
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.LINE_AXIS));
//
//        addTopButtons();
//        addLeftButtons();
//        addButtomButtons();
//        addRightButtons();
        createTable();
        pack();
    }


    private void addLeftButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        JButton button = new JButton("+");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                grid.addColumn(new TableColumn());
                grid.moveColumn(grid.getColumnCount()-1, 0);
            }
        });
        buttonPanel.add(button);
        button = new JButton("-");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                grid.removeColumn(grid.getColumn(gridModel.getColumnName(0)));
            }
        });
        buttonPanel.add(button);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel,BorderLayout.CENTER);
        add(panel, BorderLayout.WEST);
    }


    private void addButtomButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        JButton button = new JButton("+");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gridModel.addRow(new Object[0]);
            }
        });
        buttonPanel.add(button);
        button = new JButton("-");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gridModel.removeRow(gridModel.getRowCount()-1);
            }
        });
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addRightButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        JButton button = new JButton("+");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                grid.addColumn(new TableColumn());
            }
        });
        buttonPanel.add(button);
        button = new JButton("-");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                grid.removeColumn(grid.getColumn(gridModel.getColumnName(gridModel.getColumnCount()-1)));
            }
        });
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.EAST);
    }

    private void addTopButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        JButton button = new JButton("+");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gridModel.insertRow(0, new Object[0]);
            }
        });
        buttonPanel.add(button);
        button = new JButton("-");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gridModel.removeRow(0);
            }
        });
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.NORTH);
    }

    private void createTable() {
        grid = new DesignGridTable();
        gridModel = new DesignGridModel(100,100);
        grid.setModel(gridModel);
        gridModel.initiate(grid);
        grid.setRowHeight(32);
        grid.addMouseListener(new ClickListener());
        JScrollPane scrollPane = new JScrollPane(grid);
        grid.setTableHeader(null);
        add(scrollPane);
        grid.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        JScrollBar vBar = new JScrollBar(JScrollBar.HORIZONTAL);
//
//        scrollPane.setHorizontalScrollBar(vBar);
//        scrollPane.setVerticalScrollBar(new JScrollBar(JScrollBar.VERTICAL));
//        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//
//        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setSize(new Dimension(100    ,100));
    }

    public static void setCurrentBlock(Block block) {
        currentBlock = block;
    }

    private class ClickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (currentBlock == null)
                return;
           int row = grid.rowAtPoint(e.getPoint());
           int col = grid.columnAtPoint(e.getPoint());
           grid.setValueAt(currentBlock, row, col);
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


    }
}
