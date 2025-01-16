package ac.weekly.module

import ac.weekly.operation.BasicOperator

/**
 * @author Theo
 * @since 2025/01/17
 */
class InfixToPostfixConverter {
    /**
     * expression: 1+2
     * expression: 1      + 4
     * expression: 1 - 5    + 2      * 2
     * expression: 1 - 5 + 2 * 2
     */
    fun convert(expression: String): String {
        val stack = ArrayDeque<BasicOperator>() // -
        val result = StringBuilder() // 15

        val trimExpression = trim(expression)
        trimExpression.forEach { char ->
            when {
                char.isDigit() -> result.append(char)
                BasicOperator.isOperator(char) -> {
                    // 1. 현재 연산자를 BasicOperator 타입으로 변환
                    val operator = BasicOperator.from(char) // +

                    // TODO 2. 연산자간 우선순위 비교 + @
                    val top = stack.lastOrNull()
                    if (top != null) {
                        result.append(stack.removeLast().symbol)
                    }

                    stack.addLast(operator)
                }
                else -> throw IllegalArgumentException("Unknown character: $char")
            }
        }

        // 3. stack 에 남아있는 연산자를 result 에 집어넣기
        stack.forEach { operator ->
            result.append(operator.symbol)
        }

        return result.toString()
    }

    private fun trim(expression: String): String = expression.replace(Regex("\\s+"), "")
}
