package factory
import vm.VirtualMachine

/**
 * Created by tom on 10/25/15.
 */
class MyByteCodes{
  def iconst(VM: VirtualMachine, NUM: Int) = {
    //    NUM: The iconst instruction pushes the integer value NUM on the virtual machine stack. .
    VM.push(NUM)
  }
  def iadd(VM: VirtualMachine) = {
    //iadd: The iadd instruction pops the top two values from the virtual machine stack and pushes the result.
    VM.push(VM.pop()._1 + VM.pop()._1)
  }
  def isub(VM: VirtualMachine) = {
    //  isub: The isub instruction pops the top two values from the virtual machine stack and pushes the result.
    VM.push(VM.pop()._1 - VM.pop()._1)
  }
  def imul(VM: VirtualMachine) = {
    //  imul: The imul instruction pops the top two values from the virtual machine stack and pushes the result.
    VM.push(VM.pop()._1 * VM.pop()._1)
  }
  def idiv(VM: VirtualMachine) = {
    //The idiv instruction pops the top two values from the virtual machine stack and pushes the result.

    VM.push(VM.pop()._1 / VM.pop()._1)
  }
  def irem(VM: VirtualMachine) = {
    //The irem instruction pops the top two values from the virtual machine stack and pushes the result.
    VM.push(VM.pop()._1 % VM.pop()._1)
  }
  def ineg(VM: VirtualMachine) = {
    //The ineg instruction pops the the top value from the virtual machine stack, negates it, and pushes the result.
    VM.push(-VM.pop()._1)
  }
  def iinc(VM: VirtualMachine) = {
    //The iinc instruction pops the the top value from the virtual machine stack
  //, increments it, and pushes the result.
    VM.push(VM.pop()._1+1)
  }
  def idec(VM: VirtualMachine) = {
  //The idec instruction pops the the top value from the virtual machine stack
  //, decrements it, and pushes the result.
    VM.push(VM.pop()._1-1)
  }
  def iswap(VM: VirtualMachine)  = {
    //    iswap: The iswap instruction pops the top two values from the virtual machine stack and pushes them in the opposite order - effectively swapping the top two values on the top of the stack.
    val x = VM.pop()._1; val y = VM.pop()._1; VM.push(x); VM.push(y)
  }
  def idup(VM: VirtualMachine) = {
    //The idup instruction pops the top value from the stack and pushes it twice onto the stack(duplicates the top value).
    val x = VM.pop()._1;
    VM.push(x);
    VM.push(x)
  }
  def print(VM: VirtualMachine) = {
    //The print instruction pops the top value from the stack and prints the value to the console.
    println(VM.pop()._1)
  }
}
