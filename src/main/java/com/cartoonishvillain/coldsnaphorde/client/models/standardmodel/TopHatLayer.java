package com.cartoonishvillain.coldsnaphorde.client.models.standardmodel;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Register;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;

import static com.cartoonishvillain.coldsnaphorde.client.RenderManager.TOPHAT;

public class TopHatLayer <T extends LivingEntity, M extends HumanoidModel<T>> extends RenderLayer<T, M> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/armor/tophat.png");
    private static final ResourceLocation REDTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/armor/redtophat.png");
    private static final ResourceLocation BLUETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/armor/bluetophat.png");
    private static final ResourceLocation PURPLETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/armor/purpletophat.png");
    private static final ResourceLocation GREENTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/armor/greentophat.png");

    private final TopHatModel<T> topHatModel;

    public TopHatLayer(RenderLayerParent<T, M> wearer) {
        super(wearer);
        topHatModel = new TopHatModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(TOPHAT));
    }

    @Override
    public void render(PoseStack p_117349_, MultiBufferSource p_117350_, int p_117351_, T entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        if(entity.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(Register.TOPHAT.get())){
            p_117349_.pushPose();
            this.getParentModel().hat.translateAndRotate(p_117349_);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(p_117350_, RenderType.armorCutoutNoCull(TEXTURE), false, entity.getItemBySlot(EquipmentSlot.HEAD).hasFoil());
            this.topHatModel.renderToBuffer(p_117349_, vertexconsumer, p_117351_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            p_117349_.popPose();
        } else if(entity.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(Register.REDTOPHAT.get())){
            p_117349_.pushPose();
            this.getParentModel().hat.translateAndRotate(p_117349_);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(p_117350_, RenderType.armorCutoutNoCull(REDTEXTURE), false, entity.getItemBySlot(EquipmentSlot.HEAD).hasFoil());
            this.topHatModel.renderToBuffer(p_117349_, vertexconsumer, p_117351_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            p_117349_.popPose();
        } else if(entity.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(Register.BLUETOPHAT.get())){
            p_117349_.pushPose();
            this.getParentModel().hat.translateAndRotate(p_117349_);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(p_117350_, RenderType.armorCutoutNoCull(BLUETEXTURE), false, entity.getItemBySlot(EquipmentSlot.HEAD).hasFoil());
            this.topHatModel.renderToBuffer(p_117349_, vertexconsumer, p_117351_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            p_117349_.popPose();
        } else if(entity.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(Register.GREENTOPHAT.get())){
            p_117349_.pushPose();
            this.getParentModel().hat.translateAndRotate(p_117349_);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(p_117350_, RenderType.armorCutoutNoCull(GREENTEXTURE), false, entity.getItemBySlot(EquipmentSlot.HEAD).hasFoil());
            this.topHatModel.renderToBuffer(p_117349_, vertexconsumer, p_117351_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            p_117349_.popPose();
        } else if(entity.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(Register.PURPLETOPHAT.get())){
            p_117349_.pushPose();
            this.getParentModel().hat.translateAndRotate(p_117349_);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(p_117350_, RenderType.armorCutoutNoCull(PURPLETEXTURE), false, entity.getItemBySlot(EquipmentSlot.HEAD).hasFoil());
            this.topHatModel.renderToBuffer(p_117349_, vertexconsumer, p_117351_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            p_117349_.popPose();
        }
    }


}
