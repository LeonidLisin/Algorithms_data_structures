package Lesson3_DZ.Flip;

import Lesson3_DZ.Stack.*;

public class StringFlip {

    public StringBuilder flip(String text){
        StringBuilder flipText = new StringBuilder();
        @SuppressWarnings("unchecked")
        Stack<String> stack = new DoStack(text.length());

        for (int i = 0; i < text.length(); i++)
            stack.push(text.substring(i, i + 1));

        int size = stack.getSize();

        for (int i = 0; i < size; i++)
            flipText.append(stack.pop());

        return flipText;
    }

}
