package net.phoillows.rot.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import net.phoillows.rot.RelicsOfTime;
import net.phoillows.rot.registry.EntityRegistry;
import net.phoillows.rot.registry.ItemRegistry;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, RelicsOfTime.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Items
        addItem(ItemRegistry.CARAPACE, "Carapace");
        addItem(ItemRegistry.ANOMALOCARIS_BUCKET, "Bucket of Anomalocaris");
        addItem(ItemRegistry.CARAPACE_CHESTPLATE, "Carapace Chestplate");
        addItem(ItemRegistry.ANOMALOCARIS_SPAWN_EGG, "Anomalocaris Spawn Egg");

        // Entities
        addEntityType(EntityRegistry.ANOMALOCARIS, "Anomalocaris");

        // Music discs
        addMusicDisc(ItemRegistry.TIME_FLIES_MUSIC_DISC, "Music Disc", "Chips Dah Cat - Time Flies");

        // Creative tabs
        add("itemGroup.rot_items", "Relics of Time Items");
        add("itemGroup.rot_spawnEggs", "Relics of Time Spawns");
    }

    private void addMusicDisc(RegistryObject<Item> item, String name, String author) {
        addItem(item, name);
        add("item." + RelicsOfTime.MODID + "." + item.getId().getPath() + ".desc", author);
    }
}
