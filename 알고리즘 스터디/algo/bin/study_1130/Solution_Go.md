슈퍼마켓에 셀프 체크아웃용 틸이 줄지어 있다. 모든 고객이 체크아웃하는 데 필요한 총 시간을 계산하는 기능을 작성하십시오!

input:
- 고객: 대기열을 나타내는 일련의 양의 정수 각각의 정수는 고객을 나타내며, 그 값은 그들이 체크아웃하는 데 필요한 시간이다.=
- n: 양의 정수, 체크아웃 틸 수입니다.

output:
- 함수는 필요한 총 시간인 정수를 반환해야 한다.

queue_time([5,3,4], 1)
# should return 12
# because when n=1, the total time is just the sum of the times

queue_time([10,2,3,3], 2)
# should return 10
# because here n=2 and the 2nd, 3rd, and 4th people in the 
# queue finish before the 1st person has finished.

queue_time([2,3,10], 2)
# should return 12

Clarifications
많은 틸을 제공하는 유일한 대기열은 대기열의 순서는 변경되지 않으며 대기열의 앞쪽 사람(즉, 배열/목록의 첫 번째 요소)이 없어질때 까지 계속된다.