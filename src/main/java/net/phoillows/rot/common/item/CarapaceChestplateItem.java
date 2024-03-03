package net.phoillows.rot.common.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.phoillows.rot.RelicsOfTime;
import org.jetbrains.annotations.Nullable;

public class CarapaceChestplateItem extends ArmorItem {
    public CarapaceChestplateItem(Properties pProperties) {
        super(ArmorMaterials.TURTLE, Type.CHESTPLATE, pProperties);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return RelicsOfTime.MODID + ":textures/models/armor/carapace_chestplate.png";
    }
}
