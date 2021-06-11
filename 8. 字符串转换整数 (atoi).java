class Solution {
    public int myAtoi(String s) {
        /*
        可以考虑自动机
                ''      +/-     num     other
        start   start   signed  in_num  end
        signed  end     end     in_num  end
        in_num  end     end     in_num  end
        end     end     end     end     end
        */
        Automaton automaton = new Automaton();
        for (int i = 0; i < s.length(); i++) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_num", "end"});
        put("signed", new String[]{"end", "end", "in_num", "end"});
        put("in_num", new String[]{"end", "end", "in_num", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_num".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, - (long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    public int get_col(char c) {
        if (c == ' ') return 0;
        else if (c == '+' || c == '-') return 1;
        else if (Character.isDigit(c)) return 2;
        else return 3;
    }
}