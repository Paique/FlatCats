package net.paiique.flatcat.custom.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.logging.LogUtils;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.paiique.flatcat.custom.entity.common.AbstractFlatCatEntity;
import org.joml.Matrix4f;

public class GenericFlatCatEntityRenderer<T extends AbstractFlatCatEntity> extends EntityRenderer<T> {

    public GenericFlatCatEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void render(T pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        ResourceLocation catImage = pEntity.getCatImage();
        float imageScale = pEntity.getImageScale();
        if (catImage == null) throw new IllegalStateException("Cat image is null, please contact the mod author: https://github.com/Paique/FlatCats/issues");
        if (pEntity.isDeadOrDying()) catImage = pEntity.getDeathImage();

        try {
            pPoseStack.pushPose();
            pPoseStack.scale(imageScale, imageScale, imageScale);
            double motionX = pEntity.getDeltaMovement().x;
            double motionZ = pEntity.getDeltaMovement().z;
            boolean isWalking = Math.abs(motionX) > 0.01 || Math.abs(motionZ) > 0.01;

            if (pEntity.onGround() && isWalking) {
                float walkCycle = (float) (Math.sin(pEntity.tickCount * 0.5) * 0.1);
                float scale = pEntity.getScale();
                pPoseStack.scale(scale, scale + walkCycle, scale);
            }

            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null) {
                Vec3 entityPos = pEntity.position();
                Vec3 playerPos = mc.player.position();

                double dx = playerPos.x - entityPos.x;
                double dz = playerPos.z - entityPos.z;

                float rotationYaw = (float) (Mth.atan2(dz, dx) * (180F / Math.PI)) - 90F;
                float rotationPitch = (float) (Mth.atan2(entityPos.y - playerPos.y, Math.sqrt(dx * dx + dz * dz)) * (180F / Math.PI));
                pPoseStack.mulPose(Axis.YP.rotationDegrees(-rotationYaw));
                pPoseStack.mulPose(Axis.XP.rotationDegrees(rotationPitch >= 90 ? 90 : rotationPitch));
            }
            VertexConsumer vertexConsumer = pBuffer.getBuffer(RenderType.entityCutout(catImage));
            Matrix4f matrix = pPoseStack.last().pose();

            vertexConsumer.vertex(matrix, -0.5F, 0.0F, 0.0F).color(255, 255, 255, 255).uv(0.0F, 1.0F).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(pPackedLight).normal(0, 1, 0).endVertex();
            vertexConsumer.vertex(matrix, 0.5F, 0.0F, 0.0F).color(255, 255, 255, 255).uv(1.0F, 1.0F).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(pPackedLight).normal(0, 1, 0).endVertex();
            vertexConsumer.vertex(matrix, 0.5F, 1.0F, 0.0F).color(255, 255, 255, 255).uv(1.0F, 0.0F).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(pPackedLight).normal(0, 1, 0).endVertex();
            vertexConsumer.vertex(matrix, -0.5F, 1.0F, 0.0F).color(255, 255, 255, 255).uv(0.0F, 0.0F).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(pPackedLight).normal(0, 1, 0).endVertex();
        } catch (Exception e) {
            LogUtils.getLogger().warn("Failed to render flat cat entity: {}", pEntity.getClass().getSimpleName(), e);
            LogUtils.getLogger().info("Please report this issue to the mod author: https://github.com/Paique/FlatCats/issues");
        } finally {
            pPoseStack.popPose();
        }
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractFlatCatEntity pEntity) {
        return null;
    }
}
