package com.paiique.flatcat.custom.components;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent FLAT_FISH = (new FoodComponent.Builder()).nutrition(2).saturationModifier(0.2F).build();
    public static final FoodComponent COOKED_FLAT_FISH = (new FoodComponent.Builder()).nutrition(5).saturationModifier(0.5F).build();
}
