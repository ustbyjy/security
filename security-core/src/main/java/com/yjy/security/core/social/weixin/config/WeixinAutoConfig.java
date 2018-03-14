
package com.yjy.security.core.social.weixin.config;

import com.yjy.security.core.properties.SecurityProperties;
import com.yjy.security.core.properties.WeixinProperties;
import com.yjy.security.core.social.weixin.connect.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;


/**
 * 微信登录配置
 */
@Configuration
@ConditionalOnProperty(prefix = "security.social.weixin", name = "app-id")
public class WeixinAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        WeixinProperties weixin = securityProperties.getSocial().getWeixin();
        return new WeixinConnectionFactory(weixin.getProviderId(), weixin.getAppId(), weixin.getAppSecret());
    }
}
