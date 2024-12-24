package com.paiique.flatcat.fabric;

import com.mojang.logging.LogUtils;
import com.paiique.flatcat.FlatCats;
import com.paiique.flatcat.registry.common.ModEntities;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.List;

public final class FlatCatsFabric implements ModInitializer {

    private static final List<RegistryKey<Biome>> excludedBiomes = List.of(
            BiomeKeys.THE_VOID,
            BiomeKeys.NETHER_WASTES,
            BiomeKeys.THE_END,
            BiomeKeys.RIVER,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN
    );

    @Override
    @SuppressWarnings("unchecked")
    public void onInitialize() {
        FlatCats.init();

        ModEntities.FLAT_CATS.forEach((entityType) -> {
            LogUtils.getLogger().info("Adding spawn for {}", entityType);
            BiomeModifications.addSpawn(
                    BiomeSelectors.excludeByKey(excludedBiomes),
                    SpawnGroup.AMBIENT,
                    ((RegistrySupplier<EntityType<?>>) entityType).get(),
                    100, 4, 4
            );
        });
    }
}
