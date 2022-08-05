package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import net.minecraft.src.EntitySpider;
import org.bukkit.World;
import org.bukkit.entity.Spider;

/**
 * @author VladTheMountain
 */
public class LBSpider extends LBMonster implements Spider {

    EntitySpider entity;

    public LBSpider(World w, EntitySpider e) {
        super(w, e);
        this.entity = e;
    }

    @Override
    public Entity getHandle() {
        return this.entity;
    }
}
