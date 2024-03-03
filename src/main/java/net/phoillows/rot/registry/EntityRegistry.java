package net.phoillows.rot.registry;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.phoillows.rot.RelicsOfTime;
import net.phoillows.rot.common.entity.Anomalocaris;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RelicsOfTime.MODID);

    public static final RegistryObject<EntityType<Anomalocaris>> ANOMALOCARIS = register("anomalocaris", EntityType.Builder.of(Anomalocaris::new, MobCategory.WATER_CREATURE).sized(0.8F, 0.3F));

    private static <E extends Entity> RegistryObject<EntityType<E>> register(String name, EntityType.Builder<E> builder) {
        return ENTITY_TYPES.register(name, () -> builder.build(name));
    }
}
