용어
=

### Dao
DB를 사용해 데이터를 조회하거나 조작하는 기능을 전담하는 오브젝트

### 자바빈
원래 비주얼 툴에서 조작 가능한 컴포넌트를 말하였으나, 주력 개발 풀이 웹 기반 엔터프라이즈 방식으로 바뀌며 비주얼 컴포넌트로서
자바빈은 인기를 잃고 몇가지 코딩 관례를 따라 만들어진 오브젝트를 뜻한다.
- 디폴트 생성자
    - 파라미터가 없는 생성자를 가져야 한다.
      툴이나 프레임 워크에서 리플렉션을 이용해 오브젝트를 생성하기 때문.
- 프로퍼티
    - 자바빈이 노출하는 이름을 가진 속성을 뜻한다.
    - 오브젝트의 필드에 대해 get-set으로 시작하는 메서드를 가져야 한다.

### refactoring
기존 코드를 외부 동작방식에는 변화 없이 내부 구조를 변경하여 재구성하는 작업  
코드의 설계를 개선하여 코드를 이해하기 편해지고 변화에 효율적으로 대응 가능해진다.
