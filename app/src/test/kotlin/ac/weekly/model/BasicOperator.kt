package ac.weekly.model

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
}
