# 자바 스트림 치트시트

## 큰 흐름

```
소스 → 중간 연산(여러 번 체이닝) → 최종 연산(딱 한 번, 여기서 실제 실행됨)
```

- 중간 연산은 호출해도 그 자리에서 실행 안 됨 (지연 연산)
- 최종 연산이 호출되는 순간, 쌓아둔 중간 연산이 한꺼번에 실행됨
- 스트림은 최종 연산 한 번 쓰면 소멸 (재사용 불가, `.stream()` 다시 호출해야 함)

---

## 1. 소스 (스트림 시작하기)

| 시작 타입 | 코드 | 결과 |
|---|---|---|
| `int[]` | `Arrays.stream(intArr)` | `IntStream` |
| `Integer[]`, `String[]` 등 객체 배열 | `Arrays.stream(arr)` | `Stream<T>` |
| `List<T>`, `Set<T>` 등 컬렉션 | `list.stream()` | `Stream<T>` |
| 연속된 정수 | `IntStream.range(0, n)` | `IntStream` (0~n-1) |
| 연속된 정수(끝 포함) | `IntStream.rangeClosed(1, n)` | `IntStream` (1~n) |

**주의**: 배열은 `.stream()`을 스스로 못 가짐 → `Arrays.stream()` 필요
컬렉션(List, Set)은 `.stream()`을 스스로 가짐 → 바로 호출

---

## 2. 중간 연산 (Stream → Stream, 체이닝 가능)

| 메서드 | 하는 일 | 예시 |
|---|---|---|
| `filter(조건)` | 조건 맞는 것만 남김 | `.filter(x -> x > 0)` |
| `map(변환함수)` | 각 원소를 변환 | `.map(x -> x * 2)` |
| `distinct()` | 중복 제거 | `.distinct()` |
| `sorted()` | 오름차순 정렬 | `.sorted()` |
| `sorted(Comparator)` | 커스텀 정렬 | `.sorted(Comparator.reverseOrder())` |
| `limit(n)` | 앞에서 n개만 | `.limit(3)` |
| `skip(n)` | 앞에서 n개 건너뜀 | `.skip(2)` |

### 타입 변환 (`IntStream` ↔ `Stream<Integer>`)

| 메서드 | 방향 | 언제 씀 |
|---|---|---|
| `.boxed()` | `IntStream` → `Stream<Integer>` | `Integer[]`, `List<Integer>` 만들거나 커스텀 정렬 필요할 때 |
| `.mapToInt(Integer::intValue)` | `Stream<Integer>` → `IntStream` | 최종적으로 `int[]` 뽑아낼 때 |

---

## 3. 최종 연산 (여기서 실제 실행됨, 딱 한 번만)

| 메서드 | 결과 | 비고 |
|---|---|---|
| `toArray()` | `int[]` | `IntStream`에서, 인자 없음 |
| `toArray(Integer[]::new)` | `Integer[]` | `Stream<Integer>`에서, 생성자 필요 |
| `toArray(int[][]::new)` | `int[][]` | `Stream<int[]>`에서 |
| `collect(Collectors.toList())` | `List<T>` | |
| `collect(Collectors.joining(", "))` | `String` | 문자열 이어붙이기 |
| `forEach(action)` | 없음(void) | 각 원소마다 실행 |
| `count()` | `long` | 개수 |
| `sum()` | `int`/`long` | `IntStream`/`LongStream` 전용 |
| `min()`, `max()` | `OptionalInt` 등 | |
| `anyMatch(조건)` | `boolean` | 하나라도 맞으면 true |
| `allMatch(조건)` | `boolean` | 전부 맞아야 true |
| `reduce(초기값, 연산)` | 누적 결과 | 총합/최댓값 등 직접 정의 |

---

## 4. 자주 쓰는 완성 패턴

```java
// int[] → 중복제거 + 오름차순 → int[]
int[] result = Arrays.stream(arr)
                      .distinct()
                      .sorted()
                      .toArray();

// int[] → 중복제거 → Integer[] (커스텀 정렬 위해 boxed 필요)
Integer[] result = Arrays.stream(arr)
                          .boxed()
                          .distinct()
                          .toArray(Integer[]::new);
Arrays.sort(result, Collections.reverseOrder());

// List<Integer> → int[]
int[] result = list.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

// List<List<Integer>> → int[][]
int[][] result = listOfLists.stream()
    .map(inner -> inner.stream().mapToInt(Integer::intValue).toArray())
    .toArray(int[][]::new);

// Map<K,V> → value 기준 정렬 후 key만 뽑기
int[] result = map.entrySet().stream()
    .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
    .mapToInt(Map.Entry::getKey)
    .toArray();

// 조건에 맞는 것만 걸러서 개수 세기
long count = list.stream()
                  .filter(x -> x > 10)
                  .count();
```

---

## 5. 헷갈리기 쉬운 것 정리

- `list.stream()` (컬렉션용) vs `Arrays.stream(arr)` (배열용) — 대상이 다름
- `Integer::new` (int → Integer 객체 생성) vs `Integer[]::new` (배열 껍데기 생성) — 완전히 다른 역할
- `Stack` 대신 `ArrayDeque` — 동기화 오버헤드 없어서 더 빠름 (책이나 강의에서 자주 언급)
- 정렬 람다 `(o1,o2) -> Double.compare(o2.getValue(), o1.getValue())` — 인자 순서를 뒤집으면(o2 먼저) 내림차순이 됨
