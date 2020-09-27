package com.xiuxiu.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * @author stone
 * @date 2020/9/10 001011:18
 */
public class PasswordEncryptConfigurer extends PropertyPlaceholderConfigurer {

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
        //System.out.println("正在解密系统文件...");
        try {
            String JdPassword = props.getProperty("jdbc.password");
            String url = props.getProperty("jdbc.url");
            // rk----------------------
            if (JdPassword != null &&JdPassword.startsWith("stone")) {

                JdPassword = JdPassword.substring("stone".length());
                //解密  password
                JdPassword = encode.decode(JdPassword);
            }
            if (url != null &&url .startsWith("stone")) {

                url = url .substring("stone".length());
                //解密  password
                url = encode.decode(url);
            }
            //将解密后的密码放入Properties中
            props.setProperty("jdbc.password", JdPassword);
            props.setProperty("jdbc.url", url);
            super.processProperties(beanFactory, props);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BeanInitializationException(e.getMessage());
        }
    }

}
