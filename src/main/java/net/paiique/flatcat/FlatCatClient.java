package net.paiique.flatcat;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.paiique.flatcat.custom.entity.client.renderer.GenericFlatCatEntityRenderer;
import net.paiique.flatcat.registry.ModEntityTypes;

@OnlyIn(Dist.CLIENT)
public class FlatCatClient {

    private final IEventBus modEventBus;

    public FlatCatClient(IEventBus modEventBus) {
        this.modEventBus = modEventBus;
        this.modEventBus.addListener(this::onClientSetup);
    }

    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypes.LOOK_INSIDE_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.ANNOYED_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.CRYING_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.STARING_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.SURPRISED_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.GERALD_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.WHATSTHAT_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.HAPPY_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.LICK_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.ANOTHER_SURPRISED_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.ANGRY_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.YOURE_DEAD_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.EMPTY_BRAIN_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.ANOTHER_ANNOYED_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.CLOSER_INSPECTION_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.SHUT_THE_FRICK_UP_CAT.get(), GenericFlatCatEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.LONG_CAT.get(), GenericFlatCatEntityRenderer::new);

    }
}
