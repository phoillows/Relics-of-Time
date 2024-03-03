package net.phoillows.rot.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.phoillows.rot.RelicsOfTime;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RelicsOfTime.MODID);

    public static final RegistryObject<CreativeModeTab> ROT_ITEMS = CREATIVE_TABS.register("rot_items", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegistry.CARAPACE.get()))
            .title(Component.translatable("itemGroup.rot_items"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ItemRegistry.CARAPACE.get());
                output.accept(ItemRegistry.CARAPACE_CHESTPLATE.get());
                output.accept(ItemRegistry.TIME_FLIES_MUSIC_DISC.get());
            }).build());

    public static final RegistryObject<CreativeModeTab> ROT_SPAWN_EGGS = CREATIVE_TABS.register("rot_spawn_eggs", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegistry.ANOMALOCARIS_SPAWN_EGG.get()))
            .title(Component.translatable("itemGroup.rot_spawnEggs"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ItemRegistry.ANOMALOCARIS_BUCKET.get());
                output.accept(ItemRegistry.ANOMALOCARIS_SPAWN_EGG.get());
            }).build());
}
