package factory

import java.lang.Exception
import java.lang.Exception
import bc.{InvalidBytecodeException, ByteCode, ByteCodeParser}

import scala.util.control.Exception

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
    val f = new MyByteCodeFactory
    var out = Vector[ByteCode]()
    var iter = bc.iterator
    while(iter.hasNext){
      val s = iter.next()
      var n: ByteCode = null
      try {
        n = f.make(s)
      } catch {
        case d: InvalidBytecodeException => {
          if(d.getMessage.equals("no parametar on iconst")) {
            println(n + "is an iconst")
            n = f.make(s, iter.next)
          }
        }
      }
      out = out :+ n
    }
    return out
  }
}
