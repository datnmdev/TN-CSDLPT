package com.ptithcm.tn_csdlpt.view;
        
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

public class CustomTabbedPane extends JTabbedPane {
    private final Color bgColor = new Color(245, 245, 245);
    private final Color textColor = new Color(51, 51, 51);
    private final Color selectedTextColor = new Color(0, 0, 0);
    private final Font font = new Font("Segoe UI", Font.PLAIN, 14);
    private JTabbedPane _this = this;

    public CustomTabbedPane() {
        super();
        setOpaque(true);
        setBackground(bgColor);
        setForeground(textColor);
        setFont(font);
        setTabPlacement(JTabbedPane.TOP);
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    @Override
    public void addTab(String title, Component component) {
        // Create a FlowLayout that will space things 5px apart
        BorderLayout tabLayout = new BorderLayout(20, 0);
        
        // Create a JPanel to be used as the tab component
        JPanel tabComponent = new JPanel(tabLayout);
        tabComponent.setOpaque(false);
        
        // Create a JLabel to display the title text
        JLabel titleLabel = new JLabel(title);
        
        // Create a JButton to act as the "close" button
        JButton closeButton = new JButton();
        closeButton.setUI(new BasicButtonUI());
        closeButton.setIcon(new ImageIcon(getClass().getResource("/icons/12x12/close.png")));
        closeButton.setRolloverIcon(new ImageIcon(getClass().getResource("/icons/12x12/close-hover.png")));
//        closeButton.setPressedIcon(new ImageIcon(getClass().getResource("/icons/12x12/close-pressed.png")));
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusable(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder());
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = indexOfComponent(component);
                if (index != -1) {
                    removeTabAt(index);
                }
            }
        });
        
        // Add the components to the tab component panel
        tabComponent.add(titleLabel, BorderLayout.CENTER);
        tabComponent.add(closeButton, BorderLayout.EAST);
        
        // Add the tab with the content and custom tab component
        super.addTab(null, component);
        setTabComponentAt(getTabCount() - 1, tabComponent);
    }

    @Override
    public void setSelectedIndex(int index) {
        super.setSelectedIndex(index);
        for (int i = 0; i < getTabCount(); i++) {
            Component component = getTabComponentAt(i);
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                if (i == index) {
                    label.setForeground(selectedTextColor);
                    label.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, selectedTextColor));
                } else {
                    label.setForeground(textColor);
                    label.setBorder(new EmptyBorder(10, 10, 10, 10));
                }
            }
        }
    }

    @Override
    public void setTabComponentAt(int index, Component component) {
        super.setTabComponentAt(index, component);
        if (component instanceof JLabel) {
            JLabel label = (JLabel) component;
            label.setForeground(textColor);
            label.setFont(font);
            label.setBorder(new EmptyBorder(10, 10, 10, 10));
        }
    }
}
