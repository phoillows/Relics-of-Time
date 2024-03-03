package net.phoillows.rot.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.phoillows.rot.RelicsOfTime;

import java.awt.Color;

public class Helper {
    public static int TPS = 20;

    public static ResourceLocation createResource(String resource) {
        return new ResourceLocation(RelicsOfTime.MODID, resource);
    }

    public static void spawnParticlesAroundEntity(Entity entity, ParticleOptions particle) {
        RandomSource random = RandomSource.create();
        for (int i = 0; i < 7; ++i) {
            double d0 = random.nextGaussian() * 0.02D;
            double d1 = random.nextGaussian() * 0.02D;
            double d2 = random.nextGaussian() * 0.02D;
            entity.level().addParticle(particle, entity.getRandomX(1.0D), entity.getRandomY() + 0.5D, entity.getRandomZ(1.0D), d0, d1, d2);
        }
    }

    public static void drawText(Component text, int charLimit, Color color, int x, int y, GuiGraphics guiGraphics) {
        int lineHeight = 11;
        String[] words = text.getString().split(" ");
        StringBuilder line = new StringBuilder();
        for (String word : words) {
            if (line.length() + word.length() > charLimit) {
                guiGraphics.drawString(Minecraft.getInstance().font, line.toString(), x, y, color.getRGB(), false);
                line = new StringBuilder(word + " ");
                y += lineHeight;
            } else {
                line.append(word).append(" ");
            }
        }
        if (line.length() > 0) {
            guiGraphics.drawString(Minecraft.getInstance().font, line.toString(), x, y, color.getRGB(), false);
        }
    }

    public static void drawShadowedText(Component text, int charLimit, Color color, int x, int y, GuiGraphics guiGraphics, Font font) {
        int lineHeight = 11;
        String[] words = text.getString().split(" ");
        StringBuilder line = new StringBuilder();
        for (String word : words) {
            if (line.length() + word.length() > charLimit) {
                guiGraphics.drawString(Minecraft.getInstance().font, line.toString(), x, y, color.getRGB());
                line = new StringBuilder(word + " ");
                y += lineHeight;
            } else {
                line.append(word).append(" ");
            }
        }
        if (line.length() > 0) {
            guiGraphics.drawString(Minecraft.getInstance().font, line.toString(), x, y, color.getRGB());
        }
    }

    public static void spawnItemEntity(Item item, Level level, double posX, double posY, double posZ) {
        ItemEntity itemEntity = new ItemEntity(level, posX, posY, posZ, new ItemStack(item));
        level.addFreshEntity(itemEntity);
    }

    public static boolean isEntityInBiome(Mob mob, ResourceKey<Biome> biome) {
        BlockPos entityPos = new BlockPos(mob.getBlockX(), mob.getBlockY(), mob.getBlockZ());
        return mob.level().getBiome(entityPos).is(biome);
    }
}
