package com.yjy.security.core.social.qq.config;

import com.yjy.security.core.properties.SecurityProperties;
import com.yjy.security.core.social.SocialConfig;
import com.yjy.security.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;

@Configuration
@ConditionalOnProperty(prefix = "security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private SocialConfig socialConfig;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        return new QQConnectionFactory(securityProperties.getSocial().getQq().getProviderId(),
                securityProperties.getSocial().getQq().getAppId(),
                securityProperties.getSocial().getQq().getAppSecret());
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return socialConfig.getUsersConnectionRepository(connectionFactoryLocator);
    }
}
