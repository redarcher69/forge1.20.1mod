package net.red.tutorialmod.datagen;

import com.mojang.math.Axis;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.red.tutorialmod.TutorialMod;
import net.red.tutorialmod.block.ModBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID,existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlock.Meteorite_Block);
        blockWithItem(ModBlock.Raw_Meteorite_Block);
        blockWithItem(ModBlock.Meteorite_Bricks);

        blockWithItem(ModBlock.Meteorite_Ore);
        blockWithItem(ModBlock.DeepSlate_Meteorite_Ore);
        blockWithItem(ModBlock.End_Meteorite_Ore);

        blockWithItem(ModBlock.Sound_Block);

        stairsBlock(((StairBlock) ModBlock.Meteorite_Bricks_Stairs.get()),modLoc("block/meteorite_bricks"));
        slabBlock(((SlabBlock) ModBlock.Meteorite_Bricks_Slab.get()),modLoc("block/meteorite_bricks"),modLoc("block/meteorite_bricks"));

        buttonBlock(((ButtonBlock) ModBlock.Meteorite_Bricks_Button.get()),modLoc("block/meteorite_bricks"));
        pressurePlateBlock(((PressurePlateBlock) ModBlock.Meteorite_Bricks_Pressure_Plate.get()),modLoc("block/meteorite_bricks"));

        wallBlock(((WallBlock) ModBlock.Meteorite_Bricks_Wall.get()),modLoc("block/meteorite_bricks"));
        fenceGateBlock(((FenceGateBlock) ModBlock.Meteorite_Bricks_Wall_Gate.get()),modLoc("block/meteorite_bricks"));

        doorBlockWithRenderType(((DoorBlock) ModBlock.Meteorite_Bricks_Door.get()), modLoc("block/meteorite_bricks_door_bot"),modLoc("block/meteorite_bricks_door_top"),"cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlock.Meteorite_Bricks_TrapDoor.get()), modLoc("block/meteorite_bricks_trapdoor"),true,"cutout");

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
