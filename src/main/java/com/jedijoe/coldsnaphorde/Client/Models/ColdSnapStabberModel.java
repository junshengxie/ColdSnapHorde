package com.jedijoe.coldsnaphorde.Client.Models;

// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.jedijoe.coldsnaphorde.Entities.ColdSnapStabber;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.monster.MonsterEntity;

public class ColdSnapStabberModel<C extends MonsterEntity> extends EntityModel<ColdSnapStabber> {
    private final ModelRenderer lowbody;
    private final ModelRenderer body;
    private final ModelRenderer left_hand;
    private final ModelRenderer right_hand;
    private final ModelRenderer Knife;
    private final ModelRenderer head;
    private final ModelRenderer hat;

    public ColdSnapStabberModel() {
        textureWidth = 128;
        textureHeight = 128;

        lowbody = new ModelRenderer(this);
        lowbody.setRotationPoint(0.0F, 24.0F, 0.0F);
        lowbody.setTextureOffset(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 13.0F, 0.0F);
        body.setTextureOffset(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);

        left_hand = new ModelRenderer(this);
        left_hand.setRotationPoint(5.0F, 6.0F, 0.0F);
        setRotationAngle(left_hand, 0.0F, 0.0F, 0.9163F);
        left_hand.setTextureOffset(32, 0).addBox(-1.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);

        right_hand = new ModelRenderer(this);
        right_hand.setRotationPoint(-4.0F, 6.0F, 0.0F);
        setRotationAngle(right_hand, 0.0F, -0.3927F, 1.5708F);
        right_hand.setTextureOffset(32, 0).addBox(-11.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);

        Knife = new ModelRenderer(this);
        Knife.setRotationPoint(-11.1183F, 2.125F, 1.3915F);
        right_hand.addChild(Knife);
        setRotationAngle(Knife, 1.4399F, 0.0F, 1.5708F);
        Knife.setTextureOffset(41, 26).addBox(-1.5F, -4.0F, 0.5F, 1.0F, 3.0F, 2.0F, -0.25F, false);
        Knife.setTextureOffset(36, 40).addBox(-2.0F, -5.0F, -1.0F, 2.0F, 2.0F, 5.0F, -0.5F, false);
        Knife.setTextureOffset(1, 17).addBox(-2.0F, -8.0F, 0.0F, 2.0F, 4.0F, 2.0F, -0.5F, false);
        Knife.setTextureOffset(0, 36).addBox(-2.0F, -9.0F, 1.0F, 2.0F, 5.0F, 2.0F, -0.5F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 4.0F, 0.0F);
        head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);

        hat = new ModelRenderer(this);
        hat.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(hat);
        hat.setTextureOffset(63, 13).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
        hat.setTextureOffset(31, 11).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);
    }

    @Override
    public void setRotationAngles(ColdSnapStabber entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.body.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        left_hand.render(matrixStack, buffer, packedLight, packedOverlay);
        right_hand.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
