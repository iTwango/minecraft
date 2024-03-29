package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockSilverfish extends Block
{
    /** Block names that can be a silverfish stone. */
    public static final String[] silverfishStoneTypes = new String[] {"stone", "cobble", "brick"};

    public BlockSilverfish(int par1)
    {
        super(par1, Material.clay);
        this.setHardness(0.0F);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return par2 == 1 ? Block.cobblestone.getBlockTextureFromSide(par1) : (par2 == 2 ? Block.stoneBrick.getBlockTextureFromSide(par1) : Block.stone.getBlockTextureFromSide(par1));
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister) {}

    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            EntitySilverfish entitysilverfish = new EntitySilverfish(par1World);
            entitysilverfish.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            par1World.spawnEntityInWorld(entitysilverfish);
            entitysilverfish.spawnExplosionParticle();
        }

        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    /**
     * Gets the blockID of the block this block is pretending to be according to this block's metadata.
     */
    public static boolean getPosingIdByMetadata(int par0)
    {
        return par0 == Block.stone.blockID || par0 == Block.cobblestone.blockID || par0 == Block.stoneBrick.blockID;
    }

    /**
     * Returns the metadata to use when a Silverfish hides in the block. Sets the block to BlockSilverfish with this
     * metadata. It changes the displayed texture client side to look like a normal block.
     */
    public static int getMetadataForBlockType(int par0)
    {
        return par0 == Block.cobblestone.blockID ? 1 : (par0 == Block.stoneBrick.blockID ? 2 : 0);
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        Block block = Block.stone;

        if (par1 == 1)
        {
            block = Block.cobblestone;
        }

        if (par1 == 2)
        {
            block = Block.stoneBrick;
        }

        return new ItemStack(block);
    }

    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World par1World, int par2, int par3, int par4)
    {
        return par1World.getBlockMetadata(par2, par3, par4);
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int j = 0; j < 3; ++j)
        {
            par3List.add(new ItemStack(par1, 1, j));
        }
    }
}
