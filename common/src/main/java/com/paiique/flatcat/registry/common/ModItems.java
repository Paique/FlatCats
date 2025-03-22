package com.paiique.flatcat.registry.common;

import com.paiique.flatcat.FlatCats;
import com.paiique.flatcat.custom.components.ModFoodComponents;
import com.paiique.flatcat.util.ItemRegistryUtil;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static com.paiique.flatcat.FlatCats.MANAGER;

@SuppressWarnings("deprecation")
public class ModItems {

    public static final Registrar<Item> ITEMS = MANAGER.get().get(Registries.ITEM);

    public static RegistrySupplier<Item> RAW_FLAT_FISH = createItem("raw_flat_fish", new Item.Settings().food(FoodComponents.COD));
    public static RegistrySupplier<Item> COOKED_FLAT_FISH = createItem("cooked_flat_fish", new Item.Settings().food(FoodComponents.COOKED_COD));
    //public static RegistrySupplier<Item> TEST_ITEM = createItem("test_item", new Item.Settings());


    public static void init() {}

    public static RegistrySupplier<Item> createItem(String plainID, Item.Settings settings) {
        Identifier id = Identifier.of(FlatCats.MOD_ID, plainID);
        return ITEMS.register(id, () -> new Item(settings.registryKey(RegistryKey.of(Registries.ITEM.getKey(), id))));
    }


}
