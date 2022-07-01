package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityFallingSand;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingSand;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.UUID;

public class LBFallingSand extends LBEntity implements FallingSand {
    EntityFallingSand entity;
}
