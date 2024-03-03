package net.phoillows.rot.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.phoillows.rot.client.model.AnomalocarisModel;
import net.phoillows.rot.common.entity.Anomalocaris;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AnomalocarisRenderer extends GeoEntityRenderer<Anomalocaris> {
    public AnomalocarisRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnomalocarisModel());
        this.shadowRadius = 0.4F;
    }
}
