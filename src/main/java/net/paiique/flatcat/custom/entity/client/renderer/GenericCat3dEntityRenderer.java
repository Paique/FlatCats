package net.paiique.flatcat.custom.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.paiique.flatcat.custom.entity.common.Abstract3dCatEntity;
import org.jetbrains.annotations.NotNull;

public class GenericCat3dEntityRenderer<T extends Abstract3dCatEntity> extends EntityRenderer<T> {
    // Todo
    public GenericCat3dEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void render(T entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();

        poseStack.translate(0.0D, 1.5D, 0.0D);
        poseStack.scale(1.0F, -1.0F, 1.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(-entityYaw));
        var vertexConsumer = bufferSource.getBuffer(RenderType.entitySolid(entity.getTexture()));

        renderModel(poseStack, packedLight, vertexConsumer, new ModelLayerLocation(entity.getModel(), "main"));

        poseStack.popPose();

        super.render(entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);
    }

    private void renderModel(PoseStack poseStack, int packedLight, VertexConsumer vertexConsumer, ModelLayerLocation modelLayerLocation) {
        Minecraft.getInstance().getEntityModels().bakeLayer(modelLayerLocation).render(poseStack, vertexConsumer, packedLight, 0xF000F0, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(T pEntity) {
        return pEntity.getTexture();
    }
}