/* Generated By:JavaCC: Do not edit this line. MyLanguageParser.java */
public class MyLanguageParser implements MyLanguageParserConstants {
  public static void main(String[] args)  {
    MyLanguageParser parser = new MyLanguageParser(System.in);
    try{
        parser.Program();
        System.out.println("Parsing completed successfully.");
    }
    catch(ParseException e){
        System.out.println("Error");
        e.printStackTrace();
    }

  }

/*TOKEN :
{
    < IDENTIFIER: (["a"-"z","A"-"Z","_"])(["a"-"z","A"-"Z","0"-"9","_"])* >
  | < INTEGER_LITERAL: (["0"-"9"])+ >
  | < FLOAT_LITERAL: (["0"-"9"])+ "."(["0"-"9"])+ >
  | < STRING_LITERAL: "\"" (~["\"","\\"] | "\\\\" | "\\\"")* "\"" >
}*/
  final public void Program() throws ParseException {
    AlgorithmName();
    VariableFunctionDeclarations();
    MainBlock();
  }

  final public void AlgorithmName() throws ParseException {
    jj_consume_token(ALGORITHM_NAME);
    jj_consume_token(ID);
  }

  final public void VariableFunctionDeclarations() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DECLARATION:
      DeclarationBlock();
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
  }

  final public void DeclarationBlock() throws ParseException {
    jj_consume_token(DECLARATION);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER:
      case FLOAT:
      case STRING:
      case VOID:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      Declaration();
    }
  }

  final public void Declaration() throws ParseException {
    Type();
    VarFuncDeclarationTail();
  }

  final public void VarFuncDeclarationTail() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      VariableDeclaration();
      break;
    case FUNCTION:
      FunctionDeclaration();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void VariableDeclaration() throws ParseException {
    Variables();
    jj_consume_token(SEMICOLON);
  }

  final public void Type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
      jj_consume_token(INTEGER);
      break;
    case FLOAT:
      jj_consume_token(FLOAT);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    case VOID:
      jj_consume_token(VOID);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Variables() throws ParseException {
    Variable();
    label_2:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_2;
      }
      VariableTail();
    }
  }

  final public void VariableTail() throws ParseException {
    jj_consume_token(COMMA);
    Variable();
    if (jj_2_2(2)) {
      VariableTail();
    } else {
      ;
    }
  }

  final public void Variable() throws ParseException {
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQUALS:
      Variable2();
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
  }

  final public void Variable2() throws ParseException {
    jj_consume_token(EQUALS);
    Expression();
  }

  final public void FunctionDeclaration() throws ParseException {
    jj_consume_token(FUNCTION);
    jj_consume_token(ID);
    jj_consume_token(LPAREN);
    Parameters();
    jj_consume_token(RPAREN);
    Block();
  }

  final public void Parameters() throws ParseException {
    Parameter();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      ParametersTail();
    }
  }

  final public void ParametersTail() throws ParseException {
    jj_consume_token(COMMA);
    Parameter();
    if (jj_2_3(2)) {
      ParametersTail();
    } else {
      ;
    }
  }

  final public void Parameter() throws ParseException {
    Type();
    Variables();
  }

  final public void MainBlock() throws ParseException {
    jj_consume_token(START);
    Block();
    jj_consume_token(END);
  }

  final public void Block() throws ParseException {
    jj_consume_token(LBRACE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IF:
    case WHILE:
    case SHOW:
    case RETURN:
    case BREAK:
    case HASH:
    case ID:
      Content();
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    jj_consume_token(RBRACE);
  }

  final public void Content() throws ParseException {
    Statements();
  }

  final public void Statements() throws ParseException {
    Statement();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case SHOW:
      case RETURN:
      case BREAK:
      case HASH:
      case ID:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_4;
      }
      StatementsTail();
    }
  }

  final public void StatementsTail() throws ParseException {
    Statement();
    if (jj_2_4(2)) {
      StatementsTail();
    } else {
      ;
    }
  }

  final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IF:
      IfStatement();
      break;
    case WHILE:
      WhileStatement();
      break;
    case ID:
      AssignmentStatement();
      break;
    case SHOW:
      PrintStatement();
      break;
    case HASH:
      CommentStatement();
      break;
    case BREAK:
      BreakStatement();
      break;
    case RETURN:
      ReturnStatement();
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void IfStatement() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(LPAREN);
    BoolExpression();
    jj_consume_token(RPAREN);
    Block();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ELSE_IF:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_5;
      }
      ElseIfStatement();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      ElseStatement();
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
  }

  final public void ElseIfStatement() throws ParseException {
    jj_consume_token(ELSE_IF);
    jj_consume_token(LPAREN);
    BoolExpression();
    jj_consume_token(RPAREN);
    Block();
  }

  final public void ElseStatement() throws ParseException {
    jj_consume_token(ELSE);
    Block();
  }

  final public void WhileStatement() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(LPAREN);
    BoolExpression();
    jj_consume_token(RPAREN);
    Block();
  }

  final public void AssignmentStatement() throws ParseException {
    jj_consume_token(ID);
    jj_consume_token(EQUALS);
    AssignmentStatementTail();
  }

  final public void AssignmentStatementTail() throws ParseException {
    if (jj_2_5(3)) {
      VariableAssignment();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUNCTION:
        FunctionCallAssignment();
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void VariableAssignment() throws ParseException {
    ArithmeticExpression();
    jj_consume_token(SEMICOLON);
  }

  final public void FunctionCallAssignment() throws ParseException {
    FunctionCall();
    jj_consume_token(SEMICOLON);
  }

  final public void FunctionCall() throws ParseException {
    jj_consume_token(FUNCTION);
    jj_consume_token(ID);
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
    case FLOAT:
    case STRING:
    case VOID:
      Parameters();
      break;
    default:
      jj_la1[12] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
  }

  final public void CommentStatement() throws ParseException {
    jj_consume_token(HASH);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER_LITERAL:
      jj_consume_token(NUMBER_LITERAL);
      break;
    case STRING_LITERAL:
      jj_consume_token(STRING_LITERAL);
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(HASH);
  }

  final public void ReturnStatement() throws ParseException {
    jj_consume_token(RETURN);
    ArithmeticExpression();
    jj_consume_token(SEMICOLON);
  }

  final public void BreakStatement() throws ParseException {
    jj_consume_token(BREAK);
    jj_consume_token(SEMICOLON);
  }

  final public void PrintStatement() throws ParseException {
    jj_consume_token(SHOW);
    jj_consume_token(LPAREN);
    PrintArguments();
    jj_consume_token(RPAREN);
    jj_consume_token(SEMICOLON);
  }

  final public void PrintArguments() throws ParseException {
    PrintArgument();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_6;
      }
      PrintArgumentsTail();
    }
  }

  final public void PrintArgumentsTail() throws ParseException {
    jj_consume_token(PLUS);
    PrintArgument();
    if (jj_2_6(3)) {
      PrintArgumentsTail();
    } else {
      ;
    }
  }

  final public void PrintArgument() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING_LITERAL:
      jj_consume_token(STRING_LITERAL);
      break;
    case ID:
      jj_consume_token(ID);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/* Implementation of expressions */
  final public void Expression() throws ParseException {
    if (jj_2_7(3)) {
      BoolExpression();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUNCTION:
      case LPAREN:
      case ID:
      case NUMBER_LITERAL:
        ArithmeticExpression();
        break;
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void BoolExpression() throws ParseException {
    BTerm();
    BoolExpressionTail();
  }

  final public void BoolExpressionTail() throws ParseException {
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_7;
      }
      jj_consume_token(OR);
      BTerm();
    }
  }

  final public void BTerm() throws ParseException {
    BFactor();
    BTermTail();
  }

  final public void BTermTail() throws ParseException {
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_8;
      }
      jj_consume_token(AND);
      BFactor();
    }
  }

  final public void BFactor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      jj_consume_token(NOT);
      BoolValue();
      break;
    case FUNCTION:
    case TRUE:
    case FALSE:
    case LPAREN:
    case ID:
    case NUMBER_LITERAL:
      BoolValue();
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void BoolValue() throws ParseException {
    if (jj_2_8(2147483647)) {
      CompareExpression();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TRUE:
        jj_consume_token(TRUE);
        break;
      case FALSE:
        jj_consume_token(FALSE);
        break;
      default:
        jj_la1[20] = jj_gen;
        if (jj_2_9(3)) {
          jj_consume_token(LPAREN);
          BoolExpression();
          jj_consume_token(RPAREN);
        } else if (jj_2_10(3)) {
          jj_consume_token(ID);
        } else if (jj_2_11(3)) {
          FunctionCall();
        } else {
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  final public void CompareExpression() throws ParseException {
    ArithmeticExpression();
    CompareOperator();
    ArithmeticExpression();
  }

  final public void CompareOperator() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LESS:
      jj_consume_token(LESS);
      break;
    case GREATER:
      jj_consume_token(GREATER);
      break;
    case LESSEQUAL:
      jj_consume_token(LESSEQUAL);
      break;
    case GREATEREQUAL:
      jj_consume_token(GREATEREQUAL);
      break;
    case EQUAL:
      jj_consume_token(EQUAL);
      break;
    case NOTEQUAL:
      jj_consume_token(NOTEQUAL);
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// Add more parser methods here following your grammar's structure
  final public void ArithmeticExpression() throws ParseException {
    ATerm();
    ArithmeticExpressionTail();
  }

  final public void ArithmeticExpressionTail() throws ParseException {
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_9;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        ATerm();
        break;
      case MINUS:
        jj_consume_token(MINUS);
        ATerm();
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void ATerm() throws ParseException {
    AFactor();
    ATermTail();
  }

  final public void ATermTail() throws ParseException {
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULT:
      case DIV:
        ;
        break;
      default:
        jj_la1[24] = jj_gen;
        break label_10;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULT:
        jj_consume_token(MULT);
        AFactor();
        break;
      case DIV:
        jj_consume_token(DIV);
        AFactor();
        break;
      default:
        jj_la1[25] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void AFactor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER_LITERAL:
      jj_consume_token(NUMBER_LITERAL);
      break;
    case ID:
      jj_consume_token(ID);
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      ArithmeticExpression();
      jj_consume_token(RPAREN);
      break;
    case FUNCTION:
      FunctionCall();
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  private boolean jj_2_10(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  private boolean jj_2_11(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_11(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(10, xla); }
  }

  private boolean jj_3_2() {
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3R_63() {
    if (jj_3R_20()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_64()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_22() {
    if (jj_3R_35()) return true;
    if (jj_3R_36()) return true;
    return false;
  }

  private boolean jj_3R_51() {
    if (jj_3R_58()) return true;
    return false;
  }

  private boolean jj_3R_66() {
    if (jj_3R_67()) return true;
    return false;
  }

  private boolean jj_3R_67() {
    if (jj_scan_token(EQUALS)) return true;
    if (jj_3R_68()) return true;
    return false;
  }

  private boolean jj_3R_26() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(39)) {
    jj_scanpos = xsp;
    if (jj_scan_token(40)) {
    jj_scanpos = xsp;
    if (jj_scan_token(41)) {
    jj_scanpos = xsp;
    if (jj_scan_token(42)) {
    jj_scanpos = xsp;
    if (jj_scan_token(43)) {
    jj_scanpos = xsp;
    if (jj_scan_token(44)) return true;
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3R_19() {
    if (jj_scan_token(ID)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_66()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3_8() {
    if (jj_3R_17()) return true;
    return false;
  }

  private boolean jj_3R_17() {
    if (jj_3R_22()) return true;
    if (jj_3R_26()) return true;
    if (jj_3R_22()) return true;
    return false;
  }

  private boolean jj_3R_11() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_19()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_2()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_69() {
    if (jj_3R_22()) return true;
    return false;
  }

  private boolean jj_3R_34() {
    if (jj_3R_46()) return true;
    return false;
  }

  private boolean jj_3R_58() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_61()) {
    jj_scanpos = xsp;
    if (jj_scan_token(21)) {
    jj_scanpos = xsp;
    if (jj_scan_token(22)) {
    jj_scanpos = xsp;
    if (jj_3_9()) {
    jj_scanpos = xsp;
    if (jj_3_10()) {
    jj_scanpos = xsp;
    if (jj_3_11()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_61() {
    if (jj_3R_17()) return true;
    return false;
  }

  private boolean jj_3R_65() {
    if (jj_3R_19()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_1()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_37() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_50()) {
    jj_scanpos = xsp;
    if (jj_3R_51()) return true;
    }
    return false;
  }

  private boolean jj_3R_50() {
    if (jj_scan_token(NOT)) return true;
    if (jj_3R_58()) return true;
    return false;
  }

  private boolean jj_3R_27() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(7)) {
    jj_scanpos = xsp;
    if (jj_scan_token(8)) {
    jj_scanpos = xsp;
    if (jj_scan_token(9)) {
    jj_scanpos = xsp;
    if (jj_scan_token(10)) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_52() {
    if (jj_scan_token(AND)) return true;
    if (jj_3R_37()) return true;
    return false;
  }

  private boolean jj_3R_38() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_52()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_24() {
    if (jj_3R_37()) return true;
    if (jj_3R_38()) return true;
    return false;
  }

  private boolean jj_3_6() {
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3R_39() {
    if (jj_scan_token(OR)) return true;
    if (jj_3R_24()) return true;
    return false;
  }

  private boolean jj_3R_33() {
    if (jj_3R_45()) return true;
    return false;
  }

  private boolean jj_3R_25() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_39()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_16() {
    if (jj_3R_24()) return true;
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_68() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_7()) {
    jj_scanpos = xsp;
    if (jj_3R_69()) return true;
    }
    return false;
  }

  private boolean jj_3_7() {
    if (jj_3R_16()) return true;
    return false;
  }

  private boolean jj_3R_23() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(49)) {
    jj_scanpos = xsp;
    if (jj_scan_token(48)) return true;
    }
    return false;
  }

  private boolean jj_3R_32() {
    if (jj_3R_44()) return true;
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_scan_token(PLUS)) return true;
    if (jj_3R_23()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_6()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_62() {
    if (jj_3R_63()) return true;
    return false;
  }

  private boolean jj_3R_43() {
    if (jj_scan_token(SHOW)) return true;
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3_11() {
    if (jj_3R_18()) return true;
    return false;
  }

  private boolean jj_3R_45() {
    if (jj_scan_token(BREAK)) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_31() {
    if (jj_3R_43()) return true;
    return false;
  }

  private boolean jj_3R_46() {
    if (jj_scan_token(RETURN)) return true;
    if (jj_3R_22()) return true;
    return false;
  }

  private boolean jj_3R_44() {
    if (jj_scan_token(HASH)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(52)) {
    jj_scanpos = xsp;
    if (jj_scan_token(49)) return true;
    }
    return false;
  }

  private boolean jj_3_10() {
    if (jj_scan_token(ID)) return true;
    return false;
  }

  private boolean jj_3R_18() {
    if (jj_scan_token(FUNCTION)) return true;
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_62()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_14() {
    if (jj_3R_22()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_54() {
    if (jj_3R_18()) return true;
    return false;
  }

  private boolean jj_3R_30() {
    if (jj_3R_42()) return true;
    return false;
  }

  private boolean jj_3_5() {
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_42() {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(EQUALS)) return true;
    return false;
  }

  private boolean jj_3R_41() {
    if (jj_scan_token(WHILE)) return true;
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3R_29() {
    if (jj_3R_41()) return true;
    return false;
  }

  private boolean jj_3_4() {
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_40() {
    if (jj_scan_token(IF)) return true;
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3R_28() {
    if (jj_3R_40()) return true;
    return false;
  }

  private boolean jj_3R_21() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_28()) {
    jj_scanpos = xsp;
    if (jj_3R_29()) {
    jj_scanpos = xsp;
    if (jj_3R_30()) {
    jj_scanpos = xsp;
    if (jj_3R_31()) {
    jj_scanpos = xsp;
    if (jj_3R_32()) {
    jj_scanpos = xsp;
    if (jj_3R_33()) {
    jj_scanpos = xsp;
    if (jj_3R_34()) return true;
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3_9() {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_16()) return true;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_53() {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_22()) return true;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_13() {
    if (jj_3R_21()) return true;
    return false;
  }

  private boolean jj_3R_60() {
    if (jj_scan_token(DIV)) return true;
    if (jj_3R_47()) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_57() {
    if (jj_scan_token(MINUS)) return true;
    if (jj_3R_35()) return true;
    return false;
  }

  private boolean jj_3R_47() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(52)) {
    jj_scanpos = xsp;
    if (jj_scan_token(48)) {
    jj_scanpos = xsp;
    if (jj_3R_53()) {
    jj_scanpos = xsp;
    if (jj_3R_54()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_55() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_59()) {
    jj_scanpos = xsp;
    if (jj_3R_60()) return true;
    }
    return false;
  }

  private boolean jj_3R_59() {
    if (jj_scan_token(MULT)) return true;
    if (jj_3R_47()) return true;
    return false;
  }

  private boolean jj_3R_64() {
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_20() {
    if (jj_3R_27()) return true;
    if (jj_3R_65()) return true;
    return false;
  }

  private boolean jj_3R_48() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_55()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_35() {
    if (jj_3R_47()) return true;
    if (jj_3R_48()) return true;
    return false;
  }

  private boolean jj_3R_12() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_20()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_3()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_49() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_56()) {
    jj_scanpos = xsp;
    if (jj_3R_57()) return true;
    }
    return false;
  }

  private boolean jj_3R_56() {
    if (jj_scan_token(PLUS)) return true;
    if (jj_3R_35()) return true;
    return false;
  }

  private boolean jj_3R_36() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_49()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  /** Generated Token Manager. */
  public MyLanguageParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  /** Whether we are looking ahead. */
  private boolean jj_lookingAhead = false;
  private boolean jj_semLA;
  private int jj_gen;
  final private int[] jj_la1 = new int[27];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x40,0x780,0x800,0x780,0x10000000,0x8000000,0x1e4000,0x1e4000,0x1e4000,0x8000,0x10000,0x800,0x780,0x0,0x0,0x0,0x20000800,0x1000000,0x800000,0x22600800,0x600000,0x0,0x0,0x0,0x0,0x0,0x20000800,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x10000,0x0,0x0,0x0,0x10040,0x10040,0x10040,0x0,0x0,0x0,0x0,0x120000,0x2,0x30000,0x110000,0x0,0x0,0x110000,0x0,0x1f80,0x6,0x6,0x18,0x18,0x110000,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[11];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public MyLanguageParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MyLanguageParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MyLanguageParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public MyLanguageParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MyLanguageParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public MyLanguageParser(MyLanguageParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(MyLanguageParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = jj_lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List jj_expentries = new java.util.ArrayList();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[53];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 27; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 53; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 11; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
            case 10: jj_3_11(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
