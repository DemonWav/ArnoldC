package org.arnoldc.ast

import org.arnoldc.SymbolTable
import org.objectweb.asm.Opcodes._
import org.objectweb.asm.{Label, MethodVisitor}

case class AndNode(operand1: AstNode, operand2: AstNode) extends ExpressionNode {
  def generate(mv: MethodVisitor, symbolTable: SymbolTable) {
    val eitherFalse = new Label()
    val conclude = new Label()
    operand1.generate(mv, symbolTable)
    mv.visitInsn(FCONST_0)
    mv.visitInsn(FCMPL)
    mv.visitJumpInsn(IFEQ, eitherFalse)
    operand2.generate(mv, symbolTable)
    mv.visitInsn(FCONST_0)
    mv.visitInsn(FCMPL)
    mv.visitJumpInsn(IFEQ, eitherFalse)
    mv.visitInsn(FCONST_1)
    mv.visitJumpInsn(GOTO, conclude)
    mv.visitLabel(eitherFalse)
    mv.visitFrame(F_FULL, symbolTable.size(), symbolTable.getStackFrame, 0, null)
    mv.visitInsn(FCONST_0)
    mv.visitJumpInsn(GOTO, conclude)
    mv.visitLabel(conclude)
    mv.visitFrame(F_SAME1, 0, null, 1, Array(FLOAT))
  }
}
