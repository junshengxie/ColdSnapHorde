package com.cartoonishvillain.coldsnaphorde.Client.Models;// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapStabber;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.GenericHordeMember;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.SnowGolemModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class ColdSnapStabberModel<C extends GenericHordeMember> extends EntityModel<ColdSnapStabber> {
	private static final String LOWBODY = "lowbody";
	private static final String BODY = "body";
	private static final String LEFTHAND = "lefthand";
	private static final String RIGHTHAND = "righthand";
	private static final String KNIFE = "knife";
	private static final String HAT = "hat";
	private static final String HEAD = "head";
	private final ModelPart lowbody;
	private final ModelPart body;
	private final ModelPart left_hand;
	private final ModelPart right_hand;
	private final ModelPart knife;
	private final ModelPart head;
	private final ModelPart hat;

	public ColdSnapStabberModel(ModelPart part) {
		super(RenderType::entityCutoutNoCull);
		this.head = part.getChild(HEAD);
		this.hat = part.getChild(HAT);
		this.knife = part.getChild(KNIFE);
		this.right_hand = part.getChild(RIGHTHAND);
		this.left_hand = part.getChild(LEFTHAND);
		this.body = part.getChild(BODY);
		this.lowbody = part.getChild(LOWBODY);
		lowbody.setPos(0.0F, 24.0F, 0.0F);
		body.setPos(0, 13, 0);
		right_hand.setPos(-4, 6, 0);
		left_hand.setPos(5, 6, 0);
		knife.setPos(-4F, -2.5f, -1.5F);
		head.setPos(0, 4, 0);
		hat.setPos(0, 4, 0);
		left_hand.setRotation(0.0f, 0.0f, 0.9163f);
		right_hand.setRotation(0f, -0.3927f, 1.5708f);
		knife.setRotation(2.138F, 0.0F, 0.0F);
	}

	public static LayerDefinition createLayer(){
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();
		CubeDeformation cubedeformation5 = new CubeDeformation(-0.5F);
		CubeDeformation cubedeformation25 = new CubeDeformation(-0.25F);
		partDefinition.addOrReplaceChild(LOWBODY, CubeListBuilder.create()
				.texOffs(0, 36).addBox(-6, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, cubedeformation5), PartPose.ZERO);
		partDefinition.addOrReplaceChild(BODY, CubeListBuilder.create()
				.texOffs(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, cubedeformation5), PartPose.ZERO);
		partDefinition.addOrReplaceChild(LEFTHAND, CubeListBuilder.create()
				.texOffs(32, 0).addBox(-1.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, cubedeformation5), PartPose.ZERO);
		partDefinition.addOrReplaceChild(RIGHTHAND, CubeListBuilder.create()
				.texOffs(32, 0).addBox(-11.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, cubedeformation5), PartPose.ZERO);
		partDefinition.addOrReplaceChild(KNIFE, CubeListBuilder.create()
				.texOffs(41, 26).addBox(-1.5F, -4.0F, 0.5F, 1.0F, 3.0F, 2.0F, cubedeformation25)
				.texOffs(36, 40).addBox(-2.0F, -5.0F, -1.0F, 2.0F, 2.0F, 5.0F, cubedeformation5)
				.texOffs(1,17).addBox(-2.0F, -8.0F, 0.0F, 2.0F, 4.0F, 2.0F, cubedeformation5)
				.texOffs(0, 36).addBox(-2.0F, -9.0F, 1.0F, 2.0F, 5.0F, 2.0F, cubedeformation5), PartPose.ZERO);
		partDefinition.addOrReplaceChild(HEAD, CubeListBuilder.create()
				.texOffs(0,0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedeformation5), PartPose.ZERO);
		partDefinition.addOrReplaceChild(HAT, CubeListBuilder.create()
				.texOffs(63, 13).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, cubedeformation5)
				.texOffs(31,11).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, cubedeformation5), PartPose.ZERO);
		return LayerDefinition.create(meshDefinition, 128, 128);
	}


//		textureWidth = 128;
//		textureHeight = 128;
//
//		lowbody = new ModelRenderer(this);
//		lowbody.setRotationPoint(0.0F, 24.0F, 0.0F);
//		lowbody.setTextureOffset(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);
//
//		body = new ModelRenderer(this);
//		body.setRotationPoint(0.0F, 13.0F, 0.0F);
//		body.setTextureOffset(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);
//
//		left_hand = new ModelRenderer(this);
//		left_hand.setRotationPoint(5.0F, 6.0F, 0.0F);
//		setRotationAngle(left_hand, 0.0F, 0.0F, 0.9163F);
//		left_hand.setTextureOffset(32, 0).addBox(-1.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);
//
//		right_hand = new ModelRenderer(this);
//		right_hand.setRotationPoint(-4.0F, 6.0F, 0.0F);
//		setRotationAngle(right_hand, 0.0F, -0.3927F, 1.5708F);
//		right_hand.setTextureOffset(32, 0).addBox(-11.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);
//
//		Knife = new ModelRenderer(this);
//		Knife.setRotationPoint(-11.1183F, 2.125F, 1.3915F);
//		right_hand.addChild(Knife);
//		setRotationAngle(Knife, 1.4399F, 0.0F, 1.5708F);
//		Knife.setTextureOffset(41, 26).addBox(-1.5F, -4.0F, 0.5F, 1.0F, 3.0F, 2.0F, -0.25F, false);
//		Knife.setTextureOffset(36, 40).addBox(-2.0F, -5.0F, -1.0F, 2.0F, 2.0F, 5.0F, -0.5F, false);
//		Knife.setTextureOffset(1, 17).addBox(-2.0F, -8.0F, 0.0F, 2.0F, 4.0F, 2.0F, -0.5F, false);
//		Knife.setTextureOffset(0, 36).addBox(-2.0F, -9.0F, 1.0F, 2.0F, 5.0F, 2.0F, -0.5F, false);
//
//		head = new ModelRenderer(this);
//		head.setRotationPoint(0.0F, 4.0F, 0.0F);
//		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);
//
//		hat = new ModelRenderer(this);
//		hat.setRotationPoint(0.0F, 0.0F, 0.0F);
//		head.addChild(hat);
//		hat.setTextureOffset(63, 13).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
//		hat.setTextureOffset(31, 11).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);

	@Override
	public void setupAnim(ColdSnapStabber  entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = headPitch * ((float)Math.PI / 180F);
		this.hat.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.hat.xRot = headPitch * ((float)Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
	}


	@Override
	public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float p_103115_, float p_103116_, float p_103117_, float p_103118_) {
		lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		left_hand.render(matrixStack, buffer, packedLight, packedOverlay);
		right_hand.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		hat.render(matrixStack, buffer, packedLight, packedOverlay);
		knife.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}