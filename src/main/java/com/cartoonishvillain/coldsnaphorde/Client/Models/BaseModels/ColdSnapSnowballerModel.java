package com.cartoonishvillain.coldsnaphorde.Client.Models.BaseModels;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapSnowballer;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ColdSnapSnowballerModel<C extends GenericHordeMember> extends EntityModel<ColdSnapSnowballer> {
	private final ModelRenderer lowbody;
	private final ModelRenderer body;
	private final ModelRenderer left_hand;
	private final ModelRenderer right_hand;
	private final ModelRenderer head;
	private final ModelRenderer hat;

	public ColdSnapSnowballerModel() {
		texWidth = 128;
		texHeight = 128;

		lowbody = new ModelRenderer(this);
		lowbody.setPos(0.0F, 24.0F, 0.0F);
		lowbody.texOffs(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, 13.0F, 0.0F);
		body.texOffs(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);
		body.texOffs(0, 61).addBox(-8.0F, -23.0F, -8.0F, 16.0F, 16.0F, 16.0F, -2.5F, false);

		left_hand = new ModelRenderer(this);
		left_hand.setPos(4.5F, 6.2F, 0.0F);
		setRotationAngle(left_hand, 0.0F, 0.0F, 0.7854F);
		left_hand.texOffs(32, 0).addBox(-0.7879F, -0.495F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);

		right_hand = new ModelRenderer(this);
		right_hand.setPos(-4.5F, 6.2F, 0.0F);
		setRotationAngle(right_hand, 0.0F, 0.0F, -0.7854F);
		right_hand.texOffs(32, 0).addBox(-11.2121F, -0.495F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, 4.0F, 0.0F);
		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);

		hat = new ModelRenderer(this);
		hat.setPos(0.0F, 0.0F, 0.0F);
		head.addChild(hat);
		hat.texOffs(63, 13).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
		hat.texOffs(31, 11).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);
	}

	@Override
	public void setupAnim(ColdSnapSnowballer entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = headPitch * ((float)Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		left_hand.render(matrixStack, buffer, packedLight, packedOverlay);
		right_hand.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}