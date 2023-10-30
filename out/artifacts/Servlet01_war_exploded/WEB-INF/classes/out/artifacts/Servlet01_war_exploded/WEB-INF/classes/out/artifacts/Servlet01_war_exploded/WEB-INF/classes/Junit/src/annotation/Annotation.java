package annotation;

/**
 * @ClassName：Annotation
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class Annotation {
    @Deprecated
    public void sayHello() {
        System.out.println("hello lutton!");
    }

    public void hello() {
        System.out.println("hello lutton!");
    }

    public void method01(){};
    public void method02(){};
    public void method03(){};
    @SuppressWarnings("all")   // 压制警告，可以看到右边黄色警告不见了
    public void method04(){};
    public void method05(){};
}
