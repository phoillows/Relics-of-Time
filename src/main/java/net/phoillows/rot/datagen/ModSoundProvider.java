package net.phoillows.rot.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;
import net.minecraftforge.registries.RegistryObject;
import net.phoillows.rot.RelicsOfTime;
import net.phoillows.rot.registry.SoundRegistry;
import net.phoillows.rot.util.Helper;

public class ModSoundProvider extends SoundDefinitionsProvider {
    public ModSoundProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, RelicsOfTime.MODID, helper);
    }

    @Override
    public void registerSounds() {
        addSound(SoundRegistry.TIME_FLIES_MUSIC_DISC, createSound("music_disc/time_flies"));
    }

    private void addSound(RegistryObject<SoundEvent> soundEvent, SoundDefinition.Sound... sounds) {
        SoundDefinition definition = SoundDefinition.definition();
        definition.with(sounds);
        add(soundEvent, definition);
    }

    private SoundDefinition.Sound createSound(String path) {
        return sound(Helper.createResource(path));
    }
}
