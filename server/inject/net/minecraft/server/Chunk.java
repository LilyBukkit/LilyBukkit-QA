package net.minecraft.server;

import net.minecraft.src.World;

@Deprecated
public class Chunk extends net.minecraft.src.Chunk {
    public Chunk(World world, int xPosition, int zPosition) {
        super(world, xPosition, zPosition);
    }

    public Chunk(World world, byte[] blocks, int xPosition, int zPositin) {
        super(world, blocks, xPosition, zPositin);
    }
}
