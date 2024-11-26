class Solution {
    public String fractionToDecimal(int numerator, int denominator)     
    {
        // 두 정수로 주어진 분수의 분자와 분모를 이용하여, 분수를 문자열 형식으로 반환
        // 순환소수인 경우 반복되는 부분을 괄호 안에 감싸야 함.
        // 모든 입력에 대해 반환 문자열의 길이는 10⁴보다 작다
        if (numerator == 0) return "0"; // 분자가 0인 경우 바로 반환
        StringBuilder result = new StringBuilder();
        // 음수 처리
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        // 정수 부분 계산
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(num / den);
        long remainder = num % den;

        if (remainder == 0) {
            return result.toString(); // 나머지가 없는 경우
        }

        result.append("."); // 소수점 추가

        // 소수 부분 계산 - 여기가 너무 어렵다..
        HashMap<Long, Integer> map = new HashMap<>(); // 나머지를 저장하여 순환 확인
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                // 순환소수 발생
                result.insert(map.get(remainder), "(");
                result.append(")");
                break;
            }
            
            map.put(remainder, result.length()); // 나머지의 현재 위치 저장
            remainder *= 10;
            result.append(remainder / den); // 몫 추가
            remainder %= den; // 새로운 나머지 계산
        }
        
        return result.toString();
    }
}