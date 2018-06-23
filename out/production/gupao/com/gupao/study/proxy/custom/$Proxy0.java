package com.gupao.study.proxy.custom;
import java.lang.reflect.Method;
import com.gupao.study.proxy.Calculator;
public class $Proxy0 implements com.gupao.study.proxy.Calculator{
MyInvocationHandler h = null;
public $Proxy0(MyInvocationHandler h){
this.h = h;
}
public java.lang.Integer add(java.lang.Integer arg0,java.lang.Integer arg1){
try{
Method m=com.gupao.study.proxy.Calculator.class.getMethod("add",new Class[]{java.lang.Integer.class,java.lang.Integer.class});
return (
java.lang.Integer
)this.h.invoke(this,m,new Object[]{arg0,arg1});
}catch(Throwable e){
e.printStackTrace();
}
return null;
}
public java.lang.Integer sum(java.lang.Integer arg0,java.lang.Integer arg1){
try{
Method m=com.gupao.study.proxy.Calculator.class.getMethod("sum",new Class[]{java.lang.Integer.class,java.lang.Integer.class});
return (
java.lang.Integer
)this.h.invoke(this,m,new Object[]{arg0,arg1});
}catch(Throwable e){
e.printStackTrace();
}
return null;
}
}
