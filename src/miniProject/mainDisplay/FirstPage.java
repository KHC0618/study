package com.multi.h_1.mainDisplay;

import javax.swing.*;
import java.awt.*;

public class FirstPage {
    private JFrame f;
    private Font font1 = new Font("굴림", Font.BOLD, 50);
    private Font font2 = new Font("굴림", Font.BOLD, 20);
    private JPanel headerP;
    private JPanel midP;
    private JPanel footerP;

    public FirstPage() {
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 800);
        f.setTitle("코마에 사칙연산 게임");

        initHeaderP();
        initMidP();
        initFooterP();

        f.add(headerP, BorderLayout.PAGE_START);
        f.add(midP, BorderLayout.CENTER);
        f.add(footerP, BorderLayout.PAGE_END);

        f.setVisible(true);
    }

    private void initHeaderP() {
        headerP = new JPanel(); // 위
        headerP.setBackground(new Color(40, 60, 79));
        headerP.setBorder(BorderFactory.createEmptyBorder(20 , 0,  0, 0)); // 여백(=padding)

        JButton menuBtn1 = new JButton("menu1");
        JButton menuBtn2 = new JButton("menu2");
        JButton menuBtn3 = new JButton("menu3");
        JButton menuBtn4 = new JButton("menu4");
        JButton menuBtn5 = new JButton("menu5");

        JButton[] jButtons = {menuBtn1, menuBtn2, menuBtn3, menuBtn4, menuBtn5};

        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i].setFont(font2);
            jButtons[i].setBackground(new Color(63,228,192));
            headerP.add(jButtons[i]);
        }
    }

    private void initMidP() {
        midP = new JPanel(); // 가운데
        midP.setBackground(new Color(40, 60, 79));
        midP.setBorder(BorderFactory.createEmptyBorder(50 , 0, 0 , 0)); // 여백(=padding)

        JLabel titleL = new JLabel("코마에 사칙연산 게임");
        titleL.setFont(font1);
        titleL.setForeground(Color.white);
        titleL.setBorder(BorderFactory.createEmptyBorder(0 , 0, 20 , 0)); // 여백(=padding)
        midP.add(titleL);

        ImageIcon mainImg = new ImageIcon("img/img.png");
        JLabel imgL = new JLabel();
        imgL.setIcon(mainImg);
        midP.add(imgL);

    }


    private void initFooterP() {
        footerP = new JPanel(); // 아래
        footerP.setBackground(new Color(40, 60, 79));
        footerP.setBorder(BorderFactory.createEmptyBorder(0 , 0, 100 , 0)); // 여백(=padding)
        JButton startBtn = new JButton("START");
        startBtn.setBorderPainted(false);
        startBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백(=padding)
        startBtn.setFont(font1);
        startBtn.setBackground(new Color(63,228,192));
        footerP.add(startBtn);
    }
}
