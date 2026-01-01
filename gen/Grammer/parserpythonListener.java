// Generated from C:/Users/Abdullah/Desktop/complier/src/Grammer/parserpython.g4 by ANTLR 4.13.2
package Grammer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link parserpython}.
 */
public interface parserpythonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link parserpython#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(parserpython.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(parserpython.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(parserpython.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(parserpython.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImport_stmt(parserpython.Import_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImport_stmt(parserpython.Import_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#import_items}.
	 * @param ctx the parse tree
	 */
	void enterImport_items(parserpython.Import_itemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#import_items}.
	 * @param ctx the parse tree
	 */
	void exitImport_items(parserpython.Import_itemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(parserpython.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(parserpython.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(parserpython.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(parserpython.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#param_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_list(parserpython.Param_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#param_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_list(parserpython.Param_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(parserpython.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(parserpython.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(parserpython.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(parserpython.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(parserpython.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(parserpython.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(parserpython.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(parserpython.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(parserpython.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(parserpython.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(parserpython.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(parserpython.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(parserpython.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(parserpython.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#conditional_expr}.
	 * @param ctx the parse tree
	 */
	void enterConditional_expr(parserpython.Conditional_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#conditional_expr}.
	 * @param ctx the parse tree
	 */
	void exitConditional_expr(parserpython.Conditional_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#logic_or}.
	 * @param ctx the parse tree
	 */
	void enterLogic_or(parserpython.Logic_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#logic_or}.
	 * @param ctx the parse tree
	 */
	void exitLogic_or(parserpython.Logic_orContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#logic_and}.
	 * @param ctx the parse tree
	 */
	void enterLogic_and(parserpython.Logic_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#logic_and}.
	 * @param ctx the parse tree
	 */
	void exitLogic_and(parserpython.Logic_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(parserpython.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(parserpython.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#arith_expr}.
	 * @param ctx the parse tree
	 */
	void enterArith_expr(parserpython.Arith_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#arith_expr}.
	 * @param ctx the parse tree
	 */
	void exitArith_expr(parserpython.Arith_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(parserpython.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(parserpython.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(parserpython.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(parserpython.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfix(parserpython.PostfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfix(parserpython.PostfixContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(parserpython.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(parserpython.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#gen_expr}.
	 * @param ctx the parse tree
	 */
	void enterGen_expr(parserpython.Gen_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#gen_expr}.
	 * @param ctx the parse tree
	 */
	void exitGen_expr(parserpython.Gen_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#gen_for_expr}.
	 * @param ctx the parse tree
	 */
	void enterGen_for_expr(parserpython.Gen_for_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#gen_for_expr}.
	 * @param ctx the parse tree
	 */
	void exitGen_for_expr(parserpython.Gen_for_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArg_list(parserpython.Arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArg_list(parserpython.Arg_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(parserpython.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(parserpython.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#tuple_expr}.
	 * @param ctx the parse tree
	 */
	void enterTuple_expr(parserpython.Tuple_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#tuple_expr}.
	 * @param ctx the parse tree
	 */
	void exitTuple_expr(parserpython.Tuple_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#list_expr}.
	 * @param ctx the parse tree
	 */
	void enterList_expr(parserpython.List_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#list_expr}.
	 * @param ctx the parse tree
	 */
	void exitList_expr(parserpython.List_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#dict_expr}.
	 * @param ctx the parse tree
	 */
	void enterDict_expr(parserpython.Dict_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#dict_expr}.
	 * @param ctx the parse tree
	 */
	void exitDict_expr(parserpython.Dict_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserpython#dict_item}.
	 * @param ctx the parse tree
	 */
	void enterDict_item(parserpython.Dict_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserpython#dict_item}.
	 * @param ctx the parse tree
	 */
	void exitDict_item(parserpython.Dict_itemContext ctx);
}