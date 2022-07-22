package org.bukkit.craftbukkit.generator;

import net.minecraft.src.Chunk;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import org.bukkit.World;

import java.util.Random;

@Deprecated
public class NormalChunkGenerator extends InternalChunkGenerator{

    public NormalChunkGenerator(World world, long seed){
        throw new UnsupportedOperationException("One of the plugins called deprecated Chunk Generation API");
    }

    @Override
    public boolean chunkExists(int x, int z) {
        throw new UnsupportedOperationException("One of the plugins called deprecated Chunk Generation API");
    }

    @Override
    public Chunk provideChunk(int x, int z) {
        throw new UnsupportedOperationException("One of the plugins called deprecated Chunk Generation API");
    }

    @Override
    public void populate(IChunkProvider chunkProvider, int x, int z) {
        throw new UnsupportedOperationException("One of the plugins called deprecated Chunk Generation API");
    }

    @Override
    public boolean saveChunks(boolean flag, IProgressUpdate progressUpdate) {
        throw new UnsupportedOperationException("One of the plugins called deprecated Chunk Generation API");
    }

    @Override
    public boolean unload100OldestChunks() {
        throw new UnsupportedOperationException("One of the plugins called deprecated Chunk Generation API");
    }

    @Override
    public boolean canSave() {
        throw new UnsupportedOperationException("One of the plugins called deprecated Chunk Generation API");
    }

    @Override
    public byte[] generate(World world, Random random, int i, int i1) {
        throw new UnsupportedOperationException("One of the plugins called deprecated Chunk Generation API");
    }
}
