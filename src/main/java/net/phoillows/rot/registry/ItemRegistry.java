package net.phoillows.rot.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.phoillows.rot.RelicsOfTime;
import net.phoillows.rot.common.item.CarapaceChestplateItem;

import java.awt.Color;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RelicsOfTime.MODID);

    public static final RegistryObject<Item> CARAPACE = ITEMS.register("carapace", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARAPACE_CHESTPLATE = ITEMS.register("carapace_chestplate", () -> new CarapaceChestplateItem(new Item.Properties()));
    public static final RegistryObject<Item> ANOMALOCARIS_BUCKET = ITEMS.register("anomalocaris_bucket", () -> new MobBucketItem(EntityRegistry.ANOMALOCARIS, () -> Fluids.WATER, () -> SoundEvents.BUCKET_FILL_FISH, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TIME_FLIES_MUSIC_DISC = ITEMS.register("music_disc_time_flies", () -> new RecordItem(14, SoundRegistry.TIME_FLIES_MUSIC_DISC, new Item.Properties().rarity(Rarity.RARE).stacksTo(1), 103));

    public static final RegistryObject<Item> ANOMALOCARIS_SPAWN_EGG = createSpawnEgg(EntityRegistry.ANOMALOCARIS, new Color(141, 51, 51), new Color(220, 98, 71));

    private static<E extends Mob> RegistryObject<Item> createSpawnEgg(RegistryObject<EntityType<E>> entity, Color backgroundColor, Color spotColor) {
        return ITEMS.register(entity.getId().getPath() + "_spawn_egg", () -> new ForgeSpawnEggItem(entity, backgroundColor.getRGB(), spotColor.getRGB(), new Item.Properties()));
    }
}
