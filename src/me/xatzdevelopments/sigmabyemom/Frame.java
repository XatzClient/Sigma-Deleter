/*  Sigma deleter, a Simple program to get rid of a pasted block game cheat
    Sigma Deleter Copyright (C) 2021  Xatz Developments (also known as Fardmen Industries)

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>. */

package me.xatzdevelopments.sigmabyemom;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		this.setTitle("Sigma deleter v1.3");
		this.setSize(600,275);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.getHSBColor(0, 0, 0.1f));
		this.setLayout(null);
		this.setIconImage(icon.getImage());
	
		button = new JButton("Delete Sigma now for free");
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
			if (!sigmaDataDir.exists() && !sigmaVerDir.exists() && !sigmaCapitalizedDataDir.exists()) {
				JOptionPane.showMessageDialog(this, "Sigma doesn't exist, you're lucky.","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			del(sigmaCapitalizedDataDir);
			del(sigmaDataDir);
			del(sigmaFiveDataDir);
			del(sigmaNewVerDir);
			del(sigmaVerDir);
			del(jelloDataDir);
			del(jelloprelauncherthingy);

			JOptionPane.showMessageDialog(this, "Sigma is gone, your CPU will thank you!"); // it sure will

		}
	}
	private void del(File file) {
		try {
			FileUtils.forceDelete(file);
		}catch (IOException ignored) {}
	}
}

