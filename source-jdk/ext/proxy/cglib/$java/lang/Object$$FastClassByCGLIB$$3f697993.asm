// class version 46.0 (46)
// access flags 0x1
public class $java/lang/Object$$FastClassByCGLIB$$3f697993 extends net/sf/cglib/reflect/FastClass  {

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
      1826985398: L0
      1913648695: L1
      1984935277: L2
      default: L3
   L0
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 net/sf/cglib/core/Signature] [java/lang/String]
    LDC "equals(Ljava/lang/Object;)Z"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L4
    ICONST_0
    IRETURN
   L1
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 net/sf/cglib/core/Signature] [java/lang/String]
    LDC "toString()Ljava/lang/String;"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L4
    ICONST_1
    IRETURN
   L2
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 net/sf/cglib/core/Signature] [java/lang/String]
    LDC "hashCode()I"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L4
    ICONST_2
    IRETURN
   L3
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 net/sf/cglib/core/Signature] [java/lang/String]
    POP
   L4
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 net/sf/cglib/core/Signature] []
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
      147696667: L2
      default: L3
   L0
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class; java/lang/String]
    LDC "toString"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L4
    DUP
    ARRAYLENGTH
    TABLESWITCH
      0: L5
      default: L6
   L5
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    POP
    ICONST_1
    IRETURN
   L6
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    GOTO L7
   L1
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class; java/lang/String]
    LDC "equals"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L4
    DUP
    ARRAYLENGTH
    TABLESWITCH
      1: L8
      default: L9
   L8
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    DUP
    ICONST_0
    AALOAD
    INVOKEVIRTUAL java/lang/Class.getName ()Ljava/lang/String;
    LDC "java.lang.Object"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L7
    POP
    ICONST_0
    IRETURN
   L9
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    GOTO L7
   L2
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class; java/lang/String]
    LDC "hashCode"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L4
    DUP
    ARRAYLENGTH
    TABLESWITCH
      0: L10
      default: L11
   L10
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    POP
    ICONST_2
    IRETURN
   L11
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    GOTO L7
   L3
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class; java/lang/String]
    POP
   L4
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
    GOTO L7
   L7
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 java/lang/String [Ljava/lang/Class;] [[Ljava/lang/Class;]
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
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 [Ljava/lang/Class;] [[Ljava/lang/Class;]
    POP
    ICONST_0
    IRETURN
   L1
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 [Ljava/lang/Class;] [[Ljava/lang/Class;]
    GOTO L2
   L2
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 [Ljava/lang/Class;] [[Ljava/lang/Class;]
    POP
    ICONST_M1
    IRETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x1
  public invoke(ILjava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object; throws java/lang/reflect/InvocationTargetException 
    TRYCATCHBLOCK L0 L1 L1 java/lang/Throwable
    ALOAD 2
    ILOAD 1
   L0
    TABLESWITCH
      0: L2
      1: L3
      2: L4
      default: L5
   L2
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 I java/lang/Object [Ljava/lang/Object;] [java/lang/Object]
    ALOAD 3
    ICONST_0
    AALOAD
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    NEW java/lang/Boolean
    DUP_X1
    SWAP
    INVOKESPECIAL java/lang/Boolean.<init> (Z)V
    ARETURN
   L3
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 I java/lang/Object [Ljava/lang/Object;] [java/lang/Object]
    INVOKEVIRTUAL java/lang/Object.toString ()Ljava/lang/String;
    ARETURN
   L4
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 I java/lang/Object [Ljava/lang/Object;] [java/lang/Object]
    INVOKEVIRTUAL java/lang/Object.hashCode ()I
    NEW java/lang/Integer
    DUP_X1
    SWAP
    INVOKESPECIAL java/lang/Integer.<init> (I)V
    ARETURN
   L5
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 I java/lang/Object [Ljava/lang/Object;] [java/lang/Object]
    GOTO L6
   L1
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 I java/lang/Object [Ljava/lang/Object;] [java/lang/Throwable]
    NEW java/lang/reflect/InvocationTargetException
    DUP_X1
    SWAP
    INVOKESPECIAL java/lang/reflect/InvocationTargetException.<init> (Ljava/lang/Throwable;)V
    ATHROW
   L6
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 I java/lang/Object [Ljava/lang/Object;] [java/lang/Object]
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
    NEW java/lang/Object
    DUP
    ILOAD 1
   L0
    TABLESWITCH
      0: L3
      default: L4
   L3
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 I [Ljava/lang/Object;] [L2 L2]
    INVOKESPECIAL java/lang/Object.<init> ()V
    ARETURN
   L4
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 I [Ljava/lang/Object;] [L2 L2]
    GOTO L5
   L1
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 I [Ljava/lang/Object;] [java/lang/Throwable]
    NEW java/lang/reflect/InvocationTargetException
    DUP_X1
    SWAP
    INVOKESPECIAL java/lang/reflect/InvocationTargetException.<init> (Ljava/lang/Throwable;)V
    ATHROW
   L5
   FRAME FULL [$java/lang/Object$$FastClassByCGLIB$$3f697993 I [Ljava/lang/Object;] [L2 L2]
    NEW java/lang/IllegalArgumentException
    DUP
    LDC "Cannot find matching method/constructor"
    INVOKESPECIAL java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
    ATHROW
    MAXSTACK = 5
    MAXLOCALS = 3

  // access flags 0x1
  public getMaxIndex()I
    ICONST_2
    IRETURN
    MAXSTACK = 1
    MAXLOCALS = 1
}
