package factory

import bc.{ByteCode, ByteCodeParser}
/**
 * Created by tom on 10/22/15.
 */
class MyByteCodeParser extends ByteCodeParser{
  /**
   * Parses a vector of `Byte` into a vector of `ByteCode`.
   *
   * You should use [[bc.ByteCodeValues.bytecode]] to help translate
   * the individual `Byte`s into a correponding [[ByteCode]].
   *
   * @param bc  a vector of bytes representing bytecodes
   * @return    a vector of `ByteCode` objects
   */
  def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    var out: Vector[ByteCode]
    var s = new MyByteCodeFactory()
    for(i <- 0 until bc.length){
      s.make(bc(i))
    }
    return out
  }

}
