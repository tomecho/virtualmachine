package factory

import vendor.Instruction

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
  def parse(file: String): InstructionList = ???

  /**
   * Parses a string representation of a bytecode program
   * into an `InstructionList`.
   *
   * @param string the string to parse
   * @return an instruction list
   */
  def parseString(string: String): InstructionList = ???

}
