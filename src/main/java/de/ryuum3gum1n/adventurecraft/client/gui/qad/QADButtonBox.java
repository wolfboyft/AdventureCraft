package de.ryuum3gum1n.adventurecraft.client.gui.qad;

public class QADButtonBox extends QADScrollPanel {

	public QADButtonBox(QADButton... buttons) {
		int iy = 0;

		for (QADButton button : buttons) {
			addComponent(button);

			button.y = iy;
			iy += button.height;
		}

		this.setViewportHeight(iy);
	}

}