package ac.weekly.operation

/**
 * @author Theo
 * @since 2025/01/17
 */
sealed class Operation {
    abstract fun execute(
        left: Long,
        right: Long,
    ): Long

    data object Addition : Operation() {
        override fun execute(
            left: Long,
            right: Long,
        ): Long = left + right
    }

    data object Subtraction : Operation() {
        override fun execute(
            left: Long,
            right: Long,
        ): Long = left - right
    }

    data object Multiplication : Operation() {
        override fun execute(
            left: Long,
            right: Long,
        ): Long = left * right
    }

    // TODO Division Long 타입으로 처리하고 있는 부분 수정 필요
    
    data object Division : Operation() {
        override fun execute(
            left: Long,
            right: Long,
        ): Long = left / right
    }

    companion object {
        @JvmStatic
        fun from(operator: BasicOperator): Operation =
            when (operator) {
                BasicOperator.Plus -> Addition
                BasicOperator.Minus -> Subtraction
                BasicOperator.Multiply -> Multiplication
                BasicOperator.Divide -> Division
            }
    }
}
