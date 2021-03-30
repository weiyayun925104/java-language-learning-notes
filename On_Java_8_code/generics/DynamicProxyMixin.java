
import java.lang.reflect.*;
import java.util.*;

class Tuple2<A, B> {
  public final A a1;
  public final B a2;
  public Tuple2(A a, B b) { a1 = a; a2 = b; }
  public String rep() { return  a1 + ", " + a2; }
  @Override public String toString() {
    return "(" + rep() + ")";
  }
}

class Tuple3<A, B, C> extends Tuple2<A, B> {
  public final C a3;
  public Tuple3(A a, B b, C c) {
    super(a, b);
    a3 = c;
  }
  @Override public String rep() {
    return super.rep() + ", " + a3;
  }
}

class Tuple4<A, B, C, D>
  extends Tuple3<A, B, C> {
  public final D a4;
  public Tuple4(A a, B b, C c, D d) {
    super(a, b, c);
    a4 = d;
  }
  @Override public String rep() {
    return super.rep() + ", " + a4;
  }
}

class Tuple5<A, B, C, D, E>
extends Tuple4<A, B, C, D> {
  public final E a5;
  public Tuple5(A a, B b, C c, D d, E e) {
    super(a, b, c, d);
    a5 = e;
  }
  @Override public String rep() {
    return super.rep() + ", " + a5;
  }
}

class Tuple {
  public static <A, B> Tuple2<A, B> tuple(A a, B b) {
    return new Tuple2<>(a, b);
  }
  public static <A, B, C> Tuple3<A, B, C>
  tuple(A a, B b, C c) {
    return new Tuple3<>(a, b, c);
  }
  public static <A, B, C, D> Tuple4<A, B, C, D>
  tuple(A a, B b, C c, D d) {
    return new Tuple4<>(a, b, c, d);
  }
  public static <A, B, C, D, E>
  Tuple5<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
    return new Tuple5<>(a, b, c, d, e);
  }
}

class MixinProxy implements InvocationHandler {
  Map<String, Object> delegatesByMethod;
  @SuppressWarnings("unchecked")
  MixinProxy(Tuple2<Object, Class<?>>... pairs) {
    delegatesByMethod = new HashMap<>();
    for(Tuple2<Object, Class<?>> pair : pairs) {
      for(Method method : pair.a2.getMethods()) {
        String methodName = method.getName();
        // The first interface in the map
        // implements the method.
        if(!delegatesByMethod.containsKey(methodName))
          delegatesByMethod.put(methodName, pair.a1);
      }
    }
  }
  @Override
  public Object invoke(Object proxy, Method method,
    Object[] args) throws Throwable {
    String methodName = method.getName();
    Object delegate = delegatesByMethod.get(methodName);
    return method.invoke(delegate, args);
  }
  @SuppressWarnings("unchecked")
  public static Object newInstance(Tuple2... pairs) {
    Class[] interfaces = new Class[pairs.length];
    for(int i = 0; i < pairs.length; i++) {
      interfaces[i] = (Class)pairs[i].a2;
    }
    ClassLoader cl =
      pairs[0].a1.getClass().getClassLoader();
    return Proxy.newProxyInstance(
      cl, interfaces, new MixinProxy(pairs));
  }
}

public class DynamicProxyMixin {
  public static void main(String[] args) {
    @SuppressWarnings("unchecked")
    Object mixin = MixinProxy.newInstance(
      Tuple.tuple(new BasicImp(), Basic.class),
      Tuple.tuple(new TimeStampedImp(), TimeStamped.class),
      Tuple.tuple(new SerialNumberedImp(), SerialNumbered.class));
    Basic b = (Basic)mixin;
    TimeStamped t = (TimeStamped)mixin;
    SerialNumbered s = (SerialNumbered)mixin;
    b.set("Hello");
    System.out.println(b.get());
    System.out.println(t.getStamp());
    System.out.println(s.getSerialNumber());
  }
}
