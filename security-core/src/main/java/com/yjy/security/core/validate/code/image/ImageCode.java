package com.yjy.security.core.validate.code.image;

import com.yjy.security.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;

public class ImageCode extends ValidateCode {
    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
