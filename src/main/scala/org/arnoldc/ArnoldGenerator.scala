package org.arnoldc

import org.arnoldc.ast.RootNode


class ArnoldGenerator extends ClassLoader {

  def generate(arnoldCode: String, className: String, fileName: String): (Array[Byte], RootNode) = {
    val parser = new ArnoldParser
    val rootNode = parser.parse(arnoldCode)
    (rootNode.generateByteCode(className, fileName), rootNode)
  }
}
