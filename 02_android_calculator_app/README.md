# 실습 2 - 사칙연산을 수행하는 안드로이드 앱

숫자 2개를 입력하고 **+ − × ÷** 버튼을 누르면 결과와 계산 기록을 보여 주는 앱입니다.
계산은 실습 1(TDD)의 `FourBasicOpt` 를 Java 로 옮긴 클래스로 하며, 규칙도 같습니다
(0으로 나누면 예외 대신 0 반환). 외부 라이브러리 없이 Android 기본 프레임워크만 사용했습니다.

| 파일 | 설명 |
|---|---|
| `app/src/main/java/kr/ac/khu/lab05/calculator/FourBasicOpt.java` | 사칙연산 클래스 (add / subtract / multiply / divide) |
| `app/src/main/java/kr/ac/khu/lab05/calculator/MainActivity.java` | 입력값 검사, 버튼 처리, 결과·기록 출력 |
| `app/src/test/java/kr/ac/khu/lab05/calculator/FourBasicOptTest.java` | 실습 1 과 같은 단위 테스트 (JUnit) |
| `app/src/main/res/layout/activity_main.xml` | 입력칸 2개 + 연산 버튼 4개 + 결과/기록 화면 |
| `screenshots/app_running.png` | 에뮬레이터 실행 화면 (12, 5 로 사칙연산) |
| `screenshots/app_divide_by_zero.png` | 0으로 나누기 화면 |

- 언어: Java 11 / 빌드: Gradle 9.4.1, Android Gradle Plugin 9.2.1
- minSdk 24 (Android 7.0), targetSdk/compileSdk 36

## 실행 방법 (Android Studio)

1. Android Studio → **Open** → 이 폴더(`02_android_calculator_app`) 선택
2. Gradle Sync 완료 대기
3. Device Manager 에서 가상 기기 생성 후 ▶ Run 'app'

## 단위 테스트

```bash
./gradlew testDebugUnitTest
```
