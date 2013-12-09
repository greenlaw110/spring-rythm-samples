package org.rythmengine.spring.samples.tags_transformers.tags;

import org.rythmengine.spring.JavaTagBean;
import org.springframework.stereotype.Component;

/**
 * Created by luog on 10/12/13.
 */
@Component
public class Foo extends JavaTagBean {
    @Override
    protected void call(__ParameterList params, __Body body) {
        p("[foo]");
    }

    @Override
    public String __getName() {
        return "foo";
    }
}
