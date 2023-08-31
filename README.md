# Algorithm
This is a auto push repository for Baekjoon Online Judge created with [BaekjoonHub](https://github.com/BaekjoonHub/BaekjoonHub).

<br>

> 알고리즘 강의 출처 <br> 
Youtube 개발자로 취직하기 - 프로그래머스 코딩 테스트 (자바) https://bit.ly/CodingTestJAVA  <br>
Inflearn 하루코딩 - Do it! 알고리즘 코딩테스트 with JAVA https://bit.ly/DoItJAVA 

<br>

#### `Do it! 알고리즘 코딩테스트 with JAVA`

<details>
  
  <summary>✏️ 학습 내용 정리</summary>
  
  ##### `섹션 0) 코딩테스트 준비하기`
  
  * 시간복잡도
    * 보통 코딩테스트 문제는 시간 제한이 있다 (1~2초 내외)
    * 1초당 1억 번의 연산을 한 다고 대략 가정하면 되고, 최악의 연산 시간 (빅오표기법) 이 시간 제한 안에 수행될 수 있도록 문제 풀이를 진행해야 한다
    * 연산 횟수를 구하는 공식 : 알고리즘 시간 복잡도 X 데이터의 크기
    * 상수는 시간복잡도에서 제외하고, 가장 많이 중첩된 반복문 (ex. 이중, 3중 for문...) 이 수행시간이 제일 길기 때문에 시간복잡도의 기준으로 삼는다
    * 코테 문제를 한 번에 맞추면 정말 행운이지만, 문제가 틀렸다면, 1️⃣ 알맞은 알고리즘을 선택했는지 2️⃣ 비효율적인 로직이 쓰였는지, 어떻게 효율적으로 바꿀지 를 중심으로 고민할 것

  <br>
  
  * 디버깅
    * 문제 풀다가 흠... 긴가민가 하는 부분에 디버깅을 찍고 돌려보자 (처음에는 로그를 찍는게 더 편하다고 생각하겠지만 디버깅이 더 괜찮대요)
    * 반복문에서 인덱스 범위 지정 오류 찾아보기
    * 잘못된 변수 사용 오류 찾아보기
    * 자료형 범위 오류 찾아보기 (int 형을 사용했는데 이상하게 음수가 나온다면 long 으로 바꿔보자, 이런 일이 꽤 빈번하게 발생하기 때문에 아예 초장부터 long으로 선언하고 문제 푸는게 정신건강에 이로울 수 있다)

  <br>
  
  ##### `섹션 1) 자료구조 (Data Stucture)`

  * 배열 
    * 배열은 메모리의 연속 공간에 값이 채워져 있는 형태의 자료구조, 배열의 값은 인덱스를 통해 참조할 수 있으며, 선언한 자료형의 값만 저장할 수 있다.
    * 인덱스를 사용하여 값에 바로 접근할 수 있다.
    * 새로운 값을 삽입하거나 특정 인덱스에 있는 값을 삭제하기 어렵다. 값을 삽입하거나 삭제하려면 해당 인덱스 주변에 있는 값을 이동시키는 과정이 필요하다.
    * 배열의 크기는 선언할 때 지정할 수 있으며, 한 번 선언하면 크기를 늘리거나 줄일 수 없다.
    * 구조가 간단한 편 ➡️ 코테에서 많이 사용함

  <br>
  
  * 리스트
    * 리스트는 값과 포인터를 묶은 노드(값, 포인터를 쌍으로 갖는 기초 단위) 라는 것을 포인터로 연결한 자료구조다.
    * 인텍스가 없으므로 값에 접근하려면 Head 포인터부터 순서대로 접근해야 한다. ➡️ 값에 접근하는 속도가 느리다
    * 포인터로 연결되어 있으므로 데이터를 삽입하거나 삭제하는 연산 속도가 빠르다.
    * 선언할 때 크기를 별도로 지정하지 않아도 된다. ➡️ 리스트의 크기는 정해져 있지 않으며, 크기가 변하기 쉬운 데이터를 다룰 때 적절하다!
    * 포인터를 저장할 공간이 필요하므로, 배열보다는 구조가 복잡하다
    * 구현되어있는 ArrayList, LinkedList는 삽입, 삭제, 접근이 내부적으로 지원되기 때문에, 쌩 리스트를 구현하는 경우는 거의 없음 (쌩 리스트를 구현하는건 난이도가 상당히 높음)

  <br>
  
  * 구간 합
    * 구간 합은 합 배열을 이용하여 시간 복잡도를 더 줄이기 위해 사용하는 특수한 목적의 알고리즘이다.
    * <img width="404" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/97c6e441-36dd-472d-8d05-3c520c991e28">

    * 합 배열 S를 만드는 공식 : S[i] = S[i-1] + A[i]

    <br>

    * <img width="404" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/73367c95-5cbc-496e-9e44-21a423927ba4">

    * i에서 j까지의 구간 합을 구하는 공식 : S[j] - S[i-1]
   
  <br>

  * 투 포인터
    * 투포인터의 이동 원칙
    * 번호의 합이 M보다 크므로 큰 번호 index 를 내린다 : A[i] + A[j] > M일 때, j--;
    * 번호의 합이 M보다 작으므로 작은 번호 index를 올린다 : A[i] + A[j] < M일 때, i++;
    * 양쪽 포인터를 모두 이동시키고 count를 증가시킨다 : A[i] + A[j] == M일 때, i++; j--; count++;

  <br>

  * 슬라이딩 윈도우
    * 시간복잡도가 O(n) 이라 주어진 문제의 max값이 클 때 유용하게 사용할 수 있음.
    * 크기가 정해진 부분 문자열 (윈도우) 를 이동시키면서, 크기를 유지한 상태로 윈도우를 이동시키면서 조건에 맞는지 탐색하는 방법
    * <img width="506" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/62a62241-25e8-41e7-b294-a4c823e71b8f">

  <br>

  * 스택과 큐
    * 스택 : 삽입과 삭제 연산이 후입선출(LIFO)로 이루어져있는 자료구조로, 삽입과 삭제가 한 쪽에서만 일어나는 특징을 가짐
    * 스택은 깊이 우선 탐색 (DFS), 백트래킹 종류의 코테에서 효과적임. 후입선출은 개념 자체가 재귀 함수 알고리즘 원리와 일맥상통함 
      * top : 삽입과 삭제가 일어나는 위치
      * push : top 위치에 현재 있는 데이터를 삭제하고 확인하는 연산
      * peek : top 위치에 현재 있는 데이터를 단순 확인하는 연산
    * 큐 : 삽입 삭제 연산이 선입선출(FIFO)로 이루어져있는 자료구조로, 스택과는 다르게 삽입과 삭제가 양방향에서 일어나는 특징을 가짐
    * 큐는 너비 우선 탐색 (BFS) 에서 자주 사용하는 연산임
      * rear :큐에서 가장 끝 데이터를 가리키는 영역
      * front : 큐에서 가장 앞의 데이터를 가리키는 영역
      * add : rear 부분에 새로운 데이터를 삽입하는 연산
      * poll : front 부분에 있는 데이터를 삭제하고 확인하는 연산
      * peek : front에 있는 데이터를 확인할 때 사용하는 연산
    * 우선순위 큐도 있음 (들어간 순서와 산관 없이 우선순위가 높은 데이터가 먼저 나오는 자료구조, 큐 설정에 따라 front에 항상 최댓값 또는 최솟값이 위치함. 일반적으로 힙(heap, 트리 종류 中 1)을 이용해 구현)


















  
</details>
