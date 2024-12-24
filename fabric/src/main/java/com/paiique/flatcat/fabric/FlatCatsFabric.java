package com.paiique.flatcat.fabric;

import dev.architectury.event.events.common.LifecycleEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import com.paiique.flatcat.FlatCats;

public final class FlatCatsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        FlatCats.init();
    }
}
