package com.paiique.flatcat.custom.entity.common;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public abstract class Abstract3dCatEntity extends PathAwareEntity {


    protected Abstract3dCatEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return AbstractFlatCatEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10.0D)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.50D)
                .add(EntityAttributes.FOLLOW_RANGE, 32.0D)
                .add(EntityAttributes.ATTACK_DAMAGE, 2.0D)
                .add(EntityAttributes.ATTACK_KNOCKBACK, 0.5D)
                .add(EntityAttributes.ATTACK_SPEED, 1.0D)
                .add(EntityAttributes.ARMOR, 2.0D)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 0.5D);
    }

    @Override
    public void tick() {
        super.tick();
    }

    public abstract Identifier getModel();
    public abstract Identifier getTexture();
}
