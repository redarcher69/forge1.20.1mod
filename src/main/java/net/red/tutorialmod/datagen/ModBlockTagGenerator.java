package net.red.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.red.tutorialmod.TutorialMod;
import net.red.tutorialmod.block.ModBlock;
import net.red.tutorialmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METEORITE_DETECTOR_VALUABLES)
                .add(ModBlock.Meteorite_Ore.get(),
                ModBlock.DeepSlate_Meteorite_Ore.get(),
                ModBlock.End_Meteorite_Ore.get()
                ).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlock.Meteorite_Ore.get(),
                ModBlock.DeepSlate_Meteorite_Ore.get(),
                ModBlock.End_Meteorite_Ore.get(),
                ModBlock.Meteorite_Block.get(),
                ModBlock.Raw_Meteorite_Block.get()
        );
    }
}
