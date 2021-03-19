package com.githup.swing.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingThreadTest2 extends JFrame {

    private static final long serialVersionUID = 1L;

    private static final String STR = "Completed : ";

    private JProgressBar progressBar = new JProgressBar();

    private JTextField text = new JTextField(10);

    private JButton start = new JButton("Start");

    private JButton end = new JButton("End");

    private boolean flag = false;

    private int count = 0;


    GoThread t = null;

    public SwingThreadTest2() {

        this.setLayout(new FlowLayout());

        add(progressBar);

        text.setEditable(false);

        add(text);

        add(start);

        add(end);

        start.addActionListener(new Start());

        end.addActionListener(new End());

    }

    private void go() {

        while (count < 100) {

            try {

                Thread.sleep(100);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            if (flag) {

                count++;

                System.out.println(count);

                progressBar.setValue(count);

                text.setText(STR + String.valueOf(count) + "%");

            }

        }

    }

    private class Start implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            flag = true;

            if (t == null) {

                t = new GoThread();

                t.start();

            }

        }

    }

    //执行复杂工作，然后更新组件的线程

    class GoThread extends Thread {
        @Override
        public void run() {

            //do something

            go();

        }

    }

    private class End implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            flag = false;

        }

    }

    public static void main(String[] args) {

        SwingThreadTest2 fg = new SwingThreadTest2();

        fg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fg.setSize(300, 100);

        fg.setVisible(true);

    }

}