package com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel;

// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapSnowballer;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class NetherColdSnapSnowballerModel<C extends GenericHordeMember> extends EntityModel<ColdSnapSnowballer> {
    private final ModelRenderer lowbody;
    private final ModelRenderer upper;
    private final ModelRenderer head;
    private final ModelRenderer hat;
    private final ModelRenderer body;
    private final ModelRenderer cube_r1;
    private final ModelRenderer left_hand;
    private final ModelRenderer left_hand_r1;
    private final ModelRenderer right_hand;

    public NetherColdSnapSnowballerModel() {
        texWidth = 128;
        texHeight = 128;

        lowbody = new ModelRenderer(this);
        lowbody.setPos(0.0F, 24.0F, 0.0F);
        lowbody.texOffs(0, 36).addBox(-6.0F, -11.5F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);
        lowbody.texOffs(0, 104).addBox(-6.0F, -11.55F, -0.5F, 12.0F, 12.0F, 12.0F, -0.5F, false);
        lowbody.texOffs(50, 36).addBox(-6.0F, -9.7F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);

        upper = new ModelRenderer(this);
        upper.setPos(-3.0F, 14.8F, -1.0F);
        setRotationAngle(upper, -0.0436F, 0.0F, 0.3054F);


        head = new ModelRenderer(this);
        head.setPos(3.0F, -9.4F, -0.2F);
        upper.addChild(head);
        setRotationAngle(head, 0.3491F, 0.0F, -0.3491F);
        head.texOffs(0, 0).addBox(-4.0F, -7.5F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);

        hat = new ModelRenderer(this);
        hat.setPos(0.0F, -6.0F, 0.0F);
        head.addChild(hat);
        hat.texOffs(63, 13).addBox(-5.0F, -1.5F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
        hat.texOffs(31, 11).addBox(-4.0F, -6.5F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);

        body = new ModelRenderer(this);
        body.setPos(3.0F, 0.5F, 1.0F);
        upper.addChild(body);
        body.texOffs(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -9.5F, 0.0F);
        body.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.48F, 0.0F, -0.48F);
        cube_r1.texOffs(0, 61).addBox(-8.0F, -13.5F, -8.0F, 16.0F, 16.0F, 16.0F, -2.5F, false);

        left_hand = new ModelRenderer(this);
        left_hand.setPos(4.5F, -6.8F, 0.0F);
        body.addChild(left_hand);
        setRotationAngle(left_hand, 0.0F, 1.0472F, 0.7854F);


        left_hand_r1 = new ModelRenderer(this);
        left_hand_r1.setPos(0.0121F, 0.005F, 0.0F);
        left_hand.addChild(left_hand_r1);
        setRotationAngle(left_hand_r1, 0.0F, 0.0F, -0.6109F);
        left_hand_r1.texOffs(32, 0).addBox(-0.8F, -0.5F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);

        right_hand = new ModelRenderer(this);
        right_hand.setPos(-4.5F, -6.8F, 0.0F);
        body.addChild(right_hand);
        setRotationAngle(right_hand, 0.0F, 0.0F, -0.7854F);
        right_hand.texOffs(32, 0).addBox(-12.7121F, 5.505F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);
    }

    @Override
    public void setupAnim(ColdSnapSnowballer entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
//        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
//        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
//        this.body.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
        upper.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}