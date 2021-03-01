## Comparator, Comparable 정렬

comparable - 이 인터페이스를 구현한 객체 스스로에게 부여하는 한 가지 기본 정렬 규칙을 설정하는 목적

comparator - 이 인터페이스를 구현한 클래스는 정렬 규칙 그 자체를 의미하며, 기본 정렬 규칙과 다르게 원하는 대로 정렬 순서를 지정하고 싶을 때 사용



collections.sort -> comparator를 인자로 넘기지 않을 경우 그 객체에 생성되어있는 compareTo 메소드를 통해 정렬한다

comarator를 인자로 넘길 경우 comparator에 생성된 규칙에 따라 컬렉션을 정렬한다.