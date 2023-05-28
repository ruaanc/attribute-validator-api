/* Generated By:JavaCC: Do not edit this line. ValidationDSL.java */
package dsl.parser;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import dsl.*;
public class ValidationDSL implements ValidationDSLConstants {
    public static void main(String[] args) {
        ValidationDSL parser;
        if(args.length == 0) {
            System.out.println("Attribute Validator: Reading . . .");
            parser = new Exp1Parser(System.in);
        } else if(args.length == 1) {
            System.out.println("Attribute Validator: Reading " + args [0] + " . . .");
            try {
                parser = new ValidationDSL(new FileInputStream(args[0]));
            } catch (FileNotFoundException e) {
                System.out.println("Attribute Validator:  File " + args[0] + " not found.");
                return;
            }
        } else {
            System.out.println("Attribute Validator:  Usage is one of:");
            System.out.println("         java ValidationDSL < inputfile");
            System.out.println("OR");
            System.out.println("         java ValidationDSL inputfile");
            return;
        }

        try {
            Program program = parser.Input();
        } catch (ParseException e) {
            System.out.println("Attribute Validator: Encountered errors during parse.");
        }
    }

  static final public dsl.Program Input() throws ParseException {
 dsl.Program response;
    response = PProgram();
    jj_consume_token(0);
      {if (true) return response;}
    throw new Error("Missing return statement in function");
  }

  static final public Program PProgram() throws ParseException {
  Expression response;
    response = PExpression();
    {if (true) return new Program(response);}
    throw new Error("Missing return statement in function");
  }

  static final public Expression PExpression() throws ParseException {
  Expression response;
    response = PUnaryExp();
    {if (true) return response;}
    throw new Error("Missing return statement in function");
  }

  static final public Expression PUnaryExp() throws ParseException {
  Expression response;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CEP:
      response = PZipCodeExp();
      break;
    case CNPJ:
      response = PCnpjExp();
      break;
    case CPF:
      response = PCpfExp();
      break;
    case NAME:
      response = PNameExp();
      break;
    case EMAIL:
      response = PEmailExp();
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return response;}
    throw new Error("Missing return statement in function");
  }

  static final public Expression PZipCodeExp() throws ParseException {
  Expression response;
    jj_consume_token(CEP);
    response = PPrimaryExp();
    {if (true) return new ZipCodeExpression(response);}
    throw new Error("Missing return statement in function");
  }

  static final public Expression PPrimaryExp() throws ParseException {
  Expression response;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING_LITERAL:
      response = PValue();
      break;
    case CEP:
    case CPF:
    case CNPJ:
    case NAME:
    case EMAIL:
      response = PExpression();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return response;}
    throw new Error("Missing return statement in function");
  }

  static final public Value PValue() throws ParseException {
  Value response;
    response = PStringValue();
    {if (true) return response;}
    throw new Error("Missing return statement in function");
  }

  static final public Value PStringValue() throws ParseException {
  Token token;
    token = jj_consume_token(STRING_LITERAL);
  String tokenStr = token.toString();
  tokenStr = tokenStr.substring(1, tokenStr.length() - 1);
  {if (true) return new StringValue(tokenStr);}
    throw new Error("Missing return statement in function");
  }

  static final public Expression PCnpjExp() throws ParseException {
  Expression response;
    jj_consume_token(CNPJ);
    response = PPrimaryExp();
 {if (true) return new CnpjExpression(response);}
    throw new Error("Missing return statement in function");
  }

  static final public Expression PCpfExp() throws ParseException {
  Expression response;
    jj_consume_token(CPF);
    response = PPrimaryExp();
 {if (true) return new CpfExpression(response);}
    throw new Error("Missing return statement in function");
  }

  static final public Expression PNameExp() throws ParseException {
  Expression response;
    jj_consume_token(NAME);
    response = PPrimaryExp();
 {if (true) return new NameExpression(response);}
    throw new Error("Missing return statement in function");
  }

  static final public Expression PEmailExp() throws ParseException {
  Expression response;
    jj_consume_token(EMAIL);
    response = PPrimaryExp();
 {if (true) return new EmailExpression(response);}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ValidationDSLTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[2];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x3e,0x7e,};
   }

  /** Constructor with InputStream. */
  public ValidationDSL(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ValidationDSL(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ValidationDSLTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ValidationDSL(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ValidationDSLTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ValidationDSL(ValidationDSLTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ValidationDSLTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[7];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 2; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 7; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

 }
