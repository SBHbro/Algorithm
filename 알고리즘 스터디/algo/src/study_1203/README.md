���� ���� n�� ������ ���, ������ �����ϴ� ������ ����(�� ���� ���/�迭/���ڿ�)�� ��ȯ�Ͽ� ������ ���� n���� ������ �Ѵ�.

���� �ַ���� �ִ� ���(�׸��� ���� ���) ������ �� ���� ū ���� ����Ͽ� ����� ��ȯ�Ͻʽÿ�.

Examples

decompose(11) must return [1,2,4,10]. Note that there are actually two ways to decompose 11��, 11�� = 121 = 1 + 4 + 16 + 100 = 1�� + 2�� + 4�� + 10�� but don't return [2,6,9], since 9 is smaller than 10.

For decompose(50) don't return [1, 1, 4, 9, 49] but [1, 3, 5, 8, 49] since [1, 1, 4, 9, 49] doesn't form a strictly increasing sequence.

Note
[n]�̳� [1,1,1, ...,1] ��� ��ȿ�� �ذ�å�� �ƴϴ�. ������ ������� ���� ��� null �̳� None�� �����ϼ���

decompose(11) => [1,2,4,10]
decompose(50) => [1, 3, 5, 8, 49]
decompose(4) => null



�Էµ� ���(���� ��ҹ��� ���ڿ�)�� �˷��� �ܾ� �迭(���� ��ҹ��� ���ڿ�)�� �����ʽÿ�. ����� �ӹ��� � ������ �ܾ �Էµ� �ܾ�� ���� �������� �˾Ƴ��� ���̴�. 

���缺�� �Էµ� �ܾ�� ���� �� �ϳ��� �������� ���� �߰�, ���� �Ǵ� ��ü�ؾ� �ϴ� �ּ� ���� ���� ����ȴ�. 

�ʿ��� ���� Ƚ���� �������� �� �� �ܾ��� ���缺�� ��������.

���� ���� �и��� ���� ����� ���̴�. �� ���ڰ� �ʿ��� �ܾ�� 2���� �̻� �ʿ��� �ܾ�� �� �����ϴ�. ���� ���, �߸� �Էµ� ��� berr�� �跲(�� 3����)���� ����(��ü�� 1����)�� �� �����ϴ�.

������ �˷��� �ܾ� ��Ͽ��� ���� ������ �ܾ ��ȯ�� �� �ֵ��� ������ Ȯ���Ͻʽÿ�.

Code Examples:

Dictionary fruits = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});

fruits.findMostSimilar("strawbery"); // must return "strawberry"
fruits.findMostSimilar("berry"); // must return "cherry"


Dictionary languages = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
languages.findMostSimilar("heaven"); // must return "java"
languages.findMostSimilar("javascript"); // must return "javascript" (same words are obviously the most similar ones)
