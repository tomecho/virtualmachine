package factory


import vendor.InvalidInstructionFormatException
import vendor.Instruction
import scala.io.Source
import scala.collection.immutable.Vector

/**
 * Created by tom on 10/21/15.
 */
class MyProgramParser extends vendor.ProgramParser{
  /**
   * Parses a file representation of a bytecode program
   * into an `InstructionList`.
   *
   * @param file the file to parse
   * @return an instruction list
   */
  def parse(file: String): InstructionList = {
    //read file by line
    //call parseString on each line adding return value to a temp val
    var out = Vector[Instruction]()
    for(line <- Source.fromFile(file).getLines()) {
      out = out ++ (parseString(line))
    }
    return out
  }

  /**
   * Parses a string representation of a bytecode program
   * into an `InstructionList`.
   *
   * @param string the string to parse
   * @return an instruction list
   */
  def parseString(string: String): InstructionList = {
    var out = Vector[Instruction]()
    for(line <- string.split("\\n")){
      val split = line.split(" ")
      val names = Vector("iconst", "iadd", "isub", "imul", "idiv", "irem",
        "ineg", "iinc", "idec", "idup", "iswap", "print")
      if(!names.contains(split(0))) throw new InvalidInstructionFormatException(line)
      val args = split.tail.map(_.toInt).toVector
      out = out :+ (new Instruction(split(0), args))
    }
    return out
  }

}
