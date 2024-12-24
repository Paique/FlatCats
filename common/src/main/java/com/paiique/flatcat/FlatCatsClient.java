package com.paiique.flatcat;

import com.paiique.flatcat.custom.entity.client.renderer.GenericFlatCatEntityRenderer;
import com.paiique.flatcat.registry.client.ModEntityRenderers;
import com.paiique.flatcat.registry.common.ModEntities;

public class FlatCatsClient {
    public void init() {
        ModEntityRenderers.register();
    }
}
