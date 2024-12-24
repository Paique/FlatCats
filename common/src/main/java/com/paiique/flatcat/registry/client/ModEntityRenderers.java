package com.paiique.flatcat.registry.client;

import com.paiique.flatcat.custom.entity.client.renderer.GenericFlatCatEntityRenderer;
import com.paiique.flatcat.registry.common.ModEntities;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class ModEntityRenderers {
    public static Map<RegistrySupplier<? extends EntityType<?>>, Class<? extends EntityRenderer>> RENDERERS = new HashMap<>();
    public static void register() {
        EntityRendererRegistry.register(ModEntities.ANGRY_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.ANNOYED_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.ANOTHER_ANNOYED_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SURPRISED_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.ANOTHER_SURPRISED_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.CLOSER_INSPECTION_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYING_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.EMPTY_BRAIN_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.GERALD_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.HAPPY_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LONG_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LOOK_INSIDE_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHUT_THE_FRICK_UP_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.STARING_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.THOUSAND_YARD_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.WHATS_THAT_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.YOURE_DEAD_FLAT_CAT, GenericFlatCatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LICK_FLAT_CAT, GenericFlatCatEntityRenderer::new);

    }

    private static EntityRenderer rendererInstance(Class<? extends EntityRenderer> renderer, EntityRendererFactory.Context context) {
        try {
            return renderer.getDeclaredConstructor().newInstance(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
