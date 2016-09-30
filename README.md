# CountWaysOfExp
Given a bit manipulation expression, count ways of get true or false

Given a boolean expression consisting of the symbols 0,1, &, |, and ^, and a desired boolean result value result,implement afunction to count the number of ways of parenthesizing the expressionsuch that it evaluatesto result.
EXAMPLE
Expression:1^0|0|1
Desiredresult:false (0)
Output: 2ways. 1^((0|0) |1) and 1^(0|(0|1))

Recursion: the relationship between the problem and its subproblem

f(exp, result, s,e), i=1,3,5, char op=exp.charAt(i) check op == '&' '^' '|'

(s,i-1) and (i+1,e)


