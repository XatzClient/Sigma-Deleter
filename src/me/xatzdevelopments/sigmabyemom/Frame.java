/*MIT License

Copyright (c) 2021 Xatz Developments (also known as Fardmen Industries)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/

package me.xatzdevelopments.sigmabyemom;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.apache.commons.io.FileUtils;
import javax.swing.*;


@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {
    JButton button = new JButton();
    JPanel panel = new JPanel();
    ImageIcon icon = new ImageIcon(getClass().getResource("/xatz1-1.png"));


    Frame() throws IOException{
        this.setTitle("Sigma deleter v1.4");
        this.setSize(600,275);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.getHSBColor(0, 0, 0.1f));
        this.setLayout(null);
        this.setIconImage(icon.getImage());

        button = new JButton("Click on this window to delete Sigma!\nYour PC will thank you");
        button.setBounds(90, 60, 400, 100);
        button.setLocation(getWidth()/6, 60);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setBackground(Color.getHSBColor(0, 0, 0.2f));
        button.setBorder(null);
        button.setFont(getFont());
        button.setForeground(Color.WHITE);
        this.add(button);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            String prefix = "/";
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                prefix += "AppData/Roaming/.";
            } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                prefix += "Library/Application Support/";
            }
            else prefix += ".";

            File sigmaDataDir = new File(FileUtils.getUserDirectoryPath() + prefix + "minecraft/sigma");
            File sigmaFiveDataDir = new File(FileUtils.getUserDirectoryPath() + prefix + "minecraft/sigma5");
            File jelloDataDir = new File(FileUtils.getUserDirectoryPath() + prefix + "minecraft/jello");
            File sigmaCapitalizedDataDir = new File(FileUtils.getUserDirectoryPath() + prefix + "minecraft/Sigma");
            File sigmaVerDir = new File(FileUtils.getUserDirectoryPath() + prefix + "minecraft/versions/Sigma");
            File sigmaNewVerDir = new File(FileUtils.getUserDirectoryPath() + prefix + "minecraft/versions/Sigma5");
            File jelloprelauncherthingy = new File(FileUtils.getUserDirectoryPath() + prefix + "minecraft/SigmaJelloPrelauncher.jar");
            if (!jelloprelauncherthingy.exists() && !sigmaCapitalizedDataDir.exists()) {
                JOptionPane.showMessageDialog(this, "Sigma doesn't exist, you're unique and lucky.","Error",JOptionPane.ERROR_MESSAGE);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                return;
            }
            del(sigmaCapitalizedDataDir);
            del(sigmaDataDir);
            del(sigmaFiveDataDir);
            del(sigmaNewVerDir);
            del(sigmaVerDir);
            del(jelloDataDir);
            del(jelloprelauncherthingy);

            JOptionPane.showMessageDialog(this, "Sigma is now gone, your CPU, GPU, and HDD will thank you!"); // it sure will
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        }
    }
    private void del(File file) {
        try {
            FileUtils.forceDelete(file);
        }catch (IOException ignored) {}
    }
}
