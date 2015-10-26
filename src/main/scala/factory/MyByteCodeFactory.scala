package factory

import bc.{InvalidBytecodeException, ByteCodeValues, ByteCode, ByteCodeFactory}
/**
 * Created by tom on 10/23/15.
 */

class MyByteCodeFactory extends ByteCodeFactory with ByteCodeValues{
  /**
   * Returns a [[ByteCode]].
   *
   * This method creates a new [[ByteCode]] object given the `byte`
   * that corresponds to the bytecode (see [[ByteCodeValues]]. If
   * the bytecode requires arguments then an optional integer
   * argument is provided.
   *
   * This method should throw an [[InvalidBytecodeException]] if the
   * given bytecode value is unknown.
   *
   * @param byte  the byte code of a bytecode
   * @param args  an optional integer argument (depends on bytecode)
   * @return a new bytecode object
   */
  def make(byte: Byte, args: Int*): ByteCode = {
    val name = bytecode.map(_.swap).get(byte)
    "iconst", "iadd", "isub", "imul", "idiv", "irem",
    "ineg", "iinc", "idec", "idup", "iswap", "print"
    if(name.equals("iconst")) new iconst()
    else if(name.equals("iadd")) new iadd()
    else if(name.equals("isub")) new isub()
    else if(name.equals("imul")) new imul()
    else if(name.equals("idiv")) new idiv()
    else if(name.equals("irem")) new irem()
    else if(name.equals("ineg")) new ineg()
    else if(name.equals("iinc")) new iinc()
    else if(name.equals("idec")) new idec()
    else if(name.equals("idup")) new idup()
    else if(name.equals("iswap")) new iswap()
    else if(name.equals("print")) new print()

  }
}
