package w2d.antlr.gen;// Generated from /Users/ukupat/Development/University/AKT/Project/src/w2d/antlr/Grammar.g4 by ANTLR 4.x
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#CheckboxQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckboxQuestion(@NotNull GrammarParser.CheckboxQuestionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#customField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomField(@NotNull GrammarParser.CustomFieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#QuestionSentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionSentence(@NotNull GrammarParser.QuestionSentenceContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#SelectQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQuestion(@NotNull GrammarParser.SelectQuestionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(@NotNull GrammarParser.SentenceContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#sentences}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentences(@NotNull GrammarParser.SentencesContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#QuestionVariableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionVariableName(@NotNull GrammarParser.QuestionVariableNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(@NotNull GrammarParser.ScriptContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#ObjectFieldValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectFieldValue(@NotNull GrammarParser.ObjectFieldValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#LabelField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelField(@NotNull GrammarParser.LabelFieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#fields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFields(@NotNull GrammarParser.FieldsContext ctx);
}
