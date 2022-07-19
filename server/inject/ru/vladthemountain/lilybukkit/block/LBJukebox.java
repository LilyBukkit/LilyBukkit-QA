package ru.vladthemountain.lilybukkit.block;

import net.minecraft.src.BlockJukeBox;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;
import org.bukkit.material.MaterialData;
import ru.vladthemountain.lilybukkit.LBWorld;

public class LBJukebox extends LBBlockState implements Jukebox {

    final BlockJukeBox jukeBox;

    public LBJukebox(LBWorld w, Block b) {
        super(w, b);
        this.jukeBox = null; //TODO: Figure out how to initialize
    }

    @Override
    public Material getPlaying() {
        return this.getData().getItemType();
    }

    @Override
    public void setPlaying(Material material) {
        this.setData(new MaterialData(material));
    }

    @Override
    public boolean isPlaying() {
        return this.getRawData() != 0;
    }

    @Override
    public boolean eject() {
        this.jukeBox.ejectRecord(this.world.getWorldServer(), this.getX(), this.getY(), this.getZ(), this.getRawData());
        return this.getRawData() == 0;
    }
}
