package com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.coldsnaphorde.Client.Models.BaseModels.ColdSnapStabberModel;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapStabber;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class NetherColdSnapStabberModel<C extends GenericHordeMember> extends EntityModel<ColdSnapStabber> {
	private final ModelRenderer lowbody;
	private final ModelRenderer bone2;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer hat;
	private final ModelRenderer left_hand;
	private final ModelRenderer right_hand;
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;

	public NetherColdSnapStabberModel() {
		textureWidth = 128;
		textureHeight = 128;

		lowbody = new ModelRenderer(this);
		lowbody.setRotationPoint(0.0F, 24.0F, 0.0F);
		lowbody.setTextureOffset(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);
		lowbody.setTextureOffset(53, 95).addBox(-6.0F, -12.0F, -0.5F, 12.0F, 12.0F, 12.0F, -0.5F, false);
		lowbody.setTextureOffset(62, 36).addBox(-6.0F, -10.17F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 14.4F, 0.0F);
		setRotationAngle(bone2, 0.1222F, 0.0F, -0.1745F);
		

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.5F, 0.0F);
		bone2.addChild(body);
		body.setTextureOffset(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);
		body.setTextureOffset(0, 96).addBox(-2.9F, -4.3F, -2.9F, 8.0F, 8.0F, 8.0F, -0.5F, false);
		body.setTextureOffset(0, 80).addBox(-2.9F, -11.3F, -2.9F, 8.0F, 8.0F, 8.0F, -0.5F, false);
		body.setTextureOffset(32, 96).addBox(1.48F, -11.3F, 0.6F, 8.0F, 8.0F, 8.0F, -0.5F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -9.7F, 0.0F);
		bone2.addChild(head);
		setRotationAngle(head, 0.0F, 0.0F, 0.1745F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -7.5F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);
		head.setTextureOffset(0, 60).addBox(-4.9F, -2.7F, -5.0F, 10.0F, 10.0F, 10.0F, -0.7F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, -6.1F, 0.0F);
		head.addChild(hat);
		setRotationAngle(hat, 0.1745F, 0.0F, 0.0F);
		hat.setTextureOffset(63, 13).addBox(-5.0F, -1.5F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
		hat.setTextureOffset(63, 1).addBox(-5.0F, -0.5F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
		hat.setTextureOffset(31, 11).addBox(-4.0F, -6.5F, -4.0F, 8.0F, 6.0F, 8.0F, -0.49F, false);

		left_hand = new ModelRenderer(this);
		left_hand.setRotationPoint(3.3F, -9.1F, -1.0F);
		bone2.addChild(left_hand);
		setRotationAngle(left_hand, 0.0F, 0.2182F, 1.1345F);
		left_hand.setTextureOffset(32, 0).addBox(-0.6105F, -0.5038F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);

		right_hand = new ModelRenderer(this);
		right_hand.setRotationPoint(-4.5F, -6.8F, 0.0F);
		bone2.addChild(right_hand);
		setRotationAngle(right_hand, 0.0F, -0.6109F, 1.4835F);
		right_hand.setTextureOffset(32, 0).addBox(-11.3895F, -0.5038F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, true);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-10.1F, 1.0F, -0.2F);
		right_hand.addChild(bone);
		setRotationAngle(bone, -3.1416F, 0.4363F, 3.1416F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(11.0F, 0.0F, 1.0F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 3.1416F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(45, 35).addBox(-12.0F, 0.0F, -1.0F, 2.0F, 1.0F, 4.0F, -0.1F, false);
		cube_r1.setTextureOffset(50, 47).addBox(-12.0F, -0.4F, 6.6F, 2.0F, 1.0F, 4.0F, -0.1F, false);
		cube_r1.setTextureOffset(50, 43).addBox(-11.1F, -0.4F, 2.8F, 2.0F, 1.0F, 4.0F, -0.1F, false);
		cube_r1.setTextureOffset(44, 43).addBox(-12.0F, -0.4F, 2.8F, 2.0F, 1.0F, 4.0F, -0.1F, false);
	}

	@Override
	public void setRotationAngles(ColdSnapStabber entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}