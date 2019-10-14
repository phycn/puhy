package cn.puhy.compile;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 * 词法分析器
 */
public class SimpleLexicalAnalyzer {
    public static void main(String[] args) throws IOException {
        // 要解析的语句
        String script = "int inta = 291";
        int length = script.length();
        CharArrayReader reader = new CharArrayReader(script.toCharArray());
        int iChar;
        int count = 0;
        FiniteAutomatonState state = FiniteAutomatonState.INIT;
        StringBuilder sb = new StringBuilder();
        while ((iChar = reader.read()) != -1) {
            count++;
            switch (state) {
                case INIT:
                    if (isLetter(iChar)) {
                        if ((char) iChar == 'i') {
                            state = FiniteAutomatonState.INT_I;
                        } else {
                            state = FiniteAutomatonState.IDENTIFIER;
                        }
                    } else if (isDigit(iChar)) {
                        state = FiniteAutomatonState.DIGIT;
                    } else if ((char) iChar == '=') {
                        state = FiniteAutomatonState.ERUAL;
                    }
                    sb.append((char) iChar);
                    break;
                case IDENTIFIER:
                    if (isLetter(iChar) || isDigit(iChar)) {
                        sb.append((char) iChar);
                    } else if (isBlank(iChar)) {
                        state = FiniteAutomatonState.INIT;
                        System.out.println("IDENTIFIER " + sb.toString());
                        sb.delete(0, sb.length());
                    }
                    break;
                case DIGIT:
                    if (isDigit(iChar)) {
                        sb.append((char) iChar);
                        if (count == length) {
                            System.out.println("DIGIT " + sb.toString());
                        }
                    } else if (isBlank(iChar)) {
                        state = FiniteAutomatonState.INIT;
                        System.out.println(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    break;
                case ERUAL:
                    if (isBlank(iChar)) {
                        state = FiniteAutomatonState.INIT;
                        System.out.println("ERUAL " + sb.toString());
                        sb.delete(0, sb.length());
                    }
                    break;
                case INT_I:
                    if ((char) iChar == 'n') {
                        state = FiniteAutomatonState.INT_N;
                    } else {
                        state = FiniteAutomatonState.IDENTIFIER;
                    }
                    sb.append((char) iChar);
                    break;
                case INT_N:
                    if ((char) iChar == 't') {
                        state = FiniteAutomatonState.INT_T;
                    } else {
                        state = FiniteAutomatonState.IDENTIFIER;
                    }
                    sb.append((char) iChar);
                    break;
                case INT_T:
                    if (isBlank(iChar)) {
                        state = FiniteAutomatonState.INIT;
                        System.out.println("INT " + sb.toString());
                        sb.delete(0, sb.length());
                    } else {
                        state = FiniteAutomatonState.IDENTIFIER;
                        sb.append((char) iChar);
                    }
                    break;
            }
        }
//        System.out.println(sb.toString());
    }

    /**
     * 是否为字母
     *
     * @param letter 字母
     * @return
     */
    private static boolean isLetter(int letter) {
        return letter >= 'a' && letter <= 'z' || letter >= 'A' && letter <= 'Z';
    }

    /**
     * 是否为数字
     *
     * @param ch
     * @return
     */
    private static boolean isDigit(int ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 是否是空白
     *
     * @param ch
     * @return
     */
    private static boolean isBlank(int ch) {
        return ch == ' ' || ch == '\t' || ch == '\n';
    }
}

/**
 * 有限自动机状态
 */
enum FiniteAutomatonState {
    INIT,           // 初始状态
    IDENTIFIER,     // 标识符
    DIGIT,          // 数字
    ERUAL,          // 等于符号
    INT_I,
    INT_N,
    INT_T
}
