package net.phoillows.rot.event;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.phoillows.rot.RelicsOfTime;
import net.phoillows.rot.registry.ItemRegistry;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = RelicsOfTime.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventListener {
    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        AttributeModifier WATER_SPEED_MODIFIER = new AttributeModifier(UUID.fromString("b030e057-9167-4754-969b-55e6631471b2"), "Water speed modifier", 1.3D, AttributeModifier.Operation.ADDITION);
        AttributeModifier GROUND_SPEED_MODIFIER = new AttributeModifier(UUID.fromString("a55bebcc-88f3-4f0b-b83b-82ce4d964068"), "Ground speed modifier", -0.01D, AttributeModifier.Operation.ADDITION);
        AttributeInstance swimSpeedAttribute = player.getAttribute(ForgeMod.SWIM_SPEED.get());
        AttributeInstance groundSpeedAttribute = player.getAttribute(Attributes.MOVEMENT_SPEED);
        if (player.getItemBySlot(EquipmentSlot.CHEST).is(ItemRegistry.CARAPACE_CHESTPLATE.get())) {
            if (player.isInWater()) {
                if (player.isVisuallySwimming()) {
                    groundSpeedAttribute.removeModifier(GROUND_SPEED_MODIFIER);
                    if (!swimSpeedAttribute.hasModifier(WATER_SPEED_MODIFIER)) {
                        swimSpeedAttribute.addTransientModifier(WATER_SPEED_MODIFIER);
                    }
                }
            } else {
                swimSpeedAttribute.removeModifier(WATER_SPEED_MODIFIER);
                if (!groundSpeedAttribute.hasModifier(GROUND_SPEED_MODIFIER)) {
                    groundSpeedAttribute.addTransientModifier(GROUND_SPEED_MODIFIER);
                }
            }
        } else {
            groundSpeedAttribute.removeModifier(GROUND_SPEED_MODIFIER);
            swimSpeedAttribute.removeModifier(WATER_SPEED_MODIFIER);
        }
    }
}
