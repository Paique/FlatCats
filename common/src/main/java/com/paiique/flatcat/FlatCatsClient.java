package com.paiique.flatcat;

import com.paiique.flatcat.registry.client.ModEntityRenderers;

public class FlatCatsClient {
    public void init() {
        ModEntityRenderers.registerFlatCats();
    }
}
