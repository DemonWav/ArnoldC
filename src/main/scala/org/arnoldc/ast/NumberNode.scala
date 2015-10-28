package org.arnoldc.ast

import org.arnoldc.SymbolTable
import org.objectweb.asm.MethodVisitor

case class NumberNode(number: Float) extends OperandNode {
  def generate(mv: MethodVisitor, symbolTable: SymbolTable) {
    mv.visitLdcInsn(number)
  }
}
