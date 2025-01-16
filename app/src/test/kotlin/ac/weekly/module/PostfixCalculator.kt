package ac.weekly.module

import ac.weekly.model.BasicOperator

/**
 * @author Theo
 * @since 2025/01/17
 */
class PostfixCalculator {
    fun calculate(expression: String) {
        val stack = ArrayDeque<Long>()
        expression.forEach { char ->
            when {
                // 피연산자인 경우
                char.isDigit() -> stack.addLast(char.toString().toLong())
                // BasicOperator 인 경우
                char.isBasicOperator() -> {
                    val right = stack.removeLast()
                    val left = stack.removeLast()

                    // TODO 이걸 BasicOperator 기반으로 된 Operation 으로 변경하면 좋을 것.
                    val result =
                        when (char) {
                            '+' -> left + right
                            '-' -> left - right
                            '*' -> left * right
                            '/' -> left / right
                            else -> throw IllegalArgumentException("Unknown operator: $char")
                        }
                    stack.addLast(result)
                }
                else -> throw IllegalArgumentException("Unknown character: $char")
            }
        }
        println(stack.last())
    }

    private fun Char.isBasicOperator(): Boolean =
        BasicOperator::class
            .sealedSubclasses
            .map { it.objectInstance as BasicOperator }
            .any { it.symbol == this }
}

fun main() {
    val calculator = PostfixCalculator()
    calculator.calculate("23+7*")
}
