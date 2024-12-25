package com.paiique.flatcat.custom.entity.common;

import com.paiique.flatcat.FlatCats;
import com.paiique.flatcat.util.CheckFestiveDate;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.Date;

public class ChristmasCatEntity extends AbstractFlatCatEntity {

    public ChristmasCatEntity(EntityType<? extends ChristmasCatEntity> pEntityType, World pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public Identifier getCatImage() {
        return Identifier.of(FlatCats.MOD_ID ,"textures/entity/christmas.png");
    }

    @Override
    public void tick() {
        if (this.tickCount % 20 == 0) {
            if (!CheckFestiveDate.isChristmas()) this.discard();
        }
        super.tick();
    }
}
