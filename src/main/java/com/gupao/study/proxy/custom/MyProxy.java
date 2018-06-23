package com.gupao.study.proxy.custom;


import com.gupao.study.proxy.custom.compiler.DynamicEngine;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/18
 */
public class MyProxy {

    public static Object newProxyInstance(MyClassLoader classLoader,
                                          Class<?>[] interfaces,
                                          MyInvocationHandler h){
        try {
            // 写java源码
            String src = generateSrc(interfaces);

//            // 输出到文件
//            String path = MyProxy.class.getResource("").getPath();
//            File f = new File(path + "$Proxy0.java");
//            FileWriter fw = new FileWriter(f);
//            fw.write(src);
//            fw.flush();
//            fw.close();
//
//            // 编译成class文件
//            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//            StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
//            Iterable iterable = manage.getJavaFileObjects(f);
//
//            JavaCompiler.CompilationTask task = compiler.getTask(null, manage, null, null, null,iterable);
//            task.call();
//            manage.close();
//
//            //4、编译生成的.class文件加载到JVM中来
//            Class proxyClass = classLoader.findClass("$Proxy0");

            String fullName = "com.gupao.study.proxy.custom.$Proxy0";
            DynamicEngine de = DynamicEngine.getInstance();
            Class proxyClass = de.javaCodeToClass(fullName, src);
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);

            // 返回对象
            return c.newInstance(h);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;

    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        append(sb, "package com.gupao.study.proxy.custom;");

        append(sb, "import java.lang.reflect.Method;");
        append(sb, "import "+interfaces[0].getName()+";");

        append(sb, "public class $Proxy0 implements "+ interfaces[0].getName() + "{");

        append(sb, "MyInvocationHandler h = null;");

        append(sb, "public $Proxy0(MyInvocationHandler h){");
        append(sb, "this.h = h;");
        append(sb, "}");

        for(Class<?> interfaceItem :interfaces){
            for(Method m : interfaceItem.getMethods()){
                sb.append("public "+m.getReturnType().getName()+" "+ m.getName() +"(");
                StringBuffer strParams = new StringBuffer("");
                for(Parameter parameter :m.getParameters()){
                    sb.append(parameter.getType().getName()+" " + parameter.getName() + ",");
                    strParams.append(parameter.getName() + ",");
                }
                strParams.deleteCharAt(strParams.length() -1);
                sb.deleteCharAt(sb.length()-1);
                sb.append(")");
                append(sb, "{");
                append(sb, "try{");
                sb.append("Method m="+interfaces[0].getName()+".class.getMethod(\""
                        +m.getName()+"\",new Class[]{");
                for(Class<?> type :m.getParameterTypes()){
                    sb.append(type.getName()+".class,");
                }
                sb.deleteCharAt(sb.length() - 1);
                append(sb, "});");
                append(sb, "return (");
                append(sb, m.getReturnType().getName());
                append(sb, ")this.h.invoke(this,m,new Object[]{"+strParams+"});");
                append(sb,"}catch(Throwable e){");
                append(sb, "e.printStackTrace();");
                append(sb, "}");
                append(sb, "return null;");
                append(sb, "}");
            }

        }

        append(sb, "}");
        return sb.toString();
    }

    private static void append(StringBuffer sb, String code){
        sb.append(code).append("\r\n");
    }
}
