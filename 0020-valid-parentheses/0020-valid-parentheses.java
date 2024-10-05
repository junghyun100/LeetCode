class Solution {
public boolean isValid(String s) {
    Stack stack = new <Character> Stack();
    for (int i = 0; i < s.length(); i++) {
        if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
            stack.push(s.charAt(i));
        } else {
            if(stack.isEmpty()) {
                return false;
            }
            char str = (char) stack.pop();
            if(str == '(' && s.charAt(i) != ')') {
                return false;
            }
            else if(str == '[' && s.charAt(i) != ']') {
                return false;
            }
            else if(str == '{' && s.charAt(i) != '}') {
                return false;
            }
        }
        }
    if(!stack.isEmpty()) return false;
    return true;
    }
}