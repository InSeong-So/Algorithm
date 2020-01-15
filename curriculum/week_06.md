<div align=center>

# 6주차-기초 알고리즘 문제 풀이 1

</div>

<br>

## [Git](https://rogerdudler.github.io/git-guide/index.ko.html)
### Git
- [설치](https://git-scm.com/downloads)
  - [설치 방법](https://coding-factory.tistory.com/245)

- 리누스 토르발스가 개발한 분산형 버전 관리 시스템(VCS)

- 매우 빠른 속도와 분산형 저장소 지원

- Git의 작업 폴더는 전체 기록과 각 기록을 추적할 수 있는 정보를 포함하고 있음

- 작업이 끝나면 Git 원격 저장소로 다시 발행(commit, push)
  - 메인 저장소와 합치기(merge) 전 메인 저장소와 격리시키고 따로 개발 할 수 있는 가지(branch)를 만들 수 있다.
  - 가지의 개발이 완료되면 메인 저장소와 합치고 가지는 삭제시키는 가지치기를 할 수 있다. 

<br>

### Git 명령어([참조](https://medium.com/@joongwon/git-git-%EB%AA%85%EB%A0%B9%EC%96%B4-%EC%A0%95%EB%A6%AC-c25b421ecdbd))
#### 신입이 자주 사용하는 명령어
```sh
# 사용자 설정
git config --global user.name “Your name”
git config --global user.email “Your email address”
# git 디렉토리 설정
mkdir "/경로/"newDir
cd "/경로/"newDir
git init # 또는 바로 클론
# 원격 저장소에서 저장소 복제
git clone <저장소 url>
# 변경한 파일 commit stage에 추가
git add <파일>
# 변경 내용 커밋
git commit -m “<메시지>”
# 변경 내용 푸쉬
git push
```

<br>

#### 설정과 초기화
- 전역 사용자명/이메일 구성하기
    ```sh
    git config --global user.name “Your name”
    git config --global user.email “Your email address”
    ```

- 저장소별 사용자명/이메일 구성하기 (해당 저장소 디렉터리로 이동후)
    ```sh
    git config user.name “Your name”
    git config user.email “Your email address”
    # user 설정이 되어 있지 않으면 github의 commit 집계가 되지 않음
    ```

- 전역 설정 정보 조회
    ```sh
    git config --global --list
    ```

- 저장소별 설정 정보 조회
    ```sh
    git config --list
    ```

- Git의 출력결과 색상 활성화하기
    ```sh
    git config --global color.ui “auto”
    ```

- 새로운 저장소 초기화하기
    ```sh
    mkdir "/경로/"newDir
    cd "/경로/"newDir
    git init
    ```

- 저장소 복제하기
    ```sh
    git clone <저장소 url>
    ```

- 새로운 원격 저장소 추가하기
    ```sh
    git remote add <원격 저장소> <저장소 url>
    ```

<br>

#### 기본 명령어
- 새로운 파일을 추가하거나 존재하는 파일 스테이징하고 커밋하기
    ```sh
    git add <파일>
    git commit -m “<메시지>”
    ```

- 파일의 일부를 스테이징하기
    ```sh
    git add -p [<파일> [<파일> [기타 파일들…]]]
    add 명령에서 Git 대화 모드를 사용하여 파일 추가하기
    git add -i
    ```

- 수정되고 추적되는 파일의 변경 사항 스테이징하기
    ```sh
    git add -u [<경로> [<경로>]]
    ```

- 수정되고 추적되는 모든 파일의 변경 사항 커밋하기
    ```sh
    git commit -m “<메시지>” -a
    ```

- 작업 트리의 변경 사항 돌려놓기
    ```sh
    git checkout HEAD <파일> [<파일>]
    ```

- 커밋되지 않고 스테이징된 변경 사항 재설정하기
    ```sh
    git reset HEAD <파일> [<파일>]
    ```

- 마지막 커밋 고치기
    ```sh
    git commit -m “<메시지>” - -amend
    ```

- 이전 커밋을 수정하고 커밋 메시지를 재사용하기
    ```sh
    git commit -C HEAD - -amend
    ```

#### 가지(branch)
- 지역 브랜치 목록 보기
    ```sh
    git branch
    ```

- 원격 브랜치 목록 보기
    ```sh
    git branch -r
    ```

- 지역과 원격을 포함한 모든 브랜치 목록 보기
    ```sh
    git branch -a
    ```

- 현재 브랜치에서 새로운 브랜치 생성하기
    ```sh
    git branch <새로운 브랜치>
    ```

- 다른 브랜치 체크아웃하기
    ```sh
    git checkout <브랜치>
    ```

- 현재 브랜치에서 새로운 브랜치 생성하고 체크아웃하기
    ```sh
    git checkout -b <새로운 브랜치>
    ```

- 다른 시작 지점에서 브랜치 생성하기
    ```sh
    git branch <새로운 브랜치> <브랜치를 생성할 위치>
    ```

- 기존의 브랜치를 새로운 브랜치로 덮어쓰기
    ```sh
    git branch -f <기존 브랜치> [<브랜치를 생성할 위치>]
    ```

- 브랜치를 옮기거나 브랜치명 변경하기
    ```sh
    # <새로운 브랜치>가 존재하지 않을 경우
    git checkout -m <기존 브랜치> <새로운 브랜치>
    # 무조건 덮어쓰기
    git checkout -M <기존 브랜치> <새로운 브랜치>
    ```

- 다른 브랜치를 현재 브랜치로 합치기
    ```sh
    git merge <브랜치>
    ```

- 커밋하지 않고 합치기
    ```sh
    git merge - -no-commit <브랜치>
    ```

- 선택하여 합치기
    ```sh
    git cherry-pick <커밋명>
    ```

- 커밋하지 않고 선택하여 합치기
    ```sh
    git cherry-pick -n <커밋명>
    ```

- 브랜치의 이력을 다른 브랜치에 합치기
    ```sh
    git merge - -squash <브랜치>
    ```

- 브랜치 삭제하기
    ```sh
    # 삭제할 브랜치가 현재 브랜치에 합쳐졌을 경우에만
    git branch -d <삭제할 브랜치>
    # 삭제할 브랜치가 현재 브랜치에 합쳐지지 않았어도
    git branch -D <삭제할 브랜치>
    ```

<br>

#### Git 이력
- 모든 이력 보기
    ```sh
    git log
    ```

- 변경 사항을 보여주는 패치와 함께 로그 표시하기
    ```sh
    git log -p
    ```

- 1개의 항목만 보이도록 로그 개수 제한하기
    ```sh
    git log -1
    ```

- 20개의 항목과 패치만 보이도록 로그 제한하기
    ```sh
    git log -20 -p
    ```

- 6개월 동안의 커밋 로그 보기
    ```sh
    git log - -since=”6 hours”
    ```

- 이틀 전까지의 커밋 로그 보기
    ```sh
    git log - -before=”2 days”
    ```

- HEAD보다 세 개 이전의 커밋 로그 보기
    ```sh
    git log -1 HEAD-3
    git log -1 HEAD^^^
    git log -1 HEAD~1^^
    ```

- 두 지점 사이의 커밋 로그 보기
    ```sh
    git log <시작 지점>…<끝 지점>
    # 시작 지점이나 끝 지점은 커밋명, 브랜치명, 혹은 태그명이 될 수 있고 조합하여 사용 가능
    ```

- 각 항목의 로그 이력 한 줄씩 보기
    ```sh
    git log - -pretty=oneline
    ```

- 각 항목마다 영향 받은 줄의 통계 보기
    ```sh
    git log - -stat
    ```

- 커밋할 시점의 파일 상태 보기
    ```sh
    git log - -name-status
    ```

- 현재 작업 트리와 인덱스의 차이점 보기
    ```sh
    git diff
    ```

- 인덱스와 저장소의 차이점 보기
    ```sh
    git diff - -cached
    ```

- 작업 트리와 저장소의 차이점 보기
    ```sh
    git diff HEAD
    ```

- 작업 트리와 특정 위치 간의 차이점 보기
    ```sh
    git diff <시작 지점>
    # 시작 지점은 커밋명 or 브랜치명 or 태그명
    ```

- 저장소의 두 지점 사이의 차이점 보기
    ```sh
    git diff <시작 지점> <끝 지점>
    ```

- 차이점의 통계 보기
    ```sh
    git diff - -stat <시작 지점> [<끝 지점>]
    ```

- 파일의 커밋 정보 줄 단위로 보기
    ```sh
    git blame <파일>
    ```

- 파일의 줄 단위의 복사, 붙여 넣기, 이동 정보 보기
    ```sh
    git blame -M <파일>
    ```

- 파일의 줄 단위의 이동과 원본 파일 정보 보기
    ```sh
    git blame -C -C <파일>
    ```

- 로그에서 복사와 붙여 넣은 정보 보기
    ```sh
    git log -C -C -p -1 <특정 지점>
    ```

<br>

#### 원격 저장소
- 저장소 복제하기
    ```sh
    git clone <저장소>
    ```

- 마지막 200개의 커밋만 포함하여 저장소 복제하기
    ```sh
    git clone - -depth 200 <저장소>
    ```

- 새로운 원격 저장소 추가하기
    ```sh
    git remote add <원격 저장소> <저장소 url>
    ```

- 모든 원격 브랜치 목록 보기
    ```sh
    git branch -r
    ```

- 원격 브랜치에서 지역 브랜치 생성하기
    ```sh
    git branch <새로운 브랜치> <원격 브랜치>
    ```

- 원격 태그에서 지역 브랜치 생성하기
    ```sh
    git branch <새로운 브랜치> <원격 태그>
    ```

- origin 저장소에서 합치지 않고 지역 브랜치로 변경 사항 가져오기
    ```sh
    git fetch
    ```

- 원격 저장소에서 합치지 않고 지역 브랜치로 변경 사항 가져오기
    ```sh
    git fetch <원격 저장소>
    ```

- 원격 저장소에서 변경 사항을 가져와 현재 브랜치에 합치기
    ```sh
    git pull <원격 저장소>
    ```

- origin 저장소에서 변경 사항을 가져와 현재 브랜치에 합치기
    ```sh
    git pull
    ```

- 지역 브랜치를 원격 브랜치에 푸싱하기
    ```sh
    git push <원격 저장소> <지역 브랜치>:<원격 브랜치>
    ```

- 지역 브랜치를 동일한 이름의 원격 브랜치에 푸싱하기
    ```sh
    git push <원격 저장소> <지역 브랜치>
    ```

- 새로운 로컬 브랜치를 원격 저장소에 푸싱하기
    ```sh
    git push <원격 저장소> <지역 브랜치>
    ```

- 원격 저장소에서 쓸모가 없어진 원격 브랜치 제거하기
    ```sh
    git remote prune <원격 저장소>
    ```

- 원격 저장소를 제거하고 관련된 브랜치도 제거하기
    ```sh
    git remote rm <원격 저장소>
    ```

<br>

### Git 과 Github
- Git은 `Coffee`, Github은 `CoffeeShop`이다.

<br>

### [Github](https://github.com/)과 비슷한 사이트
- [Bitbucket](https://bitbucket.org/product/) : 무료
- [GitLab](https://about.gitlab.com/) : 유료
- [Azure DevOps](https://azure.microsoft.com/ko-kr/services/devops/) : 유료

<br>

## 병합정렬의 구현(추가)
- java
    ```java
    public class MergeSort1 {

        public static void main(String[] args) {
            int[] test = {59, 2, 41, 9, 10, 1, 8, 3};
            List<Integer> test2 = new ArrayList<Integer>();
            for (Integer i : test) {
                test2.add(i);
            }

            System.out.println(Arrays.toString(mergeSort(test)));
            // System.out.println(mergeSort(test2).toString());
        }

        // 병합 정렬 알고리즘 - 배열
        public static int[] mergeSort(int[] numbers) {
            // 정렬하려는 배열의 원소가 하나라면 배열 그대로 리턴 : 재귀호출의 종료 조건
            if (numbers.length < 2) {
                return numbers;
            }

            // 분할한 원소들을 담을 배열, 0부터 절반까지(원소의 갯수가 홀수의 경우 소수점 절삭)
            int[] leftArray = Arrays.copyOfRange(numbers, 0, numbers.length / 2);
            /* 확인용
            */
            System.out.println(Arrays.toString(leftArray));

            // 분할한 원소들을 담을 배열, 절반부터 끝까지
            int[] rightArray = Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length);
            /* 확인용
            */
            System.out.println(Arrays.toString(rightArray));
            // 분할한 배열을 각각 정렬하여 병합하기
            return merge(mergeSort(leftArray), mergeSort(rightArray));
        }

        // 병합
        private static int[] merge(int[] left, int[] right) {
            // 왼쪽 배열의 순서를 저장하는 포인터
            int leftPtr = 0;
            // 오른쪽 배열의 순서를 저장하는 포인터
            int rightPtr = 0;
            // 병합할 배열에 값을 저장할 위치를 나타내는 변수
            int index = 0;

            // 왼쪽 배열과 오른쪽 배열을 병합할 배열 생성
            int[] merged = new int[left.length + right.length];

            // 왼쪽 배열의 포인터가 왼쪽 배열의 크기보다 커지거나
            // 오른쪽 배열의 포인터가 오른쪽 배열의 크기보다 커지면 반복문 종료
            while (leftPtr < left.length && rightPtr < right.length) {
                // System.out.println("1번째 while문의 leftPtr : " + leftPtr);
                // System.out.println("1번째 while문의 rightPtr : " + rightPtr);
                // 왼쪽 배열의 leftPtr번째 원소 값이 오른쪽 배열의 rightPtr 원소 값보다 작다면
                if (left[leftPtr] < right[rightPtr]) {
                    // 새로 만든 배열의 index번째에 값을 추가하고
                    merged[index] = left[leftPtr];
                    // leftPtr 증가
                    leftPtr++;
                    // index 증가
                    index++;

                // 왼쪽 배열의 leftPtr번째 원소 값이 오른쪽 배열의 rightPtr 원소 값보다 크거나 같다면
                } else {
                    // 새로 만든 배열의 index번째에 값을 추가하고
                    merged[index] = right[rightPtr];
                    // rightPtr 증가
                    rightPtr++;
                    // index 증가
                    index++;
                }
            }

            // System.out.println(left.length);
            // System.out.println(right.length);
            // System.out.println(leftPtr);
            // System.out.println(rightPtr);

            // 위 조건에서 검사하지 못한 요소를 재차 검사(왼쪽)
            // 왼쪽 배열의 마지막 위치에 값을 삽입하는지를 체크하는 것
            // 값이 true 라면 마지막 인덱스에 값을 삽입함
            while (leftPtr < left.length) {
                merged[index] = left[leftPtr];
                leftPtr++;
                index++;
            }

            // 위 조건에서 검사하지 못한 요소를 재차 검사(오른쪽)
            // 오른쪽 배열의 마지막 위치에 값을 삽입하는지를 체크하는 것
            // 값이 true 라면 마지막 인덱스에 값을 삽입함
            while (rightPtr < right.length) {
                merged[index] = right[rightPtr];
                rightPtr++;
                index++;
            }

            return merged;
        }

        /***************************************************************************/

        // 병합 정렬 알고리즘열 - 리스트
        public static List<Integer> mergeSort(List<Integer> values) {
            if (values.size() < 2) {
                return values;
            }

            List<Integer> leftHalf = values.subList(0, values.size() / 2);
            List<Integer> rightHalf = values.subList(values.size() / 2, values.size());
            return merge(mergeSort(leftHalf), mergeSort(rightHalf));
        }

        // 병합
        private static List<Integer> merge(List<Integer> left, List<Integer> right) {
            int leftPtr = 0;
            int rightPtr = 0;

            List<Integer> merged = new ArrayList<>(left.size() + right.size());

            while (leftPtr < left.size() && rightPtr < right.size()) {
                if (left.get(leftPtr) < right.get(rightPtr)) {
                    merged.add(left.get(leftPtr));
                    leftPtr++;
                } else {
                    merged.add(right.get(rightPtr));
                    rightPtr++;
                }
            }

            while (leftPtr < left.size()) {
                merged.add(left.get(leftPtr));
                leftPtr++;
            }

            while (rightPtr < right.size()) {
                merged.add(right.get(rightPtr));
                rightPtr++;
            }

            return merged;
        }

    }
    ```

<br>

## 문제
### [1번 - 프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/42746)
- 문제 설명
  - 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
    ```
    예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
    ```
  - 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

- 제한 사항
  - numbers의 길이는 1 이상 100,000 이하입니다.
  - numbers의 원소는 0 이상 1,000 이하입니다.
  - 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

- 풀이
    ```java
    // 주어지는 값
    int[] n = {3, 30, 34, 5, 9};

    String solution7(int[] n){
        String answer = "";

        // 코드 작성

        return answer;
    }
    ```
    ```cs
    // 주어지는 값
    int[] n = {3, 30, 34, 5, 9};

    String solution7(int[] n){
        String answer = "";

        // 코드 작성

        return answer;
    }
    ```

<br>

### [2번 - 백준알고리즘](https://www.acmicpc.net/problem/1181)
- 문제
  - 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
    - 길이가 짧은 것부터
    - 길이가 같으면 사전 순으로

- 입력
  - 첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

- 출력
  - 조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.

- 풀이
    ```java
    void solution5(){
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine().trim());

    }
    ```
    ```cs
    void solution5(){

    }
    ```

<br>

### [3번 - 백준 알고리즘](https://www.acmicpc.net/problem/2805)
- 문제
  - 상근이는 나무 M미터가 필요하다. 근처에 나무를 구입할 곳이 모두 망해버렸기 때문에, 정부에 벌목 허가를 요청했다. 정부는 상근이네 집 근처의 나무 한 줄에 대한 벌목 허가를 내주었고, 상근이는 새로 구입한 목재절단기을 이용해서 나무를 구할것이다.

  - 목재절단기는 다음과 같이 동작한다. 먼저, 상근이는 절단기에 높이 H를 지정해야 한다. 높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라간다. 그 다음, 한 줄에 연속해있는 나무를 모두 절단해버린다. 따라서, 높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다. 예를 들어, 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자. 상근이가 높이를 15로 지정했다면, 나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이고, 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것이다. (총 7미터를 집에 들고 간다)

  - 상근이는 환경에 매우 관심이 많기 때문에, 나무를 필요한 만큼만 집으로 가져가려고 한다. 이때, 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.

- 입력
  - 첫째 줄에 나무의 수 N과 상근이가 집으로 가져가려고 하는 나무의 길이 M이 주어진다. (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)

  - 둘째 줄에는 나무의 높이가 주어진다. 나무의 높이의 합은 항상 M을 넘기 때문에, 상근이는 집에 필요한 나무를 항상 가져갈 수 있다. 높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0이다.

- 출력
  - 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.

- 풀이
    ```java
    void solution5(){
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine().trim());

    }
    ```
    ```cs
    void solution5(){

    }
    ```

<hr>
<br>

[뒤로가기](../curriculum.md)

<br>
