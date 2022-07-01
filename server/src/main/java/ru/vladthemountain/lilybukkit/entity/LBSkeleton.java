package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntitySkeleton;
import org.bukkit.entity.Skeleton;

public class LBSkeleton extends LBMonster implements Skeleton {

    EntitySkeleton entity;

    public LBSkeleton(EntitySkeleton e) {
        this.entity = e;
    }
}
