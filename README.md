명령 프롬프트나 터미널에서 다음 명령을 실행.
//이 때 cd [파일 경로] 해줘야함.

1. javac SocketServer.java
이 명령은 소스 코드를 컴파일하여 실행 가능한 바이너리 클래스 파일인 "SocketServer.class"를 생성.

2. 생성된 클래스 파일을 실행, 다음 명령을 사용하여 실행할 수 있음.
java SocketServer [port]
여기서 [port]는 서버를 실행할 포트 번호. 이 값을 명령행 인수로 전달해야 함. e.g) java SocketServer 8080
프로그램이 실행되면 서버는 해당 포트에서 클라이언트의 연결을 기다리고 현재 시간을 클라이언트에게 전송. 클라이언트가 연결되면 서버 콘솔에 클라이언트의 IP 주소와 연결된 메시지가 표시됨.

3. 위 과정이 완료되면 본 안드로이드 앱으로 버튼 누름.

4. cmd와 앱 메인 액티비티에서 결과 확인 가능.
