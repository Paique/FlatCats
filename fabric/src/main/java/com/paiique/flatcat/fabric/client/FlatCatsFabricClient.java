package com.paiique.flatcat.fabric.client;

import com.paiique.flatcat.FlatCatsClient;
import net.fabricmc.api.ClientModInitializer;

public final class FlatCatsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        new FlatCatsClient().init();
    }
}
