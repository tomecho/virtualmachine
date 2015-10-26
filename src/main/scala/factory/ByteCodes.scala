package factory

import bc.ByteCode
import vm.VirtualMachine

/**
 * Created by tom on 10/25/15.
 */
  class iconst(VM: VirtualMachine, NUM: Int) extends ByteCode{
    //    NUM: The iconst instruction pushes the integer value NUM on the virtual machine stack. .
    val code: Byte = bytecode(this.getClass.getSimpleName)
    override def execute(vm : VirtualMachine): VirtualMachine = {
      VM.push(NUM)
    }
  }
  class iadd(VM: VirtualMachine) extends ByteCode{
    //iadd: The iadd instruction pops the top two values from the virtual machine stack and pushes the result.
    val code: Byte = bytecode(this.getClass.getSimpleName)
    override def execute(vm : VirtualMachine): VirtualMachine = VM.push(VM.pop()._1 + VM.pop()._1)
  }
  class isub(VM: VirtualMachine) extends ByteCode{
    //  isub: The isub instruction pops the top two values from the virtual machine stack and pushes the result.
    val code: Byte = bytecode(this.getClass.getSimpleName)
    override def execute(vm : VirtualMachine): VirtualMachine = VM.push(VM.pop()._1 - VM.pop()._1)
  }
  class imul(VM: VirtualMachine) extends ByteCode{
    //  imul: The imul instruction pops the top two values from the virtual machine stack and pushes the result.
    val code: Byte = bytecode(this.getClass.getSimpleName)
    override def execute(vm : VirtualMachine): VirtualMachine = VM.push(VM.pop()._1 * VM.pop()._1)
  }
  class idiv(VM: VirtualMachine) extends ByteCode{
    //The idiv instruction pops the top two values from the virtual machine stack and pushes the result.
    val code: Byte = bytecode(this.getClass.getSimpleName)
    override def execute(vm : VirtualMachine): VirtualMachine = VM.push(VM.pop()._1 / VM.pop()._1)
  }
  class irem(VM: VirtualMachine) extends ByteCode{
    //The irem instruction pops the top two values from the virtual machine stack and pushes the result.
    val code: Byte = bytecode(this.getClass.getSimpleName)
    override def execute(vm : VirtualMachine): VirtualMachine = VM.push(VM.pop()._1 % VM.pop()._1)
  }
  class ineg(VM: VirtualMachine) extends ByteCode{
    //The ineg instruction pops the the top value from the virtual machine stack, negates it, and pushes the result.
    val code: Byte = bytecode(this.getClass.getSimpleName)
    override def execute(vm : VirtualMachine): VirtualMachine = VM.push(-VM.pop()._1)
  }
  class iinc(VM: VirtualMachine) extends ByteCode{
    //The iinc instruction pops the the top value from the virtual machine stack
  //, increments it, and pushes the result.
    val code: Byte = bytecode(this.getClass.getSimpleName)
    override def execute(vm : VirtualMachine): VirtualMachine = VM.push(VM.pop()._1+1)
  }
  class idec(VM: VirtualMachine) extends ByteCode{
    //The idec instruction pops the the top value from the virtual machine stack
    //, decrements it, and pushes the result.
    val code: Byte = bytecode(this.getClass.getSimpleName)
    override def execute(vm: VirtualMachine): VirtualMachine = VM.push(VM.pop()._1 - 1)
  }
  class iswap(VM: VirtualMachine) extends ByteCode{
    //    iswap: The iswap instruction pops the top two values from the virtual machine stack and pushes them in the opposite order - effectively swapping the top two values on the top of the stack.
    val code: Byte = bytecode(this.getClass.getSimpleName)
    override def execute(vm : VirtualMachine): VirtualMachine = {
      val x = VM.pop()._1
      val y = VM.pop()._1
      VM.push(x)
      VM.push(y)
    }
  }
  class idup(VM: VirtualMachine) extends ByteCode{
    //The idup instruction pops the top value from the stack and pushes it twice onto the stack(duplicates the top value).
    val code: Byte = bytecode(this.getClass.getSimpleName)
    override def execute(vm : VirtualMachine): VirtualMachine = {
      val x = VM.pop()._1
      VM.push(x)
      VM.push(x)
    }
  }
  class print(VM: VirtualMachine) extends ByteCode{
    //The print instruction pops the top value from the stack and prints the value to the console.
    val code: Byte = bytecode(this.getClass.getSimpleName)
    override def execute(vm : VirtualMachine): VirtualMachine = {
      println(VM.pop()._1)
      return vm
    }
  }