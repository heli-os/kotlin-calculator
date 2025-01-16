package ac.weekly.operation

/**
 * @author Theo
 * @since 2025/01/17
 */
sealed class BasicOperator {
    abstract val symbol: Char

    data object Plus : BasicOperator() {
        override val symbol: Char = '+'
    }

    data object Minus : BasicOperator() {
        override val symbol: Char = '-'
    }

    data object Multiply : BasicOperator() {
        override val symbol: Char = '*'
    }

    data object Divide : BasicOperator() {
        override val symbol: Char = '/'
    }

    companion object {
        @JvmStatic
        fun from(symbol: Char): BasicOperator =
            when (symbol) {
                Plus.symbol -> Plus
                Minus.symbol -> Minus
                Multiply.symbol -> Multiply
                Divide.symbol -> Divide
                else -> throw IllegalArgumentException("Unknown operator: $symbol")
            }

        @JvmStatic
        fun isOperator(char: Char): Boolean =
            BasicOperator::class
                .sealedSubclasses
                .map { it.objectInstance as BasicOperator }
                .any { it.symbol == char }
    }
}
