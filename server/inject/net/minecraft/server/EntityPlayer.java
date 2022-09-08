package net.minecraft.server;

import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.ItemInWorldManager;
import net.minecraft.src.World;

@Deprecated
public class EntityPlayer extends EntityPlayerMP {
    public EntityPlayer(MinecraftServer minecraftServer, World world, String username, ItemInWorldManager itemManager) {
        super(minecraftServer, world, username, itemManager);
    }
}
