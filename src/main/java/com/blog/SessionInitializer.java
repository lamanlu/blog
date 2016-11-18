package com.blog;

import com.blog.config.SessionConfig;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by LamanLu on 2016/11/18.
 */
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {

    public SessionInitializer(){
        super(SessionConfig.class);
    }
}
