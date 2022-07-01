package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntitySpider;
import org.bukkit.entity.Spider;

public class LBSpider extends LBMonster implements Spider {

    EntitySpider entity;

    public LBSpider(EntitySpider e) {
        this.entity = e;
    }
}
