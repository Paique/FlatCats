package net.paiique.flatcat.registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.paiique.flatcat.FlatCat;
import net.paiique.flatcat.custom.entity.common.*;
import net.paiique.flatcat.event.RegisterEntityAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FlatCat.MODID);

    public static RegistryObject<EntityType<LookInsideFlatCatEntity>> LOOK_INSIDE_CAT = registerFlatCatEntity(LookInsideFlatCatEntity::new, "look_inside");
    public static RegistryObject<EntityType<AnnoyedFlatCatEntity>> ANNOYED_CAT = registerFlatCatEntity(AnnoyedFlatCatEntity::new, "annoyed_cat");
    public static RegistryObject<EntityType<CryingFlatCatEntity>> CRYING_CAT = registerFlatCatEntity(CryingFlatCatEntity::new, "crying_cat");
    public static RegistryObject<EntityType<StaringFlatCatEntity>> STARING_CAT = registerFlatCatEntity(StaringFlatCatEntity::new, "staring_cat");
    public static RegistryObject<EntityType<SurprisedFlatCatEntity>> SURPRISED_CAT = registerFlatCatEntity(SurprisedFlatCatEntity::new, "surprised_cat");
    public static RegistryObject<EntityType<GeraldFlatCatEntity>> GERALD_CAT = registerFlatCatEntity(GeraldFlatCatEntity::new, "gerald_cat");
    public static RegistryObject<EntityType<WhatsThatFlatCatEntity>> WHATSTHAT_CAT = registerFlatCatEntity(WhatsThatFlatCatEntity::new, "whatsthat_cat");
    public static RegistryObject<EntityType<HappyFlatCatEntity>> HAPPY_CAT = registerFlatCatEntity(HappyFlatCatEntity::new, "happy_cat");
    public static RegistryObject<EntityType<LickFlatCatEntity>> LICK_CAT = registerFlatCatEntity(LickFlatCatEntity::new, "lick_cat");
    public static RegistryObject<EntityType<AnotherSurprisedFlatCatEntity>> ANOTHER_SURPRISED_CAT = registerFlatCatEntity(AnotherSurprisedFlatCatEntity::new, "another_surprised_cat");
    public static RegistryObject<EntityType<AngryFlatCatEntity>> ANGRY_CAT = registerFlatCatEntity(AngryFlatCatEntity::new, "angry_cat");
    public static RegistryObject<EntityType<YoureDeadFlatCatEntity>> YOURE_DEAD_CAT = registerFlatCatEntity(YoureDeadFlatCatEntity::new, "youre_dead_cat");
    public static RegistryObject<EntityType<EmptyBrainFlatCatEntity>> EMPTY_BRAIN_CAT = registerFlatCatEntity(EmptyBrainFlatCatEntity::new, "empty_brain_cat");
    public static RegistryObject<EntityType<AnotherAnnoyedFlatCatEntity>> ANOTHER_ANNOYED_CAT = registerFlatCatEntity(AnotherAnnoyedFlatCatEntity::new, "another_annoyed_cat");
    public static RegistryObject<EntityType<CloserInspectionFlatCatEntity>> CLOSER_INSPECTION_CAT = registerFlatCatEntity(CloserInspectionFlatCatEntity::new, "closer_inspection_cat");
    public static RegistryObject<EntityType<ShutTheFrickUpFlatCatEntity>> SHUT_THE_FRICK_UP_CAT = registerFlatCatEntity(ShutTheFrickUpFlatCatEntity::new, "shut_the_frick_up_cat");
    public static RegistryObject<EntityType<LongFlatCatEntity>> LONG_CAT = registerFlatCatEntity(LongFlatCatEntity::new, "long_cat");

    public static <T extends AbstractFlatCatEntity> RegistryObject<EntityType<T>> registerFlatCatEntity(EntityType.EntityFactory<T> factory, String name) {
        return ENTITY.register(name, () -> EntityType.Builder.of(factory, MobCategory.MISC).sized(0.6F, 0.7F).build(name));
    }

    public static void register(IEventBus eventBus) {
        ENTITY.register(eventBus);
    }
}
