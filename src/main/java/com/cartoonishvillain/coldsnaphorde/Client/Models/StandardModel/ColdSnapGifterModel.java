package com.cartoonishvillain.coldsnaphorde.Client.Models.StandardModel;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGifter;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class ColdSnapGifterModel<C extends GenericHordeMember> extends EntityModel<ColdSnapGifter> {
    private static final String LOWBODY = "lowbody";
    private static final String BODY = "body";
    private static final String LEFTHAND = "lefthand";
    private static final String HEAD = "head";
    private static final String HAT = "hat";
    private static final String RIGHTHAND = "righthand";
    private static final String PRESENT = "present";
    private static final String BOW1 = "bow";
    private static final String BOW2 = "bow2";
    private final ModelPart lowbody;
    private final ModelPart body;
    private final ModelPart right_hand;
    private final ModelPart left_hand;
    private final ModelPart head;
    private final ModelPart hat;
    private final ModelPart present;
    private final ModelPart bow2_r1;
    private final ModelPart bow1_r1;

    public ColdSnapGifterModel(ModelPart part){
        super(RenderType::entityCutoutNoCull);
        this.lowbody = part.getChild(LOWBODY);
        this.body = part.getChild(BODY);
        this.left_hand = part.getChild(LEFTHAND);
        this.right_hand = part.getChild(RIGHTHAND);
        this.head = part.getChild(HEAD);
        this.hat = part.getChild(HAT);
        this.present = part.getChild(PRESENT);
        this.bow1_r1 = part.getChild(BOW1);
        this.bow2_r1 = part.getChild(BOW2);
        lowbody.setPos(0, 24, 0);
        body.setPos(0, 13, 0);
        right_hand.setPos(-5, 6, 0);
        right_hand.setRotation(0.0F, -1.5272F, 0.0F);
        left_hand.setPos(5.0F, 6.0F, 0.0F);
        left_hand.setRotation(0.0F, 1.5272F, 0.0F);
        head.setPos(0.0F, 4.0F, 0.0F);
        present.setPos(-0.45F, 7.0F, -10.0F);
        head.children.put(HAT, hat);
        present.children.put(BOW2, bow2_r1);
        present.children.put(BOW1, bow1_r1);
    }

    public static LayerDefinition createLayer(){
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        CubeDeformation cubeDeformation5 = new CubeDeformation(-0.5f);
        CubeDeformation cubeDeformation05 = new CubeDeformation(-0.05f);
        CubeDeformation cubeDeformation1 = new CubeDeformation(-0.1f);
        CubeDeformation cubeDeformation6 = new CubeDeformation(-0.6f);
        partDefinition.addOrReplaceChild(LOWBODY, CubeListBuilder.create()
                .texOffs(0,0).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(BODY, CubeListBuilder.create()
                .texOffs(0,24).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(RIGHTHAND, CubeListBuilder.create()
                .texOffs(48, 11).addBox(-11.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(LEFTHAND, CubeListBuilder.create()
                .texOffs(48, 11).addBox(-1.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(HEAD, CubeListBuilder.create()
                .texOffs(40, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation5)
                .texOffs(0,0).addBox(-0.95F, -4.05F, -4.45F, 1.0F, 1.0F, 1.0F, cubeDeformation05)
                .texOffs(4, 0).addBox(-0.95F, -4.05F, -5.35F, 1.0F, 1.0F, 1.0F, cubeDeformation05), PartPose.ZERO);
        partDefinition.addOrReplaceChild(HAT, CubeListBuilder.create()
                .texOffs(30, 34).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, cubeDeformation5)
                .texOffs(0, 44).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(PRESENT, CubeListBuilder.create()
                .texOffs(32, 46).addBox(-5.0F, -3.0F, -3.0F, 11.0F, 3.0F, 5.0F, cubeDeformation1)
                .texOffs(36, 0).addBox(-6.0F, -5.0F, -4.0F, 13.0F, 4.0F, 7.0F, cubeDeformation6), PartPose.ZERO);
        partDefinition.addOrReplaceChild(BOW2, CubeListBuilder.create()
                .texOffs(0,58).addBox(-3.5F, -3.5F, -0.5F, 7.0F, 4.0F, 1.0F, cubeDeformation5), PartPose.offsetAndRotation(0.5F, -4.4F, -0.5F,  0.0F, -0.7418F, 0.0F));
        partDefinition.addOrReplaceChild(BOW1, CubeListBuilder.create()
                .texOffs(0,58).addBox(-3.5F, -3.5F, -0.5F, 7.0F, 4.0F, 1.0F, cubeDeformation5), PartPose.offsetAndRotation(0.5F, -4.4F, -0.5F, 0.0F, 0.7418F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }



    @Override
    public void setupAnim(ColdSnapGifter entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.body.yRot = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        right_hand.render(matrixStack, buffer, packedLight, packedOverlay);
        left_hand.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        present.render(matrixStack, buffer, packedLight, packedOverlay);
    }

}
