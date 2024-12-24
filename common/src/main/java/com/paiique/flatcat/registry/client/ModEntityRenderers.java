package com.paiique.flatcat.registry.client;

import com.paiique.flatcat.custom.entity.client.renderer.GenericFlatCatEntityRenderer;
import com.paiique.flatcat.custom.entity.common.AbstractFlatCatEntity;
import com.paiique.flatcat.registry.common.ModEntities;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.entity.EntityType;

public class ModEntityRenderers {
    @SuppressWarnings("unchecked")
    public static void registerFlatCats() {
        ModEntities.FLAT_CATS.forEach(entityType -> {
            EntityRendererRegistry.register(((RegistrySupplier<EntityType<? extends AbstractFlatCatEntity>>) entityType), GenericFlatCatEntityRenderer::new);
        });
    }
}
