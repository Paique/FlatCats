package com.paiique.flatcat.custom.entity.common;

import com.paiique.flatcat.FlatCats;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class AnotherSurprisedFlatCatEntity extends AbstractFlatCatEntity {


    public AnotherSurprisedFlatCatEntity(EntityType<? extends AnotherSurprisedFlatCatEntity> pEntityType, World pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public Identifier getCatImage() {
        return Identifier.of(FlatCats.MOD_ID ,"textures/entity/surprised2.png");
    }
}
