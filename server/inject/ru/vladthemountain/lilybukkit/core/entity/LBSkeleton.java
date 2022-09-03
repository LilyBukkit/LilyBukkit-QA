package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.EntitySkeleton;
import org.bukkit.World;
import org.bukkit.entity.Skeleton;

/**
 * @author VladTheMountain
 */
public class LBSkeleton extends LBMonster implements Skeleton {

    EntitySkeleton entity;

    public LBSkeleton(World w, EntitySkeleton e) {
        super(w, e);
        this.entity = e;
    }
}
