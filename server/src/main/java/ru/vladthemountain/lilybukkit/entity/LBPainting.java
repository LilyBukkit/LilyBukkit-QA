package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityPainting;
import org.bukkit.Art;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Painting;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBPainting extends LBEntity implements Painting {

    final EntityPainting entity;

    public LBPainting(LBWorld w, EntityPainting e) {
        super(w, e);
        this.entity = e;
    }

    @Override
    public Art getArt() {
        return Art.getByName(entity.art.title);
    }

    @Override
    public boolean setArt(Art art) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean setArt(Art art, boolean b) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean setFacingDirection(BlockFace blockFace, boolean b) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public BlockFace getAttachedFace() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void setFacingDirection(BlockFace blockFace) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public BlockFace getFacing() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
