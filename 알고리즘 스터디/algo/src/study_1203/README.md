양의 정수 n을 지정한 경우, 엄격히 증가하는 숫자의 순서(언어에 따라 목록/배열/문자열)를 반환하여 제곱의 합이 n²와 같도록 한다.

여러 솔루션이 있는 경우(그리고 있을 경우) 가능한 한 가장 큰 값을 사용하여 결과를 반환하십시오.

Examples

decompose(11) must return [1,2,4,10]. Note that there are actually two ways to decompose 11², 11² = 121 = 1 + 4 + 16 + 100 = 1² + 2² + 4² + 10² but don't return [2,6,9], since 9 is smaller than 10.

For decompose(50) don't return [1, 1, 4, 9, 49] but [1, 3, 5, 8, 49] since [1, 1, 4, 9, 49] doesn't form a strictly increasing sequence.

Note
[n]이나 [1,1,1, ...,1] 모두 유효한 해결책이 아니다. 마땅한 결과값이 없을 경우 null 이나 None을 리턴하세요

decompose(11) => [1,2,4,10]
decompose(50) => [1, 3, 5, 8, 49]
decompose(4) => null



입력된 용어(하위 대소문자 문자열)와 알려진 단어 배열(하위 대소문자 문자열)을 얻으십시오. 당신의 임무는 어떤 사전의 단어가 입력된 단어와 가장 유사한지 알아내는 것이다. 

유사성은 입력된 단어에서 사전 중 하나로 가져오기 위해 추가, 제거 또는 교체해야 하는 최소 글자 수로 설명된다. 

필요한 변경 횟수가 적을수록 각 두 단어의 유사성이 높아진다.

같은 말이 분명히 가장 비슷한 말이다. 한 글자가 필요한 단어는 2글자 이상 필요한 단어와 더 유사하다. 예를 들어, 잘못 입력된 용어 berr은 배럴(총 3글자)보다 맥주(대체할 1글자)와 더 유사하다.

사전이 알려진 단어 목록에서 가장 유사한 단어를 반환할 수 있도록 사전을 확장하십시오.

Code Examples:

Dictionary fruits = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});

fruits.findMostSimilar("strawbery"); // must return "strawberry"
fruits.findMostSimilar("berry"); // must return "cherry"


Dictionary languages = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
languages.findMostSimilar("heaven"); // must return "java"
languages.findMostSimilar("javascript"); // must return "javascript" (same words are obviously the most similar ones)
