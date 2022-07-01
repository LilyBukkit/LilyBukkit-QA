package ru.vladthemountain.lilybukkit.generator;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class LBPillarGenPopulator extends BlockPopulator {
    /**
     * Populates an area of blocks at or around the given chunk.
     * <p>
     * The chunks on each side of the specified chunk must already exist; that is,
     * there must be one north, east, south and west of the specified chunk.
     * The "corner" chunks may not exist, in which scenario the populator should
     * record any changes required for those chunks and perform the changes when
     * they are ready.
     *
     * @param world  The world to generate in
     * @param random The random generator to use
     * @param source The chunk to generate for
     */
    @Override
    public void populate(World world, Random random, Chunk source) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
