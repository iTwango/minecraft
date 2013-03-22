package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelWither;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderWither extends RenderLiving
{
    private int field_82419_a;

    public RenderWither()
    {
        super(new ModelWither(), 1.0F);
        this.field_82419_a = ((ModelWither)this.mainModel).func_82903_a();
    }

    public void func_82418_a(EntityWither par1EntityWither, double par2, double par4, double par6, float par8, float par9)
    {
        BossStatus.func_82824_a(par1EntityWither, true);
        int i = ((ModelWither)this.mainModel).func_82903_a();

        if (i != this.field_82419_a)
        {
            this.field_82419_a = i;
            this.mainModel = new ModelWither();
        }

        super.doRenderLiving(par1EntityWither, par2, par4, par6, par8, par9);
    }

    protected void func_82415_a(EntityWither par1EntityWither, float par2)
    {
        int i = par1EntityWither.func_82212_n();

        if (i > 0)
        {
            float f1 = 2.0F - ((float)i - par2) / 220.0F * 0.5F;
            GL11.glScalef(f1, f1, f1);
        }
        else
        {
            GL11.glScalef(2.0F, 2.0F, 2.0F);
        }
    }

    protected int func_82417_a(EntityWither par1EntityWither, int par2, float par3)
    {
        if (par1EntityWither.isArmored())
        {
            if (par1EntityWither.getHasActivePotion())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            if (par2 == 1)
            {
                float f1 = (float)par1EntityWither.ticksExisted + par3;
                this.loadTexture("/armor/witherarmor.png");
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                float f2 = MathHelper.cos(f1 * 0.02F) * 3.0F;
                float f3 = f1 * 0.01F;
                GL11.glTranslatef(f2, f3, 0.0F);
                this.setRenderPassModel(this.mainModel);
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_BLEND);
                float f4 = 0.5F;
                GL11.glColor4f(f4, f4, f4, 1.0F);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
                GL11.glTranslatef(0.0F, -0.01F, 0.0F);
                GL11.glScalef(1.1F, 1.1F, 1.1F);
                return 1;
            }

            if (par2 == 2)
            {
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_BLEND);
            }
        }

        return -1;
    }

    protected int func_82416_b(EntityWither par1EntityWither, int par2, float par3)
    {
        return -1;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.func_82415_a((EntityWither)par1EntityLiving, par2);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.func_82417_a((EntityWither)par1EntityLiving, par2, par3);
    }

    protected int inheritRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.func_82416_b((EntityWither)par1EntityLiving, par2, par3);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.func_82418_a((EntityWither)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.func_82418_a((EntityWither)par1Entity, par2, par4, par6, par8, par9);
    }
}
