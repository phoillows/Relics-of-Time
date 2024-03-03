package net.phoillows.rot.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.phoillows.rot.RelicsOfTime;
import net.phoillows.rot.util.Helper;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RelicsOfTime.MODID);

    public static final RegistryObject<SoundEvent> TIME_FLIES_MUSIC_DISC = registerSound("music_disc.time_flies");

    public static RegistryObject<SoundEvent> registerSound(String name) {
        ResourceLocation id = Helper.createResource(name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
