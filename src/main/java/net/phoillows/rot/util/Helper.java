package net.phoillows.rot.util;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.biome.Biome;
import net.phoillows.rot.RelicsOfTime;

public class Helper {
    public static int TPS = 20;

    public static ResourceLocation createResource(String resource) {
        return new ResourceLocation(RelicsOfTime.MODID, resource);
    }

    public static boolean isEntityInBiome(Mob mob, ResourceKey<Biome> biome) {
        BlockPos entityPos = new BlockPos(mob.getBlockX(), mob.getBlockY(), mob.getBlockZ());
        return mob.level().getBiome(entityPos).is(biome);
    }
}
