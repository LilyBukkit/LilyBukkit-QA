package net.minecraft.server;

import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

@Deprecated
public abstract class Entity extends net.minecraft.src.Entity {
    public Entity(World world) {
        super(world);
    }
}
