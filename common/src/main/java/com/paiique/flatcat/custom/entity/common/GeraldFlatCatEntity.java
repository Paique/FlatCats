package com.paiique.flatcat.custom.entity.common;

import com.paiique.flatcat.FlatCats;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class GeraldFlatCatEntity extends AbstractFlatCatEntity {


    public GeraldFlatCatEntity(EntityType<? extends GeraldFlatCatEntity> pEntityType, World pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public Identifier getCatImage() {
        return Identifier.of(FlatCats.MOD_ID ,"textures/entity/gerald.png");
    }
}
