package net.paiique.flatcat.custom.entity.common;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.paiique.flatcat.FlatCat;

public class StaringFlatCatEntity extends AbstractFlatCatEntity {

    public StaringFlatCatEntity(EntityType pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public ResourceLocation getCatImage() {
        return new ResourceLocation(FlatCat.MODID ,"textures/entity/staring.png");
    }
}
