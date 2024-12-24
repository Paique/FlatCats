package com.paiique.flatcat.custom.entity.common;

import com.paiique.flatcat.FlatCats;
import com.paiique.flatcat.custom.entity.client.renderer.GenericRenderState;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;


@Setter
@Getter
public abstract class AbstractFlatCatEntity extends PathAwareEntity {
    private GenericRenderState renderState;
    long tickCount = 0;
    float imageScale = 2.0F;

    protected AbstractFlatCatEntity(EntityType<? extends AbstractFlatCatEntity> pEntityType, World pLevel) {
        super(pEntityType, pLevel);
        renderState = new GenericRenderState();
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.add(2, new FleeEntityGoal<>(this, PlayerEntity.class, 6.0F, 1.0D, 1.2D));
        this.targetSelector.add(1, (new RevengeGoal(this)).setGroupRevenge(AbstractFlatCatEntity.class));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, CreeperEntity.class, true));
    }

    public abstract Identifier getCatImage();

    public Identifier getDeathImage() {
        return Identifier.of(FlatCats.MOD_ID,"textures/entity/death.png");
    }

    @Override
    public void tick() {
        this.tickCount++;
        super.tick();
    }

    public static Supplier<DefaultAttributeContainer.Builder> createAttributes() {
        return () -> AbstractFlatCatEntity.createMobAttributes()
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
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CAT_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.ENTITY_CAT_HURT;
    }

    @Override
    public void swingHand(Hand hand) {
        super.swingHand(hand);
        this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_CAT_HISS, SoundCategory.NEUTRAL, 1.0F, 1.0F, false);
    }
}
