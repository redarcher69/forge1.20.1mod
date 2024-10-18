package net.red.tutorialmod.block;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.red.tutorialmod.TutorialMod;
import net.red.tutorialmod.block.custom.SoundBlock;
import net.red.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> Meteorite_Block = registerBlock("meteorite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> Raw_Meteorite_Block = registerBlock("raw_meteorite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS).sound(SoundType.CHAIN)));

    public static final RegistryObject<Block> Meteorite_Ore = registerBlock("meteorite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(),UniformInt.of(3,6)));
    public static final RegistryObject<Block> DeepSlate_Meteorite_Ore = registerBlock("deepslate_meteorite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(),UniformInt.of(3,6)));
    public static final RegistryObject<Block> End_Meteorite_Ore = registerBlock("end_meteorite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(),UniformInt.of(3,6)));

    public static final RegistryObject<Block> Sound_Block = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noLootTable()));

    public static final RegistryObject<Block> Meteorite_Bricks = registerBlock("meteorite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));

   public static final RegistryObject<Block> Meteorite_Bricks_Stairs = registerBlock("meteorite_bricks_stairs",
            () -> new StairBlock(()-> ModBlock.Meteorite_Bricks.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.BRICKS)));

   public static final RegistryObject<Block> Meteorite_Bricks_Slab = registerBlock("meteorite_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));

   public static final RegistryObject<Block> Meteorite_Bricks_Button= registerBlock("meteorite_bricks_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON), BlockSetType.IRON, 10,true));

    public static final RegistryObject<Block> Meteorite_Bricks_Pressure_Plate = registerBlock("meteorite_bricks_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.copy(Blocks.BRICKS),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> Meteorite_Bricks_Wall = registerBlock("meteorite_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));

    public static final RegistryObject<Block> Meteorite_Bricks_Wall_Gate = registerBlock("meteorite_bricks_wall_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion(), SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_DOOR_CLOSE));

    public static final RegistryObject<Block> Meteorite_Bricks_Door = registerBlock("meteorite_bricks_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion(),BlockSetType.IRON));

    public static final RegistryObject<Block> Meteorite_Bricks_TrapDoor = registerBlock("meteorite_bricks_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion(),BlockSetType.IRON));

    private static <T extends Block> RegistryObject<T> registerBlock( String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItems(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItems(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
