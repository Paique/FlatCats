package com.paiique.flatcat.custom.entity.client.renderer;

import com.mojang.logging.LogUtils;
import com.paiique.flatcat.custom.entity.common.AbstractFlatCatEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;

public class GenericFlatCatEntityRenderer<T extends AbstractFlatCatEntity> extends EntityRenderer<T, GenericRenderState> {
    public GenericFlatCatEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public void updateRenderState(T entity, GenericRenderState state, float tickDelta) {
        state.catImage = entity.getCatImage();
        state.deathImage = entity.getDeathImage();
        state.scale = entity.getImageScale();
        state.isDeadOrDying = entity.isDead();
        state.onGround = entity.isOnGround();
        state.deltaMovement = entity.getVelocity();
        state.tickCount = entity.getTickCount();
        state.position = entity.getPos();
        super.updateRenderState(entity, state, tickDelta);
    }

    @Override
    public void render(GenericRenderState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {

        Identifier catImage = state.catImage;
        float imageScale = state.scale;
        if (catImage == null) throw new IllegalStateException("Cat image is null, please contact the mod author: https://github.com/Paique/FlatCats/issues");
        if (state.isDeadOrDying) catImage = state.deathImage;


        try {
            matrices.push();
            matrices.scale(imageScale, imageScale, imageScale);
            float motionX = (float) state.deltaMovement.x;
            float motionZ = (float) state.deltaMovement.z;
            boolean isWalking = Math.abs(motionX) > 0.01 || Math.abs(motionZ) > 0.01;

            if (isWalking) {
                double walkCycle = (float) (Math.sin(state.tickCount + 0.1) * 0.5) * 0.1; // Smooth walking animation
                matrices.scale(1.0F, (float) (1.0F + walkCycle), 1.0F); // Adjust scale dynamically
            }

            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.player != null) {
                Vec3d entityPos = state.position;
                Vec3d playerPos = mc.player.getPos();

                double dx = playerPos.x - entityPos.x;
                double dz = playerPos.z - entityPos.z;

                float rotationYaw = (float) (Math.atan2(dz, dx) * (180F / Math.PI)) - 90F;
                float rotationPitch = (float) (Math.atan2(entityPos.y - playerPos.y, Math.sqrt(dx * dx + dz * dz)) * (180F / Math.PI));
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-rotationYaw));
                float clampedPitch = Math.min(90.0F, Math.max(-90.0F, rotationPitch));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(clampedPitch));
            }
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(catImage));
            Matrix4f matrix = matrices.peek().getPositionMatrix();

            vertexConsumer.vertex(matrix, -0.5F, 0.0F, 0.0F).color(255, 255, 255, 255).texture(0.0F, 1.0F).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(0, 1, 0);
            vertexConsumer.vertex(matrix, 0.5F, 0.0F, 0.0F).color(255, 255, 255, 255).texture(1.0F, 1.0F).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(0, 1, 0);
            vertexConsumer.vertex(matrix, 0.5F, 1.0F, 0.0F).color(255, 255, 255, 255).texture(1.0F, 0.0F).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(0, 1, 0);
            vertexConsumer.vertex(matrix, -0.5F, 1.0F, 0.0F).color(255, 255, 255, 255).texture(0.0F, 0.0F).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(0, 1, 0);
        } catch (Exception e) {
            LogUtils.getLogger().warn("Failed to render flat cat entity", e);
            LogUtils.getLogger().info("Please report this issue to the mod author: https://github.com/Paique/FlatCats/issues");
        } finally {
            matrices.pop();
        }

        super.render(state, matrices, vertexConsumers, light);
    }

    @Override
    public GenericRenderState createRenderState() {
        return new GenericRenderState();
    }


}
