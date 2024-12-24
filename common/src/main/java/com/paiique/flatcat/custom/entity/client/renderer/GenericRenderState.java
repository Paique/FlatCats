package com.paiique.flatcat.custom.entity.client.renderer;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class GenericRenderState extends LivingEntityRenderState {
    float scale;
    long tickCount;
    boolean isDeadOrDying;
    boolean onGround;
    Vec3d deltaMovement;
    Vec3d position;
    Identifier catImage;
    Identifier deathImage;
}
