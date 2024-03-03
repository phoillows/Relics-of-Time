package net.phoillows.rot.client.model;

import net.minecraft.resources.ResourceLocation;
import net.phoillows.rot.common.entity.Anomalocaris;
import net.phoillows.rot.util.Helper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class AnomalocarisModel extends DefaultedEntityGeoModel<Anomalocaris> {
    public AnomalocarisModel() {
        super(Helper.createResource("anomalocaris"));
    }

    @Override
    public ResourceLocation getTextureResource(Anomalocaris animatable) {
        return switch (animatable.getVariant()) {
            default -> Helper.createResource("textures/entity/anomalocaris/red_anomalocaris.png");
            case 1 -> Helper.createResource("textures/entity/anomalocaris/rubber_anomalocaris.png");
            case 2 -> Helper.createResource("textures/entity/anomalocaris/parrot_anomalocaris.png");
        };
    }

    @Override
    public void setCustomAnimations(Anomalocaris animatable, long instanceId, AnimationState<Anomalocaris> animationState) {
        CoreGeoBone body = this.getAnimationProcessor().getBone("body");
        if (body != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            body.setRotX(entityData.headPitch() * 0.017453292F);
            body.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
