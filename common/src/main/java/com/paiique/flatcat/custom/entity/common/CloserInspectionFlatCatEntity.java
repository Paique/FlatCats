package com.paiique.flatcat.custom.entity.common;

import com.paiique.flatcat.FlatCats;
import com.paiique.flatcat.custom.entity.common.AbstractFlatCatEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class CloserInspectionFlatCatEntity extends AbstractFlatCatEntity {


    public CloserInspectionFlatCatEntity(EntityType<? extends CloserInspectionFlatCatEntity> pEntityType, World pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public Identifier getCatImage() {
        return Identifier.of(FlatCats.MOD_ID ,"textures/entity/closerinspection.png");
    }
}
