package factory

import scala.collection.immutable._
import bc.ByteCode
import com.sun.org.apache.bcel.internal.generic.InstructionList
import vm.VirtualMachineParser
import bc.InvalidBytecodeException
import bc.ByteCodeParser
import bc.ByteCodeValues
/**
 * Created by tom on 10/26/15.
 */


/**
 * A `VirtualMachineParser` is used to parse a file of bytecode
 * instructions (as defined by [[vendor.ProgramParser]]). Note,
 * we will use the vendor's parser to parse a file and use the
 * adapter design pattern to write an adapter that will
 * translate a vector of [[vendor.Instruction]] into a
 * vector [[bc.ByteCode]].
 */

class MyVirtualMachineParser extends VirtualMachineParser{
  /**
   * A vector of the allowable bytecode names.
   */
  val names = Vector("iconst", "iadd", "isub", "imul", "idiv", "irem",
    "ineg", "iinc", "idec", "idup", "iswap", "print")

  /**
   * A map from bytecode names to a unique byte that represents them.
   */
  val bytecode = names.zip(1.to(names.length).map(_.toByte)).toMap
  /**
   * Returns a vector of [[bc.ByteCode]].
   *
   * This method parses a file into a vector of bytecode objects.
   * Note, this method should throw a [[bc.InvalidBytecodeException]]
   * if it fails to parse a program file correctly.
   *
   * @param file the file containing a program
   * @return a vector of bytecodes
   */
  def parse(file: String): Vector[ByteCode] = {
    val out = new VectorBuilder[ByteCode]()
    val pp = new MyProgramParser
    val bcp = new MyByteCodeFactory
    val insructions = pp.parse(file)
    for(i <- insructions){
      if(i.args.length == 1) {
        out += bcp.make(bytecode(i.name), i.args(0))
      } else if(i.args.length == 0) out += bcp.make(bytecode(i.name))
      else throw new InvalidBytecodeException("too many bruh")

    }
    return out.result()
    }



  /**
   * Returns a vector of [[bc.ByteCode]].
   *
   * This method parses a string into a vector of bytecode objects.
   * Note, this method should throw a [[bc.InvalidBytecodeException]]
   * if it fails to parse a program string correctly.
   *
   * @param str a string containing a program
   * @return a vector of bytecodes
   */
  def parseString(str: String): Vector[ByteCode] = {
    val out = new VectorBuilder[ByteCode]()
    val pp = new MyProgramParser
    val bcp = new MyByteCodeFactory
    val insructions = pp.parseString(str)
    for(i <- insructions){
      if(i.args.length == 1) {
        out += bcp.make(bytecode(i.name), i.args(0))
      } else if(i.args.length == 0) out += bcp.make(bytecode(i.name))
      else throw new InvalidBytecodeException("too many bruh")

    }
    return out.result()
  }
}
