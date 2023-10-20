# Algorithm
This is a auto push repository for Baekjoon Online Judge created with [BaekjoonHub](https://github.com/BaekjoonHub/BaekjoonHub).

<br>

> 알고리즘 강의 출처 <br> 
Youtube 개발자로 취직하기 - 프로그래머스 코딩 테스트 (자바) https://bit.ly/CodingTestJAVA  <br>
Inflearn 하루코딩 - Do it! 알고리즘 코딩테스트 with JAVA https://bit.ly/DoItJAVA 

<br>

### `Do it! 알고리즘 코딩테스트 with JAVA`

<details>
  
  <summary> 📌 섹션 0) 코딩테스트 준비하기 </summary>
  
  * #### `시간복잡도`
    * 보통 코딩테스트 문제는 시간 제한이 있다 (1~2초 내외)
    * 1초당 1억 번의 연산을 한 다고 대략 가정하면 되고, 최악의 연산 시간 (빅오표기법) 이 시간 제한 안에 수행될 수 있도록 문제 풀이를 진행해야 한다
    * 연산 횟수를 구하는 공식 : 알고리즘 시간 복잡도 X 데이터의 크기
    * 상수는 시간복잡도에서 제외하고, 가장 많이 중첩된 반복문 (ex. 이중, 3중 for문...) 이 수행시간이 제일 길기 때문에 시간복잡도의 기준으로 삼는다
    * 코테 문제를 한 번에 맞추면 정말 행운이지만, 문제가 틀렸다면, 1️⃣ 알맞은 알고리즘을 선택했는지 2️⃣ 비효율적인 로직이 쓰였는지, 어떻게 효율적으로 바꿀지 를 중심으로 고민할 것

  <br>
  
  * #### `디버깅`
    * 문제 풀다가 흠... 긴가민가 하는 부분에 디버깅을 찍고 돌려보자 (처음에는 로그를 찍는게 더 편하다고 생각하겠지만 디버깅이 더 괜찮대요)
    * 반복문에서 인덱스 범위 지정 오류 찾아보기
    * 잘못된 변수 사용 오류 찾아보기
    * 자료형 범위 오류 찾아보기 (int 형을 사용했는데 이상하게 음수가 나온다면 long 으로 바꿔보자, 이런 일이 꽤 빈번하게 발생하기 때문에 아예 초장부터 long으로 선언하고 문제 푸는게 정신건강에 이로울 수 있다)

</details>


<details>

  <summary> 📌 섹션 1) 자료구조 (Data Stucture) </summary>

  * #### `배열` 
    * 배열은 메모리의 연속 공간에 값이 채워져 있는 형태의 자료구조, 배열의 값은 인덱스를 통해 참조할 수 있으며, 선언한 자료형의 값만 저장할 수 있다.
    * 인덱스를 사용하여 값에 바로 접근할 수 있다.
    * 새로운 값을 삽입하거나 특정 인덱스에 있는 값을 삭제하기 어렵다. 값을 삽입하거나 삭제하려면 해당 인덱스 주변에 있는 값을 이동시키는 과정이 필요하다.
    * 배열의 크기는 선언할 때 지정할 수 있으며, 한 번 선언하면 크기를 늘리거나 줄일 수 없다.
    * 구조가 간단한 편 ➡️ 코테에서 많이 사용함

  <br>
  
  * #### `리스트` 
    * 리스트는 값과 포인터를 묶은 노드(값, 포인터를 쌍으로 갖는 기초 단위) 라는 것을 포인터로 연결한 자료구조다.
    * 인텍스가 없으므로 값에 접근하려면 Head 포인터부터 순서대로 접근해야 한다. ➡️ 값에 접근하는 속도가 느리다
    * 포인터로 연결되어 있으므로 데이터를 삽입하거나 삭제하는 연산 속도가 빠르다.
    * 선언할 때 크기를 별도로 지정하지 않아도 된다. ➡️ 리스트의 크기는 정해져 있지 않으며, 크기가 변하기 쉬운 데이터를 다룰 때 적절하다!
    * 포인터를 저장할 공간이 필요하므로, 배열보다는 구조가 복잡하다
    * 구현되어있는 ArrayList, LinkedList는 삽입, 삭제, 접근이 내부적으로 지원되기 때문에, 쌩 리스트를 구현하는 경우는 거의 없음 (쌩 리스트를 구현하는건 난이도가 상당히 높음)

  <br>
  
  * #### `구간 합` 
    * 구간 합은 합 배열을 이용하여 시간 복잡도를 더 줄이기 위해 사용하는 특수한 목적의 알고리즘이다.
    * <img width="404" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/97c6e441-36dd-472d-8d05-3c520c991e28">

    * 합 배열 S를 만드는 공식 : S[i] = S[i-1] + A[i]

    <br>

    * <img width="404" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/73367c95-5cbc-496e-9e44-21a423927ba4">

    * i에서 j까지의 구간 합을 구하는 공식 : S[j] - S[i-1]
   
  <br>

  * #### `투 포인터` 
    * 투포인터의 이동 원칙
    * 번호의 합이 M보다 크므로 큰 번호 index 를 내린다 : A[i] + A[j] > M일 때, j--;
    * 번호의 합이 M보다 작으므로 작은 번호 index를 올린다 : A[i] + A[j] < M일 때, i++;
    * 양쪽 포인터를 모두 이동시키고 count를 증가시킨다 : A[i] + A[j] == M일 때, i++; j--; count++;

  <br>

  * #### `슬라이딩 윈도우` 
    * 시간복잡도가 O(n) 이라 주어진 문제의 max값이 클 때 유용하게 사용할 수 있음.
    * 크기가 정해진 부분 문자열 (윈도우) 를 이동시키면서, 크기를 유지한 상태로 윈도우를 이동시키면서 조건에 맞는지 탐색하는 방법
    * <img width="506" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/62a62241-25e8-41e7-b294-a4c823e71b8f">

  <br>

  * #### `스택과 큐` 
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


<details>

  <summary> 📌 섹션 2) 정렬 (Sorting) </summary>

  * #### `버블 정렬 (Bubble Sort)`
    * 인접한 두 개의 데이터 크기를 비교해 정렬하는 방법
    * 간단하게 구현할 수는 있지만, 시간복잡도는 O(n²) 으로, 다른 정렬 알고리즘보다 속도가 느린 편
    * <img width="781" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/2fcfd32d-3a20-41b1-8f97-3fc436bc1179">

    * 그림과 같이 루프를 돌면서 인접한 데이터 간의 swap 연산으로 정렬함
    * 만약 특정한 루프의 전체 영역에서 swap이 한 번도 발생하지 않았다면, 그 영역 뒤에 있는 데이터가 모두 정렬되었다는 뜻이므로 프로세스를 종료해도 된다.
   
  <br>

  * #### `선택 정렬 (Selection Sort)`
    * 대상 데이터에서 최대나 최소 데이터를 데이터가 나열된 순으로 찾아가며 선택하는 방법
    * 선택 정렬은 구현 방법이 복잡하고, 시간 복잡도도 O(n²)으로 효율적이지 않아 코딩테스트에서는 많이 사용하지 않지만, 이를 응용하는 문제가 나올 수 있고 기술면접에서 간간히 물어봄
    * <img width="432" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/4442d2e7-2941-411d-932b-bbcac1f11c5e"> 

    * 남은 정렬 부분에서 최솟값 또는 최댓값을 찾는다 ➡️ 남은 정렬 부분에서 가장 앞에 있는 데이터와 선택된 데이터를 swap 한다 ➡️
      가장 앞에 있는 데이터의 위치를 변경해(index++) 남은 정렬 부분의 번위를 축소한다 ➡️ 전체 데이터 크기만큼 index가 커질 때까지, 즉 남은 정렬 부분이 없을 때까지 반복한다

  <br>

  * #### `삽입 정렬 (Insertion Sort)`
    * 이미 정렬된 데이터 범위에 정렬되지 않은 데이터를 적절한 위치에 삽입시켜 정렬하는 방법
    * 시간 복잡도는 버블정렬, 선택정렬과 동일하게 O(n²)으로 느린 편이지만, 구현하기 쉬운 편 (시간복잡도가 느려서 코테에서 자주 사용하지는 않는 정렬이지만 면접때 정렬 관련된 질문 나오는거에 대비해서 알아두면 좋다)
    * <img width="757" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/bcaa3e60-133f-4046-8609-d8db6c1a00de"> 

    * 선택 데이터를 현재 정렬된 데이터 범위 내에서 적절한 위치의 삽입하는 것이 삽입 정렬의 전부다
    * 현재 index에 있는 데이터 값을 선택한다 ➡️ 현재 선택한 데이터가 정렬된 데이터 범위에 삽입될 위치를 탐색한다 ➡️ 삽입 위치부터 index에 있는 위치까지 shift 연산을 수행한다
       ➡️ 전체 데이터의 크기만큼 index가 커질 때까지, 즉 선택할 데이터가 없을 떄까지 반복한다
    * 적절한 삽입 위치를 탐색하는 부분에서 이진 탐색 등과 같은 탐색 알고리즘을 사용하면 시간 복잡도를 줄일 수 있음!
  
  <br>
  
  * #### `퀵 정렬 (Quick Sort)`
    * 기준값 (pivort) 을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해 정렬하는 알고리즘
    * 기준값이 어떻게 선정되는지가 시간 복잡도에 많은 영향을 미치고, 평균 시간 복잡도는 O(nlogn)이며 최악의 경우에는 시간 복잡도가 O(n²)이 됨
    * <img width="429" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/fcb767f9-8ce0-41c8-91ba-f962e1262a9e">
    * <img width="739" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/d91a2127-bb15-429b-bc1e-f6a79b0066ea">

    * pivort 선정을 운에 맡겨야되서 평균 시간 복잡도랑 최악 시간복잡도 차이가 심한 정렬이지만, 평균 시간 복잡도는 나름 준수한 편으로 코테에서는 종종 응용하는편 (재귀함수 활용)

  <br>
  
  * #### `병합 정렬 (Merge Sort)`
    * 분할 정복 (divide and conquer) 방식을 사용해서 데이터를 분할하고, 분할한 집합을 정렬하며 합치는 알고리즘, 시간 복잡도는 O(nlogn) 으로 준수한 편이다
    * <img width="346" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/444bc65b-03b6-4388-8804-0ec3a57feaeb">

    * 병합 정렬은 2개의 그룹을 병합하는 원리라는걸 꼭 숙지할 것 (투 포인터 활용, 앞 그룹은 정렬 시켜놓고 포인터 주고, 뒷 그룹은 정렬 안 되어있는 상태에서 병합 정렬을 쓰는 것)
  
  <br>
  
  * #### `기수 정렬 (Redix Sort)`
    * 기수 정렬은 값을 비교하지 않는 특이한 정렬
    * 값을 놓고 비교할 자릿수를 정한 다음, 해당 자릿수만 비교하는 정렬, 시간 복잡도는 O(kn) 이다 (여기서 k는 자릿수를 의미함)
    * 데이터가 굉장히 많은데, 각 데이터의 자릿수가 길지 않다면 시간 복잡도가 낮은 편이라 써먹어도 괜찮은 정렬임
    * 기수 정렬은 10개의 큐를 이용하는데, 각 큐는 값의 자릿수를 대표함 (0~9)
    * <img width="668" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/c4e5952f-0661-4cbe-b2f1-3e54a1142ff1"> 

</details>
    

<details>
  
  <summary> 📌 섹션 3) 탐색 </summary>

  * #### `DFS (깊이 우선 탐색)` 
    * 깊이 우선 탐색 (DFS : depth-first search) 은 그래프 완전 탐색 기법 중 하나이며, 그래프의 시작 노드에서 출발하여 탐색할 한 쪽 분기를 정하여 최대 깊이까지 탐색을 마친 후 다른 쪽 분기로 이동하여 다시 탐색을 수행하는 알고리즘이다
    * 재귀 함수르 구현하고, 스택 자료구조를 이용한다 (FILO)
    * 시간 복잡도는 O(V + E) (여기서 V : 노드 수 / E : 엣지 수 이다.)
    * DFS은 실제 구현 시 재귀함수를 이용하므로, 스택 오버플로에 유의해야함.
    * DFS는 한 번 방문한 노드를 다시 방문하면 안 되므로, 노드 방문 여부를 체크할 배열이 필요
    * <img width="796" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/eb8c56ef-d583-46fd-bba6-c8e21fe70050">
    * <img width="796" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/c174e576-08b8-4149-b665-6e3e78018c47">
    * <img width="796" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/52c51a6b-a9ae-4403-90d0-6cb159c434d1">

  <br>

  * #### `BFS (너비 우선 탐색)` 
    * 너비 우선 탐색 (BFS : breadth-first search) 도 DFS 와 동일하게 그래프를 완전 탐색하는 방법 중 하나고, 시작 노드에서 출발해 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘이다
    * 선입선출 (FIFO) 이 특징이며, 큐 자료구조를 이용한다.
    * 시간복잡도는 O(V + E) (여기서 V : 노드 수 / E : 엣지 수 이다.) 로 DFS와 동일하다
    * 너비 우선 탐색은 탐색 시작 노드와 가까운 노드를 우선하여 탐색하므로, 목표 노드에 도착하는 경로가 여러 개일 때 최단 경로를 보장함
    * <img width="514" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/0546f3c4-de29-4fc3-a040-8e140ef83b55">

    * <img width="514" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/71449ec1-be28-43c3-b1d3-4af190f8dafb">

    * <img width="514" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/fe921be3-f553-41ef-b838-92f5db61674a">


  * #### `이진 탐색 (binary search)` 
    * 이진 탐색 이란, 데이터가 정렬되어 있는 상태에서 원하는 값을 찾아내는 알고리즘이다.
    * 대상 데이터의 중앙값과 찾고자 하는 값을 비교해 데이터의 크기를 절반씩 줄이면서 대상을 찾음
    * 이진탐색의 시간 복잡도는 O(logN)
    * 이진 탐색은 정렬 데이터에서 원하는 데이터를 탐색할 때 사용하는 가장 일반적인 알고리즘, 구현 및 원리가 비교적 간단해서 코테에 자주 출제되는 영역임 !
    * 다만, 이진 탐색은 데이터가 정렬되어 있어야 정상적으로 수행할 수 있으니까 이진 탐색 실행 전에 데이터 정렬은 필수임
    
    <br>
    
    * 이진 탐색 과정 (오름차순으로 정렬된 데이터 기준, 내림차순은 이 과정을 반대로 하면 됨.)
      * 1. 현재 데이터셋의 중앙값을 선택한다
        2. 중앙값 > 타깃 데이터 일 때, 중앙값 기준으로 왼쪽 데이터셋을 선택한다.
        3. 중앙값 < 타깃 데이터일 때, 중앙값 기준으로 오른쪽 데이터셋을 선택한다.
        4. 과정 1 ~ 3을 반복하다가, 중앙값 == 타깃 데이터일 때 이진 탐색을 종료한다.
           <img width="500" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/6780d232-b208-4e5d-be24-bf787159de42">
    
</details>


<details>

  <summary> 📌 섹션 4) 탐욕 알고리즘 (Greedy Algorithm) </summary>
  
  * #### `그리디 알고리즘 (탐욕법)` 
    * 그리디 알고리즘이란, 현재 상태에서 보는 선택지 중 최선의 선택지가 전체 선택지 중 최선의 선택지라고 가정하는 알고리즘이다.
    * 그리디 알고리즘의 크리티컬 포인트는, 그리디 알고리즘이 선택하는 최선의 선택지는 문제에서의 최적의 해(best answer) 를 보장하지 않는다는 점이다
    * 그래서 실제 코딩테스트에서 그리디 알고리즘을 적용할 수 있는지 판단하는 과정이 매우 중요함
    * 그리디 알고리즘의 수행 과정
      * 1. 해 선택 : 현재 상태에서 가장 최선이라고 생각되는 해를 선택한다.
        2. 적절성 검사 : 현재 선택한 해가 전체 문제의 제약 조건에 벗어나지 않는지 검사한다.
        3. 해 검사 : 현재까지 선택한 해 집합이 전체 문제를 해결할 수 있는지 검사한다. 전체 문제를 해결하지 못한다면, 1번으로 돌아가서 같은 과정을 반복한다.
  
</details>


<details>

  <summary> 📌 섹션 5) 정수론 </summary>

  * #### `소수 구하기 (에라토스테네스의 체)` 
    * 소수 (prime number) : 자신보다 작은 2개의 자연수를 곱해 만들 수 없는 1보다 큰 자연수, 1과 자기 자신 외에 약수가 존재하지 않는 수
    * 종종 소수를 판별하는 '소수 구하기' 문제가 종종 출제되는데, 소수를 구하는 대표적인 판별법으로는 **에라토스테네스의 체** 가 있음.
    * 에라토스테네스의 체의 원리
      * 1. 구하고자 하는 소수의 범위만큼 1차원 배열을 생성한다.
           <img width="562" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/48596866-1dfd-44fd-86f6-1df0186c201f">

        2. 2부터 시작하고 현재 숫자가 지워지지 않을 때는, 현재 선택된 숫자의 배수에 해당하는 수를 배열에서 끝까지 탐색하면서 지운다. **이때, 처음으로 선택된 숫자는 지우지 않는다. ➡️ 이게 소수임**
           
           <img width="562" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/797f9b81-3cb3-48f7-9092-dddb92ce474d">
           <img width="562" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/e734402a-16d2-40fa-bf34-8c9d85fc6053">

        4. 배열의 끝까지 2번을 반복한 후, 배열에서 남아있는 모든 수를 출력한다. ➡️ **소수 모두 출력**
           <img width="562" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/c19856e8-923b-46d4-93e8-e989d265ae35">
           <img width="562" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/241a9bfa-b495-43f8-b155-a2cd85065a14">
    
    <br>

    * 에라토스테네스의 체를 사용할 때 시간 복잡도
      * 에라토스테네스의 체를 구현하려면 이중 for문을 사용하는게 일반적이라, 시간복잡도는 O(N²)이다.
      * 그러나 실제 시간 복잡도는 최적화의 정도에 따라 다르겠지만, 배수를 삭제하는 연산으로 실제 구현에서 바깥쪽 for문을 생략하는 경우가 빈번하게 발생하기 때문에, 보~통은 구현하면 O(Nlog(logN))이 나온다
      * 그래서 소수 구하기 문제에서는 에라토스테네스의 체를 사용하는 것이 일반적인 방법으로 통용되고 있다.

  <br>
    
  * #### `오일러 피` 
    * 오일러 피 함수 P[N]의 정의는 1부터 N까지 범위에서 N과 서로소인 자연수의 개수를 뜻함
    * 오일러 피 함수는 증명 과정을 알고있어야 완벽하게 알 수 있다 (원리를 알면 풀고 모르면 접근하기가 힘든 문제, 근데 출제 빈도는 높지 않음)
    * 같은 정수론인 에라토스테네스의 체와 유사한 원리다
    * 오일러 피 함수의 원리
      * 1. 구하고자 하는 오일러 피의 범위만큼 배열을 자기 자신의 인덱스값으로 초기화한다.
           <img width="699" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/8cf80bfd-e52f-4896-aeaa-4f17f3f6a960">

        2. 2부터 시작해 현재 배열의 값과 인덱스가 같으면 (= 소수일 때) 현재 선택된 숫자(K)의 배수에 해당하는 수를 배열의 끝까지 탐색하며 **P[i] = P[i] - P[i]/K** 연산을 수행한다. (여기서 i는 K의 배수)
           <img width="825" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/6ea90054-2a0b-4649-ab4e-f6867df24ecc">
           <img width="825" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/85a63cde-2560-4579-9b26-8497f9dc593d">


        3. 배열의 끝까지 2번을 반복하여 오일러 피 함수를 완성한다.
           <img width="719" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/a2bd9620-ff10-4367-8079-84086a5b4639">


  <br>

  * #### `유클리드 호제법 (euclidean - algorithm)` 
    * 유클리드 호제법이란, 두 수의 최대 공약수를 구하는 알고리즘이다
    * 일반적으로 최대 공약수를 구하는 방법은 소인수 분해를 이용한 공통된 소수들의 곱으로 표현할 수 있지만, 유클리드 호제법을 이용하면 좀 더 간단하게 최대 공약수를 구할 수 있다
    * 유클리드 호제법을 수행하려면, 먼저 MOD (모드) 연산을 이해하고 있어야 한다. (% 나머지 구하는 연산)
    * MOD : 두 값을 나눈 나머지를 구하는 연산 (ex. 10 MOD 4 = 2, 10 % 4 = 2 와 같음)
    * MOD 연산으로 구현하는 유클리드 호제법
      * 1. 큰 수를 작은 수로 나누는 MOD 연산을 수행한다.
        2. 앞 단계에서의 작은 수와 MOD 연산 결괏값 (나머지) 으로 MOD 연산을 수행한다. (여기서 최대 공약수를 구하는 연산은 일반적으로 gcd 로 정의한다)
        3. 2번 단계를 반복하다가, 나머지가 0이 되는 순간의 작은 수를 최대 공약수로 선택한다.
           <img width="705" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/97b3dc0d-a97f-4af2-a5a1-70cb9442ec78">

    * 유클리드 호제법은 코딩테스트에서 재귀함수로 구현하는 편이다

</details>


<details>
  
  <summary> 📌 섹션 6) 그래프 (Graph) </summary>  

  * #### `그래프의 표현`
    * 그래프를 구현하는 방법은 총 3가지가 있다.
    * 1. **에지 리스트 (edge list)** <br>
      에지를 중심으로 그래프를 표현한다. 에지 리스트는 배열에 출발 노드, 도착 노드를 저장하여 에지를 표현하거나, 출발 노드, 도착 노드, 가중치를 저장하여 가중치가 있는 에지를 표현한다. <br>
      에지 리스트는 구현하기는 쉬운 반면, 특정 노드와 관련되어 있는 에지를 탐색하기 쉽지 않다는 단점이 있다. <br>
      에지 리스트는 벨만 포드나 크루스칼(MST) 알고리즘에 사용하며, 노드 중심 알고리즘에는 잘 사용하지 않는다.

      * 에지 리스트로 가중치 없는 그래프 표현하기
         
        <img width="527" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/cac47996-6359-4ece-841e-511447363894">

        가중치가 없는 그래프는 출발 노드와 도착 노드만 표현하므로, 배열의 행은 2개면 충분하다. 노드는 여러 자료형을 사용할 수 있으며, 다음의 경우 노드는 Integer형이다. <br>
        방향이 없는 그래프라면, [1, 2] 랑 [2, 1] 은 같은 표현이다.
        
      * 에지 리스트로 가중치 없는 그래프 표현하기
         
        <img width="527" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/88c55c40-0932-45cc-8f58-ff6423f25479">

        가중치가 있는 그래프는 행을 3개로 늘려 3번째 행에 가중치를 저장하면 된다.

    * 2. **인접 행렬 (adjacency matrix)** <br>
      인접행렬은 2차원 배열을 자료구조로 이용하여 그래프를 표현한다. 인접행렬은 에지 리스트와 다르게 노드 중심으로 그래프를 표현한다. <br>
      만약 노드가 5개인 그래프를 인접 행렬로 표현하려면, 5*5 로 표현하면 된다 (A[5][5] 이런식으로) <br>
      인접 행렬의 장점은, 구현이 쉽고 두 노드를 연결하는 에지의 여부와 가중치값은 배열에 직접 접근하면 바로 확인할 수 있다는 점이다. <br>
      하지만, 인접 행렬의 크리티컬 포인트는 노드와 관련되어 있는 에지를 탐색하려면 N번 접근해야하므로 노트 개수에 비해 에지가 적을 때에는 공간 효율성이 떨어지고, 노드 개수가 많은 경우 아예 2차원 배열 선언 자체를 할 수 없는 결함이 있다.
      (ex. 노드가 3만 개가 넘으면 java heap space 에러 발생)

      * 인접 행렬로 가중치 없는 그래프 표현하기

        <img width="591" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/35be90e4-c278-46d5-b066-1e1d0bddecac">

        예를 들어 3에서 4로 가는 에지가 있다면, 3행 4열에 1을 기록한다. (여기서 인덱스를 중심으로 1을 저장하는 이유는 가중치가 없기 때문)

      * 인접 행렬로 가중치가 있는 그래프 표현하기
     
        <img width="591" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/a2f5403b-594c-4000-a541-f7ae3a50c0c4">

        예를 들어 2에서 5로 향하는 에지가 있고, 그 에지의 가중치가 15라면, 2행 5열에 15를 기록하는 방식

    * 3. **인접 리스트 (adjacency list)** ⭐️ 가장 중요 <br>
      인접 리스트는 ArrayList 로 그래프를 표현한다. 노드 개수만큼 ArrayList를 선언해서 푸는 방식이며, 대부분 인접 리스트 방식으로 코딩테스트 문제를 풀게 된다. <br>
      그래프를 구현하는 다른 방법들에 비해 인접 리스트를 이용한 그래프 구현은 복잡한 편이다. 하지만, 노드와 연결되어 있는 에지를 탐색하는 시간은 매우 뛰어난 편이며, 노드 개수가 커도 공간 효율이 좋아 메모리 초과 에러가 발생하지 않는다. <br>
      이런 장점으로 실제 코딩테스트에서는 인접 리스트를 이용한 그래프 구현을 선호한다. 

      * 인접 리스트로 가중치 없는 그래프 표현하기

        <img width="591" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/73d98495-3ff3-4872-bdbf-cdfec0b6692e">

        인접 리스트에는 N번 노드와 연결되어 있는 노드를 배열의 위치 N에 연결된 노드 개수만큼 배열을 연결하는 방식으로 표현한다. <br>
        예를 들어, 노드 1과 연결된 2, 3 노드는 ArrayList[1]에 [2, 3]을 연결하는 방식으로 표현한다.

      * ⭐️ 인접 리스트로 가중치 있는 그래프 표현하기

        <img width="591" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/302089a7-1580-437d-84d9-d5359f570ae3">

        가중치가 있는 경우, 자료형을 클래스로 사용해야 한다 (예시에서는 Node 라는 클래스를 자료형으로 사용) 그 다음, (도착 노드, 가중치) 를 갖는 Node 클래스를 선언하여 ArrayList 에 사용한다. <br>
        예를 들어, 그림에서처럼 3 노드 정보를 넣고 싶으면, 먼저 Node 라는 클래스를 상단에 선언하고, A[3].add(New Node(4, 3)) 이런식으로 추가해주면 된다.

  <br>
  
  * #### `유니온 파인드 (union-find)`
    * 유니온 파인드는 일반적으로 여러 노드가 있을 때, 특정 2개의 노드를 연결해 1개의 집합으로 묶는 union 연산과 두 노드가 같은 집합에 속해 있는지를 확인하는 find 연산으로 구성되어있는 알고리즘이다.
    * 유니온 파인드는 union, find 연산을 완벽하게 이해하는 것이 핵심
    * 유니온 파인드만 가지고는 그래프 카테고리의 알고리즘이라고 묶는건 무리가 있지만, 그래프 알고리즘 문제에 많이 활용되기 때문에 알아두면 좋다
    
    <br>

    * union, find 연산
    * union 연산 : 각 노드가 속한 집합을 1개로 합치는 연산. 노드 a, b 가 a ∈ A, b ∈ B 일 떼 (a는 A의 원소, b는 B의 원소) union(a, b) 는 A ∪ B (A와 B의 합집합) 을 말한다.
    * find 연산 : 특정 노드 a에 관해 a가 속한 집합의 대표 노드를 반환하는 연산. 노드 a가 a ∈ A 일 때 (a는 A의 원소), find(a) 는 A집합의 대표 노드를 반환한다.
    
    <br>

    * 유니온 파인드의 알고리즘 구현 방법
    * 1. 1차원 배열을 이용하기

         <img width="680" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/18232f9c-fbbc-45be-a813-248b0035017e">

         처음에는 노드가 연결되어 있지 않으므로 각 노드가 대표 노드가 된다. 각 노드가 모두 대표 노드이므로 배열은 자신의 인덱스값으로 **초기화**한다.

      2. 2개의 노드를 선택해 각각의 대표 노드를 찾아 연결하는 union 연산 수행

         <img width="680" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/30929c1c-2e4b-4571-8a1b-94f582cb7936">

         1, 4와 5, 6을 union 연산으로 연결한다. 배열[4]는 1로, 배열[6]은 5로 업데이트한다. <br>
         1은 대표노드, 4는 자식 노드로 union 연산을 하므로, 배열[4]의 대표 노드를 1로 설정한 것이다. <br>
         ➡️ **다시 말해, 자식 노드로 들어가는 노드값 4를 대표 노드값 1로 변경한 것이다. 그 결과, 각각의 집합이었던 1, 4는 하나로 합쳐진다.** <br>
         ⭐️ union 연산을 할 때 항상 대표 노드끼리 연결해준다! 처음에는 노드간 연결이 하나도 되어있지 않을 때는 노드 모두가 대표 노드라 그냥 연결되지만, 연결 된 후에는 대표 노드끼리 연결해주게 된다. <br>
         그래서 union(4, 6) 으로 4와 6을 연결하려고 하면, 4와 6은 대표 노드가 아니기 때문에 4의 대표 노드 1에 6의 대표 노드 5을 연결한게 된다. 배열은 그럼 그림처럼 [1, 2, 3, 1, 1, 5] 가 된다.

      3. 자신이 속한 집합의 대표 노드를 찾는 연산인 find 연산을 수행 (대표 노드를 찾고, 그래프를 정돈하고, 시간복잡도를 향상시킴)

         <img width="680" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/62c3b6ea-e61b-4c57-a656-6ba6e633201d">
         
         ⭐️ find 연산 수행 과정
         * 1. 대상 노드 배열에 index값과 value값이 동일한지 확인한다.
           2. 동일하지 않으면 value값이 가리키는 index위치로 이동한다.
           3. 이동 위치의 index값과 value값이 같을 때까지 1~2 과정을 반복한다. (재귀 함수로 구현)
           4. 대표 노드에 도달하면 재귀 함수를 빠져나오면서 거치는 모든 노드값을 루트 노드값으로 변경한다.

         * find 연산 시 왜 시간복잡도가 줄어들까? : find 연산 과정을 위 그림에서 보면, 연산을 할 때 거치는 노드들이 대표 노드와 바료 연결되는 형태로 변경된다.
           이러면 추후 노드와 관련된 find 연산 속도가 O(1)로 변경된다. 한 번의 find 연산으로 **경로 압축**의 효과가 이루어지때문에 시간 복잡도가 줄어든다.

           <img width="634" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/120394e2-fe3e-4f92-9c26-877f4dd5efa7">

           이렇게 그림에서처럼 재귀 함수를 빠져나오면서 find 연산으로 값이 다 업데이트되니까 시간 복잡도 향상 효과가 있다.

  <br>
  
  * #### `위상 정렬 (topology sort)`
    * 위상 정렬이란, 사이클이 없는 방향 그래프에서 노드 순서를 찾는 알고리즘이다. (시간복잡도 : O(V + E))
    * 위상 정렬의 특징은 사이클이 없어야 한다는 것이다. 또한, 위상정렬에서는 항상 유일한 값으로 정렬되지 않으므로 정답이 여러 개일 수 있다.
    * 사이클이 존재하면 노드 간의 순서를 명확하게 정의할 수 없으므로 위상 정렬을 적용할 수 없다.

    <br>

    * 위상 정렬의 핵심 이론
    * 1. 진입 차수에 대한 이해 : 진입 차수(in-degree)는 자기 자신을 가리키는 에지의 개수이다.

         <img width="572" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/a10a6651-f564-4e96-b260-7ff2532d9d34">

         <img width="572" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/da927a23-15cb-4d82-9c8c-66bbf31e38df">

         그림에서 그래프는 ArrayList 로 표현했고, 그래프는 사이클이 없는 상태이다. <br>
         진입 차수 배열 D를 업데이트한다. 1에서 2, 3을 가리키고 있으므로, D[2], D[3] 을 각각 1만큼 증가시신다.

       2. 위상 정렬 배열에 진입 차수가 0인 노드의 값을 저장 
     
          <img width="572" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/ba8ac2fa-2e03-4f05-88ae-054afacfb578">

          <img width="572" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/88b1c569-a9e6-42ba-ae96-24ce77ff13e1">

          진입 차수 배열에서 진입 차수가 0인 노드를 선택하고, 선택된 노드를 정렬 배열에 저장, 그 후 인접 리스트에서 선택된 노드가 가리키는 노드들의 진입 차수를 1씩 뺀다.

       3. 2번 과정 반복 후 위상 정렬 배열 종료
     
          <img width="572" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/130a0f6f-039c-43cc-9912-5312497ef002">


    <br>

    * 위상 정렬의 수행 과정
      * 1. 진입 차수가 0인 노드를 큐에 저장한다.
        2. 큐에서 데이터를 poll해서 해당 노드를 탐색 결과에 추가하고, 해당 노드가 가리키는 노드의 진입 차수를 1씩 감소한다.
        3. 감소했을 때 진입 차수가 0이 되는 노드를 큐에 offer 한다.
        4. 큐가 빌 때까지 1~3번 과정을 반복한다.
  
  <br>
  
  * #### `다익스트라 알고리즘 (dijkstra algorithm)`
    * 다익스트라 알고리즘은 그래프에서 최단 거리를 구하는 알고리즘이다.
    * 에지는 모두 양수 라는 특징을 가지고 있으며, 다익스트라 알고리즘의 시간복잡도는 O(ElogV) 이다.
    * 특정 노드에서 다른 노드들의 최단 거리를 구하는 문제가 주어졌을 때, 다익스트라 알고리즘을 사용해서 문제를 풀면 된다.
    
    <br>
    
    * 다익스트라 알고리즘의 핵심 이론
      * 1. 인접 리스트로 그래프 구현하기
           
           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/7b4790f3-3325-4355-9ee1-90f5756d927f">

           다익스트라 알고리즘은 인접 행렬로 구현해도 되지만, 시간 복잡도 측면에서 N의 크기가 클 것을 대비하여 인접 리스트를 선택해서 구현하는 것이 좋다. (N이 커지면 인접 행렬(2차원배열)이 만들어지지 않기 때문에) <br>
           그래프의 연결을 표현하기 위해 인접 리스트에 연결한 배열의 자료형은 (노드, 가중치) 와 같은 형태로 선언하여 연결한 점도 참고

        2. 최단 거리 배열 초기화하기
           
           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/f0b1c2f6-3194-426e-a37a-e24ea7eb316d">

           최단 거리 배열을 만들고, 출발 노드는 0, 이외의 노드는 무한으로 초기화한다. 이때, 무한은 적당히 큰 값을 사용하면 된다. (ex. 99,999,999 같은 엄청 큰 임의의 값)

        3. 값이 가장 작은 노드 고르기
           
           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/5a5cda09-a82b-4571-ad84-9a9b3cd9e177">

           최단 거리 배열에서 현재 값이 가장 작은 노드를 고른다. 여기서는 값이 0인 출발 노드에서 시작하면 된다.

        4. 최단 거리 배열 업데이트하기

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/91d9ba9a-57d3-406c-b8c8-669eb5eb0b30">

           선택된 노드에 연결된 에지의 값을 바탕으로 다른 노드의 값을 업데이트한다. 연결 노드의 최단 거리는 두 값 중 더 작은 값으로 업데이트한다.

        5. 3~4 과정을 반복해서 최단 거리 배열 완성하기

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/21d070e3-cb74-4e61-984f-732bbfe1c2ef">

           과정 4에서 선택된 노드가 될 때마다 다시 선택되지 않도록 방문 배열을 만들어 처리하고, 모든 노드가 선택될 때까지 반복하면 최단 거리 배열이 완성된다.
  
  <br>

  * #### `벨만-포드 알고리즘 (bellman-ford algorithm)`
    * 벨만-포드 알고리즘은 그래프에서 최단 거리를 구하는 알고리즘이다. (그래프 최단 거리를 구하는 알고리즘의 종류는 다익스트라, 벨만-포드, 플로이드-워셜 알고리즘이 있다.)
    * 벨만-포드 알고리즘의 기능은 다익스트라 알고리즘과 동일하게 특정 출발 노드에서 다른 모든 노드까지의 최단 경로를 탐색한다는 것이다.
    * 그러나 다익스트라 알고리즘과는 다르게 음수 가중치 에지가 있어도 수행할 수 있으며, **전체 그래프에서 음수 사이클의 존재 여부를 판단**할 수 있다는 점이다.
    * 벨만-포드 알고리즘의 시간복잡도는 O(VE) 이다.

    <br>

    * 벨만-포드 알고리즘의 핵심 이론
      * 1. 에지 리스트로 그래프를 구현하고, 최단 경로 리스트 초기화하기

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/c8217913-6af2-4f9f-94a7-b0ff7c9d1e58">

           벨만-포드 알고리즘은 에지 중심으로 동작하므로 그래프를 **에지 리스트** 로 구현한다. 또한, 최단 경로 리스트를 출발 노드는 0, 나머지 노드는 무한대로 초기화한다.

        2. 모든 에지를 확인해서 정답 리스트 업데이트하기

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/4d0f764c-b685-4e59-8aa6-5b0095336607">

           에지의 개수는 사이클이 생기지 않도록 노드 개수 - 1 을 해줘야 한다. <br>
           D[s] != ∞ 이며 D[e] > D[s] + w 일 때, D[e] = D[s] + w 로 리스트의 값을 업데이트한다. <br>
           노드 개수가 N이고, 음수 사이클이 없을 때 업데이트 반복 횟수가 K번이라면 해당 시점에 정답 리스트의 값은 시작점에서 K개의 에지를 사용했을 때 각 노드에 대한 최단거리이다. <br>
           음수 사이클이 없을 때, N-1번 에지 사용 횟수를 반복하면 출발 노드와 모든 노드 간의 최단 거리를 알려 주는 정답 리스트가 완성된다.

        3. ⭐️ 음수 사이클 유무 확인하기

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/e6191559-7913-4b37-9b33-a76fc364fc7e">

           N-1 에지 사용 횟수를 반복하고나서, 다시 벨만-포드 알고리즘을 실행해서 만약 업데이트 되는 노드가 발생했을 경우, N-1 에지 사용 횟수보다 N에지 사용 횟수가 더 최단 거리라는 얘기가 된다. (사이클이 일어난다는 소리) <br>
           이런 경우, 도출한 정답 리스트가 무의미하고, 최단 거리를 찾을 수 없는 사이클이 있는 그래프라는 소리니까 음수 사이클이 있다는 소리다. <br>
           그래서 3번까지 과정을 거치면 음수 사이클이 존재하는 그래프인지 확인할 수 있다.

  <br>

  * #### `플로이드-워셜 알고리즘 (floyd-warshall algorithm)`
    * 플로이드-워셜 알고리즘은 다익스트라, 벨만-포드 알고리즘과 유사하게 그래프에서 최단 거리를 구하는 알고리즘이다.
    * 두 알고리즘과의 차이점은 시작점을 고려하지 않고 모든 노드 간에 최단 거리를 탐색하는 것이다.
    * 음주 가중치 에지가 있어도 수행할 수 있으며(음수 사이클이 있으면 X), 동적 계획법의 원리를 이용하여 알고리즘에 접근한다.
    * 플로이드-워셜 알고리즘의 시간 복잡도는 O(V³) 이다. ➡️ N의 개수가 100, 200개 이런 식으로 작게 나오면 플로이드-워셜 알고리즘을 사용해야 되는지 의심해볼 수 있다.

    <br>

    * 플로이드-워셜 알고리즘의 핵심 이론
      * A노드에서 B노드까지 최단 경로를 구했다고 가정했을 때, 최단 경로 위에 K노드가 존재한다면 그것을 이루는 부분 경로 역시 최단 경로라는 점 <br>
        ex. 1에서 5까지 가는 최단 경로를 구했다고 가정하면, 1에서 4까지의 최단 경로와 4에서 5까지의 최단 경로 역시 1에서 5까지의 최단 경로에서 나올 수 밖에 없다
       
      * 1번에서 도출한 플로이드-워셜 알고리즘의 점화식 : **D[S][E] = Math.min(D[S][E], D[S][K] + D[K][E])**

    <br>

    * 플로이드-워셜 알고리즘의 구현 방법
      * 1. 리스트를 선언하고 초기화하기
           
           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/1c0863e9-3d04-48bc-959f-6a0bbee9e542">

           S와 E값이 같은 칸은 모드 0으로, 나머지 칸은 무한대로 초기화 한다. (S == E는 자기 자신에게 가는 데 걸리는 최단 경로값을 의미하기 때문)

        2. 최단 거리 리스트에 그래프 데이터 저장하기

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/776d091b-9a29-409f-94c5-2aceac56441f">

           D[S][E] = W 로 에지의 정보를 리스트에 입력한다. (여기서 W는 가중치를 의미함) ➡️ 인접 행렬로 표현

        3. ⭐️ 점화식으로 리스트 업데이트하기 (3중 for문 형태로 반복하면서 리스트 값을 업데이트)

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/9a939a6c-4422-417a-b96e-cedab90ba838">

           여기서 완성된 리스트는 모든 노드 간의 최단 거리를 알려준다. (ex. 1번 -> 5번 최단 거리는 D[1][6]=6)

  <br>

  * #### `최소 신장 트리 (minimum spanning tree, MST) - 크루스칼`
    * 최소 신장 트리란, 그래프에서 모든 노드를 연결할 때 사용된 에지들의 가중치의 합을 최소로 하는 트리다.
    * 최소 신장 트리의 특징은 ① 사이클이 포함되면 가중치의 합이 최소가 뒬 수 없으므로 사이클을 포함하지 않는다, ② N개의 노드가 있으면 최소 신장 트리를 구성하는 에지의 개수는 항상 N-1 개다.

    <br>
    
    * 최소 신장 트리의 핵심 이론
      * 1. 에지 리스트로 그래프를 구현하고 유니온 파인드 리스트로 초기화하기 (사이클 판별을 위함)
       
           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/eabdcb5f-28dc-4910-a861-ac1928bdb626">

           최소 신장 트리는 데이터를 노드가 아닌 에지 중심으로 저장한다. 그래서 인접 리스트가 아닌 **에지 리스트** 형태로 저장한다. <br>
           이 리스트는 일반적으로 노드 변수 2개와 가중치 변수로 구성된다. 사이클 처리를 위한 유니온 파인드 리스트도 함께 초기화한다. 리스트의 인덱스를 해당 자리의 값으로 초기화하면 된다.

        2. 그래프 데이터를 가중치 기준으로 정렬하기
       
           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/7f2096bb-89d7-4daa-b791-bdc23f35aef2">

           에지 리스트에 담긴 그래프 데이터를 가중치 기준으로 오름차순 정렬한다.

        3. 가중치가 낮은 에지부터 연결 시도하기
       
           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/af7c6b79-f62d-41df-9e57-bc907c97f55e">

           가중치가 낮은 에지부터 순서대로 선택해서 연결을 시도한다. 이때, 바로 연결하지 않고, 이 에지를 연결했을 때 그래프에 사이클 형성 유무를 find 연산을 이용해서 확인한 후 사이클이 형성되지 않을 때만 union 연산을 이용해서 두 노드를 연결한다.

        4. 과정 3번을 연결한 에지의 개수가 N-1이 될 때까지 반복

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/3096018d-7443-4a37-84db-a3203d694d07">

        5. 총 에지 비용 출력하기

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/e659a6e4-fe71-4e1f-be64-caba28fc172e">

</details>


<details>
  
  <summary> 📌 섹션 7) 트리 (Tree) </summary>

  * #### `트리 알아보기`
    * 트리는 노드와 에지로 연결된 그래프의 특수한 형태다. (그래프의 표현으로도 트리를 표현할 수 있다.)
    * 트리는 그래프이지만 순환 구조를 지니고 있지 않고, 1개의 루트 노드가 존재한다. 
    * 루트 노드를 제외한 노드는 단 1개의 부모 노드를 갖는다.
    * 트리의 부분 트리 역시 트리의 모든 특징을 따른다.
    * ➡️ 트리에서 임의의 두 노드를 이어주는 경로는 유일하다!
    
    <br>
    
    * 트리의 구성 요소

      <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/6080c8f1-6bfb-4610-b355-deaee6899b3d">

      <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/8ed1b5d2-3fcd-4245-be61-7192d000ef57">

    * 코딩테스트에서의 트리
      * 1. 그래프로 푸는 트리 문제 : 노드와 에지를 인접리스트로 표현할 수 있으니까 이걸 활용해서 DFS, BFS 알고리즘으로 표현해서 문제를 풀 수 있다. 
        2. 트리만을 위한 문제 : 트리 중에서 이진 트리, ⭐️세그먼트 트리(index tree), ⭐️최소 공통 조상(LCA) 를 활용해서 문제를 풀 수 있다. 특히 세그먼트 트리와 LCA는 1차원 배열로 트리를 표현한다.  
  
  
  <br>
  
  * #### `이진 트리 (binary tree)`
    * 이진 트리는 각 노드의 자식 노드(차수)의 개수가 2이하로 구성된 트라를 말한다. 트리 영역에서 가장 많이 사용되는 형태
    * 이진 트리의 종류로는 편향 이진 트리, 포화 이진 트리, 완전 이진 트리가 있다.

      <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/0aedbce9-e654-4a92-ab35-5ae2c45ebbff">

    * 데이터를 트리 자료 구조에 저장할 때, 편향 이진 트리의 형태로 저장하면 탐색 속도가 저하되고 공간이 많이 낭비되는 단점이 있다. 일반적으로 코딩 테스트에서 데이터를 트리에 담는다고 하면, 이진 트리 형태(완전 이진 트리)로 담게 된다.
    
    <br>

    * 이진 트리의 순차 표현 (배열 형태를 사용해서 표현)
      * 이진트리는 1차원 배열의 형태로 표현할 수 있다.

        <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/2779e9a5-c097-463d-8aad-f9535bd3f403">

        <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/e0dacbb3-59f0-4193-b1ff-12269d096d31">

  <br>
  
  * #### `세그먼트 트리`
    * 세그먼트 트리란, 주어진 데이터의 구간 합과 데이터 업데이트를 빠르게 수행하기 위해 고안해낸 자료구조의 형태다.
    * 세그먼트 트리의 큰 범위를 인덱스 트리 라고 부르는데, 코딩 테스트에서는 인덱스 트리와 세그먼트 트리 영역은 큰 차이가 없다고 봐도 된다.
    * 세그먼트 트리의 종류는 구간 합, 최대 최소 구하기로 나눌 수 있고, 구현 단계는 트리 초기화하기, 질의값 구하기 (구간 합 or 최대 최소), 데이터 업데이트하기로 나눌 수 있다.
    
    <br>     

    * ⭐️ 세그먼트 트리의 핵심 이론
      * 1. 트리 초기화하기 <br>
           리프 노드의 개수가 데이터의 개수(N) 이상이 되도록 트리 배열을 만든다. 트리 배열의 크기를 구하는 방법은 2의 k제곱 >= N 을 만족하는 k의 최솟값을 구한 후, 2의k제곱 * 2 를 트리 배열의 크기로 정의하면 된다.
     
           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/f2aa0372-1f05-4524-9929-7fa7dd987b04">

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/4799a253-c990-409b-a8eb-b34285c7aa27">

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/421f1608-d126-4937-8709-3f345cb264ab">

        2. 질의값 구하기 <br>
           주어진 질의 인덱스를 세그먼트 트리의 리프 노드에 해당하는 인덱스로 변경한다. 기존 샘플을 기준으로 한 인덱스 값과 세그먼트 트리 배열에서의 인덱스값이 다르기 때문에 인덱스를 변경해야함!

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/073205cb-70a6-4173-88a7-09ee069e414c">

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/1fb55d49-b0cf-4a45-8685-2d3bab25d86c">

           과정 1 ~ 2에서 해당 노드를 선택했다는 것은 해당 노드의 부모가 나타내는 범위가 질의 범위를 넘어가기 때문에 해당 노드를 질의값에 영향을 미치는 **독립 노드**로 선택하고, <br>
           해당 노드의 부모 노드는 대상 범위에서 **제외**한다는 뜻이다. <br>
           부모 노드를 대상 범위에서 제거하는 방법은 바로 3 ~ 4에서 질의 범위에 해당하는 부모 노드로 이동하기 위해 인덱스 연산을 index / 2 가 아닌 (index + 1) / 2, (index - 1) / 2 로 수행하는 것이다. <br>
           (질의에 해당하는 노드를 선택하는 방법은 구간 합, 최댓값 구하기, 최솟값 구하기 모두 동일하며 선택된 노드들에 관해 마지막에 연산하는 방식만 다르다.) <br>

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/a39b1990-dbc6-42a1-bc6b-e6ccab8f99b5">

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/29ecdcba-d2c1-4847-a2c1-e42fd20957c7">

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/179d55e4-366c-47a9-91fd-f8f242078783">

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/7256412f-e6b0-4f16-a886-d4b722bb2dd7"> <br>

        3. 데이터 업데이트하기 <br>
           업데이트 방식은 자신의 부모 노드로 이동하면서 업데이트한다는 것은 동일하지만, 어떤 값으로 업데이트할 것인지에 관해서는 트리 타입별로 다르다. <br>
           (부모 노드로 이동하는 방식은 세그먼트 트리가 이진 트리이므로 index = index / 2 로 변경하면 된다.)

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/387e09a2-a8a8-4309-b80f-0570b6984b02"> 

        <br>

      * 문제를 분석할 때, 계속 구간합을 구하라고 하는 문제는 구간합(합배열) 을 이용하는 경우 시간이 오래 걸리기 때문에 세그먼트 트리 알고리즘을 활용하는게 좋다. (단순 구간합이 아닌 구간합이 반복되는 경우)

  <br>
  
  * #### `최소 공통 조상 (LCA)`
    * 트리 그래프에서 임의의 두 노드를 선택했을 때, 두 노드가 각각 자신을 포함해 거슬러 올라가면서 부모 노드를 탐색할 때 **처음 공통으로 만나게 되는 부모 노드를 최소 공통 조상 (LCA)** 라고 한다.
    * LCA를 구하는 방법은 일반적인 방법, 빠르게 구하는 방법 이렇게 2가지 이다.
    * 두 방법의 사용 여부를 나누는 관점은 트리의 높이인데, 트리의 높이가 크지 않을 때나 시간 제한이 타이트하지 않을 때는 일반적인 방법을 쓰고, 트리의 높이가 크다면 빠른 방법을 쓴다. (트리의 높이는 시간복잡도에 영향을 준다)

    <br>
    
    * 일반적인 최소 공통 조상 구하기
      * 1. 루트 노드에서 탐색을 시작해서 각 노드의 부모 노드 깊이를 저장한다

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/e0b99717-a36c-4fa4-ba11-69a21af82452">

           4번 15번 노드의 최소 공통 조상을 구하려고 할 때, 먼저 루트 노드에서 탐색을 시작해서 각 노드의 부모 노드 깊이를 저장한다. <br>
           여기서 탐색할 때는 DFS나 BFS 를 이용해서 수행하면 된다. <br>
        2. 선택된 두 노드의 깊이가 다른 경우, 더 깊은 노드의 부모 노드로 1개씩 올려주면서 갚은 깊이로 맞춰준다. 이때, 두 노드가 같으면 해당 노드가 최소 공통 조상이므로 탐색을 종료한다.

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/b1aeb88f-0252-42f4-8554-bceb629ee799">

    * 최소 공통 조상 빠르게 구하기
      * 빠르게 구하는 방법의 핵심은 서로의 깊이를 맞춰주거나 같아지는 노드를 찾을 때 기존의 한 단계씩 올려주는 일반적인 방법에서 2의 k제곱씩 올라가서 비교하는 방식이다.
      * 기존에 자신의 부모 노드만 저장해 놓던 방식에서 2의 k제곱번째 위치의 부모 노드까지 저장해줘야된다. (그래서 단계가 하나 더 늘어나서 3단계가 됨)
      * 1. 부모 노드 저장 배열 만들기

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/4a70ff50-ab34-4845-9214-49f8276b3713">

           여기서 k는 트리의 깊이 > 2의 k제곱 을 만족하는 최대값이다. 만약 트리의 최대 깊이가 5일 경우, k의 최대값은 2가 된다 (트리의 높이보다 클 수 없다) <br> <br>

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/cffc86ab-ffce-4587-90e2-8c5c4e4042a8">

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/7a9de9fd-870d-4639-95a4-b165a3cb69ae">

        2. 선택된 두 노드의 깊이 맞추기
        3. 최소 공통 조상 찾기
       
           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/15ea08fc-d6cf-4c90-bd69-881c05fad413">

           P배열을 이용해서 최초로 두 노드의 부모가 달라지는 값을 찾는다. 여기서 K가 0이 될 때까지 반복해서 최소 공통 조상을 찾는다.

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/af90490e-004c-4556-a8c9-3b881cbd9d83">


</details>


<details>
  <summary> 📌 섹션 8) 조합 (Combination) </summary>
  
  * #### `조합 핵심 이론`
    * 조합 (Combination) 은 <sub>n</sub>C<sub>r</sub> 로 표현되고, n가의 숫자 r개를 뽑는 경우의 수를 뜻한다.
    * 조합과 비교되는 순열은 <sub>n</sub>P<sub>r</sub> 로 표현되고, n개의 숫자 중 r개를 뽑아 순서를 고려해서 나열할 경우의 수를 뜻한다.
    * 순열과 조합의 차이는 순서의 고려 유무인데, 즉, 조합에서는 데이터 1, 2, 3과 3, 2, 1을 같은 경우라고 판단하고, 순열은 다른 경우로 판단한다.
    * 실제 코딩테스트에서는 순서를 고려하는 순열 보다는 조합의 출제 빈도 수가 높고, 응용할 수 있는 문제도 많다.
    * <img width="265" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/b79cdfe0-7f58-4471-9e10-e318e3e2ea5d">

    * 분모에 r!은 순서가 다른 경우의 수를 제거하는 역할을 한다. (그래서 순열 공식에는 분모에 r! 없이 (n-r)! 만 해준다)
   
    <br>

    * ⭐️ 조합의 점화식 도출하기
      * 1. 특정 문제를 가정하기

           <img width="316" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/143a9e3e-eb82-405a-b037-712e8f7bcb1f">

           (여기서는 5개의 데이터에서 3개를 선택하는 조합의 경우의 수를 푸는 문제로 가정한다.)

        2. 모든 부분 문제가 해결된 상황이라고 가정하고 지금 문제 생각하기

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/1ff20990-b64c-4580-9bf2-ffcae667a6ab">

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/728ab64e-b818-42e7-a7e1-b99200dc8faf">

        3. 특정 문제를 해결한 내용을 바탕으로 일반 점화식 도출하기 <br>
           ⭐️ **D[i][j] = D[i-1][j-1] + D[i-1][j]** ⭐️
           
</details>

<details>

  <summary> 📌 섹션 9) 동적 계획법 (Dynamic Programming, DP) </summary>

  * #### `동적 계획법 핵심 이론`
    * 동적 계획법은 복잡한 문제를 여러 개의 간단한 문제로 분리하여 부분의 문제들을 해결함으로써 최종적으로 복잡한 문제의 답을 구하는 방법을 뜻한다.
    
    <br>
    
    * 동적 계획법의 원리와 구현 방식
      * 1. 큰 문제를 작은 문제로 나눌 수 있어야 한다.
        2. 작은 문제들이 반복되어 나타나고 사용되며, 이 작은 문제들의 결괏값은 항상 같아야 한다.
        3. 모든 작은 문제들은 한 번만 계산해 DP 테이블에 저장하며, 추후 재사용할 때는 이 DP 테이블을 이용한다. 이를 메모이제이션 기법 이라고 한다.
        4. 동적 계획법은 탑-다운 방식과 바텀-업 방식으로 구현할 수 있다.
    
    <br>

    * 동적 계획법의 대표적인 문제 - **피보나치 수열**
      * 피보나치 수열 공식 : D[N] = D[N-1] + D[N-2] (N번째 수열 = N-1번째 수열 + N-2번째 수열)
      * 1. 동적 계획법으로 풀 수 있는지 확인하기 <br>
           예를 들어, 6번째 피보나치 수열은 5번째 피보나치 수열과 4번째 피보나치 수열의 합이다. <br>
           즉, 6번째 피보나치 수열을 구하는 문제는 5번째 피보나치 수열과 4번째 피보나치 수열을 구하는 작은 문제로 나눌 수 있고, 수열의 값은 항상 같기 때문에 동적 계획법으로 풀 수 있다.
        2. 점화식 세우기 <br>
           점화식을 세울 때는 논리적으로 전체 문제를 나누고, 전체 문제와 부분 문제 간의 인과 관계를 파악하는 훈련이 필요하다.
        3. 메모이제이션 원리 이해하기 <br>
           메모이제이션은 부분 문제를 풀었을 때, 이 문제를 DP 테이블에 저장해 놓고 다음에 같은 문제가 나왔을 때 재계산하지 않고 DP 테이블의 값을 이용하는 것을 말한다. <br>

           <img width="631" alt="image" src="https://github.com/chujaeyeong/Algorithm/assets/123634960/72735453-ab06-4e8c-9978-d61440f5c6ea">

        4. 탑-다운 형식 or 바텀-업 방식으로 문제 풀이 <br>
           두 방식 중 더 안전한 방식은 바텀-업 방식이다. (탑-다운 방식은 재귀 함수 형태로 구현되어있기 때문에, 재귀의 깊이가 매우 깊은 경우 런타임 에러가 발생할 수 있기 때문, 정말 가끔 있는 경우)


</details>




