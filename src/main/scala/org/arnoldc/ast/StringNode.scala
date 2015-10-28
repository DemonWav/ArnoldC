package org.arnoldc.ast

import org.arnoldc.SymbolTable
import org.objectweb.asm.MethodVisitor

case class StringNode(value: String) extends OperandNode {
  def generate(mv: MethodVisitor, symbolTable: SymbolTable) {
    mv.visitLdcInsn(value)
  }
}
