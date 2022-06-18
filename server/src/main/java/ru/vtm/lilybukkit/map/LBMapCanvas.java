package ru.vtm.lilybukkit.map;

import org.bukkit.map.*;

import java.awt.*;

public class LBMapCanvas implements MapCanvas {
    /**
     * Get the map this canvas is attached to.
     *
     * @return The MapView this canvas is attached to.
     */
    @Override
    public MapView getMapView() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the cursor collection associated with this canvas.
     *
     * @return The MapCursorCollection associated with this canvas.
     */
    @Override
    public MapCursorCollection getCursors() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the cursor collection associated with this canvas. This does not
     * usually need to be called since a MapCursorCollection is already
     * provided.
     *
     * @param cursors The MapCursorCollection to associate with this canvas.
     */
    @Override
    public void setCursors(MapCursorCollection cursors) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Draw a pixel to the canvas.
     *
     * @param x     The x coordinate, from 0 to 127.
     * @param y     The y coordinate, from 0 to 127.
     * @param color The color. See {@link MapPalette}.
     */
    @Override
    public void setPixel(int x, int y, byte color) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get a pixel from the canvas.
     *
     * @param x The x coordinate, from 0 to 127.
     * @param y The y coordinate, from 0 to 127.
     * @return The color. See {@link MapPalette}.
     */
    @Override
    public byte getPixel(int x, int y) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get a pixel from the layers below this canvas.
     *
     * @param x The x coordinate, from 0 to 127.
     * @param y The y coordinate, from 0 to 127.
     * @return The color. See {@link MapPalette}.
     */
    @Override
    public byte getBasePixel(int x, int y) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Draw an image to the map. The image will be clipped if necessary.
     *
     * @param x     The x coordinate of the image.
     * @param y     The y coordinate of the image.
     * @param image The Image to draw.
     */
    @Override
    public void drawImage(int x, int y, Image image) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Render text to the map using fancy formatting. Newline (\n) characters
     * will move down one line and return to the original column, and the text
     * color can be changed using sequences such as "§12;", replacing 12 with
     * the palette index of the color (see {@link MapPalette}).
     *
     * @param x    The column to start rendering on.
     * @param y    The row to start rendering on.
     * @param font
     * @param text The formatted text to render.
     */
    @Override
    public void drawText(int x, int y, MapFont font, String text) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
