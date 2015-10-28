package org.arnoldc.ast

import org.arnoldc.SymbolTable
import org.objectweb.asm.MethodVisitor

abstract class AstNode {
  def generate(mv: MethodVisitor, symbolTable: SymbolTable)
}
