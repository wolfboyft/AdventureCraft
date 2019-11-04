package de.ryuum3gum1n.adventurecraft.client.gui.qad.model.nbtcompound;

import net.minecraft.nbt.NBTTagCompound;
import de.ryuum3gum1n.adventurecraft.client.gui.qad.QADTextField.TextFieldModel;

public final class NBTLongTextFieldModel implements TextFieldModel {
	String text;
	String tagKey;
	NBTTagCompound tagParent;
	boolean valid;

	public NBTLongTextFieldModel(String tagKey, NBTTagCompound tagParent) {
		this.tagKey = tagKey;
		this.tagParent = tagParent;
		this.text = Long.toString(tagParent.getLong(tagKey));
		valid = true;
	}

	@Override
	public void setText(String newText) {
		text = newText;
		try {
			long value = Long.parseLong(text);
			tagParent.setLong(tagKey, value);
			valid = true;
		} catch (NumberFormatException e) {
			valid = false; // :(
		}
	}

	@Override
	public int getTextLength() {
		return text.length();
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public char getCharAt(int i) {
		return text.charAt(i);
	}

	@Override
	public void setTextColor(int color) {
		// nope
	}

	@Override
	public int getTextColor() {
		return valid ? 0xFFFFFFFF : 0xFFFF7070;
	}
}