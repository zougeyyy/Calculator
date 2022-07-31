package com.example.mycalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final StringBuilder sb = new StringBuilder();
    private String expression = "";
    private String result = "";
    private boolean isHasDot = false;
    private final Stack<Boolean> dotStack = new Stack<>();

    private boolean isZero = false;
    private final Stack<Boolean> zeroStack = new Stack<>();
    private int leftNum = 0;
    private int rightNum = 0;
    private TextView textView;
    private TextView result_view;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_view);
        textView.setAutoSizeTextTypeUniformWithConfiguration(4, 70, 10, TypedValue.COMPLEX_UNIT_DIP);
        //将显示框设置为根据行数自动缩小
        result_view = (TextView) findViewById(R.id.result_view);
        result_view.setAutoSizeTextTypeUniformWithConfiguration(4, 70, 10, TypedValue.COMPLEX_UNIT_DIP);
        Button btn1 = (Button) findViewById(R.id.btn_1);
        btn1.setOnClickListener(this);
        Button btn2 = (Button) findViewById(R.id.btn_2);
        btn2.setOnClickListener(this);
        Button btn3 = (Button) findViewById(R.id.btn_3);
        btn3.setOnClickListener(this);
        Button btn4 = (Button) findViewById(R.id.btn_4);
        btn4.setOnClickListener(this);
        Button btn5 = (Button) findViewById(R.id.btn_5);
        btn5.setOnClickListener(this);
        Button btn6 = (Button) findViewById(R.id.btn_6);
        btn6.setOnClickListener(this);
        Button btn7 = (Button) findViewById(R.id.btn_7);
        btn7.setOnClickListener(this);
        Button btn8 = (Button) findViewById(R.id.btn_8);
        btn8.setOnClickListener(this);
        Button btn9 = (Button) findViewById(R.id.btn_9);
        btn9.setOnClickListener(this);
        Button btn0 = (Button) findViewById(R.id.btn_0);
        btn0.setOnClickListener(this);
        Button btndot = (Button) findViewById(R.id.btn_dot);
        btndot.setOnClickListener(this);
        Button btnadd = (Button) findViewById(R.id.btn_add);
        btnadd.setOnClickListener(this);
        Button btnminus = (Button) findViewById(R.id.btn_minus);
        btnminus.setOnClickListener(this);
        Button btnmult = (Button) findViewById(R.id.btn_mult);
        btnmult.setOnClickListener(this);
        Button btndivide = (Button) findViewById(R.id.btn_divide);
        btndivide.setOnClickListener(this);
        Button btnac = (Button) findViewById(R.id.btn_ac);
        btnac.setOnClickListener(this);
        Button btndel = (Button) findViewById(R.id.btn_del);
        btndel.setOnClickListener(this);
        Button btnleft = (Button) findViewById(R.id.btn_left);
        btnleft.setOnClickListener(this);
        Button btnright = (Button) findViewById(R.id.btn_right);
        btnright.setOnClickListener(this);
        Button btnresult = (Button) findViewById(R.id.btn_result);
        btnresult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        result_view.setText("");
        switch (v.getId()) {
            case R.id.btn_1:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('1');
                textView.setText(sb.toString());
                break;
            case R.id.btn_2:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('2');
                textView.setText(sb.toString());
                break;
            case R.id.btn_3:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('3');
                textView.setText(sb.toString());
                break;
            case R.id.btn_4:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('4');
                textView.setText(sb.toString());
                break;
            case R.id.btn_5:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('5');
                textView.setText(sb.toString());
                break;
            case R.id.btn_6:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('6');
                textView.setText(sb.toString());
                break;
            case R.id.btn_7:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('7');
                textView.setText(sb.toString());
                break;
            case R.id.btn_8:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('8');
                textView.setText(sb.toString());
                break;
            case R.id.btn_9:
                if (isZero == true) {
                    sb.deleteCharAt(sb.length() - 1);
                    isZero = false;
                }
                sb.append('9');
                textView.setText(sb.toString());
                break;
            case R.id.btn_0:
                if (isZero == false) {
                    sb.append('0');
                    if (sb.length() == 1 ||
                            !('0' <= sb.charAt(sb.length() - 2) && sb.charAt(sb.length() - 2) <= '9')
                                    && sb.charAt(sb.length() - 2) != '.') {
                        isZero = true;
                    }
                }
                textView.setText(sb.toString());
                break;
            case R.id.btn_dot:
                if (isHasDot == false) {
                    if (sb.length() == 0 ||
                            !('0' <= sb.charAt(sb.length() - 1) && sb.charAt(sb.length() - 1) <= '9')) {
                        sb.append("0.");
                    } else {
                        sb.append('.');
                    }
                    isHasDot = true;
                    isZero = false;
                }
                textView.setText(sb.toString());
                break;
            case R.id.btn_add:
                if (sb.length() != 0 &&
                        (sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-' || sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/')) {
                    sb.setCharAt(sb.length() - 1, '+');
                } else if (sb.length() != 0) {
                    sb.append('+');
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                if (result.matches("[-]?\\d+[.]?\\d*") && sb.length() == 0) {
                    sb.append(result + "+");
                    isHasDot = result.matches("[-]?\\d*[.]\\d*");
                    isZero = "0".equals(result);
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                textView.setText(sb.toString());
                break;
            case R.id.btn_minus:
                if (sb.length() != 0 &&
                        (sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-' || sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/')) {
                    sb.append('(');
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    leftNum++;
                }
                if (result.matches("[-]?\\d+[.]?\\d*") && sb.length() == 0) {
                    sb.append(result + "-");
                    isHasDot = result.matches("[-]?\\d*[.]\\d*");
                    isZero = "0".equals(result);
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                sb.append('-');
                zeroStack.push(isZero);
                dotStack.push(isHasDot);
                isZero = false;
                isHasDot = false;
                textView.setText(sb.toString());
                break;
            case R.id.btn_mult:
                if (sb.length() != 0 &&
                        (sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-' || sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/')) {
                    sb.setCharAt(sb.length() - 1, '*');
                } else if (sb.length() != 0) {
                    sb.append('*');
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                if (result.matches("[-]?\\d+[.]?\\d*") && sb.length() == 0) {
                    sb.append(result + "*");
                    isHasDot = result.matches("[-]?\\d*[.]\\d*");
                    isZero = "0".equals(result);
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                textView.setText(sb.toString());
                break;
            case R.id.btn_divide:
                if (sb.length() != 0 &&
                        (sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-' || sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/')) {
                    sb.setCharAt(sb.length() - 1, '/');
                } else if (sb.length() != 0) {
                    sb.append('/');
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                if (result.matches("[-]?\\d+[.]?\\d*") && sb.length() == 0) {
                    sb.append(result + "/");
                    isHasDot = result.matches("[-]?\\d*[.]\\d*");
                    isZero = "0".equals(result);
                    zeroStack.push(isZero);
                    dotStack.push(isHasDot);
                    isZero = false;
                    isHasDot = false;
                }
                textView.setText(sb.toString());
                break;
            case R.id.btn_left:
                sb.append('(');
                leftNum++;
                zeroStack.push(isZero);
                dotStack.push(isHasDot);
                isZero = false;
                isHasDot = false;
                textView.setText(sb.toString());
                break;
            case R.id.btn_right:
                sb.append(')');
                rightNum++;
                zeroStack.push(isZero);
                dotStack.push(isHasDot);
                isZero = false;
                isHasDot = false;
                textView.setText(sb.toString());
                break;
            case R.id.btn_del:
                if (sb.length() != 0) {
                    if (sb.charAt(sb.length() - 1) == '.') {
                        isHasDot = false;
                        if (sb.charAt(sb.length() - 2) == '0') {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                    }
                    if (sb.charAt(sb.length() - 1) == '(') {
                        leftNum--;
                    }
                    if (sb.charAt(sb.length() - 1) == ')') {
                        rightNum--;
                    }
                    if (sb.charAt(sb.length() - 1) == '0' && isZero == true) {
                        isZero = false;
                    }
                    if (!(sb.charAt(sb.length() - 1) == '.' || '0' <= sb.charAt(sb.length() - 1) && sb.charAt(sb.length() - 1) <= '9')) {
                        if (!dotStack.isEmpty()) {
                            isHasDot = dotStack.pop();
                        }
                        if (!zeroStack.isEmpty()) {
                            isZero = zeroStack.pop();
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }
                result_view.setText("");
                textView.setText(sb.toString());
                break;
            case R.id.btn_ac:
                if (sb.length() != 0) {
                    sb.delete(0, sb.length());
                }
                isHasDot = false;
                isZero = false;
                zeroStack.clear();
                dotStack.clear();
                expression = "";
                result = "";
                leftNum = 0;
                rightNum = 0;
                result_view.setText("");
                textView.setText("");
                break;
            case R.id.btn_result:
                if (sb.length() != 0) {
                    textView.setText(sb.toString());
                    isHasDot = false;
                    isZero = false;
                    zeroStack.clear();
                    dotStack.clear();
                    if (leftNum < rightNum) {
                        result = "出错";
                        sb.delete(0, sb.length());
                        result_view.setText(result);
                        leftNum = 0;
                        rightNum = 0;
                        break;
                    } else if (leftNum > rightNum) {
                        while (leftNum > rightNum) {
                            sb.append(')');
                            rightNum++;
                        }
                    }
                    if (sb.charAt(0) == '-') {
                        sb.insert(0, '0');
                    }
                    if (sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-') {
                        sb.append('0');
                    }
                    if (sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/') {
                        sb.append('1');
                    }
                    for (int i = 1; i < sb.length() - 1; i++) {
                        char ch = sb.charAt(i);
                        if (ch == '(' && (sb.charAt(i - 1) == '.' || '0' <= sb.charAt(i - 1) && sb.charAt(i - 1) <= '9')) {
                            sb.insert(i, '*');
                        }
                        if (ch == ')' && '0' <= sb.charAt(i + 1) && sb.charAt(i + 1) <= '9') {
                            sb.insert(i + 1, '*');
                        }
                    }
                    expression = sb.toString();
                    sb.delete(0, sb.length());
                    exchange(expression);
                    expression = "";
                    leftNum = 0;
                    rightNum = 0;
                }
                result_view.setText(result);
                break;
        }
    }

    public void exchange(String expression) {
        Queue<Object> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        int figureNum = 0;
        int operatorNum = 0;
        StringBuilder numSb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '.' || ('0' <= ch && ch <= '9')) {
                numSb.append(ch);
            } else {
                if (numSb.length() != 0) {
                    queue.offer(new BigDecimal(numSb.toString()));
                    figureNum++;
                    numSb.delete(0, numSb.length());
                }
                if (ch == '-' && expression.charAt(i - 1) == '(' &&
                        ('0' <= expression.charAt(i + 1) && expression.charAt(i + 1) <= '9')) {
                    numSb.append(ch);
                    continue;
                }
                if (ch == '(') {
                    stack.push(ch);
                } else if ((ch == '+' || ch == '-') && !stack.isEmpty() && stack.peek() == '(') {
                    stack.push(ch);
                } else if ((ch == '*' || ch == '/') && !stack.isEmpty() && !(stack.peek() == '*' || stack.peek() == '/')) {
                    stack.push(ch);
                } else {
                    while (!stack.empty() && stack.peek() != '(') {
                        queue.offer(stack.pop());
                        operatorNum++;
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    if (ch != ')') {
                        stack.push(ch);
                    }
                }
            }
        }
        if (numSb.length() != 0) {
            queue.offer(new BigDecimal(numSb.toString()));
            figureNum++;
        }
        while (!stack.empty()) {
            queue.offer(stack.pop());
            operatorNum++;
        }
        if (figureNum == operatorNum + 1) {
            calculate(queue);
        } else {
            result = "错误";
        }
    }

    public void calculate(Queue<Object> queue) {
        Stack<BigDecimal> stack = new Stack<>();
        while (!queue.isEmpty()) {
            Object obj = queue.poll();
            if (obj.getClass() == Character.class) {
                char operator = (Character) obj;
                BigDecimal num1 = (BigDecimal) stack.pop();
                BigDecimal num2 = (BigDecimal) stack.pop();
                BigDecimal subResult;
                if (operator == '+') {
                    subResult = num2.add(num1);
                    stack.push(subResult);
                } else if (operator == '-') {
                    subResult = num2.subtract(num1);
                    stack.push(subResult);
                } else if (operator == '*') {
                    subResult = num2.multiply(num1);
                    stack.push(subResult);
                } else {
                    if ("0".equals(num1.toString())) {
                        result = "错误";
                        return;
                    } else if ("0".equals(num2.toString())) {
                        stack.push(new BigDecimal("0"));
                    } else {
                        subResult = num2.divide(num1, 20, BigDecimal.ROUND_HALF_UP);
                        stack.push(subResult);
                    }
                }
            } else {
                stack.push((BigDecimal) obj);
            }
        }
        result = stack.pop().toString();
        if (result.matches("[-]?\\d*[.]\\d*")) {
            int i = result.length() - 1;
            while (result.charAt(i) == '0') {
                i--;
            }
            if (result.charAt(i) == '.') {
                i--;
            }
            result = result.substring(0, i + 1);
        }
    }
}

