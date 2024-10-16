package net.red.tutorialmod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.red.tutorialmod.block.ModBlock;
import net.red.tutorialmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlock.Meteorite_Block.get());
        this.dropSelf(ModBlock.Raw_Meteorite_Block.get());
        //this.dropSelf(ModBlock.Sound_Block.get());

        this.add(ModBlock.Meteorite_Ore.get(),
                block -> createMeteoriteOreDrops(ModBlock.Meteorite_Ore.get(), ModItems.Raw_Meteorite.get()));
        this.add(ModBlock.DeepSlate_Meteorite_Ore.get(),
                block -> createMeteoriteOreDrops(ModBlock.DeepSlate_Meteorite_Ore.get(), ModItems.Raw_Meteorite.get()));

        this.add(ModBlock.End_Meteorite_Ore.get(),
                block -> createEndMeteoriteOreDrops(ModBlock.End_Meteorite_Ore.get(),ModItems.Raw_Meteorite.get()));
    }

    protected LootTable.Builder createMeteoriteOreDrops(Block pBlock,Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 11.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createEndMeteoriteOreDrops(Block pBlock,Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 20.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
