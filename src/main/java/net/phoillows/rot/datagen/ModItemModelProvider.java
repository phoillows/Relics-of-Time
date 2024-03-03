package net.phoillows.rot.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.phoillows.rot.RelicsOfTime;
import net.phoillows.rot.registry.ItemRegistry;
import net.phoillows.rot.util.Helper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RelicsOfTime.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemRegistry.CARAPACE);
        simpleItem(ItemRegistry.ANOMALOCARIS_BUCKET);
        simpleItem(ItemRegistry.CARAPACE_CHESTPLATE);
        simpleItem(ItemRegistry.TIME_FLIES_MUSIC_DISC);
        simpleItem(ItemRegistry.OPABINIA_EYEBALL);

        spawnEggItem(ItemRegistry.ANOMALOCARIS_SPAWN_EGG);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return simpleItem(item, false);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item, boolean handheld) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation(handheld ? "item/handheld" : "item/generated")).texture("layer0", Helper.createResource("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder spawnEggItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/template_spawn_egg"));
    }

    private ItemModelBuilder simpleItemWithTexture(RegistryObject<Item> item, ResourceLocation texture) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", texture);
    }
}
