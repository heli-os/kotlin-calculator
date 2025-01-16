package ac.weekly.module

import ac.weekly.model.BasicOperator
import ac.weekly.model.Operation

/**
 * @author Theo
 * @since 2025/01/17
 */
class PostfixCalculator {
    fun calculate(expression: String): Long {
        val stack = ArrayDeque<Long>()
        expression.forEach { char ->
            when {
                // 피연산자인 경우
                char.isDigit() -> stack.addLast(char.toString().toLong())
                // BasicOperator 인 경우
                BasicOperator.isOperator(char) -> {
                    val operator = BasicOperator.from(char)
                    val right = stack.removeLast()
                    val left = stack.removeLast()

                    val operation = Operation.from(operator)
                    val result = operation.execute(left, right)
                    stack.addLast(result)
                }
                else -> throw IllegalArgumentException("Unknown character: $char")
            }
        }
        return stack.last()
    }
}
