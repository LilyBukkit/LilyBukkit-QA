package ru.vtm.lilybukkit.map;

import org.bukkit.World;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.util.List;

public class LBMapView implements MapView {
    /**
     * Get the ID of this map item. Corresponds to the damage value of a map
     * in an inventory.
     *
     * @return The ID of the map.
     */
    @Override
    public short getId() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Check whether this map is virtual. A map is virtual if its lowermost
     * MapRenderer is plugin-provided.
     *
     * @return Whether the map is virtual.
     */
    @Override
    public boolean isVirtual() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the scale of this map.
     *
     * @return The scale of the map.
     */
    @Override
    public Scale getScale() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the scale of this map.
     *
     * @param scale The scale to set.
     */
    @Override
    public void setScale(Scale scale) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the center X position of this map.
     *
     * @return The center X position.
     */
    @Override
    public int getCenterX() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the center Z position of this map.
     *
     * @return The center Z position.
     */
    @Override
    public int getCenterZ() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the center X position of this map.
     *
     * @param x The center X position.
     */
    @Override
    public void setCenterX(int x) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the center Z position of this map.
     *
     * @param z The center Z position.
     */
    @Override
    public void setCenterZ(int z) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the world that this map is associated with. Primarily used by the
     * internal renderer, but may be used by external renderers. May return
     * null if the world the map is associated with is not loaded.
     *
     * @return The World this map is associated with.
     */
    @Override
    public World getWorld() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the world that this map is associated with. The world is used by
     * the internal renderer, and may also be used by external renderers.
     *
     * @param world The World to associate this map with.
     */
    @Override
    public void setWorld(World world) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get a list of MapRenderers currently in effect.
     *
     * @return A List<MapRenderer> containing each map renderer.
     */
    @Override
    public List<MapRenderer> getRenderers() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Add a renderer to this map.
     *
     * @param renderer The MapRenderer to add.
     */
    @Override
    public void addRenderer(MapRenderer renderer) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Remove a renderer from this map.
     *
     * @param renderer The MapRenderer to remove.
     * @return True if the renderer was successfully removed.
     */
    @Override
    public boolean removeRenderer(MapRenderer renderer) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
