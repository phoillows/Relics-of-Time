package net.phoillows.rot.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.phoillows.rot.RelicsOfTime;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RelicsOfTime.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }
}
