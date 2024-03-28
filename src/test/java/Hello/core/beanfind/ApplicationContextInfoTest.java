package Hello.core.beanfind;

import Hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


 class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 호출하기")
     void findAllBean(){
       String[] beanDefinitionNames= ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean = "+beanDefinitionName + "object = "+ bean);
        }
    }
}
