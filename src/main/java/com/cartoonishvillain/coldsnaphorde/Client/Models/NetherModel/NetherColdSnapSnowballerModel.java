package com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapSnowballer;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class NetherColdSnapSnowballerModel <C extends GenericHordeMember> extends EntityModel<ColdSnapSnowballer> {
    private final ModelPart lowbody;
    private final ModelPart upper;
    private final ModelPart head;
    private final ModelPart hat;
    private final ModelPart body;
    private final ModelPart cube_r1;
    private final ModelPart left_hand;
    private final ModelPart left_hand_r1;
    private final ModelPart right_hand;
    private static final String LOWBODY = "lowbody";
    private static final String UPPER = "upper";
    private static final String CUBE = "cube";
    private static final String LEFTHAND1 = "lefthand1";
    private static final String BODY = "body";
    private static final String LEFTHAND = "lefthand";
    private static final String HEAD = "head";
    private static final String HAT = "hat";
    private static final String RIGHTHAND = "righthand";

    public NetherColdSnapSnowballerModel(ModelPart part){
        super(RenderType::entityCutoutNoCull);
        this.lowbody = part.getChild(LOWBODY);
        this.body = part.getChild(BODY);
        this.left_hand = part.getChild(LEFTHAND);
        this.left_hand_r1 = part.getChild(LEFTHAND1);
        this.cube_r1 = part.getChild(CUBE);
        this.upper = part.getChild(UPPER);
        this.right_hand = part.getChild(RIGHTHAND);
        this.head = part.getChild(HEAD);
        this.hat = part.getChild(HAT);
        lowbody.setPos(0,24,0);
        upper.setPos(-3f,14.8f,-1f);
        upper.setRotation(0.0436F, 0.0F, 0.3054F);
        upper.children.put(HEAD, head);
        head.children.put(HAT, hat);
        upper.children.put(BODY, body);
        body.children.put(CUBE, cube_r1);
        body.children.put(LEFTHAND, left_hand);
        left_hand.children.put(LEFTHAND1, left_hand_r1);
        body.children.put(RIGHTHAND, right_hand);
    }

    public static LayerDefinition createLayer(){
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        CubeDeformation cubeDeformation5 = new CubeDeformation(-0.5f);
        CubeDeformation cubeDeformation2dot5 = new CubeDeformation(-2.5f);
        partDefinition.addOrReplaceChild(LOWBODY, CubeListBuilder.create()
                .texOffs(0,36).addBox(-6.0F, -11.5F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5)
                .texOffs(0,104).addBox(-6.0F, -11.55F, -0.5F, 12.0F, 12.0F, 12.0F, cubeDeformation5)
                .texOffs(50,36).addBox(-6.0F, -9.7F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(UPPER, CubeListBuilder.create(), PartPose.ZERO);
        partDefinition.addOrReplaceChild(HEAD, CubeListBuilder.create()
                .texOffs(0,0).addBox(-4.0F, -7.5F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation5), PartPose.offsetAndRotation(3.0F, -9.4F, -0.2F,  0.3491F, 0.0F, -0.3491F));
        partDefinition.addOrReplaceChild(HAT, CubeListBuilder.create()
                .texOffs(63,13).addBox(-5.0F, -1.5F, -5.0F, 10.0F, 2.0F, 10.0F, cubeDeformation5)
                .texOffs(31,11).addBox(-4.0F, -6.5F, -4.0F, 8.0F, 6.0F, 8.0F, cubeDeformation5), PartPose.offset(0.0F, -6.0F, 0.0F));
        partDefinition.addOrReplaceChild(BODY, CubeListBuilder.create()
                .texOffs(0,16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, cubeDeformation5), PartPose.offset(3.0F, 0.5F, 1.0F));
        partDefinition.addOrReplaceChild(CUBE,CubeListBuilder.create()
                .texOffs(0,61).addBox(-8.0F, -13.5F, -8.0F, 16.0F, 16.0F, 16.0F, cubeDeformation2dot5), PartPose.offsetAndRotation(0.0F, -9.5F, 0.0F,0.48F, 0.0F, -0.48F));
        partDefinition.addOrReplaceChild(LEFTHAND, CubeListBuilder.create(), PartPose.offsetAndRotation(4.5F, -6.8F, 0.0F, 0.0F, 1.0472F, 0.7854F));
        partDefinition.addOrReplaceChild(LEFTHAND1, CubeListBuilder.create()
                .texOffs(32,0).addBox(-0.8F, -0.5F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.offsetAndRotation(0.0121F, 0.005F, 0.0F,  0.0F, 0.0F, -0.6109F));
        partDefinition.addOrReplaceChild(RIGHTHAND, CubeListBuilder.create()
                .texOffs(32,0).addBox(-12.7121F, 5.505F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.offsetAndRotation(-4.5F, -6.8F, 0.0F, 0.0F, 0.0F, -0.7854F));
        return LayerDefinition.create(meshDefinition, 128, 128);
    }



    @Override
    public void setupAnim(ColdSnapSnowballer entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
//        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
//        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
//        this.body.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
        upper.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
