package w2d.antlr.gen;// Generated from /Users/ukupat/Development/University/AKT/Project/src/w2d/antlr/Grammar.g4 by ANTLR 4.x
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#CheckboxQuestion}.
	 * @param ctx the parse tree
	 */
	void enterCheckboxQuestion(@NotNull GrammarParser.CheckboxQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#CheckboxQuestion}.
	 * @param ctx the parse tree
	 */
	void exitCheckboxQuestion(@NotNull GrammarParser.CheckboxQuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#customField}.
	 * @param ctx the parse tree
	 */
	void enterCustomField(@NotNull GrammarParser.CustomFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#customField}.
	 * @param ctx the parse tree
	 */
	void exitCustomField(@NotNull GrammarParser.CustomFieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#QuestionSentence}.
	 * @param ctx the parse tree
	 */
	void enterQuestionSentence(@NotNull GrammarParser.QuestionSentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#QuestionSentence}.
	 * @param ctx the parse tree
	 */
	void exitQuestionSentence(@NotNull GrammarParser.QuestionSentenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#SelectQuestion}.
	 * @param ctx the parse tree
	 */
	void enterSelectQuestion(@NotNull GrammarParser.SelectQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#SelectQuestion}.
	 * @param ctx the parse tree
	 */
	void exitSelectQuestion(@NotNull GrammarParser.SelectQuestionContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(@NotNull GrammarParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(@NotNull GrammarParser.SentenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#sentences}.
	 * @param ctx the parse tree
	 */
	void enterSentences(@NotNull GrammarParser.SentencesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#sentences}.
	 * @param ctx the parse tree
	 */
	void exitSentences(@NotNull GrammarParser.SentencesContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#QuestionVariableName}.
	 * @param ctx the parse tree
	 */
	void enterQuestionVariableName(@NotNull GrammarParser.QuestionVariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#QuestionVariableName}.
	 * @param ctx the parse tree
	 */
	void exitQuestionVariableName(@NotNull GrammarParser.QuestionVariableNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(@NotNull GrammarParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(@NotNull GrammarParser.ScriptContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#ObjectFieldValue}.
	 * @param ctx the parse tree
	 */
	void enterObjectFieldValue(@NotNull GrammarParser.ObjectFieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ObjectFieldValue}.
	 * @param ctx the parse tree
	 */
	void exitObjectFieldValue(@NotNull GrammarParser.ObjectFieldValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#LabelField}.
	 * @param ctx the parse tree
	 */
	void enterLabelField(@NotNull GrammarParser.LabelFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#LabelField}.
	 * @param ctx the parse tree
	 */
	void exitLabelField(@NotNull GrammarParser.LabelFieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#fields}.
	 * @param ctx the parse tree
	 */
	void enterFields(@NotNull GrammarParser.FieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#fields}.
	 * @param ctx the parse tree
	 */
	void exitFields(@NotNull GrammarParser.FieldsContext ctx);
}
