package net.red.tutorialmod.item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.red.tutorialmod.TutorialMod;
import net.red.tutorialmod.item.custom.MeteoriteDetector;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> Meteorite = ITEMS.register("meteorite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Raw_Meteorite = ITEMS.register("raw_meteorite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Meteorite_Detector = ITEMS.register("meteorite_detector",
            () -> new MeteoriteDetector(new Item.Properties().durability(50)));

    public static final RegistryObject<Item> Starfruit = ITEMS.register("starfruit",
            () -> new Item(new Item.Properties().food(ModFoods.StarFruit)));

    public static final RegistryObject<Item> StarFrO_ouit = ITEMS.register("starfr0_ouit",
         () -> new Item(new Item.Properties().food(ModFoods.StarFrO_ouit)));

    public static final RegistryObject<Item> BlackStrawStarFruit = ITEMS.register("blackstrawstarfruit",
         () -> new Item(new Item.Properties().food(ModFoods.BlackStrawStarFruit)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
