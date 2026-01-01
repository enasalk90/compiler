// Generated from C:/Users/Abdullah/Desktop/complier/src/Grammer/parserpython.g4 by ANTLR 4.13.2
package Grammer;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link parserpython}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface parserpythonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link parserpython#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(parserpython.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(parserpython.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#import_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_stmt(parserpython.Import_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#import_items}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_items(parserpython.Import_itemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorator(parserpython.DecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(parserpython.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_list(parserpython.Param_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(parserpython.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(parserpython.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(parserpython.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(parserpython.Expr_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(parserpython.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#expr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_stmt(parserpython.Expr_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(parserpython.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#conditional_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_expr(parserpython.Conditional_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#logic_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_or(parserpython.Logic_orContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#logic_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_and(parserpython.Logic_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(parserpython.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#arith_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith_expr(parserpython.Arith_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(parserpython.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(parserpython.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix(parserpython.PostfixContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(parserpython.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#gen_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGen_expr(parserpython.Gen_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#gen_for_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGen_for_expr(parserpython.Gen_for_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_list(parserpython.Arg_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(parserpython.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#tuple_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple_expr(parserpython.Tuple_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#list_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_expr(parserpython.List_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#dict_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDict_expr(parserpython.Dict_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserpython#dict_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDict_item(parserpython.Dict_itemContext ctx);
}