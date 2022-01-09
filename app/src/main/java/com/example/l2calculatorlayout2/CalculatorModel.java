package com.example.l2calculatorlayout2;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {
    private final List<InputSymbol> input = new ArrayList<>();

    private static boolean isOnlyMinus(List<InputSymbol> input) {
        return input.size() == 1 && input.get(0) == InputSymbol.OP_MINUS;
    }

    public void onClickButton(InputSymbol inputSymbol) {
        if (inputSymbol == InputSymbol.DELETE) {
            input.clear();
            return;
        }
        if (hasDot() && inputSymbol == InputSymbol.DOT) {
            return;
        }
        if ((input.isEmpty() || isOnlyMinus(input))
                && (inputSymbol == InputSymbol.DOT || inputSymbol == InputSymbol.NUM_0)) {
            input.add(InputSymbol.NUM_0);
            input.add(InputSymbol.DOT);
            return;
        }
        if (inputSymbol == InputSymbol.NUM_0
                || inputSymbol == InputSymbol.NUM_1
                || inputSymbol == InputSymbol.NUM_2
                || inputSymbol == InputSymbol.NUM_3
                || inputSymbol == InputSymbol.NUM_4
                || inputSymbol == InputSymbol.NUM_5
                || inputSymbol == InputSymbol.NUM_6
                || inputSymbol == InputSymbol.NUM_7
                || inputSymbol == InputSymbol.NUM_8
                || inputSymbol == InputSymbol.NUM_9
                || inputSymbol == InputSymbol.DOT
                || inputSymbol == InputSymbol.OP_LAST_ACTIVITY
                || inputSymbol == InputSymbol.OP_MINUS) {
            input.add(inputSymbol);
            return;

        }

        input.add(inputSymbol.UNDEFINED);
    }

    private boolean hasDot() {
        for (InputSymbol inputSymbol : input) {
            if (inputSymbol == InputSymbol.DOT) {
                return true;
            }

        }
        return false;
    }

    public List<InputSymbol> getInput() {
        return new ArrayList<>(input);
    }

}
