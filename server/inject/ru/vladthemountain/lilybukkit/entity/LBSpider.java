package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntitySpider;
import org.bukkit.entity.Spider;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBSpider extends LBMonster implements Spider {

    public LBSpider(LBWorld w, EntitySpider e) {
        super(w, e);
    }
}
