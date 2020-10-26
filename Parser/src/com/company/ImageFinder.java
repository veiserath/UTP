package com.company;

import javax.swing.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ImageFinder {
    ImageFinder() {
        File folder = new File("data/16");
        List<File> files = Arrays.asList(folder.listFiles());
        System.out.println(files);
        Icon icon = new ImageIcon("data/16/Albania-flag.png");
        JLabel jLabel = new JLabel(icon);
        JFrame jFrame = new JFrame();
        jFrame.add(jLabel);
        jFrame.setVisible(true);
    }
}
