package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Anno {
    String username();     // 抽象方法， 但在注解里面可以理解为成员属性，
                           // 只要有，在调用使用的时候就必须传值

    String passwood() default "toor";  // 设置一个默认值，这样在使用的时候，就可以不用传值了


//    String[] infos();  // 数组类型的传值：     @Anno( infos = {"method", "second"})
                       // 必须用 {} 包括起来, 如果只有一个值，则{} 可以省略不写

//    String value();
}
