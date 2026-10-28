package io.redspace.ironsspellbooks.registries;

// TODO: irons-lib
//import io.redspace.ironslib.statue.block.statue_block.decorative.DecorativeStatueBlock;
//import io.redspace.ironslib.statue.block.statue_block.decorative.DecorativeStatueBlockEntity;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.block.ArmorPileBlock;
import io.redspace.ironsspellbooks.block.BloodCauldronBlock;
import io.redspace.ironsspellbooks.block.BoneVaultBlock;
import io.redspace.ironsspellbooks.block.BookStackBlock;
import io.redspace.ironsspellbooks.block.BrazierBlock;
import io.redspace.ironsspellbooks.block.CinderousVaultBlock;
import io.redspace.ironsspellbooks.block.FireflyJar;
import io.redspace.ironsspellbooks.block.VoidstoneBlock;
import io.redspace.ironsspellbooks.block.alchemist_cauldron.AlchemistCauldronBlock;
import io.redspace.ironsspellbooks.block.alchemist_cauldron.AlchemistCauldronTile;
import io.redspace.ironsspellbooks.block.arcane_anvil.ArcaneAnvilBlock;
import io.redspace.ironsspellbooks.block.chiseled_bookshelf.WisewoodChiseledBookShelfBlockEntity;
import io.redspace.ironsspellbooks.block.chiseled_bookshelf.WisewoodChiseledBookshelfBlock;
import io.redspace.ironsspellbooks.block.ice_spider_egg.CookedIceSpiderEggBlock;
import io.redspace.ironsspellbooks.block.ice_spider_egg.IceSpiderEggBlock;
import io.redspace.ironsspellbooks.block.inscription_table.InscriptionTableBlock;
import io.redspace.ironsspellbooks.block.pedestal.PedestalBlock;
import io.redspace.ironsspellbooks.block.pedestal.PedestalTile;
import io.redspace.ironsspellbooks.block.portal_frame.PocketDimensionPortalFrameBlock;
import io.redspace.ironsspellbooks.block.portal_frame.PortalFrameBlock;
import io.redspace.ironsspellbooks.block.portal_frame.PortalFrameBlockEntity;
import io.redspace.ironsspellbooks.block.scroll_forge.ScrollForgeBlock;
import io.redspace.ironsspellbooks.block.scroll_forge.ScrollForgeTile;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class BlockRegistry {
    /* ******************************
     * Block
     ****************************** */
    public static final Block INSCRIPTION_TABLE_BLOCK = registerBlock("inscription_table", InscriptionTableBlock::new);
    public static final Block SCROLL_FORGE_BLOCK = registerBlock("scroll_forge", ScrollForgeBlock::new);
    public static final Block PEDESTAL_BLOCK = registerBlock("pedestal", PedestalBlock::new);
    public static final Block BLOOD_CAULDRON_BLOCK = registerBlock("blood_cauldron", BloodCauldronBlock::new);
    public static final Block ARCANE_ANVIL_BLOCK = registerBlock("arcane_anvil", ArcaneAnvilBlock::new);
    public static final Block ARMOR_PILE_BLOCK = registerBlock("armor_pile", ArmorPileBlock::new);
    public static final Block ALCHEMIST_CAULDRON = registerBlock("alchemist_cauldron", AlchemistCauldronBlock::new);
    public static final Block FIREFLY_JAR = registerBlock("firefly_jar", FireflyJar::new);
    public static final Block PORTAL_FRAME = registerBlock("portal_frame", PortalFrameBlock::new);
    public static final Block BRAZIER_FIRE = registerBlock("brazier", () -> new BrazierBlock(false));
    public static final Block BRAZIER_SOUL = registerBlock("brazier_soul", () -> new BrazierBlock(true));
    public static final Block CINDEROUS_KEYSTONE = registerBlock("cinderous_soul_rune", () -> new Block(BlockBehaviour.Properties.of().lightLevel(_ -> 15).pushReaction(PushReaction.BLOCK).sound(SoundType.DEEPSLATE).noLootTable().strength(40, 1200.0F)));
    public static final Block MITHRIL_ORE = registerBlock("mithril_ore", () -> new Block(BlockBehaviour.Properties.of().lightLevel(_ -> 9).mapColor(DyeColor.GRAY).requiresCorrectToolForDrops().strength(20.0F, 1200.0F).sound(SoundType.ANCIENT_DEBRIS)));
    public static final Block MITHRIL_ORE_DEEPSLATE = registerBlock("deepslate_mithril_ore", () -> new Block(BlockBehaviour.Properties.of().lightLevel(_ -> 9).mapColor(DyeColor.GRAY).requiresCorrectToolForDrops().strength(20.0F, 1200.0F).sound(SoundType.ANCIENT_DEBRIS)));
    public static final Block ICE_SPIDER_EGG = registerBlock("ice_spider_egg", () -> new IceSpiderEggBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).strength(3, 1).noOcclusion()));
    public static final Block COOKED_ICE_SPIDER_EGG = registerBlock("cooked_ice_spider_egg", () -> new CookedIceSpiderEggBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).sound(SoundType.HONEY_BLOCK)));
    public static final Block BOOK_STACK = registerBlock("book_stack", BookStackBlock::new);
    public static final Block WISEWOOD_PLANKS = registerBlock("wisewood_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Block WISEWOOD_BOOKSHELF = registerBlock("wisewood_bookshelf", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF)));
    public static final Block GRIMY_TILES = registerBlock("grimy_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final Block WISEWOOD_CHISELLED_BOOKSHELF = registerBlock("wisewood_chiseled_bookshelf", () -> new WisewoodChiseledBookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_BOOKSHELF)));
    public static final Block NETHER_BRICK_PILLAR = registerBlock("nether_brick_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final Block VOIDSTONE = registerBlock("voidstone", VoidstoneBlock::new);
    public static final Block POCKET_PORTAL_FRAME = registerBlock("pocket_dimension_portal_frame", PocketDimensionPortalFrameBlock::new);

    public static final BoneVaultBlock BONE_VAULT_BLOCK = registerSpecialBlock("bone_vault", () -> new BoneVaultBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.VAULT)));
    public static final CinderousVaultBlock CINDEROUS_VAULT_BLOCK = registerSpecialBlock("cinderous_vault", () -> new CinderousVaultBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.VAULT)));
    // TODO: irons-lib
//    public static final DecorativeStatueBlock TYROS_STATUE_BLOCK = registerSpecialBlock("tyros_statue", () -> new DecorativeStatueBlock(2, 4, 2, BlockRegistry.TYROS_STATUE_BLOCK_ENTITY));

    /* ******************************
     * Block Entity
     ****************************** */
    public static final BlockEntityType<ScrollForgeTile> SCROLL_FORGE_TILE = registerBlockEntity("scroll_forge", () -> BlockEntityType.Builder.of(ScrollForgeTile::new, SCROLL_FORGE_BLOCK).build(null));
    public static final BlockEntityType<PedestalTile> PEDESTAL_TILE = registerBlockEntity("pedestal", () -> BlockEntityType.Builder.of(PedestalTile::new, PEDESTAL_BLOCK).build(null));
    public static final BlockEntityType<AlchemistCauldronTile> ALCHEMIST_CAULDRON_TILE = registerBlockEntity("alchemist_cauldron", () -> BlockEntityType.Builder.of(AlchemistCauldronTile::new, ALCHEMIST_CAULDRON).build(null));
    public static final BlockEntityType<PortalFrameBlockEntity> PORTAL_FRAME_BLOCK_ENTITY = registerBlockEntity("portal_frame", () -> BlockEntityType.Builder.of(PortalFrameBlockEntity::new, PORTAL_FRAME, POCKET_PORTAL_FRAME).build(null));
    public static final BlockEntityType<WisewoodChiseledBookShelfBlockEntity> WISEWOOD_CHISELED_BOOKSHELF_ENTITY = registerBlockEntity("wisewood_chiseled_bookshelf", () -> BlockEntityType.Builder.of(WisewoodChiseledBookShelfBlockEntity::new, WISEWOOD_CHISELLED_BOOKSHELF).build(null));

    // TODO: irons-lib
//    public static final BlockEntityType<DecorativeStatueBlockEntity> TYROS_STATUE_BLOCK_ENTITY = registerBlockEntity("tyros_statue", () -> BlockEntityType.Builder.of(DecorativeStatueBlockEntity.from(BlockRegistry.TYROS_STATUE_BLOCK_ENTITY), TYROS_STATUE_BLOCK).build(null));

    public static Block registerBlock(String key, Supplier<Block> val) {
        return Registry.register(BuiltInRegistries.BLOCK, IronsSpellbooks.id(key), val.get());
    }

    public static <T extends Block> T registerSpecialBlock(String key, Supplier<T> val) {
        return Registry.register(BuiltInRegistries.BLOCK, IronsSpellbooks.id(key), val.get());
    }

    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String key, Supplier<BlockEntityType<T>> val) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, IronsSpellbooks.id(key), val.get());
    }
}
