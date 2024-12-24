package com.paiique.flatcat.neoforge;

import com.paiique.flatcat.FlatCatsClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

import com.paiique.flatcat.FlatCats;
import net.neoforged.fml.loading.FMLLoader;

@Mod(FlatCats.MOD_ID)
public final class FlatCatsNeo {
    public FlatCatsNeo() {
        FlatCats.init();
        if (FMLLoader.getDist() == Dist.CLIENT) new FlatCatsClient().init();
    }
}
