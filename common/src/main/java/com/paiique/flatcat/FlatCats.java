package com.paiique.flatcat;

import com.google.common.base.Suppliers;
import com.paiique.flatcat.registry.common.ModEntities;
import dev.architectury.registry.registries.RegistrarManager;

import java.util.function.Supplier;

public final class FlatCats {
    public static final String MOD_ID = "flatcat";
    public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(FlatCats.MOD_ID));

    public static void init() {
        ModEntities.init();
        ModEntities.registerAttributes();
    }
}
