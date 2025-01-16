package ac.weekly.module

import ac.weekly.operation.BasicOperator

/**
 * @author Theo
 * @since 2025/01/17
 */
class BasicOperatorPriorityResolver {
    fun resolve(operator: BasicOperator): Int =
        when (operator) {
            BasicOperator.Plus -> 1
            BasicOperator.Minus -> 1
            BasicOperator.Multiply -> 2
            BasicOperator.Divide -> 2
        }
}
