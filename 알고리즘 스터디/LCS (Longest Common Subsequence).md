## LCS (Longest Common Subsequence)

- 두개의 문자열을 비교해 공통 부분 수열의 길이를 구하는 알고리즘
- 세개를 비교하려면 삼차원으로 늘리면 된다.
- A(ACBDE)와 B(CDBAD)가 있을경우
- ​    0   A   C   B  D   E
- 0  0   0   0   0   0   0
- C  0  0    1   1   1   1
- D  0   0   1   1   2   2
- B  0   0    1   2  2   2  
- A  0   1   1    2   2   2
- D  0   1   1   2   3    3
- A[i]와 B[j] 가 같은 경우 -> 왼쪽위 +1 => ACB와 CDB를 비교할경우 AC와 CD를 비교한 값 +1
- 같지 않을 경우 -> 왼쪽 혹은 위에서 더 큰수=> ACB와 CDB를 비교할경우 ACB CD를 비교한것과 AC CDB를 비교한것 중 더 큰값
- 수열의 길이가 아닌 내용을 알고 싶을땐 대각선인 시점을 체크한다.