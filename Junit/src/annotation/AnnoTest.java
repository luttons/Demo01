package annotation;

/**
 * @ClassName：AnnoTest
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */
@Anno(username = "root")
// 注意：在Anno注解里面要对原注解添加一些修饰，保证Anno注解的生存周期可以到运行时期
public class AnnoTest {
//    @Anno(username = "root", p = "toor", value = "0")    //当注解里有抽象方法时，必须传值（标准形式）
//    @Anno("myvalue")   // 当注解里只有 一个value() 抽象方式时，可以不用写前面的抽象方法的名字

//    @Anno(username = "root")
//    public void method(){
//    }
    public static void main(String[] args) {
//        获取当前类的字节码文件
        Class<AnnoTest> atc = AnnoTest.class;
//        通过当前类的 class 对象获取 注解对象(相当于是获取注解的实现类对象)
        Anno at = atc.getAnnotation(Anno.class);

//        通过注解实现类的对象获取 成员方法（属性），获取到对应的值
        String username = at.username();
        String passwood = at.passwood();

        System.out.println("username:" + username);
        System.out.println("password:" + passwood);

    }
}
