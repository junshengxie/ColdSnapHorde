package com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapZapper;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class NetherColdSnapZapperModel <C extends GenericHordeMember> extends EntityModel<ColdSnapZapper> {

    private static final String LOWBODY = "lowbody";
    private static final String BODY = "body";
    private static final String LEFTHAND = "lefthand";
    private static final String HEAD = "head";
    private static final String HAT = "hat";
    private static final String RIGHTHAND = "righthand";
    private static final String BONE = "bone1";
    private final ModelPart lowbody;
    private final ModelPart body;
    private final ModelPart left_hand;
    private final ModelPart right_hand;
    private final ModelPart head;
    private final ModelPart hat;
    private final ModelPart bone;

    public NetherColdSnapZapperModel(ModelPart part){
        super(RenderType::entityCutoutNoCull);
        this.lowbody = part.getChild(LOWBODY);
        this.body = part.getChild(BODY);
        this.left_hand = part.getChild(LEFTHAND);
        this.right_hand = part.getChild(RIGHTHAND);
        this.head = part.getChild(HEAD);
        this.hat = part.getChild(HAT);
        this.bone = part.getChild(BONE);
        lowbody.setPos(0.0F, 24.0F, 0.0F);
        body.setPos(0.0F, 13.0F, 0.0F);
        head.setPos(0.0F, 4.0F, 0.0F);
        bone.setPos(0.0F, 25.8F, 0.0F);
        head.children.put(HAT, hat);
        bone.children.put(LEFTHAND, left_hand);
        bone.children.put(RIGHTHAND, right_hand);
    }

    public static LayerDefinition createLayer(){
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        CubeDeformation cubeDeformation5 = new CubeDeformation(-0.5f);
        CubeDeformation cubeDeformation1 = new CubeDeformation(-0.1f);
        CubeDeformation cubeDeformation3 = new CubeDeformation(-0.3f);
        partDefinition.addOrReplaceChild(BONE, CubeListBuilder.create(), PartPose.ZERO);
        partDefinition.addOrReplaceChild(LOWBODY, CubeListBuilder.create()
                .texOffs(0,36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5)
                .texOffs(51,92).addBox(-6.0F, -12.0F, 0.4F, 12.0F, 12.0F, 12.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(BODY, CubeListBuilder.create()
                .texOffs(0, 108).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, cubeDeformation5)
                .texOffs(48, 46).addBox(-5.0F, -8.1F, -5.0F, 10.0F, 10.0F, 10.0F, cubeDeformation3), PartPose.ZERO);
        partDefinition.addOrReplaceChild(HEAD, CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -7.49F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(HAT, CubeListBuilder.create()
                .texOffs(63, 13).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, cubeDeformation5)
                .texOffs(31, 11).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, cubeDeformation5)
                .texOffs(7, 69).addBox(-1.0F, -17.4F, -1.0F, 2.0F, 9.0F, 2.0F, cubeDeformation1)
                .texOffs(15, 75).addBox(-2.0F, -21.0F, -2.0F, 4.0F, 4.0F, 4.0F, cubeDeformation3), PartPose.ZERO);
        partDefinition.addOrReplaceChild(RIGHTHAND, CubeListBuilder.create()
                .texOffs(32, 0).addBox(-11.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.offsetAndRotation(-5.0F, -18.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
        partDefinition.addOrReplaceChild(LEFTHAND, CubeListBuilder.create()
                .texOffs(32,0).addBox(-1.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.offsetAndRotation(5.0F, -18.0F, 0.0F,0.0F, 0.0F, 0.7854F));
        return LayerDefinition.create(meshDefinition, 128, 128);
    }



    @Override
    public void setupAnim(ColdSnapZapper entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.body.yRot = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        bone.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
