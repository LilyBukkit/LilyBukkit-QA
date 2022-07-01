package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityChicken;
import org.bukkit.entity.Chicken;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBChicken extends LBAnimals implements Chicken {

    public LBChicken(LBWorld w, EntityChicken e) {
        super(w,e);
    }
}
