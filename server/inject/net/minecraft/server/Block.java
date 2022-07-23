package net.minecraft.server;

import net.minecraft.src.Material;

@Deprecated
public class Block extends net.minecraft.src.Block{
    protected Block(int id, Material material) {
        super(id, material);
    }

    protected Block(int id, int blockIndex, Material material) {
        super(id, blockIndex, material);
    }
}
