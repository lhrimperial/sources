// class version 46.0 (46)
// access flags 0x1
public class com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 extends net/sf/cglib/reflect/FastClass  {

  // compiled from: <generated>

  // access flags 0x1
  public <init>(Ljava/lang/Class;)V
    ALOAD 0
    ALOAD 1
    INVOKESPECIAL net/sf/cglib/reflect/FastClass.<init> (Ljava/lang/Class;)V
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x1
  public getIndex(Lnet/sf/cglib/core/Signature;)I
    ALOAD 1
    INVOKEVIRTUAL java/lang/Object.toString ()Ljava/lang/String;
    DUP
    INVOKEVIRTUAL java/lang/Object.hashCode ()I
    LOOKUPSWITCH
      -40645898: L0
      33019121: L1
      1826985398: L2
      1913648695: L3
      1984935277: L4
      default: L5
   L0
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 net/sf/cglib/core/Signature] [java/lang/String]
    LDC "realMethod()V"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    ICONST_1
    IRETURN
   L1
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 net/sf/cglib/core/Signature] [java/lang/String]
    LDC "testFinal()V"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    ICONST_0
    IRETURN
   L2
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 net/sf/cglib/core/Signature] [java/lang/String]
    LDC "equals(Ljava/lang/Object;)Z"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    ICONST_2
    IRETURN
   L3
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 net/sf/cglib/core/Signature] [java/lang/String]
    LDC "toString()Ljava/lang/String;"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    ICONST_3
    IRETURN
   L4
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 net/sf/cglib/core/Signature] [java/lang/String]
    LDC "hashCode()I"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    ICONST_4
    IRETURN
   L5
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 net/sf/cglib/core/Signature] [java/lang/String]
    POP
   L6
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 net/sf/cglib/core/Signature] []
    ICONST_M1
    IRETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x1
  public getIndex(Ljava/lang/String;[Ljava/lang/Class;)I
    ALOAD 1
    ALOAD 2
    SWAP
    DUP
    INVOKEVIRTUAL java/lang/Object.hashCode ()I
    LOOKUPSWITCH
      -1776922004: L0
      -1295482945: L1
      -1203529724: L2
      147696667: L3
      2119297055: L4
      default: L5
   L0
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class; java/lang/String]
    LDC "toString"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    DUP
    ARRAYLENGTH
    TABLESWITCH
      0: L7
      default: L8
   L7
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    POP
    ICONST_3
    IRETURN
   L8
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    GOTO L9
   L1
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class; java/lang/String]
    LDC "equals"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    DUP
    ARRAYLENGTH
    TABLESWITCH
      1: L10
      default: L11
   L10
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    DUP
    ICONST_0
    AALOAD
    INVOKEVIRTUAL java/lang/Class.getName ()Ljava/lang/String;
    LDC "java.lang.Object"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L9
    POP
    ICONST_2
    IRETURN
   L11
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    GOTO L9
   L2
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class; java/lang/String]
    LDC "testFinal"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    DUP
    ARRAYLENGTH
    TABLESWITCH
      0: L12
      default: L13
   L12
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    POP
    ICONST_0
    IRETURN
   L13
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    GOTO L9
   L3
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class; java/lang/String]
    LDC "hashCode"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    DUP
    ARRAYLENGTH
    TABLESWITCH
      0: L14
      default: L15
   L14
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    POP
    ICONST_4
    IRETURN
   L15
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    GOTO L9
   L4
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class; java/lang/String]
    LDC "realMethod"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    DUP
    ARRAYLENGTH
    TABLESWITCH
      0: L16
      default: L17
   L16
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    POP
    ICONST_1
    IRETURN
   L17
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    GOTO L9
   L5
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class; java/lang/String]
    POP
   L6
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    GOTO L9
   L9
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    POP
    ICONST_M1
    IRETURN
    MAXSTACK = 3
    MAXLOCALS = 3

  // access flags 0x1
  public getIndex([Ljava/lang/Class;)I
    ALOAD 1
    DUP
    ARRAYLENGTH
    TABLESWITCH
      0: L0
      default: L1
   L0
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 [Ljava/lang/Class;] [[Ljava/lang/Class;]
    POP
    ICONST_0
    IRETURN
   L1
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 [Ljava/lang/Class;] [[Ljava/lang/Class;]
    GOTO L2
   L2
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 [Ljava/lang/Class;] [[Ljava/lang/Class;]
    POP
    ICONST_M1
    IRETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x1
  public invoke(ILjava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object; throws java/lang/reflect/InvocationTargetException 
    TRYCATCHBLOCK L0 L1 L1 java/lang/Throwable
    ALOAD 2
    CHECKCAST com/github/sources/proxy/cglib/RealService
    ILOAD 1
   L0
    TABLESWITCH
      0: L2
      1: L3
      2: L4
      3: L5
      4: L6
      default: L7
   L2
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 I java/lang/Object [Ljava/lang/Object;] [com/github/sources/proxy/cglib/RealService]
    INVOKEVIRTUAL com/github/sources/proxy/cglib/RealService.testFinal ()V
    ACONST_NULL
    ARETURN
   L3
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 I java/lang/Object [Ljava/lang/Object;] [com/github/sources/proxy/cglib/RealService]
    INVOKEVIRTUAL com/github/sources/proxy/cglib/RealService.realMethod ()V
    ACONST_NULL
    ARETURN
   L4
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 I java/lang/Object [Ljava/lang/Object;] [com/github/sources/proxy/cglib/RealService]
    ALOAD 3
    ICONST_0
    AALOAD
    INVOKEVIRTUAL com/github/sources/proxy/cglib/RealService.equals (Ljava/lang/Object;)Z
    NEW java/lang/Boolean
    DUP_X1
    SWAP
    INVOKESPECIAL java/lang/Boolean.<init> (Z)V
    ARETURN
   L5
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 I java/lang/Object [Ljava/lang/Object;] [com/github/sources/proxy/cglib/RealService]
    INVOKEVIRTUAL com/github/sources/proxy/cglib/RealService.toString ()Ljava/lang/String;
    ARETURN
   L6
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 I java/lang/Object [Ljava/lang/Object;] [com/github/sources/proxy/cglib/RealService]
    INVOKEVIRTUAL com/github/sources/proxy/cglib/RealService.hashCode ()I
    NEW java/lang/Integer
    DUP_X1
    SWAP
    INVOKESPECIAL java/lang/Integer.<init> (I)V
    ARETURN
   L7
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 I java/lang/Object [Ljava/lang/Object;] [com/github/sources/proxy/cglib/RealService]
    GOTO L8
   L1
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 I java/lang/Object [Ljava/lang/Object;] [java/lang/Throwable]
    NEW java/lang/reflect/InvocationTargetException
    DUP_X1
    SWAP
    INVOKESPECIAL java/lang/reflect/InvocationTargetException.<init> (Ljava/lang/Throwable;)V
    ATHROW
   L8
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 I java/lang/Object [Ljava/lang/Object;] [com/github/sources/proxy/cglib/RealService]
    NEW java/lang/IllegalArgumentException
    DUP
    LDC "Cannot find matching method/constructor"
    INVOKESPECIAL java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
    ATHROW
    MAXSTACK = 4
    MAXLOCALS = 4

  // access flags 0x1
  public newInstance(I[Ljava/lang/Object;)Ljava/lang/Object; throws java/lang/reflect/InvocationTargetException 
    TRYCATCHBLOCK L0 L1 L1 java/lang/Throwable
   L2
    NEW com/github/sources/proxy/cglib/RealService
    DUP
    ILOAD 1
   L0
    TABLESWITCH
      0: L3
      default: L4
   L3
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 I [Ljava/lang/Object;] [L2 L2]
    INVOKESPECIAL com/github/sources/proxy/cglib/RealService.<init> ()V
    ARETURN
   L4
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 I [Ljava/lang/Object;] [L2 L2]
    GOTO L5
   L1
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 I [Ljava/lang/Object;] [java/lang/Throwable]
    NEW java/lang/reflect/InvocationTargetException
    DUP_X1
    SWAP
    INVOKESPECIAL java/lang/reflect/InvocationTargetException.<init> (Ljava/lang/Throwable;)V
    ATHROW
   L5
   FRAME FULL [com/github/sources/proxy/cglib/RealService$$FastClassByCGLIB$$b5f91b96 I [Ljava/lang/Object;] [L2 L2]
    NEW java/lang/IllegalArgumentException
    DUP
    LDC "Cannot find matching method/constructor"
    INVOKESPECIAL java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
    ATHROW
    MAXSTACK = 5
    MAXLOCALS = 3

  // access flags 0x1
  public getMaxIndex()I
    ICONST_4
    IRETURN
    MAXSTACK = 1
    MAXLOCALS = 1
}
