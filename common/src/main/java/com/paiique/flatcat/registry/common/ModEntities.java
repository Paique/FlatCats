package com.paiique.flatcat.registry.common;

import com.paiique.flatcat.FlatCats;
import com.paiique.flatcat.custom.entity.common.*;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class ModEntities {
    public static final Registrar<EntityType<?>> ENTITIES = FlatCats.MANAGER.get().get(Registries.ENTITY_TYPE);
    public static List<Object> FLAT_CATS = new ArrayList<>();

    public static RegistrySupplier<EntityType<AngryFlatCatEntity>> ANGRY_FLAT_CAT = registerCat("angry_cat", AngryFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<AnnoyedFlatCatEntity>> ANNOYED_FLAT_CAT = registerCat("annoyed_cat", AnnoyedFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<AnotherAnnoyedFlatCatEntity>> ANOTHER_ANNOYED_FLAT_CAT = registerCat("another_annoyed_cat", AnotherAnnoyedFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<SurprisedFlatCatEntity>> SURPRISED_FLAT_CAT = registerCat("surprised_cat", SurprisedFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<AnotherSurprisedFlatCatEntity>> ANOTHER_SURPRISED_FLAT_CAT = registerCat("another_surprised_cat", AnotherSurprisedFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<CloserInspectionFlatCatEntity>> CLOSER_INSPECTION_FLAT_CAT = registerCat("closer_inspection_cat", CloserInspectionFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<CryingFlatCatEntity>> CRYING_FLAT_CAT = registerCat("crying_cat", CryingFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<EmptyBrainFlatCatEntity>> EMPTY_BRAIN_FLAT_CAT = registerCat("empty_brain_cat", EmptyBrainFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<GeraldFlatCatEntity>> GERALD_FLAT_CAT = registerCat("gerald_cat", GeraldFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<HappyFlatCatEntity>> HAPPY_FLAT_CAT = registerCat("happy_cat", HappyFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<LongFlatCatEntity>> LONG_FLAT_CAT = registerCat("long_cat", LongFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<LookInsideFlatCatEntity>> LOOK_INSIDE_FLAT_CAT = registerCat("look_inside_cat", LookInsideFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<ShutTheFrickUpFlatCatEntity>> SHUT_THE_FRICK_UP_FLAT_CAT = registerCat("shut_the_frick_up_cat", ShutTheFrickUpFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<StaringFlatCatEntity>> STARING_FLAT_CAT = registerCat("staring_cat", StaringFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<ThousandYardFlatCatEntity>> THOUSAND_YARD_FLAT_CAT = registerCat("thousand_yard_cat", ThousandYardFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<WhatsThatFlatCatEntity>> WHATS_THAT_FLAT_CAT = registerCat("whats_that_cat", WhatsThatFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<YoureDeadFlatCatEntity>> YOURE_DEAD_FLAT_CAT = registerCat("youre_dead_cat", YoureDeadFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<LickFlatCatEntity>> LICK_FLAT_CAT = registerCat("lick_cat", LickFlatCatEntity::new, SpawnGroup.AMBIENT);
    public static RegistrySupplier<EntityType<ChristmasCatEntity>> CHRISTMAS_CAT = registerCat("christmas_cat", ChristmasCatEntity::new, SpawnGroup.AMBIENT);

    public static void init() {
    }

    private static <E extends Entity> RegistrySupplier<EntityType<E>> registerCat(String plainID, EntityType.EntityFactory<E> entity, SpawnGroup group) {
        Identifier id = Identifier.of(FlatCats.MOD_ID, plainID);
         RegistrySupplier<EntityType<E>> entityRegistry = ENTITIES.register(id, () -> EntityType.Builder.create(entity, group).dimensions(1, 1).build(RegistryKey.of(ENTITIES.key(), id)));
        FLAT_CATS.add(entityRegistry);
        return entityRegistry;
    }

    @SuppressWarnings("unchecked")
    public static void registerAttributes() {
        FLAT_CATS.forEach(entityType -> {
            EntityAttributeRegistry.register((Supplier<? extends EntityType<? extends LivingEntity>>) entityType, AbstractFlatCatEntity.createAttributes());
        });
    }
}
