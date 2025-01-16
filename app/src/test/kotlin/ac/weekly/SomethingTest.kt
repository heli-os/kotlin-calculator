package ac.weekly

import ac.weekly.model.BasicOperator
import ac.weekly.model.KeypadNumber
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isEqualTo
import kotlin.test.Test

/**
 * @author Theo
 * @since 2025/01/17
 */
class SomethingTest {
    // 소수점 표시 1개: .

    // 부호 표시: 양수, 음수
    // 숫자 10개: 0 ~ 9
    // 사칙연산 연산자 4개: +, -, *, /
    // 특수 연산 1개: 루트 (sqrt)
    // 계산 결과 1개: =
    // 초기화 버튼 1개: Clear

    @Test
    fun `키패드 숫자는 10을 허용하지 않는다`() {
        expectThrows<IllegalArgumentException> {
            KeypadNumber(10)
        }
    }

    @Test
    fun `키패드 숫자는 -1을 허용하지 않는다`() {
        expectThrows<IllegalArgumentException> {
            KeypadNumber(-1)
        }
    }

    @Test
    fun `BasicOperator Plus 는 Plus 로 프린팅되어야 한다`() {
        expectThat(BasicOperator.Plus).and {
            get { toString() } isEqualTo "Plus"
        }
    }

    @Test
    fun `Plus object`() {
        expectThat(BasicOperator.Plus) isEqualTo BasicOperator.Plus
    }

    @Test
    fun `기본 연산자는 4개가 제공된다 덧셈 뺄셈 곱셈 나눗셈`() {
        expectThat(BasicOperator::class.nestedClasses).and {
            get { size } isEqualTo 4
            // TODO 4개가 구체적으로 어떤게 제공되는지 테스트 코드 추가
        }
    }

    @Test
    fun `연산 우선순위, 덧셈과 뺄셈은 같은 우선순위를 가진다`() {
    }

    @Test
    fun `연산 우선순위, 곱셈과 나눗셈은 같은 우선순위를 가진다`() {
    }

    @Test
    fun `연산 우선순위, 곱셉은 덧셈보다 높은 우선순위를 가진다`() {
    }

    @Test
    fun `연산 우선순위, 나눗셈 덧셈보다 높은 우선순위를 가진다`() {
    }

    @Test
    fun `연산 우선순위, 곱셉은 뺄셈보다 높은 우선순위를 가진다`() {
    }

    @Test
    fun `연산 우선순위, 나눗셈 뺄셈보다 높은 우선순위를 가진다`() {
    }

    @Test
    fun `1+1=2`() {
    }

    @Test
    fun `3-2=1`() {
    }

    @Test
    fun `3*2=6`() {
    }

    @Test
    fun `9-1*6=3`() {
    }

    @Test
    fun `5+3-2*4=0`() {
    }

    @Test
    fun `특수 연산자는 1개가 제공된다 루트(sqrt)`() {
    }

    @Test
    fun `이전 결과를 기억해놓고 있다가 이어서 연산을 수행 할 수 있다`() {
    }

    /**
     * 1. Stack 기반 후위 표기식 -> 전통 방식으로 우선 작업
     * 2. 간단한 상태 머신
     * 3. top->down 하향 재귀 방식
     * 4. 중위 표기법 기반으로된 알고리즘: Shunting Yard
     * 5. 정규표현식 기반 계산 방식
     */
}
