package ru.vladthemountain.lilybukkit.block;

import net.minecraft.src.Entity;
import org.bukkit.block.Sign;

public class LBSign extends LBBlockState implements Sign {
    public LBSign(Entity e) {
        super(e);
    }

    /**
     * Gets all the lines of text currently on this sign.
     *
     * @return Array of Strings containing each line of text
     */
    @Override
    public String[] getLines() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the line of text at the specified index.
     * <p>
     * For example, getLine(0) will return the first line of text.
     *
     * @param index Line number to get the text from, starting at 0
     * @return Text on the given line
     * @throws IndexOutOfBoundsException Thrown when the line does not exist
     */
    @Override
    public String getLine(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the line of text at the specified index.
     * <p>
     * For example, setLine(0, "Line One") will set the first line of text to
     * "Line One".
     *
     * @param index Line number to set the text at, starting from 0
     * @param line  New text to set at the specified index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void setLine(int index, String line) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
