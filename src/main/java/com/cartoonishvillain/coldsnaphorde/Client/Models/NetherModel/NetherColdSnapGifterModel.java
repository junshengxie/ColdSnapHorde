package com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGifter;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class NetherColdSnapGifterModel<C extends GenericHordeMember> extends EntityModel<ColdSnapGifter> {
	private final ModelRenderer bone4;
	private final ModelRenderer bone2;
	private final ModelRenderer head;
	private final ModelRenderer bone3;
	private final ModelRenderer bone;
	private final ModelRenderer bow1_r1;
	private final ModelRenderer bow2_r1;
	private final ModelRenderer left_hand;
	private final ModelRenderer present;
	private final ModelRenderer base_r1;
	private final ModelRenderer right_hand;
	private final ModelRenderer body;
	private final ModelRenderer hat;
	private final ModelRenderer lowbody;

	public NetherColdSnapGifterModel() {
		textureWidth = 128;
		textureHeight = 128;

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 24.5F, 0.0F);
		

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -9.1F, 0.0F);
		bone4.addChild(bone2);
		setRotationAngle(bone2, 0.2559F, 0.056F, -0.1237F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -7.3F, -1.5F);
		bone2.addChild(head);
		setRotationAngle(head, -0.6545F, 0.0F, 0.0F);
		head.setTextureOffset(40, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(1.0F, -1.2F, 0.6F);
		head.addChild(bone3);
		setRotationAngle(bone3, 0.2355F, 0.3829F, 0.0894F);
		bone3.setTextureOffset(0, 0).addBox(-0.95F, -4.05F, -4.45F, 1.0F, 1.0F, 1.0F, -0.05F, false);
		bone3.setTextureOffset(4, 0).addBox(-0.95F, -4.05F, -5.35F, 1.0F, 1.0F, 1.0F, -0.05F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-0.45F, -7.2F, -0.5F);
		head.addChild(bone);
		setRotationAngle(bone, -0.0859F, 0.0151F, 0.1739F);
		bone.setTextureOffset(36, 0).addBox(-6.0F, -3.4F, -4.0F, 13.0F, 4.0F, 7.0F, -0.6F, false);

		bow1_r1 = new ModelRenderer(this);
		bow1_r1.setRotationPoint(0.5F, -2.8F, -0.5F);
		bone.addChild(bow1_r1);
		setRotationAngle(bow1_r1, 0.0F, 0.7418F, 0.0F);
		bow1_r1.setTextureOffset(0, 58).addBox(-3.5F, -3.5F, -0.5F, 7.0F, 4.0F, 1.0F, -0.5F, false);

		bow2_r1 = new ModelRenderer(this);
		bow2_r1.setRotationPoint(0.5F, -2.8F, -0.5F);
		bone.addChild(bow2_r1);
		setRotationAngle(bow2_r1, 0.0F, -0.7418F, 0.0F);
		bow2_r1.setTextureOffset(0, 58).addBox(-3.5F, -3.5F, -0.5F, 7.0F, 4.0F, 1.0F, -0.5F, false);

		left_hand = new ModelRenderer(this);
		left_hand.setRotationPoint(4.5F, -6.0F, 0.0F);
		bone2.addChild(left_hand);
		setRotationAngle(left_hand, 0.662F, 1.1366F, 0.6271F);
		left_hand.setTextureOffset(48, 11).addBox(-0.9782F, -0.5F, -0.5005F, 12.0F, 2.0F, 2.0F, -0.5F, true);

		present = new ModelRenderer(this);
		present.setRotationPoint(9.8718F, 0.1F, 0.9995F);
		left_hand.addChild(present);
		

		base_r1 = new ModelRenderer(this);
		base_r1.setRotationPoint(0.6282F, -0.1F, -0.5F);
		present.addChild(base_r1);
		setRotationAngle(base_r1, 0.0F, 0.0F, 0.0436F);
		base_r1.setTextureOffset(32, 46).addBox(-5.6282F, -2.903F, -2.5F, 11.0F, 3.0F, 5.0F, -0.099F, false);

		right_hand = new ModelRenderer(this);
		right_hand.setRotationPoint(-3.1F, -4.8F, 0.9F);
		bone2.addChild(right_hand);
		setRotationAngle(right_hand, 0.2943F, -0.6534F, -0.3822F);
		right_hand.setTextureOffset(48, 11).addBox(-8.9F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.5F, 0.0F);
		bone2.addChild(body);
		body.setTextureOffset(0, 24).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, -13.1F, -3.0F);
		bone4.addChild(hat);
		setRotationAngle(hat, -1.3111F, 0.0338F, -0.1265F);
		hat.setTextureOffset(30, 34).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
		hat.setTextureOffset(0, 44).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);

		lowbody = new ModelRenderer(this);
		lowbody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(lowbody);
		lowbody.setTextureOffset(12, 72).addBox(-6.0F, -10.17F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);
		lowbody.setTextureOffset(51, 92).addBox(-6.0F, -12.0F, 0.4F, 12.0F, 12.0F, 12.0F, -0.5F, false);
		lowbody.setTextureOffset(0, 104).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);
	}

	@Override
	public void setRotationAngles(ColdSnapGifter entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone4.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}