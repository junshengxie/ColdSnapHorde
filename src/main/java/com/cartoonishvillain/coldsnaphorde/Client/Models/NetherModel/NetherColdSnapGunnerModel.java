package com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGunner;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.OpticParts;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class NetherColdSnapGunnerModel<C extends GenericHordeMember> extends EntityModel<ColdSnapGunner> {
    private final ModelPart lowbody;
    private final ModelPart bone;
    private final ModelPart right_hand;
    private final ModelPart gun;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart hat;
    private final ModelPart left_hand;

    private static final String LOWBODY = "lowbody";
    private static final String BODY = "body";
    private static final String LEFTHAND = "lefthand";
    private static final String HEAD = "head";
    private static final String HAT = "hat";
    private static final String RIGHTHAND = "righthand";
    private static final String GUN = "gun";
    private static final String BONE = "bone";

    public NetherColdSnapGunnerModel(ModelPart part){
        super(RenderType::entityCutoutNoCull);
        this.head = part.getChild(HEAD);
        this.lowbody = part.getChild(LOWBODY);
        this.body = part.getChild(BODY);
        this.left_hand = part.getChild(LEFTHAND);
        this.hat = part.getChild(HAT);
        this.right_hand = part.getChild(RIGHTHAND);
        this.gun = part.getChild(GUN);
        this.bone = part.getChild(BONE);
        lowbody.setPos(0, 24, 0);
        bone.setPos(0, 14.4f, 0);
        bone.setRotation(-0.2937F, 0.3009F, -0.1827F);
        bone.children.put(RIGHTHAND, right_hand);
        right_hand.children.put(GUN, gun);
        bone.children.put(BODY, body);
        bone.children.put(HEAD, head);
        head.children.put(HAT, hat);
        bone.children.put(LEFTHAND, left_hand);
    }

    public static LayerDefinition createLayer(){
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        CubeDeformation cubeDeformation5 = new CubeDeformation(-0.5f);
        CubeDeformation cubeDeformation51 = new CubeDeformation(-0.51f);
        CubeDeformation cubeDeformation499 = new CubeDeformation(-0.499f);
        partDefinition.addOrReplaceChild(LOWBODY, CubeListBuilder.create()
                .texOffs(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5)
                .texOffs(0, 60).addBox(-6.0F, -12.0F, -1.45F, 12.0F, 12.0F, 12.0F, cubeDeformation5)
                .texOffs(50, 36).addBox(-6.0F, -10.17F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5),  PartPose.ZERO);
        partDefinition.addOrReplaceChild(BONE, CubeListBuilder.create(), PartPose.ZERO);
        partDefinition.addOrReplaceChild(RIGHTHAND, CubeListBuilder.create()
                .texOffs(32, 0).addBox(-11.3895F, -0.5038F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.offsetAndRotation(-0.2F, -3.2F, 0.4F, -1.5137F, 0.1122F, 0.5334F));
        partDefinition.addOrReplaceChild(GUN, CubeListBuilder.create()
                .texOffs(120,124).addBox(-1.0F, -4.6F, -7.4F, 2.0F, 2.0F, 2.0F, cubeDeformation51)
                .texOffs(103, 119).addBox(-1.0F, -5.0F, -6.9F, 2.0F, 4.0F, 5.0F, cubeDeformation51)
                .texOffs(94, 115).addBox(-1.0F, -5.0F, -4.5F, 2.0F, 4.0F, 5.0F, cubeDeformation5)
                .texOffs(114, 94).addBox(-1.0F, -2.0F, -4.5F, 2.0F, 4.0F, 5.0F, cubeDeformation5)
                .texOffs(114, 102).addBox(-1.0F, -2.75F, -2.1F, 2.0F, 4.0F, 5.0F, cubeDeformation5)
                .texOffs(112, 115).addBox(-0.5F, -3.5F, -6.1F, 2.0F, 4.0F, 5.0F, cubeDeformation5)
                .texOffs(72, 119).addBox(-0.5F, -6.5F, -3.7F, 2.0F, 4.0F, 5.0F, cubeDeformation5)
                .texOffs(120, 124).addBox(-1.0F, -3.4F, -7.4F, 2.0F, 2.0F, 2.0F, cubeDeformation51), PartPose.offsetAndRotation(-11.1F, -0.1F, 0.5F, 1.6281F, 0.2374F, -0.547F));
        partDefinition.addOrReplaceChild(BODY, CubeListBuilder.create()
                .texOffs(0,16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, cubeDeformation5), PartPose.offset(0, 0.5f, 0));
        partDefinition.addOrReplaceChild(HEAD, CubeListBuilder.create()
                .texOffs(0,0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation5), PartPose.offsetAndRotation(0.0F, -8.5F, 0.0F, 0.3143F, -0.2103F, 0.2279F ));
        partDefinition.addOrReplaceChild(HAT, CubeListBuilder.create()
                .texOffs(63,13).addBox(-5.0F, -1.5F, -8.5F, 10.0F, 2.0F, 10.0F, cubeDeformation5)
                .texOffs(31,11).addBox(-4.0F, -6.5F, -7.5F, 8.0F, 6.0F, 8.0F, cubeDeformation499), PartPose.offsetAndRotation(0.0F, -4.6F, 3.7F, -0.3491F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild(LEFTHAND, CubeListBuilder.create()
                .texOffs(32,0).addBox(-0.6105F, -0.5038F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.offsetAndRotation(2.7F, -2.0F, 0.4F, -2.7293F, 0.3466F, -0.7453F));
        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public void setupAnim(ColdSnapGunner entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }

}
