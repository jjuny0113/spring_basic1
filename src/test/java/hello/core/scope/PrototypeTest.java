package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        System.out.println("protoTypeBean1");
        ProtoTypeBean protoTypeBean1 = applicationContext.getBean(ProtoTypeBean.class);
        System.out.println("protoTypeBean2");
        ProtoTypeBean protoTypeBean2 = applicationContext.getBean(ProtoTypeBean.class);
        System.out.println("protoTypeBean1 = " + protoTypeBean1);
        System.out.println("protoTypeBean2 = " + protoTypeBean2);

        assertThat(protoTypeBean1).isNotSameAs(protoTypeBean2);
        applicationContext.close();
    }

    @Scope("prototype")
    static class ProtoTypeBean {
        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean.destory");
        }
    }
}
