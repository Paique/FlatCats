package net.paiique.flatcat.event;

import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.paiique.flatcat.FlatCat;
import net.paiique.flatcat.custom.entity.common.*;
import net.paiique.flatcat.registry.ModEntityTypes;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = FlatCat.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterEntityAttributes {

    @SubscribeEvent
    public static void onRegisterAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.LOOK_INSIDE_CAT.get(), LookInsideFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.ANNOYED_CAT.get(), AnnoyedFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.CRYING_CAT.get(), CryingFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.STARING_CAT.get(), StaringFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.SURPRISED_CAT.get(), SurprisedFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.GERALD_CAT.get(), GeraldFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.WHATSTHAT_CAT.get(), WhatsThatFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.HAPPY_CAT.get(), HappyFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.LICK_CAT.get(), LickFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.ANOTHER_SURPRISED_CAT.get(), AnotherSurprisedFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.ANGRY_CAT.get(), AngryFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.YOURE_DEAD_CAT.get(), YoureDeadFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.EMPTY_BRAIN_CAT.get(), EmptyBrainFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.ANOTHER_ANNOYED_CAT.get(), AnotherAnnoyedFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.CLOSER_INSPECTION_CAT.get(), CloserInspectionFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.SHUT_THE_FRICK_UP_CAT.get(), ShutTheFrickUpFlatCatEntity.createAttributes().build());
        event.put(ModEntityTypes.LONG_CAT.get(), LongFlatCatEntity.createAttributes().build());
    }
}
