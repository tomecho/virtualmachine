package factory

import bc.{ByteCode, ByteCodeParser}
/**
 * Created by tom on 10/22/15.
 */
class MyByteCodeParser extends ByteCodeParser{
  /**
   * Parses a vector of `Byte` into a vector of `ByteCode`.
   *
   * You should use [[ByteCodeValues.bytecode]] to help translate
   * the individual `Byte`s into a correponding [[ByteCode]].
   *
   * @param bc  a vector of bytes representing bytecodes
   * @return    a vector of `ByteCode` objects
   */
  override def parse(bc: Vector[Byte]): Vector[ByteCode] = ???

}
