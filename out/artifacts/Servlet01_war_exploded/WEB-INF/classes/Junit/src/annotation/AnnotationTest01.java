package annotation;

/**
 * @ClassName：AnnotationTest01
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class AnnotationTest01 {
    public static void main(String[] args) {
        Annotation an = new Annotation();


        an.hello();
        an.sayHello();   // 此时应显示 这是过时的。 因为加上了  @Deprecated(荒废的)注解
    }
}
