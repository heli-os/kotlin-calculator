package ac.weekly.ui

/**
 * @author Theo
 * @since 2025/01/17
 */
@JvmInline
value class KeypadNumber(
    val value: Long,
) {
    init {
        require(value in 0..9) { "키패드 숫자는 0에서 9까지만 허용한다" }
    }
}
