package com.liuruichao.view;


import com.liuruichao.utils.FileUtils;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * index
 * @author liuruichao
 * @date 15/7/12 下午2:29
 */
public class IndexView extends JFrame {
    private Logger logger = Logger.getLogger(IndexView.class);
    private String name = "indexView";
    private String title = "代码生成器";
    private MenuBar menuBar;
    private Menu menuFile;
    private MenuItem menuNew, menuOpen;
    private TextArea textArea;

    public IndexView() {
        setTitle(title);
        setName(name);

        // 设置宽和高
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dimension);

        textArea = new TextArea();
        textArea.setSize(dimension);

        // 菜单
        menuBar = new MenuBar();
        menuFile = new Menu("文件");
        menuNew = new MenuItem("新建");
        menuOpen = new MenuItem("打开");

        menuFile.add(menuNew);
        // 加入分割线
        menuFile.addSeparator();
        menuFile.add(menuOpen);
        menuBar.add(menuFile);
        setMenuBar(menuBar);
        // 点击事件
        menuOpen.addActionListener((e) -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File selectFile = fileChooser.getSelectedFile();
                String filePath = selectFile.getPath();
                logger.info("select file path: " + filePath);
                textArea.setText(FileUtils.getFileContent(filePath));
            }
        });

        add(textArea);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}