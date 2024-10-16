package net.red.tutorialmod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.red.tutorialmod.block.ModBlock;
import net.red.tutorialmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MeteoriteDetector extends Item {
    private int SqValue = 7;
    public MeteoriteDetector(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(!context.getLevel().isClientSide()){
            BlockPos pos = context.getClickedPos();
            Player player = context.getPlayer();
            boolean foundBlock = false;
//context.getLevel().getBlockState(pos.below(i))
            for(int i = 0; i<= SqValue*5; i++){
                BlockState state = CheckCircle(context,pos.below(i),SqValue);
                //BlockState state = null;
                    if (state!=null) {
                        outputValuableCoordinates(pos.below(i), player, state.getBlock());
                        foundBlock = true;
                        break;
                    }

            }

            if(!foundBlock){
                player.displayClientMessage(Component.literal("No ore found!"),true);
            }
        }

        context.getItemInHand().hurtAndBreak(1,context.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        context.getPlayer().getCooldowns().addCooldown(this, 100);

        return InteractionResult.SUCCESS;
    }

    private BlockState CheckCircle(UseOnContext context, BlockPos block, int Radius) {
        //raza mica
        int sRadius=0;
        BlockState state;
        while(sRadius<=Radius) {

            for(int i=-sRadius;i<=sRadius;i++)
                for(int j=-sRadius;j<=sRadius;j++)
                    if( Math.round(Math.sqrt(i*i + j*j)) == sRadius) {
                        state = context.getLevel().getBlockState(block.north(i).west(j));
                        if (isValuableBlock(state))
                            return state;
                    }
            sRadius++;
        }
        return null;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.meteorite_detector.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.displayClientMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " "
                + (int)Math.abs(player.getY()-blockPos.getY())
                + " blocks below in " + SqValue + " Radius"),true);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.METEORITE_DETECTOR_VALUABLES);
    }
}
