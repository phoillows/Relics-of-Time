package net.phoillows.rot.event;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.phoillows.rot.RelicsOfTime;
import net.phoillows.rot.common.entity.Anomalocaris;
import net.phoillows.rot.datagen.ModBlockStateProvider;
import net.phoillows.rot.datagen.ModItemModelProvider;
import net.phoillows.rot.datagen.ModLanguageProvider;
import net.phoillows.rot.datagen.ModSoundProvider;
import net.phoillows.rot.registry.EntityRegistry;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = RelicsOfTime.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventListener {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        dataGenerator.addProvider(true, new ModBlockStateProvider(packOutput, existingFileHelper));
        dataGenerator.addProvider(true, new ModItemModelProvider(packOutput, existingFileHelper));
        dataGenerator.addProvider(true, new ModLanguageProvider(packOutput));
        dataGenerator.addProvider(true, new ModSoundProvider(packOutput, existingFileHelper));
    }

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.ANOMALOCARIS.get(), Anomalocaris.createAttributes().build());
    }
}
