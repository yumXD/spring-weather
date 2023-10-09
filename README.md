# 🌤️ 날씨 웹 애플리케이션

## 📌 목차

- [📚 프로젝트 소개](#-프로젝트-소개)
- [🛠️ 설치 및 시작 방법](#-설치-및-시작-방법)
- [🌟 주요 기능](#-주요-기능)
- [🔧 사용된 기술 스택](#-사용된-기술-스택)
- [💬 프로젝트 후기](#-프로젝트-후기)
- [🤝 기여 및 참여](#-기여-및-참여)

## 📚 프로젝트 소개

OpenWeatherMap API를 활용하여 현재 날씨 데이터를 신속하게 가져오며,

Docker의 Redis를 활용하여 데이터를 캐시하여 더 빠른 로딩을 지원하는 날씨 웹 애플리케이션.

## 🛠️ 설치 및 시작 방법

### 1. OpenWeatherMap API의 KEY를 `openweathermap.properties`에 설정합니다.

### 2. Docker에 Redis를 실행합니다.

### 3. 저장소를 클론합니다.

```bash
git clone https://github.com/yumXD/spring-weather.git
```

### 4. 인텔리제이 혹은 다른 IDE를 실행하여 build.gradle로 엽니다.

### 4-1. 🔥 Build 실패시 아래의 방법으로 해결합니다.

```plaintext
Build, Exeution, Deployment → Build Tools → Build and run using → Intellij IDEA 변경
Build, Exeution, Deployment → Build Tools → Run tests using → Intellij IDEA 변경
Build, Exeution, Deployment → Build Tools → Gradle JVM → Java 17 이상 변경
Project Structure → SDK → Java 17 이상 변경
```

### 5. 환경설정

```plaintext
setting → Enable annotation processing
setting → Optimize imports on the fly (java)
setting → Editor → File Encoding → Transparent native-to-ascii conversion
```

### 6. 의존성 설치

```plaintext
build
```

### 7. 애플리케이션 시작!

```plaintext
Run ShopApplication
```

### 8. 웹 실행주소!

> http://localhost:8080/

## 🌟 주요 기능

- 🌦️ 날씨 정보 업데이트 기능: OpenWeatherMap API를 통해 현재 날씨 정보를 실시간으로 업데이트하고 제공

- 📦 데이터 캐싱: Redis를 사용하여 API로부터 가져온 데이터를 캐싱하여 반복적인 데이터 요청 시에 빠른 응답을 제공합니다.

- ⏳ 로딩 표시: 메인 페이지에 접속하면 데이터 로딩 중에는 로딩 표시가 표시되고, 데이터 로딩이 완료되면 자동으로 로딩 표시가 사라지며 날씨 정보가 표시됩니다.

- 🌍 지역별 날씨 정보: 다양한 지역의 실시간 날씨 정보를 제공하여 사용자는 원하는 지역의 날씨를 확인할 수 있습니다.

## 🔧 사용된 기술 스택

- **언어**: Java 17
- **버전 관리**: Git
- **IDE**: 인텔리제이 (IntelliJ IDEA)
- **프레임워크**: 스프링부트 3.1.4
- **빌드 도구**: Gradle
- **데이터베이스**: Redis (Docker를 통한 설치)
- **템플릿 엔진**: 타임리프 (Thymeleaf)
- **프론트엔드**: HTML, CSS, 부트스트랩 (Bootstrap)
- **백엔드**: Spring Restful API
- **테스트**: JUnit

## 💬 프로젝트 후기

이 프로젝트에서 Redis를 처음 사용해봤는데 Redis는 데이터 캐싱과 성능 향상에 매우 효과적이었고, 그 사용법을 익히는 것은 프로젝트의 핵심이었습니다. Docker를 활용하여 Redis를 간단하게 설정하고 운영함으로써, 프로젝트의 성능을 크게 향상시켰습니다.

외부에서 제공되는 API를 내 프로젝트에 통합하는 것은 예상보다 어려운 과정이었습니다.
다른 시스템과의 통합, 데이터 형식 변환 및 업데이트 주기와 관련된 문제에 직면했으며, 이러한 어려움을 극복하면서 많은 것을 배웠습니다. 프로젝트를 성공적으로 완료하기 위해 많은 시간과 노력이 필요했지만, 이러한 도전을 통해 기술적인 역량과 문제 해결 능력을 크게 향상시킬 수 있었습니다.

## 🤝 기여 및 참여

이 프로젝트는 🌱 오픈소스로 운영되며, 모든 기여와 피드백을 💖 환영합니다! 🚀 이슈 제출, 📥 풀 리퀘스트 및 💡 코드 리뷰를 통해 함께 더 나은 날씨 웹 애플리케이션을 만들어나갑시다.

프로젝트에 기여하고 싶다면 아래의 단계를 따라주세요:

1. 🍴 프로젝트를 포크합니다.
2. 🌿 새로운 branch를 생성합니다 (`git checkout -b feature/AmazingFeature`).
3. ✏️ 변경 사항을 커밋합니다 (`git commit -m 'Add some AmazingFeature'`).
4. 📤 branch에 변경 사항을 푸시합니다 (`git push origin feature/AmazingFeature`).
5. 🔀 Pull Request를 엽니다.
