class Solution {
    public String simplifyPath(String path) {
        String [] parts = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for(String p : parts) {
            if(p.equals(".") || p.isEmpty()) {
                continue;
            } else if(p.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        } 
        StringBuilder result = new StringBuilder();
        for(String p : stack){
            result.append('/').append(p);
        }
        return result.length() > 0 ? result.toString() : "/";
    }
}